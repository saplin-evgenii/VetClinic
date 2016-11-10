package org.seuge.vetclinic.controllers.dto

import groovy.transform.Canonical

/**
 * Base for all transferable objects DTO
 *
 * @author Seuge
 * @since 1.0
 */
@Canonical
abstract class EntityDTO {

    Long id;
}
