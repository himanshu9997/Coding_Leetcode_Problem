class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 > len2) {
            return false;  
        }
        
        int[] s1Freq = new int[26];  
        int[] s2Freq = new int[26];  
        
        for (int i = 0; i < len1; i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }
        
        if (compareFreqArrays(s1Freq, s2Freq)) {
            return true;
        }
        
        for (int i = len1; i < len2; i++) {
            s2Freq[s2.charAt(i) - 'a']++;
            
            s2Freq[s2.charAt(i - len1) - 'a']--;
            
            if (compareFreqArrays(s1Freq, s2Freq)) {
                return true;
            }
        }
        
        return false;  
    }
    
    private boolean compareFreqArrays(int[] s1Freq, int[] s2Freq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != s2Freq[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.checkInclusion("ab", "eidbaooo"));  
        System.out.println(sol.checkInclusion("ab", "eidboaoo"));  
    }
}
