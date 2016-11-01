package org.seuge.vetclinic.dao

import org.seuge.vetclinic.entities.Dog
import org.springframework.stereotype.Repository

/**
 * Dogs repository
 * 
 * @author Seuge
 * @since 1.0
 */
@Repository
interface Dogs extends Pets<Dog> {
}
