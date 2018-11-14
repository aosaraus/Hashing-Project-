public class Node {
   private Object element; 
   private Node next;
   
   public Node(Object object, Node n) {
      element = object;
      next = n;
   }
  
   public Object getElement() {
      return element;
   }
   
   public Node getNext() {
      return next; 
   }
 
   public void setElement(Object newE) {
      element = newE;
   }
 
   public void setNext(Node newN) {
      next = newN;
   }
}
