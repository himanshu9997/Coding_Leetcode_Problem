var modifiedList = function(nums, head) {
    const set = new Set(nums);
    let cur = new ListNode(null, head);
    let newHead = cur;

    while(cur.next) {
        if(set.has(cur.next.val)) {
            cur.next = cur.next.next;
        } else {
            cur = cur.next;
        }
    }

    return newHead.next;
};