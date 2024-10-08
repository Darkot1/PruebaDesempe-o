package com.riwi.pruebaRiwi.controller.interfaces;

import com.riwi.pruebaRiwi.application.dto.request.LoadEntityRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.LoadEntityResponseDto;
import com.riwi.pruebaRiwi.controller.crud.*;
import com.riwi.pruebaRiwi.domain.model.LoadEntity;

public interface ILoadController extends
        CreateController<LoadEntityRequestDto, LoadEntity>,
        ReadAllController<LoadEntityResponseDto>,
        ReadByIdController<LoadEntityResponseDto, Long>,
        DeleteController<Long>,
        UpdateController<LoadEntityRequestDto, LoadEntity, Long> {
}
