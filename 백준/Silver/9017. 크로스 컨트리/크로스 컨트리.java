import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        while(T-->0) {
            int N=Integer.parseInt(br.readLine());

            int[] arr=new int[N+1];
            int teamCount=0;
            int[] countPlayers=new int[201]; // 각 팀에서 6명의 선수가 출전했는지 확인
            int[] countCheck=new int[201]; // 각 팀에서 상위 4명의 선수만 포함했는지 확인
            int[] teamScore=new int[201]; // 상위 4명의 선수의 점수 합 저장
            int[] fifth=new int[201]; // 다섯 번째 선수의 점수 저장

            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++) {
                arr[i]=Integer.parseInt(st.nextToken());
                countPlayers[arr[i]]++;
                teamCount=Math.max(teamCount, arr[i]);
            }

            int temp=0;
            for(int i=1;i<=N;i++) {
                if(countPlayers[arr[i]]<6) {
                    temp++;
                    teamScore[arr[i]]=Integer.MAX_VALUE;
                    fifth[arr[i]]=Integer.MAX_VALUE;
                } else if(countCheck[arr[i]]<4) {
                    countCheck[arr[i]]++;
                    teamScore[arr[i]]+=i-temp;
                } else if(countCheck[arr[i]]==4) {
                    fifth[arr[i]]=i-temp;
                    countCheck[arr[i]]++;
                }
            }

            int bestTeam=0, bestScore=Integer.MAX_VALUE;
            fifth[0]=Integer.MAX_VALUE;

            for(int i=1;i<=teamCount;i++) {
                if(teamScore[i]<bestScore) {
                    bestTeam=i;
                    bestScore=teamScore[i];
                } else if(teamScore[i]==bestScore && fifth[bestTeam]>fifth[i]) {
                    bestTeam=i;
                }
            }

            System.out.println(bestTeam);
        }
    }
}