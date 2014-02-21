package googlejam;
/*Test SVN*/
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String[]> pairs = new ArrayList<String[]>();
		List<Integer> lineCountList = new ArrayList<Integer>();
		List<String> league1 = new ArrayList<String>();
		List<String> league2 = new ArrayList<String>();
		
		Scanner in = null;
		try {
			in = new Scanner(new FileInputStream("C:\\Users\\gu\\Downloads\\A-small-2-attempt1.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int caseCount = in.nextInt();
		for(int j=0; j<caseCount; j++) {
			lineCountList.add(in.nextInt());
			in.nextLine();
			for(int count=0; count<lineCountList.get(j); count++) {
				String line = in.nextLine();
				String[] pair = line.split(" ");
				pairs.add(pair);
			}
		}
		in.close();
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("C:\\Users\\gu\\Downloads\\A-small-2-attempt1.out"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int j=0; j<caseCount; j++) {
			int lineCount = lineCountList.get(j);
			league1.clear();
			league2.clear();
//			int i=0;
//			for(i=0; i<pairs.size(); i++){
//				String[] pair = pairs.get(i);
//				if((join(league1, pair[0], pairs, lineCount)&&join(league2, pair[1], pairs, lineCount))
//						|| (join(league1, pair[1], pairs, lineCount)&&join(league2, pair[0], pairs, lineCount)))
//					continue;
//				else 
//					break;
//			}
			StringBuffer sb = new StringBuffer("Case #");
			sb.append(j+1).append(": ");
//			if(i < pairs.size())
			if(seprate(league1, league2, pairs, 0, lineCount)) {
				sb.append("Yes");
			}
			else {
				sb.append("No");
			}
			try {
				out.write(sb.toString());
				out.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int k=0; k<lineCount; k++) {
				pairs.remove(0);
			}
//			System.out.println("Testcase "+(j+1));
//			System.out.println("League1:"+league1);
//			System.out.println("League2:"+league2);
//			System.out.println("+++++++++++++++++++++++++++++++++");
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * judge whether str can join league
	 * @param league
	 * @param str
	 * @param pairs
	 * @return
	 */
	public static boolean join(List<String> league, String str, List<String[]> pairs, int count) {
		//判断该联盟是否已存在该值,若不存在，需要判断该联盟中所有节点与该值是否troublesome
		if(!league.contains(str)) {
			int i=0;
			for(i=0; i<league.size(); i++) {
				String mem = league.get(i);
				int j=0;
				for(j=0; j<count; j++) {
					String[] pair = pairs.get(j);
					//判断mem是否与str冲突
					if((pair[0].equals(mem) && pair[1].equals(str)) 
							|| (pair[0].equals(str) && pair[1].equals(mem)))
						return false;
				}
			}
//			league.add(str);
		}
		return true;
	}
	
	public static boolean seprate(List<String> league1, List<String> league2, List<String[]> pairs, int index, int lineCount) {
		if(index == lineCount) {
			return true;
		}
		String[] pair = pairs.get(index);
		if(join(league1, pair[0], pairs, lineCount)&&join(league2, pair[1], pairs, lineCount)) {
			league1.add(pair[0]);
			league2.add(pair[1]);
			if(seprate(league1, league2, pairs, index+1, lineCount)) {
				return true;
			}
			league1.remove(pair[0]);
			league2.remove(pair[1]);
		}
		if(join(league1, pair[1], pairs, lineCount)&&join(league2, pair[0], pairs, lineCount)) {
			league1.add(pair[1]);
			league2.add(pair[0]);
			if(seprate(league1, league2, pairs, index+1, lineCount)) {	
				return true;
			}				
			league1.remove(pair[1]);
			league2.remove(pair[0]);
		}
		return false;
	}
}
