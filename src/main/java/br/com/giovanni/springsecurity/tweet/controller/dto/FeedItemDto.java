package br.com.giovanni.springsecurity.tweet.controller.dto;

public record FeedItemDto(Long tweetId, String content, String username) {
}
