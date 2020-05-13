import org.json.JSONArray;

import java.util.Arrays;

/**
 * Created by Thor on 11/05/2020.
 */


public class Score_Logic {

    static int[] sum(JSONArray array){
        boolean dobonus = false;
        int sum = 0;

        // should use List
        int[] tmparray = null;
        if(array.length() == 11){
            tmparray = new int[array.length() - 1];
        }else {
            tmparray = new int[array.length()];
        }

        // checking if game is applicable for bonus
        if(array.length() > 10){dobonus = true;}

        for(int i = 0; i < array.length(); i++){

            //last element is the bonus throws
            if(i > 9){continue;}

            JSONArray tmp = array.getJSONArray(i);
            // assuming inner array always contain 2 values for each bowling "stroke"
            int a = tmp.getInt(0);
            int b = tmp.getInt(1);

            //case strike
            if(a == 10){

                if(i  == (array.length()) - 1 && dobonus == false ){

                    sum = sum + 10;
                    tmparray[i] = sum;
                    continue;

                }

                // Strike in last frame
                if(i == (array.length()) - 1){
                    JSONArray tmp1 = array.getJSONArray(i);

                    sum = sum + 10 + tmp1.getInt(0) + tmp1.getInt(1);
                    tmparray[i] = sum;
                    continue;

                }


                // Strike in 2. last frame
                if(i == (array.length()) - 3){
                    JSONArray tmp1 = array.getJSONArray(i+1);

                    if(tmp1.getInt(0) == 10){
                        JSONArray tmp2 = array.getJSONArray(i+2);
                        sum = sum + 10 + tmp1.getInt(0) + tmp2.getInt(0);

                    }else{
                        sum = sum + 10 + tmp1.getInt(0) + tmp1.getInt(1);
                    }
                    tmparray[i] = sum;
                    continue;

                }

                if(i == (array.length()) - 2){
                    JSONArray tmp1 = array.getJSONArray(i+1);

                    if(tmp1.getInt(0) == 10){
                        sum = sum + 10 + tmp1.getInt(0) + tmp1.getInt(1);

                    }else{
                        sum = sum + 10 + tmp1.getInt(0) + tmp1.getInt(1);
                    }
                    tmparray[i] = sum;
                    continue;

                }

                if(i < array.length() - 3){
                    JSONArray tmp1 = array.getJSONArray(i+1);
                    if(tmp1.getInt(0) == 10){

                        JSONArray tmp2 = array.getJSONArray(i+2);

                        sum = sum + 10 + 10 + tmp2.getInt(0);
                        tmparray[i] = sum;

                    }else{
                        sum = sum + 10 + tmp1.getInt(0) + tmp1.getInt(1);
                        tmparray[i] = sum;
                    }

                continue;
                }

            }

            //case spare


            if(a + b == 10 && b != 0 ){

                if(i == array.length() - 1 && dobonus == true) {
                    JSONArray tmp1 = array.getJSONArray(i);

                    //if spare in the last frame
                    if(tmp1.getInt(0) + tmp1.getInt(1) == 10) {
                        sum = sum + 10 + tmp1.getInt(0) + tmp1.getInt(1);
                        tmparray[i] = sum;
                        continue;

                    }

                    sum = sum + 10 + tmp1.getInt(0);
                    tmparray[i] = sum;
                    continue;
                }

                if(i + 1 == array.length()) {
                    sum = sum + 10;
                    tmparray[i] = sum;
                    continue;
                }
                if(i == array.length() - 2 && dobonus == true){
                    JSONArray tmp1 = array.getJSONArray(i+1);

                    sum = sum + 10 + tmp1.getInt(0);
                    tmparray[i]=sum;
                    continue;
                }

                JSONArray tmp1 = array.getJSONArray(i+1);
                sum = sum + 10 + tmp1.getInt(0);
                tmparray[i] = sum;
                continue;
            }

            // default case
            sum = sum + a + b;
            tmparray[i] = sum;

        }
        return tmparray;

    }


}
