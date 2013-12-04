package Question1_5;

public class Question {

    /**
     * 입력 받은 array의 입력 받은 index에 해당하는 요소에 입력받은 c 문자를 할당한다.
     * @param array
     * @param c
     * @param index
     * @param count
     * @return
     */
	public static int setChar(char[] array, char c, int index, int count) {
        System.out.println("setChar:받은 배열의 index에 c를 할당하고 index를 증가시킨다.");
        System.out.println("setChar:index (" + index + "), c (" + c + ")");
        array[index] = c;   // index에 문자 넣고
		index++;            // index 증가 시켜서 count를 넣을 것이다.
        System.out.println("setChar:증가된 index (" + index + ")");
        char[] cnt = String.valueOf(count).toCharArray();   // 카운트를 문자열로 바꿔서 char 배열로 변환하고
        System.out.println("setChar:count 값을 String으로 변환 후 char 배열로 변환하고");
        System.out.println("setChar:배열 요소만큼 반복문을 실행한다. count (" + count + ")");
        for (char x : cnt) {
            System.out.println("setChar:입력 받은 array의 index에 x값을 할당한 후 index를 증가시킨다. x (" + x + ")");
			array[index] = x;   // 증가 시킨 인덱스에 변환된 카운트 문자를 할당하고
			index++;    // 인덱스를 증가 시킨다.
		}
        System.out.println("setChar:최종적으로 증가된 인덱스를 반환한다. index (" + index + ")");
        // 문자 + 카운트숫자 갯수 만큼 증가된 인덱스를 반환한다.
        return index;
	}

    /**
     * 압축 되었을 때의 문자열 길이를 반환한다.
     * @param str
     * @return
     */
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
        System.out.println("compressAlternate:size가 문자열 길이보다 크거나 같으면 원래 문자열을 그대로 반환한다.");
		if (size >= str.length()) {
			return str;
		}
        System.out.println("compressAlternate:size (" + size + ")");
        System.out.println("compressAlternate:압축된 문자열 결과의 사이즈 만큼 요소를 갖는 char 배열을 생성한다.");
        char[] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
        System.out.println("compressAlternate:index, last(첫번째 문자), count 변수를 초기화. index (" + index + "), last (" + last + "), count (" + count + ")");
        System.out.println("compressAlternate:문자열 길이만큼 반복문을 실행한다.");
        for (int i = 1; i < str.length(); i++) {
            System.out.println("compressAlternate:새로 들어온 문자하고 last 문자하고 같으면 카운트를 증가시킨다.");
            System.out.println("compressAlternate:setChar()를 통해 index를 받아오고, last, count를 업데이트 한다.");
            if (str.charAt(i) == last) {
				count++;
                System.out.println("compressAlternate:count (" + count+ ")");
            } else {
				index = setChar(array, last, index, count);
				last = str.charAt(i);
				count = 1;
                System.out.println("compressAlternate:index (" + index + "), count (" + count + "), last (" + last + ")");
            }
		}
		index = setChar(array, last, index, count);
        System.out.println("compressAlternate:최종 인덱스를 setChar() 호출해서 받아온다. index (" + index + ")");
        System.out.println("compressAlternate:마지막으로 array를 String으로 변환해서 반환한다.");
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

        description.delete(0, description.length()-1);
        description.append("StringBuffer를 쓸 수 없거나 쓰고 싶지 않을 때에 변환 결과 문자열의 길이를 계산해서\n");
        description.append("그 결과를 사용해 올바른 길이의 char 배열을 만들어 낼 수 있다.\n");

        description.append("1. 압축 결과로 만들어진 문자열이 원본 문자열보다 길이가 크거나 같은지 검사.\n");
        description.append("2. 압축 결과 문자열 길이만큼 요소를 갖는 char 배열을 생성한다.\n");
        description.append("3. last 변수에 첫번째 문자를 할당. index는 0, count는 1로 초기화한다.\n");
        description.append("4. 입력 문자열 길이만큼 반복문을 실행하면서 압축 문자열을 편집해 나간다.");
        System.out.println("---------------------------- 해설 시작 (해법 2) -----------------------");
        System.out.println(description);
        System.out.println("---------------------------- 해설 끝 (해법 2) ------------------------");

        System.out.println("---------------------------- 코드 실행 시작 (해법 2) -----------------------");
        str = "abbccccccde";
        System.out.println("입력 문자열 (" + str + ")");
        str2 = compressAlternate(str);
        System.out.println("출력 문자열 (" + str2 + ")");
        //int c = countCompression(str);
        //String str2 = compressAlternate(str);
        //String t = compressBetter("");
        //System.out.println("Compression: " + t);
        //System.out.println("Old String (len = " + str.length() + "): " + str);
        //System.out.println("New String (len = " + str2.length() + "): " + str2);
        //System.out.println("Potential Compression: " + c);
        System.out.println("---------------------------- 코드 실행 끝 (해법 2) -----------------------");
	}
}
