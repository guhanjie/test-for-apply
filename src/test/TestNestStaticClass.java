package test;

import static java.lang.System.out;

public class TestNestStaticClass {
	private static String string = "sdfdsf";
	
	public static class NestStaticClass {
		static {
			//��̬�ڲ�����Է����ⲿ���static��Ա�����ǲ��ܷ��ʷ�static��Ա
			out.println(string);
		}
	}
}
