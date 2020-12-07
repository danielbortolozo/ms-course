package br.com.sisdb.hrusers.resources;

import br.com.sisdb.hrusers.entities.User;
import br.com.sisdb.hrusers.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {


    @Autowired
    private UserRepository repository;
    @Autowired
    private Environment env;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id)  {
        User object = repository.findById(id).get();
        return ResponseEntity.ok(object);
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email)  {
        User object = repository.findByEmail(email);
        return ResponseEntity.ok(object);
    }
}
