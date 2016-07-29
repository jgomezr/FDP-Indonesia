package org.grameenfoundation.fdp.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * A simple service that binds with the correct sync adapter.
 *
 * @author bhariharan
 */
public class ContactSyncService extends Service {

    private static final Object SYNC_ADAPTER_LOCK = new Object();
    private static ContactSyncAdapter CONTACT_SYNC_ADAPTER = null;

    @Override
    public void onCreate() {
        super.onCreate();
        synchronized (SYNC_ADAPTER_LOCK) {
            if (CONTACT_SYNC_ADAPTER == null) {
                CONTACT_SYNC_ADAPTER = new ContactSyncAdapter(getApplicationContext(),
                        true, false);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return CONTACT_SYNC_ADAPTER.getSyncAdapterBinder();
    }
}