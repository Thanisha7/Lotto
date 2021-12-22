import io.restassured.path.json.JsonPath;

import java.util.List;


public class Utils {
    public ResponseBody responseBodyData()
    {
        ResponseBody r=new ResponseBody();
        Lotto l=new Lotto();
        Winners w=new Winners();


        w.setWinnerId(54);
        int[] b={52, 3, 12, 11, 18, 22};
        w.setNumbers(b);
        l.setLottoId(5);
        int[] a= {2, 45, 34, 23, 7, 5, 3};
        l.setWinning_numbers(a);
        l.setWinners(w);
        r.setLotto(l);

        return r;
    }

    public  int getValue(String response,String key)
    {
        JsonPath js=new JsonPath(response);
        int value=js.getInt(key);
        return value;
    }
    public  List getListOfNumbers(String response,String key)
    {
        JsonPath js=new JsonPath(response);
        List value=js.getList(key);
        return value;
    }
}
