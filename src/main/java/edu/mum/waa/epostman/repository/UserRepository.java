package edu.mum.waa.epostman.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.waa.epostman.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
