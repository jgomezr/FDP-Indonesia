
package org.grameenfoundation.fdp;

import android.app.Application;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.app.SalesforceSDKManager.KeyInterface;
import com.salesforce.androidsdk.security.Encryptor;

/**
 * Application class for our application.
 */
public class fdpApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		SmartSyncSDKManager.initNative(getApplicationContext(), new NativeKeyImpl(), MainActivity.class);

		/*
		 * Un-comment the line below to enable push notifications in this app.
		 * Replace 'pnInterface' with your implementation of 'PushNotificationInterface'.
		 * Add your Google package ID in 'bootonfig.xml', as the value
		 * for the key 'androidPushNotificationClientId'.
		 */
		// SmartSyncSDKManager.getInstance().setPushNotificationReceiver(pnInterface);
	}
}

class NativeKeyImpl implements KeyInterface {

	@Override
	public String getKey(String name) {
		return Encryptor.hash(name + "12s9adpahk;n12-97sdainkasd=012", name + "12kl0dsakj4-cxh1qewkjasdol8");
	}
}
