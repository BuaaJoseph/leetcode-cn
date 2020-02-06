/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 
 * 给定的 n 保证是有效的。
 * 
 * 进阶：
 * 
 * 你能尝试使用一趟扫描实现吗？
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode endPoint = head, delPoint = head;
        while (n > 1) {
            endPoint = endPoint.next;
            if (endPoint == null) {
                return head;
            }
            n--;
        }

        ListNode delPrePoint = delPoint;
        while (endPoint.next != null) {
            endPoint = endPoint.next;
            delPrePoint = delPoint;
            delPoint = delPoint.next;
        }

        if (delPrePoint == delPoint) {
            return head.next;
        }
        // delete
        delPrePoint.next = delPoint.next;
        delPoint.next = null;
        return head;
    }
}