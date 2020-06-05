package com.magicfish.web.security;

import com.magicfish.web.domain.entity.UserEntity;
import com.magicfish.weroll.security.AbstractUserFinder;
import com.magicfish.weroll.security.jwt.identifier.UserPayload;
import com.magicfish.web.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserFinder extends AbstractUserFinder {

    @Autowired
    private UserRepository userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity user = userDao.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Account '" + username + "' not found");
        }

        HashMap<String, Object> source = new HashMap<>();
//        source.put("");
        UserPayload userPayload = UserPayload.buildWithUsernameAndPassword(user.getUsername(), user.getPassword(), user.getJS(), source).withId(user.getId());
        return userPayload;
    }
}
