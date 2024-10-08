package com.riwi.pruebaRiwi.domain.port.crud;

public interface Create <Entity,EntityRequest>{
    public Entity create (EntityRequest request);
}
