package com.ctg.flagadmin.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {
    public static String JWT_HTTP_HEADER;
    public static String USER_ID_KEY;
    public static String USER_ROLE_KEY;
    private static String SECRET;
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
        response.setHeader(JWT_HTTP_HEADER, token);
    }

    /**
     * 从请求头中获得token
     */
    public static String getToken(HttpServletRequest request) {
        return request.getHeader(JWT_HTTP_HEADER);
    }

    /**
     * jwt 验证
     */
    public static DecodedJWT verifyToken(String token) throws SignatureVerificationException {
        return jwtVerifier.verify(token);
    }


    @Value("${jwt.http.header}")
    public void setJwtHttpHeader(String jwtHttpHeader) {
        JWTUtil.JWT_HTTP_HEADER = jwtHttpHeader;
    }

    @Value("${jwt.idKey}")
    public void setUserIdKey(String userIdKey) {
        USER_ID_KEY = userIdKey;
    }

    @Value("${jwt.roleKey}")
    public void setUserRoleKey(String userRoleKey) {
        USER_ROLE_KEY = userRoleKey;
    }

    @Value("${jwt.secret}")
    public void setSECRET(String SECRET) {
        JWTUtil.SECRET = SECRET;
    }

    @Value("${jwt.expireTime}")
    public void setExpireTime(Long expireTime) {
        EXPIRE_TIME = expireTime;
    }
}
