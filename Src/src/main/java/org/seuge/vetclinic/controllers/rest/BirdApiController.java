package org.seuge.vetclinic.controllers.rest;

import org.seuge.vetclinic.controllers.dto.BirdDTO;
import org.seuge.vetclinic.entities.Bird;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.seuge.vetclinic.controllers.rest.PetApiController.PETS_URL;

/**
 * Birds REST API controller
 *
 * @author Seuge
 * @since 1.0
 */
@RestController
@RequestMapping(PETS_URL + "/birds")
public class BirdApiController extends PetApiController<Bird, BirdDTO> {

    protected BirdDTO newDto() {
        return new BirdDTO();
    }

    @Override
    protected Bird newEntity() {
        return new Bird();
    }
}
