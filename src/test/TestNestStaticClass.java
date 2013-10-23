package test;

import static java.lang.System.out;

public class TestNestStaticClass {
	private static String string = "sdfdsf";
	
	public static class NestStaticClass {
		static {
			//静态内部类可以访问外部类的static成员，但是不能访问非static成员
			out.println(string);
		}
	}
}
