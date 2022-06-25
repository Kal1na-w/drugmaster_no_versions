package ua.od.atomspace.drugfiinder.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.od.atomspace.drugfiinder.model.JwtPayload;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("jwt.secret")
    private String SECRET;

    @Override
    public JwtPayload decode(String token) {
        Algorithm algorithm = getAlgorithm();
        JWTVerifier verifier = JWT.require(algorithm)
                .withAudience()
                .build();

        DecodedJWT jwt = verifier.verify(token);
        String username = jwt.getClaim(JwtPayload.Claims.USERNAME.name()).asString();

        return JwtPayload.builder()
                .username(username)
                .build();
    }

    @Override
    public String encode(JwtPayload payload) {
        Algorithm algorithm = getAlgorithm();
        return JWT.create()
                .withClaim(JwtPayload.Claims.USERNAME.name(), payload.getUsername())
                .sign(algorithm);
    }

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(SECRET);
    }
}
