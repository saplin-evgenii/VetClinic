package org.seuge.vetclinic.entities

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * Base global entity
 *
 * @author Seuge
 * @since 1.0
 */
@MappedSuperclass
@Canonical
abstract class Entity {

    // Internal entity identifier
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
}
