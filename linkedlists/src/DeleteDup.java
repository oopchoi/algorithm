import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 12. 2.
 * Time: 오전 2:36
 * To change this template use File | Settings | File Templates.
 *
 * 다음의 비정렬 연결 리스트에서 중복 문자를 제거하는 코드를 작성하라.
 *
 * 연관문제
 * 임시 버퍼가 허용되지 않는 상황에서 이 문제를 어떻게 해결할 수 있겠는가?
 */
public class DeleteDup {
    public static void deleteDups(LinkedListNode n){
        Hashtable table = new Hashtable();
        LinkedListNode previous = null;
        while (n != null){
            if (table.containsKey(n.data)){
                previous.next = n.next;
            }else{
                table.put(n.data, true);
                System.out.println(n.data);
                previous = n;
            }
            n = n.next;
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

        DeleteDup.deleteDups(n1);
    }
}
