package Carro.modelos.carros;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carros")
@RequiredArgsConstructor

public class CarroController {
    private final CarroService carroService;

    @PostMapping
    public ResponseEntity<CarroResponseDto> salvar(@RequestBody Carro carro) {
        Carro salvo = carroService.salvar(carro);
        return ResponseEntity.ok(toResponseDTO(salvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponseDto> buscarPorId(@PathVariable Long id) {
        Carro carro = carroService.buscarPorId(id);
        return ResponseEntity.ok(toResponseDTO(carro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroResponseDto> atualizar(@RequestBody Carro novoCarro, @PathVariable Long id) {
        Carro atualizado = carroService.atualizar(id,novoCarro);
        return ResponseEntity.ok(toResponseDTO(atualizado));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        carroService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    private CarroResponseDto toResponseDTO(Carro carro){
        CarroResponseDto dto = new CarroResponseDto();
        dto.setId(carro.getId());
        dto.setAno(carro.getAno());
        dto.setMarca(carro.getMarca());
        dto.setPlaca(carro.getPlaca());
        dto.setModelo(carro.getModelo());
        return dto;
    }
}

