/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 11. 30.
 * Time: 오후 1:33
 * To change this template use File | Settings | File Templates.
 *
 * 문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘을 구현하라.
 * 다른 자료구조를 사용할 수 없는 상황이라면 어떻게 하겠는가?
 *
 * 256자 아스키코드 배열에 체크하는 방식
 */
public class UniqueChars1 {
    public boolean isUniqueChars2(String str){
        if(str.length()>256) return false;

        boolean[] char_set = new boolean[256];
        for(int i=0; i<str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val]){ // 이 문자는 이미 문자열 내에 있음
                return false;
            }

            char_set[i] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueChars1 u = new UniqueChars1();
        boolean result = u.isUniqueChars2("abcdefg");
        System.out.println(result);
    }
}
