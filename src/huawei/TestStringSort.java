package huawei;

/**
 * 2013��9��8��15:29:02
 * ��Ϊ�Ļ����⣺
 * ��һ��ȫΪСд���ַ�����Ҫ���ַ������ո���ָ��ɶ�����ʣ��Ե��ʰ��ֵ�����
 * Ȼ������˳����������ĸ����ʡ�
 * ���ӣ�
 * ���룺i am a good boy
 * �����a am boy good i
 * ����ʱ���Լ�����һ���ݹ麯����������⣬ͦ���ӵģ�
 * �����������룬����ֱ����java�������sort�����ֵ�����sort�����ǳ�ǿ��
 * ��������1����Сʱ�����µ�����û���������Ժ�һ��Ҫ����java��ϵͳ������ͷ����������߹���Ч��
 */

import java.util.Scanner;

public class TestStringSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] words = scanner.nextLine().split(" ");
		
//		//����һ��ֱ��Ӧ��java���߰�
////		List<String> list = Arrays.asList(words);
//		Arrays.sort(words, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);		//o1��ǰ�򷵻ظ���
//			}
//		});
		
		//������������String.compareTo()�����ߴ�С��Ȼ����ð�����������������
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
//		//���꣺Arrays.sort()�����ǳ�ǿ�󣬿��Դ�������������͵����ݣ�������������
//		//����Arrays.sort()�⣬Collection��Ҳ��sort����
//		//���ߵ�����Arrays.sort()��������������Collection.sort()����Լ��ϵ�����
//		Integer a[] = new Integer[]{10,65,12,53,100};
//		Arrays.sort(a);
//		List<Integer> lll = Arrays.asList(a);
//		System.out.println(lll);
	}
}
