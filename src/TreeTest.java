import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TreeTest {
	

	Tree tr;
	
	@Before
	public void BeforeAction()
	{
		 tr = new Tree();
	}
	
	

	@Test
	public void InitNodes() {
		
		TreeNode tNoder = new TreeNode(3);
		tNoder.setLeft(new TreeNode (2));
		tNoder.setRight(new TreeNode(6));
		TreeNode left = tNoder.Left();
		TreeNode right = tNoder.Right();
		assertTrue(left.Parent() == tNoder);
		assertTrue(right.Parent() == tNoder);
	}
	@Test
	public void Insert()
	{
		assertTrue(tr.root == null);
		tr.insert(new TreeNode(4));
		assertTrue(tr.root.getData()==4);
		tr.insert(new TreeNode(2));
		assertTrue(tr.root.GetHeight()==1);
		assertTrue(tr.root.Left().GetHeight()==0);
		tr.insert(new TreeNode(6));
		tr.insert(new TreeNode(4));
		tr.insert(new TreeNode(3));
		tr.insert(new TreeNode(8));
		tr.insert(new TreeNode(1));
		tr.insert(new TreeNode(5));
		tr.insert(new TreeNode(99));
		tr.insert(new TreeNode(199));
		tr.insert(new TreeNode(139));
		assertTrue(tr.root.GetSize()== 10);
		TreeNode right = tr.root.Right();
		assertTrue(right.Right().GetSize() == 4);
		assertTrue(right.GetHeight() == 4);
		assertTrue(right.Right().GetHeight() == 3);
	}
	
	
	@Test
	public void Find() {
	
		tr.insert(new TreeNode(8));
		tr.insert(new TreeNode(1));
		tr.insert(new TreeNode(5));
		tr.insert(new TreeNode(99));
		tr.insert(new TreeNode(199));
		tr.insert(new TreeNode(139));	
		assertTrue(tr.find(139).Parent().getData() == (199));
		assertTrue(tr.find(8).Left().getData() == (1));
		assertTrue(tr.find(44) == null);

		
	}
	@Test
	public void SearchedRankedNode()
	{
		tr.insert(new TreeNode(4));
		tr.insert(new TreeNode(2));
		tr.insert(new TreeNode(6));
		tr.insert(new TreeNode(3));
		tr.insert(new TreeNode(8));
		tr.insert(new TreeNode(1));
		tr.insert(new TreeNode(5));
		tr.insert(new TreeNode(99));
		tr.insert(new TreeNode(199));
		tr.insert(new TreeNode(139));
		tr.insert(new TreeNode(138));
		System.out.println(tr.OSSelect(9).getData());
		assertTrue(tr.OSSelect(1).getData() == 1);
		assertTrue(tr.OSSelect(2).getData() == 2);
		assertTrue(tr.OSSelect(3).getData() == 3);
		assertTrue(tr.OSSelect(4).getData() == 4);
		assertTrue(tr.OSSelect(9).getData() == 138);
		assertTrue(tr.OSSelect(11).getData() == 199);
		
		
	}
	
	@After
	public void terminate()
	{
		tr = null;
	}

}
