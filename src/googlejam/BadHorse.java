package googlejam;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BadHorse {
	/**
     * @param args
     */
    public static void main(String[] args) {
            int caseCount;
            List<Integer> lineCountList = new ArrayList<Integer>();
            Scanner in = null;
            BufferedWriter out = null;
    		try {
    			out = new BufferedWriter(new FileWriter("C:\\Users\\gu\\Downloads\\A-small-2-attempt2.out"));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
			try {
				in = new Scanner(new FileInputStream("C:\\Users\\gu\\Downloads\\A-small-2-attempt1.in"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            caseCount = in.nextInt();
            for(int i=0; i<caseCount; i++) {
                    int lineCount = in.nextInt();
                    in.nextLine();
                    lineCountList.add(lineCount);
                    List<String[]> inputList = new ArrayList<String[]>();
                    List<String> nameList = new ArrayList<String>();
                    for(int j=0; j<lineCount; j++) {
                            String str[] = in.nextLine().split(" ");
                            inputList.add(str);
                            if(!nameList.contains(str[0]))
                                    nameList.add(str[0]);
                            if(!nameList.contains(str[1]))
                                    nameList.add(str[1]);
                    }
                    //build troublesome relation
                    int nameCount = nameList.size();
                    char [][]trouble = new char[nameCount][nameCount];
                    for(int k=0; k<inputList.size(); k++) {
                            String[] pair = inputList.get(k);
                            int index1 = nameList.indexOf(pair[0]);
                            int index2 = nameList.indexOf(pair[1]);
                            trouble[index1][index2] = 1;
                            trouble[index2][index1] = 1;
                    }
                    //juede whether can seperate into two leagues
                    int m=0;
                    for(m=0; m<nameCount; m++) {
                            List<Integer> troubleMems = new ArrayList<Integer>(); 
                            for(int n=0; n<nameCount; n++) {
                                    if(trouble[m][n] == 1) {
                                            troubleMems.add(n);
                                    }
                            }
                            //judge whether the MemsList conflicts
                            if(!canConExist(trouble,troubleMems)) {
                                    break;
                            }                                      
                    }
                    try {
	                    if(m == nameCount) 
	                    	out.write("#Case "+(i+1)+": Yes");
						else
							out.write("#Case "+(i+1)+": No");
	                    out.write("\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            }
            in.close();
            try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    
    public static boolean canConExist(char [][]trouble, List<Integer> troubleMems) {
            int memSize = troubleMems.size();
            for(int i=0; i<memSize; i++) {
                    int index1 = troubleMems.get(i);
                    for(int j=i+1; j<memSize; j++) {
                            int index2 = troubleMems.get(j);
                            if(trouble[index1][index2] == 1)
                                    return false;
                    }
            }
            return true;
    }
}
