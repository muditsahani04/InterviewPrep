
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
	
	public Node reverse(Node start)
	{
		Node prev = null;
		Node next = null;
		Node current = start;
		
		while (current!=null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		return prev;
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
	
	public boolean isPalindrome()
	{
		Node p1 = head;
		Node p2 = head;
        
        if (head == null || head.next == null)
            return true;
        
        while (p2 != null && p2.next != null)
        {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        Node start;
        if (p2 == null)
           start = reverse(p1);
        else
           start = reverse(p1.next);
        
        p1 = head;
        while (start != null)
        {
            if (p1.data != start.data)
                return false;
            p1 = p1.next;
            start = start.next;
        }
        
        return true;
	}
}
