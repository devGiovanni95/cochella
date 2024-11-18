package br.com.alura.giovanni.codechella;

import java.util.List;

public record Traducao(List<Texto> tranlations) {

    public String getTexto() {
        return tranlations.get(0).text();
        //return tranlations.getFirst().text();
    }
}
