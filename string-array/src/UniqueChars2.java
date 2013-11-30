/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 11. 30.
 * Time: 오후 1:37
 * To change this template use File | Settings | File Templates.
 * 문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘을 구현하라.
 * 다른 자료구조를 사용할 수 없는 상황이라면 어떻게 하겠는가?
 *
 * a~z 까지로만 구성될 경우
 */
public class UniqueChars2 {
    public boolean isUniqueChars(String str){
        if(str.length()>256) return false;

        int checker = 0;
        for(int i=0; i<str.length(); i++){
            int val = str.charAt(i) - 'a';
            System.out.println("val:" + val);
            System.out.println("1 << val:" + (1 << val));
            System.out.println("checker & 1:" + (checker & 1));
            System.out.println("checker & (1 << val):" + (checker & (1 << val)));
            if((checker & (1 << val)) > 0){
                return false;
            }
            System.out.println("checker | (1 << val):" + (checker | (1 << val)));
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueChars2 u = new UniqueChars2();
        boolean result = u.isUniqueChars("abcdefg");
        System.out.println(result);
    }
}
