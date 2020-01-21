/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.layout.admin.web.internal.portlet.action;

import com.liferay.layout.admin.constants.LayoutAdminPortletKeys;
import com.liferay.layout.admin.web.internal.configuration.LayoutConverterConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.LayoutService;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.util.Map;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + LayoutAdminPortletKeys.GROUP_PAGES,
		"mvc.command.name=/layout/move_layout"
	},
	service = MVCActionCommand.class
)
public class MoveLayoutMVCActionCommand
	extends GetLayoutChildrenMVCActionCommand {

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_layoutConverterConfiguration = ConfigurableUtil.createConfigurable(
			LayoutConverterConfiguration.class, properties);
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long plid = ParamUtil.getLong(actionRequest, "plid");

		long parentPlid = ParamUtil.getLong(actionRequest, "parentPlid");
		int priority = ParamUtil.getInteger(actionRequest, "priority");

		Layout layout = layoutLocalService.fetchLayout(plid);

		if (layout.getParentPlid() == parentPlid) {
			_layoutService.updatePriority(plid, priority);
		}
		else {
			_layoutService.updatePriority(plid, Integer.MAX_VALUE);

			_layoutService.updateParentLayoutIdAndPriority(
				plid, parentPlid, priority);
		}

		long checkPlid = ParamUtil.getLong(actionRequest, "checkPlid");

		writeChildLayoutsAsJSON(
			actionRequest, actionResponse, _layoutConverterConfiguration,
			checkPlid);
	}

	private volatile LayoutConverterConfiguration _layoutConverterConfiguration;

	@Reference
	private LayoutService _layoutService;

}