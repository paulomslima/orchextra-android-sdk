package com.gigigo.orchextra.di.modules;

import com.gigigo.ggglib.network.mappers.ApiGenericResponseMapper;
import com.gigigo.ggglib.network.mappers.RequestMapper;
import com.gigigo.ggglib.network.mappers.ResponseMapper;
import com.gigigo.orchextra.di.qualifiers.ActionNotificationResponse;
import com.gigigo.orchextra.di.qualifiers.ActionQueryRequest;
import com.gigigo.orchextra.di.qualifiers.ActionsResponse;
import com.gigigo.orchextra.di.qualifiers.AppRequest;
import com.gigigo.orchextra.di.qualifiers.BeaconResponse;
import com.gigigo.orchextra.di.qualifiers.ClientDataResponseMapper;
import com.gigigo.orchextra.di.qualifiers.ConfigRequest;
import com.gigigo.orchextra.di.qualifiers.ConfigResponseMapper;
import com.gigigo.orchextra.di.qualifiers.CrmRequest;
import com.gigigo.orchextra.di.qualifiers.DeviceRequest;
import com.gigigo.orchextra.di.qualifiers.GeoLocationRequest;
import com.gigigo.orchextra.di.qualifiers.GeofenceResponse;
import com.gigigo.orchextra.di.qualifiers.PointReqResMapper;
import com.gigigo.orchextra.di.qualifiers.PushNotificationRequest;
import com.gigigo.orchextra.di.qualifiers.SdkDataResponseMapper;
import com.gigigo.orchextra.di.qualifiers.ThemeResponse;
import com.gigigo.orchextra.di.qualifiers.VuforiaResponse;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gigigo.com.orchextra.data.datasources.api.model.mappers.PointMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.request.ActionQueryRequestMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.request.AppRequestMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.request.ConfigRequestMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.request.CrmRequestMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.request.DeviceRequestMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.request.GeoLocationRequestMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.request.PushNotificationRequestMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.response.ActionNotificationResponseMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.response.ActionsApiResponseMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.response.BeaconResponseMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.response.ClientApiResponseMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.response.ConfigApiResponseMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.response.GeofenceResponseMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.response.OrchextraGenericResponseMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.response.SdkApiResponseMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.response.ThemeResponseMapper;
import gigigo.com.orchextra.data.datasources.api.model.mappers.response.VuforiaResponseMapper;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 11/12/15.
 */
@Module
public class ApiMappersModule {

  //region Response Mappers

  @Provides @Singleton @SdkDataResponseMapper ApiGenericResponseMapper
  provideSdkDataResponseMapper(SdkApiResponseMapper sdkMapper){
    return createResponseMapper(sdkMapper);
  }

  @Provides @Singleton @ClientDataResponseMapper ApiGenericResponseMapper
  provideClientDataResponseMapper(ClientApiResponseMapper clientMapper){
    return createResponseMapper(clientMapper);
  }

  @Provides @Singleton @ConfigResponseMapper ApiGenericResponseMapper
  provideConfigResponseMapper(ConfigApiResponseMapper configApiResponseMapper) {
    return createResponseMapper(configApiResponseMapper);
  }

  @Provides @Singleton SdkApiResponseMapper provideSdkMapper(){
   return new SdkApiResponseMapper();
  }

  @Provides @Singleton ClientApiResponseMapper provideClientMapper(){
    return new ClientApiResponseMapper();
  }

  @Provides @Singleton   ApiGenericResponseMapper provideActionsResMapper(
      @ActionsResponse ActionsApiResponseMapper actionsApiResponseMapper){
    return createResponseMapper(actionsApiResponseMapper);
  }

  @Provides @Singleton @ActionsResponse ResponseMapper provideActionsApiResponseMapper(
      @ActionNotificationResponse ActionNotificationResponseMapper actionNotifResponseMapper){
    return new ActionsApiResponseMapper(actionNotifResponseMapper);
  }

  @Provides @Singleton @ActionNotificationResponse
  ResponseMapper provideActionNotificationResponseMapper(){
    return new ActionNotificationResponseMapper();
  }

  @Provides @Singleton ConfigApiResponseMapper provideConfigApiResponseMapper(
      @BeaconResponse BeaconResponseMapper beaconResponse,
      @GeofenceResponse GeofenceResponseMapper geofenceResponseMapper,
      @ThemeResponse ThemeResponseMapper themeResponseMapper,
      @VuforiaResponse VuforiaResponseMapper vuforiaResponseMapper){

    return new ConfigApiResponseMapper(vuforiaResponseMapper, themeResponseMapper,
        beaconResponse , geofenceResponseMapper);
  }

  @Provides @Singleton @VuforiaResponse VuforiaResponseMapper provideVuforiaResponseMapper(){
    return new VuforiaResponseMapper();
  }

  @Provides @Singleton @ThemeResponse ThemeResponseMapper provideThemeResponseMapper(){
    return new ThemeResponseMapper();
  }

  @Provides @Singleton @GeofenceResponse GeofenceResponseMapper provideGeofenceResponseMapper(
          @PointReqResMapper PointMapper pointMapper){
    return new GeofenceResponseMapper(pointMapper);
  }

  @Provides @Singleton @BeaconResponse BeaconResponseMapper provideBeaconResponseMapper(){
    return new BeaconResponseMapper();
  }

    @Provides
    @Singleton
    @ActionsResponse
    ApiGenericResponseMapper createResponseMapper(@ActionNotificationResponse ResponseMapper mapper) {
    return new OrchextraGenericResponseMapper(mapper);
  }

  //endregion

  @Provides @Singleton @PointReqResMapper PointMapper providePointMapper(){
    return new PointMapper();
  }

  //region Request Mappers

  @Provides @Singleton @ActionQueryRequest RequestMapper provideActionQueryRequestMapper(){
    return new ActionQueryRequestMapper();
  }

  @Provides @Singleton @AppRequest AppRequestMapper provideAppRequestMapper(){
    return new AppRequestMapper();
  }

  @Provides @Singleton @CrmRequest CrmRequestMapper provideCrmRequestMapper(){
    return new CrmRequestMapper();
  }

  @Provides @Singleton @PushNotificationRequest PushNotificationRequestMapper providePushNotifRequestMapper(){
    return new PushNotificationRequestMapper();
  }

  @Provides @Singleton @DeviceRequest DeviceRequestMapper provideDeviceRequestMapper(){
    return new DeviceRequestMapper();
  }

  @Provides @Singleton @GeoLocationRequest GeoLocationRequestMapper provideGeoLocationRequestMapper(
      @PointReqResMapper PointMapper pointMapper){
    return new GeoLocationRequestMapper(pointMapper);
  }

  @Provides @Singleton @ConfigRequest RequestMapper provideConfigRequestMapper(
      @PushNotificationRequest PushNotificationRequestMapper pushNotificationRequestMapper,
      @GeoLocationRequest GeoLocationRequestMapper geoLocationRequestMapper,
      @DeviceRequest DeviceRequestMapper deviceRequestMapper,
      @CrmRequest CrmRequestMapper crmRequestMapper,
      @AppRequest AppRequestMapper appRequestMapper){

    return new ConfigRequestMapper(pushNotificationRequestMapper, geoLocationRequestMapper,
        deviceRequestMapper, crmRequestMapper, appRequestMapper);
  }

  //endregion
}
