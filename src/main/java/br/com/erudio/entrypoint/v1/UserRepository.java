package br.com.erudio.entrypoint.v1;

import org.springframework.data.repository.CrudRepository;

import br.com.erudio.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByLogin(String login);
}
