package com.github.springwebflux.service;

import com.github.springwebflux.entity.User;
import com.github.springwebflux.reposity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午11:48 2018/9/17
 * @desc
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll().log();
    }

    /**
     *
     *  保存或更新。如果传入的user没有id属性，由于username是unique的，在重复的情况下有可能报错，
     *  这时找到以保存的user记录用传入的user更新它。
     *
     * @param user
     * @return
     */
    public Mono<User> save(User user) {
        return userRepository.save(user)
                .doOnError(System.out::println)
                .onErrorResume(e ->
                userRepository.findByUsername(user.getUsername())
                .flatMap(originUser -> {
                    user.setId(user.getId());
                    return userRepository.save(user);
                }));
    }

    public Mono<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Mono<Long> deleteByUsername(String username) {
        return userRepository.deleteByUsername(username);
    }
}
