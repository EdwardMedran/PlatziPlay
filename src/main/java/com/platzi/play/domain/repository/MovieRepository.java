package com.platzi.play.domain.repository;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.UpdateMovieDto;

import java.util.List;


public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(Long id);
    MovieDto add(MovieDto movieDto);
    MovieDto update(long id, UpdateMovieDto updateMovieDto);
}
