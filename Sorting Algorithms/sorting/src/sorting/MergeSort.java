package sorting;

import java.util.Random;

public class MergeSort {

	
	    private int[] U;
	    private int[] S;

	    private int number;

	  

	    private void mergeSort(int low, int high) {
	        
	        if (low < high) {
	            
	            int middle = low + (high - low) / 2;
	            
	            mergeSort(low, middle);
	            
	            mergeSort(middle + 1, high);
	            
	            merge(low, middle, high);
	           
	          
	        }
	    }

	    private void merge(int low, int mid, int high) {

	    	
	        for (int i = low; i <= high; i++) {
	            S[i] = U[i];
	        }

	        int i = low, j = mid + 1, k = low;
	        
	        while (i <= mid && j <= high) {
	            if (S[i] <= S[j]) {
	                U[k] = S[i];
	                i++;
	            } else {
	                U[k] = S[j];
	                j++;
	            }
	            k++;
	        }
	        while (i <= mid) {
	            U[k] = S[i];
	            k++;
	            i++;
	        }

	    }
	    
	    public void sort(int[] values) {
	        this.U = values;
	        number = values.length;
	        this.S = new int[number];
	        mergeSort(0, number - 1);
	    }
	    
	    public static void print(int array[]) {
	        for(int i=0;i<array.length;i++)
	            System.out.print(array[i]+" ");
	        System.out.println();
	    }
	}

