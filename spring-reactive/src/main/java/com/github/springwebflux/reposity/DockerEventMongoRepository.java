package com.github.springwebflux.reposity;

import com.github.springwebflux.entity.DockerEvent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午11:40 2018/9/17
 * @desc
 */
public interface DockerEventMongoRepository extends ReactiveMongoRepository<DockerEvent, String> {

    @Tailable
    Flux<DockerEvent> findByStatus(String status);

    @Tailable
    Flux<DockerEvent> findByTypeAndFrom(String type, String from);

    @Tailable
    Flux<DockerEvent> findBy();
}
