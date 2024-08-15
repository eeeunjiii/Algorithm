import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dr={-1,1,0,0};
    private static final int[] dc={0,0,-1,1};
    private static int w;
    private static int h;
    private static int answer;
    private static char[][] board;
    private static Queue<int[]> fire;
    private static Queue<int[]> person;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int TC=Integer.parseInt(br.readLine());
        for(int t=0;t<TC;t++) {
            StringTokenizer st=new StringTokenizer(br.readLine());

            w=Integer.parseInt(st.nextToken()); // 너비(열)
            h=Integer.parseInt(st.nextToken()); // 높이(행)

            board=new char[h][w];
            fire=new LinkedList<>();
            person=new LinkedList<>();

            for(int i=0;i<h;i++) {
                String line=br.readLine();
                for(int j=0;j<w;j++) {
                    board[i][j]=line.charAt(j);
                    if(board[i][j]=='@') {
                        person.offer(new int[]{i, j, 0});
                    } else if(board[i][j]=='*') {
                        fire.offer(new int[]{i, j});
                    }
                }
            }
            answer=0;
            bfs();

            if(answer==0) sb.append("IMPOSSIBLE").append("\n");
            else sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        while(!person.isEmpty()) {
            int size=fire.size();

            for(int i=0;i<size;i++) {
                int[] v=fire.poll();

                for(int j=0;j<4;j++) {
                    int nx=v[0]+dr[j];
                    int ny=v[1]+dc[j];

                    if(nx>=h || nx<0 || ny>=w || ny<0) continue;
                    if(board[nx][ny]=='.' || board[nx][ny]=='@') {
                        board[nx][ny]='*';
                        fire.offer(new int[]{nx, ny});
                    }
                }
            }

            size=person.size();

            for(int i=0;i<size;i++) {
                int[] v=person.poll();

                for(int j=0;j<4;j++) {
                    int nx=v[0]+dr[j];
                    int ny=v[1]+dc[j];

                    if(nx>=h || nx<0 || ny>=w || ny<0) {
                        answer = v[2] + 1;
                        return;
                    }

                    if(board[nx][ny]=='.') {
                        board[nx][ny]='@';
                        person.offer(new int[]{nx, ny, v[2]+1});
                    }
                }
            }
        }
    }
}