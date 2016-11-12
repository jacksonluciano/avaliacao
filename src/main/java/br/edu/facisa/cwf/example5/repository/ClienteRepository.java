package br.edu.facisa.cwf.example5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.facisa.cwf.example5.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String> {

	public Cliente findByName(String name);
	
}
