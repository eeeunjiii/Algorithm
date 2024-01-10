#include <stdio.h>

int main() {
	int n = 0;
	int dp[1001] = { 0 };
	scanf("%d", &n);
	dp[1] = 1;
	dp[2] = 2;
	for (int i = 3; i <= n; i++) {
		dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
	}
	printf("%d", dp[n]);
}