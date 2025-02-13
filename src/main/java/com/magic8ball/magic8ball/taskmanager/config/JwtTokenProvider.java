package com.magic8ball.magic8ball.taskmanager.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    public String generateToken(Authentication authentication){
        String email =authentication.getName();
        Date currentDate = new Date();
        Date ExpireDate = new Date(currentDate.getTime()+3600000);
        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(currentDate)
                .setExpiration(ExpireDate)
                .signWith(SignatureAlgorithm.HS256,"4261656C64756E67yHWWH7262818paguakg7287FBWHHFGVFAEE")
                .compact();
        return token;
    }
    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey("4261656C64756E67yHWWH7262818paguakg7287FBWHHFGVFAEE")
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
    public boolean validate(String token){
        try{
            Jwts.parser()
                    .setSigningKey("4261656C64756E67yHWWH7262818paguakg7287FBWHHFGVFAEE")
                    .build()
                    .parseClaimsJws(token);
            return true;
        }catch (Exception e){
            throw new RuntimeException("Token issue"+e.getMessage());
        }
    }


}
