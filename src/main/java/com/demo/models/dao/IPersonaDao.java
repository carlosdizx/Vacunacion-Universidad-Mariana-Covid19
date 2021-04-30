package com.demo.models.dao;

import ch.qos.logback.core.net.server.Client;
import com.demo.models.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaDao extends JpaRepository<Persona, Long>
{

}
