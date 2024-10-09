class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i]; 
            projects[i][1] = profits[i];  
        }

        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int currentIndex = 0;

        for (int i = 0; i < k; i++) {
            while (currentIndex < n && projects[currentIndex][0] <= w) {
                maxHeap.offer(projects[currentIndex][1]); 
                currentIndex++;
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            w += maxHeap.poll(); 
        }

        return w; 
    }
}
