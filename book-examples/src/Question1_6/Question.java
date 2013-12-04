package Question1_6;

import CtCILibrary.*;

public class Question {

    /**
     * 매트릭스 회전 시키기
     * @param matrix
     * @param n
     */
	public static void rotate(int[][] matrix, int n) {

		for (int layer = 0; layer < n / 2; ++layer) {
            System.out.println("rotate:layer (" + layer + "), n/2 (" + n/2 + ")");
            int first = layer;
            System.out.println("rotate:first (" + first + ")");
            int last = n - 1 - layer;
            System.out.println("rotate:last (" + last + ")");
            System.out.println("rotate:first->last까지 반복문 실행.");
            for(int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
                System.out.println("rotate:offset (" + offset + "), top (" + top + ")");

				// left -> top
				matrix[first][i] = matrix[last-offset][first];
                System.out.println("rotate:get left. last-offset (" + (last-offset) + "), first (" + first + ")");
                System.out.println("rotate:set top. first (" + first + "), i (" + i + ")");

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset];
                System.out.println("rotate:get bottom. last (" + last + "), last - offset (" + (last - offset) + ")");
                System.out.println("rotate:set left. last-offset (" + (last-offset) + "), i (" + first + ")");

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
                System.out.println("rotate:get right. i (" + i + "), last (" + last + ")");
                System.out.println("rotate:set bottom. last (" + last + "), last - offset (" + (last - offset) + ")");

				// top -> right
				matrix[i][last] = top; // right <- saved top
                System.out.println("rotate:get top. top (" + top + ")");
                System.out.println("rotate:set right. i (" + i + "), last (" + last + ")");
			}
		}
	}
	
	public static void main(String[] args) {
        StringBuffer problem = new StringBuffer();
        problem.append("이미지를 표현하는 NxN 행렬이 있다. 이미지의 각 픽셀은 4바이트로 표현된다.\n");
        problem.append("이때 이미지를 90도 회전시키는 메서드를 작성하라.\n");
        problem.append("부가적인 행렬을 사용하지 않고서도 할 수 있겠는가?");
        System.out.println("---------------------------- 문제 시작 -----------------------");
        System.out.println(problem);
        System.out.println("---------------------------- 문제 끝 ------------------------");
        StringBuffer description = new StringBuffer();
        description.append("레이어별로 회전시키면 된다. 행렬의 맨 바깥쪽 원소들이 하나의 레이어를 구성하고,\n");
        description.append("그 안쪽 원소들이 또 하나의 레이어를 구성한다.\n");
        description.append("이런 식으로 행렬을 레이어별로 쪼개어 회전시킬 수 있다.\n\n");

        description.append("1. .");
        System.out.println("---------------------------- 해설 시작 (해법 1) -----------------------");
        System.out.println(description);
        System.out.println("---------------------------- 해설 끝 (해법 1) ------------------------");

        System.out.println("---------------------------- 코드 실행 시작 (해법 1) -----------------------");
        System.out.println("10x10개짜리 메트릭스 생성 : 값은 0~9까지 사용.");
        int[][] matrix = AssortedMethods.randomMatrix(10, 10, 0, 9);
        System.out.println("======= 1");
        System.out.println(AssortedMethods.arrayToString(matrix[0]));
        System.out.println("======= 2");
        System.out.println(AssortedMethods.arrayToString(matrix[1]));
        System.out.println("======= 3");
        System.out.println(AssortedMethods.arrayToString(matrix[2]));
        System.out.println("======= 4");
        System.out.println(AssortedMethods.arrayToString(matrix[3]));
        System.out.println("======= 5");
        System.out.println(AssortedMethods.arrayToString(matrix[4]));
        System.out.println("======= 6");
        System.out.println(AssortedMethods.arrayToString(matrix[5]));
        System.out.println("======= 7");
        System.out.println(AssortedMethods.arrayToString(matrix[6]));
        System.out.println("======= 8");
        System.out.println(AssortedMethods.arrayToString(matrix[7]));
        System.out.println("======= 9");
        System.out.println(AssortedMethods.arrayToString(matrix[8]));
        System.out.println("======= 10");
        System.out.println(AssortedMethods.arrayToString(matrix[9]));
        System.out.println("####### before");
		AssortedMethods.printMatrix(matrix);
		rotate(matrix, 10);
		//System.out.println(AssortedMethods.arrayToString(matrix[0]));
        System.out.println("####### after");
		AssortedMethods.printMatrix(matrix);
        System.out.println("---------------------------- 코드 실행 끝 (해법 1) -----------------------");
	}

}
