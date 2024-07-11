package br.com.desafioapiplaces.api;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public record PlaceResponse (
        String name, String slug,
        String city,String state,
        @CreatedDate LocalDateTime createdAt,
        @LastModifiedDate LocalDateTime updatedAt
) {
}
