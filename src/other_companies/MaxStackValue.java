package other_companies;


/**
 * 蘑菇街的一条笔试算法题：
 * 有一支股票，假如可以穿越，知道它的每天股票价格，让你选择一天买入，一天卖出，使获利最大！
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
	 * 有问题，算法有误
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
		System.out.println("买入价格："+values[min]+"卖出价格："+values[max]+"获利最大："+maxValue);
	}
	
	/**
	 * 正确，但是时间复杂度有点高
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
		System.out.println("获利最大："+maxValue);
	}
	
	/**
	 * 算法正确，但是时间复杂度貌似还能提高
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
		System.out.println("买入价格："+min+"获利最大："+maxValue);
	}
	
	/**
	 * 算法正确，时间复杂度上对3进行了一些改进，记住了max的位置
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
		System.out.println("买入价格："+min+"获利最大："+maxValue);
	}
	
	/**
	 * 算法正确，网上搜的算法，时间复杂度上为O(N)
	 * 后面的元素减去前面的元素
	 * （你可以认为你在炒股票，买入价格和卖出价格就是你的盈利），
	 * 要求：O(N)时间复杂度，O(1)空间复杂度 
	 * 思路：首先从包含两个元素的数组开始考虑问题，
	 * 当这个包含两个元素的问题解决了，那么加一个新的元素会造成什么影响？要改变哪些值？
	 * 每次都添加一个元素，每次都将这些可能的改变考虑进来，这样就能做到遍历整个数组的时候，问题就解决了。
	 * 自我总结：
	 * 其实我的想法已经非常接近这个了，只不过我是考虑了定下买进（头），去找卖出（尾）max；
	 * 而这个算法比我高明的地方在于：它定下卖出，去卖出之前找买入min。
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
		System.out.println("买入价格："+min+"获利最大："+maxValue);
	}
}
