package br.com.brunood.clients.services;

import br.com.brunood.clients.dtos.ClientProfileResponseDTO;
import br.com.brunood.clients.exceptions.UserNotFoundException;
import br.com.brunood.clients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientProfileUseCase {

    @Autowired
    private ClientRepository clientRepository;

    public ClientProfileResponseDTO execute(Long clientId) {
        var client = this.clientRepository.findById(clientId).orElseThrow(UserNotFoundException::new);

        return ClientProfileResponseDTO.builder()
                .clientId(client.getClientId())
                .createdAt(client.getCreatedAt())
                .dateOfBirth(client.getDateOfBirth())
                .document(client.getDocument())
                .email(client.getEmail())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .phoneNumber(client.getPhoneNumber())
                .updatedAt(client.getUpdatedAt())
                .build();
    }
}
