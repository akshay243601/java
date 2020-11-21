package practice.dp;

public class CostForEditFrom1WordTo2ndWord {
    private static int minCostOfEditFromWord1ToWord2(String a, String b) {
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if(i == 0) {
                    dp[i][j] = j;
                } else if(j == 0) {
                    dp[i][j] = i;
                } else {
                    if(a.charAt(i-1) == b.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    }
                }
            }
        }



        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(minCostOfEditFromWord1ToWord2("ABCDEFGHI", "ACDEFGHIBXYZ"));
        System.out.println(minCostOfEditFromWord1ToWord2("AAA", "AAA"));
        System.out.println(minCostOfEditFromWord1ToWord2("ABC", "BC"));
        System.out.println(minCostOfEditFromWord1ToWord2("ACDF", "ACDB"));
        System.out.println(minCostOfEditFromWord1ToWord2("", "ABCD"));
    }

}
