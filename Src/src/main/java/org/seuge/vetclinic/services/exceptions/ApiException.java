package org.seuge.vetclinic.services.exceptions;

import org.seuge.vetclinic.exceptions.AppException;

import static org.seuge.vetclinic.services.exceptions.util.ApiExceptionMessages.API_MESSAGE;

/**
 * Base API (service layer) exception
 *
 * @author Seuge
 * @since 1.0
 */
public abstract class ApiException extends AppException {

    public ApiException() {
        appendMessagePartNewline(API_MESSAGE);
    }
}
