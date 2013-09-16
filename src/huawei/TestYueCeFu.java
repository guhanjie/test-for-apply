package huawei;

import java.util.ArrayList;
import java.util.List;

public class TestYueCeFu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<10; i++) {
			list.add(i);
		}
		System.out.println(list);
		cycleCal(list, 5, 0);
//		for(int i=1, pos=0; list.size()>0; i++) {
//			if(i==5) {
//				System.out.print(list.get(pos));
//				list.remove(pos);
//				i = 0;
//				pos--;
//			}
//			if(list.size() != 0) 
//				pos = (pos+1)%list.size();
//		}
	}
	
	public static void cycleCal(List list, int m, int pos) {
		if(list.size() != 0) {
			for(int count=1; count<m; count++) {
				pos = (pos+1)%list.size();
			}
			System.out.print(list.get(pos)+" ");
			list.remove(pos);
			cycleCal(list, m, pos);
		}
	}

}
