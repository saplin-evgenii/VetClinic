package org.seuge.vetclinic.entities

import groovy.transform.Canonical

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.Table

/**
 * Bird pet
 *
 * @author Seuge
 * @since 1.0
 */
@Entity
@Table(name = "birds")
@DiscriminatorValue("BIRD")
@Canonical
class Bird extends Pet {
}
