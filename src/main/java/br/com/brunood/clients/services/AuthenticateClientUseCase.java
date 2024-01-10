package br.com.brunood.clients.services;

import br.com.brunood.clients.dtos.AuthenticateClientRequestDTO;
import br.com.brunood.clients.dtos.AuthenticateClientResponseDTO;
import br.com.brunood.clients.exceptions.InvalidCredentialsException;
import br.com.brunood.clients.repositories.ClientRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
public class AuthenticateClientUseCase {

    @Value("${security.token.secret.candidate}")
    private String secretKey;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthenticateClientResponseDTO execute(AuthenticateClientRequestDTO data) {
        var client = this.clientRepository.findByEmail(data.getEmail()).orElseThrow(InvalidCredentialsException::new);

        var passwordMatches = this.passwordEncoder.matches(data.getPassword(), client.getPassword());

        if (!passwordMatches) throw new InvalidCredentialsException();

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expiresIn = Instant.now().plus(Duration.ofMinutes(10));

        var token = JWT.create()
                .withIssuer("javagas")
                .withExpiresAt(expiresIn)
                .withSubject(client.getClientId().toString())
                .withClaim("roles", List.of("CANDIDATE"))
                .sign(algorithm);

        return AuthenticateClientResponseDTO.builder().access_token(token).expiresIn(expiresIn.toEpochMilli()).build();
    }
}
