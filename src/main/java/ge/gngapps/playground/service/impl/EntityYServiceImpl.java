package ge.gngapps.playground.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import ge.gngapps.playground.entity.EntityY;
import ge.gngapps.playground.service.EntityYService;

@Service
public class EntityYServiceImpl implements EntityYService {

    @Override
    public List<EntityY> getAll() {
        EntityY entityY = new EntityY();
        entityY.setEntityId(1L);
        entityY.setEntityName("EntityY 1");

        EntityY entityY2 = new EntityY();
        entityY2.setEntityId(2L);
        entityY2.setEntityName("EntityY 2");

        EntityY entityY3 = new EntityY();
        entityY3.setEntityId(3L);
        entityY3.setEntityName("EntityY 3");
        return Arrays.asList(entityY, entityY2, entityY3);
    }

    @Override
    public EntityY getById(long id) {
        EntityY entityY = new EntityY();
        entityY.setEntityId(id);
        entityY.setEntityName("EntityY " + id);
        return entityY;
    }

}
