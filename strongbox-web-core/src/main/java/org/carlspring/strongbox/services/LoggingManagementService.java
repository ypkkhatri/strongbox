package org.carlspring.strongbox.services;

import java.io.IOException;

/**
 * @author mtodorov
 */
public interface LoggingManagementService
{

    void addLogger(String fullyQualifiedPackageName, String level);

    void editLogger(String fullyQualifiedPackageName, String level);

    void deleteLogger(String fullyQualifiedPackageName);

    void reload()
            throws IOException;

}
