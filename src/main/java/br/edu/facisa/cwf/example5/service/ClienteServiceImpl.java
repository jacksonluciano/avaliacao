package br.edu.facisa.cwf.example5.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.edu.facisa.cwf.example5.domain.Cliente;
import br.edu.facisa.cwf.example5.repository.ClienteRepository;

@Service
@Validated
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    @Autowired
    public ClienteServiceImpl(final ClienteRepository repository) {
        this.repository = repository;
    }
    
    public Cliente getById(String id) {    
    	return repository.findOne(id);
    }
    
	public List<Cliente> listAllClientes() {
		return repository.findAll();
	}
	
    @Transactional
    public Cliente save(@NotNull @Valid final Cliente participant) {
    	
        Cliente existing = repository.findOne(participant.getName());
/*        
        if (existing != null) {
            throw new ClienteAlreadyExistsException(String.format("There already exists a participant with email=%s", participant.getName()));
        }
 */
        
        return repository.save(participant);
    }

    
    public void delete(Cliente cliente) {    
       repository.delete(cliente);
    }
    
    
    
	public ClienteRepository getRepository() {
		return repository;
	}


   

}