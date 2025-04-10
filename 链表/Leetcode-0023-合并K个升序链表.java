//k次循环，每次合并两个链表
//归并加合并两个链表
class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int l,int r){
        if(l==r)
        return  lists[l];
        if(l>r)
        return null;
        int mid = (l+r)/2;
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }
    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
         if(list1 == null) return list2;
         if(list2 == null) return list1;
         ListNode preHead = new ListNode(0);
         ListNode pre = preHead;
         while(list1 != null && list2 != null){
            if(list1.val<list2.val){
                pre.next = list1;
                list1 = list1.next;
            }else{
                pre.next = list2;
                list2= list2.next;
            }
            pre = pre.next;
         }
         pre.next =  list1 == null ? list2 : list1;
         return preHead.next;
    }
}
