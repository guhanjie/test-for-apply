package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 本测试用例用于测试List<Integer>如果remove方法
 * List有两个remove方法，remove(int index)和remove(Object o)
 * 对于List<Integer>，我调用remove(i)，系统到底调用的是哪一个方法呢？
 * @author gu
 *
 */
public class TestList_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		for(int i=250; i<260; i++) {
			list.add(i);
		}
		System.out.println(list);
		System.out.println("List.remove(5):\n"+list.remove(5)+"\t"+list);
//		System.out.println("List.remove(5):\n"+list.remove(255)+"\t"+list);
		System.out.println("List.remove(Integer.valueOf(5)):\n"+list.remove(Integer.valueOf(255))+"\t"+list);
		System.out.println("List.remove(new Integer(255)):\n"+list.remove(new Integer(255))+"\t"+list);
	}

}
