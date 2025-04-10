//递归调用
class Solution1 {
    private ListNode frontPointer;
    public boolean recursivelyCheck(ListNode currentNode){
        if(currentNode !=null){
            if(!recursivelyCheck(currentNode.next)){
                return false;
            }
            if(currentNode.val != frontPointer.val){
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
     frontPointer = head;
     return recursivelyCheck(head);
    }
}
//快慢指针找到中间节点，然后对后半链表进行反转，遍历比较
class Solution2{
    public boolean isPalindrome(ListNode head) {
        if(head == null)
        return true;
        ListNode node1 = head ,node2 = head;
        while(node2.next!=null && node2.next.next!=null)//双指针遍历条件
        {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        ListNode temp2 = reverse(node1);
        ListNode temp = head;
        while(temp!=null && temp2!=null)
         {
            if(temp.val!=temp2.val)
             return false;
            else{
                temp2 = temp2.next;
                temp = temp.next;
            }
         }
         return true;
    }
    public ListNode reverse(ListNode node){
        ListNode cur = node,pre = null;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
