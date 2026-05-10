# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        cur = dummy

        carry = 0 #initialize a carry-value of 0 outside of the loop
        #iterature through these nodes while eiteher of them has a digit/is nonnull
        while l1 or l2 or carry: #is non-null or CARRY. important for edge-case
            #v1 is going to be the digit of list 1 only if list 1 is nonnull, if null, set it to 0
            v1 = l1. val if l1 else 0
            v2 = l2.val if l2 else 0

            # new digit
            val = v1 + v2 + carry
            # we could have a new carry, say 15. we want to get the carry out of it by doing this
            carry = val // 10
            #if our value is bigger than 10, we need only the ones place so we need a modulo
            val = val % 10
            #insert a new list node with the value we just completed
            cur.next = ListNode(val)

            # update pointers/ptrs
            cur = cur.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None 

        return dummy.next

        