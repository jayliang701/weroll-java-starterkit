package com.magicfish.web.domain.service;

import com.magicfish.web.domain.entity.UserEntity;
import com.magicfish.web.domain.repository.UserRepository;
import com.magicfish.weroll.security.jwt.SessionTokenProvider;
import com.magicfish.weroll.security.jwt.identifier.UserPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

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

    public UserEntity getInfo(String id) {
        return userRepository.findById(id);
    }

    public List<UserEntity> search(String JS, String status) {
        Map<String, Object> filter = new HashMap<>();
        filter.put("JS", JS);
        filter.put("status", status);
        return userRepository.find("select * from user where JS=\"" + JS + "\"");
    }
}
