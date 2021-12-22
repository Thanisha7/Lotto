
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
public class Tests {
    Utils l=new Utils();
    ResponseBody res=l.responseBodyData();
    ObjectMapper m=new ObjectMapper();


    @Test
    public void getLottoResponse() throws JsonProcessingException {
        String response=given()
                .get("https://reqres.in/").asString();
        //dummy url , just to invoke get method

        System.out.println(m.writeValueAsString(res));
    }
    @Test
    public void validateLottoId() throws JsonProcessingException {
        int lottoid=l.getValue(m.writeValueAsString(res),"lotto.lottoId");
        System.out.println("LottoId= "+lottoid );
        Assert.assertEquals(lottoid,res.getLotto().getLottoId());
    }
    @Test
    public void validateWinnerIdAndNumbers() throws JsonProcessingException {
        int winnerId;
        List list;
        winnerId=l.getValue(m.writeValueAsString(res),"lotto.winners.winnerId");
        list=l.getListOfNumbers(m.writeValueAsString(res),"lotto.winners.numbers");
        System.out.println("WinnerId of :"+winnerId);
        System.out.println("Numbers of :"+list);
        Assert.assertEquals(winnerId,res.getLotto().getWinners().getWinnerId());
        Assert.assertNotNull(list.toString());
        }


}
