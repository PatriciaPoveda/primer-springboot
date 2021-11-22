package com.formacionjava.springboot.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionjava.springboot.apirest.models.entity.Cliente;

//facilita la implementacion de CRUD. Recibe el modelo cliente y la ID
public interface ClienteDao extends CrudRepository<Cliente, Long>{

}
