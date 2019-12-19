package ge.gngapps.playground.resource;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import ge.gngapps.playground.entity.EntityY;
import ge.gngapps.playground.rest.controller.EntityYController;

public class EntityYResourceAssembler extends RepresentationModelAssemblerSupport<EntityY, EntityYResource> {

    public EntityYResourceAssembler() {
        super(EntityYController.class, EntityYResource.class);
    }

    @Override
    public EntityYResource toModel(EntityY entityY) {
        return entityY != null ? createModelWithId(entityY.getEntityId(), entityY) : null;
    }

    @Override
    protected EntityYResource instantiateModel(EntityY entityY) {
        return new EntityYResource(entityY);
    }

}
