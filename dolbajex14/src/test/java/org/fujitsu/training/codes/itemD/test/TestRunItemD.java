package org.fujitsu.training.codes.itemD.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ TestItemD.class })
public class TestRunItemD {

	private static final Logger LOGGER = LogManager.getLogger(TestRunItemD.class);

	static {
		LOGGER.info("Running TestRunItemD suite");
	}
}
