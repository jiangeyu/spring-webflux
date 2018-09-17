package com.github.springwebflux.controller;

import com.github.springwebflux.entity.User;
import com.github.springwebflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午12:02 2018/9/18
 * @desc
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public Mono<User> findByUsername(@PathVariable String username) {
        return this.userService.findByUsername(username);
    }
}
