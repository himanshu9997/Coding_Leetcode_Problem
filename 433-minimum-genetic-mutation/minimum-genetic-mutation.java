class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        
        if (!geneBank.contains(endGene)) return -1;
        
        char[] geneChars = {'A', 'C', 'G', 'T'};
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(startGene);
        visited.add(startGene);
        
        int mutations = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();
                
                if (currentGene.equals(endGene)) {
                    return mutations;
                }
                
                char[] currentGeneArray = currentGene.toCharArray();
                for (int j = 0; j < currentGeneArray.length; j++) {
                    char originalChar = currentGeneArray[j];
                    
                    for (char c : geneChars) {
                        if (c == originalChar) continue;  // Skip if it's the same character
                        
                        currentGeneArray[j] = c;
                        String mutatedGene = new String(currentGeneArray);
                        
                        if (geneBank.contains(mutatedGene) && !visited.contains(mutatedGene)) {
                            visited.add(mutatedGene);  // Mark as visited
                            queue.offer(mutatedGene);  // Add to BFS queue
                        }
                    }
                    currentGeneArray[j] = originalChar;
                }
            }
            mutations++;
        }
        
        return -1;
    }
}
