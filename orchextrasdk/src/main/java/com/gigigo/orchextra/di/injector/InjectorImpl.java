package com.gigigo.orchextra.di.injector;

import com.gigigo.orchextra.delegates.AuthenticationDelegate;
import com.gigigo.orchextra.di.components.DaggerDelegateComponent;
import com.gigigo.orchextra.di.components.DelegateComponent;
import com.gigigo.orchextra.delegates.FakeDelegate;
import com.gigigo.orchextra.di.components.OrchextraComponent;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 3/12/15.
 */
public class InjectorImpl implements Injector{

  private OrchextraComponent orchextraComponent;

  public InjectorImpl(OrchextraComponent orchextraComponent) {
    this.orchextraComponent = orchextraComponent;
  }

  @Override synchronized public DelegateComponent injectAuthDelegate(AuthenticationDelegate authenticationDelegate) {
    DelegateComponent delegateComponent = DaggerDelegateComponent.builder().
        orchextraComponent(orchextraComponent).build();
    delegateComponent.injectAuhtDelegate(authenticationDelegate);
    return delegateComponent;
  }

  @Override synchronized public DelegateComponent injectFakeDelegate(FakeDelegate fakeDelegate) {
    DelegateComponent delegateComponent = DaggerDelegateComponent.builder().
        orchextraComponent(orchextraComponent).build();
    delegateComponent.injectFakeDelegate(fakeDelegate);
    return delegateComponent;
  }

}