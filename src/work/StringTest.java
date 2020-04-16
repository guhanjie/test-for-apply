import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringTest {

    public static void main(String[] args) {
        testDictionaryOrder();
    }

    /**
     * 算法题：
     * 给定一串随机的字符序列（取值：a-z，可能存在重复字符），请输出尽可能按字典序排序的字符串
     * 举例如下：
     * input:      {'b', 'a', 'd', 'c', 'a', 'b', 'd'}
     * output:     acbd
     * 
     * test case1:
     * {}
     * {'b', 'a', 'd', 'c', 'a', 'b', 'd'};
     * {'b', 'b', 'd', 'a', 'b', 'c', 'd'};
     * {'a', 'b', 'a', 'c', 'b', 'a', 'd'};
     * {'b', 'a', 'c', 'b', 'a', 'd', 'c'};
     */
    public static String dictionaryOrder1(char[] input) {
        if(input == null || input.length == 0) {
            return "";
        }
        List<Character> list = new LinkedList<Character>();
        for(int i=input.length-1; i>=0; i--) {
            char c = input[i];
            int idx = list.indexOf(c);
            if(idx == -1) {
                list.add(0, c);
            }
            else {
                //在链表中(0..idx)这一段检查第一个比c大的值
                //需要向前询问：[a, b]? _c_ b a _d_ c
                int k = -1;
                for(int j=0; j<idx; j++) {
                    if(c < list.get(j)) {
                        k = j;
                        break;
                    }
                }
                boolean foundprev = (k != -1);
                for(int j=0; j<k; j++) {
                    if(!foundPrev(input, i, list.get(j))) {
                        foundprev = false;
                        break;
                    }
                }
                if(foundprev) {
                    list.remove(idx);
                    for(int j=k-1; j>=0; j--) {
                        list.remove(j);
                    }
                    list.add(0, c);
                }
            }
        }
        return list.toString();
    }

    public static boolean foundPrev(char[] input, int idx, char c) {
        for(int i=0; i<idx; i++) {
            if(input[i] == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * 算法思想2：连线法（暴力测试法）
     * 先确定字符集合，a b c d
     * 开始暴力测试：
     * 从a开始-能否连线到b-能否连线到c-能否连线到d
     * a-b-d-...
     * @param input
     * @return
     */
    public static String dictionaryOrder2(char[] input) {
        return "";
    }

    public static void testDictionaryOrder() {
        char[] test0 = {};
        char[] test1 = {'b', 'a', 'd', 'c', 'a', 'b', 'd'};
        char[] test2 = {'b', 'b', 'd', 'a', 'b', 'c', 'd'};
        char[] test3 = {'a', 'b', 'a', 'c', 'b', 'a', 'd'};
        char[] test4 = {'b', 'a', 'c', 'b', 'a', 'd', 'c'};
        System.out.println("Test0: " + Arrays.toString(test0));
        System.out.println("Result: " + dictionaryOrder1(test0));
        System.out.println("Test1: " + Arrays.toString(test1));
        System.out.println("Result: " + dictionaryOrder1(test1));
        System.out.println("Test2: " + Arrays.toString(test2));
        System.out.println("Result: " + dictionaryOrder1(test2));
        System.out.println("Test3: " + Arrays.toString(test3));
        System.out.println("Result: " + dictionaryOrder1(test3));
        System.out.println("Test4: " + Arrays.toString(test4));
        System.out.println("Result: " + dictionaryOrder1(test4));
    }
    
}
