class Trie {
    public class Node {
        public Node[] children = new Node[26];
        public boolean end = false;

        public Node getNode(char value) {
            return children[value - 'a'];
        }

        public void addNode(char value, Node node) {
            children[value - 'a'] = node;
        }
    }

    private Node root;
    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        Node currentNode = root;
        for (char c : word.toCharArray()) {
            Node next = currentNode.getNode(c);
            if (next == null) {
                next = new Node();
                currentNode.addNode(c, next);
            }

            currentNode = next;
        }

        currentNode.end = true;
    }
    
    public boolean search(String word) {
        Node currentNode = root;
        int idx = 0;
        while (idx < word.length()) {
            if (currentNode == null)
                return false;

            Node next = currentNode.getNode(word.charAt(idx));
            currentNode = next;
            idx++;
        }

        return currentNode != null && currentNode.end;
    }
    
    public boolean startsWith(String prefix) {
        Node currentNode = root;
        int idx = 0;
        while (idx < prefix.length()) {
            if (currentNode == null)
                return false;

            Node next = currentNode.getNode(prefix.charAt(idx));
            currentNode = next;
            idx++;
        }

        return currentNode != null;
    }
}