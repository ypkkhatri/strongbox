package org.carlspring.strongbox.storage.validation.version;

/**
 * @author mtodorov
 */
public class VersionValidationException
        extends Exception
{

    public VersionValidationException()
    {
    }

    public VersionValidationException(String message)
    {
        super(message);
    }

    public VersionValidationException(String message,
                                      Throwable cause)
    {
        super(message, cause);
    }

    public VersionValidationException(Throwable cause)
    {
        super(cause);
    }

}
