package org.seuge.vetclinic.entities

import groovy.transform.Canonical

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.Table

/**
 * Cat pet
 *
 * @author Seuge
 * @since 1.0
 */
@Entity
@Table(name = "cats")
@DiscriminatorValue("CAT")
@Canonical
class Cat extends Pet {
}
