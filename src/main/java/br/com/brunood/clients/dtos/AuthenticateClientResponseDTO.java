package br.com.brunood.clients.dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AuthenticateClientResponseDTO {

    private String access_token;
    private Long expiresIn;
}
