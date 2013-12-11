package Question2_2;

import CtCILibrary.*;

public class Question {

	public static int nthToLastR1(LinkedListNode head, int n) {
		if (n == 0 || head == null) {
			return 0;
		}
		int k = nthToLastR1(head.next, n) + 1;
        System.out.println("nthToLastR1:" + head.toString() + ", n:" + n + ", k:" + k);
        if (k == n) {
			System.out.println(n + "th to last node is " + head.data);
		}
		return k;
	}
	
	public static LinkedListNode nthToLastR2(LinkedListNode head, int n, IntWrapper i) {
		if (head == null) {
			return null;
		}
        System.out.println("h ("+ head.data + "), n (" + n + "), i.value (" + i.value + ")1111111111");
        LinkedListNode node = nthToLastR2(head.next, n, i);
        System.out.println("h ("+ head.data + "), n (" + n + "), i.value (" + i.value + ")2222222222");
		i.value = i.value + 1;
        System.out.println("h ("+ head.data + "), n (" + n + "), i.value (" + i.value + ")3333333333");
		if (i.value == n) {
            System.out.println("h ("+ head.data + "), n (" + n + "), i.value (" + i.value + ")44444444");
			return head;
		}
        // 4번째 3초 슬립 시켜서 함수들이 스택에 대기하고 있음을 확인할 수 있다.
        if(i.value == 4){
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        System.out.println("h ("+ head.data + "), n (" + n + "), i.value (" + i.value + ")5555555555555");
		return node;
	}
	
	public static Result nthToLastR3Helper(LinkedListNode head, int k) {
		if (head == null) {
			return new Result(null, 0);
		}
        System.out.println("nthToLastR3Helper:head:" + head.toString());

        Result res = nthToLastR3Helper(head.next, k);

		if (res.node == null) {
			res.count++;
            System.out.println("res.node == null:"+res.toString());
			if (res.count == k) {
                res.node = head;
			}
		}

        System.out.println("nthToLastR3Helper:res:" + res.toString());
        return res;
	}	
	
	public static LinkedListNode nthToLastR3(LinkedListNode head, int k) {
		Result res = nthToLastR3Helper(head, k);
        System.out.println("nthToLastR3:"+res.toString());
        if (res != null) {
			return res.node;
		}
		return null;
	}		
	
	public static LinkedListNode nthToLast(LinkedListNode head, int n) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		if (n <= 0) return null;
		
		// Move p2 n nodes into the list.  Keep n1 in the same position.
        System.out.println("nthToLast:n-1번째의 ");
        System.out.println("nthToLast:입력받은 정수의 갯수만큼 next를 뒤져서 null이 발생한다면");
        System.out.println("nthToLast:LinkedList 요소의 갯수를 입력 받은 정수가 오버한다는 의미이므로 null을 반환한다.");
        for (int i = 0; i < n - 1; i++) {
            if (p2 == null) {
				return null; // Error: list is too small.
			}
            System.out.println("nthToLast:i (" + i + "), n, (" + n + "), p2.data (" + p2.data + ")");
            p2 = p2.next;
		}
        System.out.println("nthToLast:결국 p2.data (" + p2.data + ")");
        if (p2 == null) { // Another error check.
			return null;
		}
		
		// Move them at the same pace.  When p2 hits the end, 
		// p1 will be at the right element.
        System.out.println("p1의 노드를, p2의 next가 null(마지막노드)까지 동시에 이동하면 p1은 n-1노드에 도착하게 된다.");
        while (p2.next != null) {
            System.out.println("nthToLast:p1 (" + p1.data + "), p2.data (" + p2.data + ")");
			p1 = p1.next;
			p2 = p2.next;

	  	}
        System.out.println("nthToLast:최종 이동 결과의 p1 (" + p1.data + "), p2.data (" + p2.data + ")");
	  	return p1;
	}
	
	public static void main(String[] args) {
        StringBuffer problem = new StringBuffer();
        problem.append("단방향 연결 리스트에서, 뒤에서 k번째 원소를 찾는 알고리즘을 구현하라.");
        System.out.println("---------------------------- 문제 시작 -----------------------");
        System.out.println(problem);
        System.out.println("---------------------------- 문제 끝 ------------------------");
        StringBuffer description = new StringBuffer();
        description.append("재귀적 해법. Wrapper 클래스 구현\n");
        System.out.println("---------------------------- 해설 시작 (해법 1) -----------------------");
        System.out.println(description);
        System.out.println("---------------------------- 해설 끝 (해법 1) ------------------------");

        System.out.println("---------------------------- 코드 실행 시작 (해법 1) -----------------------");

		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		int nth = 3;
		IntWrapper wr = new IntWrapper();

        LinkedListNode n = nthToLastR2(head, nth, wr);
        System.out.println(n.data);
        System.out.println("---------------------------- 코드 실행 끝 (해법 1) -----------------------");

        description.append("순환적 방법.");
        System.out.println("---------------------------- 해설 시작 (해법 2) -----------------------");
        System.out.println(description);
        System.out.println("---------------------------- 해설 끝 (해법 2) ------------------------");

        System.out.println("---------------------------- 코드 실행 시작 (해법 2) -----------------------");

        System.out.println(head.printForward());

        n = nthToLast(head, nth);
        System.out.println(n.data);

        /*LinkedListNode n = nthToLastR3(head, nth);
		nthToLastR1(head, nth);
		if (n != null) {
			System.out.println(nth + "th to last node is " + n.data);
		} else {
			System.out.println("Null.  n is out of bounds.");
		}*/
        System.out.println("---------------------------- 코드 실행 끝 (해법 2) -----------------------");
	}

}
