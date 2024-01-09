package br.com.brunood.clients.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CreateClientUseCaseRequestDTO {

    @NotBlank(message = "firstName required")
    private String firstName;
    @NotBlank(message = "lastName required")
    private String lastName;
    @NotBlank(message = "document required")
    private String document;
    private String dateOfBirth;
    @NotBlank(message = "email required")
    private String email;
    private String phoneNumber;
    @NotBlank(message = "password required")
    private String password;
}
