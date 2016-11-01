package org.seuge.vetclinic.entities

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.Table

/**
 * Base pet entity
 *
 * @author Seuge
 * @since 1.0
 */

@Entity
@Table(name = "pets")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Canonical
abstract class Pet {

    // Internal pet identifier
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    // Pet name given by owner
    @Column(name = "name")
    String name
}
