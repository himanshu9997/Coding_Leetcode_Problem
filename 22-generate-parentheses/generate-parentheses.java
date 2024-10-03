class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        findAll("", 0, 0, result, n);
        return result;
    }

    void findAll(String current, int openCount, int closeCount, List<String> result, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        if (openCount < n) {
            findAll(current + "(", openCount + 1, closeCount, result, n);
        }
        if (closeCount < openCount) {
            findAll(current + ")", openCount, closeCount + 1, result, n);
        }
    }
}