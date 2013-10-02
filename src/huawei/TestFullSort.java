package huawei;

import java.util.ArrayList;
import java.util.List;

public class TestFullSort {
	
	public static int i = 0;
	
	public static void main(String[] args) {
		Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9};
		List<Integer> list = new ArrayList<Integer>();
//		fullSort(list, array, 0);
		System.out.println(getPermutation(9, 123141));
	}
	
	public static void fullSort(List<Integer>list, Integer[] array, int pos) {
		if(pos<array.length) {
			for(int i=0; i<array.length; i++) {
				if(!list.contains(array[i])) {
					list.add(array[i]);
					fullSort(list, array, pos+1);
					list.remove(list.size()-1);
				}
			}
		}
		else
			System.out.println(++i+"--->"+list);		
	}
	
	public static String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Integer[] array = new Integer[n];
        for(int i=0; i<n; i++) {
            array[i] = i+1;
        }
        List<Integer> list = new ArrayList<Integer>();
        List<String> resList = new ArrayList<String>();
		fullSort(list, array, 0, resList);
		return resList.get(k-1);
    }
    
    public static void fullSort(List<Integer>list, Integer[] array, int pos, List<String> resList) {
		if(pos<array.length) {
			for(int i=0; i<array.length; i++) {
				if(!list.contains(array[i])) {
					list.add(array[i]);
					fullSort(list, array, pos+1, resList);
					list.remove(list.size()-1);
				}
			}
		}
		else {
		    StringBuffer s = new StringBuffer();
		    for(Integer m : list) {
		        s.append(""+m);
		    }
		    resList.add(s.toString());
		}
	}
}
