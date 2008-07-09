/*
 * Copyright 2004-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.webflow.samples.fileupload;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

public class FileUploadAction extends AbstractAction {

	protected Event doExecute(RequestContext context) throws Exception {
		MultipartFile file = context.getRequestParameters().getRequiredMultipartFile("file");
		if (file.getSize() > 0) {
			// data was uploaded
			context.getFlashScope().put("file", new String(file.getBytes()));
			return success();
		} else {
			return error();
		}
	}
}