package com.riwi.pruebaRiwi.domain.port.interfaces;

import com.riwi.pruebaRiwi.application.dto.request.LoadEntityRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.LoadEntityResponseDto;
import com.riwi.pruebaRiwi.domain.model.LoadEntity;
import com.riwi.pruebaRiwi.domain.port.crud.*;

public interface ILoadEntityService extends
        Create<LoadEntity,LoadEntityRequestDto>,
        ReadAll<LoadEntityResponseDto>,
        ReadById<LoadEntityResponseDto, Long>,
        Update<LoadEntityRequestDto, LoadEntity,Long>,
        Delete<Long>{
}
