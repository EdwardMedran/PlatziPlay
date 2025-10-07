package com.platzi.play.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiService {

    @UserMessage("Genera unn saludo de bienvenida a la plataforma de Gestion de Peliculas {{plataform}}. Usa menos de 120 caracteres y hazlo al estilo de platzi")
    public String generateGreeting(@V("plataform")String platform);

    @SystemMessage("Eres un experto en cine que recomienda peliculas segun los gustos del usuario, debes recomendar maximo 3 peliculas, No incluyas peliculas que esten fuera de la plataforma de PlatziPlay")
    String generateMovieSuggestion(@UserMessage String userMessage);

}
