package com.formacionjava.springboot.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.formacionjava.springboot.apirest.models.entity.Cliente;
import com.formacionjava.springboot.apirest.models.entity.Region;

//facilita la implementacion de CRUD. Recibe el modelo cliente y la ID
public interface ClienteDao extends CrudRepository<Cliente, Long> {
	
	//Para crear una peticion de Region sin tener que crear un CRUD especifico
	@Query("from Region")// Estamos referenciando desde donde queremos listar
	public List<Region> findAllRegions();
}
