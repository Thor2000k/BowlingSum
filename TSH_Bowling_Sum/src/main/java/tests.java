import org.json.JSONArray;
/**
 * Created by Thor on 12/05/2020.
 */
public class tests {
    /*
    [[8,1],[1,6],[5,0],[5,2],[10,0]]
    [[10,0],[10,0],[10,0],[10,0],[10,0],[10,0],[10,0],[10,0],[10,0],[10,0],[10,10]]
[[10,0],[0,2],[8,0],[0,6],[0,0],[7,1],[0,7],[7,2],[10,0],[10,0],[5,5]]
[[0,9],[4,5],[6,3],[0,7],[1,9],[2,4],[9,1],[6,0],[5,4],[3,7],[8,0]]

    */
    public static void test1(){


        JSONArray Jarr = new JSONArray();
        JSONArray test = new JSONArray();
        test.put(10); test.put(0);
        JSONArray test1 = new JSONArray();
        test1.put(10); test1.put(10);
        for(int i = 0; i < 10; i++){Jarr.put(test);}
        Jarr.put((test1));

        System.out.println(Jarr);
    }


}
