package googlejam;

import java.util.ArrayList;
import java.util.List;

public class Main3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		String string = "Hello";
		list.add(string);
		if(!list.contains(string))
			list.add(string);
		System.out.println(list);
	}

}
