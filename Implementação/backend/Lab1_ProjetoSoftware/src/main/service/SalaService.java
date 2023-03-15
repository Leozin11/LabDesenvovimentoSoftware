package main.service;

import main.model.Funcionario;
import main.model.Sala;

public interface SalaService {

    Sala criarSala(Sala sala) throws Exception;
    Sala editarSala(Long id, Sala sala) throws Exception;
    Sala deletarSala(Long id) throws Exception;

    Sala findSalaById(Long id) throws Exception;
    Sala findSalaByNumber(int Numero) throws Exception;
}

