package org.seuge.vetclinic.services.pets.impl;

import org.seuge.vetclinic.dao.Pets;
import org.seuge.vetclinic.entities.Pet;
import org.seuge.vetclinic.services.CrudService;
import org.seuge.vetclinic.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Entity CRUD operations
 *
 * @author Seuge
 * @since 1.0
 */
@Transactional
@SuppressWarnings("unchecked")
public class CrudServiceDefaultImpl<EntityType extends Pet, EntityDao extends Pets> implements CrudService<EntityType> {

    @Autowired
    private EntityDao dao;

    @Override
    public EntityType create(EntityType entity) {
        return (EntityType) dao.save(entity);
    }

    @Override
    public EntityType getById(long id) throws EntityNotFoundException {
        EntityType entity = (EntityType) dao.findOne(id);
        if (entity == null) {
            throw new EntityNotFoundException("id", id);
        }
        return entity;
    }

    @Override
    public EntityType updateById(long id, EntityType entity) throws EntityNotFoundException {
        if (!dao.exists(id)) {
            throw new EntityNotFoundException("id", id);
        }
        entity.setId(id);
        return (EntityType) dao.save(entity);
    }

    @Override
    public void deleteById(long id) throws EntityNotFoundException {
        if (!dao.exists(id)) {
            throw new EntityNotFoundException("id", id);
        }
        dao.delete(id);
    }
}
