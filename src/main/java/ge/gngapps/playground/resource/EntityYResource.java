package ge.gngapps.playground.resource;

import org.springframework.hateoas.RepresentationModel;

import ge.gngapps.playground.entity.EntityY;

public class EntityYResource extends RepresentationModel<EntityYResource> {

    private String name;

    public EntityYResource(EntityY entityY) {
        this.name = entityY.getEntityName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
