package com.riwi.pruebaRiwi.controller.implement;

import com.riwi.pruebaRiwi.domain.port.interfaces.IPaletService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pallets")
@AllArgsConstructor
@Tag(name = "User", description = "Manage user-related request.")
@CrossOrigin("*")
public class PaletControllerImpl {

    private final IPaletService paletService;
}
