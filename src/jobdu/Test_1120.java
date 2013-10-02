package jobdu;
import java.util.*;

public class Test_1120{	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String str = in.nextLine();
			Character[] array = new Character[str.length()];
			for(int i=0; i<str.length(); i++) {
				array[i] = str.charAt(i);
			}
			List<Character> list = new ArrayList<Character>();
			fullSort(list, array, 0);
		}
	}
	
	public static void fullSort(List<Character>list, Character[] array, int pos) {
		if(pos<array.length) {
			for(int i=0; i<array.length; i++) {
				if(!list.contains(array[i])) {
					list.add(array[i]);
					fullSort(list, array, pos+1);
					list.remove(list.size()-1);
				}
			}
		}
		else {
			StringBuffer s = new StringBuffer();
	        for(Character m : list) {
	             s.append(m);
	        }
	        System.out.println(s.toString());
        }
	}
}