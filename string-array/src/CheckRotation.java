/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 11. 30.
 * Time: 오후 3:54
 * To change this template use File | Settings | File Templates.
 *
 * 한 단어가 다른 단어에 포함된 문자열인지 판별하는 isSubstring이라는 메서드가 있다고 하자.
 * s1과 s2의 두 문자열이 주어졌을 때, s2가 s1을 회전시킨 결과인지 판별하는 코드를
 * isSubstring을 한 번만 호출하도록 하여 작성하라
 * 가령 'waterbottle'은 'erbottlewat'을 회전시켜 얻을 수 있는 문자열이다.
 */
public class CheckRotation {
    public boolean isRotation(String s1, String s2){
        int len = s1.length();
        /* s1과 s2의 길이가 같고, 0보다 큰지 확인 */
        if(len == s2.length() && len >0){
            /* s1과 s1을 연결해 새 문자열 생성 */
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    boolean isSubstring(String s1s1, String s2){
        return false;
    }

}
