package com.gigigo.orchextra.actions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.gigigo.orchextra.domain.entities.actions.strategy.BasicAction;

public class BrowserActionExecutor implements ActionExecution {

    private final Context context;

    public BrowserActionExecutor(Context context) {
        this.context = context;
    }

    @Override
    public void execute(BasicAction action) {
        String url = action.getUrl();
        Uri uriUrl = Uri.parse(url);

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, uriUrl);
        context.startActivity(browserIntent);
    }
}
