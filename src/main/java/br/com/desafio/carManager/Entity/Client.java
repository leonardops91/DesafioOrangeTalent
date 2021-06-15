package br.com.desafio.carManager.Entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.desafio.carManager.DTO.VehicleDTO;

@Entity
public class Client {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String CPF;
	private Date birthday;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
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
		Client other = (Client) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public Client() {};
	
	public Client(String name, String email,
			String CPF, String birthday) {
		this.name=name;
		this.email=email;
		this.CPF=CPF;
		try {
			setBirthday(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getBirthday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(birthday);
	}
	public void setBirthday(String birthday) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.birthday = sdf.parse(birthday);
	}
	public List<VehicleDTO> getVehicles() {
		return VehicleDTO.convert(vehicles);
	}
	public void setVehicles(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	@Override
	public String toString() {
		
		return "Nome: " + name + "\n " +
				"Email: " + email + "\n " +
				"CPF: " + CPF + "\n " +
				"Data de nascimento: " + getBirthday() + "\n " +
				"Veículos: " + vehicles;
	}
	
}
