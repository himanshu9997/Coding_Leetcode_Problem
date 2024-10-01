class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adjList.get(prereq).add(course); 
            inDegree[course]++; 
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] result = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            result[index++] = currCourse;  
            
            for (int nextCourse : adjList.get(currCourse)) {
                inDegree[nextCourse]--;
                
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        return index == numCourses ? result : new int[0];
    }
}
