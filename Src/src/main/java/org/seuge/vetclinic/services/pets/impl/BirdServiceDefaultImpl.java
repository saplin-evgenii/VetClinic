package org.seuge.vetclinic.services.pets.impl;

import org.seuge.vetclinic.dao.Birds;
import org.seuge.vetclinic.entities.Bird;
import org.seuge.vetclinic.services.pets.BirdService;
import org.springframework.stereotype.Service;

/**
 * Manipulations with birds
 *
 * @author Seuge
 * @since 1.0
 */
@Service
public class BirdServiceDefaultImpl extends PetServiceDefaultImpl<Bird, Birds> implements BirdService {
}
