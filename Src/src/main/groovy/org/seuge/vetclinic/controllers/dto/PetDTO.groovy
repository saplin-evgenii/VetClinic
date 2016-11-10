package org.seuge.vetclinic.controllers.dto

import groovy.transform.Canonical

/**
 * Pet DTO
 *
 * @author Seuge
 * @since 1.0
 */
@Canonical
abstract class PetDTO extends EntityDTO {

    String name;
}
