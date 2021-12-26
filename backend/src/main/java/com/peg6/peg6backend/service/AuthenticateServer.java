package com.peg6.peg6backend.service;


import com.peg6.peg6backend.entity.TokenEntity;
import com.peg6.peg6backend.resp.CommonResp;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public CommonResp wrongToken(){
        CommonResp resp = new CommonResp();
        resp.setSuccess(false);
        resp.setMessage("Token Wrong Or No Token");
        return resp;
    }
}
