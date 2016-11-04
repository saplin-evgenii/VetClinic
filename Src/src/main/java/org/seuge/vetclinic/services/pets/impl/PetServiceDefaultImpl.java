package org.seuge.vetclinic.services.pets.impl;

import org.seuge.vetclinic.dao.Pets;
import org.seuge.vetclinic.entities.Pet;
import org.seuge.vetclinic.services.pets.PetService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Manipulations with pets
 *
 * @author Seuge
 * @since 1.0
 */
@Transactional
public class PetServiceDefaultImpl<PetType extends Pet, PetDao extends Pets>
        extends CrudServiceDefaultImpl<PetType, PetDao> implements PetService<PetType, PetDao> {
}
