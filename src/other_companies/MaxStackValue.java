package other_companies;


/**
 * Ģ���ֵ�һ�������㷨�⣺
 * ��һ֧��Ʊ��������Դ�Խ��֪������ÿ���Ʊ�۸�����ѡ��һ�����룬һ��������ʹ�������
 * @author gu
 *
 */
public class MaxStackValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {4,5,5,7,15,3,1,2,13,4};
		chooseMaxMin5(values);
	}
	
	/**
	 * �����⣬�㷨����
	 * @param values
	 */
	public static void chooseMaxMin(int[] values) {
		int low = 0, high = values.length-1;
		int min = low;
		int max = high;
		int maxValue = values[high]-values[low];
		for(low++, high--; low<high; ) {
			if(values[low]<values[min]) {
				maxValue += values[min] - values[low];
				min = low;
				low++;
			}
			if(values[high]>values[max]) {
				maxValue += values[high] - values[max];
				max = high;
				high--;
			}
			if(values[low]<=values[max]||maxValue>=(values[low]-values[min])) {
				low++;
			}
			if(values[high]>=values[min]||maxValue>=(values[max]-values[high])) {
				high--;
			}
		}
		System.out.println("����۸�"+values[min]+"�����۸�"+values[max]+"�������"+maxValue);
	}
	
	/**
	 * ��ȷ������ʱ�临�Ӷ��е��
	 * @param values
	 */
	public static void chooseMaxMin2(int[] values) {
		int min=0,max=0;
		int maxValue = Integer.MIN_VALUE;
		for(int i=1; i<values.length; i++) {
			min=Integer.MAX_VALUE;
			max=Integer.MIN_VALUE;
			for(int j=0; j<i; j++) {
				if(values[j]<min)
					min = values[j];
			}
			for(int k=i; k<values.length; k++) {
				if(values[k]>max)
					max = values[k];
			}
			if(max-min>maxValue)
				maxValue = max-min;
		}
		System.out.println("�������"+maxValue);
	}
	
	/**
	 * �㷨��ȷ������ʱ�临�Ӷ�ò�ƻ������
	 * @param values
	 */
	public static void chooseMaxMin3(int[] values) {
		int min=Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;
		for(int i=0; i<values.length-1; i++)
			if(values[i]<min) {
				min = values[i];
				for(int j=i+1; j<values.length; j++) {
					if(values[j]-min > maxValue)
						maxValue = values[j]-min;
				}				
			}
		System.out.println("����۸�"+min+"�������"+maxValue);
	}
	
	/**
	 * �㷨��ȷ��ʱ�临�Ӷ��϶�3������һЩ�Ľ�����ס��max��λ��
	 * @param values
	 */
	public static void chooseMaxMin4(int[] values) {
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		int maxPosition = 0;
		int maxValue=Integer.MIN_VALUE;
		for(int i=0; i<values.length-1; i++)
			if(values[i]<min) {
				min = values[i];
				if(i>=maxPosition) {
					max=Integer.MIN_VALUE;
					for(int j=i+1; j<values.length; j++)
						if(values[j]>max) {
							max = values[j];
							maxPosition = j;
						}
				}
				if(max-min > maxValue)
					maxValue = max-min;
			}
		System.out.println("����۸�"+min+"�������"+maxValue);
	}
	
	/**
	 * �㷨��ȷ�������ѵ��㷨��ʱ�临�Ӷ���ΪO(N)
	 * �����Ԫ�ؼ�ȥǰ���Ԫ��
	 * ���������Ϊ���ڳ���Ʊ������۸�������۸�������ӯ������
	 * Ҫ��O(N)ʱ�临�Ӷȣ�O(1)�ռ临�Ӷ� 
	 * ˼·�����ȴӰ�������Ԫ�ص����鿪ʼ�������⣬
	 * �������������Ԫ�ص��������ˣ���ô��һ���µ�Ԫ�ػ����ʲôӰ�죿Ҫ�ı���Щֵ��
	 * ÿ�ζ����һ��Ԫ�أ�ÿ�ζ�����Щ���ܵĸı俼�ǽ������������������������������ʱ������ͽ���ˡ�
	 * �����ܽ᣺
	 * ��ʵ�ҵ��뷨�Ѿ��ǳ��ӽ�����ˣ�ֻ�������ǿ����˶��������ͷ����ȥ��������β��max��
	 * ������㷨���Ҹ����ĵط����ڣ�������������ȥ����֮ǰ������min��
	 * @param values
	 */
	public static void chooseMaxMin5(int[] values) {
		int maxValue = values[1] - values[0];
		int min = values[0];
		for(int i=2; i<values.length; i++) {
			if(values[i-1] < min) {
				min = values[i-1];
			}
			if(values[i]-min > maxValue) {
				maxValue = values[i]-min;
			}
		}		
		System.out.println("����۸�"+min+"�������"+maxValue);
	}
}
