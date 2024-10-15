package org.samuel_vargas.Main.service;

import org.samuel_vargas.Main.Domain.Gorra;
import org.samuel_vargas.Main.Aplication.GorraRepository;
import java.util.List;

public class GorraServiceImpl implements GorraService {

    private final GorraRepository gorraRepository;

    public GorraServiceImpl(GorraRepository gorraRepository) {
        this.gorraRepository = gorraRepository;
    }

    @Override
    public void addGorra(Gorra gorra) {
        gorraRepository.saveGorra(gorra);
    }

    @Override
    public void updateGorra(Gorra gorra) {
        gorraRepository.updateGorra(gorra);
    }

    @Override
    public void deleteGorra(int id) {
        gorraRepository.deleteGorra(id);
    }

    @Override
    public Gorra getGorraById(int id) {
        return gorraRepository.findGorraById(id);
    }

    @Override
    public List<Gorra> getAllGorras() {
        return gorraRepository.findAll();
    }
}
