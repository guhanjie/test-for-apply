package googlejam;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Read_PhoneNum {
	
	public static String[] NUM = {	"zero ", 
									"one ", 
									"two ",
									"three ",
									"four ",
									"five ",
									"six ",
									"seven ",
									"eight ",
									"nine "};
	public static String[] COUNT = { "","", 
									"double ",
									"triple ",
									"quadruple ",
									"quintuple ",
									"sextuple ",
									"septuple ",
									"octuple ",
									"nonuple ",
									"decuple "};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new FileInputStream("C:\\Users\\gu\\Downloads\\A-large.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\gu\\Downloads\\A-large.out")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int caseCount;
        caseCount = in.nextInt();
		for(int i=1; i<=caseCount; i++) {
			StringBuffer phoneNum = new StringBuffer(in.next());
			String formate = in.next();
//			System.out.println(phoneNum +"---" +formate);
			String[] splitNum = formate.split("-");
			StringBuffer[] splits = new StringBuffer[splitNum.length];
			for(int j=0; j<splitNum.length; j++) {
				int count = Integer.valueOf(splitNum[j]);
				StringBuffer splitStr = new StringBuffer();
				for(int k=0; k<count; k++) {
					splitStr.append(phoneNum.charAt(0));
					phoneNum.deleteCharAt(0);
				}
				splits[j]=splitStr;
//				int start = (j==0) ? 0: Integer.valueOf(splitNum[j-1]);
//				int end = (j==splitNum.length-1)?phoneNum.length():Integer.valueOf(splitNum[j]);
//				splitStr[j] = phoneNum.substring(start, end);
			}
			StringBuffer output = new StringBuffer("Case #"+i+": ");
			for(StringBuffer str : splits) {
				int index = 0;
				int count;
				int j;
				while(index<str.length()) {
					int num = str.charAt(index)-48;
					for(j=index+1; j<str.length(); j++) {
						if(num != (str.charAt(j)-48)) {
							break;
						}
					}
					count = j-index;
					if(count == 11) {
						while(count-->0) {
							output.append(NUM[num]);
						}
						break;
					}
					index = j;
					output.append(COUNT[count]+NUM[num]);
				}
			}
			output.deleteCharAt(output.length()-1);
			out.println(output.toString());
		}
		in.close();
		out.close();
	}

}
