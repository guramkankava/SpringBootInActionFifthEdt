package ge.gngapps.playground.resource;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import ge.gngapps.playground.entity.EntityX;
import ge.gngapps.playground.rest.controller.EntityXController;

public class EntityXResourceAssembler extends RepresentationModelAssemblerSupport<EntityX, EntityXResource> {

    public EntityXResourceAssembler() {
        super(EntityXController.class, EntityXResource.class);
    }

    @Override
    protected EntityXResource instantiateModel(EntityX entityX) {
        return new EntityXResource(entityX);
    }

    @Override
    public EntityXResource toModel(EntityX entityX) {
        return createModelWithId(entityX.getEntityId(), entityX);
    }

}
