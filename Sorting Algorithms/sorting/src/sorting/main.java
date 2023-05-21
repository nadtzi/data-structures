package sorting;

import java.util.Random;

public class main {
	public static void main(String[] args) {
		

		   Random rd = new Random(); 
		      int[] array1 = new int[10000];
		      for (int i = 0; i < array1.length; i++) {
		         array1[i] = rd.nextInt(10000); 
		      //  System.out.println(array1[i]);
		      }
		
		
    MergeSort sorter = new MergeSort();
    long startTime = System.nanoTime();
    sorter.sort(array1);
    long stopTime = System.nanoTime();
  // print(array1);
  
    long elapsedTime = stopTime - startTime;
    System.out.println("Time required for Mergesort " + elapsedTime + " Nano Seconds");

    //Exchange Sort
    

    int[] array2 = new int[10000];
    for (int i = 0; i < array2.length; i++) {
       array2[i] = rd.nextInt(10000); 
      //System.out.println(array2[i]);
    }
   // System.out.print("Array before Exchange sort: ");
    //print(array2); 
    startTime=System.nanoTime();
  
    exchangeSort(array2);
    
    stopTime=System.nanoTime();
   // System.out.print("Array after Exchange sort: ");
    //print(array2);
    System.out.println("Time required for Exchange sort: "+(stopTime-startTime)+" nano seconds");
}
	

	
	//Exchange Sort implementation
public static void exchangeSort(int[] arr) {
	   
    for (int i = 0; i < arr.length - 1; i++) {
    	
       for (int j = i + 1; j < arr.length; j++) {
    	
          if (arr[i] > arr[j]) {
             int temp = arr[i];
             arr[i] = arr[j];
             arr[j] = temp;
         
          }
       }
      }
 }
	  public static void print(int array[]) {
	       for(int i=0;i<array.length;i++)
	           System.out.print(array[i]+" ");
	       System.out.println();
	   }
	  
}