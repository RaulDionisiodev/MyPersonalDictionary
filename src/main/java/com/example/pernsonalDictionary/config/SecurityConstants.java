package com.example.pernsonalDictionary.config;

public class SecurityConstants {

     // Authorization
     static final String SECRET = "MELHORTCCDOMUNDO";
     static final String TOKEN_PREFIX = "Bearer ";
     static final String HEADER_STRING = "Authorization";
     static final String SIGN_UP_URL = "/Login";

     static final String NEW_USER_URL = "/user";
     static final Long EXPIRATION_TIME = 86400000L;

}
