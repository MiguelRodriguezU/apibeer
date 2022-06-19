package com.mrodriguezul.apibeer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrodriguezul.apibeer.dao.AuditoriaRepository;
import com.mrodriguezul.apibeer.model.Auditoria;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {
	
	@Autowired
	private AuditoriaRepository auditoriaRepository;

	@Override
	public Auditoria save(Auditoria auditoria) {
		return auditoriaRepository.save(auditoria);
	}

}
