package br.com.desafioapiplaces.controller;

import br.com.desafioapiplaces.api.PlaceResponse;
import br.com.desafioapiplaces.domain.Place;

public class PlaceMapper {
    public static PlaceResponse fromPlaceToResponse(Place place){
        return new PlaceResponse(place.name(), place.slug(), place.city(), place.state(), place.createdAt(),place.updatedAt());
    }
}
