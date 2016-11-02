package org.seuge.vetclinic.services.pets;

import org.seuge.vetclinic.dao.Pets;
import org.seuge.vetclinic.entities.Pet;
import org.seuge.vetclinic.services.CrudService;

/**
 * CRUD service
 *
 * @author Eugene
 * @since 1.0
 */
public interface PetService<PetType extends Pet, PetDao extends Pets> extends CrudService<PetType> {
}
