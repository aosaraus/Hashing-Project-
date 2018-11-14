public class BucketList {
   protected Node head;
   protected long size;
   //constructor for BucketList
   public BucketList() {
      head = new Node(null, null);
      size = 0;
   }
   //return element 
   public void returnElement() {
      String elements = "";
      Node curNode = head.getNext();
      if(curNode != null) {
         while (curNode != null) {
         elements += curNode.getElement().toString();
         curNode = curNode.getNext();
         }
      }
      System.out.println(elements);
   }
   //adds element to linked list         
   public boolean addElement(Object object) {
      boolean added = false;
      if (head == null) {
         head = new Node(object, null);
         added = true;
      } else {
         Node curNode = head.getNext();
         Node v = new Node (object, null);
         int counter = 0;   
         while (curNode != null) {
            if(curNode.getElement().equals(object)) {
                counter++; 
            }
            curNode = curNode.getNext();
         }
         if (counter == 0) {
             v.setNext(head.getNext());
             head.setNext(v);
             added = true;
         } 
      } 
      return added;
   } 
   //return size of linked list
   public int size() { 
      if (head.getNext() == null) throw new IllegalStateException("This list is empty"); 
      Node curNode = head.getNext();
      int size = 0; 
      while(curNode != null) {
         size++; 
         curNode = curNode.getNext();
      }
      return size;
   }
   //check if linked list is empty
   public boolean isEmpty() {
      boolean isEmpty = false;
      if(head.getNext() == null) {
         isEmpty = true;
      }
      return isEmpty;
   }
   //calculates the average of the linkedlist
   public double average() {
      double counter = 0;
      double sum = 0;
      double num = 0;
      Node curNode = head.getNext();
      while(curNode != null) {
         num = (Double)curNode.getElement();
         sum += num;
         counter++;
         curNode = curNode.getNext();
      }
      return sum/counter;
   }
} 

