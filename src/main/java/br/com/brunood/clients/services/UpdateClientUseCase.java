package br.com.brunood.clients.services;

import br.com.brunood.clients.dtos.ClientProfileResponseDTO;
import br.com.brunood.clients.dtos.UpdateClientRequestDTO;
import br.com.brunood.clients.exceptions.UserNotFoundException;
import br.com.brunood.clients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UpdateClientUseCase {

    @Autowired
    private ClientRepository clientRepository;

    public ClientProfileResponseDTO execute(Long clientId, UpdateClientRequestDTO data) {
        var client = clientRepository.findById(clientId).orElseThrow(UserNotFoundException::new);

        var dateOfBirth = data.getDateOfBirth() == null ? client.getDateOfBirth() : data.getDateOfBirth();
        var firstName = data.getFirstName() == null ? client.getFirstName() : data.getFirstName();
        var lastName = data.getLastName() == null ? client.getLastName() : data.getLastName();
        var phoneNumber = data.getPhoneNumber() == null ? client.getPhoneNumber() : data.getPhoneNumber();
        client.setDateOfBirth(dateOfBirth);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setPhoneNumber(phoneNumber);
        client.setUpdatedAt(LocalDateTime.now());

        var updatedClient = this.clientRepository.save(client);

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
