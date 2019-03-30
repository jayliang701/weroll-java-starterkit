package com.magicfish.web.service;

import com.magicfish.weroll.security.jwt.SessionTokenProvider;
import com.magicfish.weroll.security.jwt.identifier.UserPayload;
import com.magicfish.web.dao.UserDao;
import com.magicfish.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service(value = "userService")
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SessionTokenProvider sessionTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(String username, String password) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            UserPayload userPayload = (UserPayload) authentication.getPrincipal();
            Map<String, Object> params = new HashMap<>();
//            params.put("JS", userDetails.getAuthorities());
            return sessionTokenProvider.createToken(userPayload.getId(), params);
        } catch (AuthenticationException e) {
            throw new Exception("Invalid username/password supplied");
        }
    }

    public User getInfo(String id) {
        return userDao.findById(id);
    }
}
