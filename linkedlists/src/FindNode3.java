/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 12. 2.
 * Time: 오전 3:34
 * To change this template use File | Settings | File Templates.
 *
 * 단방향 연결 리스트에서, 뒤에서 k번째 원소를 찾는 알고리즘을 구현하라.
 *
 * 연결 리스트 길이를 아는 경우 : 만일 연결 리스트의 길이를 알고 있다면,
 * 맨 마지막 원소에서 k번째 원소는 앞에서부터 따지면 (length-k)번째 원소가 된다.
 * 이 원소부터 시작해서 리스트를 순회해 나가면 된다. (너무 쉬워서 100% 답이 아님)
 *
 * 순환적 해법으로 직관적이지는 않지만 좀 더 최적인 방법이다.
 */
public class FindNode3 {
    LinkedListNode nthToLast(LinkedListNode head, int k){
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        // p2를 리스트 뒤쪽으로 k번 이동시킨다.
        for (int i=0; i<k-1; i++){
            if (p2 == null) return null; // 오류 검사
            p2 = p2.next;
        }
        if (p2 == null) return null;

        /* 이제 p1과 p2를 같은 속도로 움직인다. p2가 마지막 노드에 도달하면,
            p1이 가리키는 노드가 답이다.
         */
        while (p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println(p1.data);
        return p1;
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

        FindNode3 f = new FindNode3();
        f.nthToLast(n1, 2);
    }
}
