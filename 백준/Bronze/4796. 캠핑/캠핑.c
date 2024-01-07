#include <stdio.h>

int main(void) {
	int l, p, v;
	int cnt = 1;
	int day = 0;

	while (1) {
		scanf("%d %d %d", &l, &p, &v);
		if (l == 0 && p == 0 && v == 0) {
			break;
		}
		day = (v / p) * l;
		v = v % p;
		day += v < l ? v : l;
		printf("Case %d: %d\n", cnt, day);
		cnt++;
	}
	return 0;
}