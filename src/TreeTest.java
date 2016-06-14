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

	@Test
	public void testIsBalancedA() {
		tr.insert(new TreeNode(5));
		tr.insert(new TreeNode(2));
		tr.insert(new TreeNode(6));
		tr.insert(new TreeNode(1));
		tr.insert(new TreeNode(7));
		assertTrue(tr.isBalanced(tr.root));
	}
	
	@Test
	public void testIsBalancedB() {
		tr.insert(new TreeNode(5));
		tr.insert(new TreeNode(2));
		tr.insert(new TreeNode(6));
		tr.insert(new TreeNode(1));
		tr.insert(new TreeNode(7));
		tr.insert(new TreeNode(8));
		tr.insert(new TreeNode(9));
		assertFalse(tr.isBalanced(tr.root));
	}
	
	@Test
	public void testDeleteNoChildren() {
		tr.insert(new TreeNode(94));
		tr.insert(new TreeNode(97));
		tr.insert(new TreeNode(10));
		tr.insert(new TreeNode(5));
		tr.insert(new TreeNode(24));
		tr.insert(new TreeNode(11));
		tr.insert(new TreeNode(17));
		assertTrue(7 == tr.root.GetSize());
		assertTrue(4 == tr.root.GetHeight());
		TreeNode node5 = tr.root.Left().Left();
		assertTrue(5 == node5.getData());
		assertNull(node5.Left());
		assertNull(node5.Right());
		assertTrue(3 == tr.root.Left().GetHeight());
		assertTrue(5 == tr.root.Left().GetSize());
		tr.delete(node5);
		assertTrue(4 == tr.root.Left().GetSize());
		assertTrue(3 == tr.root.Left().GetHeight());
		assertNull(tr.root.Left().Left());
	}
	@Test
	public void testDeleteOneChild() {
		tr.insert(new TreeNode(94));
		tr.insert(new TreeNode(97));
		tr.insert(new TreeNode(10));
		tr.insert(new TreeNode(5));
		tr.insert(new TreeNode(24));
		tr.insert(new TreeNode(11));
		tr.insert(new TreeNode(17));
		TreeNode node24 = tr.root.Left().Right();
		assertTrue(24 == node24.getData());
		assertTrue(11 == node24.Left().getData());
		assertNull(node24.Right());
		assertTrue(3 == tr.root.Left().GetHeight());
		assertTrue(5 == tr.root.Left().GetSize());
		tr.delete(node24);
		assertTrue(4 == tr.root.Left().GetSize());
		assertTrue(2 == tr.root.Left().GetHeight());
		assertTrue(11 == tr.root.Left().Right().getData());
	}
	@Test
	public void testDeleteTwoChildren() {
		tr.insert(new TreeNode(94));
		tr.insert(new TreeNode(97));
		tr.insert(new TreeNode(10));
		tr.insert(new TreeNode(5));
		tr.insert(new TreeNode(24));
		tr.insert(new TreeNode(11));
		tr.insert(new TreeNode(17));
		TreeNode node10 = tr.root.Left();
		assertTrue(10 == node10.getData());
		assertTrue(5 == node10.Left().getData());
		assertTrue(24 == node10.Right().getData());
		assertTrue(3 == tr.root.Left().GetHeight());
		assertTrue(5 == tr.root.Left().GetSize());
		tr.delete(node10);
		assertTrue(4 == tr.root.Left().GetSize());
		assertTrue(2 == tr.root.Left().GetHeight());
		assertTrue(11 == tr.root.Left().getData());
		assertTrue(17 == tr.root.Left().Right().Left().getData());
	}
	@Test
	public void testOSRank() {
		tr.insert(new TreeNode(94));
		tr.insert(new TreeNode(97));
		tr.insert(new TreeNode(10));
		tr.insert(new TreeNode(5));
		tr.insert(new TreeNode(24));
		tr.insert(new TreeNode(11));
		tr.insert(new TreeNode(17));
		assertTrue(1 == tr.OSRank(tr.root.Left().Left())); // Node 5
		assertTrue(6 == tr.OSRank(tr.root)); // Node 95
		assertTrue(7 == tr.OSRank(tr.root.Right())); // Node 96
		assertTrue(5 == tr.OSRank(tr.root.Left().Right())); // Node 24
	}
	
	@After
	public void terminate()
	{
		tr = null;
	}

}
