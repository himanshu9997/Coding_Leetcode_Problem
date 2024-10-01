class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                for (int j = 0; j < currentWord.length(); j++) {
                    char[] charArray = currentWord.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        String nextWord = new String(charArray);

                        if (nextWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            queue.offer(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
            }

            level++;
        }

        return 0;
    }
}
