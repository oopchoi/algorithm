/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 11. 30.
 * Time: 오후 12:18
 * To change this template use File | Settings | File Templates.
 *
 * 주어진 문자열 내의 모든 공백을 '%20'으로 바꾸고 메서드를 작성하라.
 * 문자열 끝에 추가로 필요한 문자들을 더할 수 있는 충분한 공간이 있다고 가정하라.
 * 그리고 공백을 포함하는 문자열의 길이도 함께 주어진다고 가정하라.
 * (주의: 만일 Java로 구현한다면, 문자 배열을 사용하여 필요한 연산을 각 문자에 바로 적용할 수 있도록 하라.)
 */
public class ReplaceSpaces {
    public void replaceSpaces(char[] str, int length){
        int spaceCount = 0, newLength, i = 0;
        for(i=0; i<length; i++)
        {
            if(str[i] == ' '){
                spaceCount++;
            }
        }
        System.out.println("spaceCount:" + spaceCount + ", length:" + length + ", str.length:" + str.length);
        newLength = length + spaceCount * 2;
        str[newLength] = '\0';
        for(i=length-1; i>=0; i--){
            if(str[i]==' '){
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            }else{
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
        System.out.println(new String(str));
    }

    public static void main(String[] args) {
        ReplaceSpaces r = new ReplaceSpaces();
        //String str = "Welcome To The Algorithm";
        char[] chars = new char[30];
        chars[0] = 'W';
        chars[1] = 'e';
        chars[2] = 'l';
        chars[3] = 'c';
        chars[4] = 'o';
        chars[5] = 'e';
        chars[6] = ' ';
        chars[7] = 'T';
        chars[8] = 'o';
        chars[9] = ' ';
        chars[10] = 'T';
        chars[11] = 'h';
        chars[12] = 'e';
        chars[13] = ' ';
        chars[14] = 'A';
        chars[15] = 'l';
        chars[16] = 'g';
        chars[17] = 'o';
        chars[18] = 'r';
        chars[19] = 'i';
        chars[20] = 't';
        chars[21] = 'h';
        chars[22] = 'm';
        r.replaceSpaces(chars, 23);
    }
}
