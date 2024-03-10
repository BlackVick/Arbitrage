package org.vykinginteractive.arbitrage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.vykinginteractive.arbitrage.entities.Parameter;

import java.util.Optional;

public interface ParameterRepository extends JpaRepository<Parameter, Long> {
    @Query("SELECT p FROM Parameter p WHERE p.prmKey = :prmKey")
    Optional<Parameter> getParam(String prmKey);
}
