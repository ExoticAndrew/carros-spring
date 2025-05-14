package Carro.modelos.carros.Service;

import Carro.modelos.carros.Model.Carro;
import Carro.modelos.carros.Repository.CarroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarroService  {
    private final CarroRepository carroRepository;

    public Carro salvar (Carro carro){
       return carroRepository.save(carro);
    }
    public Carro buscarPorId(Long id){
        return carroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Esse carro não existe"));

    }
public Carro atualizar(Long id, Carro novocarro){
        Carro carro = buscarPorId(id);
        carro.setModelo(novocarro.getModelo());
        carro.setMarca(novocarro.getMarca());
        carro.setId(novocarro.getId());
        carro.setPlaca(novocarro.getPlaca());
        carro.setAno(novocarro.getAno());
        return carroRepository.save(carro);
}
public void deletar(Long id){
        carroRepository.deleteById(id);
}

}
