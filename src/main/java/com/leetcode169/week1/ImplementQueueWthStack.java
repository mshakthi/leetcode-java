package com.leetcode169.week1;

import java.util.Stack;

/**
 * Implements a queue using two stacks.
 * 
 * This class provides the standard queue operations (push, pop, peek, empty)
 * by utilizing two stacks to maintain the FIFO (First-In-First-Out) order.
 * 
 * <p>
 * The {@code inputStack} is used for enqueue operations (push), and the
 * {@code outStack} is used for dequeue operations (pop, peek). When the
 * {@code outStack} is empty, all elements from the {@code inputStack} are
 * transferred to the {@code outStack}, reversing their order to maintain
 * queue semantics.
 * </p>
 * 
 * Methods:
 * <ul>
 *   <li>{@link #push(int)} - Adds an element to the end of the queue.</li>
 *   <li>{@link #pop()} - Removes and returns the element at the front of the queue.</li>
 *   <li>{@link #peek()} - Returns the element at the front of the queue without removing it.</li>
 *   <li>{@link #empty()} - Checks if the queue is empty.</li>
 *   <li>{@link #moveInputToOutput()} - Transfers all elements from inputStack to outStack.</li>
 * </ul>
 * 
 * Example usage:
 * <pre>
 * ImplementQueueWthStack queue = new ImplementQueueWthStack();
 * queue.push(1);
 * queue.push(2);
 * int front = queue.peek(); // returns 1
 * int removed = queue.pop(); // returns 1
 * boolean isEmpty = queue.empty(); // returns false
 * </pre>
 */
public class ImplementQueueWthStack {
    Stack<Integer> inputStack;
    Stack<Integer> outStack;

    public ImplementQueueWthStack() {
        inputStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        this.inputStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()){
            while(!inputStack.isEmpty()){
                outStack.push(inputStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()){
            while(!inputStack.isEmpty()){
                outStack.push(inputStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outStack.isEmpty();
    }

    public void moveInputToOutput(){
        while(!inputStack.isEmpty()){
            outStack.push(inputStack.pop());
        }
    }
}
