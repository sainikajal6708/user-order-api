package com.kajal.api.controller;
import com.kajal.api.entity.User;
import com.kajal.api.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/users")
public class UserController {
    @Autowired private UserRepository repo;

    @GetMapping public List<User> getAll(){ return repo.findAll(); }
    @GetMapping("/{id}") public User getOne(@PathVariable Long id){ return repo.findById(id).orElse(null); }
    @PostMapping public User create(@Valid @RequestBody User u){ return repo.save(u); }
    @PutMapping("/{id}") public User update(@PathVariable Long id, @RequestBody User u){ u.setId(id); return repo.save(u); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ repo.deleteById(id); }
}
