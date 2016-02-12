package com.gigigo.orchextra.dataprovision.config.model.strategy;

import com.gigigo.orchextra.domain.model.MethodSupported;
import com.gigigo.orchextra.domain.model.vo.Theme;

/**
 * Created by Sergio Martinez Rodriguez
 * Date 17/12/15.
 */
public interface SupportsTheme extends MethodSupported {
  Theme getTheme();
}