package org.seuge.vetclinic.dao

import org.seuge.vetclinic.entities.Bird
import org.springframework.stereotype.Repository

/**
 * Birds repository
 * 
 * @author Seuge
 * @since 1.0
 */
@Repository
interface Birds extends Pets<Bird> {
}
