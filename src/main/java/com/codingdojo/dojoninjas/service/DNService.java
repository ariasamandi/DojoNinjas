package com.codingdojo.dojoninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoninjas.models.Dojo;
import com.codingdojo.dojoninjas.models.Ninja;
import com.codingdojo.dojoninjas.repositories.DojoRepository;
import com.codingdojo.dojoninjas.repositories.NinjaRepository;

@Service
public class DNService {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	public DNService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}
	public Dojo createDojo(Dojo b) {
		return dojoRepository.save(b);
	}
	public List<Dojo> findAllDojos(){
		return dojoRepository.findAll();
	}
	public Dojo findDojo(Long id){
		Optional<Dojo> d = dojoRepository.findById(id);
		if(d.isPresent()) {
			return d.get();
		}
		else {
			return null;
		}
		
	}
	public Ninja createNinja(Ninja a) {
		return ninjaRepository.save(a);
		
	}
	public List<Ninja> findAllNinja(){
		return ninjaRepository.findAll();
	}
}
