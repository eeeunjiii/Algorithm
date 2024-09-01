import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(br.readLine());

        List<Person> list=new ArrayList<>();

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st=new StringTokenizer(br.readLine());
            int w=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());

            list.add(new Person(w, h));
        }

        for(int i=0;i<list.size();i++) {
            int index=0;
            Person now=list.get(i);

            for(int j=0;j<list.size();j++) {
                Person next=list.get(j);
                if(now.height<next.height && now.weight<next.weight) index++;
            }
            sb.append(index+1).append(" ");
        }
        System.out.println(sb);
    }

    private static class Person {
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}