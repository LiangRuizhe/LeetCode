//方法1：双指针迭代，cur,pre,next
class Solution1 {
    public ListNode reverseList(ListNode head) {
         ListNode cur = head, pre = null;
         while(cur!=null){
             ListNode temp = cur.next;
             cur.next = pre;
             pre = cur;
             cur = temp;
        }
        return pre;
    }
}
