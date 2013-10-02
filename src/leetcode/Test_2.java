package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {5,3,2,1,45,2,332,4,34,3};
		combinationSum2(num, 5);
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        List<Integer> tempList = new ArrayList<Integer>();
		for(int i=0; i<num.length; i++) {
        	if(num[i] <= target) {
        		tempList.add(num[i]);
        	}
        }
		Integer[] newNum = tempList.toArray(new Integer[tempList.size()]);
		Arrays.sort(newNum);
		for(int i=0; i<newNum.length; i++) {
			List<Integer> testList = new ArrayList<Integer>();
			for(int j=i+1; j<newNum.length && ; j++) {
				
			}
		}
    }

}
