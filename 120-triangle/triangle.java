class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();

        for (int row = rows - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                int current = triangle.get(row).get(col);
                int below1 = triangle.get(row + 1).get(col);
                int below2 = triangle.get(row + 1).get(col + 1);
                triangle.get(row).set(col, current + Math.min(below1, below2));
            }
        }

        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<Integer>> triangle1 = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        int result1 = solution.minimumTotal(triangle1);
        System.out.println(result1);  

        List<List<Integer>> triangle2 = List.of(List.of(-10));
        int result2 = solution.minimumTotal(triangle2);
        System.out.println(result2); 
    }
}
