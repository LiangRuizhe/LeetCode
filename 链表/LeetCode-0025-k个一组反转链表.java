class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
      ListNode dummyNode = new ListNode(0);
      dummyNode.next = head;
      ListNode pre = dummyNode;
      while(head!=null){
        ListNode tail = pre;
        for(int i=0;i<k;i++){
            tail = tail.next;
            if(tail==null)
            return dummyNode.next;
        }
        ListNode nex = tail.next;
        ListNode[] res = Reverse(head, tail);
        head = res[0];
        tail = res[1];
        pre.next = head;
        tail.next = nex;
        pre  = tail;
        head = tail.next;
      }
      return dummyNode.next;
    }
    public ListNode[] Reverse(ListNode head,ListNode tail){
        ListNode prev = tail.next;
        ListNode p =head;
        while(prev!=tail){
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail,head};
    }
}
