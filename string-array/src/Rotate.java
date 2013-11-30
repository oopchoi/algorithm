/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 11. 30.
 * Time: 오후 3:38
 * To change this template use File | Settings | File Templates.
 *
 * 이미지를 표현하는 NxN 행렬이 있다. 이미지의 각 픽셀은 4바이트로 표현된다.
 * 이 때 이미지를 90도 회전시키는 메서드를 작성하라.
 * 부가적인 행렬을 사용하지 않고서도 할 수 있겠는가?
 */
public class Rotate {
   public void rotate(int[][] matrix, int n){
       for(int layer=0; layer<n/2; ++layer){
           int first = layer;
           int last = n - 1 - layer;
           for(int i=first; i<last; i++){
               int offset = i-first;
               // 위쪽을 저장
               int top = matrix[first][i];
               // 왼쪽 -> 위쪽
               matrix[first][i] = matrix[last-offset][first];
               // 아래 -> 왼쪽
               matrix[last-offset][first] = matrix[last][last-offset];
               // 오른쪽 -> 아래
               matrix[last][last-offset] = matrix[i][last];
               // 위 -> 오른쪽
               matrix[i][last] = top;
           }
       }
   }

    public static void main(String[] args) {
        Rotate r = new Rotate();
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
        r.rotate(matrix,3);
    }
}
