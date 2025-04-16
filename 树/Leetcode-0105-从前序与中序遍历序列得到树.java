class Solution {
    private Map<Integer,Integer> SearchMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        SearchMap = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            SearchMap.put(inorder[i], i);
        }
        return buildMyTree(preorder,inorder,0,n-1,0,n-1);
    }

    public TreeNode buildMyTree(int[] preorder,int[] inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right){
        if(preorder_left>preorder_right){
            return null;
        }//注意返条件
        int preorder_root = preorder_left;
        //System.out.print(preorder_root);
        int inorder_root = SearchMap.get(preorder[preorder_root]);
        TreeNode root = new TreeNode(preorder[preorder_root]);
        int left_len = inorder_root - inorder_left;
        root.left = buildMyTree(preorder, inorder, preorder_left+1, preorder_left + left_len, inorder_left,inorder_root-1);
        root.right = buildMyTree(preorder, inorder, preorder_left + left_len +1, preorder_right, inorder_root+1, inorder_right);
        return root;
    }
}
