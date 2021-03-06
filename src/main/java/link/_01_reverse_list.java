package link;

import common.ListNode;
import common.TreeNode;

/**
 * 反转链表
 *
 *
 */
public class _01_reverse_list {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode last = null;
        ListNode current = head;
        ListNode next = head.next;
        while(current != null){
            current.next = last;

            last = current;
            current = next;
            if(next != null){
                next = current.next;
            }
        }

        return last;
    }

    public static void test(TreeNode root){
        if(root == null){
            System.out.println();
        }


    }

}
