package com.crudunabmartes.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudunabmartes.app.entidades.Agenda;

public interface RepositorioAgenda extends JpaRepository<Agenda, Long>{

}
