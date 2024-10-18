package br.com.alura.giovanni.codechella;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repositorio;

    public Flux<EventoDto> obtertodos(){
        return repositorio.findAll().map(EventoDto::toDto);
    }
}
