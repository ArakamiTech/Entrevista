package com.proyecto.crud.util;

import com.proyecto.crud.security.RestSecurityFilter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.naming.AuthenticationException;

public class Util {

    public String issueToken(String login, String roles) {
        Date issueDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(issueDate);
        calendar.add(Calendar.MINUTE, 60);
        Date expireDate = calendar.getTime();

        String jwtToken = Jwts.builder()
                .claim("roles", roles)
                .setSubject(login)
                .setIssuer("http://www.infointernet.es")
                .setIssuedAt(issueDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, RestSecurityFilter.KEY)
                .compact();
        return jwtToken;
    }

    public String authenticate(String user, String password) throws AuthenticationException {
        if ("test".equals(user) && "test".equals(password)) {
            return "USUARIO";
        } else if ("admin".equals(user) && "admin".equals(password)) {
            return "ADMINISTRADOR";
        } else {
            throw new AuthenticationException();
        }
    }

    public String generadorNumeroTarjeta() {
        char[] chars = "0123456789".toCharArray();
        int charsLength = chars.length;
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            buffer.append(chars[random.nextInt(charsLength)]);
        }
        return buffer.toString();
    }

    public Date fechaVencimiento() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, 5);
        return cal.getTime();
    }
}
