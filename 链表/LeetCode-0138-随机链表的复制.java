//在每个结点后，复制一个结点，复制随机结点，拆分链表
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
        return null;
        Node temp = head;
        while(temp!=null){
            Node clone = new Node(temp.val);
            clone.next = temp.next;
            temp.next = clone;
            temp = temp.next.next;
        }
        temp = head;
        while(temp!=null){
            temp.next.random = (temp.random!=null) ? temp.random.next : null;
            temp = temp.next.next;
        }
        Node newHead = head.next;
        temp = head;
        while(temp!=null){
             Node clone  = temp.next;
             temp.next = temp.next.next;
             clone.next = (clone.next!=null)?clone.next.next:null;//拆分链表时的赋值条件
             temp = temp.next;
        }
        return newHead;
    }
}
