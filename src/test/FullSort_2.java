package test;

/**
 * 实现全排列：
 * 如给出{1，2，3}
 * 输出：
 * 123，132，213，231，312，321
 */
import java.util.ArrayList;
import java.util.List;

public class FullSort_2 {
	
	public static void main(String[] args) {
		Integer[] array = new Integer[]{1,2,3};
		List<Integer> list = new ArrayList<Integer>();
		fullSort(list, array, 0);
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
			System.out.println(list);
	}
}
