package org.samuel_vargas.Main.Aplication;

import org.samuel_vargas.Main.Domain.Gorra;
import java.util.List;

public interface GorraRepository {
    void saveGorra(Gorra gorra);
    void updateGorra(Gorra gorra);
    void deleteGorra(int id);
    Gorra findGorraById(int id);
    List<Gorra> findAll();
}
