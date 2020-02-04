import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Christopher Staunton
 *  @version 09/10/18 11:13:22
 *  
 *  9 hours spent on program.
 */

/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 *
 * @param <T> This is a type parameter. T is used as a class name in the
 *            definition of this class.
 *
 *            When creating a new DoublyLinkedList, T should be instantiated
 *            with an actual class name that extends the class Comparable. Such
 *            classes include String and Integer.
 *
 *            For example to create a new DoublyLinkedList class containing
 *            String data: DoublyLinkedList<String> myStringList = new
 *            DoublyLinkedList<String>();
 *
 *            The class offers a toString() method which returns a
 *            comma-separated sting of all elements in the data structure.
 *
 *            This is a bare minimum class you would need to completely
 *            implement. You can add additional methods to support your code.
 *            Each method will need to be tested by your jUnit tests -- for
 *            simplicity in jUnit testing introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>> {

	/**
	 * private class DLLNode: implements a *generic* Doubly Linked List node.
	 */
	private class DLLNode {
		public final T data; // this field should never be updated. It gets its
// value once from the constructor DLLNode.
		public DLLNode next;
		public DLLNode prev;

		/**
		 * Constructor
		 *
		 * @param theData  : data of type T, to be stored in the node
		 * @param prevNode : the previous Node in the Doubly Linked List
		 * @param nextNode : the next Node in the Doubly Linked List
		 * @return DLLNode
		 */
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) {
			data = theData;
			prev = prevNode;
			next = nextNode;
		}
	}

