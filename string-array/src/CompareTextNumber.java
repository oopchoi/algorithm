/**
 * Created with IntelliJ IDEA.
 * User: bryan
 * Date: 13. 11. 28
 * Time: 오전 8:17
 * To change this template use File | Settings | File Templates.
 */
public class CompareTextNumber {
    public boolean compareBinToHex(String binary, String hex){
        int n1 = convertToBase(binary, 2);
        int n2 = convertToBase(hex, 16);
        if(n1 < 0 || n2 < 0){
            return false;
        }else{
            return n1 == n2;
        }
    }

    public int digitToValue(char c){
        if(c>='0' && c<='9') return c - '0';
        else if(c>='A' && c<= 'F') return 10 + c - 'A';
        else if(c>='a' && c<='f') return 10 + c - 'a';
        return -1;
    }

    public int convertToBase(String number, int base){
        if(base<2 || (base>10 && base != 16)) return -1;
        int value = 0;
        for(int i = number.length()-1; i>=0; i--){
            int digit = digitToValue(number.charAt(i));
            if(digit<0 || digit >= base) {
                return -1;
            }
            int exp = number.length() - 1 - i;
            value += digit * Math.pow(base, exp);
        }
        return value;
    }
    public static void main(String[] args) {
        CompareTextNumber checker = new CompareTextNumber();
        boolean check = checker.compareBinToHex("1100", "C");
        System.out.println(check);
    }
}
