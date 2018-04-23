
public class IsPalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		LinkedList list1 = new LinkedList(new Node(1));
		list1.add(new Node(6));
		list1.add(new Node(7));
		Node p = new Node(6);
		list1.add(p);
		list1.add(new Node(1));
		list1.print();
		System.out.println("\n" +list1.isPalindrome());
		
	}

}
