package link;

import common.ListNode;

/**
 * 反转链表
 *
 *
 */
public class _01_reverse_list {
    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pReversedNode = null;

        ListNode pPre = null;
        ListNode pCur = head;

        while(pCur != null){
            ListNode pNext = pCur.next;

            if(pNext == null){
                pReversedNode = pCur;
            }

            pCur.next = pPre;
            pPre = pCur;
            pCur = pNext;

        }

        return pReversedNode;

    }

}
