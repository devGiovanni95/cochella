package br.com.alura.giovanni.codechella;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService servico;

    //estou produzindo um fluxo de dados de texto
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDto> obterTodos(){
        return servico.obtertodos();
    }

    @GetMapping("/{id}")
    public Mono<EventoDto> obterPorId(@PathVariable Long id){
        return servico.obterPorId(id);
    }

    @PostMapping
    public Mono<EventoDto> cadastrar(@RequestBody EventoDto dto){
        return servico.cadastrar(dto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> excluir(@PathVariable Long id){
        return servico.excluir(id);
    }
}
