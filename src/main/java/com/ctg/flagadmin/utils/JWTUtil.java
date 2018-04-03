package com.ctg.flagadmin.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {
    @Value("${jwt.http.header}")
    public static String jwtHttpHeader;

    @Value("${jwt.user.idKey}")
    public static String USER_ID_KEY;

    @Value("${jwt.user.roleKey}")
    public static String USER_ROLE_KEY;

    @Value("${jwt.secret}")
    private static String SECRET;

    @Value("${jwt.expireTime}")
    private static Long EXPIRE_TIME;

    private static Algorithm algorithm;
    private static JWTVerifier jwtVerifier;

    /**
     * 初始化
     */
    @PostConstruct
    public void setup() throws UnsupportedEncodingException {
        algorithm = Algorithm.HMAC256(SECRET);
        jwtVerifier = JWT
                .require(algorithm)
                .acceptExpiresAt(EXPIRE_TIME / 1000L)
                .build();
    }

    /**
     * 经算法，获得token
     * @param userId id
     * @param role 角色种类
     * @return token
     */
    public static String createToken(Integer userId, Integer role) {
        // jwt的header
        Map<String, Object> jwtHeader = new HashMap<>(2);
        jwtHeader.put("typ", "JWT");
        jwtHeader.put("alg", "HS256");

        return JWT.create()
                .withHeader(jwtHeader)
                .withClaim(USER_ID_KEY, userId)
                .withClaim(USER_ROLE_KEY, role)
                .withExpiresAt(new Date(System.currentTimeMillis() + JWTUtil.EXPIRE_TIME))
                .sign(JWTUtil.algorithm);
    }

    /**
     * 添加响应头
     */
    public static void setToken(HttpServletResponse response, String token) {
        response.setHeader(jwtHttpHeader, token);
    }

    /**
     * 从请求头中获得token
     */
    public static String getToken(HttpServletRequest request) {
        return request.getHeader(jwtHttpHeader);
    }

    /**
     * jwt 验证
     */
    public static DecodedJWT verifyToken(String token) {
        return jwtVerifier.verify(token);
    }
}
