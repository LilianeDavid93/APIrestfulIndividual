package com.residencia.biblioteca.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.biblioteca.entities.Role;
import com.residencia.biblioteca.entities.RoleEnum;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(RoleEnum name);
}