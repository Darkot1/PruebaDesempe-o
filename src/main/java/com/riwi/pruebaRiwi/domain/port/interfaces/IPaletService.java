package com.riwi.pruebaRiwi.domain.port.interfaces;

import com.riwi.pruebaRiwi.application.dto.request.PaletRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.PaletResponseDto;
import com.riwi.pruebaRiwi.domain.model.Palet;
import com.riwi.pruebaRiwi.domain.port.crud.*;

public interface IPaletService extends
        Create<Palet, PaletRequestDto>,
        ReadById<Palet, Long>,
        ReadAll<PaletResponseDto>,
        Update<PaletRequestDto,Palet, Long>,
        Delete<Long>{
}
