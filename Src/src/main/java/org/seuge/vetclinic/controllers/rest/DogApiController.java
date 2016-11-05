package org.seuge.vetclinic.controllers.rest;

import org.seuge.vetclinic.controllers.dto.DogDTO;
import org.seuge.vetclinic.entities.Dog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.seuge.vetclinic.controllers.rest.PetApiController.PETS_URL;

/**
 * Dogs REST API controller
 *
 * @author Seuge
 * @since 1.0
 */
@RestController
@RequestMapping(PETS_URL + "/dogs")
public class DogApiController extends PetApiController<Dog, DogDTO> {

    protected DogDTO newDto() {
        return new DogDTO();
    }

    @Override
    protected Dog newEntity() {
        return new Dog();
    }
}
