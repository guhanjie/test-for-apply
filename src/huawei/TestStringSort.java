package huawei;

/**
 * 2013年9月8日15:29:02
 * 华为的机试题：
 * 给一个全为小写的字符串，要求将字符串按空格符分隔成多个单词，对单词按字典排序，
 * 然后依次顺序输出排序后的各单词。
 * 例子：
 * 输入：i am a good boy
 * 输出：a am boy good i
 * 考试时我自己用了一个递归函数解决该问题，挺复杂的！
 * 后来回来想想，可以直接用java工具类的sort进行字典排序（sort方法非常强大）
 * 花费了我1个多小时，导致第三题没做出来，以后一定要留心java的系统工具类和方法，大大提高工作效率
 */

import java.util.Scanner;

public class TestStringSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] words = scanner.nextLine().split(" ");
		
//		//方法一：直接应用java工具包
////		List<String> list = Arrays.asList(words);
//		Arrays.sort(words, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);		//o1在前则返回负数
//			}
//		});
		
		//方法二：利用String.compareTo()比两者大小，然后用冒泡排序进行数组重排
		for(int i=0; i<words.length-1; i++) {
			int k = i;
			for(int j=i+1; j<words.length; j++) {
				if(words[k].compareTo(words[j])>0) {
					k = j;
				}
			}
			if(k != i) {
				String temp = words[i];
				words[i] = words[k];
				words[k] = temp;
			}
		}
		for(int i=0; i<words.length; i++) {
			System.out.println(words[i]);
		}
//		//引申：Arrays.sort()方法非常强大，可以处理多种数据类型的数据，完成数组的排序
//		//除了Arrays.sort()外，Collection类也有sort方法
//		//两者的区别，Arrays.sort()是针对数组的排序，Collection.sort()是针对集合的排序
//		Integer a[] = new Integer[]{10,65,12,53,100};
//		Arrays.sort(a);
//		List<Integer> lll = Arrays.asList(a);
//		System.out.println(lll);
	}
}
