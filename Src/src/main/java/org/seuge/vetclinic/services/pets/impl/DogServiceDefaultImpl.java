package org.seuge.vetclinic.services.pets.impl;

import org.seuge.vetclinic.dao.Dogs;
import org.seuge.vetclinic.entities.Dog;
import org.seuge.vetclinic.services.pets.DogService;
import org.springframework.stereotype.Service;

/**
 * Manipulations with dogs
 *
 * @author Seuge
 * @since 1.0
 */
@Service
public class DogServiceDefaultImpl extends PetServiceDefaultImpl<Dog, Dogs> implements DogService {
}
