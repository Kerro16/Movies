package com.movies.Movies.security.jwt;

import com.movies.Movies.security.entity.MainUser;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String Secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        MainUser mainUser = (MainUser) authentication.getPrincipal();
        return Jwts.builder().setSubject(mainUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.ES512,Secret)
                .compact();
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(Secret).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateToken(String token){
        try{
           Jwts.parser().setSigningKey(Secret).parseClaimsJws(token);
        }
        catch(MalformedJwtException e){
            logger.error("Malformed token");
        }
        catch(UnsupportedJwtException e){
            logger.error("Token not supported");
        }
        catch(ExpiredJwtException e){
            logger.error("Expired token");
        }
        catch(IllegalArgumentException e){
            logger.error("Empty token");
        }
        catch(SignatureException e){
            logger.error("Fail signing");
        }
        return false;
    }
}