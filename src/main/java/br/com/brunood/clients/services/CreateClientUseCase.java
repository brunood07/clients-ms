package br.com.brunood.clients.services;

import br.com.brunood.clients.dtos.CreateClientUseCaseRequestDTO;
import br.com.brunood.clients.entities.Client;
import br.com.brunood.clients.exceptions.EmptyBodyException;
import br.com.brunood.clients.exceptions.UserFoundException;
import br.com.brunood.clients.factories.ClientFactory;
import br.com.brunood.clients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CreateClientUseCase {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Client execute(CreateClientUseCaseRequestDTO data) {
        if (ObjectUtils.isEmpty(data)) throw new EmptyBodyException();

        var emailAlreadyExists = clientRepository.findByEmail(data.getEmail());
        var documentAlreadyExists = clientRepository.findByDocument(data.getDocument());

        if (emailAlreadyExists.isPresent() || documentAlreadyExists.isPresent()) throw new UserFoundException();

        var password = this.passwordEncoder.encode(data.getPassword());
        data.setPassword(password);

        var client = ClientFactory.createClientPayload(data);

        return this.clientRepository.save(client);
    }
}
