import org.json.JSONArray;
/**
 * Created by Thor on 12/05/2020.
 */
public class tests {

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
    
        public static boolean test2() throws FileNotFoundException {

        String t1 = "[[8,1],[1,6],[5,0],[5,2],[10,0]]";
        String t2 = "[[10,0],[10,0],[10,0],[10,0],[10,0],[10,0],[10,0],[10,0],[10,0],[10,0],[10,10]]";
        String t3 = "[[10,0],[0,2],[8,0],[0,6],[0,0],[7,1],[0,7],[7,2],[10,0],[10,0],[5,5]]";
        String t4 = "[[0,9],[4,5],[6,3],[0,7],[1,9],[2,4],[9,1],[6,0],[5,4],[3,7],[8,0]]";
        JSONArray test1 = new JSONArray(t1);
        JSONArray test2 = new JSONArray(t2);
        JSONArray test3 = new JSONArray(t3);
        JSONArray test4 = new JSONArray(t4);

        int exres1 = 38;
        int exres2 = 300;
        int exres3 = 97;
        int exres4 = 101;
        int[] res1 = Score_Logic.sum(test1);
        int[] res2 = Score_Logic.sum(test2);
        int[] res3 = Score_Logic.sum(test3);
        int[] res4 = Score_Logic.sum(test4);

        if(exres1 != res1[res1.length-1] || exres2 != res2[res2.length-1] || exres3 != res3[res3.length-1] || exres4 != res4[res4.length-1]){return false;}

        return true;


    }



}
