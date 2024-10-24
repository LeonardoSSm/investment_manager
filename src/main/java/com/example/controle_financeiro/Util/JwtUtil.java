package com.example.controle_financeiro.Util;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private String secretKey = "JWTSecretKey";

    public String gerarToken(String email){
        Map<String, Object> claims = new HashMap<>();
        return criarToken(claims, email);
    }

    private String criarToken(Map<String, Object> claims, String subject){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validarToken(String token, String email){
        final String usuario = obterUsuarioDoToken(token);
        return (usuario.equals(email) && !isTokenExpirado(token));
    }

    private boolean isTokenExpirado(String token){
        return obterDataExpiracao(token).before(new Date());
    }

    private Date obterDataExpiracao(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration();
    }

    private String obterUsuarioDoToken(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}
