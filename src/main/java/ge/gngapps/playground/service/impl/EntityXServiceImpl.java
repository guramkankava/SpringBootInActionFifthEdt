package ge.gngapps.playground.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ge.gngapps.playground.entity.EntityX;
import ge.gngapps.playground.service.EntityXService;
import ge.gngapps.playground.service.EntityYService;

@Service
public class EntityXServiceImpl implements EntityXService {

    @Autowired
    private EntityYService entityYService;

    @Override
    public List<EntityX> getAll() {
        EntityX entityX = new EntityX();
        entityX.setEntityId(1L);
        entityX.setName("EntityX 1");
        entityX.setEntityY(entityYService.getById(1));

        EntityX entityX2 = new EntityX();
        entityX2.setEntityId(2L);
        entityX2.setName("EntityX 2");
        entityX2.setEntityY(entityYService.getById(2L));

        EntityX entityX3 = new EntityX();
        entityX3.setEntityId(3L);
        entityX3.setName("EntityX 3");
        return Arrays.asList(entityX, entityX2, entityX3);
    }

    @Override
    public EntityX getById(long id) {
        EntityX entityX = new EntityX();
        entityX.setEntityId(id);
        entityX.setName("EntityX " + id);
        return entityX;
    }
}
