package Events;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Andrea Graziani on 02/12/2016.
 */

public class Event
{
    /**
     * This method open a specified activity.
     * @param arg0 Represents a "Context" object.
     * @param target_activity Represents the "Class" object corresponding to target activity.
     */
    public static void openNewActivity(Context arg0, Class target_activity)
    {
        Intent intent = new Intent();
        intent.setClass(arg0, target_activity);
        arg0.startActivity(intent);
    }
}
