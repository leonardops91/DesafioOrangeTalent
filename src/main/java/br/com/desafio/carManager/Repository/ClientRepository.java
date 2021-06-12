package br.com.desafio.carManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.carManager.Entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
