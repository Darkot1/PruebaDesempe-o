package com.riwi.pruebaRiwi.domain.port.crud;

public interface Update <EntityRequest, Entity, ID> {
    public Entity update(EntityRequest request, ID id);
}
