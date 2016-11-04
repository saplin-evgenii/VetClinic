package org.seuge.vetclinic.services;

import org.seuge.vetclinic.services.exceptions.EntityNotFoundException;

/**
 * CRUD service
 *
 * @author Eugene
 * @since 1.0
 */
public interface CrudService<Entity> {

    Entity create(Entity entity);

    Entity getById(long id) throws EntityNotFoundException;

    Entity updateById(long id, Entity entity) throws EntityNotFoundException;

    void deleteById(long id) throws EntityNotFoundException;
}
