package br.com.desafio.carManager.DTO;

import java.util.List;
import java.util.stream.Collectors;

import br.com.desafio.carManager.Entity.Client;

public class ClientDTO {
	private int id;
	private String name;
	private String email;
	private List<VehicleDTO> vehicles;
	
	public ClientDTO(Client client) {
		this.id=client.getId();
		this.name=client.getName();
		this.email=client.getEmail();
		this.vehicles=client.getVehicles();
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public List<VehicleDTO> getVehicles() {
		return vehicles;
	}
	
	public static List<ClientDTO> convert(List<Client> clients){
		return clients.stream().map(ClientDTO::new).collect(Collectors.toList());
	}
}
