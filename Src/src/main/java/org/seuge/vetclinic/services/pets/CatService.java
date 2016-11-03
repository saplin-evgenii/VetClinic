package org.seuge.vetclinic.services.pets;

import org.seuge.vetclinic.dao.Cats;
import org.seuge.vetclinic.entities.Cat;

/**
 * CRUD service
 *
 * @author Eugene
 * @since 1.0
 */
public interface CatService extends PetService<Cat, Cats> {
}
