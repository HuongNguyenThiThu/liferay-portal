/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.portal.search.elasticsearch.cross.cluster.replication.internal.configuration;

/**
 * @author Bryan Engler
 */
public interface CrossClusterReplicationConfigurationWrapper {

	public String[] getCCRLocalClusterConnectionConfigurations();

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getCCRLocalClusterConnectionConfigurations()}
	 */
	@Deprecated
	public String getCCRLocalClusterConnectionId();

	public String getRemoteClusterAlias();

	public boolean isCCREnabled();

}