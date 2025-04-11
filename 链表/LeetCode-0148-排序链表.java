class Solution {
    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }
    public ListNode sortList(ListNode head,ListNode tail){
        if(head==null){
            return head;
        }
        if(head.next == tail){
            head.next = null;//如果两个结点相邻则断开
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=tail) {
            slow = slow.next;
            fast = fast.next;
            if(fast!=tail)
            fast = fast.next;
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode ans = merge(list1,list2);
        return ans;
    }
    public ListNode merge(ListNode node1,ListNode node2){
       ListNode dummyNode = new ListNode(0);
       ListNode temp = dummyNode;
       ListNode temp1 = node1;
       ListNode temp2 = node2;
       while(temp1!=null && temp2!=null){
        if(temp1.val<=temp2.val){
            temp.next = temp1;
            temp1 = temp1.next;
        }else{
            temp.next = temp2;
            temp2 = temp2.next;
        }
        temp = temp.next;
       }
       if(temp1!=null) temp.next = temp1;
       else if(temp2!=null) temp.next = temp2;
       return dummyNode.next;
    }
}
