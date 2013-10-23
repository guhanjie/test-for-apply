package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {4,1,1,4,4,4,4,2,3,5};
//		ArrayList<ArrayList<Integer>> res = combinationSum2(num, 10);
//		System.out.println(res);
		Arrays.sort(num);
		ArrayList<Integer> tempList = new ArrayList<Integer>();
        combinationSum(num, 0, tempList, 10);
        System.out.println(resultArrayList);
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
		int sum = 0;
		ArrayList<ArrayList<Integer>> solsList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for(int i=0; i<newNum.length; i++) {
			for(int j=i; j<newNum.length; j++) {
				if(sum+newNum[j] > target) {
					
					while(testList.size() > 0) {
						
					}
					
					do {
						if(testList.isEmpty()) {
							break;
						}
						else {
							sum -= testList.get(testList.size()-1);
							testList.remove(testList.size()-1);
						}
					}while(target-sum < newNum[j]);
				}
				testList.add(newNum[j]);
				sum += newNum[j];
				if(sum == target) {
					ArrayList<Integer> solution = new ArrayList<Integer>();
					for(int number : testList) {
						solution.add(number);
					}
					boolean dump = false;
					for(ArrayList<Integer> compare : solsList) {
						if(compare.containsAll(solution) && (compare.size()==solution.size())) {
							int k=0;
							for(; k<compare.size(); k++) {
								if(compare.get(k) != solution.get(k)) {
									break;
								}
							}
							if(k == compare.size()) {
								dump = true;
								break;									
							}
						}
					}
					if(dump == false) {
						solsList.add(solution);
					}
				}
			}
			sum = 0;
			testList.clear();
		}
		return solsList;
    }
	
	private static ArrayList<ArrayList<Integer>> resultArrayList = new ArrayList<ArrayList<Integer>>();
	
	public static void combinationSum(int[] num, int idx, ArrayList<Integer> list, int target) {
		if(target == 0) {
			ArrayList<Integer> solution = new ArrayList<Integer>();
			for(int number : list) {
				solution.add(number);
			}
			resultArrayList.add(solution);
		}
		else {
			for(int i=idx; i<num.length; i++) {
				if(i!=idx && num[i]==num[i-1]) {
					continue;
				}
				if(target >= num[i]) {
					list.add(num[i]);
					combinationSum(num, i+1, list, target-num[i]);
					list.remove(list.size()-1);
				}
				else {
					break;
				}
			}
		}
	}

}
