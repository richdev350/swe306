package com.peg6.peg6backend.resp;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.peg6.peg6backend.entity.TokenEntity;

public class LoginUserResp {
    TokenEntity tokenEntity = new TokenEntity();
    private String Token = tokenEntity.token;

    private UserResp user;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public UserResp getUserResp() {
        return user;
    }

    @JsonProperty("user")
    public void setUserResp(UserResp user) {
        this.user = user;
    }
}
