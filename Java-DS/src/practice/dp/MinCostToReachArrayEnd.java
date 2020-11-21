package practice.dp;

public class MinCostToReachArrayEnd {

    private static int minCost(int[][] a, int m, int n) {
        int cost[][] = new int[m+1][n+1];

        for(int i = 0; i < m+1; i++) {
            for(int j = 0; j < n+1; j++) {
                if(i == 0 && j == 0) {
                    cost[0][0] = a[i][j];
                } else if(i == 0) {
                    cost[0][j] = cost[0][j-1] + a[0][j];
                } else if(j == 0) {
                    cost[i][0] = cost[i-1][0] + a[i][0];
                } else {
                    cost[i][j] = Math.min(cost[i-1][j-1], Math.min(cost[i-1][j], cost[i][j-1])) + a[i][j];
                }
            }
        }
        return cost[m][n];
    }


    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1,42,33},
                        {4,78,2},
                        {7,8,3}
                };

        System.out.println(minCost(matrix, 2,2));
        System.out.println(minCost(matrix, 2,2));
    }

}
