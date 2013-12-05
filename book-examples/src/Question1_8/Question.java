package Question1_8;

public class Question {
	public static boolean isSubstring(String big, String small) {
        System.out.println("isSubstring:big.indexOf(small) (" + big.indexOf(small) + ")");
        if (big.indexOf(small) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isRotation(String s1, String s2) {
	    int len = s1.length();
	    /* check that s1 and s2 are equal length and not empty */
	    if (len == s2.length() && len > 0) { 
	    	/* concatenate s1 and s1 within new buffer */
	    	String s1s1 = s1 + s1;
            System.out.println("isRotation:s1s1 (" + s1s1 + ")");
            return isSubstring(s1s1, s2);
	    }
	    return false;
	}
	
	public static void main(String[] args) {
        StringBuffer problem = new StringBuffer();
        problem.append("한 단어가 다른 단어에 포함된 문자열인지 판별하는 isSubstring이라는 메서드가 있다고 하자.\n");
        problem.append("s1과 s2의 두 문자열이 주어졌을 때, s2가 s1을 회전시킨 결과인지 판별하는 코드를\n");
        problem.append("isSubstring을 한 번만 호출하도록 하여 작성하라.\n");
        problem.append("가령 'waterbottle'은 'erbottlewat'을 회전시켜 얻을 수 있는 문자열이다.");
        System.out.println("---------------------------- 문제 시작 -----------------------");
        System.out.println(problem);
        System.out.println("---------------------------- 문제 끝 ------------------------");
        StringBuffer description = new StringBuffer();
        description.append("s2가 s1s1의 부분 문자열인지 판단한다.");
        System.out.println("---------------------------- 해설 시작 (해법 1) -----------------------");
        System.out.println(description);
        System.out.println("---------------------------- 해설 끝 (해법 1) ------------------------");

        System.out.println("---------------------------- 코드 실행 시작 (해법 1) -----------------------");

		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = isRotation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
        System.out.println("---------------------------- 코드 실행 끝 (해법 1) -----------------------");
	}

}
