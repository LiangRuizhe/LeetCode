class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);//添加哑节点防止出现链表只有一个结点，删除后变成空表的情况
        ListNode temp1 = dummy;
        ListNode temp2 = head;
        for(int i=0;i<n;i++){
            temp2=temp2.next;
        }
        while(temp2!=null){
            temp1=temp1.next;
            temp2=temp2.next;
        }
        temp1.next=temp1.next.next;
        return dummy.next;
    }
}
