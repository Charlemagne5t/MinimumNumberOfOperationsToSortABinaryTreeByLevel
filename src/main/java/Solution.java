import com.sun.source.tree.Tree;

import java.util.*;

class Solution {
    public int minimumOperations(TreeNode root) {
        int res = 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> lvl = new ArrayList<>();
            List<Integer> sorted = new ArrayList<>();
            for(int i  = 0; i < size; i++) {
                TreeNode cur = q.poll();
                lvl.add(cur.val);
                sorted.add(cur.val);
                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            sorted.sort(Comparator.naturalOrder());
            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            for(int i = 0; i < size; i++) {
                map.put(i, sorted.get(i));
                map2.put(sorted.get(i), i);
            }

            for(int i = 0; i < size; i++) {
                if(lvl.get(i) != map.get(i)) {
                    int toSwapInd = map2.get(lvl.get(i));
                    lvl.set(toSwapInd, lvl.get(i));
                    res++;
                }
            }
            
        }

        return res;
    }
}