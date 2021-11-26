package com.formacionjava.springboot.apirest.models.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.formacionjava.springboot.apirest.models.dao.ClienteDao;
import com.formacionjava.springboot.apirest.models.entity.Cliente;
import com.formacionjava.springboot.apirest.models.entity.Region;

@Service
public class ClienteServideImpl implements ClienteService{
	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente>findAll(){
		return (List<Cliente>) clienteDao.findAll(); //clienteDao devuelve un obj así que debemos convertirlo en una lista.
	}
	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id){
		return clienteDao.findById(id).orElse(null);// Si no encuntra el obj encontrado devuelve null 
	}
	@Override
	@Transactional
	public Cliente save(Cliente cliente){
		return clienteDao.save(cliente);
	}
	@Override
	@Transactional
	public void delete(Long id){
		clienteDao.deleteById(id);;
	}
	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllRegions() {
		return clienteDao.findAllRegions();
	}
	
}
