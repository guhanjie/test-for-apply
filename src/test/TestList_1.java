package test;

import java.util.ArrayList;
import java.util.List;

/**
 * �������������ڲ���List<Integer>���remove����
 * List������remove������remove(int index)��remove(Object o)
 * ����List<Integer>���ҵ���remove(i)��ϵͳ���׵��õ�����һ�������أ�
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
