package Question1_7;

import CtCILibrary.AssortedMethods;

public class Question {
    /**
     * 해당 로우의 값을 모두 0으로 변경
     * @param matrix
     * @param row
     */
	public static void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}		
	}

    /**
     * 해당 컬럼의 값을 모두 0으로 변경
     * @param matrix
     * @param col
     */
	public static void nullifyColumn(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}		
	}		
	
	public static void setZeros2(int[][] matrix) {
		boolean rowHasZero = false;
		boolean colHasZero = false;		
		
		// Check if first row has a zero
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}		
		
		// Check if first column has a zero
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}		
		
		// Check for zeros in the rest of the array
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
		 		}
			}
		}		
		
		// Nullify rows based on values in first column
        for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}		
		
		// Nullify columns based on values in first row
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				nullifyColumn(matrix, j);
			}
		}	
		
		// Nullify first row
		if (rowHasZero) {
			nullifyRow(matrix, 0);
		}
		
		// Nullify first column
		if (colHasZero) {
			nullifyColumn(matrix, 0);
		}
	}	
	
	public static void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];	
		boolean[] column = new boolean[matrix[0].length];
        System.out.println("setZeros:boolean 로우 배열, boolean 컬럼 배열 생성.");

		// Store the row and column index with value 0
        System.out.println("setZeros:매트릭스 2중 반복문 실행.");
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
                    System.out.println("setZeros:해당 로우와 컬럼 배열 인덱스의 값이 0이면, true로 마킹.");
                    System.out.println("setZeros:로우: i (" + i + ")");
                    System.out.println("setZeros:컬럼: j (" + j + ")");
                    row[i] = true;
					column[j] = true;
		 		}
			}
		}
		
		// Nullify rows
        System.out.println("setZeros:로우 배열의 갯수 만큼 반복문 실행.");
        for (int i = 0; i < row.length; i++) {
			if (row[i]) {
                System.out.println("setZeros:로우 배열에 해당 인덱스 값이 true면");
                System.out.println("setZeros:매트릭스에 인덱스에 해당하는 로우의 모든 값을 0으로 변경. i (" + i + ")");
                nullifyRow(matrix, i);
			}
		}
		
		// Nullify columns
        System.out.println("setZeros:컬럼 배열의 갯수 만큼 반복문 실행.");
		for (int j = 0; j < column.length; j++) {
			if (column[j]) {
				nullifyColumn(matrix, j);
                System.out.println("setZeros:컬럼 배열에 해당 인덱스 값이 true면");
                System.out.println("setZeros:매트릭스에 인덱스에 해당하는 컬럼에 모든 값을 0으로 변경. j (" + j + ")");
			}
		}
	}	
	
	public static boolean matricesAreEqual(int[][] m1, int[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length) {
			return false;
		}
		
		for (int k = 0; k < m1.length; k++) {
			for (int j = 0; j < m1[0].length; j++) {
				if (m1[k][j] != m2[k][j]) {
					return false;
				}
			}
		}	
		return true;
	}
	
	public static int[][] cloneMatrix(int[][] matrix) {
		int[][] c = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				c[i][j] = matrix[i][j];
			}
		}
		return c;
	}
	
	public static void main(String[] args) {

        StringBuffer problem = new StringBuffer();
        problem.append("MxN 행렬의 한 원소가 0일 경우, 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을 작성하라.");
        System.out.println("---------------------------- 문제 시작 -----------------------");
        System.out.println(problem);
        System.out.println("---------------------------- 문제 끝 ------------------------");
        StringBuffer description = new StringBuffer();
        description.append("어떤 원소가 0인지 기록할 행렬 하나를 더 둔다.\n");
        description.append("그 행렬에 올바른 값을 기록하는 단계를 수행하고 나서, 그 다음 단계에서 행렬의 다른 원소 값을 0으로 조정한다.\n");
        description.append("그러려면 O(MN)만큼 공간이 필요하다.\n");
        description.append("그러나 같은 행과 열의 모든 원소의 값을 0으로 만들 것이므로,\n");
        description.append("어떤 행 안에 0 값, 어떤 열 안에 0값을 갖는 원소가 있는지만 기록하면 된다.\n");
        description.append("0으로 만들어야 할 행과 열의 위치를 추적하는 두 개의 배열을 사용한다.");
        System.out.println("---------------------------- 해설 시작 (해법 1) -----------------------");
        System.out.println(description);
        System.out.println("---------------------------- 해설 끝 (해법 1) ------------------------");

        System.out.println("---------------------------- 코드 실행 시작 (해법 1) -----------------------");

		int nrows = 10;
		int ncols = 15;
		int[][] matrix1 = AssortedMethods.randomMatrix(nrows, ncols, 0, 100);		
		int[][] matrix2 = cloneMatrix(matrix1);

		AssortedMethods.printMatrix(matrix1);
		
		setZeros(matrix1);
		setZeros2(matrix2);
		
		System.out.println();
		
		AssortedMethods.printMatrix(matrix1);
		System.out.println();
		AssortedMethods.printMatrix(matrix2);
		
		if (matricesAreEqual(matrix1, matrix2)) {
			System.out.println("Equal");
		} else {
			System.out.println("Not Equal");
		}
        System.out.println("---------------------------- 코드 실행 끝 (해법 1) -----------------------");
	}
}
