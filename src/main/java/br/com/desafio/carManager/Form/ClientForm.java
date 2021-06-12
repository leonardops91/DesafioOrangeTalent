package br.com.desafio.carManager.Form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.desafio.carManager.Entity.Client;

public class ClientForm {
	@NotNull @NotEmpty @Length(min = 3)
	private String name;
	@NotNull @NotEmpty @Length(min = 7)
	private String email;
	@NotNull @NotEmpty @Length(min = 11)
	private String cpf;
	@NotNull @NotEmpty @Length(min = 8)
	private String birthday;
	
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
		return cpf;
	}
	public void setCPF(String cPF) {
		cpf = cPF;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public Client convert() {
		return new Client(name, email, cpf, birthday);
	}
}
