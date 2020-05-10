package fun.danqing.wechartpay.util;

import fun.danqing.wechartpay.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**jwt工具类
 * @author 丹青
 * @date 2020/5/8-20:48
 */
public class JwtUtils {

    public static final String SUBJECT = "danqing";

    public static long EXPORE = 1000 * 60 * 60 * 24 * 7;//设置过期时间（一周）单位：毫秒

    public static final String APPSECRET = "xd666";//秘钥

    /**
     * 生成jwt
     *
     * @param user
     * @return
     */
    public static String geneJsonWevToken(User user) {

        if (user == null || user.getId() == null || user.getName() == null || user.getHeadImg() == null) {
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT).claim("id", user.getId())
                .claim("name", user.getName())
                .claim("img", user.getHeadImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPORE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();

        return token;
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception exception) { }
            return null;
    }
}