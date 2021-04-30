package com.demo.models.dao;

import ch.qos.logback.core.net.server.Client;
import com.demo.models.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDao extends CrudRepository<Persona, Long>
{

}
