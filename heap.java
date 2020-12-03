import java.util.*;
public class heap {
	static int size=6;
	static int index=0;
	static void heapify(int[] array, int i) {
		int largest = i;
		
		int l= 2*i+1;
		int r= 2*i+2;
		
		if(l<size && array[l]>array[largest]) {
			largest=l;
		}
		
		if(r<size &&  array[r]>array[largest])
			largest=r;
		
		if(largest != i ) {
			int temp = array[i];
			array[i]=array[largest];
			array[largest]= temp;
			
			heapify(array,largest);	
		}
	}
	static void mheapify(int[] array, int i) {
		int lowest = i;
		
		int l= 2*i+1;
		int r= 2*i+2;
		
		if(l<size && array[l]<array[lowest]) {
			lowest=l;
		}
		
		if(r<size &&  array[r]<array[lowest])
			lowest=r;
		
		if(lowest != i ) {
			int temp = array[i];
			array[i]=array[lowest];
			array[lowest]= temp;
			
			heapify(array,lowest);	
		}
	}
	static void insert(int [] arr, int n) {
		int parent = (index-1)/2;
		//int left = 2*i+1;
		//int right = 2*i+2;
		arr[index]=n;
		int i = index;
		while(parent >=0 && arr[parent]<arr[i]) {
			int temp = arr[parent];
			arr[parent] = arr[i];
			arr[i]=temp;
			
			i = parent;
			parent = (i-1)/2; 
		}	
		index++;
	}
	
	static void delete(int[] arr) {
		int element = arr[0];
		arr[0]=arr[size-1];
		size= size-1;
		for(int i = 0; i<(arr.length/2)-1;i++)
			heapify(arr,0);
		System.out.println("Maximum element :"+element);
	}
	
	static void printArray(int[] arr) {
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int [] array = new int[6];
		int size = 6;
		insert(array,2);
		insert(array,4);
		insert(array,3);
		insert(array,7);
		insert(array,9);
		insert(array,10);
		
		printArray(array);
		delete(array);
		delete(array);
		delete(array);
		delete(array);
		delete(array);
		delete(array);
		printArray(array);

	}

}