// Fields head and tail point to the first and last nodes of the list.
	private DLLNode head, tail;

	/**
	 * Constructor of an empty DLL
	 *
	 * @return DoublyLinkedList
	 */
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Tests if the doubly linked list is empty
	 *
	 * @return true if list is empty, and false otherwise
	 *
	 *         Worst-case asymptotic running time cost: TODO
	 *
	 *         Justification: TODO
	 */
	public boolean isEmpty() {
		if (head == null || tail == null) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Inserts an element in the doubly linked list
	 *
	 * @param pos  : The integer location at which the new data should be inserted
	 *             in the list. We assume that the first position in the list is 0
	 *             (zero). If pos is less than 0 then add to the head of the list.
	 *             If pos is greater or equal to the size of the list then add the
	 *             element at the end of the list.
	 * @param data : The new data of class T that needs to be added to the list
	 * @return none
	 *
	 *         Worst-case asymptotic running time cost: TODO
	 *
	 *         Justification: TODO
	 */
	public void insertBefore(int pos, T data) {
// TODO

		DLLNode newNode = new DLLNode(data, null, null);
		DLLNode tempNode = null;
		DLLNode node = head;
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else if (pos <= 0) {
// insert at head
			node.next = newNode;
			newNode.prev = node;
			newNode.next = null;
//head.prev = newNode;
			head = newNode;

		}
// else if(pos>=)

// insert in middle of list
		else if (get(pos) != null) {

			for (int i = 0; i < pos; i++) {

				tempNode = node.prev;
				node = node.prev;

			}
			newNode.prev = tempNode;
			newNode.next = tempNode.next;
			tempNode.next.prev = newNode;
			tempNode.next = newNode;

// newNode.next = node;
// newNode.prev = node.prev;
		}
// insert last
		else if (get(pos) == null) {

			tail.prev = newNode;
			newNode.next = tail;
			tail = newNode;
		}

		return;
	}

	/**
	 * Returns the data stored at a particular position
	 *
	 * @param pos : the position
	 * @return the data at pos, if pos is within the bounds of the list, and null
	 *         otherwise.
	 *
	 *         Worst-case asymptotic running time cost: TODO
	 *
	 *         Justification: TODO
	 *
	 */
	public T get(int pos) {
// TODO
		DLLNode node = head;
		DLLNode tempNode = null;
		if (pos < 0) {
			return null;
		} else if (pos == 0) {
			tempNode = node;
		} else {
			for (int i = 0; i < pos; i++) {
				if (node.prev != null) {
					tempNode = node.prev;
					node = node.prev;
				} else {
					return null;
				}
			}
		}
		return tempNode.data;
	}

	/**
	 * Deletes the element of the list at position pos. First element in the list
	 * has position 0. If pos points outside the elements of the list then no
	 * modification happens to the list.
	 *
	 * @param pos : the position to delete in the list.
	 * @return true : on successful deletion, false : list has not been modified.
	 *
	 *         Worst-case asymptotic running time cost: TODO
	 *
	 *         Justification: TODO
	 */
	public boolean deleteAt(int pos) {
// TODO
		boolean result = false;
		DLLNode startNode = head;
		DLLNode tempNode = null;
		if (head == null) {
			return false;
		}
		if (get(pos) != null) {
			for (int i = 0; i < pos; i++) {
				tempNode = startNode.prev;
				startNode = startNode.prev;

			}
// delete whole DDL
			if (startNode == head && startNode == tail) {
				head = null;
				tail = null;
			}
//delete head
			else if (startNode == head) {
				startNode.prev.next = null;
				head = startNode.prev;
				startNode.prev = null;
				startNode.next = null;
			}
//delete tail
			else if (tempNode == tail) {
				tempNode.next.prev = null;
				tail = tempNode.next;
			} else {
				tempNode.next.prev = tempNode.prev;
				tempNode.prev.next = tempNode.next;
				tempNode.next = null;
				tempNode.prev = null;
				result = true;
			}
// tempNode.data =null;

		} else {
			result = false;
		}
		return result;
	}

	/**
	 * Reverses the list. If the list contains "A", "B", "C", "D" before the method
	 * is called Then it should contain "D", "C", "B", "A" after it returns.
	 *
	 * Worst-case asymptotic running time cost: TODO
	 *
	 * Justification: TODO
	 */
	public void reverse() {
// TODO
// for loop with
		DLLNode currentNode = head;
//DLLNode endNode = this.tail;
//DLLNode nextStartNode = null;
//DLLNode prevEndNode = null;
		DLLNode tempNode = null;
		if (currentNode == null) {
			return;
		} else if (currentNode.prev == null) {
			return;
		} else if (currentNode.prev == tail) {
			tempNode = head;
			head = tail;
			tail = tempNode;
			tail.next = head;
			tail.prev = null;
			head.prev = tail;
			head.next = null;
			return;
		}
		while (currentNode != null) {
			tempNode = currentNode.next;
			currentNode.next = currentNode.prev;
			currentNode.prev = tempNode;

			currentNode = currentNode.next;
		}
		if (tempNode != null || tempNode.next != tail) {
			head = tempNode.next;
		}

// int size = 0;
// while(get(size)!=null) {
// size++;
// }
// //size is the size of the DLL
////
//// for(int i=0; i<size; i++, size--) {
//// firstNode = null;
//// secondNode = null;
//// startNode = head;
//// endNode = tail;
//// }
////
// for(int i=0; i<size/2; i++) {
// nextStartNode = startNode.next;
// prevEndNode = endNode.prev;
//
// //swap
// tempNode = startNode;
// tempNode.next = startNode.next;
// tempNode.prev = startNode.prev;
//
// startNode = endNode;
// startNode.next = endNode.next;
// startNode.prev = startNode.prev;
// endNode = tempNode;
// endNode.next = tempNode.next;
// endNode.prev = endNode.prev;
//
// startNode = startNode.next;
// prevEndNode = endNode.prev;
// }
//
// //tempNode = helpStartNode;
// this.tail = helpStartNode;
// this.head = helpEndNode;

	}

	/**
	 * Removes all duplicate elements from the list. The method should remove the
	 * _least_number_ of elements to make all elements unique. If the list contains
	 * "A", "B", "C", "B", "D", "A" before the method is called Then it should
	 * contain "A", "B", "C", "D" after it returns. The relative order of elements
	 * in the resulting list should be the same as the starting list.
	 *
	 * Worst-case asymptotic running time cost: TODO
	 *
	 * Justification: TODO
	 */
	public void makeUnique() {
// TODO
// cycle through dll -> compare first to rest. if copys delete
// increment first.
		T first = null, second = null;
		int size = 0;
		while (get(size) != null) {
			size++;
		}
		int j;
		for (int i = 0; i < size; i++) {
			first = get(i);
			j=i+1;
//			for (int j = i+1; j < size; j++) {
//				second = get(j);
//				if(first == second) {
//					deleteAt(j);
//				}
//			}
			while(get(j)!=null) {
				second = get(j);
				if(first==second) {
					deleteAt(j);
				}
				else {
					j++;
				}
			}
		}
	}

	/*----------------------- STACK API
	* If only the push and pop methods are called the data structure should behave like a stack.
	*/

	/**
	 * This method adds an element to the data structure. How exactly this will be
	 * represented in the Doubly Linked List is up to the programmer.
	 *
	 * @param item : the item to push on the stack
	 *
	 *             Worst-case asymptotic running time cost: TODO
	 *
	 *             Justification: TODO
	 */
	public void push(T item) {
// TODO
		DLLNode node = new DLLNode(item, null, null);
//
// node.next = head;
// node.prev = null;
// head = node;
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			head.next = node;
			node.prev = head;
			head = node;
		}

	}

	/**
	 * This method returns and removes the element that was most recently added by
	 * the push method.
	 *
	 * @return the last item inserted with a push; or null when the list is empty.
	 *
	 *         Worst-case asymptotic running time cost: TODO
	 *
	 *         Justification: TODO
	 */
	public T pop() {
// TODO
		if (isEmpty()) {
			return null;
		} else {
			T data = head.data;
			deleteAt(0);
			return data;
		}
	}

	/*----------------------- QUEUE API
	* If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	*/

	/**
	 * This method adds an element to the data structure. How exactly this will be
	 * represented in the Doubly Linked List is up to the programmer.
	 *
	 * @param item : the item to be enqueued to the stack
	 *
	 *             Worst-case asymptotic running time cost: TODO
	 *
	 *             Justification: TODO
	 */
	public void enqueue(T item) {
// TODO
// add to the tail
		DLLNode node = new DLLNode(item, null, null);
//
// node.next = tail;
// node.prev = null;
// head = node;
		if (isEmpty()) {
			head = node;
			tail = node;
		} else {
			tail.prev = node;
			node.next = tail;
			tail = node;
		}
	}

	/**
	 * This method returns and removes the element that was least recently added by
	 * the enqueue method.
	 *
	 * @return the earliest item inserted with an enqueue; or null when the list is
	 *         empty.
	 *
	 *         Worst-case asymptotic running time cost: TODO
	 *
	 *         Justification: TODO
	 */
	public T dequeue() {
// TODO
// delete at the head
		if (isEmpty()) {
			return null;
		} else {
			T data = head.data;
			deleteAt(0);
			return data;
		}

	}

	/**
	 * @return a string with the elements of the list as a comma-separated list,
	 *         from beginning to end
	 *
	 *         Worst-case asymptotic running time cost: Theta(n)
	 *
	 *         Justification: We know from the Java documentation that
	 *         StringBuilder's append() method runs in Theta(1) asymptotic time. We
	 *         assume all other method calls here (e.g., the iterator methods above,
	 *         and the toString method) will execute in Theta(1) time. Thus, every
	 *         one iteration of the for-loop will have cost Theta(1). Suppose the
	 *         doubly-linked list has 'n' elements. The for-loop will always iterate
	 *         over all n elements of the list, and therefore the total cost of this
	 *         method will be n*Theta(1) = Theta(n).
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;

// iterate over the list, starting from the head
		for (DLLNode iter = head; iter != null; iter = iter.prev) {
			if (!isFirst) {
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data.toString());
		}

		return s.toString();
	}

}