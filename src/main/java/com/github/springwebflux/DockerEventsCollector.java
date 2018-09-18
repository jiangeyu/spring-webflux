package com.github.springwebflux;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Event;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.EventsResultCallback;
import com.github.springwebflux.entity.DockerEvent;
import com.github.springwebflux.reposity.DockerEventMongoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Objects;
import java.util.UUID;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午5:09 2018/9/18
 * @desc
 */
@Slf4j
@Component
public class DockerEventsCollector implements CommandLineRunner {

    private DockerEventMongoRepository dockerEventMongoRepository;
    private MongoTemplate mongo;

    public DockerEventsCollector(DockerEventMongoRepository dockerEventMongoRepository, MongoTemplate mongo) {
        this.dockerEventMongoRepository = dockerEventMongoRepository;
        this.mongo = mongo;
    }

    @Override
    public void run(String... args) throws Exception {

        mongo.dropCollection(DockerEvent.class);
        mongo.createCollection(DockerEvent.class, CollectionOptions.empty().maxDocuments(200).capped());

        dockerEventMongoRepository.saveAll(collect()).subscribe();

    }

    private Flux<DockerEvent> collect() {
        DockerClient docker = DockerClientBuilder.getInstance().build();
        return Flux.create((FluxSink<Event> sink) -> {
            EventsResultCallback callback = new EventsResultCallback() {
                @Override
                public void onNext(Event item) {
                    sink.next(item);
                }
            };
            docker.eventsCmd().exec(callback);
        })
                .map(this::trans)
                .doOnNext(e -> log.info(e.toString()));
    }

    private DockerEvent trans(Event event) {
        DockerEvent dockerEvent = DockerEvent.builder().build();
        dockerEvent.setAction(event.getAction());
        dockerEvent.setActorId(Objects.requireNonNull(event.getActor()).getId());
        dockerEvent.setFrom(event.getFrom() == null ? null : event.getFrom().replace("//", "_"));
        dockerEvent.setId(UUID.randomUUID().toString());
        dockerEvent.setNode(event.getNode());
        dockerEvent.setStatus(event.getStatus());
        dockerEvent.setTime(event.getTime());
        dockerEvent.setTimeNano(event.getTimeNano());
        dockerEvent.setType(event.getType());
        return dockerEvent;
    }
}