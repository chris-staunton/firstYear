
class ListEquals {
	static class LNode {
		public int data;
		public LNode next;

		public LNode(int d, LNode nxt) {
			data = d;
			next = nxt;
		}
	}

	public static boolean listEquals(LNode head1, LNode head2) {
// TODO
		boolean result = true;
		while (head1!=null) {
			if(head2 == null) {
				result = false;
				break;
			}
			if(head1.data != head2.data) {
				result = false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		if(head2 != null) {
			result = false;
		}
		return result;
	}
	public static void main(String[] args) {
		LNode list1 = new LNode(0, new LNode(1, new LNode(2, null)));
		LNode list2 = new LNode(0, new LNode(1, new LNode(2, null)));
		LNode list3 = new LNode(0, new LNode(88, new LNode(2, null)));
		LNode list4 = new LNode(0, new LNode(1, null));
		System.out.println("should be true: " + listEquals(list1, list2));
		System.out.println("should be false: " + listEquals(list1, list3));
		System.out.println("should be false: " + listEquals(list1, list4));
		System.out.println("should be false: " + listEquals(list1, null));
	}
}
