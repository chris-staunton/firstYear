public class CountCommon {
	
	static class LNode {
			public int data;
			public LNode next;
			public LNode(int d, LNode nxt) {data = d; next = nxt;}
	}
	//This function counts the common elements in two lists.
	//Given that the first list will contain N and the second will contain M elements (in ascending order) 
	//the worst case is that both N and M are of equal size and their elements are different 
	// but are spaced in between one another
	// it would have an asymtotic running time of Theta(N*M)
	public static Integer countCommon(LNode head1, LNode head2) {
		LNode list1 = head1;
		LNode list2 = head2;
		int commonCount = 0;
		
		if(list1 == null || list2 == null) {
			return 0;
		}
		
		while(list1 != null && list2 !=null) {
			while(list1.data<=list2.data && list2.data<=list1.data) {
				if(list1.data == list2.data) {
					commonCount++;
				}
				if (list2.next != null) {
					list2 = list2.next;
				}
				else return commonCount;
			}
			list1 = list1.next;
		}
		return commonCount;
	}
	
	public static void main (String [] args ) {
		LNode list1 = new LNode(0, new LNode (1, new LNode(2, null)));
		LNode list2 = new LNode(1, new LNode (2, new LNode(3, null)));
		LNode list3 = new LNode(0, new LNode (1, new LNode(2, null)));
		LNode list4 = new LNode(0, new LNode (1, new LNode(2, new LNode (3, null))));
		LNode list5 = new LNode(0, new LNode (3, null));
		LNode list6 = null;
	
		LNode list7 = new LNode(0, new LNode (1, new LNode(2, null)));
		LNode list8 = new LNode(6, new LNode (7, new LNode(8, null)));

		
		System.out.println("should_return_2:_" +countCommon(list1, list2));
		System.out.println("should_return_3:_" +countCommon(list1, list3));
		System.out.println("should_return_3:_" +countCommon(list1, list4));
		System.out.println("should_return_1:_" +countCommon(list1, list5));
		System.out.println("should_return_0:_" +countCommon(list1, list6));
		System.out.println("should_return_0:_" +countCommon(list7, list8));

	}
}
//