package jobdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test_1009_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		in.nextLine();
		String str = in.nextLine();
		List<Integer> initalArray = new ArrayList<Integer>();
		inputArray(initalArray, str);
		List<List<Integer>> testList = new ArrayList<List<Integer>>();
		String compareStr = in.nextLine();
		while(!compareStr.equals("0")) {
			List<Integer> compareArray = new ArrayList<Integer>();
			inputArray(compareArray, compareStr);
			testList.add(compareArray);
			compareStr = in.nextLine();
		}
		for(int i=0; i<testList.size(); i++) {
			System.out.println(compare(initalArray, testList.get(i))?"YES":"NO");
		}
	}
	
	public static void inputArray(List<Integer> array, String str) {
		for(int i=0; i<str.length(); i++) {
			array.add(str.charAt(i)-48);
		}
	}
	
	public static boolean compare(List<Integer> initalArray, List<Integer> compareArray) {
		for(int pos=0; pos<initalArray.size(); pos++) {
			int now = compareArray.get(pos);
			List<Integer> largerList = new ArrayList<Integer>();
			List<Integer> smallerList = new ArrayList<Integer>();
			for(int i=pos+1; i<compareArray.size(); i++) {
				int data = compareArray.get(i);
				if(data>now && compareArray.indexOf(data)<compareArray.indexOf(data+1)) {
					largerList.add(data);
				}
				else if(data<now && compareArray.indexOf(data-1)<compareArray.indexOf(data)) {
					smallerList.add(data);
				}
			}
			int index = initalArray.indexOf(now);
			for(int i=index+1; i<initalArray.size(); i++) {
				int data = initalArray.get(i);
				if(data>now && initalArray.indexOf(data)<initalArray.indexOf(data+1)) {
					if(!largerList.contains(data)) {
						return false;
					}
				}
				else if(data<now && initalArray.indexOf(data-1)<initalArray.indexOf(data)) {
					if(!smallerList.contains(data)) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
