package com.fresh.coding.bookverse.services.auths;

import com.fresh.coding.bookverse.configurations.JwtProperties;
import com.fresh.coding.bookverse.utils.TimeProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private final SecretKey SECRET_KEY;
    private final long EXPIRATION;
    private final TimeProvider timeProvider;

    public JwtService(@NonNull JwtProperties jwtProperties, @NonNull TimeProvider timeProvider) {
        this.SECRET_KEY = Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes());
        this.EXPIRATION = jwtProperties.getExpiration();
        this.timeProvider = timeProvider;
    }

    String generateToken(UserDetails userDetails) {
        final var now = timeProvider.now();
        final var expiryDate = new Date(now.getTime() + EXPIRATION);
        final var subject = userDetails.getUsername();
        final var roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        final Map<String, ?> claims = Map.of(
                "roles", roles
        );
        return Jwts
                .builder()
                .subject(subject)
                .issuedAt(now)
                .claims(claims)
                .expiration(expiryDate)
                .signWith(SECRET_KEY)
                .compact();
    }

    boolean isTokenValid(String token, String username) {
        final var tokenUsername = extractUsername(token);
        return tokenUsername.equals(username) && !isTokenExpired(token);
    }

    private <T> T extractAllClaims(String token, Function<Claims, T> claimsResolver) {
        final var claims = parseClaims(token);
        return claimsResolver.apply(claims);
    }

    String extractUsername(String token) {
        return extractAllClaims(token, Claims::getSubject);
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private boolean isTokenExpired(String token) {
        final var now = new Date();
        return extractExpiredDate(token).before(now);
    }

    private Date extractExpiredDate(String token) {
        return extractAllClaims(token, Claims::getExpiration);
    }
}
