
public class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;  // How many words share this prefix
    }

    class Trie {
        TrieNode root = new TrieNode();

        // Insert a word into the trie and increase the count of each prefix
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
                node.count++;
            }
        }

        // Calculate the score of all prefixes of the word
        public int getPrefixScore(String word) {
            TrieNode node = root;
            int score = 0;
            for (char ch : word.toCharArray()) {
                node = node.children.get(ch);
                score += node.count;
            }
            return score;
        }
    }

    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        
        // Step 1: Insert all words into the Trie
        for (String word : words) {
            trie.insert(word);
        }
        
        // Step 2: Calculate the prefix scores for each word
        int[] answer = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            answer[i] = trie.getPrefixScore(words[i]);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words1 = {"abc","ab","bc","b"};
        System.out.println(Arrays.toString(solution.sumPrefixScores(words1)));  // Output: [5, 4, 3, 2]

        String[] words2 = {"abcd"};
        System.out.println(Arrays.toString(solution.sumPrefixScores(words2)));  // Output: [4]
    }
}
