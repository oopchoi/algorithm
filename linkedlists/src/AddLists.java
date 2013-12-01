/**
 * Created with IntelliJ IDEA.
 * User: oopchoi
 * Date: 13. 12. 2.
 * Time: 오전 4:21
 * To change this template use File | Settings | File Templates.
 *
 * 연결 리스트로 표현된 두 개의 수가 있다고 하자.
 * 리스트의 각 노드는 해당 수의 각 자릿수를 표현한다.
 * 이때 자릿수들은 역순으로 배열되는데,
 * 1의 자릿수가 리스트의 맨 앞에 오도록 배열된다는 뜻이다.
 * 이 두 수를 더하여 그 합을 연결 리스트로 반환하는 함수를 작성하라.
 *
 * 연관문제
 * 각 자릿수가 정상적으로 배열된다고 가정하고 구현해 보자.
 */
public class AddLists {
    LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry){
        // 두 리스트가 null이고 carry 값이 0이면 종료
        if(l1==null && l2==null && carry==0){
            return null;
        }

        LinkedListNode result = new LinkedListNode(carry);
        // value의 값과 l1, l2에 보관된 값 합산
        int value = carry;
        if (l1!=null){
            value += l1.data;
        }
        if (l2!=null){
            value += l2.data;
        }

        result.data = value % 10;   // 1의 자릿수

        // 재귀 호출
        if (l1!=null || l2!=null || value>=10){
            LinkedListNode more = addLists(l1==null?null:l1.next, l2==null?null:l2.next, value>=10?1:0);
            result.setNext(more);
        }
        return result;
    }
}
