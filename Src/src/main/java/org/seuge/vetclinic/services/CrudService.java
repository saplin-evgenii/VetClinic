package org.seuge.vetclinic.services;

/**
 * CRUD service
 *
 * @author Eugene
 * @since 1.0
 */
public interface CrudService<Entity> {

    Entity create(Entity entity);

    Entity getById(long id);

    Entity updateById(long id, Entity entity);

    void deleteById(long id);
}
