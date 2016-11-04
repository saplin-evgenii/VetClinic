package org.seuge.vetclinic.services.exceptions.util;

/**
 * Application API (service layer) exception messages
 *
 * @author Eugene
 * @since 1.0
 */
public final class ApiExceptionMessages {

    public static final String API_MESSAGE = "API exception:";
    public static final String ENTITY_NOT_FOUND_MESSAGE = "Requested entity was not found.";

    public static final String ENTITY_NOT_FOUND_DETAILS = "Search object: %s: %s";

    private ApiExceptionMessages() {
    }
}
