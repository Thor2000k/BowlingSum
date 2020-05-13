/**
 * Created by Thor on 11/05/2020.
 */
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class APIhandle {

    public static JSONObject GET(String url)throws IOException, JSONException{

        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }

    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }


    public static JSONObject POST(String token, int[] res, String tmpurl) throws IOException {

        JSONObject Jres = new JSONObject();
        JSONArray Jarr = new JSONArray();
        for (int a: res) {Jarr.put(a);}

        Jres.put("token", token);
        Jres.put("points", Jarr);
        URL url = new URL(tmpurl);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        OutputStream os = con.getOutputStream();
        byte[] byt = Jres.toString().getBytes("utf-8");
        os.write(byt);

        BufferedReader br = new BufferedReader( new InputStreamReader(con.getInputStream(), "utf-8"));
        StringBuilder response = new StringBuilder();
        String responseLine = null;
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }

        JSONObject Jresponse = new JSONObject(response.toString());

        return Jresponse;
    }

}
