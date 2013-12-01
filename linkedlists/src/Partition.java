/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 12. 2.
 * Time: 오전 3:56
 * To change this template use File | Settings | File Templates.
 *
 * x값을 갖는 노드를 기준으로 연결 리스트를 나누는 코드를 작성하라.
 * x보다 작은 값을 갖는 노드가 x와 같거나 더 큰 값을 갖는 노드들보다 앞쪽에 오도록 하면 된다.
 *
 * 두 개의 연결 리스트를 사용하는 방법
 */
public class Partition {
    /**
     * 첫 번째 인자는 입력으로 사용될 리스트의 맨 첫 번째 노드와 분할 기준이 되는 정수 값
     */
    public LinkedListNode partition(LinkedListNode node, int x){
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        // 리스트 분할
        while (node != null){
            LinkedListNode next = node.next;
            node.next = null;
            if (node.data < x){
                // 노드를 before 리스트의 마지막에 삽입
                if (beforeStart == null){
                    beforeStart = node;
                    beforeEnd = beforeStart;
                }else{
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            }else {
                // 노드를 after 리스트의 마지막에 삽입
                if (afterStart == null){
                    afterStart = node;
                    afterEnd = afterStart;
                }else{
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null){
            return afterStart;
        }

        // before 리스트와 after 리스트를 결합
        beforeEnd.next = afterStart;
        return beforeStart;
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

        Partition p = new Partition();
        LinkedListNode beforeStart = p.partition(n1, 3);
        p.sout(beforeStart);
    }
}
