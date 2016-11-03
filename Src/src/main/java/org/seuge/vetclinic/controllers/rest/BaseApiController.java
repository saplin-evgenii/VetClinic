package org.seuge.vetclinic.controllers.rest;

import org.seuge.vetclinic.controllers.dto.BaseDTO;
import org.seuge.vetclinic.controllers.dto.CatDTO;
import org.seuge.vetclinic.services.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 *
 * @author Seuge
 * @since 1.0
 */
//TODO: introduce Base class as the base entity for the controller and use it instead of Entity type parameter
public abstract class BaseApiController<Entity, BaseDtoType extends BaseDTO> {

    protected static final String BASE_URL = "/api";

    @Autowired
    private CrudService<Entity> crudService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<BaseDtoType> getEntityById(@PathVariable("id") long id) {
        BaseDtoType entityDTO = entityToDto(crudService.getById(id), newDto());
        return new ResponseEntity<>(entityDTO, HttpStatus.OK);
    }

    protected abstract BaseDtoType newDto();

    protected BaseDtoType entityToDto(Entity entity, BaseDtoType newDto) {
        return newDto;
    }

    protected abstract Entity dtoToEntity(BaseDtoType dto);
}
