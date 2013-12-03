package Question1_1;

public class Question {

	public static boolean isUniqueChars(String str) {
        if (str.length() > 256) {
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}

	public static boolean isUniqueChars2(String str) {
		if (str.length() > 256) {
			return false;
		}
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
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
        description.append("아스키 문자코드의 전체 갯수는 256개 이므로,\n");
        description.append("입력 받는 문자열 갯수가 256개가 넘으면\n");
        description.append("중복되는 문자가 존재한다는 의미이기 때문에 곧 바로 return 한다.\n\n");

        description.append("검증) 입력 받은 문자열의 갯수가 256개가 넘으면 false를 반환한다.\n");
        description.append("1. 256개의 boolean 배열을 생성한다.\n");
        description.append("2. 입력 받은 문자열의 길이만큼 루프를 돌면서 각 문자를 int형의 아스키코드로 변환한다.\n");
        description.append("3. 아스키코드를 인덱스로 사용하여 해당하는 boolean 배열 요소를 검사하여 true로 마킹되어 있으면 false를 반환한다.\n");
        description.append("4. 아스키코드를 인덱스로 사용하여 해당하는 boolean 배열 요소에 true를 마킹한다.");
        System.out.println("---------------------------- 해설 시작 (해법 1) -----------------------");
        System.out.println(description);
        System.out.println("---------------------------- 해설 끝 (해법 1) ------------------------");

        System.out.println("---------------------------- 코드 실행 시작 (해법 1) -----------------------");
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars2(word));
        }
        System.out.println("---------------------------- 코드 실행 끝 (해법 1) -----------------------");

		/*String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word));
		}*/
	}

}
