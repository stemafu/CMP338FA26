
public class SelectionSort {
	
	public static void selectionSort(int [] nums) {
		
		/*
		 * We can think of i as the front of the unsorted subarray
		 */
		for(int i = 0; i < nums.length - 1; i++) {
			
			/*Assume that the smallest element is the front of the'
			unsorted subarray
			*/
			int indexOfSmallest = i;
			
			/*
			 * We will add a nest loop here that we will use to
			 * search for the smallest element in the unsorted 
			 * subarray.
			 */
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[j] < nums[indexOfSmallest]) {
					indexOfSmallest = j;
				}
			}
			
			
			/* Once we find the smallest element, we swap
			 */
			int temp = nums[indexOfSmallest];
			nums[indexOfSmallest] = nums[i];
			nums[i] = temp;
			
		}
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
