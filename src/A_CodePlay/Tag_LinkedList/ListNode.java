package A_CodePlay.Tag_LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }
    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode currNode = this;
        StringBuilder s = new StringBuilder();
        while (currNode != null) {
            s.append(currNode.val);
            s.append(" -> ");
            currNode = currNode.next;
        }
        // 最后添加一个 NULL 标志表示添加到末尾了
        s.append("NULL");
        return s.toString();
    }
}
