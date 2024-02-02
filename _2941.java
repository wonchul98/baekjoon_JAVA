import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class _2941 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] words = str.split("");
        int cnt = 0;
        for(int i = 0; i < words.length;i++){
            if(i == words.length-1) {
                cnt++;
                break;
            }
            //System.out.println(words[i] + " " + words[i+1]);
            if(i < words.length-1 && (words[i+1].equals("-")||words[i+1].equals("="))) i++;
            else if(i < words.length-2 && words[i].equals("d")){
                if(words[i+1].equals("z")&&words[i+2].equals("=")) i +=2;
            }
            else if(i < words.length-1 && words[i].equals("l") && words[i+1].equals("j")) i++;
            else if(i < words.length-1 && words[i].equals("n") && words[i+1].equals("j")) i++;
            cnt++;
        }
        System.out.println(cnt);
    }
}
