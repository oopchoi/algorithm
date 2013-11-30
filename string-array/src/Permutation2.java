/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 11. 30.
 * Time: 오후 12:06
 * To change this template use File | Settings | File Templates.
 *
 * 문자열 두 개를 입력으로 받아 그중 하나가 다른 하나의 순열인지 판별하는 메서드를 작성하라.
 *
 * 문자열에 포함된 문자의 출현 횟수가 같은지 검사하는 방법
 */
public class Permutation2 {
    public boolean permutation(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] letters = new int[256]; // 가정
        char[] s_array = s.toCharArray();
        for(char c:s_array){
            System.out.println((int)c);
            letters[c]++;
        }
        for(int i=0; i<t.length(); i++){
            int c = (int) t.charAt(i);
            System.out.println(c);
            if(--letters[c]<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Permutation2 p = new Permutation2();
        boolean result = p.permutation("dog", "god");
        System.out.println(result);
    }
}
