package br.com.desafio.carManager.DTO;

import java.util.List;
import java.util.stream.Collectors;

import br.com.desafio.carManager.Entity.Vehicle;

public class VehicleDTO {
	private String brand;
	private String model;
	private String year;
	private String rotationDay;
	private String rotationActive;
	
	public VehicleDTO(Vehicle vehicle) {
		this.brand=vehicle.getBrand();
		this.model=vehicle.getModel();
		this.year=vehicle.getYear();
		this.rotationDay=vehicle.getRotationDay();
		if(vehicle.isRotationActive()) {
			System.out.println("entrei");
			this.rotationActive = "Sim";
		}else {
			this.rotationActive="Não";
		}
	}
	
	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getYear() {
		return year;
	}

	public String getRotationDay() {
		return rotationDay;
	}
	
	public String getRotationActive() {
		return rotationActive;
	}
	
	public static List<VehicleDTO> convert(List<Vehicle> vehicles){
		return vehicles.stream().map(VehicleDTO::new).collect(Collectors.toList());
	}

}
