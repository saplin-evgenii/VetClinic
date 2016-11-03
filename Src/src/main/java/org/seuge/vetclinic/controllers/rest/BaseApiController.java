package org.seuge.vetclinic.controllers.rest;

import org.seuge.vetclinic.controllers.dto.EntityDTO;
import org.seuge.vetclinic.entities.Entity;
import org.seuge.vetclinic.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.seuge.vetclinic.controllers.util.ControllerConsts.ID_PATTERN;

/**
 * Base controller containing all REST API related logic
 *
 * @author Seuge
 * @since 1.0
 */
public abstract class BaseApiController<EntityType extends Entity, EntityDtoType extends EntityDTO> {

    protected static final String BASE_URL = "/api";

    @Autowired
    private CrudService<EntityType> crudService;

    /**
     * Creates entity by specified prototype with 201 status ("created")
     *
     * @param entityDto entity prototype
     * @return response wrapper with entity updated with id
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Long> createEntity(@RequestBody EntityDtoType entityDto) {
        EntityType entity = dtoToEntity(entityDto, newEntity());
        EntityType entityCreated = crudService.create(entity);
        return new ResponseEntity<>(entityCreated.getId(), HttpStatus.CREATED);
    }

    /**
     * Returns entity by specified id with http 200 status ("OK")
     *
     * @param id id of entity to be returned
     * @return response wrapper with entity
     */
    @RequestMapping(value = "/{id:" + ID_PATTERN + "}", method = RequestMethod.GET)
    public ResponseEntity<EntityDtoType> getEntityById(@PathVariable("id") long id) {
        EntityDtoType entityDTO = entityToDto(crudService.getById(id), newDto());
        return new ResponseEntity<>(entityDTO, HttpStatus.OK);
    }

    /**
     * Updates entity with specified prototype's properties by specified id with 200 status ("OK")
     *
     * @param id        id of entity to be updated
     * @param entityDto entity prototype (id is ignored)
     * @return response wrapper with entity updated with id
     */
    @RequestMapping(value = "/{id:" + ID_PATTERN + "}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEntity(@PathVariable("id") long id, @RequestBody EntityDtoType entityDto) {
        EntityType entity = dtoToEntity(entityDto, newEntity());
        crudService.updateById(id, entity);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Deletes entity by specified id with http 204 status ("no content")
     *
     * @param id id of entity to be deleted
     * @return response wrapper
     */
    @RequestMapping(value = "/{id:" + ID_PATTERN + "}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEntityById(@PathVariable("id") long id) {
        crudService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    protected abstract EntityDtoType newDto();

    protected EntityDtoType entityToDto(EntityType entity, EntityDtoType newDto) {
        return newDto;
    }

    protected abstract EntityType newEntity();

    protected EntityType dtoToEntity(EntityDtoType dto, EntityType newEntity) {
        return newEntity;
    }
}
