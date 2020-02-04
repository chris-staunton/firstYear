
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 * Test class for Doubly Linked List
 *
 * @author
 * @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest {
	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new DoublyLinkedList<Integer>();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check if the insertBefore works
	 */
	@Test
	public void testInsertBefore() {
		// test non-empty list
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(1, 2);
		testDLL.insertBefore(2, 3);

		testDLL.insertBefore(0, 4);
		assertEquals("Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3",
				testDLL.toString());
		testDLL.insertBefore(1, 5);
		assertEquals("Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3",
				testDLL.toString());
		testDLL.insertBefore(2, 6);
		assertEquals("Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3",
				testDLL.toString());
		testDLL.insertBefore(-1, 7);
		assertEquals(
				"Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list",
				"7,4,5,6,1,2,3", testDLL.toString());
		testDLL.insertBefore(7, 8);
		assertEquals(
				"Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list",
				"7,4,5,6,1,2,3,8", testDLL.toString());
		testDLL.insertBefore(700, 9);
		assertEquals(
				"Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list",
				"7,4,5,6,1,2,3,8,9", testDLL.toString());

		// test empty list
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0, 1);
		assertEquals(
				"Checking insertBefore to an empty list at position 0 - expected the element at the head of the list",
				"1", testDLL.toString());
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(10, 1);
		assertEquals(
				"Checking insertBefore to an empty list at position 10 - expected the element at the head of the list",
				"1", testDLL.toString());
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(-10, 1);
		assertEquals(
				"Checking insertBefore to an empty list at position -10 - expected the element at the head of the list",
				"1", testDLL.toString());
	}

	// TODO: add more tests here. Each line of code in DoublyLinkedList.java should
	// be executed at least once from at least one test.

	@Test
	public void testDeleteAt() {

		// test non-empty list
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(1, 2);
		testDLL.insertBefore(2, 3);

		testDLL.deleteAt(0);
		assertEquals("Checking deleteAt to a list containing 3 elements at position 0", "2,3", testDLL.toString());
		testDLL.deleteAt(1);
		assertEquals("Checking deleteAt to a list containing 2 elements at position 1", "2", testDLL.toString());
		testDLL.deleteAt(0);
		assertEquals("Checking deleteAt to a list containing 1 elements at position 0", "", testDLL.toString());

		// test empty
		testDLL.deleteAt(0);
		assertEquals("Checking deleteAt to a list containing 0 elements at position 0", "", testDLL.toString());

		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(1, 2);
		testDLL.insertBefore(2, 3);
		testDLL.insertBefore(3, 1);
		testDLL.insertBefore(4, 2);
		testDLL.insertBefore(5, 3);

		testDLL.deleteAt(3);
		assertEquals("Checking deleteAt to a list containing 6 elements at position 3", "1,2,3,2,3",
				testDLL.toString());
		testDLL.deleteAt(10);
		assertEquals("Checking deleteAt to a list containing 5 elements at position 10", "1,2,3,2,3",
				testDLL.toString());
		testDLL.deleteAt(-5);
		assertEquals("Checking deleteAt to a list containing 5 elements at position -5", "1,2,3,2,3",
				testDLL.toString());

	}

	@Test
	public void testPush() {
		// test non-empty list
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(1, 2);
		testDLL.insertBefore(2, 3);

		testDLL.push(5);
		assertEquals("Checking push to a list containing 3", "5,1,2,3", testDLL.toString());

	}

	@Test
	public void testPop() {
		// test non-empty list
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(1, 2);
		testDLL.insertBefore(2, 3);

		testDLL.pop();
		assertEquals("Checking pop to a list containing 3", "2,3", testDLL.toString());
		testDLL.pop();
		testDLL.pop();
		testDLL.pop();
		testDLL.pop();
		assertEquals("Checking pop to an empty list", "", testDLL.toString());

	}

	@Test
	public void testReverse() {
		// test non-empty list
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0, 2);
		testDLL.insertBefore(1, 10);
		testDLL.insertBefore(2, 6);
		testDLL.insertBefore(3, 17);

		testDLL.reverse();
		assertEquals("Checking reverse to a list containing 4", "17,6,10,2", testDLL.toString());
		testDLL.reverse();
		assertEquals("Checking reverse to a list containing 4", "2,10,6,17", testDLL.toString());
		testDLL.pop();
		testDLL.pop();
		testDLL.reverse();
		// list is "6,17"
		assertEquals("Checking reverse to a list containing 2", "17,6", testDLL.toString());

		testDLL.pop();
		assertEquals("Checking reverse to a list containing 1", "6", testDLL.toString());
		// list is "6"
		testDLL.reverse();
		assertEquals("Checking reverse to a list containing 1", "6", testDLL.toString());

		testDLL.pop();
		testDLL.reverse();
		// list is empty
		assertEquals("Checking reverse to an empty list", "", testDLL.toString());

	}

	@Test
	public void testEnqueue() {
		// test non-empty list
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.enqueue(5);
		assertEquals("Checking enqueue to an empty list", "5", testDLL.toString());

		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(1, 2);
		testDLL.insertBefore(2, 3);

		testDLL.enqueue(5);
		assertEquals("Checking enqueue to a list containing 3", "1,2,3,5,5", testDLL.toString());

		testDLL.enqueue(4);
		assertEquals("Checking enqueue to a list containing 3", "1,2,3,5,5,4", testDLL.toString());

	}

	@Test
	public void testdequeue() {
		// test non-empty list
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(1, 2);
		testDLL.insertBefore(2, 3);
		// testDLL.insertBefore(3,4);

		testDLL.dequeue();
		assertEquals("Checking reverse to a list containing 3", "2,3", testDLL.toString());
		testDLL.dequeue();
		assertEquals("Checking reverse to a list containing 2", "3", testDLL.toString());
		testDLL.dequeue();
		assertEquals("Checking reverse to a list containing 1", "", testDLL.toString());
		testDLL.dequeue();
		assertEquals("Checking reverse to an empty list", "", testDLL.toString());

	}
	@Test
	public void testMakeUnique() {
		// test non-empty list
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0, 1);
		testDLL.insertBefore(1, 2);
		testDLL.insertBefore(2, 3);
		testDLL.insertBefore(1, 2);
		testDLL.insertBefore(2, 3);
		// testDLL.insertBefore(3,4);
		assertEquals("Checking reverse to a list containing 5", "1,2,3,2,3", testDLL.toString());
		
		testDLL.makeUnique();
		//testDLL.dequeue();
		assertEquals("Checking reverse to a list containing 5", "1,2,3", testDLL.toString());
		testDLL.dequeue();
		assertEquals("Checking reverse to a list containing 3", "2,3", testDLL.toString());
		testDLL.makeUnique();
		assertEquals("Checking reverse to a list containing 3", "2,3", testDLL.toString());
		testDLL.pop();
		assertEquals("Checking reverse to a list containing 3", "3", testDLL.toString());
		testDLL.insertBefore(0, 3);
		testDLL.insertBefore(1, 3);
		testDLL.insertBefore(2, 3);
		testDLL.insertBefore(1, 3);
		testDLL.insertBefore(2, 3);
		assertEquals("Checking reverse to a list containing 3", "3,3,3,3,3,3", testDLL.toString());
		testDLL.makeUnique();
		assertEquals("Checking makeUnique to a list containing 7, with 5 dupilcates", "3", testDLL.toString());
		testDLL.makeUnique();
		assertEquals("Checking makeUnique to a list containing 1, with 0 dupilcates", "3", testDLL.toString());
	}
}
