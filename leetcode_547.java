// 547. Number of Provinces

// using dfs and converting the matrix to graph
// tc - O(V+E)
// sc - O(V) - recursion stack + graph + visited

class Solution {
    public void dfs(Map<Integer, List<Integer>> adjList, int src, boolean[] visited){
       
        visited[src] = true;

        for(int nbr : adjList.getOrDefault(src, new ArrayList<>())){
            if(visited[nbr]){
                continue;
            }
            if(!visited[nbr]){
                dfs(adjList, nbr, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int u = 0; u < n; u++){
            for(int v = 0; v < n; v++){
                if(isConnected[u][v] == 1 && u != v){
                    adjList.putIfAbsent(u, new ArrayList<>());
                    adjList.get(u).add(v);
                }
            }
        }

        int count = 0;
        boolean[] visited = new boolean[n];

        for(int src = 0; src < n; src++){
            if(!visited[src]){
                dfs(adjList, src, visited);
                count++;
            }
        }

        return count;
    }
}

// directly performing on the isConnected matrix
// tc - O(V^2)
// sc - O(V)

class Solution {
    int n;
    public void dfs(int[][] isConnected, int src, boolean[] visited){
       
        visited[src] = true;

        for(int v = 0; v < n; v++){
            if(!visited[v] && isConnected[src][v] == 1){
                dfs(isConnected, v, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];

        for(int src = 0; src < n; src++){
            if(!visited[src]){
                dfs(isConnected, src, visited);
                count++;
            }
        }

        return count;
    }
}
