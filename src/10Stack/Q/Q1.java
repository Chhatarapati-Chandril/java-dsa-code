import java.util.*;

// Palindrome Linked List
// We have a singly linked list of characters, write a function that returns true if the given list is a
// palindrome, else false.
// Input : A->B->C->B->A
// Output : Yes It is Palindrome

// Time Complexity : o(n)
// Space Complexity: o(n)

public class Q1 
{
    public static class Node
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    static boolean isPalindrome(Node head)
    {   
        // head is the left most 
        Node slow = head;
        boolean isPalindrome = true;
        Stack<Integer> s = new Stack<>();

        // pushing all the elements in the stack
        while(slow != null)
        {
            s.push(slow.data);
            slow = slow.next;
        }
        // the top of the stack will be right most element
        while(head != null)
        {
            int i = s.pop();
            // checking if the head(left most of LL) == i(top of stack - right most of LL)
            if (i == head.data) {
                isPalindrome = true;
            }
            else{
                isPalindrome = false;
                break;
            }
            // moving head pointer from left to right in LinkedList
            head = head.next;
        }
            return isPalindrome;
    }
    public static void main(String[] args) 
    {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        boolean condition = isPalindrome(one);
        System.out.println("Palindrome : " + condition);
    }    
}