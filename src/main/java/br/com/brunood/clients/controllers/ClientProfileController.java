package br.com.brunood.clients.controllers;

import br.com.brunood.clients.services.ClientProfileUseCase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")
public class ClientProfileController {

    @Autowired
    private ClientProfileUseCase clientProfileUseCase;

    @GetMapping("/me")
    public ResponseEntity<Object> profile(HttpServletRequest request) {
        var clientId = request.getAttribute("client_id");

        try {
            var profile = this.clientProfileUseCase.execute(Long.valueOf(clientId.toString()));
            return ResponseEntity.ok().body(profile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
