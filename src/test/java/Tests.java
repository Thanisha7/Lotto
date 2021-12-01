import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Tests {
    String response=Response.responseBody();
    JsonPath js=new JsonPath(response);
    @Test
    public void validateLottoId()
    {
        int lottoId=js.getInt("lotto.lottoId");
        System.out.println("Lotto ID: "+ lottoId);
        Assert.assertNotNull(lottoId);
        //Or can also Assert.assertEquals(lottoId,5);
    }
    @Test
    public void validateWinnersDetails()
    {
        int winnerId;
        ArrayList list=new ArrayList();
       int count= js.getInt("lotto.winners.size()");
        for (int i=0;i<count;i++)
        {
            winnerId=js.getInt("lotto.winners["+i+"].winnerId");
            list= (ArrayList) js.getList("lotto.winners["+i+"].numbers");
            System.out.println("Winner ID of "+i+ " is: "+winnerId);
            System.out.println("Numbers of "+i+ " are : "+ list);
            Assert.assertNotNull(winnerId);
            Assert.assertNotNull(list);
        }
    }
}
