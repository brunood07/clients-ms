package br.com.brunood.clients.dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UpdateClientRequestDTO {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String phoneNumber;
}
