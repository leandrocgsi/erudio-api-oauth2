package br.com.erudio.repository.implementations;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.erudio.repository.interfaces.IReportRepository;
import br.com.erudio.service.reporter.Reporter;

@Repository
public class ReportRepository implements IReportRepository, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Reporter reporter; 

	@Override
	public byte[] makeReport() throws Exception {
		return (byte[])reporter.makeReport();
	}
}