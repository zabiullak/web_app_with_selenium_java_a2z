package learningBlock;

import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class JavaList {

    @Test
    public void arraySmaple(){
        int[] val = {1,2,3};
        val[3] = 4;

        for (int v : val) {
            System.out.println(v);
        }
    }

    @Test
    public void arrayList(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add("hi");

        System.out.println(list);
    }

    @Test
    private void vector(){
        Vector<Boolean> vec =new Vector<Boolean>();

        vec.add(true);
        vec.add(false);

        boolean val = vec.get(1);
        System.out.println(val);
    }
    @Test
    private void stack(){
        Stack<String> stack =new Stack<>();
        stack.push("Hi");
        stack.push("add");
        stack.push("car");

        System.out.println(stack);

        String v = stack.pop();

        System.out.println(v);
        int val = stack.search("add");
        System.out.println(val);
        String ss = stack.peek();
        System.out.println(ss);
    }


    @Test
    private void priorityQueue(){

            // Creating a priority queue
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(4);
        System.out.println("PriorityQueue: " + numbers);
        numbers.add(2);
        System.out.println("PriorityQueue: " + numbers);
        numbers.add(1);
        System.out.println("PriorityQueue: " + numbers);
        numbers.offer(10);
        System.out.println("PriorityQueue: " + numbers);
        numbers.add(2);
        System.out.println("PriorityQueue: " + numbers);
        numbers.add(5);
        System.out.println("PriorityQueue: " + numbers);

        while(!numbers.isEmpty()) {
            System.out.println(numbers.poll());
        }
            // Using the remove() method
            boolean result = numbers.remove(2);
            System.out.println("Is the element 2 removed? " + result);

            // Using the poll() method
            int number = numbers.poll();
            System.out.println("Removed Element Using poll(): " + number);
    }

    @Test
    public void prioprityQueueComparator(){
        Queue<Integer> pq = new PriorityQueue<>(new CustomComparator());
        pq.add(10);
        pq.offer(12);
        pq.add(1);
        pq.add(2);
        System.out.print("PriorityQueue: " + pq);
    }

    @Test
    public void arrayDeque(){
        Deque<Integer> numbers = new ArrayDeque<>();

        // add elements to the Deque
        numbers.offer(1);
        numbers.offerLast(2);
        numbers.offerFirst(3);
        System.out.println("Deque: " + numbers);
        // Access elements of the Deque
        int firstElement = numbers.peekFirst();
        System.out.println("First Element: " + firstElement);
        int lastElement = numbers.peekLast();
        System.out.println("Last Element: " + lastElement);
           // Remove elements from the Deque
           int removedNumber1 = numbers.pollFirst();
           System.out.println("Removed First Element: " + removedNumber1);

           int removedNumber2 = numbers.pollLast();
           System.out.println("Removed Last Element: " + removedNumber2);

           System.out.println("Updated Deque: " + numbers);
    }

    @Test
    public void arrayBlockingQueue(){
        // Create a blocking queue using the ArrayBlockingQueue
        BlockingQueue<Integer> numbers = new ArrayBlockingQueue<>(5);
        try {
               // Insert element to blocking queue
            numbers.put(2);
            numbers.put(1);
            numbers.put(3);
            numbers.put(1);
            numbers.put(3);

            System.out.println("BLockingQueue: " + numbers);

            // Remove Elements from blocking queue
            int removedNumber = numbers.take();
            System.out.println("Removed Number: " + removedNumber);
        }
        catch(Exception e) {
            e.getStackTrace();
        }
    }
}
