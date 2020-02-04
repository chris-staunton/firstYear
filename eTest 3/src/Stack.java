import java.util.ArrayList;

public class Stack {
	ArrayList<Integer> stackArray;
	Stack(ArrayList<Integer> stackArray){
		this.stackArray = stackArray;
		
	}
	void push(int value) {
//		for(int i=0; i<stackArray.size(); i++) {
//			
//		}
		stackArray.add(value);
	}
	int pop() {
		int lastValue=-1;
		if(stackArray!=null) {
			lastValue = stackArray.get(stackArray.size()-1);
			stackArray.remove(stackArray.size()-1);
			
		}
		else {
			//throw Exception exception;
			System.out.println("Error, stack is empty -> cannot pop.");
		}
		return lastValue;
	}
	int peek() {
		int lastValue = -1;
		if(stackArray!=null) {
			lastValue = stackArray.get(stackArray.size()-1);
			
		}
		else {
			System.out.println("Error, stack is empty -> cannot peek.");
		}
		return lastValue;
	}
	int search(int value) {
		int index = -1;
		for(int i=0; i<stackArray.size(); i++) {
			if(value==stackArray.get(i)) {
				index= stackArray.get(i);
			}
		}
		return index;
		
	}
	void move(int element) {
		int index;
		if(search(element)!=-1) {
			index = search(element);
		}
		//int value = stackArray.get(stackArray.size()-1);
		//int pop = pop();
		//stackArray.get(index) = stackArray.get(index+1);
		push(element);
	}
}
