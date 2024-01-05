#include <stdio.h>

int main(void){
    int n;
    int cnt=0;
    
    scanf("%d", &n);
    
    while(n>0){
        if(n%5==0){
            n -= 5;
            cnt++;
        }
        else if(n%3==0){
            n -= 3;
            cnt++;
        }
        else if(n>5){
            n -= 5;
            cnt++;
        }
        else{
            cnt = -1;
            break;
        }
    }
    printf("%d\n", cnt);
   
}