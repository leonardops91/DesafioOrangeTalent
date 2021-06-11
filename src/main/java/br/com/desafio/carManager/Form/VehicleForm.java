package br.com.desafio.carManager.Form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.desafio.carManager.Entity.Vehicle;

public class VehicleForm {
	@NotNull @NotEmpty
	private String brand;
	@NotNull @NotEmpty
	private String model;
	@NotNull @NotEmpty
	private String year;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Vehicle convert() {
		Vehicle vehicle = new Vehicle(brand, model, year);
		vehicle.setRotationDay();
		return vehicle;
	}
}
