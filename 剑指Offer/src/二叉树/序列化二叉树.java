package 二叉树;

import Util.TreeNode;

//请实现两个函数，分别用来序列化和反序列化二叉树
//
//二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
// 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
// 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
//
//二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树
public class 序列化二叉树 {
    String Serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        Serialize2(sb,root);
        return sb.toString();
    }
    public void Serialize2(StringBuilder sb,TreeNode root){
        if(root==null){
            sb.append("#!");
            return;
        }
        sb.append(root.val);
        sb.append("!");
        Serialize2(sb,root.left);
        Serialize2(sb,root.right);
    }
    TreeNode Deserialize(String str) {
        if(str.length()==0){
            return null;
        }
        String []strs=str.split("!");
        return Deserialize2(strs);
    }
    int index=-1;
    public TreeNode Deserialize2(String []strs){
        index++;
        if(!strs[index].equals("#")){//如果根结点不为空
            TreeNode root=new TreeNode(0);
            root.val=Integer.parseInt(strs[index]);
            root.left=Deserialize2(strs);
            root.right=Deserialize2(strs);
            return root;
        }
        return null;
    }
}
