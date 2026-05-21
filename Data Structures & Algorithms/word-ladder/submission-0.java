class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> adjList = new HashMap<>();

        wordList.add(beginWord);
        for (String word: wordList) {
            for (int j = 0; j < word.length(); j++) {
                String pattern = word.substring(0,j) + "*" + word.substring(j+1);
                adjList.putIfAbsent(pattern, new ArrayList<>());
                adjList.get(pattern).add(word);
            }
        }

        Set<String> visited = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();

        q.offer(beginWord);
        int output = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return output;
                }
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0,j) + "*" + word.substring(j+1);
                    for (String adjWord : adjList.getOrDefault(pattern, new ArrayList<>())) {
                        if (visited.contains(adjWord)) {
                            continue;
                        }
                        visited.add(adjWord);
                        q.offer(adjWord);
                    }
                }
            }
            output++;
        }
        return 0;
    }
}
