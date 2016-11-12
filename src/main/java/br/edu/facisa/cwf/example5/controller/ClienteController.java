package br.edu.facisa.cwf.example5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.facisa.cwf.example5.domain.Cliente;
import br.edu.facisa.cwf.example5.service.ClienteService;

@RestController
public class ClienteController {

	private final ClienteService ClienteService;

	@Autowired
	public ClienteController(final ClienteService ClienteService) {
		this.ClienteService = ClienteService;
	}

	
	
	@RequestMapping(value="/Cliente", method = RequestMethod.GET)
	public ResponseEntity< List<Cliente> > listAllClientes() {
		return new ResponseEntity< List<Cliente> >
		(ClienteService.listAllClientes(), HttpStatus.OK);
	}

	@RequestMapping(value = "/Cliente/{id}",method = RequestMethod.GET)
	public ResponseEntity<Cliente> getCliente(@PathVariable String id) {
		
		Cliente Cliente = ClienteService.getById(id);
		
		return Cliente == null ? 
				new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Cliente>(Cliente, HttpStatus.OK);
	}
	
	@RequestMapping(value="/Cliente", method = RequestMethod.POST)
	public ResponseEntity<String> createCliente(@RequestBody Cliente Cliente) {

		try {
			ClienteService.save(Cliente);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ClienteService getClienteService() {
		return ClienteService;
	}


	
	@RequestMapping(value = "/Cliente/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> putCliente(@PathVariable String id, @RequestBody Cliente Cliente){

		try {
			ClienteService.save(Cliente);
			return new ResponseEntity<String>(HttpStatus.OK);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

	
	 @RequestMapping(value= "/Cliente/{id}", method=RequestMethod.DELETE)
	  public void delete(@PathVariable String id) {

		 Cliente cliente = ClienteService.getById(id);
		 
		 if(cliente != null){
		 ClienteService.delete(cliente);
		 }
	  }
	
	
	

}
