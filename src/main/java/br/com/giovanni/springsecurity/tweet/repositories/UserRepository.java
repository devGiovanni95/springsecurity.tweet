package br.com.giovanni.springsecurity.tweet.repositories;

import br.com.giovanni.springsecurity.tweet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
