package com.mrodriguezul.apibeer.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.stereotype.Repository;

import com.mrodriguezul.apibeer.model.Auditoria;

@Repository
public class LogRepository extends InMemoryHttpTraceRepository {
	
	@Autowired
	private AuditoriaRepository auditoriaRepository;
	
	@Value("${beer.key}")
	private String apiBeerKey;
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
	private String dateConsulta = "";
	private String requestUri = "";
	private Long timeConsulta;
	
	@Override
	public void add(HttpTrace trace) {
		requestUri = trace.getRequest().getUri().toString();	
		
		if(requestUri.contains(apiBeerKey)){
			dateConsulta = simpleDateFormat.format(new Date());
			timeConsulta = trace.getTimeTaken();
			
			auditoriaRepository.save(new Auditoria(0, requestUri, dateConsulta, timeConsulta));			
		}        
		super.add(trace);
	}
	
}
