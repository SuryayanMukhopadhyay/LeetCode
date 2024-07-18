class Pair {
    String first;
    int second;
    Pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(wordList.get(i));
        }
        if(!set.contains(endWord)) {
            return 0;
        }
        Queue<Pair> Q = new LinkedList<>();
        Q.offer(new Pair(beginWord, 1));
        while(!Q.isEmpty()) {
            String word = Q.peek().first;
            int count = Q.peek().second;
            int size = word.length();
            Q.remove();
            if(word.equals(endWord)) return count;
            for(int i = 0; i < size; i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String newWord = new String(replacedCharArray);
                    if(set.contains(newWord)) {
                        set.remove(newWord);
                        Q.offer(new Pair(newWord, count + 1));
                    }
                }
            }
        }
        return 0;
    }
}