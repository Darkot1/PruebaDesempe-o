package com.riwi.pruebaRiwi.controller.implement;

import com.riwi.pruebaRiwi.application.dto.request.LoadEntityRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.LoadEntityResponseDto;
import com.riwi.pruebaRiwi.controller.interfaces.ILoadController;
import com.riwi.pruebaRiwi.domain.model.LoadEntity;
import com.riwi.pruebaRiwi.domain.port.interfaces.ILoadEntityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/loads")
@AllArgsConstructor
@Tag(name = "loads", description = "Manage loads -related request.")
@CrossOrigin("*")
public class LoadControllerImp implements ILoadController {

    @Autowired
    private final ILoadEntityService loadService;


    @SecurityRequirement(name = "bearerAuth")
    @PostMapping
    @Operation(
            summary = "Create a new load.",
            description = "Provides the load data to create a new Load."
    )
    @Override
    public ResponseEntity<LoadEntity> create(@Validated @RequestBody LoadEntityRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loadService.create(requestDto));
    }


    @SecurityRequirement(name = "bearerAuth")
    @DeleteMapping("{id}")
    @Operation(
            summary = "Delete a load.",
            description = "Deletes a load with the specified ID."
    )
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        loadService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping
    @Operation(
            summary = "Get all loads.",
            description = "Returns a list of all loads."
    )
    @Override
    public ResponseEntity<List<LoadEntityResponseDto>> readAll() {
        return ResponseEntity.ok(loadService.readAll());
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/{id}")
    @Operation(
            summary = "Get load by ID.",
            description = "Returns a load with the specified ID."
    )
    @Override
    public ResponseEntity<LoadEntityResponseDto> readById(Long aLong) {
        return ResponseEntity.ok(loadService.readById(aLong));
    }

    @SecurityRequirement(name = "bearerAuth")
    @PutMapping("/{id}")
    @Operation(
            summary = "Update a load.",
            description = "Updates a load with the specified ID."
    )
    @Override
    public ResponseEntity<LoadEntity> update(@Validated @RequestBody LoadEntityRequestDto requestDto,
                                        @PathVariable Long id) {
        return ResponseEntity.ok(loadService.update(requestDto, id));
    }
}
