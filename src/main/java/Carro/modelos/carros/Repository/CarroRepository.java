package Carro.modelos.carros.Repository;

import Carro.modelos.carros.Model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository <Carro, Long> {
}
