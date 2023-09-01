// Link: https://practice.geeksforgeeks.org/problems/help-santa/0/?track=Java-Collections-Arrays&batchId=318#
// Time Complexity: O(N * log(N))
// Space Complexity: O(N)

boolean[] composite;
List<Integer> primes;

private int findPar(int u, int[] par) {
    return (par[u] == u) ? u : (par[u] = findPar(par[u], par));
}

private void union(int u, int v, int[] par, int[] rank) {
    u = findPar(u, par);
     v = findPar(v, par);
    if (u != v) {
        if (rank[u] < rank[v]) {
            int temp = u;
            u = v;
            v = temp;
         }
        par[v] = u;
        rank[u] += rank[v];
    }
}

public void precompute() {
    composite = new boolean[1000001];
    primes = new ArrayList<>();
    Arrays.fill(composite, false);

     for (int i = 2; i <= 1000; ++i) {
        if (!composite[i]) {
            for (int j = i; i * j <= 1e6; ++j)
                composite[i * j] = true;
        }
    }

    for (int i = 2; i <= 1e6; ++i) {
        if (!composite[i])
            primes.add(i);
    }
}

public int helpSanta(int n, int m, int[][] g) {
    if (m == 0)
        return -1;

    int[] rank = new int[n + 1];
    int[] par = new int[n + 1];
    Arrays.fill(rank, 1);
    for (int i = 0; i <= n; i++)
        par[i] = i;

    for (int i = 0; i < g.length; i++) {
        int u = g[i][0];
        int v = g[i][1];
        union(u, v, par, rank);
    }

    int mx = 1;
    for (int i = 1; i <= n; i++)
        mx = Math.max(mx, rank[i]);

    return primes.get(mx - 1);
}