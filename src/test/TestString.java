package test;
/**
 * String���ַ��������࣬���ǲ��ɱ�ġ�
 * ����һ������Ҫ�����ԣ������ڶ����ַ�������ʱ������һ������أ�
 * @author gu
 *
 */
public class TestString {
    public static void main(String[] args) {
        String str1 = new String("abc");	//����new�����Ķ������ڶѿռ��п����µ��ڴ�
        String str2 = "abc";				//���ﶨ����һ���ַ���������ϵͳ��ȥJVM��ǰ�ַ���������������޸ö���û�У��򴴽�һ���ô�
        String str3 = "abc";				//����У���ֱ�ӽ��������ַ���������е����ݸ�������Ҳ����ָ��ͬһ�������ַ
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
    }
}