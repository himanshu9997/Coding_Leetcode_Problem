class Solution {
    public boolean isAnagram(String s, String t) {
        // char[] sChar = s.toCharArray();
        // char[] tChar = t.toCharArray();

        int charA[] = new int[26]; 

        for(int i = 0;i < s.length();i++) {
            charA[s.charAt(i) - 'a']++;
        }


        for(int i = 0;i < t.length();i++) {
            charA[t.charAt(i) - 'a']--;
        }

        for(int count : charA) {
            if(count != 0) {
                return false;
            }
        }
        return true;
        // Arrays.sort(sChar);
        // Arrays.sort(tChar);

        // return Arrays.equals(sChar, tChar);
    }
}