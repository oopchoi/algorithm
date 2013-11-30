import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 11. 30.
 * Time: 오전 11:58
 * To change this template use File | Settings | File Templates.
 *
 * 문자열 두 개를 입력으로 받아 그중 하나가 다른 하나의 순열인지 판별하는 메서드를 작성하라.
 *
 * 정렬하는 방법
 */
public class Permutation1 {
    public String sort(String s){
        char[] content = s.toCharArray();
        Arrays.sort(content);
        System.out.println(new String(content));
        return new String(content);
    }
    public boolean permutation(String s, String t){
        if (s.length()!=t.length()){
            return false;
        }
        return sort(s).equals(sort(t));
    }

    public static void main(String[] args) {
        Permutation1 p = new Permutation1();
        boolean result = p.permutation("god", "dog");
        System.out.println(result);
    }
}
