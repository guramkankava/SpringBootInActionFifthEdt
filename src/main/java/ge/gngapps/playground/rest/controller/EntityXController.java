package ge.gngapps.playground.rest.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ge.gngapps.playground.entity.EntityX;
import ge.gngapps.playground.resource.EntityXResource;
import ge.gngapps.playground.resource.EntityXResourceAssembler;
import ge.gngapps.playground.service.EntityXService;

@RestController
@RequestMapping(path = "entityX")
public class EntityXController {

    @Autowired
    private EntityXService entityXService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EntityX> getAll() {
        return entityXService.getAll();
    }

    @GetMapping(path = "/v2", produces = MediaType.APPLICATION_JSON_VALUE)
    public CollectionModel<EntityModel<EntityX>> getAllV2() {
        CollectionModel<EntityModel<EntityX>> cm = CollectionModel.wrap(entityXService.getAll());

//        cm.forEach(em -> {
//            em.add(linkTo(PlayWithController.class).slash(em.getContent().getEntityId()).withRel("self"));
//        });

        cm.forEach(em -> {
            em.add(linkTo(methodOn(EntityXController.class).getById(em.getContent().getEntityId())).withRel("self"));
        });

        //cm.add(linkTo(PlayWithController.class).slash("v2").withRel("self"));

        cm.add(linkTo(methodOn(EntityXController.class).getAllV2()).withRel("self"));

//        cm.add(linkTo(methodOn(PlayWithController.class).getAllV2()).withRel("playWiths"));

//        new EntityXResourceAssembler(PlayWithController.class, EntityXResource.class).toModel(playWithService.getAll());
        return cm;
    }

    @GetMapping(path = "/v3", produces = MediaType.APPLICATION_JSON_VALUE)
    public CollectionModel<EntityXResource> getAllV3() {
        List<EntityX> allXEntityes = entityXService.getAll();

        CollectionModel<EntityXResource> collectionModel = new CollectionModel<>(new EntityXResourceAssembler().toCollectionModel(allXEntityes));

        collectionModel.add(linkTo(methodOn(EntityXController.class).getAllV3()).withRel("self"));

        return collectionModel;
    }


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntityX getById(@PathVariable long id) {
        return entityXService.getById(id);
    }
}
