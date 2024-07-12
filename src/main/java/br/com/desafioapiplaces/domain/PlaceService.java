package br.com.desafioapiplaces.domain;

import br.com.desafioapiplaces.api.PlaceRequest;
import com.github.slugify.Slugify;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepository placeRepository;
    private Slugify slg;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        this.slg = Slugify.builder().build();
    }

    public Mono<Place> create(PlaceRequest placeRequest){
        var place = new Place(null, placeRequest.name(),slg.slugify(placeRequest.name()),
                placeRequest.city(), placeRequest.state(), null,null);
       return placeRepository.save(place);
    }

    public Flux<Place> getAll() {
        return this.placeRepository.findAll();
    }

    public Mono<Place> update(Place place) {
        return this.placeRepository.save(place);
    }

    public Mono<Void> delete(Long id) {
        return placeRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("ID não encontrado")))
                .flatMap(place -> placeRepository.deleteById(id));
    }
}



