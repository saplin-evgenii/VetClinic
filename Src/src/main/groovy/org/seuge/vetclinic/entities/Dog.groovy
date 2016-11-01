package org.seuge.vetclinic.entities

import groovy.transform.Canonical

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.Table

/**
 * Dog pet
 *
 * @author Seuge
 * @since 1.0
 */
@Entity
@Table(name = "dogs")
@DiscriminatorValue("DOG")
@Canonical
class Dog extends Pet {
}
