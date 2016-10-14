package org.grameenfoundation.fdp.loaders;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.smartstore.store.QuerySpec;
import com.salesforce.androidsdk.smartstore.store.SmartSqlHelper.SmartSqlException;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.smartsync.util.Constants;
import org.grameenfoundation.fdp.objects.ContactObject;

/**
 * A simple AsyncTaskLoader to load object detail for a Contact object.
 *
 * @author bhariharan
 */
public class ContactDetailLoader extends AsyncTaskLoader<ContactObject> {

    private static final String TAG = "SmartSyncExplorer: ContactDetailLoader";

    private String objectId;
    private SmartStore smartStore;

    /**
     * Parameterized constructor.
     *
     * @param context Context.
     * @param account User account.
     * @param objId Object ID.
     */
    public ContactDetailLoader(Context context, UserAccount account,
                               String objId) {
        super(context);
        objectId = objId;
        smartStore = SmartSyncSDKManager.getInstance().getSmartStore(account);
    }

    @Override
    public ContactObject loadInBackground() {
        if (TextUtils.isEmpty(objectId)) {
            return null;
        }
        ContactObject sObject = null;
        if (!smartStore.hasSoup(ContactListLoader.CONTACT_SOUP)) {
            return null;
        }
        final QuerySpec querySpec = QuerySpec.buildExactQuerySpec(
                ContactListLoader.CONTACT_SOUP, Constants.ID, objectId, null, null, 1);
        JSONArray results = null;
        try {
            results = smartStore.query(querySpec, 0);
            if (results != null) {
                sObject = new ContactObject(results.getJSONObject(0));
            }
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        } catch (SmartSqlException e) {
            Log.e(TAG, "SmartSqlException occurred while fetching data", e);
        }
        return sObject;
    }
}
