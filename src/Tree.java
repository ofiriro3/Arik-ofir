
public class Tree {

	TreeNode root;
	
	/**
	 * Empty constructor
	 */
	public Tree()
	{
		
	}
	/**
	 * Receive a double number and search for it in the tree, return null if do not exists
	 * @param keyToLookUp
	 * @return
	 */
	public TreeNode find(double keyToLookUp)
	{
			return findT(this.root,keyToLookUp);
	}
	private TreeNode findT(TreeNode currentNode, double keyToLookUp) {
		
		if(currentNode == null)
			return null;
		if(keyToLookUp == currentNode.getData())
			return currentNode;
		else if (keyToLookUp > currentNode.getData())
			return findT(currentNode.Right(),keyToLookUp);
		return findT(currentNode.Left(), keyToLookUp);
	}
	
	public void insert(TreeNode node)
	{
		if(this.root ==null)
		{
			this.root = node;
			return;
		}
		 insertT(this.root,node);
	}
	
	
	private void insertT(TreeNode current, TreeNode toAdd) {
		
		//Insert in the right sub-Tree
		if(current.getData() < toAdd.getData())
		{
				// Updating Size		
				current.SetSize(current.GetSize()+1);
				
			// If it does not have right child , chain it to the last leaf
				if(current.Right()== null)
				{
					current.setRight(toAdd);
					updatesHeights(toAdd.Parent());
				}
			insertT(current.Right(), toAdd);
		}
		//Insert in the left sub-Tree
		if(current.getData() > toAdd.getData())
		{
				// Updating Size		
				current.SetSize(current.GetSize()+1);
			// If it does not have left child , chain it to the last leaf
				if(current.Left()== null)
					{
					current.setLeft(toAdd);
					updatesHeights(toAdd.Parent());
					}
			insertT(current.Left(), toAdd);
		}
			
			
		
	}
	/**
	 * updates all the node's heights that need to be updated
	 * @param current
	 * @param firstAddition - treats the leaf addition differently 
	 */
	private void updatesHeights(TreeNode current ) {
	
		// reached the end of the loop
		if(current == null)
			return;
		int rHeight = 0 ;
		int lHeight = 0 ;
		
		if(current.Right()!=null)
			rHeight = current.Right().GetHeight();
		if(current.Left()!=null)
			lHeight = current.Left().GetHeight();
		
		current.SetHeight(Math.max(rHeight, lHeight)+1);
		
		// keep updating the ancestors 
		updatesHeights(current.Parent());	
			
	}
	
	private TreeNode findSucessor(TreeNode current)
	{
		// if the current has right childs
		
		if(current.Right()!=null)
		{
			return findMin(current.Right());
		}
		else if(current.Parent()!=null)
		{
			// If the node is a left son of Parent
			if(current.Parent().Left().equals(current))
			{
				return current.Parent();
			}
			if(root.Right().equals(current))
			{
				return null;
			}
			
			return findSucessor(current.Parent());
		}
		// the only option to get here is when your'e a root with no right sons
		return null;
	}
	
	/**
	 * private function that finds the minVal in the tree
	 * @param current
	 * @return
	 */
	private TreeNode findMin(TreeNode current)
	{
		if(current.Left()!=null)
		{
			return findMin(current.Left());
		}
		return current;
	}
	
	/**
	 * return the node of the required rank
	 * Node's counting begins with 1
	 * @param requiredRank
	 * @return
	 */
	public TreeNode OSSelect(int requiredRank)
	{
		return OSSelect(this.root,requiredRank);
	
	}
	private TreeNode OSSelect (TreeNode node, int requiredRank) {
		
		try{
			
		
		int currentRank = 1;
		if(node.Left()!=null)
		{
			currentRank = node.Left().GetSize()+1;
		}
		// We assumed that the input is validate
		
		if(requiredRank == currentRank)
			return node;
		if(currentRank < requiredRank)
		{
			return OSSelect(node.Right(), requiredRank-(currentRank));
		}
		return OSSelect(node.Left(), requiredRank);
		}
		catch(NullPointerException e)
		{
			System.err.println("Invalid input");
			return null;
		}
	}


	/**
	 * 
	 * @param deleteNode
	 */
	public void delete(TreeNode deleteNode)
	{
		/////////////////////////notice that i've written the findSuccessor function
		// but I haven't checked it yet
	}
	/**
	 * return the rank of the given node (assume the node is in the tree)
	 */
	public int OSRank(TreeNode deleteNode)
	{
		return -1;
	}
	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean isBalanced(TreeNode node)
	{
		return false;
	}
}

