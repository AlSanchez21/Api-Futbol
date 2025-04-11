package com.futbol.api;

import com.futbol.api.models.Equipo;
import com.futbol.api.repositories.EquipoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final EquipoRepository equipoRepository;

    public DataLoader(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (equipoRepository.count() == 0) {
            equipoRepository.save(new Equipo(null, "Barcelona", "España", 1899));
            equipoRepository.save(new Equipo(null, "Real Madrid", "España", 1902));
            equipoRepository.save(new Equipo(null, "Manchester United", "Inglaterra", 1878));
            equipoRepository.save(new Equipo(null, "Boca Juniors", "Argentina", 1905));
            equipoRepository.save(new Equipo(null, "River Plate", "Argentina", 1901));
            equipoRepository.save(new Equipo(null, "Bayern Munich", "Alemania", 1900));
            equipoRepository.save(new Equipo(null, "Juventus", "Italia", 1897));
        }
    }
}
