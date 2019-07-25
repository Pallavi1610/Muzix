
package com.stackroute.muzix;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.repository.TrackRepository;
import com.stackroute.muzix.service.TrackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


import java.util.Arrays;

@Component
@PropertySource("classpath:application.properties")
public class CommandListener implements CommandLineRunner {
    @Value("${Track.id}")
    private int id;
    @Value("${Track.name}")
    private String name;
    @Value("${Track.comment}")
    private String comment;
    @Autowired
    TrackService trackService;

    @Override
    public void run(String... args) throws Exception {
       Logger logger = LoggerFactory.getLogger(CommandListener.class);
        try {
            Track newTrack = new Track(id,name,comment);
            System.out.println(newTrack);
            trackService.saveTrack(newTrack);
            for(Track track:trackService.getAllTracks())
            {
                logger.info(track.toString());
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

