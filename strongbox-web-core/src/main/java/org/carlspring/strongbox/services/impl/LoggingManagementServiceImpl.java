package org.carlspring.strongbox.services.impl;

import org.carlspring.strongbox.resource.ConfigurationResourceResolver;
import org.carlspring.strongbox.services.LoggingManagementService;

import java.io.IOException;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @author mtodorov
 */
@Component
@Scope("singleton")
public class LoggingManagementServiceImpl
        implements LoggingManagementService
{

    private static final Logger logger = LoggerFactory.getLogger(LoggingManagementServiceImpl.class);


    @Autowired
    private ConfigurationResourceResolver configurationResourceResolver;


    @Override
    public void addLogger(String fullyQualifiedPackageName,
                          String level)
    {

    }

    @Override
    public void editLogger(String fullyQualifiedPackageName,
                           String level)
    {

    }

    @Override
    public void deleteLogger(String fullyQualifiedPackageName)
    {

    }

    @Override
    public void reload()
            throws IOException
    {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

        try
        {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(context);

            logger.debug("Forcing a reload of the logging configuration...");

            // Call context.reset() to clear any previous configuration, e.g. default
            // configuration. For multi-step configuration, omit calling context.reset().
            context.reset();

            Resource resource = configurationResourceResolver.getConfigurationResource(ConfigurationResourceResolver.getBasedir() + "/etc/logback.xml",
                                                                                       "logback.xml",
                                                                                       "etc/logback.xml");

            configurator.doConfigure(resource.getFile());

            logger.debug("Logging configuration reloaded.");
        }
        catch (JoranException je)
        {
            // StatusPrinter will handle this
        }

        if (logger.isDebugEnabled())
        {
            // This will otherwise spew a load of output on every reload.
            StatusPrinter.printInCaseOfErrorsOrWarnings(context);
        }
    }

}
