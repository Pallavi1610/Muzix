
package com.stackroute.muzix;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.repository.TrackRepository;
import com.stackroute.muzix.service.TrackService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements ApplicationListener<ContextRefreshedEvent> {
   TrackService trackService;

    public ApplicationRunner(TrackService trackService) {
        this.trackService = trackService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            trackService.saveTrack(new Track(10,"Evolution","average"));
        } catch (TrackAlreadyExistsException e) {
            e.getMessage();
        }

    }
}

