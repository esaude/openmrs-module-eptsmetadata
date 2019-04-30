/**
 * The contents of this file are subject to the OpenMRS Public License Version 1.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy of the
 * License at http://license.openmrs.org
 *
 * <p>Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF
 * ANY KIND, either express or implied. See the License for the specific language governing rights
 * and limitations under the License.
 *
 * <p>Copyright (C) OpenMRS, LLC. All Rights Reserved.
 */
package org.openmrs.module.eptsmetadata.bundles;

import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.*;

import org.openmrs.GlobalProperty;
import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.springframework.stereotype.Component;

/*-
 * Common metadata bundle
 *
 * Contains:
 *  - Global Properties
 *  - Patient Identifiers
 *  - User Roles
 *  - Locations
 *  - Address Hierarchy
 *  - Programs
 *  - Visit Types
 */
@Component
public class CommonMetadata extends AbstractMetadataBundle {
	
	public static class _GlobalProperties {
		
		public static final GlobalProperty EXAMPLE = globalProperty("sespmetadata.exampleGlobalProperty",
		    "Example Global Property", "50");
	}
	
	/** @see org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle#install() */
	@Override
	public void install() {
		install(_GlobalProperties.EXAMPLE);
	}
}
