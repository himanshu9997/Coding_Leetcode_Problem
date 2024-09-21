class Solution {
    public String reverseWords(String s) {
        int str = s.length();

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for(int i = str-1;i >= 0;i--) {
            char c = s.charAt(i);
            if(c != ' ') {
                 word.append(c);
            }else if(word.length() > 0) {
                result.append(word.reverse().append(' '));
                word.setLength(0);
            }
        }
        

        if(word.length() > 0) {
            result.append(word.reverse()).append(' ');
        }

        return result.toString().trim();
    }
}