package com.platzi.play.web.controller;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.SuggestRequestDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.domain.service.MovieService;
import com.platzi.play.domain.service.PlatziPlayAiService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final PlatziPlayAiService platziPlayAiService;

    public MovieController(MovieService movieService, PlatziPlayAiService platziPlayAiService) {
        this.movieService = movieService;
        this.platziPlayAiService = platziPlayAiService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll(){
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable Long id){
        MovieDto movieDto = this.movieService.getById(id);

        if(movieDto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movieDto);
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.add(movieDto));
    }

    @PostMapping("/suggest")
    public ResponseEntity<String>generateMovieSuggestions(@RequestBody SuggestRequestDto suggestRequestDto){
        return ResponseEntity.ok(this.platziPlayAiService.generateMovieSuggestion(suggestRequestDto.userPreferences()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @RequestBody @Valid UpdateMovieDto updateMovieDto){
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> delete(@PathVariable Long id){
        return ResponseEntity.ok(this.movieService.delete(id));
    }

}
