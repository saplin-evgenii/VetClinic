package org.seuge.vetclinic.dao

import org.seuge.vetclinic.entities.Cat
import org.springframework.stereotype.Repository

/**
 * Cats repository
 * 
 * @author Seuge
 * @since 1.0
 */
@Repository
interface Cats extends Pets<Cat> {
}
