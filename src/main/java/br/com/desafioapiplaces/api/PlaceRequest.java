package br.com.desafioapiplaces.api;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public record PlaceRequest(@NotBlank String name, @NotBlank String state, @NotBlank String city) {
 }