
public class BubbleSort {
	
	
	public static void bubbleSort(int [] nums) {
		
		
		for(int i = 0; i < (nums.length  - 1); i++) {
			
			/* We need another loop that will be used to 
			 * compare and swap adjacent values
			 */
			for(int j = 0; j < (nums.length - 1 - i); j++) {
				
				/*
				 * this where we compare and swap if necessary
				 */
				
				
				if(nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					
				}
				
				
			}
			
			
		
		}
		
		
	}
	
	public static void display(int [] nums) {
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public static void main(String[] args) {
		
		
		int [] nums = {3, 2, 17, 9, 44, 25, 1, 100};
		bubbleSort(nums);
		display(nums);
		

	}

}
