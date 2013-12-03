package Question1_3;

public class QuestionB {	
	public static boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		int[] letters = new int[256];
		 
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			letters[c]++;  
		}
		  
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
            System.out.println("int 배열 (" + c + ")번째 값 (" + letters[c] + ")");
            if (--letters[c] < 0) {
		    	return false;
		    }
		}
		  
		return true;
	}
	
	public static void main(String[] args) {
        StringBuffer problem = new StringBuffer();
        problem.append("문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘을 구현하라.\n");
        problem.append("다른 자료구조를 사용할 수 없는 상황이라면 어떻게 하겠는가?");
        System.out.println("---------------------------- 문제 시작 -----------------------");
        System.out.println(problem);
        System.out.println("---------------------------- 문제 끝 ------------------------");

        StringBuffer description = new StringBuffer();
        description.append("소스 문자열의 카운트 후 타겟 문자열의 카운트 시 마이너스값이 있으면 false를 반환한다.\n\n");

        description.append("1. 입력 받은 두 문자열의 길이를 비교하여 다르면 false를 반환한다.\n");
        description.append("2. 256개의 요소를 갖는 int 배열을 생성한다.\n");
        description.append("3. 소스 문자열을 char 배열로 변환한다.\n");
        description.append("4. int 배열의 요소에 1 증가시킨다.\n");
        description.append("5. 타겟 문자열의 길이만큼 루프를 돌면서 아스키코드를 얻어온다.\n");
        description.append("6. 아스키코드에 해당하는 배열 요소를 1 감소 시키고 결과가 마이너스 값이면 false를 반환한다.\n");
        description.append("7. 모든 루프를 돌고 나면 true를 반환한다.");
        System.out.println("---------------------------- 해설 시작 (해법 3) -----------------------");
        System.out.println(description);
        System.out.println("---------------------------- 해설 끝 (해법 3) ------------------------");

        System.out.println("---------------------------- 코드 실행 시작 (해법 3) -----------------------");
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
            System.out.println("# 시작");
			String word1 = pair[0];
			String word2 = pair[1];
            System.out.println("소스 문자열 ("+word1 + "), 타겟 문자열 (" + word2 + ")");
			boolean anagram = permutation(word1, word2);
            System.out.println("순열 성립 (" + anagram + ")");
            System.out.println("# 끝");
		}
        System.out.println("---------------------------- 코드 실행 시작 (해법 3) -----------------------");
	}
}
