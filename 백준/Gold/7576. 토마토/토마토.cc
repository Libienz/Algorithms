#include<stdio.h>
#define SZ 1005
#define QUE_SZ 1000050
int input_X, input_Y;

struct node {
    int x;
    int y;
};

struct node queue[QUE_SZ];
int head = 0;
int tail = 0;
int cnt = 0;

int vectX[4] = { 0, 0, 1, -1 };
int vectY[4] = { 1, -1, 0, 0 };

int map[SZ][SZ];

struct node deque() {
    struct node temp = queue[head];
    head = (head + 1) % QUE_SZ;
    return temp;
}

void enque(int x_, int y_) {
    struct node temp;
    temp.x = x_;
    temp.y = y_;
    queue[tail] = temp;
    tail = (tail + 1) % QUE_SZ;
}

int isQueEmpty() {
    return((tail == head) ? 1 : 0);
}

int do_BFS() {
    int x, y;
    int nextX; int nextY;
    while (isQueEmpty() == 0) {
        struct node temp = deque();
        x = temp.x; y = temp.y;
        for (int i = 0; i < 4; i++) {
            nextX = x + vectX[i];
            nextY = y + vectY[i];

            if (nextX >= 0 && nextY >= 0 && nextX < input_X && nextY < input_Y) {
            
                if (map[nextX][nextY] == 0) {
                    map[nextX][nextY] = map[x][y] + 1;
                    enque(nextX, nextY);
                    cnt--;
                }
            }
        }
    }


    if (cnt == 0) {
        return (map[x][y] - 1);
    }

    
    return -1;
}

int main() {
    scanf("%d %d", &input_Y, &input_X);
    for (int i = 0; i < input_X; i++) {
        for (int j = 0; j < input_Y; j++) {
            scanf("%d", &map[i][j]);
            if (map[i][j] == 0) {
                cnt++;
            }
            else if (map[i][j] == 1) {
                enque(i, j);
            }
        }
    }

    printf("%d", do_BFS());

}


/*
#include<stdio.h>


t_arr[1000][1000] = { 0 };

int check_box(int m, int n) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (t_arr[i][j] = 0) {
				return 1; //모두 익어있지는 않은 상태
			}
		}
	}
	return 0; // 모두 익어있는 상태
}

int main(void) {

	int m, n;
	scanf_s("%d %d", &m, &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf_s("%d", &t_arr[i][j]);
		}
	}

	if (check_box(m, n) == 0) {
		printf("0\n");
		return 0; //모두 익어 있을 때 
	}



	return 0;
	

}
*/