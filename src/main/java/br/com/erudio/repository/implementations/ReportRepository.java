package br.com.erudio.repository.implementations;

import java.io.File;
import java.io.Serializable;

import org.springframework.stereotype.Repository;

import br.com.erudio.repository.interfaces.IReportRepository;


@Repository
public class ReportRepository implements IReportRepository, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public File makeReport() {
		return null;
	}

	
}