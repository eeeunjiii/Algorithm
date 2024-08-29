import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int X=Integer.parseInt(br.readLine());

        int row=1;
        int col=1;

        while(X-->1) {
            if(row==1 && col%2!=0) {
                col++;
            } else if(row%2==0 && col==1) {
                row++;
            } else if((row+col)%2!=0) {
                row++;
                col--;
            } else if((row+col)%2==0) {
                row--;
                col++;
            }
        }
        System.out.println(row+"/"+col);
    }
}