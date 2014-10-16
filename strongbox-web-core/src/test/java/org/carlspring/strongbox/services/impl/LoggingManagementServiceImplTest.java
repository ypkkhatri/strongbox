package org.carlspring.strongbox.services.impl;

import org.carlspring.strongbox.services.LoggingManagementService;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author mtodorov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/META-INF/spring/strongbox-*-context.xml", "classpath*:/META-INF/spring/strongbox-*-context.xml"})
public class LoggingManagementServiceImplTest
{

    private static final Logger logger = LoggerFactory.getLogger(LoggingManagementServiceImplTest.class);

    @Autowired
    private LoggingManagementService loggingManagementService;


    @Test
    public void testReload()
            throws IOException
    {
        loggingManagementService.reload();

        logger.debug("Testing logger after configuration reloading...");
    }

}
