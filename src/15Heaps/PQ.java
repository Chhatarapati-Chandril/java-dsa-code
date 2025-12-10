import java.util.*;

public class PQ {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s) {
            return this.rank - s.rank;
        }
        
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        // pq.offer(data) can also be used instead of pq.add(data)
        // pq.poll() can also be used instead of pq.remove()

        pq.add(new Student("A", 4));
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 12));

        while(!pq.isEmpty()) {
            // O(1)
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            // O(log n)
            pq.remove();    
        }
    }
}