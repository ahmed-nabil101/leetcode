package DesignHashMap;
class MyHashMap {
    final ListNode[] nodes = new ListNode[10000];

    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = hash(key);
        if(nodes[i] == null)
            nodes[i] = new ListNode(-1, -1);
        ListNode prev = find(nodes[i], key);
        if(prev.next == null)
            prev.next = new ListNode(key, value);
        else
            prev.next.val = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = hash(key);
        if(nodes[i] == null)
            return -1;
        ListNode prev = find(nodes[i], key);
        return prev.next == null ? -1 : prev.next.val;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = hash(key);
        if(nodes[i] == null) return;
        ListNode prev = find(nodes[i], key);
        if(prev.next == null) return;
        prev.next = prev.next.next;
    }

    private int hash(int key) {
        return key % 10000; // Integer.hashCode(key) % 10000
    }

    private ListNode find(ListNode bucket, int key) {
        ListNode node = bucket, prev = null;
        while(node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    static class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
