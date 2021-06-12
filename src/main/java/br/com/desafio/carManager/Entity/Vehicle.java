package br.com.desafio.carManager.Entity;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private int id;
	private String brand;
	private String model;
	private String year;
	private String rotationDay;
	private boolean rotationActive;
	
	public Vehicle() {};

	public Vehicle(String brand, String model, String year) {
		this.brand = brand;
		this.model = model;
		this.year = year;
	}



	public int getId() {
		return id;
	}
	public String getBrand() {
		return brand;
	}

	public void setBrand(String marca) {
		this.brand = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String modelo) {
		this.model = modelo;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String ano) {
		this.year = ano;
	}

	public String getRotationDay() {
		return rotationDay;
	}

	public void setRotationDay() {
		String endOfYear = year.substring(3);
		switch (endOfYear) {
		case "0":
		case "1":
			this.rotationDay = "segunda-feira";
			break;
		case "2":
		case "3":
			this.rotationDay = "terça-feira";	
			break;
		case "4":
		case "5":
			this.rotationDay = "quarta-feira";	
			break;
		case "6":
		case "7":
			this.rotationDay = "quinta-feira";	
			break;
		default:
			this.rotationDay = "sexta-feira";
		}

	}

	public void setRotationActive() {
		Calendar cal = Calendar.getInstance();
		String today = new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];
		this.rotationActive = (rotationDay == today);
	}
	public boolean getRotationActive() {
		setRotationActive();
		return rotationActive;
	}
	public String isRotationActive() {
		setRotationActive();
		if(rotationActive)
			return "Sim";
		return "Não";
	}


	@Override
	public String toString() {
		return  "\n" + "Marca: " + brand + " " + "\n" + "Modelo: " + model  + "\n" + "Ano: " + year  + "\n" + "Dia no rodízio: " + rotationDay  + "\n" + "Rodizio Ativo? " + isRotationActive() + "\n";
	}


}
