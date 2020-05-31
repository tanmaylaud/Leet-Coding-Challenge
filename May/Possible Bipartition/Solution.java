class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {

        int[][] G = new int[N + 1][N + 1];
        for (int i = 0; i < dislikes.length; i++) {
            for (int j = 0; j < 2; j++) {
                int from = dislikes[i][0];
                int to = dislikes[i][1];
                G[from][to] = 1;
                G[to][from] = 1;
            }
        }

        int colorArr[] = new int[N + 1];
        for (int i = 1; i <= N; ++i)
            colorArr[i] = -1;

        // This code is to handle disconnected graoh
        for (int i = 1; i <= N; i++)
            if (colorArr[i] == -1)
                if (isBipartiteUtil(G, i, colorArr, N) == false)
                    return false;

        return true;
    }

    public boolean isBipartiteUtil(int G[][], int src, int colorArr[], int N) {
        colorArr[src] = 1;

        // Create a queue (FIFO) of vertex numbers and
        // enqueue source vertex for BFS traversal
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(src);

        // Run while there are vertices in queue
        // (Similar to BFS)
        while (!q.isEmpty()) {
            // Dequeue a vertex from queue
            // ( Refer http://goo.gl/35oz8 )
            int u = q.getFirst();
            q.pop();

            // Return false if there is a self-loop
            if (G[u][u] == 1)
                return false;

            // Find all non-colored adjacent vertices
            for (int v = 1; v <= N; ++v) {
                // An edge from u to v exists and
                // destination v is not colored
                if (G[u][v] == 1 && colorArr[v] == -1) {
                    // Assign alternate color to this
                    // adjacent v of u
                    colorArr[v] = 1 - colorArr[u];
                    q.push(v);
                }

                // An edge from u to v exists and
                // destination v is colored with same
                // color as u
                else if (G[u][v] == 1 && colorArr[v] == colorArr[u])
                    return false;
            }
        }

        // If we reach here, then all adjacent vertices
        // can be colored with alternate color
        return true;
    }

}
