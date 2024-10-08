package com.riwi.pruebaRiwi.domain.port.crud;

public interface ReadById <Entity,ID>{
    public Entity readById(ID id);
}
