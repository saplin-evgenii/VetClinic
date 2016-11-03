package org.seuge.vetclinic.controllers.rest;

import org.seuge.vetclinic.controllers.dto.CatDTO;
import org.seuge.vetclinic.controllers.dto.PetDTO;
import org.seuge.vetclinic.entities.Cat;
import org.seuge.vetclinic.entities.Pet;

/**
 * @author Seuge
 * @since 1.0
 */
public abstract class PetApiController<PetType extends Pet, PetDtoType extends PetDTO>
        extends BaseApiController<PetType, PetDtoType> {

    protected static final String PETS_URL = BASE_URL + "/pets";

    @Override
    protected PetDtoType entityToDto(PetType pet, PetDtoType newDto) {
        PetDtoType dto = super.entityToDto(pet, newDto);
        dto.setId(pet.getId());
        dto.setName(pet.getName());
        return dto;
    }

    @Override
    protected Pet dtoToEntity(PetDTO o) {
        return null;
    }
}
