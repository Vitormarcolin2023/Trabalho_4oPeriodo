package dev.uniamerica.carrosapi.service;

import dev.uniamerica.carrosapi.model.Carro;
import dev.uniamerica.carrosapi.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    private final CarroRepository carroRepository;

  public List<Carro> findAll() {
      return carroRepository.getCarros();
  }

  public Carro findById(Integer id) {
      return carroRepository.getCarro(id);
  }

  public Carro save(Carro carro) {
      return carroRepository.save(carro);
  }

  public void delete(Integer id) {
      carroRepository.delete(id);
  }

  public Carro update(Integer id, Carro carroUpdate) {
      return carroRepository.update(id, carroUpdate);
  }
}
