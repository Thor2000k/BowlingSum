/**
 * Created by Thor on 11/05/2020.
 */
import java.io.IOException;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) throws IOException {


        if(args.length > 0){
            //tests.test1();
            if(tests.test2()){ System.out.println("test2 successfull");}
            int fails = 0;
            int i = 0;
            for(i = 0; i < 10 ; i++){
                JSONObject json = APIhandle.GET("http://13.74.31.101/api/points");
                JSONArray JArr = json.getJSONArray("points");
                String token = json.getString("token");
                int[] res = Score_Logic.sum(JArr);
                JSONObject Jresult = APIhandle.POST(token, res, "http://13.74.31.101/api/points");
                if(Jresult.get("success").toString().equals(false)){ fails++;}
            }
            System.out.println(" Test Program ran: " + i + " times with failues: " + fails);
        }


        JSONObject json = APIhandle.GET("http://13.74.31.101/api/points");
        JSONArray JArr = json.getJSONArray("points");
        String token = json.getString("token");
        System.out.println("Points array ");
        System.out.println(JArr + "\n");
        int[] res = Score_Logic.sum(JArr);
        System.out.println("Calculated score ");
        System.out.println(Arrays.toString(res) + "\n");
        JSONObject JJresult = APIhandle.POST(token, res, "http://13.74.31.101/api/points");
        System.out.println("Response msg from server  \n");
        System.out.println(JJresult.toString() + "\n");

    }


}
