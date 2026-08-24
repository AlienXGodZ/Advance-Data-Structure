import java.util.Collections;
import java.util.PriorityQueue;

public class Test19 {

    public static void main(String[] args) {

        // =====================================================
        //                  MIN PRIORITY QUEUE
        // =====================================================

        System.out.println("===== MIN PRIORITY QUEUE =====");

        // Default PriorityQueue = Min Heap
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        // Insert
        minPQ.offer(50);
        minPQ.offer(20);
        minPQ.offer(80);
        minPQ.offer(10);
        minPQ.offer(40);

        System.out.println("PriorityQueue: " + minPQ);

        // Peek
        System.out.println("Peek: " + minPQ.peek());

        // Size
        System.out.println("Size: " + minPQ.size());

        // Search using contains()
        System.out.println("Contains 40: " + minPQ.contains(40));
        System.out.println("Contains 100: " + minPQ.contains(100));

        // Poll
        System.out.println("Poll: " + minPQ.poll());
        System.out.println("After Poll: " + minPQ);

        System.out.println("Poll: " + minPQ.poll());
        System.out.println("After Poll: " + minPQ);

        System.out.println("Is Empty: " + minPQ.isEmpty());


        // =====================================================
        //                  MAX PRIORITY QUEUE
        // =====================================================

        System.out.println();
        System.out.println("===== MAX PRIORITY QUEUE =====");

        // reverseOrder() = Max Heap
        PriorityQueue<Integer> maxPQ =
                new PriorityQueue<>(Collections.reverseOrder());

        // Insert
        maxPQ.offer(50);
        maxPQ.offer(20);
        maxPQ.offer(80);
        maxPQ.offer(10);
        maxPQ.offer(40);

        System.out.println("PriorityQueue: " + maxPQ);

        // Peek
        System.out.println("Peek: " + maxPQ.peek());

        // Size
        System.out.println("Size: " + maxPQ.size());

        // Search
        System.out.println("Contains 40: " + maxPQ.contains(40));
        System.out.println("Contains 100: " + maxPQ.contains(100));

        // Poll
        System.out.println("Poll: " + maxPQ.poll());
        System.out.println("After Poll: " + maxPQ);

        System.out.println("Poll: " + maxPQ.poll());
        System.out.println("After Poll: " + maxPQ);

        System.out.println("Is Empty: " + maxPQ.isEmpty());
    }
}