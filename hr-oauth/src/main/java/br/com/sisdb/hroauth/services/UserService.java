package br.com.sisdb.hroauth.services;

import br.com.sisdb.hroauth.entities.User;
import br.com.sisdb.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeingClient;

    public User findByEmail(String email){
//        User user = new User();
        User user = userFeingClient.findByEmail(email).getBody();
        if (user == null) {
            logger.error("Email not found: "+email);
            throw new IllegalArgumentException("Email not found.");
        }

        logger.info("Email found: "+email);
        return user;
    }


}
