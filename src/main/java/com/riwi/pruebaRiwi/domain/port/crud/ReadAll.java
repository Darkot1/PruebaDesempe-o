package com.riwi.pruebaRiwi.domain.port.crud;

import java.util.List;

public interface ReadAll<Entity> {
    public List<Entity> readAll();

}
