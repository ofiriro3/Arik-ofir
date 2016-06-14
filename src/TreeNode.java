/**
 * TreeNode is a class that representing the nodes in a binary tree Each node
 * has pointers to it's left/right childs and back to it's parent Each node
 * contains as well member size that represtens the size of it's inner tree and
 * member high which represents the high of the node
 * 
 * @author ofiri
 *
 */
public class TreeNode {

	private double data;
	private TreeNode right;
	private TreeNode left;
	private TreeNode parent;
	private int size;
	private int height;

	public TreeNode(double key) {

		this.data = key;
		this.size = 1;
		this.height = 0;
	}

	public double getData()
	{
		return this.data;
	}
	public void setData(double key){
		this.data = key;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
		if (left != null)
			left.parent = this;
	}

	public void setRight(TreeNode right) {
		this.right = right;
		if (right != null)
			right.parent = this;	
	}

	public TreeNode Parent() {
		return this.parent;
	}

	public TreeNode Left() {
		return this.left;
	}

	public TreeNode Right() {
		return this.right;
	}

	public int GetSize() {
		return this.size;
	}

	public void SetSize(int size) {
		this.size = size;
	}

	public int GetHeight() {
		return this.height;
	}

	public void SetHeight(int height) {
		this.height = height;
	}

}
