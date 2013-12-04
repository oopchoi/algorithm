package Question1_4;

import CtCILibrary.AssortedMethods;

public class Question {
	// Assume string has sufficient free space at the end
	public static void replaceSpaces(char[] str, int length) {
		int spaceCount = 0, index = 0, i = 0;
        System.out.println("replaceSpaces:공백 문자 카운트 (" + spaceCount + "), index (" + index + "), i (" + i + "), 문자열의 length (" + length + ")");
        System.out.println("replaceSpaces:문자열의 갯수 만큼 반복문 실행");
        for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
                spaceCount++;
                System.out.println("replaceSpaces:공백문자 카운트 증가 spaceCount (" + spaceCount + ")");
			}
		}
		index = length + spaceCount * 2;
        System.out.println("replaceSpaces:뒤에서 부터 앞으로 이동하기 위해 index를 구함. index (" + index + ")");
        str[index] = '\0';
        System.out.println("replaceSpaces:배열의 마지막 요소로 문자열의 마지막 문자 할당");

        System.out.println("replaceSpaces:문자열 길이-1 부터 0까지 1씩 빼면서 반복문 실행");
        for (i = length - 1; i >= 0; i--) {
            System.out.println("replaceSpaces:변환 전 str (" + AssortedMethods.charArrayToString(str) + ")");
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
                System.out.println("replaceSpaces:공백문자이면 [index-1]에 '0' 할당, [index-2]에 '2' 할당, [index-3]에 '%' 할당");
                System.out.println("replaceSpaces:index는 3을 빼준다. index (" + index + ")");
            } else {
				str[index - 1] = str[i];
				index--;
                System.out.println("replaceSpaces:공백문자가 아니면 [index-1]에 str[i] 문자열을 그대로 할당. str[i] (" + str[i] + ")");
                System.out.println("replaceSpaces:index는 1을 빼준다. index (" + index + ")");
            }
            System.out.println("replaceSpaces:변환 후 str (" + AssortedMethods.charArrayToString(str) + ")");
		}
	}
	
	public static void main(String[] args) {
        StringBuffer problem = new StringBuffer();
        problem.append("주어진 문자열 내의 모든 공백을 '%20'으로 바꾸는 메서드를 작성하라.\n");
        problem.append("문자열 끝에 추가로 필요한 문자들을 더할 수 있는 충분한 공간이 있다고 가정하라.\n");
        problem.append("그리고 공백을 포함하는 문자열의 길이도 함께 주어진다고 가정하라.\n");
        problem.append("주의: 만일 Java로 구현한다면, 문자 배열을 사용하여 필요한 연산을 각 문자에 바로 적용할 수 있도록 하라.");
        System.out.println("---------------------------- 문제 시작 -----------------------");
        System.out.println(problem);
        System.out.println("---------------------------- 문제 끝 ------------------------");
        StringBuffer description = new StringBuffer();
        description.append("핵심은 문자열을 뒤에서부터 거꾸로 편집해 나가는 것이다.\n");
        description.append("처음에는 문자열 내에 얼마나 많은 공백문자가 있는지 카운트를 센다.\n");
        description.append("그 결과를 최종 변환 결과 문자열의 길이를 계산하는 데 사용한다.\n");
        description.append("역방향으로 진행하면서 공백을 만나면 다음 위치에 '%20'을 복사한다.\n\n");

        description.append("1. 공백 문자 카운트 변수와 실제 배열의 갯수를 담을 변수를 초기화한다.\n");
        description.append("2. 입력받은 길이만큼 루프를 돌면서 입력 받은 char 배열 요소에 공백 문자가 있으면 카운트 변수에 1을 더한다.\n");
        description.append("3. 실제 배열의 갯수를 '입력받은 길이 + 공백 문자 카운트 + * 2'로 계산해 둔다.\n");
        description.append("4. 입력 받은 char 배열의 실제 배열의 갯수의 인덱스에 '역슬래시0'값으로 할당한다.\n");
        description.append("5. 실제 배열의 갯수 값-1 부터 1 씩 감소시키면서 루프를 돌린다.\n");
        description.append("6. 공백 문자를 만나면 [newLength-1]번째에 '0', [newLength-2]번째에 '2', [newLength-3]번째에 '%'를 할당한다.\n");
        description.append("7. 실제 배열 갯수 변수에 -3 을 해서 할당한다.\n");
        description.append("8. 공백 문자가 아니라면 [newLength-1]에 문자를 할당하고 실제 배열 갯수 변수에 -1 하여 할당한다.\n");
        System.out.println("---------------------------- 해설 시작 (해법 1) -----------------------");
        System.out.println(description);
        System.out.println("---------------------------- 해설 끝 (해법 1) ------------------------");

        System.out.println("---------------------------- 코드 실행 시작 (해법 1) -----------------------");
		String str = "abc d e f";
        System.out.println("입력 값 (" + str + ")");
        System.out.println("배열의 전체 length = (입력 문자열의 length) + (공백문자갯수*공백문자 대체문자수)+마지막 문자열을 알리는 수(1)");
        char[] arr = new char[str.length() + 3 * 2 + 1];
        System.out.println("배열의 전체 length (" + arr.length + ")");
        for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		replaceSpaces(arr, str.length());	
		System.out.println("최종 출력 값 (" + AssortedMethods.charArrayToString(arr) + ")");
        System.out.println("---------------------------- 코드 실행 끝 (해법 1) -----------------------");
	}
}
