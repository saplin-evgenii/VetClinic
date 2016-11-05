package org.seuge.vetclinic.dao

import org.seuge.vetclinic.entities.Pet
import org.springframework.context.annotation.Scope
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE

/**
 * Pets repository
 *
 * @author Seuge
 * @since 1.0
 */
@Repository
@Scope(SCOPE_PROTOTYPE)
interface Pets<PetType extends Pet> extends JpaRepository<PetType, Long> {

    Collection<PetType> findByName(String name)
}
