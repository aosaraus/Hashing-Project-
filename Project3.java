import java.io.*;
import java.util.*;

class Project3 {
  public static void main(String[] args) throws IOException {
    //created to use methods in this class
    Project3 tool = new Project3(); 
    if (args.length < 1) {
        System.out.println("Error: Directory name is missing");
        System.out.println("Usage: java scoreProcess directory_name");
        return;
    }
    int size = 32;
    File directory = new File(args[0]); // args[0] contains the directory name
    File[] files = directory.listFiles(); // get the list of files from that directory

    File file;
    int fileLength = files.length;
    Scanner counter;
    Scanner input;
    
    BucketArray a = new BucketArray(size);
    a.setSize(size);
    // process the arguments stores in args
    for (int i = 0; i < files.length; i++) {
      input = new Scanner(files[i]);

      System.out.println("\nCurrent file name: " + files[i].getName());
      
      // no error checking done here, add your own
      String key;
      Double value;
      while (input.hasNext())
      {
      	key = "";
      	while (!input.hasNextDouble()){
      		key += input.next() + " ";
      	}
	// remove the last space
        key = key.replaceAll("\\s+$", "");	
      	value = new Double(input.next());
      	System.out.println("Key: " + key + " Value: " + value);
      	// #### insert the (key, value) pair into your hash table
        int index = tool.hashKey(key, a);
        a.addPair(index, value);
        
      }
    }
      System.out.println("# of collisions: " + a.collisions());
      System.out.println("Minimum Average: " + a.minAverage());
      System.out.println("Maximum Average: " + a.maxAverage());
      tool.askUser(a);
  }
   //hashes the key
   public int hashKey(String key, BucketArray a){
      int newKey = 0;
      char c;
      for (int i = 0; i < key.length(); i++) {
         newKey = ( 31 * newKey + key.charAt(i)) % a.getSize();
      }
      return newKey;
   }
   //this method asks the user for a key
   public void askUser(BucketArray a) {
      Scanner kb = new Scanner(System.in);
      System.out.print("Enter Name: ");
      String key = kb.nextLine();
      int index = hashKey(key, a);
      double average = a.getSlot(index).average();
      System.out.println("Key: Avg: " + average);
   } 
     
}
