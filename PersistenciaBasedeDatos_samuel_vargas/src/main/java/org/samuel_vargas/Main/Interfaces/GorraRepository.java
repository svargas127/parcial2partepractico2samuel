package org.samuel_vargas.Main.Interfaces;

import org.samuel_vargas.Main.Domain.Gorra;

import java.util.List;
import java.util.Optional;

public interface GorraRepository {

    void saveCancha(Gorra cancha);
    void updateCancha(Gorra cancha);
    void deleteCancha(int id);
    Optional<Gorra> findCanchaById(int id);
    List<Gorra> findAll();
}
