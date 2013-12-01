/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 12. 2.
 * Time: 오전 3:15
 * To change this template use File | Settings | File Templates.
 *
 * 단방향 연결 리스트에서, 뒤에서 k번째 원소를 찾는 알고리즘을 구현하라.
 *
 * 연결 리스트 길이를 아는 경우 : 만일 연결 리스트의 길이를 알고 있다면,
 * 맨 마지막 원소에서 k번째 원소는 앞에서부터 따지면 (length-k)번째 원소가 된다.
 * 이 원소부터 시작해서 리스트를 순회해 나가면 된다. (너무 쉬워서 100% 답이 아님)
 *
 * 재귀적 해법으로 원소를 반환하지 않는 방법을 사용한다.
 */
public class FindNode {
    public static int nthToLast(LinkedListNode head, int k){
        if (head == null){
            return 0;
        }

        int i = nthToLast(head.next, k) + 1;
        if (i == k){
            System.out.println(head.data);
        }
        return i;
    }

    public static void main(String[] args) {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(2);
        LinkedListNode n4 = new LinkedListNode(4);
        LinkedListNode n5 = new LinkedListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        FindNode.nthToLast(n1, 2);
    }
}
