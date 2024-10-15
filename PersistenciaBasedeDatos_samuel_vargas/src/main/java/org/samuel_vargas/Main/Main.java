package org.samuel_vargas.Main;

import org.samuel_vargas.Domain.Gorra;
import org.samuel_vargas.Infrastructure.JpaGorraRepository;
import org.samuel_vargas.Services.GorraService;
import org.samuel_vargas.Services.GorraServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GorraService gorraService = new GorraServiceImpl(new JpaGorraRepository());

        // Agregar nuevas gorras
        Gorra gorra1 = new Gorra("Nike", "Rojo", "Beisbolera");
        Gorra gorra2 = new Gorra("Adidas", "Negro", "Snapback");

        gorraService.addGorra(gorra1);
        gorraService.addGorra(gorra2);

        // Obtener todas las gorras
        List<Gorra> gorras = gorraService.getAllGorras();
        System.out.println("Gorras disponibles: " + gorras);

        // Actualizar una gorra
        gorra1.setColor("Azul");
        gorraService.updateGorra(gorra1);

        // Obtener una gorra por ID
        Gorra foundGorra = gorraService.getGorraById(gorra1.getId());
        System.out.println("Gorra encontrada: " + foundGorra);

        // Eliminar una gorra
        gorraService.deleteGorra(gorra2.getId());

        // Verificar la lista de gorras después de la eliminación
        gorras = gorraService.getAllGorras();
        System.out.println("Gorras disponibles después de la eliminación: " + gorras);
    }
}
