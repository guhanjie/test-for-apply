package test;

/**
 * java��ĳ�Ա��ʼ��˳��ͳ�ʼ����֪ʶ
 * @author gu
 * ���ԡ����������췽�������ɿ鶼�����еĳ�Ա���ڴ�����Ķ���ʱ�����и���Ա��ִ��˳��
 *	1.���ྲ̬��Ա�;�̬��ʼ���죬���ڴ����г��ֵ�˳������ִ�С�
 *	2.���ྲ̬��Ա�;�̬��ʼ���飬���ڴ����г��ֵ�˳������ִ�С�
 *	3. �����ʵ����Ա��ʵ����ʼ���飬���ڴ����г��ֵ�˳������ִ�С�
 *	4.ִ�и���Ĺ��췽����
 *	5.����ʵ����Ա��ʵ����ʼ���飬���ڴ����г��ֵ�˳������ִ�С�
 *	6.ִ������Ĺ��췽����
 */
public class TestInitSequence {
	/**
	 * Description
	 * @param args
	 */
	public static void main(String[] args) {
		Son s = new Son("son");
	}
}

class Parent{

	public static int k=0;
	public static Parent t1 = new Parent("parent1");
	public static Parent t2 = new Parent("parent2");
	public static int i = print("i");
	public static int n = 99;
	static{
		print("parent�о�̬��ʼ����");
	}
	
	{
		print("parent�еĳ�ʼ����");
	}	
	public Parent(String str){
		print("parent���췽��");
	}
	
	public static int print(String str) {
		System.out.println(++k+":"+str+"	i="+i+"		n="+n);		
		++n;
		return ++i;
	}
}

class Son extends Parent{
	public static Son son = new Son("son1");
	static{
		print("son�еľ�̬��ʼ����");
	}
	
	{
		print("son�еĳ�ʼ����");
	}	
	public Son(String str){
		super(str);
		print("son���췽��");
	}
	
}
