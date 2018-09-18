package com.github.springwebflux.entity;

import com.github.dockerjava.api.model.EventType;
import com.github.dockerjava.api.model.Node;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午11:40 2018/9/17
 * @desc
 */
@Data
@Builder
@Document(collection = "docker-event")
public class DockerEvent {

    @Indexed
    private String status;

    @Id
    private String id;

    private String from;

    private Node node;

    private EventType type;

    private String action;

    private String actorId;

    private Long time;

    private Long timeNano;


}
