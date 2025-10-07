package com.platzi.play.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record UpdateMovieDto(
        @NotBlank(message = "El titulo es obligatorio")
        String title,

        @PastOrPresent(message = "La fecha de lanzamiento no puede ser en futuro")
        LocalDate releaseDate,

        @Min(value = 0, message = "La calificacion no puede ser menor a 0")
        @Max(value = 5, message = "La calificacion no puede ser mayor a 5")
        Double rating
) {
}
