package br.com.giovanni.springsecurity.tweet.repositories;

import br.com.giovanni.springsecurity.tweet.entities.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
