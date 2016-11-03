package org.seuge.vetclinic.entities

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.Table

/**
 * Base pet entity
 *
 * @author Seuge
 * @since 1.0
 */
@javax.persistence.Entity
@Table(name = "pets")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Canonical
abstract class Pet extends Entity {

    // Pet name given by owner
    @Column(name = "name")
    String name
}
