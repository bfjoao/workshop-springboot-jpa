package com.bfjoao.curso.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Indica que esta classe é uma entidade JPA (será mapeada para uma tabela no banco de dados).
@Table(name = "tb_user") // Define o nome da tabela como "tb_user" (evita conflito com palavras reservadas, como "user").
public class User implements Serializable { // Permite que objetos da classe sejam serializáveis, útil para trafegar dados na rede ou armazená-los em arquivos.

	private static final long serialVersionUID = 1L;
	
	@Id // Define id como chave primária da tabela.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // O banco de dados será responsável por gerar automaticamente o ID (usando AUTO_INCREMENT em bancos como MySQL).
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;

	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	public User() {

	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrders() {
		return orders;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
}
