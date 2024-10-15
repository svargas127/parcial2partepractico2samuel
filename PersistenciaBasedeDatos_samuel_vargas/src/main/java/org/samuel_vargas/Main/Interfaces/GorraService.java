package org.samuel_vargas.Main.Interfaces;

import org.samuel_vargas.Main.Domain.Gorra;
import java.util.List;

public interface GorraService {
    void addGorra(Gorra gorra);
    void updateGorra(Gorra gorra);
    void deleteGorra(int id);
    Gorra getGorraById(int id);
    List<Gorra> getAllGorras();
}
