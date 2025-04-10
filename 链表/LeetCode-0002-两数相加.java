class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode temp = null;
        int jinwei = 0;
        while(l1!=null || l2!=null){
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum  = n1 + n2 + jinwei;
            jinwei = sum /10;
            if(head==null){
                head = temp = new ListNode(sum%10);
            }else{
                temp.next = new ListNode(sum%10); 
                temp = temp.next;
            }
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
            if(jinwei==1)
             temp.next = new ListNode(jinwei);
        }
        return head;
    }
}
