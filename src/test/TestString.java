package test;
/**
 * String是字符串对象类，且是不可变的。
 * 它有一个很重要的特性，就是在定义字符串常量时，用了一个缓冲池！
 * @author gu
 *
 */
public class TestString {
    public static void main(String[] args) {
        String str1 = new String("abc");	//凡是new出来的对象都是在堆空间中开辟新的内存
        String str2 = "abc";				//这里定义了一个字符串常量，系统会去JVM当前字符串缓冲池中找有无该对象，没有，则创建一个该串
        String str3 = "abc";				//如果有，则直接将存在于字符串缓冲池中的数据给出来，也就是指向同一个对象地址
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
    }
}