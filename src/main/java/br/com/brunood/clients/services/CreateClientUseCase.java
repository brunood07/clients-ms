package br.com.brunood.clients.services;

import br.com.brunood.clients.dtos.CreateClientUseCaseRequestDTO;
import br.com.brunood.clients.exceptions.EmptyBodyException;
import br.com.brunood.clients.exceptions.UserFoundException;
import br.com.brunood.clients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CreateClientUseCase {

    @Autowired
    private ClientRepository clientRepository;

    public void execute(CreateClientUseCaseRequestDTO data) {
        if (ObjectUtils.isEmpty(data)) throw new EmptyBodyException();

        var emailAlreadyExists = clientRepository.findByEmail(data.getEmail());
        var documentAlreadyExists = clientRepository.findByDocumento(data.getDocument());

        if (emailAlreadyExists.isPresent() || documentAlreadyExists.isPresent()) throw new UserFoundException();

    }
}
