package org.seuge.vetclinic.services.pets.impl;

import org.seuge.vetclinic.dao.Pets;
import org.seuge.vetclinic.entities.Pet;
import org.seuge.vetclinic.services.pets.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Manipulations with pets
 *
 * @author Seuge
 * @since 1.0
 */
@Service
@Transactional
public class PetServiceDefaultImpl<PetType extends Pet> implements PetService<PetType> {

    @Autowired
    private Pets<PetType> dao;

    @Override
    public PetType create(PetType pet) {
        return dao.save(pet);
    }

    @Override
    public PetType getById(long id) {
        return dao.findOne(id);
    }

    @Override
    public PetType updateById(long id, PetType pet) {
        pet.setId(id);
        return dao.save(pet);
    }

    @Override
    public void deleteById(long id) {
        dao.delete(id);
    }
}
