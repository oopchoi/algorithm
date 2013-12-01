/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 12. 2.
 * Time: 오전 2:42
 * To change this template use File | Settings | File Templates.
 *
 * 단방향 연결 리스트
 */
public class LinkedListNode {
    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    LinkedListNode next = null;
    int data;
    public LinkedListNode(int d){
        data = d;
    }

    /**
     * 노드 추가
     * @param d
     */
    void appendToTail(int d){
        LinkedListNode end = new LinkedListNode(d);
        LinkedListNode n = this;
        while (n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    /**
     * 노드 삭제
     *
     * @param head
     * @param d
     * @return
     */
    LinkedListNode deleteNode(LinkedListNode head, int d){
        LinkedListNode n = head;
        if(n.data == d){
            return head.next;   // head가 변경된다.
        }

        while (n.next != null){
            if (n.next.data == d){
                n.next = n.next.next;
                return head;    // head는 바뀌지 않는다.
            }
            n = n.next;
        }
        return head;
    }
}
