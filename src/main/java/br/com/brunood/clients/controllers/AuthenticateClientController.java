package br.com.brunood.clients.controllers;

import br.com.brunood.clients.dtos.AuthenticateClientRequestDTO;
import br.com.brunood.clients.services.AuthenticateClientUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")
public class AuthenticateClientController {

    @Autowired
    private AuthenticateClientUseCase authenticateClientUseCase;

    @PostMapping("/auth")
    public ResponseEntity<Object> authenticateClient(@RequestBody AuthenticateClientRequestDTO data) {
        try {
            var token = this.authenticateClientUseCase.execute(data);
            return ResponseEntity.ok().body(token);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
