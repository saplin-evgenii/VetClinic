package org.seuge.vetclinic.services.exceptions;

import static org.seuge.vetclinic.services.exceptions.util.ApiExceptionMessages.ENTITY_NOT_FOUND_DETAILS;
import static org.seuge.vetclinic.services.exceptions.util.ApiExceptionMessages.ENTITY_NOT_FOUND_MESSAGE;

/**
 * Exception that is thrown when an entity that was expected to exist was not found with specified search object
 *
 * @author Seuge
 * @since 1.0
 */
public class EntityNotFoundException extends ApiException {

    public EntityNotFoundException(String message, Object searchObject) {
        super();
        appendMessagePartNewline(ENTITY_NOT_FOUND_MESSAGE);
        appendMessagePartNewline(String.format(ENTITY_NOT_FOUND_DETAILS, message, searchObject));
    }
}
