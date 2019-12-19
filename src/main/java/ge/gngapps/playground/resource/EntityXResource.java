package ge.gngapps.playground.resource;

import org.springframework.hateoas.RepresentationModel;

import ge.gngapps.playground.entity.EntityX;

public class EntityXResource extends RepresentationModel<EntityXResource> {

    private static final EntityYResourceAssembler ENTITY_Y_RESOURCE_ASSEMBLER = new EntityYResourceAssembler();
    private String name;

    private EntityYResource entityYResource;

    public EntityXResource(EntityX entityX) {
        this.name = entityX.getName();
        this.entityYResource = ENTITY_Y_RESOURCE_ASSEMBLER.toModel(entityX.getEntityY());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntityYResource getEntityYResource() {
        return entityYResource;
    }

    public void setEntityYResource(EntityYResource entityYResource) {
        this.entityYResource = entityYResource;
    }
}
