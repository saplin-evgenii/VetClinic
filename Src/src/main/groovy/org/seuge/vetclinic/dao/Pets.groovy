package org.seuge.vetclinic.dao

import org.seuge.vetclinic.entities.Pet
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Pets repository
 * 
 * @author Seuge
 * @since 1.0
 */
interface Pets<PetType extends Pet> extends JpaRepository<PetType, Long> {
}
