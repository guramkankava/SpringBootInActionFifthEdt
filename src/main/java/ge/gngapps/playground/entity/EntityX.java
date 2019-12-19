package ge.gngapps.playground.entity;

import org.springframework.hateoas.EntityModel;

public class EntityX extends EntityModel<EntityX> {

    private long entityId;

    private String name;

    private EntityY entityY;

    public long getEntityId() {
        return entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntityY getEntityY() {
        return entityY;
    }

    public void setEntityY(EntityY entityY) {
        this.entityY = entityY;
    }

}
