/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 12. 2.
 * Time: 오전 4:12
 * To change this template use File | Settings | File Templates.
 *
 * x값을 갖는 노드를 기준으로 연결 리스트를 나누는 코드를 작성하라.
 * x보다 작은 값을 갖는 노드가 x와 같거나 더 큰 값을 갖는 노드들보다 앞쪽에 오도록 하면 된다.
 *
 * 두 개의 연결 리스트를 사용하는 방법 : before와 after의 앞쪽에 삽입하는 방법
 */
public class Partition2 {
    public LinkedListNode partition(LinkedListNode node, int x){
        LinkedListNode beforeStart = null;
        LinkedListNode afterStart = null;
        // 리스트 분할
        while (node != null){
            LinkedListNode next = node.next;
            if (node.data < x){
                // before 리스트의 앞에 노드 삽입
                node.next = beforeStart;
                beforeStart = node;
            }else{
                // after 리스트의 앞에 노드 삽입
                node.next = afterStart;
                afterStart = node;
            }
            node = next;
        }

        // before 리스트와 after 리스트의 결합
        if (beforeStart == null){
            return afterStart;
        }

        // before 리스트의 끝을 찾은 다음, 두 리스트를 결합한다.
        LinkedListNode head = beforeStart;
        while (beforeStart.next != null){
            beforeStart = beforeStart.next;
        }
        beforeStart.next = afterStart;

        return head;
    }

    public void sout(LinkedListNode n){
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
        LinkedListNode n1 = new LinkedListNode(4);
        LinkedListNode n2 = new LinkedListNode(5);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(1);
        LinkedListNode n5 = new LinkedListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Partition2 p = new Partition2();
        LinkedListNode beforeStart = p.partition(n1, 3);
        p.sout(beforeStart);
    }
}
