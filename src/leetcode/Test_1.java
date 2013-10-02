package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Remove Duplicates from Sorted Array AC Rate: 124/290 My Submissions
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
 * @author gu
 *
 */
public class Test_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String string = in.nextLine();
			Integer[] A = new Integer[string.length()];
			for(int i=0; i<string.length(); i++) {
				A[i] = string.charAt(i)-48;
			}
			int length = removeDuplicates(A);				
			System.out.println("Length="+length+"\n"+Arrays.asList(A));
		}
	}
	
    public static int removeDuplicates(Integer[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int length = A.length;
        for(int i=0; i<length; i++) {
        	int now = A[i];
        	for(int j=i+1; j<length; j++) {
        		if(now == A[j]) {
        			for(int k=j+1; k<length; k++) {
        				A[k-1] = A[k];
        			}
        			length--;
        			j--;
        		}
        	}
        }
        return length;
    }

}
