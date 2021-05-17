import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal {

    public List<Integer> preorderTravelsal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> preorder = new ArrayList<>();

        if (root == null){
            return preorder;
        }

        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left !=null){
                stack.push(node.left);

            }
        }
        return preorder;
    }

}
