package Question1_5;

public class Question {

	public static int setChar(char[] array, char c, int index, int count) {
		array[index] = c;
		index++;
		char[] cnt = String.valueOf(count).toCharArray();
		for (char x : cnt) {
			array[index] = x;
			index++;
		}
		return index;
	}
	
	public static int countCompression(String str) {
        System.out.println("countCompression:입력 받은 문자열이 null이거나 비어있으면 0을 반환한다.");
        if (str == null || str.isEmpty()) return 0;
		char last = str.charAt(0);
        System.out.println("countCompression:첫번째 문자를 last 변수에 할당. last (" + last + ")");
        int size = 0;
		int count = 1;
        System.out.println("countCompression:size변수와 count 변수를 초기화. size (" + size + "), count (" + count + ")");
        System.out.println("countCompression:문자열 길이만큼 반복문을 실행. 단, i=1 부터 i<문자열.length() 까지");
        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) == last) {
				count++;
                System.out.println("countCompression:i에 해당하는 문자가 last와 같으면 count 1 증가. count (" + count + ")");
			} else {
                System.out.println("countCompression:i에 해당하는 문자가 last와 다르면");
				last = str.charAt(i);
                System.out.println("countCompression:last에 i에 해당하는 문자 할당. last (" + last + ")");
                size += 1 + String.valueOf(count).length();
                System.out.println("countCompression:size 에 (1증가 + 카운트를 문자열로 변환 후 length) 계산값 할당. size (" + size + ")");
                count = 1;
                System.out.println("countCompression:count에 1 할당. count (" + count + ")");
			} 
		}
        size += 1 + String.valueOf(count).length();
        System.out.println("countCompression:반복문 실행을 마친 후 size 에 (1증가 + 카운트를 문자열로 변환 후 length) 계산값 할당. size (" + size + ")");
		return size;
	}
	
	public static String compressBad(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				mystr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		return mystr + last + count;
	}
	
	public static String compressBetter(String str) {
		int size = countCompression(str);
        System.out.println("compressBetter:size가 문자열 길이보다 크거나 같으면 원래 문자열을 그대로 반환한다.");
        if (size >= str.length()) {
			return str;
		}

		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
        System.out.println("compressBetter:StringBuffer 객체를 생성하고, 첫번째 문자열을 last 변수에 할당. last (" + last + ")");
        int count = 1;
        System.out.println("compressBetter:문자열의 길이만큼 반복문 실행. 단, i와 count는 1부터 시작.");
        for (int i = 1; i < str.length(); i++) {
            System.out.println("compressBetter:i에 해당하는 문자 (" + str.charAt(i) + "), last (" + last + ")");
			if (str.charAt(i) == last) {
                count++;
			} else {
				mystr.append(last);
				mystr.append(count);
				last = str.charAt(i);
				count = 1;
			}
            System.out.println("compressBetter:count (" + count + ")");
		}
		mystr.append(last);
		mystr.append(count);
		return mystr.toString();
	}	
	
	public static String compressAlternate(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		char[] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				index = setChar(array, last, index, count);
				last = str.charAt(i);
				count = 1;
			}
		}
		index = setChar(array, last, index, count);
		return String.valueOf(array);
	}
	
	public static void main(String[] args) {
        StringBuffer problem = new StringBuffer();
        problem.append("같은 문자가 연속으로 반복될 경우, 그 횟수를 사용해 문자열을 압축하는 메서드를 구현하라.\n");
        problem.append("가령 압축해야 할 문자열이 aabccccccccaaa라면 a2b1c8a3과 같이 압축되어야 한다.\n");
        problem.append("압축 결과로 만들어지는 문자열이 원래 문자열보다 짧아지지 않는 경우, 이 메서드는 원래 문자열을 그대로 반환해야 한다.");
        System.out.println("---------------------------- 문제 시작 -----------------------");
        System.out.println(problem);
        System.out.println("---------------------------- 문제 끝 ------------------------");
        StringBuffer description = new StringBuffer();
        description.append("StringBuffer를 사용하여 문자열을 순회하면서 새로운 문자열에 문자들을 복사해 넣고 반복되는 횟수를 센다.\n\n");

        description.append("1. 압축 결과로 만들어진 문자열이 원본 문자열보다 길이가 크거나 같은지 검사.\n");
        description.append("2. StringBuffer 객체를 생성하고 첫번째 문자열을 last 변수에 넣어둔다.\n");
        description.append("3. 문자열 길이만큼 반복문을 돌면서 같은 문자열을 만나면 count를 증가시키고.\n");
        description.append("4. 다르면 StringBuffer 객체에 문자열과 카운트를 각각 append 한다.\n");
        description.append("5. append를 한 후 다른 문자열이니까 last 변수에 다시 할당한다.\n");
        description.append("6. count변수를 다시 1로 초기화한다.  \n");
        description.append("7. 반복문 실행을 마치면 최종적으로 마지막 순회 결과인 last와 count를 append 하고 String으로 변환하여 반환한다.");
        System.out.println("---------------------------- 해설 시작 (해법 1) -----------------------");
        System.out.println(description);
        System.out.println("---------------------------- 해설 끝 (해법 1) ------------------------");

        System.out.println("---------------------------- 코드 실행 시작 (해법 1) -----------------------");
		String str = "abbccccccde";
        System.out.println("입력 문자열 (" + str + ")");
        String str2 = compressBetter(str);
        System.out.println("출력 문자열 (" + str2 + ")");
        //int c = countCompression(str);
		//String str2 = compressAlternate(str);
		//String t = compressBetter("");
		//System.out.println("Compression: " + t);
		//System.out.println("Old String (len = " + str.length() + "): " + str);
		//System.out.println("New String (len = " + str2.length() + "): " + str2);
		//System.out.println("Potential Compression: " + c);
        System.out.println("---------------------------- 코드 실행 끝 (해법 1) -----------------------");
	}
}
