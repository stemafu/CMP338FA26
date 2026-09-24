
public class InsertionSort {
	
	/*
	 * With insertion sort we assume that the first element in the 
	 * array is the sort sublist.
	 */
	public static void insertionSort(int [] nums) {
		
		for(int i = 1; i < nums.length; i++) {
			
			int j = i; // Taking an element in front of the unsorted subarray
			
			
			while(j > 0 && nums[j] < nums[j - 1]) {
				
				int temp = nums[j];
				nums[j] = nums[j - 1];
				nums[j - 1] = temp;
				
				j--; // This helps with moving the smallest value to its correct position
			}
			
			
			
		}
	}
	
	public static void main(String [] args) {
		
		
	}

}
