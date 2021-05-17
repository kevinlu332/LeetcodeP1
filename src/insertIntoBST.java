public class insertIntoBST {


        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            TreeNode p = null;
            TreeNode r = root;
            while (r != null){
                p = r;
                if (r.val<val){
                    r = r.right;
                }else{
                    r = r.left;
                }
            }
            TreeNode n = new TreeNode(val);
            if (p.val<val){
                p.right = n;
            }else{
                p.left = n;
            }

            return root;

        }
    }


