class Tree
{
	Object[] array;
	int count;
	
	public Tree()
	{
		array = new Object[20];
	}
	
	public boolean empty()
	{
		return (array[1]==null);
	}
	
	public int left(int i)
	{
		return 2*i;
	}
	public int right(int i)
	{
		return (2*i + 1);
	}
	public int parent(int i)
	{
		return i/2;
	}
	
	public Object getCargo(int i)
	{
		if(i<=0 || i>=array.length)
			return null;
		return array[i];
	}
	public void setCargo(int i,Object obj)
	{
		if(i<=0 || i>=array.length)
			return;
        array[i] = obj;
    }
	
	public void printPreorder (int i) {
        if(getCargo(i) == null)
		{
			System.out.print("- ");
			return;
		}
        System.out.print(getCargo(i)+" ");
        printPreorder(left(i));
        printPreorder(right(i));
    }
	
	public void printPostorder(int i)
	{
		if(getCargo(i) == null)
		{
			System.out.print("- ");
			return;
		}
		printPostorder(left(i));
		printPostorder(right(i));
		System.out.print(getCargo(i)+" ");
	}
	
	public void printInorder(int i)
	{
		if(getCargo(i) == null)
		{
			System.out.print("- ");
			return;
		}
		printInorder(left(i));
		System.out.print(getCargo(i)+" ");
		printInorder(right(i));
	}
	
	public void nodeCount()
	{
		for(int i=0;i<array.length;i++)
		{	
			if(array[i]==null)
				continue;
			else if(array[i].equals("-"))
					continue;
				else
					count++;
		}
		System.out.println("Number of nodes : "+count);
	}
	
}

public class testTree
{
	public static void main(String args[])
	{
		Tree tree = new Tree ();
		
		int root = 1;
		tree.setCargo (root, "A");
		tree.setCargo (tree.left (root), "B");
		tree.setCargo (tree.right (root), "C");
		
		int node = 2;
		tree.setCargo (tree.left (node), "D");
		//tree.setCargo (tree.right (node), "-");
		
		node = 3;
		tree.setCargo (tree.left (node), "E");
		//tree.setCargo (tree.right (node), "-");
		
		node = 4;
		tree.setCargo (tree.left (node), "G");
		tree.setCargo (tree.right (node), "H");
		
		node = 8;
		tree.setCargo (tree.left (node), "K");
		//tree.setCargo (tree.right (node), "-");
		
		node = 9;
		tree.setCargo (tree.left (node), "L");
		tree.setCargo (tree.right (node), "M");
		
		System.out.print("Preorder : ");
		tree.printPreorder(1);
		System.out.println();
		
		System.out.print("Postorder : ");
		tree.printPostorder(1);
		System.out.println();
		
		System.out.print("Inorder : "); 
		tree.printInorder(1);
		System.out.println();
		
		tree.nodeCount();
		
	}
}