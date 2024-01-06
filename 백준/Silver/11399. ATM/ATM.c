#include <stdio.h>

int main(void){
    int num=0;
    int time[1001];
    int tmp=0;
    int sum=0;
    scanf("%d", &num);
    
    for(int i=0; i<num; i++){
        scanf("%d", &time[i]);
    }
    
    for(int i=0; i<num; i++){
        for(int j=i+1; j<num; j++){
            if(time[i]>time[j]){
            tmp=time[i];
            time[i]=time[j];
            time[j]=tmp;
            }
        }
    }
    for(int i=0; i<num; i++){
        sum += time[i]*(num-i);
    }
    printf("%d", sum);
}