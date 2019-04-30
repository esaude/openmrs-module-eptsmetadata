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
import org.openmrs.module.eptsmetadata.MetadataTypes.EncounterType;
import org.openmrs.module.eptsmetadata.MetadataTypes.Form;
import org.springframework.stereotype.Component;

/** Example metadata bundle */
@Deprecated
@Component
public class ExampleMetadata extends AbstractMetadataBundle {
	
	public static class _EncounterType {
		
		public static final EncounterType EXAMPLE = new EncounterType("d69dedbd-3933-4e44-8292-bea939ce980a",
		        "Example encounter", "Just an example");
	}
	
	public static class _Form {
		
		public static final Form EXAMPLE = new Form("b694b1bc-2086-47dd-a4ad-ba48f9471e4b", "Example Form",
		        "Just an Example form", "1.0");
	}
	
	public static class _GlobalProperties {
		
		public static final GlobalProperty EXAMPLE = globalProperty("sespmetadata.exampleGlobalProperty",
		    "Example Global Property", "50");
	}
	
	/** @see org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle#install() */
	@Override
	public void install() {
		install(encounterType(_EncounterType.EXAMPLE.getName(), _EncounterType.EXAMPLE.getDescription(),
		    _EncounterType.EXAMPLE.getUuid()));
		
		install(form(_Form.EXAMPLE.getName(), _Form.EXAMPLE.getDescription(), _EncounterType.EXAMPLE.getUuid(),
		    _Form.EXAMPLE.getVersion(), _Form.EXAMPLE.getUuid()));
		
		install(_GlobalProperties.EXAMPLE);
	}
}
