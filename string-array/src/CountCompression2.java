/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 11. 30.
 * Time: 오후 3:19
 * To change this template use File | Settings | File Templates.
 *
 * 같은 문자가 연속으로 반복될 경우, 그 횟수를 사용해 문자열을 압축하는 메서드를 구현하라.
 * 가령 압축해야 할 문자열이 aabccccccccaaa라면 a2b1c8a3과 같이 압축되어야 한다.
 * 압축 결과로 만들어지는 문자열이 원래 문자열보다 짧아지지 않는 경우, 이 메서드는 원래 문자열을 그대로 반환해야 한다.
 *
 * StringBuffer를 사용하지 못하는 경우
 */
public class CountCompression2 {
    String compressAlternate(String str){
        /* 압축 결과로 만들어지는 문자열의 길이가 원래보다 길어지는지 검사 */
        int size = countCompression(str);
        if(size >= str.length()){
            return str;
        }

        char[] array = new char[size];
        int index = 0;
        char last = str.charAt(0);
        int count = 1;
        for (int i=0; i<str.length(); i++){
            if(str.charAt(i) == last){  // 반복되는 문자 찾기
                count++;
            }else{
                /* 문자 반복 횟수 갱신 */
                index = setChar(str, array, last, index, count);
                last = str.charAt(i);
                System.out.println("(internal loop)appended last and count:" + last + ", " + count);
                count = 1;
            }
        }

        /* 최종적으로 반복된 부분 문자열을 결과에 추가 */
        index = setChar(str, array, last, index, count);
        System.out.println("(external loop)appended last and count:" + last + ", " + count);
        return String.valueOf(array);
    }

    int setChar(String str, char[] array, char c, int index, int count){
        array[index] = c;
        index++;

        /* 반복 횟수를 문자열로 바꾸고, 최종적으로 배열로 변환 */
        char[] cnt = String.valueOf(count).toCharArray();

        /* 변환된 문자열을 앞에서부터 결과에 추가 */
        for(char x:cnt){
            array[index] = x;
            index++;
        }

        return index;
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
        CountCompression2 c = new CountCompression2();
        String result = c.compressAlternate("aabccccccccaaa");
        System.out.println(result);
    }
}
