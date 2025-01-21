import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static int[][] copy;
    static List<CCTV> cctvList;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int[] result;
    static int ans=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        board=new int[N][M];
        cctvList=new ArrayList<>();

        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                board[i][j]=Integer.parseInt(st.nextToken());

                if(board[i][j]!=0 && board[i][j]!=6) {
                    cctvList.add(new CCTV(board[i][j], i, j));
                }
            }
        }

        result=new int[cctvList.size()]; // 각 cctv가 갖는 방향 번호
        permutation(0, cctvList.size());

        System.out.println(ans);
    }

    static void permutation(int depth, int r) {
        if(depth==r) {
            copy=new int[N][M];
            for(int i=0;i<N;i++) {
                copy[i]=board[i].clone();
            }

            for(int i=0;i<cctvList.size();i++) {
                direction(cctvList.get(i), result[i]);
            }

            getBlindSpot();
            return;
        }
        for(int i=0;i<4;i++) {
            result[depth]=i;
            permutation(depth+1, r);
        }
    }

    static void direction(CCTV cctv, int d) {
        int cctvNum=cctv.num;

        if(cctvNum==1) {
            if(d==0) watch(cctv, 0); // 상
            else if(d==1) watch(cctv, 1); // 우
            else if(d==2) watch(cctv, 2); // 하
            else if(d==3) watch(cctv, 3); // 좌
        } else if(cctvNum==2) {
            if(d==0 || d==2) {
                watch(cctv, 0);
                watch(cctv, 2);
            } else {
                watch(cctv, 1); // 상하
                watch(cctv, 3); // 좌우
            }
        } else if(cctvNum==3) {
            if(d==0) {
                watch(cctv, 0);
                watch(cctv, 1);
            } else if(d==1) {
                watch(cctv, 1);
                watch(cctv, 2);
            } else if(d==2) {
                watch(cctv, 2);
                watch(cctv, 3);
            } else if(d==3) {
                watch(cctv, 3);
                watch(cctv, 0);
            }
        } else if(cctvNum==4) {
            if(d==0) {
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 3);
            } else if(d==1) {
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 2);
            } else if(d==2) {
                watch(cctv, 1);
                watch(cctv, 2);
                watch(cctv, 3);
            } else if(d==3) {
                watch(cctv, 0);
                watch(cctv, 2);
                watch(cctv, 3);
            }
        } else if(cctvNum==5) {
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3);
        }
    }

    static void watch(CCTV cctv, int d) {
        Queue<CCTV> queue=new LinkedList<>();
        queue.add(cctv);

        while(!queue.isEmpty()) {
            CCTV v=queue.poll();
            int nx=v.x+dx[d];
            int ny=v.y+dy[d];

            if(nx<0 || ny<0 || nx>=N || ny>=M || copy[nx][ny]==6) break;
            if(copy[nx][ny]==0) {
                copy[nx][ny]=-1;
                queue.add(new CCTV(cctv.num, nx, ny));
            } else {
                queue.add(new CCTV(cctv.num, nx, ny));
            }
        }
    }

    static void getBlindSpot() {
        int cnt=0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(copy[i][j]==0) cnt++;
            }
        }
        ans=Math.min(ans, cnt);
    }
}

class CCTV {
    int num;
    int x;
    int y;

    public CCTV(int num, int x, int y) {
        this.num=num;
        this.x=x;
        this.y=y;
    }
}