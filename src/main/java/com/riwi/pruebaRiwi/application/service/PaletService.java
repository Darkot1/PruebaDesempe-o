package com.riwi.pruebaRiwi.application.service;

import com.riwi.pruebaRiwi.application.dto.request.PaletRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.PaletResponseDto;
import com.riwi.pruebaRiwi.application.mapper.PaletMapper;
import com.riwi.pruebaRiwi.domain.model.Palet;
import com.riwi.pruebaRiwi.domain.port.interfaces.IPaletService;
import com.riwi.pruebaRiwi.infrastructure.persistence.PaletRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class PaletService implements IPaletService {

    @Autowired
    private PaletMapper paletMapper;

    @Autowired
    private PaletRepository paletRepository;

    @Override
    public Palet create(PaletRequestDto requestDto) {
        if (requestDto.getCapacity() <= 0) {
            throw new RuntimeException("the Pallet Capacity Must Be A Positive Value");
        }
        if (requestDto.getUbication() == null || requestDto.getUbication().isEmpty()) {
            throw new RuntimeException("pallet Location Cannot Be Empty.");
        }
        Palet palet = paletMapper.toEntity(requestDto);
        Palet savedPalet = paletRepository.save(palet);
        return savedPalet;

    }

    @Override
    public List<PaletResponseDto> readAll() {
        List<Palet> palets = paletRepository.findAll();
        return palets.stream()
                .map(paletMapper::toResponseDto)
                .collect(Collectors.toList());
    }


    @Override
    public Palet readById(Long id) {
        Palet palet = paletRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Palet not found"));
        return palet;
    }


    @Override
    public Palet update(PaletRequestDto requestDto, Long id) {
        Palet palet = paletRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Palet not found"));

        if (requestDto.getCapacity() <= 0) {
            throw new RuntimeException("the Pallet Capacity Must Be A Positive Value");
        }
        if (requestDto.getUbication() == null || requestDto.getUbication().isEmpty()) {
            throw new RuntimeException("the Pallet Location Cannot Be Empty");
        }

        paletMapper.toEntity(requestDto);
        Palet updatedPalet = paletRepository.save(palet);
        return updatedPalet;
    }

    @Override
    public void delete(Long id) {

    }

}
