class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean end = false;
}


class PrefixTree {
    private Node root;

    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char c: word.toCharArray()) {
            curr.children.putIfAbsent(c, new Node());
            curr = curr.children.get(c);
        }
        curr.end = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
                continue;
            }
            return false;
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
                continue;
            }
            return false;
        }
        return true;
    }
}
