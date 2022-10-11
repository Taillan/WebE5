package com.esiee.tp3.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class SecurityManager {
	private static final String SECRET_KEY = ABCD;
	private static SecurityManager singleton;

    public static SecurityManager getInstance() {
        
        if (singleton == null) {
            singleton = new SecurityManager();
        }
        return singleton;
    }
    
    private SecurityManager() {
        
    }
    
    private String createJWT(String id, String issuer, String subject, long ttlMillis) {
        
        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);
        
        //if it has been specified, let's add the expiration
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }  
        
        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }
    
    public String authenticate(String username, String password) throws Exception {
        
        String token = "";
        String DBUsername = "admin";
        String DBpassword = "admin123";
        
        if (username == null) {
            throw new Exception("username is missing");
        }
        if(password == null) {
            throw new Exception("password is missing");
        }
        
        if (DBUsername.equals(username) && DBpassword.equals(password)) {            
            String jwtId = "123456";
            String jwtIssuer = "jwt-demo";
            String jwtSubject = DBUsername;
            int jwtTimeToLive = 800000;
            token = createJWT(
                    jwtId, // claim = jti
                    jwtIssuer, // claim = iss
                    jwtSubject, // claim = sub
                    jwtTimeToLive // used to calculate expiration (claim = exp)
            );
        } else {
            throw new Exception("Bad credentials");
        }
        
        return token;
    }
    
    public Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }
}
