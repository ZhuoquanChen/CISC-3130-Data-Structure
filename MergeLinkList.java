public class ListNode 
{
	public int data;
	public ListNode next;
	
	public ListNode(int data)
	{
		this.data = data;
	}
	
	public void displayNode()
	{
		System.out.print(data + " ");
	}
}

//----------------------------------------------------------------------------------------------

public class LinkList 
{
	public ListNode first;
	
	public LinkList()
	{
		first = null;
	}
	
	public ListNode MergeList(ListNode ListNodeA, ListNode ListNodeB)
	{
		
		if(ListNodeA == null)
		{
			return ListNodeB;
		}
		
		if(ListNodeB == null)
		{
			return ListNodeA;
		}
		
		//ListNode first = null;
		if(ListNodeA.data < ListNodeB.data)
		{
			first = ListNodeA;
			ListNodeA = ListNodeA.next;
		}
		
		if(ListNodeA.data > ListNodeB.data)
		{
			first = ListNodeB;
			ListNodeB = ListNodeB.next;
		}
		
		ListNode current = first;
		while(ListNodeA != null || ListNodeB != null)
		{
			if(ListNodeA == null)
			{
				current.next = ListNodeB;
				return first;
			}
			
			else if(ListNodeB == null)
			{
				current.next = ListNodeA;
				return first;
			}
			
			if(ListNodeA.data < ListNodeB.data)
			{
				current.next = ListNodeA;
				current = current.next;
				ListNodeA = ListNodeA.next;
			}
			
			else
			{
				current.next = ListNodeB;
				current = current.next;
				ListNodeB = ListNodeB.next;
			}
		
		}
		
		current.next = null;
		return first;
		
		
		//ListNode ListNodeA = new ListNode();
		//ListNode ListNodeB = new ListNode();
		/*
	    if (ListNodeA == null) 
	    	return ListNodeB;
		if (ListNodeB == null) 
			return ListNodeA;

		if (ListNodeA.data < ListNodeB.data) 
		{
			ListNodeA.next = MergeList(ListNodeA.next, ListNodeB);
			return ListNodeA;
		} 
		
		else 
		{
			ListNodeB.next = MergeList(ListNodeB.next, ListNodeA);
			return ListNodeB;
		}*/
		
	}
	
	public void insertFirst(int data)
	{
		ListNode node = new ListNode(data);
		node.next = first;
		first = node;
	}
	
	public void displayList()
	{
		ListNode current = first;
		while(current != null)
		{
			current.displayNode();
			current = current.next;
		}
	}
}

//----------------------------------------------------------------------------------------------

public static void main(String[] args) 
{
		LinkList LA = new LinkList();
		LinkList LB = new LinkList();
		LinkList LM  = new LinkList();
				
		LA.insertFirst(9);
		LA.insertFirst(7);
		LA.insertFirst(5);
		LA.insertFirst(3);
		LA.insertFirst(1);
		LA.displayList();
		
		System.out.println();
		
		LB.insertFirst(10);
		LB.insertFirst(8);
		LB.insertFirst(6);
		LB.insertFirst(4);
		LB.insertFirst(2);
		LB.displayList();
		
		System.out.println();
		
		LM.MergeList(LA.first, LB.first);
		LM.displayList();

}
