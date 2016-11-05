package org.seuge.vetclinic.services.pets;

import org.seuge.vetclinic.entities.Pet;
import org.seuge.vetclinic.services.CrudService;

/**
 * Manipulations with pets
 *
 * @author Eugene
 * @since 1.0
 */
public interface PetService<PetType extends Pet> extends CrudService<PetType> {
}
