//快慢指针终将相遇
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
        return false;
        ListNode fast = head.next;//避免while循环不运行
        ListNode slow = head;
        while(fast!=slow){
            if(fast==null || fast.next ==null)
            return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
