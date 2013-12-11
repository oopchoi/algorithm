package Question2_2;

import CtCILibrary.*;

public class Result {
	public LinkedListNode node;
	public int count;
	public Result(LinkedListNode n, int c) {
		node = n;
		count = c;
	}

    public String toString(){
        String description = "";
        if(node!=null)
            description = node.toString() + ", count:" + count;
        else
            description = "node is null, count:" + count;
        return description;
    }
}
