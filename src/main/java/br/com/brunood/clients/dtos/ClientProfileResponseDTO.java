package br.com.brunood.clients.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ClientProfileResponseDTO {

    private Long clientId;
    private String firstName;
    private String lastName;
    private String document;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
