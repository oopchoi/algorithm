package Question2_1;

import CtCILibrary.LinkedListNode;

import java.util.Hashtable;

public class Question {
	public static int tapB = 0;
	public static int tapC = 0;
	
	public static void tap(int i) {
		if (i == 0) {
			tapB++;
		} else {
			tapC++;
		}
	}

    /**
     * Hashtable을 활용한 중복 제거
     * @param n
     */
	public static void deleteDupsA(LinkedListNode n) {
		Hashtable table = new Hashtable();
		LinkedListNode previous = null;
        System.out.println("deleteDupsA:previous 변수를 null로 초기화 한다.");
        while (n != null) {
            System.out.println("deleteDupsA:Hashtable에 노드의 값을 키로 사용해서 존재하는지 판단한다.");
            if (table.containsKey(n.data)) {
                System.out.println("deleteDupsA:있으면 다음 노드를 previous 객체의 next에 할당한다.");
                previous.next = n.next;
			} else {
                System.out.println("deleteDupsA:없으면 현재 노드의 데이터를 키로 true를 값으로 사용해서 HashTable에 입력하고");
                table.put(n.data, true);
                System.out.println("deleteDupsA:현재 노드를 previous 변수에 할당한다.");
                previous = n;
			}
            System.out.println("deleteDupsA:최종적으로 현재 노드에 next노드를 할당한다.");
            n = n.next;
		}
	}
	
	public static void deleteDupsC(LinkedListNode head) {
		if (head == null) return;
		LinkedListNode previous = head;
		LinkedListNode current = previous.next;
		while (current != null) {
			// Look backwards for dups, and remove any that you see.
			LinkedListNode runner = head;
			while (runner != current) { 
				tap(1);
				if (runner.data == current.data) {
					LinkedListNode tmp = current.next;
					previous.next = tmp;
					current = tmp;
					/* We know we can�t have more than one dup preceding
					 * our element since it would have been removed 
					 * earlier. */
				    break;
				}
				runner = runner.next;
			}
			
			/* If runner == current, then we didn�t find any duplicate 
			 * elements in the previous for loop.  We then need to 
			 * increment current.  
			 * If runner != current, then we must have hit the �break� 
			 * condition, in which case we found a dup and current has
			 * already been incremented.*/
			if (runner == current) {
				previous = current;
		        current = current.next;
			}
		}
	}

    /**
     * 두 개의 포인터를 사용하여 중복을 제거한다.
     * @param head
     */
	public static void deleteDupsB(LinkedListNode head) {
		if (head == null) return;
		
		LinkedListNode current = head;
        System.out.println("deleteDupsB:current 변수에 head를 할당한다.");
        while (current != null) {
			/* Remove all future nodes that have the same value */
			LinkedListNode runner = current;
            System.out.println("deleteDupsB:current가 null이 아니면 runner 변수에 current를 할당한다.");
			while (runner.next != null) {
				//tap(0);
                System.out.println("deleteDupsB:runner.next 데이터와 current의 데이터가 같다면");
				if (runner.next.data == current.data) {
                    System.out.println("deleteDupsB:runner.next에 runner.next.next를 할당하고");
                    runner.next = runner.next.next;
				} else {
                    System.out.println("deleteDupsB:같지 않다면 runner에 runner.next를 할당한다.");
                    runner = runner.next;
				}
			}
            System.out.println("deleteDupsB:current 변수에 current.next를 할당한다.");
		}
	}	
	
	public static void main(String[] args) {
        StringBuffer problem = new StringBuffer();
        problem.append("다음의 비정렬 연결 리스트에서 중복 문자를 제거하는 코드를 작성하라.\n");
        problem.append("연관문제 : 임시 버퍼가 허용되지 않는 상황에서 이 문제를 어떻게 해결할 수 있겠는가?");
        System.out.println("---------------------------- 문제 시작 -----------------------");
        System.out.println(problem);
        System.out.println("---------------------------- 문제 끝 ------------------------");
        StringBuffer description = new StringBuffer();
        description.append("연결 리스트에서 중복을 제거하기 위해서는 중복을 추적할 필요가 있다.\n");
        description.append("단순히 연결 리스트를 순회하면서 각 원소를 해시 테이블에 저장하고\n");
        description.append("그러다 중복을 발견하면, 그 원소는 제거하고 계속 진행한다.\n");
        description.append("이 알고리즘은 O(N) 시간에 수행된다.");
        System.out.println("---------------------------- 해설 시작 (해법 1) -----------------------");
        System.out.println(description);
        System.out.println("---------------------------- 해설 끝 (해법 1) ------------------------");

        System.out.println("---------------------------- 코드 실행 시작 (해법 1) -----------------------");
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
        System.out.println(first.data + ", " + head.data + ", " + second.data);
        int[] num = {0,3,1,5,2,4,6,4,2,7};
        for (int i = 1; i < 10; i++) {
			second = new LinkedListNode(num[i], null, null);
            System.out.println("second = new LinkedListNode(" + i + ")");
            System.out.println("i ("+ i + "), h (" + head + ")");
            System.out.println("i ("+ i + "), f (" + first + ")");
            System.out.println("i ("+ i + "), s (" + second + ")");
            first.setNext(second);
            System.out.println("first.setNext(second)");
            System.out.println("i ("+ i + "), h (" + head + ")");
            System.out.println("i ("+ i + "), f (" + first + ")");
            System.out.println("i ("+ i + "), s (" + second + ")");
			second.setPrevious(first);
            System.out.println("second.setPrevious(first)");
            System.out.println("i ("+ i + "), h (" + head + ")");
            System.out.println("i ("+ i + "), f (" + first + ")");
            System.out.println("i ("+ i + "), s (" + second + ")");
			first = second;
		}
		System.out.println(head.printForward());

        LinkedListNode clone = head.clone();

        deleteDupsA(head);
		/*deleteDupsB(head);
		deleteDupsC(clone);*/
        System.out.println(head.printForward());
        System.out.println("---------------------------- 코드 실행 끝 (해법 1) -----------------------");

        description.delete(0, description.length());
        description.append("버퍼가 없다면 두 개의 포인터를 사용해 순회하여 문제를 해결한다.");
        System.out.println("---------------------------- 해설 시작 (해법 2) -----------------------");
        System.out.println(description);
        System.out.println("---------------------------- 해설 끝 (해법 2) ------------------------");

        System.out.println("---------------------------- 코드 실행 시작 (해법 2) -----------------------");
		deleteDupsB(clone);
        System.out.println(clone.printForward());
        System.out.println("---------------------------- 코드 실행 끝 (해법 2) -----------------------");
	}
}
