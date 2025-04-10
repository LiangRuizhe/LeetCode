//方法1：每次遍历都将listA中的数组插入哈希表中，在遍历listB查看哈希表中是否存在对应元素
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      Set<ListNode> ansA = new HashSet<ListNode>();
      ListNode temp = headA;
      while(temp!=null){
        ansA.add(temp);
        temp = temp.next;
      }
      temp = headB;
      while(temp!=null){
        if(ansA.contains(temp)){
            return temp;
        }
        temp = temp.next;
      }
      return null;
}
//方法2：双指针，同样走长度为ListA+ListB，终会相遇
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      ListNode pA = headA , pB = headB;
      if(pA == null || pB ==null)
      return null;
      while(pA!=pB){
        pA = (pA!=null ? pA.next : headB);
        pB = (pB!=null ? pB.next : headA);
      }
      return pA;
}
}
