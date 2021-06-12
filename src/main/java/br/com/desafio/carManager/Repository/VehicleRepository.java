package br.com.desafio.carManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.carManager.Entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

}
