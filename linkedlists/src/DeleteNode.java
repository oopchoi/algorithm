/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 12. 2.
 * Time: 오전 3:41
 * To change this template use File | Settings | File Templates.
 *
 * 단방향 연결 리스트의 중간에 있는 노드 하나를 삭제하는 알고리즘을 구현하라.
 * 삭제할 노드에 대한 접근만 가능하다는 것에 유의하라.
 */
public class DeleteNode {
    public static boolean deleteNode(LinkedListNode n){
        if (n==null || n.next==null){
            return false;   // Failure
        }
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    public static void sout(LinkedListNode n){
        if(n==null) return;

        while (n.next!=null){
            if(n!=null){
                System.out.println(n.data);
                n = n.next;
            }
        }
        System.out.println(n.data);
    }

    public static void main(String[] args) {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        LinkedListNode n5 = new LinkedListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        DeleteNode.deleteNode(n3);
        DeleteNode.sout(n1);
    }
}
