package br.com.brunood.clients.controllers;

import br.com.brunood.clients.dtos.UpdateClientRequestDTO;
import br.com.brunood.clients.services.UpdateClientUseCase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")
public class UpdateClientController {

    @Autowired
    private UpdateClientUseCase updateClientUseCase;

    @PutMapping
    public ResponseEntity<Object> updateClient(@RequestBody UpdateClientRequestDTO data, HttpServletRequest request) {
        var clientId = request.getAttribute("client_id");
        try {
            var updatedClient = this.updateClientUseCase.execute(Long.valueOf(clientId.toString()), data);
            return ResponseEntity.ok().body(updatedClient);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
