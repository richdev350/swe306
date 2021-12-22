package com.peg6.peg6backend.resp;
import com.peg6.peg6backend.entity.TokenEntity;

public class LoginUserResp {
    TokenEntity tokenEntity = new TokenEntity();
    private String Token = tokenEntity.token;
    private UserResp user;

    public TokenEntity getTokenEntity() {
        return tokenEntity;
    }

    public void setTokenEntity(TokenEntity tokenEntity) {
        this.tokenEntity = tokenEntity;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public UserResp getUserResp() {
        return user;
    }

    public void setUserResp(UserResp userResp) {
        this.user = userResp;
    }
}
