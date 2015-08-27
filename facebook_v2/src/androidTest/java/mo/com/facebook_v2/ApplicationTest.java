package mo.com.facebook_v2;

import android.app.Application;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.test.ApplicationTestCase;
import android.util.Log;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    private static final String TAG = "ApplicationTest";

    public ApplicationTest() {
        super(Application.class);
    }

    public void testMedioList(){
        ContentResolver resolver = getContext().getContentResolver();
        Uri uri = Uri.parse("content://contacts/");

        Cursor query = resolver.query(uri, null, null, null, null);
        while (query.moveToNext()){
            String string = query.getString(query.getColumnIndex("_data"));
            Log.i(TAG,"------------->"+string);

        }


    }
}























