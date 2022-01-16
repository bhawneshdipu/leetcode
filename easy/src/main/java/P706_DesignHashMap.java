import java.util.Arrays;

/**
 *  The general implementation of HashMap uses bucket which is basically a chain of linked lists and each node containing <key, value> pair.
 *     So if we have duplicate nodes, that doesn't matter - it will still replicate each key with it's value in linked list node.
 *     When we insert the pair (10, 20) and then (10, 30), there is technically no collision involved. We are just replacing the old value with the new value for a given key 10, since in both cases, 10 is equal to 10 and also the hash code for 10 is always 10.
 *     Collision happens when multiple keys hash to the same bucket. In that case, we need to make sure that we can distinguish between those keys. Chaining collision resolution is one of those techniques which is used for this.
 *     Just for the information. In JDK 8, HashMap has been tweaked so that if keys can be compared for ordering, then any densely-populated bucket is implemented as a tree, so that even if there are lots of entries with the same hash-code, the complexity isO(log n).
 *     Time complexity: O(1) average and O(n) worst case - for all get(),put() and remove() methods.
 *     Space complexity: O(n) - where n is the number of entries in HashMap
 */
public class P706_DesignHashMap {


    static class MyHashMap
    {
        ListNode[] nodes = new ListNode[10000];

        public int get(int key)
        {
            int index = getIndex(key);
            ListNode prev = findElement(index, key);
            return prev.next == null ? -1 : prev.next.val;
        }

        public void put(int key, int value)
        {
            int index = getIndex(key);
            ListNode prev = findElement(index, key);

            if (prev.next == null)
                prev.next = new ListNode(key, value);
            else
                prev.next.val = value;
        }

        public void remove(int key)
        {
            int index = getIndex(key);
            ListNode prev = findElement(index, key);

            if(prev.next != null)
                prev.next = prev.next.next;
        }

        private int getIndex(int key)
        {
            return Integer.hashCode(key) % nodes.length;
        }

        private ListNode findElement(int index, int key)
        {
            if(nodes[index] == null)
                return nodes[index] = new ListNode(-1, -1);

            ListNode prev = nodes[index];

            while(prev.next != null && prev.next.key != key)
            {
                prev = prev.next;
            }
            return prev;
        }

        private static class ListNode
        {
            int key, val;
            ListNode next;

            ListNode(int key, int val)
            {
                this.key = key;
                this.val = val;
            }
        }
    }

    /**
     *  Solution 2: Using Large Sized Array - Accepted in 100 ms
     *
     *     Time complexity: O(1) - for all get(),put() and remove() methods.
     *     Space complexity: O(n) - where n is the maximum possible value for the key.
     */
   static class MyHashMap2 {
        int[] map;

        public MyHashMap2() {
            map = new int[1000001];
            Arrays.fill(map, -1);
        }

        public int get(int key) {
            return map[key];
        }

        public void put(int key, int value) {
            map[key] = value;
        }

        public void remove(int key) {
            map[key] = -1;
        }
    }
}
