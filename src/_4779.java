import java.io.*;
import java.util.StringTokenizer;


public class _4779 {
    static char[] c;
    static void recur(int start, double length){
        //System.out.println("recur: " + start + length);
        if((int)length == 1) {
            return;
        }

        else{
            for(int i = start + (int)length / 3; i < start + 2 * ((int)length / 3);i++){
                c[i] = ' ';
            }
            recur(start, length/3);
            recur(start + 2*(int)length/3, length/3);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;

        while(true){
            line = br.readLine();

            if(line == null || line.isEmpty()) break;
            //System.out.println("while: " + line);
            double n = Double.parseDouble(line);
            c = new char[(int) Math.pow(3,n)]; //c초기화
            for(int i = 0; i < Math.pow(3,n);i++) c[i] = '-';
            recur(0,Math.pow(3,n));
            //System.out.println("end");
            for(int i = 0; i < Math.pow(3,n);i++) bw.write(c[i]);
            bw.write("\n");
            bw.flush();
        }
    }
}
