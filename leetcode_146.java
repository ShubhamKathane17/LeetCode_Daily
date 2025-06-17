// 146. LRU Cache
// brute force using deque arrayDeque
//  tc O(n);
// sc - O(n)

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class LRUCache {
    Deque<Pair> dq;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dq = new LinkedList<>();
    }

    public int get(int key) {

        Iterator<Pair> it = dq.iterator();

        while (it.hasNext()) {
            Pair p = it.next();
            if (p.first == key) {
                int t = p.second;
                Pair temp = new Pair(p.first, p.second);
                dq.remove(p);
                dq.addFirst(temp);
                return t;
            }

        }
        return -1;

    }

    public void put(int key, int value) {

        Iterator<Pair> it = dq.iterator();

        while (it.hasNext()) {
            Pair p = it.next();
            if (p.first == key) {
                dq.remove(p);
                break;
            }
        }
        if (dq.size() == capacity) {
            dq.pollLast();
        }

        dq.addFirst(new Pair(key, value));

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


// optimal approach using doubly linkedlist
// tc - O(n)
// sc - O(n)


class Node {
    int first;
    int second;
    Node prev;
    Node next;

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class LRUCache {
    // Deque<Node> dq;
    Map<Integer, Node> map;
    int capacity;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.second;
        }
        else
            return -1;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    public void remove(Node node){
        map.remove(node.first);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insert(Node node){
        map.put(node.first, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
