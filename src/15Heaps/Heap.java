import java.util.*;

// for min heap
public class Heap {
    ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // add at last 
            arr.add(data);

            // child index
            int x = arr.size() - 1;
            int par = (x - 1) / 2;

            while(arr.get(x) < arr.get(par)) {  // O(log n)
                // swap(arr.get(x), arr.get(par))
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }


        public int peek() {
            return arr.get(0);
        }


        private void heapify(int i) {
            // Assume parent is min index
            // Compare with left child → update min index if needed
            // Compare with right child → update min index if needed
            // If parent is not min → swap and recurse
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            if (minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }


        public int remove() {
            int data = arr.get(0);

            // 1. swap 1st and last
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, data);

            // 2. remove last
            arr.remove(arr.size() - 1);

            // 3. heapify
            heapify(0);
            return data;

        }


        public boolean isEmpty() {
            return arr.size() == 0;
        }

        
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(! h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}