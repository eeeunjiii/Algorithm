#include <stdio.h>
#define MIN(x,y) (x)<(y)?(x):(y)
#define GET_MIN(x,y,z) (MIN(x, y))<(z)?(MIN(x, y)):(z)

int main(void) {
	int n, m;
	int pack = 1000;
	int sol = 1000;
	int p, s;
	int answer = 0;

	scanf("%d %d", &n, &m);
	for (int i = 0; i < m; i++) {
		scanf("%d %d", &p, &s); //가격
		if (p < pack) { //최소 판별
			pack = p; //최소 가격
		}
		if (s < sol) {
			sol = s;
		}
	}
	int quo = n / 6;
	int rem = n % 6;

	int case1 = pack * (quo + 1);
	int case2 = pack * quo + sol * rem;
	int case3 = sol * n;

	answer = GET_MIN(case1, case2, case3);

	printf("%d", answer);
}