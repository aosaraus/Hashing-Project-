public class BucketArray {
   private int tableSize;
   private int collisions = 0;
   BucketList[] table;

   //constructor for BucketArray. fills in each slot of array with empty linkedlist    
   public BucketArray(int size) {
      table = new BucketList[size];
      for (int i= 0; i < size; i++) {
         table[i] = new BucketList(); 
      }
   }
   
   public BucketList[] getArray() {
      return table;
   }
   //gets specific array 
   public BucketList getSlot(int key) {
      return table[key];
   }
   //returns size of array 
   public int getSize(){
      return tableSize;
   }
   //set size of array 
   public void setSize(int size) {
      tableSize = size;
   }
   //adds the entries into the array 
   public void addPair(int key, double score) {
      if(table[key].isEmpty() != true){
         collisions++;
      }
      table[key].addElement(score);
   }
   //returns the collisions
   public int collisions() {
      return collisions;
   }
   //calculates the max average
   public double maxAverage() {
      double max = 0;
      double tempMax = 0;
      for(int i = 0; i < tableSize; i++)
      {
         tempMax = table[i].average();
         if (tempMax > max) {
            max = tempMax;
         }
      }
      return max;
   }
   //calculates the min average
   public double minAverage() {
      double min = 10000000;
      double tempMin = 0;
      for(int i = 0; i < tableSize; i++) {
         tempMin = table[i].average();
         if (tempMin < min) {
            min = tempMin;
         }
      }
      return min;
   }
}
  
