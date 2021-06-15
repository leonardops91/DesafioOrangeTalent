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
	private double price;
	
	
	public Vehicle() {};

	public Vehicle(String brand, String model, String year) {
		this.brand = brand;
		this.model = model;
		this.year = year;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + id;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((rotationDay == null) ? 0 : rotationDay.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (rotationDay == null) {
			if (other.rotationDay != null)
				return false;
		} else if (!rotationDay.equals(other.rotationDay))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
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

	public boolean isRotationActive() {
		Calendar cal = Calendar.getInstance();
		String today = new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];
		return (rotationDay.compareToIgnoreCase(today) == 0);
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return  "\n" + "Marca: " + brand + " " + "\n" + "Modelo: " + model  + "\n" + "Ano: " + year  + "\n" + "Dia no rodízio: " + rotationDay  + "\n" + "Rodizio Ativo? " + isRotationActive() + "\n";
	}


}
