class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    public Node() {

    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }
}

class Trie {
    Node root = new Node();

    public Trie() {

    }

    void insert(String word) {
        int n = word.length();
        Node temp = root;
        for (int i = 0; i < n; i++) {
            if (!temp.containsKey(word.charAt(i))) {
                temp.put(word.charAt(i), new Node());
            }
            temp = temp.get(word.charAt(i));
        }
        temp.setEnd();
    }

    boolean search(String word) {
        int n = word.length();
        Node temp = root;
        for (int i = 0; i < n; i++) {
            if (!temp.containsKey(word.charAt(i))) {
                return false;
            }
            temp = temp.get(word.charAt(i));
        }
        return temp.isEnd();
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie T = new Trie();
        int size = dictionary.size();
        for(int i = 0; i < size; i++) {
            T.insert(dictionary.get(i));
        }
        StringBuilder str = new StringBuilder("");
        StringBuilder temp = new StringBuilder("");
        int n = sentence.length();
        int i = 0;
        while(i < n) {
            if(sentence.charAt(i) == ' ') {
                str.append(temp.toString() + " ");
                temp.setLength(0);
                i++;
            }
            else {
                temp.append(sentence.charAt(i));
                if(T.search(temp.toString())) {
                    str.append(temp.toString());
                    temp.setLength(0);
                    while(i < n && sentence.charAt(i) != ' ') {
                        i++;
                    }
                }
                else {
                    i++;
                }
            }
        }
        str.append(temp.toString());
        return str.toString();
    }
}