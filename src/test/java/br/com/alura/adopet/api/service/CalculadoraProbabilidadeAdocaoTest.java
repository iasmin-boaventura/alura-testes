package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.dto.CadastroPetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.ProbabilidadeAdocao;
import br.com.alura.adopet.api.model.TipoPet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraProbabilidadeAdocaoTest {

    @Test
    void cenario01() {
        //idade: 4, peso: 4 - ALTA

        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
                "Abrigo Boaventura",
                "12988085875",
                "abrigoboaventura@email.com"
        ));

        Pet pet = new Pet(new CadastroPetDto(
                TipoPet.GATO,
                "Miau",
                "SDR",
                4,
                "Laranja",
                4.0f
        ), abrigo);

        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.ALTA, probabilidade);

    }

    @Test
    void cenario02() {
        //idade: 15, peso: 4 - MÉDIA

        Abrigo abrigo = new Abrigo(new CadastroAbrigoDto(
                "Abrigo Boaventura",
                "12988085875",
                "abrigoboaventura@email.com.br"
        ));

        Pet pet = new Pet(new CadastroPetDto(
                TipoPet.GATO,
                "Miau",
                "SDR",
                15,
                "Laranja",
                4.0f
        ), abrigo);

        CalculadoraProbabilidadeAdocao calculadora = new CalculadoraProbabilidadeAdocao();
        ProbabilidadeAdocao probabilidade = calculadora.calcular(pet);

        Assertions.assertEquals(ProbabilidadeAdocao.MEDIA, probabilidade);

    }

}