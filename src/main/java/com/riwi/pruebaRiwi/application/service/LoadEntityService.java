package com.riwi.pruebaRiwi.application.service;

import com.riwi.pruebaRiwi.application.dto.request.LoadEntityRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.LoadEntityResponseDto;
import com.riwi.pruebaRiwi.application.mapper.LoadEntityMapper;
import com.riwi.pruebaRiwi.domain.model.LoadEntity;
import com.riwi.pruebaRiwi.domain.model.Palet;
import com.riwi.pruebaRiwi.domain.port.interfaces.ILoadEntityService;
import com.riwi.pruebaRiwi.infrastructure.persistence.LoadEntityRepository;
import com.riwi.pruebaRiwi.infrastructure.persistence.PaletRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class LoadEntityService implements ILoadEntityService {

    @Autowired
    private LoadEntityRepository repository;

    @Autowired
    private LoadEntityMapper mapper;

    @Autowired
    private PaletRepository paletRepository;


    @Override
    public LoadEntity create(LoadEntityRequestDto request) {
        // Validar que el palet existe
        Palet palet = paletRepository.findById(request.getPalet().getId())
                .orElseThrow(() -> new RuntimeException("Palet not found"));

        // Validar la capacidad del palet
        Double totalWeightLoads = palet.getLoads().stream()
                .mapToDouble(LoadEntity::getWeight)
                .sum();

        if (totalWeightLoads + request.getWeight() > palet.getCapacity()) {
            throw new RuntimeException("the load exceeds the capacity of the pallet");
        }

        // Crear la carga
        LoadEntity load = mapper.toEntity(request);
        load.setPalet(palet);
        LoadEntity savedLoad = repository.save(load);

        // Devolver la carga guardada como LoadEntityResponseDto
        return savedLoad;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);


    }

    @Override
    public List<LoadEntityResponseDto> readAll() {
        List<LoadEntity> load = repository.findAll();

        return load.stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public LoadEntityResponseDto readById(Long id) {
        LoadEntity load = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Load Not Found"));
        return mapper.toResponseDto(load);
    }


    @Override
    public LoadEntity update(LoadEntityRequestDto requestDto, Long id) {
        LoadEntity load = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Load Not Found"));

        Palet palet = paletRepository.findById(requestDto.getPalet().getId())
                .orElseThrow(() -> new RuntimeException("pallet Not Found"));

        validatePaletCapacity(palet, requestDto.getWeight());

        mapper.toEntity(requestDto);
        load.setPalet(palet);
        LoadEntity updatedLoad = repository.save(load);

        return updatedLoad;
    }

    private void validatePaletCapacity(Palet palet, Integer newLoadWeight) {
        Double totalWeightLoads = palet.getLoads().stream()
                .mapToDouble(LoadEntity::getWeight)
                .sum();

        if (totalWeightLoads + newLoadWeight > palet.getCapacity()) {
            throw new RuntimeException("the Load Exceeds The Capacity Of The Pallet");
        }
    }



}
