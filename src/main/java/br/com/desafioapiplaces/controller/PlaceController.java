package br.com.desafioapiplaces.controller;

import br.com.desafioapiplaces.api.PlaceRequest;
import br.com.desafioapiplaces.api.PlaceResponse;
import br.com.desafioapiplaces.domain.Place;
import br.com.desafioapiplaces.domain.PlaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest request) {
        var placeResponse = placeService.create(request).map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
    }


    @GetMapping
    public ResponseEntity<Flux<Place>> getAll(){
        Flux<Place> placeResponseFlux = this.placeService.getAll();
        return ResponseEntity.ok().body(placeResponseFlux);

    }

    @PutMapping
    public Mono<Place> update(@RequestBody Place place){
        return placeService.update(place);
    }

    @DeleteMapping("{id}")
    public Mono<ResponseEntity<String>> delete(@PathVariable("id") Long id) {
        return placeService.delete(id)
                .then(Mono.just(ResponseEntity.ok("Deletado com sucesso")))
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage())));
    }

}
