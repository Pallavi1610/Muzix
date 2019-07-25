
package com.stackroute.muzix;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.repository.TrackRepository;
import com.stackroute.muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")

public class ApplicationRunner implements ApplicationListener<ContextRefreshedEvent> {
    @Value("${Track.id}")
    private int id;
    @Value("${Track.name}")
    private String name;
    @Value("${Track.comment}")
    private String comment;
    @Autowired
   TrackRepository trackRepository;
    @Autowired
    Environment env;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

            trackRepository.save(new Track(Integer.parseInt(env.getProperty("Track.id")),env.getProperty("Track.name"),env.getProperty("Track.comment")));
        System.out.println("rfdsc");

    }
}

