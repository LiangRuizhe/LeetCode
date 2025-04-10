//快慢指针，相遇后，慢指针和头指针一起运动，第一次重合即为环入口。
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next ==null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            slow = slow.next;
            if(fast.next!=null)
            fast = fast.next.next;
            else
            return null;//无环终止条件
            if(fast==slow){
                ListNode temp = head;
                while(temp!=slow){
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }
}
