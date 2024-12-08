package br.com.giovanni.springsecurity.tweet.controller;

import br.com.giovanni.springsecurity.tweet.controller.dto.CreateTweerDto;
import br.com.giovanni.springsecurity.tweet.entities.Tweet;
import br.com.giovanni.springsecurity.tweet.repositories.TweetRepository;
import br.com.giovanni.springsecurity.tweet.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TweetController {

    private final TweetRepository tweetRepository;

    private final UserRepository userRepository;

    public TweetController(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }


    @PostMapping("/tweets")
    public ResponseEntity<Void> createTweet(@RequestBody CreateTweerDto dto, JwtAuthenticationToken token){

        var user = userRepository.findById(UUID.fromString(token.getName()));

        var tweet = new Tweet();
        tweet.setUser(user.get());
        tweet.setContent(dto.content());

        tweetRepository.save(tweet);

        return ResponseEntity.ok().build();
    }
}
