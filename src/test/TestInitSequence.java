package test;

/**
 * java类的成员初始化顺序和初始化块知识
 * @author gu
 * 属性、方法、构造方法和自由块都是类中的成员，在创建类的对象时，类中各成员的执行顺序：
 *	1.父类静态成员和静态初始化快，按在代码中出现的顺序依次执行。
 *	2.子类静态成员和静态初始化块，按在代码中出现的顺序依次执行。
 *	3. 父类的实例成员和实例初始化块，按在代码中出现的顺序依次执行。
 *	4.执行父类的构造方法。
 *	5.子类实例成员和实例初始化块，按在代码中出现的顺序依次执行。
 *	6.执行子类的构造方法。
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
		print("parent中静态初始化块");
	}
	
	{
		print("parent中的初始化块");
	}	
	public Parent(String str){
		print("parent构造方法");
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
		print("son中的静态初始化块");
	}
	
	{
		print("son中的初始化块");
	}	
	public Son(String str){
		super(str);
		print("son构造方法");
	}
	
}
