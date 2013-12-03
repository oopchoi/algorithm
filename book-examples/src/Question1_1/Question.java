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
        description.append("중복되는 문자가 존재한다는 의미이기 때문에 곧 바로 return 한다.");
        System.out.println("---------------------------- 해설 시작 -----------------------");
        System.out.println(description);
        System.out.println("---------------------------- 해설 끝 ------------------------");

		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word));
		}
	}

}
