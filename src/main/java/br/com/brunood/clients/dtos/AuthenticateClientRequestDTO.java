package br.com.brunood.clients.dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AuthenticateClientRequestDTO {

    private String email;
    private String password;
}
