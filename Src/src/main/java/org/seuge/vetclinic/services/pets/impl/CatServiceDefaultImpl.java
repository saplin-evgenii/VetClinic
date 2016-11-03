package org.seuge.vetclinic.services.pets.impl;

import org.seuge.vetclinic.dao.Cats;
import org.seuge.vetclinic.entities.Cat;
import org.seuge.vetclinic.services.pets.CatService;
import org.springframework.stereotype.Service;

/**
 * Manipulations with cats
 *
 * @author Seuge
 * @since 1.0
 */
@Service
public class CatServiceDefaultImpl extends PetServiceDefaultImpl<Cat, Cats> implements CatService {
}
