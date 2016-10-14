package org.grameenfoundation.fdp.sync;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import org.grameenfoundation.fdp.loaders.ContactListLoader;

/**
 * A simple sync adapter to perform background sync of contacts.
 *
 * @author bhariharan
 */
public class ContactSyncAdapter extends AbstractThreadedSyncAdapter {

    /**
     * Parameterized constructor.
     *
     * @param context Context.
     * @param autoInitialize True - if it should be initialized automatically, False - otherwise.
     */
    public ContactSyncAdapter(Context context, boolean autoInitialize,
                              boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority,
                              ContentProviderClient provider, SyncResult syncResult) {
        if (account != null) {
            final UserAccount user = SalesforceSDKManager.getInstance().getUserAccountManager().buildUserAccount(account);
            final ContactListLoader contactLoader = new ContactListLoader(getContext(), user);
            contactLoader.syncUp();
        }
    }
}