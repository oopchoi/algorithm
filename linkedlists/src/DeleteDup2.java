/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 12. 2.
 * Time: 오전 3:04
 * To change this template use File | Settings | File Templates.
 *
 * 다음의 비정렬 연결 리스트에서 중복 문자를 제거하는 코드를 작성하라.
 *
 * 연관문제
 * 임시 버퍼가 허용되지 않는 상황에서 이 문제를 어떻게 해결할 수 있겠는가?
 *
 * 버퍼가 없는 경우
 */
public class DeleteDup2 {
    public static void deleteDups(LinkedListNode head){
        if(head == null) return;

        LinkedListNode current = head;
        while (current != null){
            // 같은 값을 갖는 이후 노드들을 제거
            LinkedListNode runner = current;
            while (runner.next != null){
                if (runner.next.data == current.data){
                    runner.next = runner.next.next;
                }else {
                    runner = runner.next;
                }
            }
            System.out.println(current.data);
            current = current.next;
        }
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

        DeleteDup2.deleteDups(n1);
    }
}
