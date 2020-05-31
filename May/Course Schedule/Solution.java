class Solution {
    public boolean canFinish(int num, int[][] pre) {

        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();

        for (int i = 0; i < pre.length; i++) {
            adj.computeIfAbsent(pre[i][0], k -> new ArrayList()).add(pre[i][1]);
        }

        int[] visited = new inta[num];
        boolean status = false;
        for (int i = 0; i < num; i++) {
            if (visited[i] == 0) {
                if (isCyclic(visited, adj, i))
                    return false;
            }

        }
        return true;
    }

    public boolean isCyclic(int[] visited, HashMap<Integer, ArrayList<Integer>> adj, int curr) {
        if (visited[curr] == 2)
            return true;
        // System.out.println("Current node"+curr);
        visited[curr] = 2;
        List<Integer> list = adj.get(curr);
        // System.out.println("Adj nodes"+list);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (visited[list.get(i)] != 1) {
                    if (isCyclic(visited, adj, list.get(i)))
                        return true;
                }
            }
        }
        visited[curr] = 1;
        return false;

    }
}