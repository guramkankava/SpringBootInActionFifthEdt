package ge.gngapps.playground.service;

import java.util.List;

import ge.gngapps.playground.entity.EntityY;

public interface EntityYService {

    public List<EntityY> getAll();

    public EntityY getById(long id);
}
