
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        
        int wordCount = words.length;
        int wordLength = words[0].length();
        int totalLength = wordCount * wordLength;
        
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> currentMap = new HashMap<>();
            int left = i;
            
            for (int right = i; right + wordLength <= s.length(); right += wordLength) {
                String word = s.substring(right, right + wordLength);
                
                if (wordMap.containsKey(word)) {
                    currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);
                    
                    while (currentMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        left += wordLength;
                    }
                    
                    if (right + wordLength - left == totalLength) {
                        result.add(left);
                    }
                } else {
                    currentMap.clear();
                    left = right + wordLength;
                }
            }
        }
        
        return result;
    }
}
