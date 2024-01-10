package br.com.brunood.clients.factories;

import br.com.brunood.clients.dtos.CreateClientUseCaseRequestDTO;
import br.com.brunood.clients.entities.Client;

import java.time.LocalDateTime;

public class ClientFactory {

    public static Client createClientPayload(CreateClientUseCaseRequestDTO data) {

        return Client.builder()
                .createdAt(LocalDateTime.now())
                .dateOfBirth(data.getDateOfBirth())
                .document(data.getDocument())
                .email(data.getEmail())
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .password(data.getPassword())
                .phoneNumber(data.getPhoneNumber())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
