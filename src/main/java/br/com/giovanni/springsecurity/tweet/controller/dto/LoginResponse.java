package br.com.giovanni.springsecurity.tweet.controller.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}
