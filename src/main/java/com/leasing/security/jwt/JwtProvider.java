package com.leasing.security.jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtProvider {
    @Value(value = "${jwt-secret_key}")
    public String key;
    @Value(value = "${expire-time}")
    public int expireTime;

    public String createJwtToken(String login){
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.NANOSECONDS.toMillis(expireTime)))
                .signWith(SignatureAlgorithm.ES256, key)
                .compact();
    }

    public String getLoginFromJwt(String token){
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean isValid(String token){
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            return true;
        }catch (JwtException e){
            System.out.println(e); //TODO лучше использовать log
        }
        return false;
    }

}
