package org.seuge.vetclinic.controllers.dto

import groovy.transform.Canonical

/**
 * Pet DTO
 *
 * @author Seuge
 * @since 1.0
 */
@Canonical
class PetDTO extends BaseDTO {

    Long id;

    String name;
}
