package com.riwi.pruebaRiwi.controller.crud;

import org.springframework.http.ResponseEntity;

public interface ReadByIdController <Entity, ID>{
    public ResponseEntity<Entity> readById(ID id);
}
