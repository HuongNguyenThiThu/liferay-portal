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

package com.liferay.multi.factor.authentication.fido2.credential.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the MFAFIDO2CredentialEntry service. Represents a row in the &quot;MFAFIDO2CredentialEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.multi.factor.authentication.fido2.credential.model.impl.MFAFIDO2CredentialEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.multi.factor.authentication.fido2.credential.model.impl.MFAFIDO2CredentialEntryImpl</code>.
 * </p>
 *
 * @author Arthur Chan
 * @see MFAFIDO2CredentialEntry
 * @generated
 */
@ProviderType
public interface MFAFIDO2CredentialEntryModel
	extends AuditedModel, BaseModel<MFAFIDO2CredentialEntry>, MVCCModel,
			ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a mfafido2 credential entry model instance should use the {@link MFAFIDO2CredentialEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this mfafido2 credential entry.
	 *
	 * @return the primary key of this mfafido2 credential entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this mfafido2 credential entry.
	 *
	 * @param primaryKey the primary key of this mfafido2 credential entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this mfafido2 credential entry.
	 *
	 * @return the mvcc version of this mfafido2 credential entry
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this mfafido2 credential entry.
	 *
	 * @param mvccVersion the mvcc version of this mfafido2 credential entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the mfa fido2 credential entry ID of this mfafido2 credential entry.
	 *
	 * @return the mfa fido2 credential entry ID of this mfafido2 credential entry
	 */
	public long getMfaFIDO2CredentialEntryId();

	/**
	 * Sets the mfa fido2 credential entry ID of this mfafido2 credential entry.
	 *
	 * @param mfaFIDO2CredentialEntryId the mfa fido2 credential entry ID of this mfafido2 credential entry
	 */
	public void setMfaFIDO2CredentialEntryId(long mfaFIDO2CredentialEntryId);

	/**
	 * Returns the company ID of this mfafido2 credential entry.
	 *
	 * @return the company ID of this mfafido2 credential entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this mfafido2 credential entry.
	 *
	 * @param companyId the company ID of this mfafido2 credential entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this mfafido2 credential entry.
	 *
	 * @return the user ID of this mfafido2 credential entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this mfafido2 credential entry.
	 *
	 * @param userId the user ID of this mfafido2 credential entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this mfafido2 credential entry.
	 *
	 * @return the user uuid of this mfafido2 credential entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this mfafido2 credential entry.
	 *
	 * @param userUuid the user uuid of this mfafido2 credential entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this mfafido2 credential entry.
	 *
	 * @return the user name of this mfafido2 credential entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this mfafido2 credential entry.
	 *
	 * @param userName the user name of this mfafido2 credential entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this mfafido2 credential entry.
	 *
	 * @return the create date of this mfafido2 credential entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this mfafido2 credential entry.
	 *
	 * @param createDate the create date of this mfafido2 credential entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this mfafido2 credential entry.
	 *
	 * @return the modified date of this mfafido2 credential entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this mfafido2 credential entry.
	 *
	 * @param modifiedDate the modified date of this mfafido2 credential entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the credential key of this mfafido2 credential entry.
	 *
	 * @return the credential key of this mfafido2 credential entry
	 */
	@AutoEscape
	public String getCredentialKey();

	/**
	 * Sets the credential key of this mfafido2 credential entry.
	 *
	 * @param credentialKey the credential key of this mfafido2 credential entry
	 */
	public void setCredentialKey(String credentialKey);

	/**
	 * Returns the credential type of this mfafido2 credential entry.
	 *
	 * @return the credential type of this mfafido2 credential entry
	 */
	public int getCredentialType();

	/**
	 * Sets the credential type of this mfafido2 credential entry.
	 *
	 * @param credentialType the credential type of this mfafido2 credential entry
	 */
	public void setCredentialType(int credentialType);

	/**
	 * Returns the failed attempts of this mfafido2 credential entry.
	 *
	 * @return the failed attempts of this mfafido2 credential entry
	 */
	public int getFailedAttempts();

	/**
	 * Sets the failed attempts of this mfafido2 credential entry.
	 *
	 * @param failedAttempts the failed attempts of this mfafido2 credential entry
	 */
	public void setFailedAttempts(int failedAttempts);

	/**
	 * Returns the public key code of this mfafido2 credential entry.
	 *
	 * @return the public key code of this mfafido2 credential entry
	 */
	@AutoEscape
	public String getPublicKeyCode();

	/**
	 * Sets the public key code of this mfafido2 credential entry.
	 *
	 * @param publicKeyCode the public key code of this mfafido2 credential entry
	 */
	public void setPublicKeyCode(String publicKeyCode);

	/**
	 * Returns the signature count of this mfafido2 credential entry.
	 *
	 * @return the signature count of this mfafido2 credential entry
	 */
	public long getSignatureCount();

	/**
	 * Sets the signature count of this mfafido2 credential entry.
	 *
	 * @param signatureCount the signature count of this mfafido2 credential entry
	 */
	public void setSignatureCount(long signatureCount);

}