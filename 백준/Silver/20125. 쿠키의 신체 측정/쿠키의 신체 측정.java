import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static char[][] board;
    private static int heartX, heartY;
    private static int waistEnd;
    private static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        board=new char[N+1][N+1]; // *는 쿠키의 신체, _는 신체가 없는 부분

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            char[] ch=br.readLine().toCharArray();
            for(int j=0;j<N;j++) {
                board[i+1][j+1]=ch[j];
            }
        }

        // 심장이 위치한 행 X, 열 Y
        // 왼팔, 오른팔, 허리, 왼다리, 오른다리 길이를 공백으로 구분하여 출력
        findHeadLoc();
        sb.append(heartX).append(" ").append(heartY).append("\n");

        getArmLength();
        getWaistLength();
        getLegLength();

        System.out.println(sb);
    }

    private static void findHeadLoc() {
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if (board[i][j]=='*') {
                    heartX=i+1;
                    heartY=j;
                    return;
                }
            }
        }
    }

    private static void getArmLength() {
        int leftLen=0;
        for(int i=1;i<heartY;i++) {
            if(board[heartX][i]=='*') {
                leftLen++;
            }
        }
        int rightLen=0;
        for(int i=heartY+1;i<=N;i++) {
            if(board[heartX][i]=='*') {
                rightLen++;
            }
        }
        sb.append(leftLen).append(" ").append(rightLen).append(" ");
    }

    private static void getWaistLength() {
        // 심장 아래부터 시작해야 함.
        int len=0;
        for(int i=heartX+1;i<=N;i++) {
            if(board[i][heartY]=='*') {
                len++;
                waistEnd=i; // 행이 끝나는 부분
            }
        }
        sb.append(len).append(" ");
    }

    private static void getLegLength() {
        int leftLen=0;
        for(int i=waistEnd+1;i<=N;i++) { // 왼쪽 다리
            if(board[i][heartY-1]=='*') {
                leftLen++;
            }
        }

        int rightLen=0;
        for(int i=waistEnd+1;i<=N;i++) { // 오른쪽 다리
            if(board[i][heartY+1]=='*') {
                rightLen++;
            }
        }
        sb.append(leftLen).append(" ").append(rightLen);
    }
}