/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.eptsmetadata;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.BaseModuleActivator;
import org.openmrs.module.metadatadeploy.api.MetadataDeployService;
import org.openmrs.module.metadatadeploy.bundle.MetadataBundle;

/**
 * This class contains the logic that is run every time this module is either started or shutdown
 */
public class EPTSMetadataActivator extends BaseModuleActivator {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * @see #started()
	 */
	public void started() {
		log.info("Started EPTS Metadata module");
		
		// Install metadata bundles excluding depricated bundles
		MetadataDeployService metadataDeployService = Context.getService(MetadataDeployService.class);
		for (MetadataBundle metadataBundle : Context.getRegisteredComponents(MetadataBundle.class)) {
			if (metadataBundle.getClass().getAnnotation(Deprecated.class) == null) {
				metadataDeployService.installBundle(metadataBundle);
			}
		}
		log.info("EPTS Metadata Installed");
	}
	
	/** @see #stopped() */
	public void stopped() {
		log.info("Stopped EptsMetadata Module");
	}
	
	@Override
	public void contextRefreshed() {
		log.debug("EptsMetadata Module refreshed");
	}
	
	@Override
	public void willRefreshContext() {
		log.debug("Refreshing EptsMetadata Module");
	}
	
	@Override
	public void willStart() {
		log.debug("Starting EptsMetadata Module");
	}
	
	@Override
	public void willStop() {
		log.debug("Stopping EptsMetadata Module");
		try {
			// remove metadata
			log.debug("EPTS Metadata purged");
		}
		catch (Exception e) {
			log.error("An error occured trying to purge EPTS Metadata", e);
		}
	}
	
}
