package com.gigigo.orchextra.domain.dataprovider;

import com.gigigo.gggjavalib.business.model.BusinessObject;
import com.gigigo.orchextra.domain.entities.ClientAuthData;
import com.gigigo.orchextra.domain.entities.Credentials;
import com.gigigo.orchextra.domain.entities.Crm;
import com.gigigo.orchextra.domain.entities.SdkAuthData;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 9/12/15.
 */
public interface AuthenticationDataProvider {

  BusinessObject<SdkAuthData> authenticateSdk(Credentials credentials);

  BusinessObject<ClientAuthData> authenticateUser(Credentials credentials, String crmId);

  BusinessObject<Crm> retrieveCrm();
}
