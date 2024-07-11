package br.com.desafioapiplaces.config;

import br.com.desafioapiplaces.domain.Place;
import br.com.desafioapiplaces.domain.PlaceRepository;
import br.com.desafioapiplaces.domain.PlaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@Configuration
@EnableR2dbcAuditing
public class PlaceConfig {

    @Bean
    PlaceService placeService(PlaceRepository placeRepository){
        return new PlaceService(placeRepository);
    }
}
