package com.formacionjava.springboot.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.PrePersist;
//import javax.persistence.*;

@Entity
//Crea tabla en la base de datos
@Table(name = "Clientes")
public class Cliente implements Serializable {
	@Id
	//Reconoce cual es el id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String nombre;
	private String apellido;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(unique = true)
	private String telefono;
	//Por defecto las columnas llevan el nombre del atributo. Si queremos cambiar su nombre utilizamos la anotación @Column
	@Column(name = "created_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	private String imagen;
	
	//RELACION ManyToOne
	
	@NotNull(message = "No puede estar vacio")
	@ManyToOne(fetch = FetchType.LAZY) //Solo se ejecuta cada vez que llamemos a un metodo
	@JoinColumn(name = "region_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//Cuando hacemos una caraga perezosa (FetchType.LAZY) necesitamos esta anotacion
	private Region region; //Debe pasar un tipo de entity
	
	
	//GETTERS AND SETTERS
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //Variable que declara una id asocidada a la serialización.

}
