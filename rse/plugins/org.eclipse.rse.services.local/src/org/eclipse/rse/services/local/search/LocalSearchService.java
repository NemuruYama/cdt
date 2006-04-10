/********************************************************************************
 * Copyright (c) 2006 IBM Corporation. All rights reserved.
 * This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is 
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Initial Contributors:
 * The following IBM employees contributed to the Remote System Explorer
 * component that contains this file: David McKnight, Kushal Munir, 
 * Michael Berger, David Dykstal, Phil Coulthard, Don Yantzi, Eric Simpson, 
 * Emily Bruner, Mazen Faraj, Adrian Storisteanu, Li Ding, and Kent Hawley.
 * 
 * Contributors:
 * {Name} (company) - description of contribution.
 ********************************************************************************/

package org.eclipse.rse.services.local.search;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.rse.services.files.IFileService;
import org.eclipse.rse.services.search.AbstractSearchService;
import org.eclipse.rse.services.search.IHostSearchResultConfiguration;
import org.eclipse.rse.services.search.ISearchHandler;




public class LocalSearchService extends AbstractSearchService
{
		
	public ISearchHandler internalSearch(IProgressMonitor monitor, IHostSearchResultConfiguration searchConfig, IFileService fileService)
	{
		LocalSearchHandler handler = new LocalSearchHandler(searchConfig, fileService);
		searchConfig.setSearchHandler(handler);
		handler.search(monitor);
		return handler;
	}

}