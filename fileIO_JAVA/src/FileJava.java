import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class FileJava {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        FileInputStream fs = new FileInputStream("DATA.in");
        BufferedInputStream bs = new BufferedInputStream(fs);
        HashSet<String> v = new HashSet<>();
        HashMap<String, Integer> cnt = new HashMap<>();
        String ans = "";
        int i = 0;
        int count = 0;
        while((i=bs.read())!=-1){
            ans += (char)i;
            System.out.println((char)i);
            count += 1;
            if(count > 100000 ) break;
        }
        String [] arr = ans.split("\\s+");
        for(String a : arr){
            v.add(a);
            cnt.put(a, cnt.getOrDefault(a, 0) + 1);

        }
        for(String x : v){
            System.out.println(x + " " +  cnt.getOrDefault(x, 0));
        }

        bs.close();
        fs.close();

    }
}
