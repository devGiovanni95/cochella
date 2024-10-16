package br.com.alura.giovanni.codechella;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository repositorio;

    //estou produzindo um fluxo de dados de texto
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Evento> obterTodos(){
        return repositorio.findAll();
    }
}
