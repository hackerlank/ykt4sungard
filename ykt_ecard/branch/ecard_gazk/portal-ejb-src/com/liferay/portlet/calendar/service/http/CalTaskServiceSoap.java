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

package com.liferay.portlet.calendar.service.http;

import com.liferay.portlet.calendar.service.spring.CalTaskServiceUtil;

import java.rmi.RemoteException;

/**
 * <a href="CalTaskServiceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Wing Shun Chan
 * @version $Revision: 1.183 $
 *
 */
public class CalTaskServiceSoap {
	public static com.liferay.portlet.calendar.model.CalTaskModel addTask(
		java.lang.String title, java.lang.String description,
		boolean noDueDate, int dueMonth, int dueDay, int dueYear, int priority,
		int status) throws RemoteException {
		try {
			com.liferay.portlet.calendar.model.CalTask returnValue = CalTaskServiceUtil.addTask(title,
					description, noDueDate, dueMonth, dueDay, dueYear,
					priority, status);

			return returnValue;
		}
		catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteTask(java.lang.String taskId)
		throws RemoteException {
		try {
			CalTaskServiceUtil.deleteTask(taskId);
		}
		catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.calendar.model.CalTaskModel getTask(
		java.lang.String taskId) throws RemoteException {
		try {
			com.liferay.portlet.calendar.model.CalTask returnValue = CalTaskServiceUtil.getTask(taskId);

			return returnValue;
		}
		catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.calendar.model.CalTaskModel[] getTasks()
		throws RemoteException {
		try {
			java.util.List returnValue = CalTaskServiceUtil.getTasks();

			return (com.liferay.portlet.calendar.model.CalTask[])returnValue.toArray(new com.liferay.portlet.calendar.model.CalTask[0]);
		}
		catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.calendar.model.CalTaskModel[] getTasks(
		int priority, int status) throws RemoteException {
		try {
			java.util.List returnValue = CalTaskServiceUtil.getTasks(priority,
					status);

			return (com.liferay.portlet.calendar.model.CalTask[])returnValue.toArray(new com.liferay.portlet.calendar.model.CalTask[0]);
		}
		catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.calendar.model.CalTaskModel updateTask(
		java.lang.String taskId, java.lang.String title,
		java.lang.String description, boolean noDueDate, int dueMonth,
		int dueDay, int dueYear, int priority, int status)
		throws RemoteException {
		try {
			com.liferay.portlet.calendar.model.CalTask returnValue = CalTaskServiceUtil.updateTask(taskId,
					title, description, noDueDate, dueMonth, dueDay, dueYear,
					priority, status);

			return returnValue;
		}
		catch (Exception e) {
			throw new RemoteException(e.getMessage());
		}
	}
}