package link;

import common.ListNode;

/**
 * 合并两个排序的链表
 *
 *
 */
public class _02_merge_sorted_lists {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode pNode1 = list1;
        ListNode pNode2 = list2;

        if(pNode1 == null){
            return pNode2;
        }
        if(pNode2 == null){
            return pNode1;
        }

        ListNode pMergedHead = null;
        if(pNode1.val < pNode2.val){
            pMergedHead = pNode1;
            pMergedHead.next = Merge(pNode1.next, pNode2);
        }else{
            pMergedHead = pNode2;
            pMergedHead.next = Merge(pNode1, pNode2.next);
        }

        return pMergedHead;

    }

}
