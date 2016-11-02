package org.seuge.vetclinic.services.pets.impl;

import org.seuge.vetclinic.dao.Pets;
import org.seuge.vetclinic.entities.Pet;
import org.seuge.vetclinic.services.pets.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Manipulations with pets
 *
 * @author Seuge
 * @since 1.0
 */
@Transactional
@SuppressWarnings("unchecked")
public class PetServiceDefaultImpl<PetType extends Pet, PetDao extends Pets> implements PetService<PetType, PetDao> {

    @Autowired
    private PetDao dao;

    @Override
    public PetType create(PetType pet) {
        return (PetType) dao.save(pet);
    }

    @Override
    public PetType getById(long id) {
        return (PetType) dao.findOne(id);
    }

    @Override
    public PetType updateById(long id, PetType pet) {
        pet.setId(id);
        return (PetType) dao.save(pet);
    }

    @Override
    public void deleteById(long id) {
        dao.delete(id);
    }
}
