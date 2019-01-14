package DoubleEndLinkList;

public class Link {
	public int data;  // data item
	public Link next;  // the next link
	
//----------------------------------------------------------------------------
	
	public Link(int data) {  // constructor
		this.data = data;
	}
	
//----------------------------------------------------------------------------

	public void displayLink() {
		System.out.print(data + " ");
	}
}  // end class Link
