package br.com.brunood.clients.controllers;

import br.com.brunood.clients.dtos.CreateClientUseCaseRequestDTO;
import br.com.brunood.clients.services.CreateClientUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/client")
public class CreateClientController {

    @Autowired
    private CreateClientUseCase createClientUseCase;

    @PostMapping
    public ResponseEntity<Object> createClient(@Valid @RequestBody CreateClientUseCaseRequestDTO data, UriComponentsBuilder uriBuilder) {
        try {
            var client = this.createClientUseCase.execute(data);
            var uri = uriBuilder.path("/api/v1/client/{id}").buildAndExpand(client.getClientId()).toUri();
            return ResponseEntity.created(uri).body("created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
