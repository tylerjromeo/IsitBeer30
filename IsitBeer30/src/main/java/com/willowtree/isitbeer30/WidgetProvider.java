package com.willowtree.isitbeer30;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import java.util.Calendar;

/**
 * User: tylerromeo Date: 9/13/13 Time: 3:04 PM
 */
public class WidgetProvider extends AppWidgetProvider {

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i = 0; i < N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(),
                    R.layout.main_activity_fullscreen);

            Calendar now = Calendar.getInstance();

            Calendar beginCal = Calendar.getInstance();
            beginCal.set(Calendar.HOUR_OF_DAY, 16);
            beginCal.set(Calendar.MINUTE, 30);

            Calendar endCal = Calendar.getInstance();
            endCal.set(Calendar.HOUR_OF_DAY, 18);
            endCal.set(Calendar.MINUTE, 0);

            if (now.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                if (now.after(beginCal) && now.before(endCal)) {
                    views.setTextViewText(R.id.fullscreen_content,
                            context.getResources().getString(R.string.yep));
                } else {
                    views.setTextViewText(R.id.fullscreen_content,
                            context.getResources().getString(R.string.no));
                }
            } else {
                views.setTextViewText(R.id.fullscreen_content,
                        context.getResources().getString(R.string.no));
            }

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);

        }
    }
}
