/**
 * Copyright (c) 2000-2005 Liferay, LLC. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.sun.faces.config;

import com.sun.faces.RIConstants;
import com.sun.faces.application.ApplicationAssociate;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * <a href="LiferayConfigureListener.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Myunghun Kim
 * @version $Revision: 1.5 $
 *
 */
public class LiferayConfigureListener extends ConfigureListener {

	public static final String ASSOCIATE_KEY =
		RIConstants.FACES_PREFIX + "ApplicationAssociate";

	public static final String FACES_CLASS_LOADER = "FACES_CLASS_LOADER";

	public void contextInitialized(ServletContextEvent sce) {
		super.contextInitialized(sce);

		ServletContext sc = sce.getServletContext();

		ApplicationAssociate associate =
		    ApplicationAssociate.getInstance(new ServletContextAdapter(sc));

		if (associate != null) {
			sc.setAttribute(ASSOCIATE_KEY, associate);
		}
	}

}