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

package com.liferay.portal.service.http;

import com.liferay.portal.auth.HttpPrincipal;
import com.liferay.portal.service.spring.ColorSchemeServiceUtil;
import com.liferay.portal.servlet.TunnelUtil;

import com.liferay.util.lang.MethodWrapper;
import com.liferay.util.lang.NullWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <a href="ColorSchemeServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Wing Shun Chan
 * @version $Revision: 1.183 $
 *
 */
public class ColorSchemeServiceHttp {
	public static com.liferay.portal.model.ColorScheme getColorScheme(
		HttpPrincipal httpPrincipal, java.lang.String themeId,
		java.lang.String colorSchemeId)
		throws com.liferay.portal.SystemException {
		try {
			Object paramObj0 = themeId;

			if (themeId == null) {
				paramObj0 = new NullWrapper("java.lang.String");
			}

			Object paramObj1 = colorSchemeId;

			if (colorSchemeId == null) {
				paramObj1 = new NullWrapper("java.lang.String");
			}

			MethodWrapper methodWrapper = new MethodWrapper(ColorSchemeServiceUtil.class.getName(),
					"getColorScheme", new Object[] { paramObj0, paramObj1 });
			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.SystemException) {
					throw (com.liferay.portal.SystemException)e;
				}

				throw e;
			}

			return (com.liferay.portal.model.ColorScheme)returnObj;
		}
		catch (com.liferay.portal.SystemException se) {
			throw se;
		}
		catch (Exception e) {
			_log.error(e.getMessage());
			throw new com.liferay.portal.SystemException();
		}
	}

	public static com.liferay.portal.model.ColorScheme updateColorScheme(
		HttpPrincipal httpPrincipal, java.lang.String colorSchemeId,
		java.lang.String settings)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException {
		try {
			Object paramObj0 = colorSchemeId;

			if (colorSchemeId == null) {
				paramObj0 = new NullWrapper("java.lang.String");
			}

			Object paramObj1 = settings;

			if (settings == null) {
				paramObj1 = new NullWrapper("java.lang.String");
			}

			MethodWrapper methodWrapper = new MethodWrapper(ColorSchemeServiceUtil.class.getName(),
					"updateColorScheme", new Object[] { paramObj0, paramObj1 });
			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.PortalException) {
					throw (com.liferay.portal.PortalException)e;
				}

				if (e instanceof com.liferay.portal.SystemException) {
					throw (com.liferay.portal.SystemException)e;
				}

				throw e;
			}

			return (com.liferay.portal.model.ColorScheme)returnObj;
		}
		catch (com.liferay.portal.PortalException pe) {
			throw pe;
		}
		catch (com.liferay.portal.SystemException se) {
			throw se;
		}
		catch (Exception e) {
			_log.error(e.getMessage());
			throw new com.liferay.portal.SystemException();
		}
	}

	private static final Log _log = LogFactory.getLog(ColorSchemeServiceHttp.class);
}