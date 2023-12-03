import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;

        for (int i = x; i <= y; i++) {
            // x+n, x*2, x*3으로 만들어지지 않는 값은 패스
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            // 다음값인 i+n, i*2, i*3이 y보다 크면 dp배열에 저장X
            if (i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }
            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }

        return (dp[y] == Integer.MAX_VALUE) ? -1 : dp[y];
    }
}
