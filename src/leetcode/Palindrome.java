package leetcode;

import java.util.Scanner;

public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String string = in.nextLine();
			System.out.println(getLongestPalindrome(string));
		}
	}
	
	public static String getLongestPalindrome(String str) {
		String reString = str;
		int length = str.length();
		int longestCnt = 1;
		for(int i=0; i<length; i++) {
			for(int j=length-1; j>i; j--) {
				int front = i;
				int end = j;
				for(; front<end; front++,end--) {
					if(str.charAt(front) != str.charAt(end))
						break;
				}
				if(front>=end && longestCnt<j-i+1) {
					longestCnt = j-i+1;
					reString = str.substring(i, j+1);
				}
			}
		}
		System.out.println("最长子串长度为"+longestCnt);
		return reString;
	}

}
