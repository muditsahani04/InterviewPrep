
public class LinkedList {
	Node head;
	private Node tail;
	private int len;
	LinkedList (Node n)
	{
		head = n;
		tail = n;
		len++;
	}
	public void add (Node n)
	{
		if (head == null)
			head = n;
		else
			tail.next = n;
		tail = n;
		len++;
	}
	
	public void reverse()
	{
		Node prev = null;
		Node next = null;
		Node current = head;
		
		while (current!=null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		head = prev;
	}
	
	public void print()
	{
		Node temp = head;
		while (temp!= null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
}
