package Trees;

public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        if((root.val > p.val && root.val < q.val) || (root.val > q.val && root.val < p.val)){
            return root;
        }else if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p,q);
        }else{
            return lowestCommonAncestor(root.right, p,q);
        }
    }
}
