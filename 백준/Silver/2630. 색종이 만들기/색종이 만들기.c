#include<stdio.h>

int arr[128][128];
int blue = 0;
int white = 0;

int same_color(int row_start, int row_end, int column_start, int column_end) {
	int diff = arr[row_start][column_start];
	for (int i = row_start; i <= row_end; i++)
		for (int j = column_start; j <= column_end; j++)
			if (diff != arr[i][j]) 
				return 0;
	return 1;

}
void dnc(int row_start, int row_end, int column_start, int column_end, int size) {
	if (same_color(row_start, row_end, column_start, column_end) == 1) {
		if (arr[row_start][column_start] == 1)
			blue++;
		else
			white++;
		return;
	}
	else {
		dnc(row_start, row_start + size/2 - 1, column_start, column_start + size/2 - 1, size/2); //왼쪽위 0,3,0,3
		dnc(row_start + size/2, row_end, column_start + size/2, column_end, size/2); // 오른쪽 아래 4,7,4,7
		dnc(row_start + size/2, row_end, column_start, column_start+size/2 -1,size/2); // 왼쪽 아래
		dnc(row_start, row_start + size/2 - 1, column_start+size/2, column_end,size/2); //오른쪽 위


	}

}



int main(void) {


	
	int size;
	
	scanf("%d", &size);
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			scanf("%d", &arr[i][j]);
		}
	}
	
	dnc(0, size - 1, 0, size - 1,size);
	printf("%d %d", white, blue);


}

//배열의 크기가 1이거나 모두 같은색이면 그만 쪼갬
//색이 같지 않으면 4개로 쪼갠다