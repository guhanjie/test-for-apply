package googlejam;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Sorting {

	public static int not = -10000000;
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			Scanner in = null;
			try {
				in = new Scanner(new FileInputStream("C:\\Users\\gu\\Downloads\\C-large.in"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter out = null;
			try {
				out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\gu\\Downloads\\C-large.out")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int caseCount;
	        caseCount = in.nextInt();
			for(int i=1; i<=caseCount; i++) {
				int numCount = in.nextInt();
				int[] seq = new int[numCount];
				LinkedList<Integer> sortList = new LinkedList<Integer>();
				for(int j=0; j<numCount; j++) {
					int num = in.nextInt();
					if(num%2!=0) {		//odd value
						seq[j] = not;
						sortList.add(num);
					}
					else {
						seq[j] = num;
					}
				}
				Collections.sort(sortList);
				for(int j=0; !sortList.isEmpty()&&j<numCount; j++) {
					if(seq[j]==not) {		//odd value
						seq[j] = sortList.getFirst();
						sortList.removeFirst();
					}
					else {
						sortList.addLast(seq[j]);
						seq[j] = not;
					}
				}
				Collections.sort(sortList);
				for(int j=0; !sortList.isEmpty()&&j<numCount; j++) {
					if(seq[j]==not) {		//even value
						seq[j] = sortList.getLast();
						sortList.removeLast();
					}
				}
				StringBuffer output = new StringBuffer("Case #"+i+": ");
				for(int num : seq) {
					output.append(num);
					output.append(" ");
				}
				output.deleteCharAt(output.length()-1);
				out.println(output.toString());
			}
			in.close();
			out.close();
		}

	}
