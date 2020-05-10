package fun.danqing.wechartpay;

import fun.danqing.wechartpay.domain.User;
import fun.danqing.wechartpay.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;

/**
 * @author 丹青
 * @date 2020/5/8-22:27
 */
public class CommonTest {
    /**
     * 生成token
     */
    @Test
    public void testGeneJwt(){

        User user = new User();
        user.setId(999);
        user.setHeadImg("www.danqing.fun");
        user.setName("xd");
        String token = JwtUtils.geneJsonWevToken(user);
        System.out.println(token);
    }

    /**
     * 解析token
     */
    @Test
    public void testCheck(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkYW5xaW5nIiwiaWQiOjk5OSwibmFtZSI6InhkIiwiaW1nIjoid3d3LmRhbnFpbmcuZnVuIiwiaWF0IjoxNTg4OTQ4MzAzLCJleHAiOjE1ODk1NTMxMDN9.aG-SgXs0AdHzjgudOaqwraq7C4STFZzHzFw-ULjHc7M";
        Claims claims = JwtUtils.checkJWT(token);
        if(claims != null){
            String name = (String) claims.get("name");
            String img = (String) claims.get("img");
            Integer id = (Integer) claims.get("id");
            System.out.println(name);
            System.out.println(id);
            System.out.println(img);
        }
    }
}
