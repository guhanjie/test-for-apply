package test;

/**
 * 易宝支付公司面试题：
 * 给一个候选字集，要求给出所有的组合，用于暴力破解
 * 如：
 * 给出集合：{1，2，3，4}
 * 结果：
 * 1111，1112，1113，1114，1121，1122，1123，1124，...
 */
import java.util.ArrayList;
import java.util.List;

public class FullSort {

	private static List<Integer> tempL = new ArrayList<Integer>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4};
		List<List<Integer>> L = new ArrayList<List<Integer>>();
		fullSort(a, L);
		System.out.println(L);
	}
	
	public static void fullSort(int[] a, List<List<Integer>> L) {
		if(tempL.size() == a.length) {
			List<Integer> recordL = new ArrayList<Integer>();
			for(Integer t : tempL) {
				recordL.add(t);
			}
			L.add(recordL);
			return;
		}
		for(int i=0; i<a.length; i++) {
			tempL.add(a[i]);
			fullSort(a, L);
			tempL.remove(tempL.size()-1);
		}
	}

}
