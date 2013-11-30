/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 11. 30.
 * Time: 오후 3:49
 * To change this template use File | Settings | File Templates.
 *
 * MxN 행렬의 한 원소가 0일 경우, 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을 작성하라.
 */
public class SetZero {

    public void setZeros(int[][] matrix){
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // 0인 원소가 있는 행과 열의 첨자(index)값을 저장한다.
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // i행이나 j열이 0인 원소를 갖는 경우, arr[i][j]의 값을 0으로 만든다.
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++){
                if((row[i] || column[j])){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
