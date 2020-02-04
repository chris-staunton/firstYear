import java.util.ArrayList;

public class StackTest {
	public static void main(String[] args) {
		ArrayList<Integer> stackArray = new ArrayList<Integer>();
		//((Integer) stackArray).push(1);
		Stack stack = new Stack(stackArray);
		//stack.push(1);
		//System.out.println(stack);
		//stack.push(5);
		//stack.push(7);
		//stack.push(3);
		for(int i=1; i<11; i++) {
			stack.push(i);
		}
		for(int i=0; i<2; i++) {		// loop to show different values 
			
		
		int lastValue = stack.pop();
		System.out.println("popped value: " + lastValue);
		int peek = stack.peek();
		System.out.println("Peek value: " + peek);
		lastValue = stack.pop();
		System.out.println("popped value: " + lastValue);
		int element = 8;
		int search = stack.search(element);
		if(search!=-1) {
			System.out.println("Index of value("+element + "): " + search);
		}
		else {
			System.out.println(element + " does not exist on stack.");
		}
		}
	}
}
