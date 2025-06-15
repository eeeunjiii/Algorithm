import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    private static int P;
    private static int M;
    private static Player[] players;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        P=Integer.parseInt(st.nextToken()); // 플레이어의 수
        M=Integer.parseInt(st.nextToken()); // 방 한 개의 정원
        players=new Player[P];

        for(int i=0;i<P;i++) {
            st=new StringTokenizer(br.readLine());
            int level=Integer.parseInt(st.nextToken());
            String name=st.nextToken();

            players[i]=new Player(level, name);
        }

        for(int i=0;i<P;i++) {
            List<Player> room=new ArrayList<>();
            if(!players[i].visited) {
                for(int j=i;j<P;j++) {
                    if(room.size()==M) {
                        break;
                    }

                    int level=players[j].level;
                    String name=players[j].name;
                    if(!players[j].visited && players[i].level-10<=level && level<=players[i].level+10) {
                        room.add(new Player(level, name));
                        players[j].visited=true;
                    }
                }
                Collections.sort(room);
                if(room.size()==M) {
                    sb.append("Started!").append("\n");
                } else {
                    sb.append("Waiting!").append("\n");
                }

                for(Player player:room) {
                    sb.append(player.level).append(" ").append(player.name).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}

class Player implements Comparable<Player> {
    int level;
    String name;
    boolean visited;

    public Player(int level, String name) {
        this.level=level;
        this.name=name;
    }

    @Override
    public int compareTo(Player o) {
        return name.compareTo(o.name);
    }
}