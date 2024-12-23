import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left  = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(8);
        root.right.left.left = new TreeNode(9);
        root.right.right.left = new TreeNode(10);

        int expected = 3;
        int actual = new Solution().minimumOperations(root);

        Assert.assertEquals(expected, actual);


    }
}
