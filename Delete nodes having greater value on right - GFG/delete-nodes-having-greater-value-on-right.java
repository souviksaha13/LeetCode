//{ Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node compute(Node head)
    {
        // your code here
        List<Integer> ls = new ArrayList<>();
        Node curr = head;
        
        while(curr != null) {
            ls.add(curr.data);
            curr = curr.next;
        }
        
        int maxel = ls.get(ls.size()-1);
        
        for(int i=ls.size()-2; i>=0; i--) {
            if(ls.get(i) < maxel) ls.remove(i);
            else maxel = ls.get(i);
        }
        
        while(head.data != ls.get(0)) head = head.next;
        curr = head;
        int i=1;
        
        while(curr.next != null) {
            if(curr.next.data != ls.get(i)) curr.next = curr.next.next;
            else {
                curr = curr.next;
                i++;
            }
        }
        
        return head;
    }
}
  