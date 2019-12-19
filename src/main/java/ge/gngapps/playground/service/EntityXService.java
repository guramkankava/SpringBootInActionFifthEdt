package ge.gngapps.playground.service;

import java.util.List;

import ge.gngapps.playground.entity.EntityX;

public interface EntityXService {

    public List<EntityX> getAll();

    public EntityX getById(long id);
}
