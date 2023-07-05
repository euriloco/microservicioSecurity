package com.frc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frc.dao.CursosDao;
import com.frc.model.Curso;

@Service
public class CursosServiceImpl implements CursosService {
	@Autowired
	CursosDao dao;

	@Override
	public List<Curso> listarCursos() {
		return dao.findAll();
	}

	@Override
	public List<Curso> altaCurso(Curso curso) {
		dao.save(curso);
		return dao.findAll();
	}

	@Override
	public List<Curso> eliminarCurso(String codCurso) {
		dao.deleteById(codCurso);
		return dao.findAll();
	}

	@Override
	public void actualizarDuracion(String codCurso, int horas) {
		Curso actualizado = dao.findById(codCurso).orElse(null);
		System.out.println(actualizado.getHoras());
		if (actualizado != null) {
			actualizado.setHoras(horas);
			dao.save(actualizado);
		}
	}

	@Override
	public Curso burscarCurso(String codCurso) {
		return dao.findById(codCurso).orElse(null);
	}

	@Override
	public List<Curso> listadoPorPrecio(double minimo, double maximo) {
		 List<Curso> cursosEnRango = new ArrayList<>();
		 List<Curso> cursosAcademia = listarCursos();
		 for(Curso curso : cursosAcademia) {
			 if(curso.getPrecio()>= minimo && curso.getPrecio()<= maximo) {
				 cursosEnRango.add(curso);
			 }
		 }
		return cursosEnRango;
	}

}
