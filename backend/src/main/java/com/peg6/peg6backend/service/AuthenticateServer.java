package com.peg6.peg6backend.service;


import com.peg6.peg6backend.entity.TokenEntity;
import com.peg6.peg6backend.resp.CommonResp;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateServer {
    TokenEntity tokenEntity = new TokenEntity();

    public boolean authenticateToken(String Token) {
        return Token.equals(tokenEntity.token);
    }

    public CommonResp ConnectionTest(){
        CommonResp resp = new CommonResp();
        resp.setMessage("Connection Success!");
        return resp;
    }
}
