<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
AnalyticsConfiguration analyticsConfiguration = (AnalyticsConfiguration)request.getAttribute(AnalyticsSettingsWebKeys.ANALYTICS_CONFIGURATION);
AnalyticsUsersManager analyticsUsersManager = (AnalyticsUsersManager)request.getAttribute(AnalyticsSettingsWebKeys.ANALYTICS_USERS_MANAGER);

boolean connected = false;

if (!Validator.isBlank(analyticsConfiguration.token())) {
	connected = true;
}

boolean syncAllContacts = analyticsConfiguration.syncAllContacts();
Set<String> syncedContactFieldNames = SetUtil.fromArray(analyticsConfiguration.syncedContactFieldNames());
Set<String> syncedUserFieldNames = SetUtil.fromArray(analyticsConfiguration.syncedUserFieldNames());

long totalContactsSelected = 0;

if (analyticsConfiguration.syncAllContacts()) {
	totalContactsSelected = analyticsUsersManager.getCompanyUsersCount(themeDisplay.getCompanyId());
}
else {
	String[] syncedOrganizationIds = analyticsConfiguration.syncedOrganizationIds();

	long[] syncedOrganizationIdsLong = new long[syncedOrganizationIds.length];

	for (int i = 0; i < syncedOrganizationIds.length; i++) {
		syncedOrganizationIdsLong[i] = GetterUtil.getLong(syncedOrganizationIds[i]);
	}

	String[] syncedUserGroupIds = analyticsConfiguration.syncedUserGroupIds();

	long[] syncedUserGroupIdsLong = new long[syncedUserGroupIds.length];

	for (int i = 0; i < syncedUserGroupIds.length; i++) {
		syncedUserGroupIdsLong[i] = GetterUtil.getLong(syncedUserGroupIds[i]);
	}

	totalContactsSelected = analyticsUsersManager.getOrganizationsAndUserGroupsUsersCount(syncedOrganizationIdsLong, syncedUserGroupIdsLong);
}
%>

<clay:sheet
	cssClass="portlet-analytics-settings"
>
	<h2>
		<liferay-ui:message key="contact-data" />
	</h2>

	<hr />

	<div class="c-pb-3 form-text">
		<liferay-ui:message key="select-contact-data-help" />
	</div>

	<fieldset <%= connected ? "" : "disabled" %>>
		<label class="control-label">
			<liferay-ui:message key="contact-sync-options" />
		</label>

		<c:choose>
			<c:when test="<%= connected %>">
				<portlet:renderURL var="editSyncedContactsURL">
					<portlet:param name="mvcRenderCommandName" value="/analytics_settings/edit_synced_contacts" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="includeSyncContactsFields" value="true" />
				</portlet:renderURL>

				<a class="d-flex m-4 p-2 text-decoration-none" href=<%= editSyncedContactsURL %>>
			</c:when>
			<c:otherwise>
				<span class="contacts-link-disabled d-flex m-4 p-2">
			</c:otherwise>
		</c:choose>

		<div class="pr-3">
			<clay:sticker
				cssClass="sticker-light"
				displayType="light"
				icon="user"
			/>
		</div>

		<div>
			<p class="list-group-title">
				<liferay-ui:message key="sync-contacts" />
			</p>

			<small class="list-group-subtext">
				<liferay-ui:message arguments='<%= syncAllContacts ? "all" : totalContactsSelected %>' key="x-contacts-selected" />
			</small>
		</div>

		<c:choose>
			<c:when test="<%= connected %>">
				</a>
			</c:when>
			<c:otherwise>
				</span>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="<%= connected %>">
				<portlet:renderURL var="editSyncedContactsFieldsURL">
					<portlet:param name="mvcRenderCommandName" value="/analytics_settings/edit_synced_contacts_fields" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
				</portlet:renderURL>

				<a class="d-flex m-4 p-2 text-decoration-none" href=<%= editSyncedContactsFieldsURL %>>
			</c:when>
			<c:otherwise>
				<span class="contacts-link-disabled d-flex m-4 p-2">
			</c:otherwise>
		</c:choose>

		<div class="pr-3">
			<clay:sticker
				cssClass="sticker-light"
				displayType="light"
				icon="check-square"
			/>
		</div>

		<div>
			<p class="list-group-title">
				<liferay-ui:message key="sync-data-fields" />
			</p>

			<small class="list-group-subtext">
				<liferay-ui:message arguments="<%= syncedContactFieldNames.size() + syncedUserFieldNames.size() %>" key="x-fields-selected" />
			</small>
		</div>

		<c:choose>
			<c:when test="<%= connected %>">
				</a>
			</c:when>
			<c:otherwise>
				</span>
			</c:otherwise>
		</c:choose>
	<fieldset>
</clay:sheet>