package com.platzi.play;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiService {

    @UserMessage("Genra unn saludo de bienvenida a la plataforma de Gestion de Peliculas PlatziPlay. Usa menos de 120 caracteres y hazlo al estilo de platzi")
    public String generateGreeting();
}
