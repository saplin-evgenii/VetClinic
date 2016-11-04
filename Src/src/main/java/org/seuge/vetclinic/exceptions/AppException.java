package org.seuge.vetclinic.exceptions;

import static org.seuge.vetclinic.exceptions.util.AppExceptionMessages.APP_MESSAGE;

/**
 * Base for all custom exception classes application exception
 *
 * @author Seuge
 * @since 1.0
 */
public abstract class AppException extends Exception {

    private String message = "";

    public AppException() {
        appendMessagePartNewline(APP_MESSAGE);
    }

    @Override
    public String getMessage() {
        return message;
    }

    protected void appendMessagePart(String messagePart) {
        message += messagePart;
    }

    protected void appendMessagePartNewline(String messagePart) {
        appendMessagePart(messagePart);
        message += System.lineSeparator();
    }
}
