#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#pragma warning(disable:4996)
int flo(double n)
{
	int n1 = n;
	return n1;
}
int main(void)
{
	int n;
	scanf("%d", &n);
	for (int j = 0; j < n; j++)
	{
		int x, y;
		scanf("%d %d", &x, &y);
		int d = y - x;


		double rd = sqrt((double)d);
		int i = flo(rd);


		if (d == i * i)
			printf("%d\n", 2 * i - 1);
		else if (0 < d - i * i && d - i * i <= i)
			printf("%d\n", 2 * i);
		else if (i < d - i * i && d - i * i < 2 * i + 1)
			printf("%d\n", 2 * i + 1);
		else if (d == (i+1)*(i + 1))
			printf("%d\n", 2 * i + 1);
	}
	
	return 0;
}
	