package br.com.desafio.carManager.DTO;

import java.util.List;
import java.util.stream.Collectors;

import br.com.desafio.carManager.Entity.Vehicle;

public class VehicleDTO {
	private String brand;
	private String model;
	private String year;
	private String rotationDay;
	private boolean rotationActive;
	
	public VehicleDTO(Vehicle vehicle) {
		this.brand=vehicle.getBrand();
		this.model=vehicle.getModel();
		this.year=vehicle.getYear();
		this.rotationDay=vehicle.getRotationDay();
		this.rotationActive=vehicle.getRotationActive();
	}
	

	public boolean isRotationActive() {
		return rotationActive;
	}


	public void setRotationActive(boolean rotationActive) {
		this.rotationActive = rotationActive;
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
	
	public static List<VehicleDTO> convert(List<Vehicle> vehicles){
		return vehicles.stream().map(VehicleDTO::new).collect(Collectors.toList());
	}

}
