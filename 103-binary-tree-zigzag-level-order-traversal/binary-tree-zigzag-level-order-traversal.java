public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            Stack<Integer> tempStack = new Stack<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (zigzag) {
                    tempStack.push(node.val);
                } else {
                    currentLevel.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            while (!tempStack.isEmpty()) {
                currentLevel.add(tempStack.pop());
            }

            result.add(currentLevel);
            zigzag = !zigzag;
        }

        return result;
    }
}