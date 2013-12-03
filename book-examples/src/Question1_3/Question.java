package Question1_3;

public class Question {
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
        return new String(content);
	}
	
	public static boolean permutation(String s, String t) {
        System.out.println("permutation:sorted s=>" + sort(s) + ", sorted t=>" + sort(t));
        return sort(s).equals(sort(t));
	}
	
	public static boolean anagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0){
				++num_unique_chars;
                System.out.println("anagram:새로운 소스 문자 (" + c + "), 중복되지 않는 소스 문자 갯수 (" + num_unique_chars + ")");
            }
			++letters[c];
            System.out.println("anagram:소스 문자 (" + c + ")의 갯수 (" + letters[c] + ")");
        }
        for (int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
                System.out.println("anagram:루프 시작 시 타겟 문자 (" + t.charAt(i) + ")의 갯수가 0이라는 의미는 소스문자에 존재하지 않거나,");
                System.out.println("타겟 문자에 같은 문자가 추가로 하나 이상 더 있다는 의미이므로 순열이 성립이 안된다.");
                return false;
			}
			--letters[c];
            System.out.println("anagram:타겟 문자 (" + t.charAt(i) + ")의 카운트-1 이 후 갯수 (" + letters[c] + ")");
            if (letters[c] == 0) {
				++num_completed_t;

                System.out.println("anagram:소스에 존재하는 타겟 문자 (" + t.charAt(i) + "), 중복되지 않는 타겟 문자 갯수 (" + num_completed_t + ")");
				if (num_completed_t == num_unique_chars) {
					// it�s a match if t has been processed completely
					return true;
					//return i == t.length() - 1;
				}
			}
		}
		return false;
	}	
	
	public static void main(String[] args) {
        StringBuffer problem = new StringBuffer();
        problem.append("문자열 두 개를 입력으로 받아 그중 하나가 다른 하나의 순열인지 판별하는 메서드를 작성하라.\n");
        problem.append("대소문자를 구별하고, 공백도 문자 하나로 취급한다.");
        System.out.println("---------------------------- 문제 시작 -----------------------");
        System.out.println(problem);
        System.out.println("---------------------------- 문제 끝 ------------------------");

        StringBuffer description = new StringBuffer();
        description.append("입력 받은 두개의 문자열을 정렬하고 비교한다.\n\n");

        description.append("1. 입력 받은 두 문자열을 정렬한다.\n");
        description.append("2. 정렬된 두 문자열을 String.equals()로 비교하여 결과를 반환한다.");
        System.out.println("---------------------------- 해설 시작 (해법 1) -----------------------");
        System.out.println(description);
        System.out.println("---------------------------- 해설 끝 (해법 1) ------------------------");

        System.out.println("---------------------------- 코드 실행 시작 (해법 1) -----------------------");
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
        System.out.println("---------------------------- 코드 실행 끝 (해법 1) -----------------------");

        StringBuffer description2 = new StringBuffer();
        description2.append("효율성이 아주 중요한 상황일 경우, 문자열에 포함된 문자의 출현 횟수가 같은지 검사하라.\n");
        description2.append("256개 요소를 갖는 int 배열을 생성하고, 소스 문자열 길이만큼 루프를 돌면서");
        description2.append("문자에 해당하는 배열 요소를 1씩 증가시키고\n");
        description2.append("타겟 문자열의 길이만큼 루프를 돌면서, int 배열 요소의 카운트를 하나씩 빼면서 비교한다.\n");
        description2.append("최종적으로 소스 문자의 카운트 변수와 타겟 문자의 카운트 변수의 값이 같다면 순열이 성립되는 것이다.\n\n");

        description2.append("1. 입력 받은 두 문자열의 길이를 비교하여 다르면 false를 반환한다.\n");
        description2.append("2. 256개의 요소를 갖는 int 배열을 생성한다.\n");
        description2.append("3. 소스 문자의 카운트 변수와 타겟 문자의 카운트 변수를 초기화 한다.\n");
        description2.append("4. 소스 문자열을 char 배열로 변환한다.\n");
        description2.append("5. 변환된 배열 요소의 길이 만큼 루프를 돌면서 int 배열에 요소가 0인지 검사한다.\n");
        description2.append("6. int 배열의 요소가 0이면 소스 문자의 카운트 변수를 1 증가시킨다.\n");
        description2.append("7. int 배열의 요소에 1을 증가시킨다.\n");
        description2.append("8. 타겟 문자열의 길이만큼 루프를 돌면서 아스키코드를 얻어온다.\n");
        description2.append("9. 아스키코드에 해당하는 인덱스에 int 배열의 요소가 0인지 검사한다.\n");
        description2.append("10. 아스키코드에 해당하는 int 배열의 요소가 0이면 해당하는 문자가 소스 문자열에 없다는 뜻이니까 false를 반환한다.\n");
        description2.append("11. 아스키코드에 해당하는 int 배열의 요소를 1 감소시킨다.\n");
        description2.append("12. 감소 시킨 int 배열의 요소가 0인지 다시 검사해서 0이면,\n");
        description2.append("13. 타겟 문자의 카운트 변수를 1 증가시킨다.\n");
        description2.append("14. 타겟 문자의 카운트 변수와 소스 문자의 카운트 변수의 값이 같으면 최종적으로 true를 반환한다.");

        System.out.println("---------------------------- 해설 시작 (해법 2) -----------------------");
        System.out.println(description2);
        System.out.println("---------------------------- 해설 끝 (해법 2) ------------------------");

        System.out.println("---------------------------- 코드 실행 시작 (해법 2) -----------------------");
        for (String[] pair : pairs) {
            System.out.println("# 시작");
            String word1 = pair[0];
            String word2 = pair[1];
            System.out.println("소스 문자열 ("+word1 + "), 타겟 문자열 (" + word2 + ")");
            boolean anagram = anagram(word1, word2);
            System.out.println("순열 성립 (" + anagram + ")");
            System.out.println("# 끝");
        }
        System.out.println("---------------------------- 코드 실행 끝 (해법 2) -----------------------");
	}
}
