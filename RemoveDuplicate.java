public class Node 
{
	public int data;
	public Node next;
	public Node previous;
	
	public Node(int data)
	{
		this.data = data;
	}
	
	public void displayNode()
	{
		System.out.print(data + " ");
	}
}

//-------------------------------------------------------------------------------------------------------------

public class LinkedList 
{
	private Node first;
	
	public LinkedList()
	{
		first = null;
	}
	
//	public boolean isEmpty()
//	{
//		return (first == null);
//	}
	
	public void insertFirst(int data)
	{
		Node node = new Node(data);
		node.next = first;
		first = node;
	}
	
	public void displayList()
	{
		Node current = first;
		while(current != null)
		{
			current.displayNode();
			current = current.next;
		}
		
	}
	
	public Node removeDuplicate()
	{
		Node current = first;
		while(current != null)
		{
			Node runner = current;
			while(runner.next != null)
			{
				if(runner.next.data == current.data)
				{
					runner.next = runner.next.next;
				}
				else
				{
					runner = runner.next;
				}
			}
			current = current.next;
		}
		return current;
	}
}

//-------------------------------------------------------------------------------------------------------------

public static void main(String[] args) 
{
	LinkedList ll = new LinkedList();
	ll.insertFirst(6);
	ll.insertFirst(8);
	ll.insertFirst(6);
	ll.insertFirst(1);
	ll.insertFirst(5);
	ll.insertFirst(6);
	ll.displayList();
	System.out.println();
	ll.removeDuplicate();
	ll.displayList();

}
