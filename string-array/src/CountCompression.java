/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 11. 30.
 * Time: 오후 1:55
 * To change this template use File | Settings | File Templates.
 *
 * 같은 문자가 연속으로 반복될 경우, 그 횟수를 사용해 문자열을 압축하는 메서드를 구현하라.
 * 가령 압축해야 할 문자열이 aabccccccccaaa라면 a2b1c8a3과 같이 압축되어야 한다.
 * 압축 결과로 만들어지는 문자열이 원래 문자열보다 짧아지지 않는 경우, 이 메서드는 원래 문자열을 그대로 반환해야 한다.
 */
public class CountCompression {
    String compressBetter(String str){
        /* 압축 결과가 원래 문자열보다 길어지는지 검사 */
        int size = countCompression(str);
        if(size >= str.length()){
            return str;
        }

        StringBuffer mystr = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == last){  // 반복되는 문자 찾기
                count++;
            }else{  // 반복 횟수를 삽입하고, last 갱신
                mystr.append(last); // 문자 삽입
                mystr.append(count);    // 반복 횟수 삽입
                System.out.println("(internal loop)appended last and count:" + last + ", " + count);
                last = str.charAt(i);
                count = 1;
            }
        }

        /*
        * 27-28 행에서, 문자들은 반복되는 문자가 바뀔 때 삽입된다.
        * 메서드 끝부분에서 최종적으로 문자열을 갱신할 필요가 있는데,
        * 맨 마지막 부분에서 반복되는 문자열은
        * 아직 최종적으로 생성되는 압축 결과 문자열에
        * 반영되지 않았기 때문이다.
        * */
        mystr.append(last);
        mystr.append(count);
        System.out.println("(external loop)appended last and count:" + last + ", " + count);
        return mystr.toString();
    }

    int countCompression(String str){
        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == last){
                count++;
            }else {
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 0;
            }
        }
        size += 1  + String.valueOf(count).length();

        System.out.println("count before compressing:" + str.length());
        System.out.println("count after compressing:" + size);
        return size;
    }

    public static void main(String[] args) {
        CountCompression c = new CountCompression();
        String result = c.compressBetter("aabccccccccaaa");
        System.out.println(result);
    }
}
