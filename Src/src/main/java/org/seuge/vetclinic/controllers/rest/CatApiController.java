package org.seuge.vetclinic.controllers.rest;

import org.seuge.vetclinic.controllers.dto.CatDTO;
import org.seuge.vetclinic.entities.Cat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.seuge.vetclinic.controllers.rest.PetApiController.PETS_URL;

/**
 *
 *
 * @author Seuge
 * @since 1.0
 */
@RestController
@RequestMapping(PETS_URL + "/cats")
public class CatApiController extends PetApiController<Cat, CatDTO> {

    protected CatDTO newDto() {
        return new CatDTO();
    }

    @Override
    protected Cat dtoToEntity(CatDTO o) {
        return null;
    }
}
