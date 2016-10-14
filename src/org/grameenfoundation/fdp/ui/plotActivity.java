package org.grameenfoundation.fdp.ui;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.util.Constants;
import com.salesforce.androidsdk.ui.SalesforceActivity;
import org.grameenfoundation.fdp.R;
import org.grameenfoundation.fdp.loaders.ContactDetailLoader;
import org.grameenfoundation.fdp.loaders.ContactListLoader;
import org.grameenfoundation.fdp.objects.ContactObject;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by julian_Gf on 7/4/2016.
 */
public class plotActivity extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {

    private static final int CONTACT_DETAIL_LOADER_ID = 2;
    private static final String TAG = "SmartSyncExplorer: plotActivity";
    private UserAccount curAccount;
    private String objectId;
    private String objectTitle;
    private String objNameKey;
    private ContactObject sObject;
    public static final String OBJECT_ID_KEY = "object_id";
    public static final String OBJECT_TITLE_KEY = "object_title";
    public static final String OBJECT_NAME_KEY = "object_name";
    private EditText gpsP1,ageP1,areP1,cteP1,estP1,steP1,gpsP2,ageP2,areP2,cteP2,estP2,steP2, gpsP3,ageP3,areP3,cteP3,estP3,steP3, gpsP4,ageP4,areP4,cteP4,estP4,steP4,gpsP5,ageP5,areP5,cteP5,estP5,steP5;
    private TextView Lp1,Lp2,Lp3,Lp4,Lp5;
    private Spinner plantP1,fcondP1,tdensP1,teageP1,tehelP1,debDiP1,pruniP1,pesDiP1,weediP1,harveP1,shadeP1,soilCP1,orgMaP1,fertFP1,fertAP1,limeNP1,drainP1,filliP1,hireNP1,plantP2,fcondP2,tdensP2,teageP2,tehelP2,debDiP2,pruniP2,pesDiP2,weediP2,harveP2,shadeP2,soilCP2,orgMaP2,fertFP2,fertAP2,limeNP2,drainP2,filliP2,hireNP2,plantP3,fcondP3,tdensP3,teageP3,tehelP3,debDiP3,pruniP3,pesDiP3,weediP3,harveP3,shadeP3,soilCP3,orgMaP3,fertFP3,fertAP3,limeNP3,drainP3,filliP3,hireNP3,plantP4,fcondP4,tdensP4,teageP4,tehelP4,debDiP4,pruniP4,pesDiP4,weediP4,harveP4,shadeP4,soilCP4,orgMaP4,fertFP4,fertAP4,limeNP4,drainP4,filliP4,hireNP4,plantP5,fcondP5,tdensP5,teageP5,tehelP5,debDiP5,pruniP5,pesDiP5,weediP5,harveP5,shadeP5,soilCP5,orgMaP5,fertFP5,fertAP5,limeNP5,drainP5,filliP5,hireNP5;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plot);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setIcon(R.drawable.ic_action_back);
        final Intent launchIntent = getIntent();
        if (launchIntent != null) {
            objectId = launchIntent.getStringExtra(DetailActivity.OBJECT_ID_KEY);
            objectTitle = launchIntent.getStringExtra(DetailActivity.OBJECT_TITLE_KEY);
            objNameKey = launchIntent.getStringExtra(DetailActivity.OBJECT_NAME_KEY);
        }
        Lp1= (TextView)findViewById(R.id.plot_1_label);
        Lp2= (TextView)findViewById(R.id.plot_2_label);
        Lp3= (TextView)findViewById(R.id.plot_3_label);
        Lp4= (TextView)findViewById(R.id.plot_4_label);
        Lp5= (TextView)findViewById(R.id.plot_5_label);
        gpsP1 = (EditText)findViewById(R.id.gpsp1_field);
        ageP1 = (EditText)findViewById(R.id.plotAgep1_field);
        areP1 = (EditText)findViewById(R.id.plotArea1_field);
        cteP1 = (EditText)findViewById(R.id.cocoaTreesP1_field);
        estP1 = (EditText)findViewById(R.id.estimatedP1_field);
        steP1 = (EditText) findViewById(R.id.shadeTreesP1_field);
        plantP1 = (Spinner)findViewById(R.id.plantingP1_field);
        fcondP1 = (Spinner)findViewById(R.id.farmConditionP1_field);
        tdensP1 = (Spinner)findViewById(R.id.treeDensityP1_field);
        teageP1 = (Spinner)findViewById(R.id.treeAgeP1_field);
        tehelP1 = (Spinner)findViewById(R.id.treeHealthP1_field);
        debDiP1 = (Spinner)findViewById(R.id.debilitationP1_field);
        pruniP1 = (Spinner)findViewById(R.id.pruningP1_field);
        pesDiP1 = (Spinner)findViewById(R.id.pestDiseaseP1_field);
        weediP1 = (Spinner)findViewById(R.id.weedingP1_field);
        harveP1 = (Spinner)findViewById(R.id.harvestingP1_field);
        shadeP1 = (Spinner)findViewById(R.id.shadeManagementP1_field);
        soilCP1 = (Spinner)findViewById(R.id.soilConditionP1_field);
        orgMaP1 = (Spinner)findViewById(R.id.organicMatterP1_field);
        fertFP1 = (Spinner)findViewById(R.id.fartFormP1_field);
        fertAP1 = (Spinner)findViewById(R.id.fartApplicationP1_field);
        limeNP1 = (Spinner)findViewById(R.id.limeP1_field);
        drainP1 = (Spinner)findViewById(R.id.drainageP1_field);
        filliP1 = (Spinner)findViewById(R.id.fillingP1_field);
        hireNP1 = (Spinner)findViewById(R.id.hireP1_field);
         gpsP2 = (EditText)findViewById(R.id.gpsp2_field);
         ageP2 = (EditText)findViewById(R.id.plotAgep2_field);
         areP2 = (EditText)findViewById(R.id.plotArea2_field);
         cteP2 = (EditText)findViewById(R.id.cocoaTreesP2_field);
         estP2 = (EditText)findViewById(R.id.estimatedP2_field);
         steP2 = (EditText) findViewById(R.id.shadeTreesP2_field);
         plantP2 = (Spinner)findViewById(R.id.plantingP2_field);
         fcondP2 = (Spinner)findViewById(R.id.farmConditionP2_field);
         tdensP2 = (Spinner)findViewById(R.id.treeDensityP2_field);
         teageP2 = (Spinner)findViewById(R.id.treeAgeP2_field);
         tehelP2 = (Spinner)findViewById(R.id.treeHealthP2_field);
         debDiP2 = (Spinner)findViewById(R.id.debilitationP2_field);
         pruniP2 = (Spinner)findViewById(R.id.pruningP2_field);
         pesDiP2 = (Spinner)findViewById(R.id.pestDiseaseP2_field);
         weediP2 = (Spinner)findViewById(R.id.weedingP2_field);
         harveP2 = (Spinner)findViewById(R.id.harvestingP2_field);
         shadeP2 = (Spinner)findViewById(R.id.shadeManagementP2_field);
         soilCP2 = (Spinner)findViewById(R.id.soilConditionP2_field);
         orgMaP2 = (Spinner)findViewById(R.id.organicMatterP2_field);
         fertFP2 = (Spinner)findViewById(R.id.fartFormP2_field);
         fertAP2 = (Spinner)findViewById(R.id.fartApplicationP2_field);
         limeNP2 = (Spinner)findViewById(R.id.limeP2_field);
         drainP2 = (Spinner)findViewById(R.id.drainageP2_field);
         filliP2 = (Spinner)findViewById(R.id.fillingP2_field);
         hireNP2 = (Spinner)findViewById(R.id.hireP2_field);
         gpsP3 = (EditText)findViewById(R.id.gpsp3_field);
         ageP3 = (EditText)findViewById(R.id.plotAgep3_field);
         areP3 = (EditText)findViewById(R.id.plotArea3_field);
         cteP3 = (EditText)findViewById(R.id.cocoaTreesP3_field);
         estP3 = (EditText)findViewById(R.id.estimatedP3_field);
         steP3 = (EditText) findViewById(R.id.shadeTreesP3_field);
         plantP3 = (Spinner)findViewById(R.id.plantingP3_field);
         fcondP3 = (Spinner)findViewById(R.id.farmConditionP3_field);
         tdensP3 = (Spinner)findViewById(R.id.treeDensityP3_field);
         teageP3 = (Spinner)findViewById(R.id.treeAgeP3_field);
         tehelP3 = (Spinner)findViewById(R.id.treeHealthP3_field);
         debDiP3 = (Spinner)findViewById(R.id.debilitationP3_field);
         pruniP3 = (Spinner)findViewById(R.id.pruningP3_field);
         pesDiP3 = (Spinner)findViewById(R.id.pestDiseaseP3_field);
         weediP3 = (Spinner)findViewById(R.id.weedingP3_field);
         harveP3 = (Spinner)findViewById(R.id.harvestingP3_field);
         shadeP3 = (Spinner)findViewById(R.id.shadeManagementP3_field);
         soilCP3 = (Spinner)findViewById(R.id.soilConditionP3_field);
         orgMaP3 = (Spinner)findViewById(R.id.organicMatterP3_field);
         fertFP3 = (Spinner)findViewById(R.id.fartFormP3_field);
         fertAP3 = (Spinner)findViewById(R.id.fartApplicationP3_field);
         limeNP3 = (Spinner)findViewById(R.id.limeP3_field);
         drainP3 = (Spinner)findViewById(R.id.drainageP3_field);
         filliP3 = (Spinner)findViewById(R.id.fillingP3_field);
         hireNP3 = (Spinner)findViewById(R.id.hireP3_field);
         gpsP4 = (EditText)findViewById(R.id.gpsp4_field);
         ageP4 = (EditText)findViewById(R.id.plotAgep4_field);
         areP4 = (EditText)findViewById(R.id.plotArea4_field);
         cteP4 = (EditText)findViewById(R.id.cocoaTreesP4_field);
         estP4 = (EditText)findViewById(R.id.estimatedP4_field);
         steP4 = (EditText) findViewById(R.id.shadeTreesP4_field);
         plantP4 = (Spinner)findViewById(R.id.plantingP4_field);
         fcondP4 = (Spinner)findViewById(R.id.farmConditionP4_field);
         tdensP4 = (Spinner)findViewById(R.id.treeDensityP4_field);
         teageP4 = (Spinner)findViewById(R.id.treeAgeP4_field);
         tehelP4 = (Spinner)findViewById(R.id.treeHealthP4_field);
         debDiP4 = (Spinner)findViewById(R.id.debilitationP4_field);
         pruniP4 = (Spinner)findViewById(R.id.pruningP4_field);
         pesDiP4 = (Spinner)findViewById(R.id.pestDiseaseP4_field);
         weediP4 = (Spinner)findViewById(R.id.weedingP4_field);
         harveP4 = (Spinner)findViewById(R.id.harvestingP4_field);
         shadeP4 = (Spinner)findViewById(R.id.shadeManagementP4_field);
         soilCP4 = (Spinner)findViewById(R.id.soilConditionP4_field);
         orgMaP4 = (Spinner)findViewById(R.id.organicMatterP4_field);
         fertFP4 = (Spinner)findViewById(R.id.fartFormP4_field);
         fertAP4 = (Spinner)findViewById(R.id.fartApplicationP4_field);
         limeNP4 = (Spinner)findViewById(R.id.limeP4_field);
         drainP4 = (Spinner)findViewById(R.id.drainageP4_field);
         filliP4 = (Spinner)findViewById(R.id.fillingP4_field);
         hireNP4 = (Spinner)findViewById(R.id.hireP4_field);
         gpsP5 = (EditText)findViewById(R.id.gpsp5_field);
         ageP5 = (EditText)findViewById(R.id.plotAgep5_field);
         areP5 = (EditText)findViewById(R.id.plotArea5_field);
         cteP5 = (EditText)findViewById(R.id.cocoaTreesP5_field);
         estP5 = (EditText)findViewById(R.id.estimatedP5_field);
         steP5 = (EditText) findViewById(R.id.shadeTreesP5_field);
         plantP5 = (Spinner)findViewById(R.id.plantingP5_field);
         fcondP5 = (Spinner)findViewById(R.id.farmConditionP5_field);
         tdensP5 = (Spinner)findViewById(R.id.treeDensityP5_field);
         teageP5 = (Spinner)findViewById(R.id.treeAgeP5_field);
         tehelP5 = (Spinner)findViewById(R.id.treeHealthP5_field);
         debDiP5 = (Spinner)findViewById(R.id.debilitationP5_field);
         pruniP5 = (Spinner)findViewById(R.id.pruningP5_field);
         pesDiP5 = (Spinner)findViewById(R.id.pestDiseaseP5_field);
         weediP5 = (Spinner)findViewById(R.id.weedingP5_field);
         harveP5 = (Spinner)findViewById(R.id.harvestingP5_field);
         shadeP5 = (Spinner)findViewById(R.id.shadeManagementP5_field);
         soilCP5 = (Spinner)findViewById(R.id.soilConditionP5_field);
         orgMaP5 = (Spinner)findViewById(R.id.organicMatterP5_field);
         fertFP5 = (Spinner)findViewById(R.id.fartFormP5_field);
         fertAP5 = (Spinner)findViewById(R.id.fartApplicationP5_field);
         limeNP5 = (Spinner)findViewById(R.id.limeP5_field);
         drainP5 = (Spinner)findViewById(R.id.drainageP5_field);
         filliP5 = (Spinner)findViewById(R.id.fillingP5_field);
         hireNP5 = (Spinner)findViewById(R.id.hireP5_field);
    }

    @Override
    public void onResume(RestClient client) {
        curAccount = SmartSyncSDKManager.getInstance().getUserAccountManager().getCurrentUser();
        getLoaderManager().initLoader(CONTACT_DETAIL_LOADER_ID, null, this).forceLoad();
    }

    public void launchFdp(View view) {
        save();
        final Intent fdpIntent = new Intent(this, fdpActivity.class);
        fdpIntent.addCategory(Intent.CATEGORY_DEFAULT);
        fdpIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        fdpIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        fdpIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        startActivity(fdpIntent);
    }

    @Override
    public Loader<ContactObject> onCreateLoader(int id, Bundle args) {
        return new ContactDetailLoader(this, curAccount, objectId);
    }

    @Override
    public void onLoadFinished(Loader<ContactObject> loader, ContactObject data) {
        sObject = data;
        refreshScreen();
    }

    @Override
    public void onLoaderReset(Loader<ContactObject> loader) {
        sObject = null;
        refreshScreen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
        final MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        searchItem.setVisible(false);
        final MenuItem logoutItem = menu.findItem(R.id.action_logout);
        logoutItem.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
                return true;
            case R.id.action_refresh:
                save();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void refreshScreen() {
        if (sObject != null) {
            if (sObject.getNumberOfPlots().equals("1")) {
                Lp1.setVisibility(View.VISIBLE);
                Lp2.setVisibility(View.GONE);
                Lp3.setVisibility(View.GONE);
                Lp4.setVisibility(View.GONE);
                Lp5.setVisibility(View.GONE);
                gpsP1.setVisibility(View.VISIBLE);
                ageP1.setVisibility(View.VISIBLE);
                areP1.setVisibility(View.VISIBLE);
                cteP1.setVisibility(View.VISIBLE);
                estP1.setVisibility(View.VISIBLE);
                steP1.setVisibility(View.VISIBLE);
                plantP1.setVisibility(View.VISIBLE);
                fcondP1.setVisibility(View.VISIBLE);
                tdensP1.setVisibility(View.VISIBLE);
                teageP1.setVisibility(View.VISIBLE);
                tehelP1.setVisibility(View.VISIBLE);
                debDiP1.setVisibility(View.VISIBLE);
                pruniP1.setVisibility(View.VISIBLE);
                pesDiP1.setVisibility(View.VISIBLE);
                weediP1.setVisibility(View.VISIBLE);
                harveP1.setVisibility(View.VISIBLE);
                shadeP1.setVisibility(View.VISIBLE);
                soilCP1.setVisibility(View.VISIBLE);
                orgMaP1.setVisibility(View.VISIBLE);
                fertFP1.setVisibility(View.VISIBLE);
                fertAP1.setVisibility(View.VISIBLE);
                limeNP1.setVisibility(View.VISIBLE);
                drainP1.setVisibility(View.VISIBLE);
                filliP1.setVisibility(View.VISIBLE);
                hireNP1.setVisibility(View.VISIBLE);
                gpsP2.setVisibility(View.GONE);
                ageP2.setVisibility(View.GONE);
                areP2.setVisibility(View.GONE);
                cteP2.setVisibility(View.GONE);
                estP2.setVisibility(View.GONE);
                steP2.setVisibility(View.GONE);
                plantP2.setVisibility(View.GONE);
                fcondP2.setVisibility(View.GONE);
                tdensP2.setVisibility(View.GONE);
                teageP2.setVisibility(View.GONE);
                tehelP2.setVisibility(View.GONE);
                debDiP2.setVisibility(View.GONE);
                pruniP2.setVisibility(View.GONE);
                pesDiP2.setVisibility(View.GONE);
                weediP2.setVisibility(View.GONE);
                harveP2.setVisibility(View.GONE);
                shadeP2.setVisibility(View.GONE);
                soilCP2.setVisibility(View.GONE);
                orgMaP2.setVisibility(View.GONE);
                fertFP2.setVisibility(View.GONE);
                fertAP2.setVisibility(View.GONE);
                limeNP2.setVisibility(View.GONE);
                drainP2.setVisibility(View.GONE);
                filliP2.setVisibility(View.GONE);
                hireNP2.setVisibility(View.GONE);
                gpsP3.setVisibility(View.GONE);
                ageP3.setVisibility(View.GONE);
                areP3.setVisibility(View.GONE);
                cteP3.setVisibility(View.GONE);
                estP3.setVisibility(View.GONE);
                steP3.setVisibility(View.GONE);
                plantP3.setVisibility(View.GONE);
                fcondP3.setVisibility(View.GONE);
                tdensP3.setVisibility(View.GONE);
                teageP3.setVisibility(View.GONE);
                tehelP3.setVisibility(View.GONE);
                debDiP3.setVisibility(View.GONE);
                pruniP3.setVisibility(View.GONE);
                pesDiP3.setVisibility(View.GONE);
                weediP3.setVisibility(View.GONE);
                harveP3.setVisibility(View.GONE);
                shadeP3.setVisibility(View.GONE);
                soilCP3.setVisibility(View.GONE);
                orgMaP3.setVisibility(View.GONE);
                fertFP3.setVisibility(View.GONE);
                fertAP3.setVisibility(View.GONE);
                limeNP3.setVisibility(View.GONE);
                drainP3.setVisibility(View.GONE);
                filliP3.setVisibility(View.GONE);
                hireNP3.setVisibility(View.GONE);
                gpsP4.setVisibility(View.GONE);
                ageP4.setVisibility(View.GONE);
                areP4.setVisibility(View.GONE);
                cteP4.setVisibility(View.GONE);
                estP4.setVisibility(View.GONE);
                steP4.setVisibility(View.GONE);
                plantP4.setVisibility(View.GONE);
                fcondP4.setVisibility(View.GONE);
                tdensP4.setVisibility(View.GONE);
                teageP4.setVisibility(View.GONE);
                tehelP4.setVisibility(View.GONE);
                debDiP4.setVisibility(View.GONE);
                pruniP4.setVisibility(View.GONE);
                pesDiP4.setVisibility(View.GONE);
                weediP4.setVisibility(View.GONE);
                harveP4.setVisibility(View.GONE);
                shadeP4.setVisibility(View.GONE);
                soilCP4.setVisibility(View.GONE);
                orgMaP4.setVisibility(View.GONE);
                fertFP4.setVisibility(View.GONE);
                fertAP4.setVisibility(View.GONE);
                limeNP4.setVisibility(View.GONE);
                drainP4.setVisibility(View.GONE);
                filliP4.setVisibility(View.GONE);
                hireNP4.setVisibility(View.GONE);
                gpsP5.setVisibility(View.GONE);
                ageP5.setVisibility(View.GONE);
                areP5.setVisibility(View.GONE);
                cteP5.setVisibility(View.GONE);
                estP5.setVisibility(View.GONE);
                steP5.setVisibility(View.GONE);
                plantP5.setVisibility(View.GONE);
                fcondP5.setVisibility(View.GONE);
                tdensP5.setVisibility(View.GONE);
                teageP5.setVisibility(View.GONE);
                tehelP5.setVisibility(View.GONE);
                debDiP5.setVisibility(View.GONE);
                pruniP5.setVisibility(View.GONE);
                pesDiP5.setVisibility(View.GONE);
                weediP5.setVisibility(View.GONE);
                harveP5.setVisibility(View.GONE);
                shadeP5.setVisibility(View.GONE);
                soilCP5.setVisibility(View.GONE);
                orgMaP5.setVisibility(View.GONE);
                fertFP5.setVisibility(View.GONE);
                fertAP5.setVisibility(View.GONE);
                limeNP5.setVisibility(View.GONE);
                drainP5.setVisibility(View.GONE);
                filliP5.setVisibility(View.GONE);
                hireNP5.setVisibility(View.GONE);
            } else if (sObject.getNumberOfPlots().equals("2")) {
                Lp1.setVisibility(View.VISIBLE);
                Lp2.setVisibility(View.VISIBLE);
                Lp3.setVisibility(View.GONE);
                Lp4.setVisibility(View.GONE);
                Lp5.setVisibility(View.GONE);
                gpsP1.setVisibility(View.VISIBLE);
                ageP1.setVisibility(View.VISIBLE);
                areP1.setVisibility(View.VISIBLE);
                cteP1.setVisibility(View.VISIBLE);
                estP1.setVisibility(View.VISIBLE);
                steP1.setVisibility(View.VISIBLE);
                plantP1.setVisibility(View.VISIBLE);
                fcondP1.setVisibility(View.VISIBLE);
                tdensP1.setVisibility(View.VISIBLE);
                teageP1.setVisibility(View.VISIBLE);
                tehelP1.setVisibility(View.VISIBLE);
                debDiP1.setVisibility(View.VISIBLE);
                pruniP1.setVisibility(View.VISIBLE);
                pesDiP1.setVisibility(View.VISIBLE);
                weediP1.setVisibility(View.VISIBLE);
                harveP1.setVisibility(View.VISIBLE);
                shadeP1.setVisibility(View.VISIBLE);
                soilCP1.setVisibility(View.VISIBLE);
                orgMaP1.setVisibility(View.VISIBLE);
                fertFP1.setVisibility(View.VISIBLE);
                fertAP1.setVisibility(View.VISIBLE);
                limeNP1.setVisibility(View.VISIBLE);
                drainP1.setVisibility(View.VISIBLE);
                filliP1.setVisibility(View.VISIBLE);
                hireNP1.setVisibility(View.VISIBLE);
                gpsP2.setVisibility(View.VISIBLE);
                ageP2.setVisibility(View.VISIBLE);
                areP2.setVisibility(View.VISIBLE);
                cteP2.setVisibility(View.VISIBLE);
                estP2.setVisibility(View.VISIBLE);
                steP2.setVisibility(View.VISIBLE);
                plantP2.setVisibility(View.VISIBLE);
                fcondP2.setVisibility(View.VISIBLE);
                tdensP2.setVisibility(View.VISIBLE);
                teageP2.setVisibility(View.VISIBLE);
                tehelP2.setVisibility(View.VISIBLE);
                debDiP2.setVisibility(View.VISIBLE);
                pruniP2.setVisibility(View.VISIBLE);
                pesDiP2.setVisibility(View.VISIBLE);
                weediP2.setVisibility(View.VISIBLE);
                harveP2.setVisibility(View.VISIBLE);
                shadeP2.setVisibility(View.VISIBLE);
                soilCP2.setVisibility(View.VISIBLE);
                orgMaP2.setVisibility(View.VISIBLE);
                fertFP2.setVisibility(View.VISIBLE);
                fertAP2.setVisibility(View.VISIBLE);
                limeNP2.setVisibility(View.VISIBLE);
                drainP2.setVisibility(View.VISIBLE);
                filliP2.setVisibility(View.VISIBLE);
                hireNP2.setVisibility(View.VISIBLE);
                gpsP3.setVisibility(View.GONE);
                ageP3.setVisibility(View.GONE);
                areP3.setVisibility(View.GONE);
                cteP3.setVisibility(View.GONE);
                estP3.setVisibility(View.GONE);
                steP3.setVisibility(View.GONE);
                plantP3.setVisibility(View.GONE);
                fcondP3.setVisibility(View.GONE);
                tdensP3.setVisibility(View.GONE);
                teageP3.setVisibility(View.GONE);
                tehelP3.setVisibility(View.GONE);
                debDiP3.setVisibility(View.GONE);
                pruniP3.setVisibility(View.GONE);
                pesDiP3.setVisibility(View.GONE);
                weediP3.setVisibility(View.GONE);
                harveP3.setVisibility(View.GONE);
                shadeP3.setVisibility(View.GONE);
                soilCP3.setVisibility(View.GONE);
                orgMaP3.setVisibility(View.GONE);
                fertFP3.setVisibility(View.GONE);
                fertAP3.setVisibility(View.GONE);
                limeNP3.setVisibility(View.GONE);
                drainP3.setVisibility(View.GONE);
                filliP3.setVisibility(View.GONE);
                hireNP3.setVisibility(View.GONE);
                gpsP4.setVisibility(View.GONE);
                ageP4.setVisibility(View.GONE);
                areP4.setVisibility(View.GONE);
                cteP4.setVisibility(View.GONE);
                estP4.setVisibility(View.GONE);
                steP4.setVisibility(View.GONE);
                plantP4.setVisibility(View.GONE);
                fcondP4.setVisibility(View.GONE);
                tdensP4.setVisibility(View.GONE);
                teageP4.setVisibility(View.GONE);
                tehelP4.setVisibility(View.GONE);
                debDiP4.setVisibility(View.GONE);
                pruniP4.setVisibility(View.GONE);
                pesDiP4.setVisibility(View.GONE);
                weediP4.setVisibility(View.GONE);
                harveP4.setVisibility(View.GONE);
                shadeP4.setVisibility(View.GONE);
                soilCP4.setVisibility(View.GONE);
                orgMaP4.setVisibility(View.GONE);
                fertFP4.setVisibility(View.GONE);
                fertAP4.setVisibility(View.GONE);
                limeNP4.setVisibility(View.GONE);
                drainP4.setVisibility(View.GONE);
                filliP4.setVisibility(View.GONE);
                hireNP4.setVisibility(View.GONE);
                gpsP5.setVisibility(View.GONE);
                ageP5.setVisibility(View.GONE);
                areP5.setVisibility(View.GONE);
                cteP5.setVisibility(View.GONE);
                estP5.setVisibility(View.GONE);
                steP5.setVisibility(View.GONE);
                plantP5.setVisibility(View.GONE);
                fcondP5.setVisibility(View.GONE);
                tdensP5.setVisibility(View.GONE);
                teageP5.setVisibility(View.GONE);
                tehelP5.setVisibility(View.GONE);
                debDiP5.setVisibility(View.GONE);
                pruniP5.setVisibility(View.GONE);
                pesDiP5.setVisibility(View.GONE);
                weediP5.setVisibility(View.GONE);
                harveP5.setVisibility(View.GONE);
                shadeP5.setVisibility(View.GONE);
                soilCP5.setVisibility(View.GONE);
                orgMaP5.setVisibility(View.GONE);
                fertFP5.setVisibility(View.GONE);
                fertAP5.setVisibility(View.GONE);
                limeNP5.setVisibility(View.GONE);
                drainP5.setVisibility(View.GONE);
                filliP5.setVisibility(View.GONE);
                hireNP5.setVisibility(View.GONE);

            } else if (sObject.getNumberOfPlots().equals("3")) {
                Lp1.setVisibility(View.VISIBLE);
                Lp2.setVisibility(View.VISIBLE);
                Lp3.setVisibility(View.VISIBLE);
                Lp4.setVisibility(View.GONE);
                Lp5.setVisibility(View.GONE);
                gpsP1.setVisibility(View.VISIBLE);
                ageP1.setVisibility(View.VISIBLE);
                areP1.setVisibility(View.VISIBLE);
                cteP1.setVisibility(View.VISIBLE);
                estP1.setVisibility(View.VISIBLE);
                steP1.setVisibility(View.VISIBLE);
                plantP1.setVisibility(View.VISIBLE);
                fcondP1.setVisibility(View.VISIBLE);
                tdensP1.setVisibility(View.VISIBLE);
                teageP1.setVisibility(View.VISIBLE);
                tehelP1.setVisibility(View.VISIBLE);
                debDiP1.setVisibility(View.VISIBLE);
                pruniP1.setVisibility(View.VISIBLE);
                pesDiP1.setVisibility(View.VISIBLE);
                weediP1.setVisibility(View.VISIBLE);
                harveP1.setVisibility(View.VISIBLE);
                shadeP1.setVisibility(View.VISIBLE);
                soilCP1.setVisibility(View.VISIBLE);
                orgMaP1.setVisibility(View.VISIBLE);
                fertFP1.setVisibility(View.VISIBLE);
                fertAP1.setVisibility(View.VISIBLE);
                limeNP1.setVisibility(View.VISIBLE);
                drainP1.setVisibility(View.VISIBLE);
                filliP1.setVisibility(View.VISIBLE);
                hireNP1.setVisibility(View.VISIBLE);
                gpsP2.setVisibility(View.VISIBLE);
                ageP2.setVisibility(View.VISIBLE);
                areP2.setVisibility(View.VISIBLE);
                cteP2.setVisibility(View.VISIBLE);
                estP2.setVisibility(View.VISIBLE);
                steP2.setVisibility(View.VISIBLE);
                plantP2.setVisibility(View.VISIBLE);
                fcondP2.setVisibility(View.VISIBLE);
                tdensP2.setVisibility(View.VISIBLE);
                teageP2.setVisibility(View.VISIBLE);
                tehelP2.setVisibility(View.VISIBLE);
                debDiP2.setVisibility(View.VISIBLE);
                pruniP2.setVisibility(View.VISIBLE);
                pesDiP2.setVisibility(View.VISIBLE);
                weediP2.setVisibility(View.VISIBLE);
                harveP2.setVisibility(View.VISIBLE);
                shadeP2.setVisibility(View.VISIBLE);
                soilCP2.setVisibility(View.VISIBLE);
                orgMaP2.setVisibility(View.VISIBLE);
                fertFP2.setVisibility(View.VISIBLE);
                fertAP2.setVisibility(View.VISIBLE);
                limeNP2.setVisibility(View.VISIBLE);
                drainP2.setVisibility(View.VISIBLE);
                filliP2.setVisibility(View.VISIBLE);
                hireNP2.setVisibility(View.VISIBLE);
                gpsP3.setVisibility(View.VISIBLE);
                ageP3.setVisibility(View.VISIBLE);
                areP3.setVisibility(View.VISIBLE);
                cteP3.setVisibility(View.VISIBLE);
                estP3.setVisibility(View.VISIBLE);
                steP3.setVisibility(View.VISIBLE);
                plantP3.setVisibility(View.VISIBLE);
                fcondP3.setVisibility(View.VISIBLE);
                tdensP3.setVisibility(View.VISIBLE);
                teageP3.setVisibility(View.VISIBLE);
                tehelP3.setVisibility(View.VISIBLE);
                debDiP3.setVisibility(View.VISIBLE);
                pruniP3.setVisibility(View.VISIBLE);
                pesDiP3.setVisibility(View.VISIBLE);
                weediP3.setVisibility(View.VISIBLE);
                harveP3.setVisibility(View.VISIBLE);
                shadeP3.setVisibility(View.VISIBLE);
                soilCP3.setVisibility(View.VISIBLE);
                orgMaP3.setVisibility(View.VISIBLE);
                fertFP3.setVisibility(View.VISIBLE);
                fertAP3.setVisibility(View.VISIBLE);
                limeNP3.setVisibility(View.VISIBLE);
                drainP3.setVisibility(View.VISIBLE);
                filliP3.setVisibility(View.VISIBLE);
                hireNP3.setVisibility(View.VISIBLE);
                gpsP4.setVisibility(View.GONE);
                ageP4.setVisibility(View.GONE);
                areP4.setVisibility(View.GONE);
                cteP4.setVisibility(View.GONE);
                estP4.setVisibility(View.GONE);
                steP4.setVisibility(View.GONE);
                plantP4.setVisibility(View.GONE);
                fcondP4.setVisibility(View.GONE);
                tdensP4.setVisibility(View.GONE);
                teageP4.setVisibility(View.GONE);
                tehelP4.setVisibility(View.GONE);
                debDiP4.setVisibility(View.GONE);
                pruniP4.setVisibility(View.GONE);
                pesDiP4.setVisibility(View.GONE);
                weediP4.setVisibility(View.GONE);
                harveP4.setVisibility(View.GONE);
                shadeP4.setVisibility(View.GONE);
                soilCP4.setVisibility(View.GONE);
                orgMaP4.setVisibility(View.GONE);
                fertFP4.setVisibility(View.GONE);
                fertAP4.setVisibility(View.GONE);
                limeNP4.setVisibility(View.GONE);
                drainP4.setVisibility(View.GONE);
                filliP4.setVisibility(View.GONE);
                hireNP4.setVisibility(View.GONE);
                gpsP5.setVisibility(View.GONE);
                ageP5.setVisibility(View.GONE);
                areP5.setVisibility(View.GONE);
                cteP5.setVisibility(View.GONE);
                estP5.setVisibility(View.GONE);
                steP5.setVisibility(View.GONE);
                plantP5.setVisibility(View.GONE);
                fcondP5.setVisibility(View.GONE);
                tdensP5.setVisibility(View.GONE);
                teageP5.setVisibility(View.GONE);
                tehelP5.setVisibility(View.GONE);
                debDiP5.setVisibility(View.GONE);
                pruniP5.setVisibility(View.GONE);
                pesDiP5.setVisibility(View.GONE);
                weediP5.setVisibility(View.GONE);
                harveP5.setVisibility(View.GONE);
                shadeP5.setVisibility(View.GONE);
                soilCP5.setVisibility(View.GONE);
                orgMaP5.setVisibility(View.GONE);
                fertFP5.setVisibility(View.GONE);
                fertAP5.setVisibility(View.GONE);
                limeNP5.setVisibility(View.GONE);
                drainP5.setVisibility(View.GONE);
                filliP5.setVisibility(View.GONE);
                hireNP5.setVisibility(View.GONE);
            } else if (sObject.getNumberOfPlots().equals("4")) {
                Lp1.setVisibility(View.VISIBLE);
                Lp2.setVisibility(View.VISIBLE);
                Lp3.setVisibility(View.VISIBLE);
                Lp4.setVisibility(View.VISIBLE);
                Lp5.setVisibility(View.GONE);
                gpsP1.setVisibility(View.VISIBLE);
                ageP1.setVisibility(View.VISIBLE);
                areP1.setVisibility(View.VISIBLE);
                cteP1.setVisibility(View.VISIBLE);
                estP1.setVisibility(View.VISIBLE);
                steP1.setVisibility(View.VISIBLE);
                plantP1.setVisibility(View.VISIBLE);
                fcondP1.setVisibility(View.VISIBLE);
                tdensP1.setVisibility(View.VISIBLE);
                teageP1.setVisibility(View.VISIBLE);
                tehelP1.setVisibility(View.VISIBLE);
                debDiP1.setVisibility(View.VISIBLE);
                pruniP1.setVisibility(View.VISIBLE);
                pesDiP1.setVisibility(View.VISIBLE);
                weediP1.setVisibility(View.VISIBLE);
                harveP1.setVisibility(View.VISIBLE);
                shadeP1.setVisibility(View.VISIBLE);
                soilCP1.setVisibility(View.VISIBLE);
                orgMaP1.setVisibility(View.VISIBLE);
                fertFP1.setVisibility(View.VISIBLE);
                fertAP1.setVisibility(View.VISIBLE);
                limeNP1.setVisibility(View.VISIBLE);
                drainP1.setVisibility(View.VISIBLE);
                filliP1.setVisibility(View.VISIBLE);
                hireNP1.setVisibility(View.VISIBLE);
                gpsP2.setVisibility(View.VISIBLE);
                ageP2.setVisibility(View.VISIBLE);
                areP2.setVisibility(View.VISIBLE);
                cteP2.setVisibility(View.VISIBLE);
                estP2.setVisibility(View.VISIBLE);
                steP2.setVisibility(View.VISIBLE);
                plantP2.setVisibility(View.VISIBLE);
                fcondP2.setVisibility(View.VISIBLE);
                tdensP2.setVisibility(View.VISIBLE);
                teageP2.setVisibility(View.VISIBLE);
                tehelP2.setVisibility(View.VISIBLE);
                debDiP2.setVisibility(View.VISIBLE);
                pruniP2.setVisibility(View.VISIBLE);
                pesDiP2.setVisibility(View.VISIBLE);
                weediP2.setVisibility(View.VISIBLE);
                harveP2.setVisibility(View.VISIBLE);
                shadeP2.setVisibility(View.VISIBLE);
                soilCP2.setVisibility(View.VISIBLE);
                orgMaP2.setVisibility(View.VISIBLE);
                fertFP2.setVisibility(View.VISIBLE);
                fertAP2.setVisibility(View.VISIBLE);
                limeNP2.setVisibility(View.VISIBLE);
                drainP2.setVisibility(View.VISIBLE);
                filliP2.setVisibility(View.VISIBLE);
                hireNP2.setVisibility(View.VISIBLE);
                gpsP3.setVisibility(View.VISIBLE);
                ageP3.setVisibility(View.VISIBLE);
                areP3.setVisibility(View.VISIBLE);
                cteP3.setVisibility(View.VISIBLE);
                estP3.setVisibility(View.VISIBLE);
                steP3.setVisibility(View.VISIBLE);
                plantP3.setVisibility(View.VISIBLE);
                fcondP3.setVisibility(View.VISIBLE);
                tdensP3.setVisibility(View.VISIBLE);
                teageP3.setVisibility(View.VISIBLE);
                tehelP3.setVisibility(View.VISIBLE);
                debDiP3.setVisibility(View.VISIBLE);
                pruniP3.setVisibility(View.VISIBLE);
                pesDiP3.setVisibility(View.VISIBLE);
                weediP3.setVisibility(View.VISIBLE);
                harveP3.setVisibility(View.VISIBLE);
                shadeP3.setVisibility(View.VISIBLE);
                soilCP3.setVisibility(View.VISIBLE);
                orgMaP3.setVisibility(View.VISIBLE);
                fertFP3.setVisibility(View.VISIBLE);
                fertAP3.setVisibility(View.VISIBLE);
                limeNP3.setVisibility(View.VISIBLE);
                drainP3.setVisibility(View.VISIBLE);
                filliP3.setVisibility(View.VISIBLE);
                hireNP3.setVisibility(View.VISIBLE);
                gpsP4.setVisibility(View.VISIBLE);
                ageP4.setVisibility(View.VISIBLE);
                areP4.setVisibility(View.VISIBLE);
                cteP4.setVisibility(View.VISIBLE);
                estP4.setVisibility(View.VISIBLE);
                steP4.setVisibility(View.VISIBLE);
                plantP4.setVisibility(View.VISIBLE);
                fcondP4.setVisibility(View.VISIBLE);
                tdensP4.setVisibility(View.VISIBLE);
                teageP4.setVisibility(View.VISIBLE);
                tehelP4.setVisibility(View.VISIBLE);
                debDiP4.setVisibility(View.VISIBLE);
                pruniP4.setVisibility(View.VISIBLE);
                pesDiP4.setVisibility(View.VISIBLE);
                weediP4.setVisibility(View.VISIBLE);
                harveP4.setVisibility(View.VISIBLE);
                shadeP4.setVisibility(View.VISIBLE);
                soilCP4.setVisibility(View.VISIBLE);
                orgMaP4.setVisibility(View.VISIBLE);
                fertFP4.setVisibility(View.VISIBLE);
                fertAP4.setVisibility(View.VISIBLE);
                limeNP4.setVisibility(View.VISIBLE);
                drainP4.setVisibility(View.VISIBLE);
                filliP4.setVisibility(View.VISIBLE);
                hireNP4.setVisibility(View.VISIBLE);
                gpsP5.setVisibility(View.GONE);
                ageP5.setVisibility(View.GONE);
                areP5.setVisibility(View.GONE);
                cteP5.setVisibility(View.GONE);
                estP5.setVisibility(View.GONE);
                steP5.setVisibility(View.GONE);
                plantP5.setVisibility(View.GONE);
                fcondP5.setVisibility(View.GONE);
                tdensP5.setVisibility(View.GONE);
                teageP5.setVisibility(View.GONE);
                tehelP5.setVisibility(View.GONE);
                debDiP5.setVisibility(View.GONE);
                pruniP5.setVisibility(View.GONE);
                pesDiP5.setVisibility(View.GONE);
                weediP5.setVisibility(View.GONE);
                harveP5.setVisibility(View.GONE);
                shadeP5.setVisibility(View.GONE);
                soilCP5.setVisibility(View.GONE);
                orgMaP5.setVisibility(View.GONE);
                fertFP5.setVisibility(View.GONE);
                fertAP5.setVisibility(View.GONE);
                limeNP5.setVisibility(View.GONE);
                drainP5.setVisibility(View.GONE);
                filliP5.setVisibility(View.GONE);
                hireNP5.setVisibility(View.GONE);
            } else if (sObject.getNumberOfPlots().equals("5")) {
                Lp1.setVisibility(View.VISIBLE);
                Lp2.setVisibility(View.VISIBLE);
                Lp3.setVisibility(View.VISIBLE);
                Lp4.setVisibility(View.VISIBLE);
                Lp5.setVisibility(View.VISIBLE);
                gpsP1.setVisibility(View.VISIBLE);
                ageP1.setVisibility(View.VISIBLE);
                areP1.setVisibility(View.VISIBLE);
                cteP1.setVisibility(View.VISIBLE);
                estP1.setVisibility(View.VISIBLE);
                steP1.setVisibility(View.VISIBLE);
                plantP1.setVisibility(View.VISIBLE);
                fcondP1.setVisibility(View.VISIBLE);
                tdensP1.setVisibility(View.VISIBLE);
                teageP1.setVisibility(View.VISIBLE);
                tehelP1.setVisibility(View.VISIBLE);
                debDiP1.setVisibility(View.VISIBLE);
                pruniP1.setVisibility(View.VISIBLE);
                pesDiP1.setVisibility(View.VISIBLE);
                weediP1.setVisibility(View.VISIBLE);
                harveP1.setVisibility(View.VISIBLE);
                shadeP1.setVisibility(View.VISIBLE);
                soilCP1.setVisibility(View.VISIBLE);
                orgMaP1.setVisibility(View.VISIBLE);
                fertFP1.setVisibility(View.VISIBLE);
                fertAP1.setVisibility(View.VISIBLE);
                limeNP1.setVisibility(View.VISIBLE);
                drainP1.setVisibility(View.VISIBLE);
                filliP1.setVisibility(View.VISIBLE);
                hireNP1.setVisibility(View.VISIBLE);
                gpsP2.setVisibility(View.VISIBLE);
                ageP2.setVisibility(View.VISIBLE);
                areP2.setVisibility(View.VISIBLE);
                cteP2.setVisibility(View.VISIBLE);
                estP2.setVisibility(View.VISIBLE);
                steP2.setVisibility(View.VISIBLE);
                plantP2.setVisibility(View.VISIBLE);
                fcondP2.setVisibility(View.VISIBLE);
                tdensP2.setVisibility(View.VISIBLE);
                teageP2.setVisibility(View.VISIBLE);
                tehelP2.setVisibility(View.VISIBLE);
                debDiP2.setVisibility(View.VISIBLE);
                pruniP2.setVisibility(View.VISIBLE);
                pesDiP2.setVisibility(View.VISIBLE);
                weediP2.setVisibility(View.VISIBLE);
                harveP2.setVisibility(View.VISIBLE);
                shadeP2.setVisibility(View.VISIBLE);
                soilCP2.setVisibility(View.VISIBLE);
                orgMaP2.setVisibility(View.VISIBLE);
                fertFP2.setVisibility(View.VISIBLE);
                fertAP2.setVisibility(View.VISIBLE);
                limeNP2.setVisibility(View.VISIBLE);
                drainP2.setVisibility(View.VISIBLE);
                filliP2.setVisibility(View.VISIBLE);
                hireNP2.setVisibility(View.VISIBLE);
                gpsP3.setVisibility(View.VISIBLE);
                ageP3.setVisibility(View.VISIBLE);
                areP3.setVisibility(View.VISIBLE);
                cteP3.setVisibility(View.VISIBLE);
                estP3.setVisibility(View.VISIBLE);
                steP3.setVisibility(View.VISIBLE);
                plantP3.setVisibility(View.VISIBLE);
                fcondP3.setVisibility(View.VISIBLE);
                tdensP3.setVisibility(View.VISIBLE);
                teageP3.setVisibility(View.VISIBLE);
                tehelP3.setVisibility(View.VISIBLE);
                debDiP3.setVisibility(View.VISIBLE);
                pruniP3.setVisibility(View.VISIBLE);
                pesDiP3.setVisibility(View.VISIBLE);
                weediP3.setVisibility(View.VISIBLE);
                harveP3.setVisibility(View.VISIBLE);
                shadeP3.setVisibility(View.VISIBLE);
                soilCP3.setVisibility(View.VISIBLE);
                orgMaP3.setVisibility(View.VISIBLE);
                fertFP3.setVisibility(View.VISIBLE);
                fertAP3.setVisibility(View.VISIBLE);
                limeNP3.setVisibility(View.VISIBLE);
                drainP3.setVisibility(View.VISIBLE);
                filliP3.setVisibility(View.VISIBLE);
                hireNP3.setVisibility(View.VISIBLE);
                gpsP4.setVisibility(View.VISIBLE);
                ageP4.setVisibility(View.VISIBLE);
                areP4.setVisibility(View.VISIBLE);
                cteP4.setVisibility(View.VISIBLE);
                estP4.setVisibility(View.VISIBLE);
                steP4.setVisibility(View.VISIBLE);
                plantP4.setVisibility(View.VISIBLE);
                fcondP4.setVisibility(View.VISIBLE);
                tdensP4.setVisibility(View.VISIBLE);
                teageP4.setVisibility(View.VISIBLE);
                tehelP4.setVisibility(View.VISIBLE);
                debDiP4.setVisibility(View.VISIBLE);
                pruniP4.setVisibility(View.VISIBLE);
                pesDiP4.setVisibility(View.VISIBLE);
                weediP4.setVisibility(View.VISIBLE);
                harveP4.setVisibility(View.VISIBLE);
                shadeP4.setVisibility(View.VISIBLE);
                soilCP4.setVisibility(View.VISIBLE);
                orgMaP4.setVisibility(View.VISIBLE);
                fertFP4.setVisibility(View.VISIBLE);
                fertAP4.setVisibility(View.VISIBLE);
                limeNP4.setVisibility(View.VISIBLE);
                drainP4.setVisibility(View.VISIBLE);
                filliP4.setVisibility(View.VISIBLE);
                hireNP4.setVisibility(View.VISIBLE);
                gpsP5.setVisibility(View.VISIBLE);
                ageP5.setVisibility(View.VISIBLE);
                areP5.setVisibility(View.VISIBLE);
                cteP5.setVisibility(View.VISIBLE);
                estP5.setVisibility(View.VISIBLE);
                steP5.setVisibility(View.VISIBLE);
                plantP5.setVisibility(View.VISIBLE);
                fcondP5.setVisibility(View.VISIBLE);
                tdensP5.setVisibility(View.VISIBLE);
                teageP5.setVisibility(View.VISIBLE);
                tehelP5.setVisibility(View.VISIBLE);
                debDiP5.setVisibility(View.VISIBLE);
                pruniP5.setVisibility(View.VISIBLE);
                pesDiP5.setVisibility(View.VISIBLE);
                weediP5.setVisibility(View.VISIBLE);
                harveP5.setVisibility(View.VISIBLE);
                shadeP5.setVisibility(View.VISIBLE);
                soilCP5.setVisibility(View.VISIBLE);
                orgMaP5.setVisibility(View.VISIBLE);
                fertFP5.setVisibility(View.VISIBLE);
                fertAP5.setVisibility(View.VISIBLE);
                limeNP5.setVisibility(View.VISIBLE);
                drainP5.setVisibility(View.VISIBLE);
                filliP5.setVisibility(View.VISIBLE);
                hireNP5.setVisibility(View.VISIBLE);
            } else if (sObject.getNumberOfPlots().equals("0")) {
                Lp1.setVisibility(View.GONE);
                Lp2.setVisibility(View.GONE);
                Lp3.setVisibility(View.GONE);
                Lp4.setVisibility(View.GONE);
                Lp5.setVisibility(View.GONE);
                gpsP1.setVisibility(View.GONE);
                ageP1.setVisibility(View.GONE);
                areP1.setVisibility(View.GONE);
                cteP1.setVisibility(View.GONE);
                estP1.setVisibility(View.GONE);
                steP1.setVisibility(View.GONE);
                plantP1.setVisibility(View.GONE);
                fcondP1.setVisibility(View.GONE);
                tdensP1.setVisibility(View.GONE);
                teageP1.setVisibility(View.GONE);
                tehelP1.setVisibility(View.GONE);
                debDiP1.setVisibility(View.GONE);
                pruniP1.setVisibility(View.GONE);
                pesDiP1.setVisibility(View.GONE);
                weediP1.setVisibility(View.GONE);
                harveP1.setVisibility(View.GONE);
                shadeP1.setVisibility(View.GONE);
                soilCP1.setVisibility(View.GONE);
                orgMaP1.setVisibility(View.GONE);
                fertFP1.setVisibility(View.GONE);
                fertAP1.setVisibility(View.GONE);
                limeNP1.setVisibility(View.GONE);
                drainP1.setVisibility(View.GONE);
                filliP1.setVisibility(View.GONE);
                hireNP1.setVisibility(View.GONE);
                gpsP2.setVisibility(View.GONE);
                ageP2.setVisibility(View.GONE);
                areP2.setVisibility(View.GONE);
                cteP2.setVisibility(View.GONE);
                estP2.setVisibility(View.GONE);
                steP2.setVisibility(View.GONE);
                plantP2.setVisibility(View.GONE);
                fcondP2.setVisibility(View.GONE);
                tdensP2.setVisibility(View.GONE);
                teageP2.setVisibility(View.GONE);
                tehelP2.setVisibility(View.GONE);
                debDiP2.setVisibility(View.GONE);
                pruniP2.setVisibility(View.GONE);
                pesDiP2.setVisibility(View.GONE);
                weediP2.setVisibility(View.GONE);
                harveP2.setVisibility(View.GONE);
                shadeP2.setVisibility(View.GONE);
                soilCP2.setVisibility(View.GONE);
                orgMaP2.setVisibility(View.GONE);
                fertFP2.setVisibility(View.GONE);
                fertAP2.setVisibility(View.GONE);
                limeNP2.setVisibility(View.GONE);
                drainP2.setVisibility(View.GONE);
                filliP2.setVisibility(View.GONE);
                hireNP2.setVisibility(View.GONE);
                gpsP3.setVisibility(View.GONE);
                ageP3.setVisibility(View.GONE);
                areP3.setVisibility(View.GONE);
                cteP3.setVisibility(View.GONE);
                estP3.setVisibility(View.GONE);
                steP3.setVisibility(View.GONE);
                plantP3.setVisibility(View.GONE);
                fcondP3.setVisibility(View.GONE);
                tdensP3.setVisibility(View.GONE);
                teageP3.setVisibility(View.GONE);
                tehelP3.setVisibility(View.GONE);
                debDiP3.setVisibility(View.GONE);
                pruniP3.setVisibility(View.GONE);
                pesDiP3.setVisibility(View.GONE);
                weediP3.setVisibility(View.GONE);
                harveP3.setVisibility(View.GONE);
                shadeP3.setVisibility(View.GONE);
                soilCP3.setVisibility(View.GONE);
                orgMaP3.setVisibility(View.GONE);
                fertFP3.setVisibility(View.GONE);
                fertAP3.setVisibility(View.GONE);
                limeNP3.setVisibility(View.GONE);
                drainP3.setVisibility(View.GONE);
                filliP3.setVisibility(View.GONE);
                hireNP3.setVisibility(View.GONE);
                gpsP4.setVisibility(View.GONE);
                ageP4.setVisibility(View.GONE);
                areP4.setVisibility(View.GONE);
                cteP4.setVisibility(View.GONE);
                estP4.setVisibility(View.GONE);
                steP4.setVisibility(View.GONE);
                plantP4.setVisibility(View.GONE);
                fcondP4.setVisibility(View.GONE);
                tdensP4.setVisibility(View.GONE);
                teageP4.setVisibility(View.GONE);
                tehelP4.setVisibility(View.GONE);
                debDiP4.setVisibility(View.GONE);
                pruniP4.setVisibility(View.GONE);
                pesDiP4.setVisibility(View.GONE);
                weediP4.setVisibility(View.GONE);
                harveP4.setVisibility(View.GONE);
                shadeP4.setVisibility(View.GONE);
                soilCP4.setVisibility(View.GONE);
                orgMaP4.setVisibility(View.GONE);
                fertFP4.setVisibility(View.GONE);
                fertAP4.setVisibility(View.GONE);
                limeNP4.setVisibility(View.GONE);
                drainP4.setVisibility(View.GONE);
                filliP4.setVisibility(View.GONE);
                hireNP4.setVisibility(View.GONE);
                gpsP5.setVisibility(View.GONE);
                ageP5.setVisibility(View.GONE);
                areP5.setVisibility(View.GONE);
                cteP5.setVisibility(View.GONE);
                estP5.setVisibility(View.GONE);
                steP5.setVisibility(View.GONE);
                plantP5.setVisibility(View.GONE);
                fcondP5.setVisibility(View.GONE);
                tdensP5.setVisibility(View.GONE);
                teageP5.setVisibility(View.GONE);
                tehelP5.setVisibility(View.GONE);
                debDiP5.setVisibility(View.GONE);
                pruniP5.setVisibility(View.GONE);
                pesDiP5.setVisibility(View.GONE);
                weediP5.setVisibility(View.GONE);
                harveP5.setVisibility(View.GONE);
                shadeP5.setVisibility(View.GONE);
                soilCP5.setVisibility(View.GONE);
                orgMaP5.setVisibility(View.GONE);
                fertFP5.setVisibility(View.GONE);
                fertAP5.setVisibility(View.GONE);
                limeNP5.setVisibility(View.GONE);
                drainP5.setVisibility(View.GONE);
                filliP5.setVisibility(View.GONE);
                hireNP5.setVisibility(View.GONE);
            } else {
                Lp1.setVisibility(View.VISIBLE);
                Lp2.setVisibility(View.VISIBLE);
                Lp3.setVisibility(View.VISIBLE);
                Lp4.setVisibility(View.VISIBLE);
                Lp5.setVisibility(View.VISIBLE);
                gpsP1.setVisibility(View.VISIBLE);
                ageP1.setVisibility(View.VISIBLE);
                areP1.setVisibility(View.VISIBLE);
                cteP1.setVisibility(View.VISIBLE);
                estP1.setVisibility(View.VISIBLE);
                steP1.setVisibility(View.VISIBLE);
                plantP1.setVisibility(View.VISIBLE);
                fcondP1.setVisibility(View.VISIBLE);
                tdensP1.setVisibility(View.VISIBLE);
                teageP1.setVisibility(View.VISIBLE);
                tehelP1.setVisibility(View.VISIBLE);
                debDiP1.setVisibility(View.VISIBLE);
                pruniP1.setVisibility(View.VISIBLE);
                pesDiP1.setVisibility(View.VISIBLE);
                weediP1.setVisibility(View.VISIBLE);
                harveP1.setVisibility(View.VISIBLE);
                shadeP1.setVisibility(View.VISIBLE);
                soilCP1.setVisibility(View.VISIBLE);
                orgMaP1.setVisibility(View.VISIBLE);
                fertFP1.setVisibility(View.VISIBLE);
                fertAP1.setVisibility(View.VISIBLE);
                limeNP1.setVisibility(View.VISIBLE);
                drainP1.setVisibility(View.VISIBLE);
                filliP1.setVisibility(View.VISIBLE);
                hireNP1.setVisibility(View.VISIBLE);
                gpsP2.setVisibility(View.VISIBLE);
                ageP2.setVisibility(View.VISIBLE);
                areP2.setVisibility(View.VISIBLE);
                cteP2.setVisibility(View.VISIBLE);
                estP2.setVisibility(View.VISIBLE);
                steP2.setVisibility(View.VISIBLE);
                plantP2.setVisibility(View.VISIBLE);
                fcondP2.setVisibility(View.VISIBLE);
                tdensP2.setVisibility(View.VISIBLE);
                teageP2.setVisibility(View.VISIBLE);
                tehelP2.setVisibility(View.VISIBLE);
                debDiP2.setVisibility(View.VISIBLE);
                pruniP2.setVisibility(View.VISIBLE);
                pesDiP2.setVisibility(View.VISIBLE);
                weediP2.setVisibility(View.VISIBLE);
                harveP2.setVisibility(View.VISIBLE);
                shadeP2.setVisibility(View.VISIBLE);
                soilCP2.setVisibility(View.VISIBLE);
                orgMaP2.setVisibility(View.VISIBLE);
                fertFP2.setVisibility(View.VISIBLE);
                fertAP2.setVisibility(View.VISIBLE);
                limeNP2.setVisibility(View.VISIBLE);
                drainP2.setVisibility(View.VISIBLE);
                filliP2.setVisibility(View.VISIBLE);
                hireNP2.setVisibility(View.VISIBLE);
                gpsP3.setVisibility(View.VISIBLE);
                ageP3.setVisibility(View.VISIBLE);
                areP3.setVisibility(View.VISIBLE);
                cteP3.setVisibility(View.VISIBLE);
                estP3.setVisibility(View.VISIBLE);
                steP3.setVisibility(View.VISIBLE);
                plantP3.setVisibility(View.VISIBLE);
                fcondP3.setVisibility(View.VISIBLE);
                tdensP3.setVisibility(View.VISIBLE);
                teageP3.setVisibility(View.VISIBLE);
                tehelP3.setVisibility(View.VISIBLE);
                debDiP3.setVisibility(View.VISIBLE);
                pruniP3.setVisibility(View.VISIBLE);
                pesDiP3.setVisibility(View.VISIBLE);
                weediP3.setVisibility(View.VISIBLE);
                harveP3.setVisibility(View.VISIBLE);
                shadeP3.setVisibility(View.VISIBLE);
                soilCP3.setVisibility(View.VISIBLE);
                orgMaP3.setVisibility(View.VISIBLE);
                fertFP3.setVisibility(View.VISIBLE);
                fertAP3.setVisibility(View.VISIBLE);
                limeNP3.setVisibility(View.VISIBLE);
                drainP3.setVisibility(View.VISIBLE);
                filliP3.setVisibility(View.VISIBLE);
                hireNP3.setVisibility(View.VISIBLE);
                gpsP4.setVisibility(View.VISIBLE);
                ageP4.setVisibility(View.VISIBLE);
                areP4.setVisibility(View.VISIBLE);
                cteP4.setVisibility(View.VISIBLE);
                estP4.setVisibility(View.VISIBLE);
                steP4.setVisibility(View.VISIBLE);
                plantP4.setVisibility(View.VISIBLE);
                fcondP4.setVisibility(View.VISIBLE);
                tdensP4.setVisibility(View.VISIBLE);
                teageP4.setVisibility(View.VISIBLE);
                tehelP4.setVisibility(View.VISIBLE);
                debDiP4.setVisibility(View.VISIBLE);
                pruniP4.setVisibility(View.VISIBLE);
                pesDiP4.setVisibility(View.VISIBLE);
                weediP4.setVisibility(View.VISIBLE);
                harveP4.setVisibility(View.VISIBLE);
                shadeP4.setVisibility(View.VISIBLE);
                soilCP4.setVisibility(View.VISIBLE);
                orgMaP4.setVisibility(View.VISIBLE);
                fertFP4.setVisibility(View.VISIBLE);
                fertAP4.setVisibility(View.VISIBLE);
                limeNP4.setVisibility(View.VISIBLE);
                drainP4.setVisibility(View.VISIBLE);
                filliP4.setVisibility(View.VISIBLE);
                hireNP4.setVisibility(View.VISIBLE);
                gpsP5.setVisibility(View.VISIBLE);
                ageP5.setVisibility(View.VISIBLE);
                areP5.setVisibility(View.VISIBLE);
                cteP5.setVisibility(View.VISIBLE);
                estP5.setVisibility(View.VISIBLE);
                steP5.setVisibility(View.VISIBLE);
                plantP5.setVisibility(View.VISIBLE);
                fcondP5.setVisibility(View.VISIBLE);
                tdensP5.setVisibility(View.VISIBLE);
                teageP5.setVisibility(View.VISIBLE);
                tehelP5.setVisibility(View.VISIBLE);
                debDiP5.setVisibility(View.VISIBLE);
                pruniP5.setVisibility(View.VISIBLE);
                pesDiP5.setVisibility(View.VISIBLE);
                weediP5.setVisibility(View.VISIBLE);
                harveP5.setVisibility(View.VISIBLE);
                shadeP5.setVisibility(View.VISIBLE);
                soilCP5.setVisibility(View.VISIBLE);
                orgMaP5.setVisibility(View.VISIBLE);
                fertFP5.setVisibility(View.VISIBLE);
                fertAP5.setVisibility(View.VISIBLE);
                limeNP5.setVisibility(View.VISIBLE);
                drainP5.setVisibility(View.VISIBLE);
                filliP5.setVisibility(View.VISIBLE);
                hireNP5.setVisibility(View.VISIBLE);
            }
            //set field
            if (sObject.getPlot1Area().isEmpty()){
                setText((EditText) findViewById(R.id.plotArea1_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotArea1_field),
                        sObject.getPlot1Area());
            }

            //set field
            if (sObject.getPlot1Age().isEmpty()){
                setText((EditText) findViewById(R.id.plotAgep1_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotAgep1_field),
                        sObject.getPlot1Age());
            }
            //set field
            if (sObject.getPlot1GPS().isEmpty()){
                setText((EditText) findViewById(R.id.gpsp1_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.gpsp1_field),
                        sObject.getPlot1GPS());
            }

            //set field
            if (sObject.getPlot1CocoaTrees().isEmpty()){
                setText((EditText) findViewById(R.id.cocoaTreesP1_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.cocoaTreesP1_field),
                        sObject.getPlot1CocoaTrees());
            }

            //set field
            if (sObject.getPlot1ShadeTrees().isEmpty()){
                setText((EditText) findViewById(R.id.shadeTreesP1_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.shadeTreesP1_field),
                        sObject.getPlot1ShadeTrees());
            }

            //set field
            if (sObject.getPlot1Yield().isEmpty()){
                setText((EditText) findViewById(R.id.estimatedP1_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.estimatedP1_field),
                        sObject.getPlot1Yield());
            }

            //set field
            if (sObject.getPlantingMaterial1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial1().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFarmCondition1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFarmCondition1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeDensity1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeDensity1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeAge1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeAge1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeHealth1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDebilitatingDisease1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPruning1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning1().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPestDiseaseSanitation1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation1().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getWeeding1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHarvesting1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getShadeManagement1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getSoilCondition1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getOrganicMatter1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerFormulation1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation1().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerApplication1().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication1().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication1().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getLimeNeed1().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.limeP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getLimeNeed1().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.limeP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.limeP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDrainageNeed1().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed1().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFillingOption1().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFillingOption1().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHireLabor1().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor1().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.hireP1_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            ////////////////////////////////////////////////////////

            //set field
            if (sObject.getPlot2Area().isEmpty()){
                setText((EditText) findViewById(R.id.plotArea2_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotArea2_field),
                        sObject.getPlot2Area());
            }

            //set field
            if (sObject.getPlot2Age().isEmpty()){
                setText((EditText) findViewById(R.id.plotAgep2_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotAgep2_field),
                        sObject.getPlot2Age());
            }
            //set field
            if (sObject.getPlot2GPS().isEmpty()){
                setText((EditText) findViewById(R.id.gpsp2_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.gpsp2_field),
                        sObject.getPlot2GPS());
            }

            //set field
            if (sObject.getPlot2CocoaTrees().isEmpty()){
                setText((EditText) findViewById(R.id.cocoaTreesP2_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.cocoaTreesP2_field),
                        sObject.getPlot2CocoaTrees());
            }

            //set field
            if (sObject.getPlot2ShadeTrees().isEmpty()){
                setText((EditText) findViewById(R.id.shadeTreesP2_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.shadeTreesP2_field),
                        sObject.getPlot2ShadeTrees());
            }

            //set field
            if (sObject.getPlot2Yield().isEmpty()){
                setText((EditText) findViewById(R.id.estimatedP2_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.estimatedP2_field),
                        sObject.getPlot2Yield());
            }

            //set field
            if (sObject.getPlantingMaterial2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial2().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFarmCondition2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFarmCondition2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeDensity2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeDensity2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeAge2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeAge2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeHealth2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDebilitatingDisease2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPruning2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning2().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPestDiseaseSanitation2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation2().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getWeeding2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHarvesting2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getShadeManagement2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getSoilCondition2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getOrganicMatter2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerFormulation2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation2().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFartilizerApplication2().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFartilizerApplication2().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFartilizerApplication2().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getLimeNeed2().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.limeP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getLimeNeed2().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.limeP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.limeP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDrainageNeed2().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed2().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFillingOption2().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFillingOption2().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHireLabor2().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor2().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.hireP2_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            ////////////////////////////////////////////////////////

            //set field
            if (sObject.getPlot3Area().isEmpty()){
                setText((EditText) findViewById(R.id.plotArea3_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotArea3_field),
                        sObject.getPlot3Area());
            }

            //set field
            if (sObject.getPlot3Age().isEmpty()){
                setText((EditText) findViewById(R.id.plotAgep3_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotAgep3_field),
                        sObject.getPlot3Age());
            }
            //set field
            if (sObject.getPlot3GPS().isEmpty()){
                setText((EditText) findViewById(R.id.gpsp3_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.gpsp3_field),
                        sObject.getPlot3GPS());
            }

            //set field
            if (sObject.getPlot3CocoaTrees().isEmpty()){
                setText((EditText) findViewById(R.id.cocoaTreesP3_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.cocoaTreesP3_field),
                        sObject.getPlot3CocoaTrees());
            }

            //set field
            if (sObject.getPlot3ShadeTrees().isEmpty()){
                setText((EditText) findViewById(R.id.shadeTreesP3_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.shadeTreesP3_field),
                        sObject.getPlot3ShadeTrees());
            }

            //set field
            if (sObject.getPlot3Yield().isEmpty()){
                setText((EditText) findViewById(R.id.estimatedP3_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.estimatedP3_field),
                        sObject.getPlot3Yield());
            }

            //set field
            if (sObject.getPlantingMaterial3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial3().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFarmCondition3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFarmCondition3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeDensity3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeDensity3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeAge3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeAge3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeHealth3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDebilitatingDisease3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPruning3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning3().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPestDiseaseSanitation3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation3().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getWeeding3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHarvesting3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getShadeManagement3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getSoilCondition3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getOrganicMatter3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerFormulation3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation3().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerApplication3().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication3().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication3().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getLimeNeed3().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.limeP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getLimeNeed3().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.limeP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.limeP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDrainageNeed3().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed3().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFillingOption3().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFillingOption3().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHireLabor3().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor3().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.hireP3_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            ////////////////////////////////////////////////////////

            //set field
            if (sObject.getPlot4Area().isEmpty()){
                setText((EditText) findViewById(R.id.plotArea4_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotArea4_field),
                        sObject.getPlot4Area());
            }

            //set field
            if (sObject.getPlot4Age().isEmpty()){
                setText((EditText) findViewById(R.id.plotAgep4_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotAgep4_field),
                        sObject.getPlot4Age());
            }
            //set field
            if (sObject.getPlot4GPS().isEmpty()){
                setText((EditText) findViewById(R.id.gpsp4_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.gpsp4_field),
                        sObject.getPlot4GPS());
            }

            //set field
            if (sObject.getPlot4CocoaTrees().isEmpty()){
                setText((EditText) findViewById(R.id.cocoaTreesP4_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.cocoaTreesP4_field),
                        sObject.getPlot4CocoaTrees());
            }

            //set field
            if (sObject.getPlot4ShadeTrees().isEmpty()){
                setText((EditText) findViewById(R.id.shadeTreesP4_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.shadeTreesP4_field),
                        sObject.getPlot4ShadeTrees());
            }

            //set field
            if (sObject.getPlot4Yield().isEmpty()){
                setText((EditText) findViewById(R.id.estimatedP4_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.estimatedP4_field),
                        sObject.getPlot4Yield());
            }

            //set field
            if (sObject.getPlantingMaterial4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial4().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFarmCondition4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFarmCondition4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeDensity4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeDensity4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeAge4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeAge4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeHealth4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDebilitatingDisease4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPruning4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning4().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPestDiseaseSanitation4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation4().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getWeeding4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHarvesting4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getShadeManagement4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getSoilCondition4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getOrganicMatter4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerFormulation4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation4().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerApplication4().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication4().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication4().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.geLimeNeed4().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.limeP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.geLimeNeed4().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.limeP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.limeP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDrainageNeed4().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed4().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFillingOption4().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFillingOption4().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHireLabor4().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor4().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.hireP4_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            ////////////////////////////////////////////////////////

            //set field
            if (sObject.getPlot5Area().isEmpty()){
                setText((EditText) findViewById(R.id.plotArea5_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotArea5_field),
                        sObject.getPlot5Area());
            }

            //set field
            if (sObject.getPlot5Age().isEmpty()){
                setText((EditText) findViewById(R.id.plotAgep5_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.plotAgep5_field),
                        sObject.getPlot5Age());
            }
            //set field
            if (sObject.getPlot5GPS().isEmpty()){
                setText((EditText) findViewById(R.id.gpsp5_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.gpsp5_field),
                        sObject.getPlot5GPS());
            }

            //set field
            if (sObject.getPlot5CocoaTrees().isEmpty()){
                setText((EditText) findViewById(R.id.cocoaTreesP5_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.cocoaTreesP5_field),
                        sObject.getPlot5CocoaTrees());
            }

            //set field
            if (sObject.getPlot5ShadeTrees().isEmpty()){
                setText((EditText) findViewById(R.id.shadeTreesP5_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.shadeTreesP5_field),
                        sObject.getPlot5ShadeTrees());
            }

            //set field
            if (sObject.getPlot5Yield().isEmpty()){
                setText((EditText) findViewById(R.id.estimatedP5_field),Integer.toString(0));
            }else {
                setText((EditText) findViewById(R.id.estimatedP5_field),
                        sObject.getPlot5Yield());
            }

            //set field
            if (sObject.getPlantingMaterial5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPlantingMaterial5().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPlantingMaterial5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.plantingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFarmCondition5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFarmCondition5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.farmConditionP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeDensity5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeDensity5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeDensityP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeAge5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeAge5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeAgeP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getTreeHealth5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getTreeHealth5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.treeHealthP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDebilitatingDisease5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDebilitatingDisease5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.debilitationP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPruning5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPruning5().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPruning5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pruningP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getPestDiseaseSanitation5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getPestDiseaseSanitation5().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getPestDiseaseSanitation5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.pestDiseaseP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getWeeding5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getWeeding5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.weedingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHarvesting5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHarvesting5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.harvestingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getShadeManagement5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getShadeManagement5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.shadeManagementP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getSoilCondition5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getSoilCondition5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.soilConditionP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getOrganicMatter5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_b, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getOrganicMatter5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_g, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.organicMatterP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerFormulation5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerFormulation5().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerFormulation5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartFormP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFertilizerApplication5().contentEquals("G")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.g_mb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFertilizerApplication5().contentEquals("M")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.m_gb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else if (sObject.getFertilizerApplication5().contentEquals("B")) {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.b_gm, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fartApplicationP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.gmb, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getLimeNeed5().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.limeP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getLimeNeed5().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.limeP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.limeP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getDrainageNeed5().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getDrainageNeed5().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.drainageP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getFillingOption5().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getFillingOption5().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.fillingP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }

            //set field
            if (sObject.getHireLabor5().contentEquals("Yes")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            } else if (sObject.getHireLabor5().contentEquals("No")) {
                Spinner spinner = (Spinner) findViewById(R.id.hireP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.No, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }else {
                Spinner spinner = (Spinner) findViewById(R.id.hireP5_field);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.yesNo, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }
        }
    }

    private void setText(EditText textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }

    private void save() {
        final String gpsp1 = ((EditText) findViewById(R.id.gpsp1_field)).getText().toString();
        final String plotAgep1 = ((EditText) findViewById(R.id.plotAgep1_field)).getText().toString();
        final String plotArea1 = ((EditText) findViewById(R.id.plotArea1_field)).getText().toString();
        final String cocoaTreesP1 = ((EditText) findViewById(R.id.cocoaTreesP1_field)).getText().toString();
        final String estimatedP1 = ((EditText) findViewById(R.id.estimatedP1_field)).getText().toString();
        final String shadeTreesP1 = ((EditText) findViewById(R.id.shadeTreesP1_field)).getText().toString();
        final String plantingP1 = ((Spinner) findViewById(R.id.plantingP1_field)).getSelectedItem().toString();
        final String farmConditionP1 = ((Spinner) findViewById(R.id.farmConditionP1_field)).getSelectedItem().toString();
        final String treeDensityP1 = ((Spinner) findViewById(R.id.treeDensityP1_field)).getSelectedItem().toString();
        final String treeAgeP1 = ((Spinner) findViewById(R.id.treeAgeP1_field)).getSelectedItem().toString();
        final String treeHealthP1 = ((Spinner) findViewById(R.id.treeHealthP1_field)).getSelectedItem().toString();
        final String debilitationP1 = ((Spinner) findViewById(R.id.debilitationP1_field)).getSelectedItem().toString();
        final String pruningP1 = ((Spinner) findViewById(R.id.pruningP1_field)).getSelectedItem().toString();
        final String pestDiseaseP1 = ((Spinner) findViewById(R.id.pestDiseaseP1_field)).getSelectedItem().toString();
        final String weedingP1 = ((Spinner) findViewById(R.id.weedingP1_field)).getSelectedItem().toString();
        final String harvestingP1 = ((Spinner) findViewById(R.id.harvestingP1_field)).getSelectedItem().toString();
        final String shadeManagementP1 = ((Spinner) findViewById(R.id.shadeManagementP1_field)).getSelectedItem().toString();
        final String soilConditionP1 = ((Spinner) findViewById(R.id.soilConditionP1_field)).getSelectedItem().toString();
        final String organicMatterP1 = ((Spinner) findViewById(R.id.organicMatterP1_field)).getSelectedItem().toString();
        final String fertFormP1 = ((Spinner) findViewById(R.id.fartFormP1_field)).getSelectedItem().toString();
        final String fertApplicationP1 = ((Spinner) findViewById(R.id.fartApplicationP1_field)).getSelectedItem().toString();
        final String limeP1 = ((Spinner) findViewById(R.id.limeP1_field)).getSelectedItem().toString();
        final String drainageP1 = ((Spinner) findViewById(R.id.drainageP1_field)).getSelectedItem().toString();
        final String fillingP1 = ((Spinner) findViewById(R.id.fillingP1_field)).getSelectedItem().toString();
        final String hireP1 = ((Spinner) findViewById(R.id.hireP1_field)).getSelectedItem().toString();
        final String gpsp2 = ((EditText) findViewById(R.id.gpsp2_field)).getText().toString();
        final String plotAgep2 = ((EditText) findViewById(R.id.plotAgep2_field)).getText().toString();
        final String plotArea2 = ((EditText) findViewById(R.id.plotArea2_field)).getText().toString();
        final String cocoaTreesP2 = ((EditText) findViewById(R.id.cocoaTreesP2_field)).getText().toString();
        final String estimatedP2 = ((EditText) findViewById(R.id.estimatedP2_field)).getText().toString();
        final String shadeTreesP2 = ((EditText) findViewById(R.id.shadeTreesP2_field)).getText().toString();
        final String plantingP2 = ((Spinner) findViewById(R.id.plantingP2_field)).getSelectedItem().toString();
        final String farmConditionP2 = ((Spinner) findViewById(R.id.farmConditionP2_field)).getSelectedItem().toString();
        final String treeDensityP2 = ((Spinner) findViewById(R.id.treeDensityP2_field)).getSelectedItem().toString();
        final String treeAgeP2 = ((Spinner) findViewById(R.id.treeAgeP2_field)).getSelectedItem().toString();
        final String treeHealthP2 = ((Spinner) findViewById(R.id.treeHealthP2_field)).getSelectedItem().toString();
        final String debilitationP2 = ((Spinner) findViewById(R.id.debilitationP2_field)).getSelectedItem().toString();
        final String pruningP2 = ((Spinner) findViewById(R.id.pruningP2_field)).getSelectedItem().toString();
        final String pestDiseaseP2 = ((Spinner) findViewById(R.id.pestDiseaseP2_field)).getSelectedItem().toString();
        final String weedingP2 = ((Spinner) findViewById(R.id.weedingP2_field)).getSelectedItem().toString();
        final String harvestingP2 = ((Spinner) findViewById(R.id.harvestingP2_field)).getSelectedItem().toString();
        final String shadeManagementP2 = ((Spinner) findViewById(R.id.shadeManagementP2_field)).getSelectedItem().toString();
        final String soilConditionP2 = ((Spinner) findViewById(R.id.soilConditionP2_field)).getSelectedItem().toString();
        final String organicMatterP2 = ((Spinner) findViewById(R.id.organicMatterP2_field)).getSelectedItem().toString();
        final String fertFormP2 = ((Spinner) findViewById(R.id.fartFormP2_field)).getSelectedItem().toString();
        final String fertApplicationP2 = ((Spinner) findViewById(R.id.fartApplicationP2_field)).getSelectedItem().toString();
        final String limeP2 = ((Spinner) findViewById(R.id.limeP2_field)).getSelectedItem().toString();
        final String drainageP2 = ((Spinner) findViewById(R.id.drainageP2_field)).getSelectedItem().toString();
        final String fillingP2 = ((Spinner) findViewById(R.id.fillingP2_field)).getSelectedItem().toString();
        final String hireP2 = ((Spinner) findViewById(R.id.hireP2_field)).getSelectedItem().toString();
        final String gpsp3 = ((EditText) findViewById(R.id.gpsp3_field)).getText().toString();
        final String plotAgep3 = ((EditText) findViewById(R.id.plotAgep3_field)).getText().toString();
        final String plotArea3 = ((EditText) findViewById(R.id.plotArea3_field)).getText().toString();
        final String cocoaTreesP3 = ((EditText) findViewById(R.id.cocoaTreesP3_field)).getText().toString();
        final String estimatedP3 = ((EditText) findViewById(R.id.estimatedP3_field)).getText().toString();
        final String shadeTreesP3 = ((EditText) findViewById(R.id.shadeTreesP3_field)).getText().toString();
        final String plantingP3 = ((Spinner) findViewById(R.id.plantingP3_field)).getSelectedItem().toString();
        final String farmConditionP3 = ((Spinner) findViewById(R.id.farmConditionP3_field)).getSelectedItem().toString();
        final String treeDensityP3 = ((Spinner) findViewById(R.id.treeDensityP3_field)).getSelectedItem().toString();
        final String treeAgeP3 = ((Spinner) findViewById(R.id.treeAgeP3_field)).getSelectedItem().toString();
        final String treeHealthP3 = ((Spinner) findViewById(R.id.treeHealthP3_field)).getSelectedItem().toString();
        final String debilitationP3 = ((Spinner) findViewById(R.id.debilitationP3_field)).getSelectedItem().toString();
        final String pruningP3 = ((Spinner) findViewById(R.id.pruningP3_field)).getSelectedItem().toString();
        final String pestDiseaseP3 = ((Spinner) findViewById(R.id.pestDiseaseP3_field)).getSelectedItem().toString();
        final String weedingP3 = ((Spinner) findViewById(R.id.weedingP3_field)).getSelectedItem().toString();
        final String harvestingP3 = ((Spinner) findViewById(R.id.harvestingP3_field)).getSelectedItem().toString();
        final String shadeManagementP3 = ((Spinner) findViewById(R.id.shadeManagementP3_field)).getSelectedItem().toString();
        final String soilConditionP3 = ((Spinner) findViewById(R.id.soilConditionP3_field)).getSelectedItem().toString();
        final String organicMatterP3 = ((Spinner) findViewById(R.id.organicMatterP3_field)).getSelectedItem().toString();
        final String fertFormP3 = ((Spinner) findViewById(R.id.fartFormP3_field)).getSelectedItem().toString();
        final String fertApplicationP3 = ((Spinner) findViewById(R.id.fartApplicationP3_field)).getSelectedItem().toString();
        final String limeP3 = ((Spinner) findViewById(R.id.limeP3_field)).getSelectedItem().toString();
        final String drainageP3 = ((Spinner) findViewById(R.id.drainageP3_field)).getSelectedItem().toString();
        final String fillingP3 = ((Spinner) findViewById(R.id.fillingP3_field)).getSelectedItem().toString();
        final String hireP3 = ((Spinner) findViewById(R.id.hireP3_field)).getSelectedItem().toString();
        final String gpsp4 = ((EditText) findViewById(R.id.gpsp4_field)).getText().toString();
        final String plotAgep4 = ((EditText) findViewById(R.id.plotAgep4_field)).getText().toString();
        final String plotArea4 = ((EditText) findViewById(R.id.plotArea4_field)).getText().toString();
        final String cocoaTreesP4 = ((EditText) findViewById(R.id.cocoaTreesP4_field)).getText().toString();
        final String estimatedP4 = ((EditText) findViewById(R.id.estimatedP4_field)).getText().toString();
        final String shadeTreesP4 = ((EditText) findViewById(R.id.shadeTreesP4_field)).getText().toString();
        final String plantingP4 = ((Spinner) findViewById(R.id.plantingP4_field)).getSelectedItem().toString();
        final String farmConditionP4 = ((Spinner) findViewById(R.id.farmConditionP4_field)).getSelectedItem().toString();
        final String treeDensityP4 = ((Spinner) findViewById(R.id.treeDensityP4_field)).getSelectedItem().toString();
        final String treeAgeP4 = ((Spinner) findViewById(R.id.treeAgeP4_field)).getSelectedItem().toString();
        final String treeHealthP4 = ((Spinner) findViewById(R.id.treeHealthP4_field)).getSelectedItem().toString();
        final String debilitationP4 = ((Spinner) findViewById(R.id.debilitationP4_field)).getSelectedItem().toString();
        final String pruningP4 = ((Spinner) findViewById(R.id.pruningP4_field)).getSelectedItem().toString();
        final String pestDiseaseP4 = ((Spinner) findViewById(R.id.pestDiseaseP4_field)).getSelectedItem().toString();
        final String weedingP4 = ((Spinner) findViewById(R.id.weedingP4_field)).getSelectedItem().toString();
        final String harvestingP4 = ((Spinner) findViewById(R.id.harvestingP4_field)).getSelectedItem().toString();
        final String shadeManagementP4 = ((Spinner) findViewById(R.id.shadeManagementP4_field)).getSelectedItem().toString();
        final String soilConditionP4 = ((Spinner) findViewById(R.id.soilConditionP4_field)).getSelectedItem().toString();
        final String organicMatterP4 = ((Spinner) findViewById(R.id.organicMatterP4_field)).getSelectedItem().toString();
        final String fertFormP4 = ((Spinner) findViewById(R.id.fartFormP4_field)).getSelectedItem().toString();
        final String fertApplicationP4 = ((Spinner) findViewById(R.id.fartApplicationP4_field)).getSelectedItem().toString();
        final String limeP4 = ((Spinner) findViewById(R.id.limeP4_field)).getSelectedItem().toString();
        final String drainageP4 = ((Spinner) findViewById(R.id.drainageP4_field)).getSelectedItem().toString();
        final String fillingP4 = ((Spinner) findViewById(R.id.fillingP4_field)).getSelectedItem().toString();
        final String hireP4 = ((Spinner) findViewById(R.id.hireP4_field)).getSelectedItem().toString();
        final String gpsp5 = ((EditText) findViewById(R.id.gpsp5_field)).getText().toString();
        final String plotAgep5 = ((EditText) findViewById(R.id.plotAgep5_field)).getText().toString();
        final String plotArea5 = ((EditText) findViewById(R.id.plotArea5_field)).getText().toString();
        final String cocoaTreesP5 = ((EditText) findViewById(R.id.cocoaTreesP5_field)).getText().toString();
        final String estimatedP5 = ((EditText) findViewById(R.id.estimatedP5_field)).getText().toString();
        final String shadeTreesP5 = ((EditText) findViewById(R.id.shadeTreesP5_field)).getText().toString();
        final String plantingP5 = ((Spinner) findViewById(R.id.plantingP5_field)).getSelectedItem().toString();
        final String farmConditionP5 = ((Spinner) findViewById(R.id.farmConditionP5_field)).getSelectedItem().toString();
        final String treeDensityP5 = ((Spinner) findViewById(R.id.treeDensityP5_field)).getSelectedItem().toString();
        final String treeAgeP5 = ((Spinner) findViewById(R.id.treeAgeP5_field)).getSelectedItem().toString();
        final String treeHealthP5 = ((Spinner) findViewById(R.id.treeHealthP5_field)).getSelectedItem().toString();
        final String debilitationP5 = ((Spinner) findViewById(R.id.debilitationP5_field)).getSelectedItem().toString();
        final String pruningP5 = ((Spinner) findViewById(R.id.pruningP5_field)).getSelectedItem().toString();
        final String pestDiseaseP5 = ((Spinner) findViewById(R.id.pestDiseaseP5_field)).getSelectedItem().toString();
        final String weedingP5 = ((Spinner) findViewById(R.id.weedingP5_field)).getSelectedItem().toString();
        final String harvestingP5 = ((Spinner) findViewById(R.id.harvestingP5_field)).getSelectedItem().toString();
        final String shadeManagementP5 = ((Spinner) findViewById(R.id.shadeManagementP5_field)).getSelectedItem().toString();
        final String soilConditionP5 = ((Spinner) findViewById(R.id.soilConditionP5_field)).getSelectedItem().toString();
        final String organicMatterP5 = ((Spinner) findViewById(R.id.organicMatterP5_field)).getSelectedItem().toString();
        final String fertFormP5 = ((Spinner) findViewById(R.id.fartFormP5_field)).getSelectedItem().toString();
        final String fertApplicationP5 = ((Spinner) findViewById(R.id.fartApplicationP5_field)).getSelectedItem().toString();
        final String limeP5 = ((Spinner) findViewById(R.id.limeP5_field)).getSelectedItem().toString();
        final String drainageP5 = ((Spinner) findViewById(R.id.drainageP5_field)).getSelectedItem().toString();
        final String fillingP5 = ((Spinner) findViewById(R.id.fillingP5_field)).getSelectedItem().toString();
        final String hireP5 = ((Spinner) findViewById(R.id.hireP5_field)).getSelectedItem().toString();
        final SmartStore smartStore = SmartSyncSDKManager.getInstance().getSmartStore(curAccount);
        JSONObject contact;
        try {
            boolean isCreate = TextUtils.isEmpty(objectId);
            if (!isCreate) {
                contact = smartStore.retrieve(ContactListLoader.CONTACT_SOUP,
                        smartStore.lookupSoupEntryId(ContactListLoader.CONTACT_SOUP,
                                Constants.ID, objectId)).getJSONObject(0);
            } else {
                contact = new JSONObject();
                contact.put(Constants.ID, "local_" + System.currentTimeMillis()
                        + Constants.EMPTY_STRING);
                final JSONObject attributes = new JSONObject();
                attributes.put(Constants.TYPE.toLowerCase(), Constants.SUBMISSION);
                contact.put(Constants.ATTRIBUTES, attributes);
            }
            contact.put(ContactObject.PLOT1GPS, gpsp1);
            contact.put(ContactObject.PLOT1AGE, plotAgep1);
            contact.put(ContactObject.PLOT1AREA, plotArea1);
            contact.put(ContactObject.PLOT1COCOATREES, cocoaTreesP1);
            contact.put(ContactObject.PLOT1YIELD, estimatedP1);
            contact.put(ContactObject.PLOT1SHADETREES, shadeTreesP1);
            contact.put(ContactObject.PLANTINGMATERIAL1, plantingP1);
            contact.put(ContactObject.FARMCONDITION1, farmConditionP1);
            contact.put(ContactObject.TREEDENSITY1, treeDensityP1);
            contact.put(ContactObject.TREEAGE1, treeAgeP1);
            contact.put(ContactObject.TREEHEALTH1, treeHealthP1);
            contact.put(ContactObject.DEBILITATINGDISEASE1, debilitationP1);
            contact.put(ContactObject.PRUNING1, pruningP1);
            contact.put(ContactObject.PESTDISEASESANITATION1, pestDiseaseP1);
            contact.put(ContactObject.WEEDING1, weedingP1);
            contact.put(ContactObject.HARVESTING1, harvestingP1);
            contact.put(ContactObject.SHADEMANAGEMENT1, shadeManagementP1);
            contact.put(ContactObject.SOILCONDITION1, soilConditionP1);
            contact.put(ContactObject.ORGANICMATTER1, organicMatterP1);
            contact.put(ContactObject.FERTILIZERFORMULATION1, fertFormP1);
            contact.put(ContactObject.FERTILIZERAPPLICATION1, fertApplicationP1);
            contact.put(ContactObject.LIMENEED1, limeP1);
            contact.put(ContactObject.DRAINAGENEED1, drainageP1);
            contact.put(ContactObject.FILLINGOPTION1, fillingP1);
            contact.put(ContactObject.HIRELABOR1, hireP1);
            contact.put(ContactObject.PLOT2GPS, gpsp2);
            contact.put(ContactObject.PLOT2AGE, plotAgep2);
            contact.put(ContactObject.PLOT2AREA, plotArea2);
            contact.put(ContactObject.PLOT2COCOATREES, cocoaTreesP2);
            contact.put(ContactObject.PLOT2YIELD, estimatedP2);
            contact.put(ContactObject.PLOT2SHADETREES, shadeTreesP2);
            contact.put(ContactObject.PLANTINGMATERIAL2, plantingP2);
            contact.put(ContactObject.FARMCONDITION2, farmConditionP2);
            contact.put(ContactObject.TREEDENSITY2, treeDensityP2);
            contact.put(ContactObject.TREEAGE2, treeAgeP2);
            contact.put(ContactObject.TREEHEALTH2, treeHealthP2);
            contact.put(ContactObject.DEBILITATINGDISEASE2, debilitationP2);
            contact.put(ContactObject.PRUNING2, pruningP2);
            contact.put(ContactObject.PESTDISEASESANITATION2, pestDiseaseP2);
            contact.put(ContactObject.WEEDING2, weedingP2);
            contact.put(ContactObject.HARVESTING2, harvestingP2);
            contact.put(ContactObject.SHADEMANAGEMENT2, shadeManagementP2);
            contact.put(ContactObject.SOILCONDITION2, soilConditionP2);
            contact.put(ContactObject.ORGANICMATTER2, organicMatterP2);
            contact.put(ContactObject.FERTILIZERFORMULATION2, fertFormP2);
            contact.put(ContactObject.FERTILIZERAPPLICATION2, fertApplicationP2);
            contact.put(ContactObject.LIMENEED2, limeP2);
            contact.put(ContactObject.DRAINAGENEED2, drainageP2);
            contact.put(ContactObject.FILLINGOPTION2, fillingP2);
            contact.put(ContactObject.HIRELABOR2, hireP2);
            contact.put(ContactObject.PLOT3GPS, gpsp3);
            contact.put(ContactObject.PLOT3AGE, plotAgep3);
            contact.put(ContactObject.PLOT3AREA, plotArea3);
            contact.put(ContactObject.PLOT3COCOATREES, cocoaTreesP3);
            contact.put(ContactObject.PLOT3YIELD, estimatedP3);
            contact.put(ContactObject.PLOT3SHADETREES, shadeTreesP3);
            contact.put(ContactObject.PLANTINGMATERIAL3, plantingP3);
            contact.put(ContactObject.FARMCONDITION3, farmConditionP3);
            contact.put(ContactObject.TREEDENSITY3, treeDensityP3);
            contact.put(ContactObject.TREEAGE3, treeAgeP3);
            contact.put(ContactObject.TREEHEALTH3, treeHealthP3);
            contact.put(ContactObject.DEBILITATINGDISEASE3, debilitationP3);
            contact.put(ContactObject.PRUNING3, pruningP3);
            contact.put(ContactObject.PESTDISEASESANITATION3, pestDiseaseP3);
            contact.put(ContactObject.WEEDING3, weedingP3);
            contact.put(ContactObject.HARVESTING3, harvestingP3);
            contact.put(ContactObject.SHADEMANAGEMENT3, shadeManagementP3);
            contact.put(ContactObject.SOILCONDITION3, soilConditionP3);
            contact.put(ContactObject.ORGANICMATTER3, organicMatterP3);
            contact.put(ContactObject.FERTILIZERFORMULATION3, fertFormP3);
            contact.put(ContactObject.FERTILIZERAPPLICATION3, fertApplicationP3);
            contact.put(ContactObject.LIMENEED3, limeP3);
            contact.put(ContactObject.DRAINAGENEED3, drainageP3);
            contact.put(ContactObject.FILLINGOPTION3, fillingP3);
            contact.put(ContactObject.HIRELABOR3, hireP3);
            contact.put(ContactObject.PLOT4GPS, gpsp4);
            contact.put(ContactObject.PLOT4AGE, plotAgep4);
            contact.put(ContactObject.PLOT4AREA, plotArea4);
            contact.put(ContactObject.PLOT4COCOATREES, cocoaTreesP4);
            contact.put(ContactObject.PLOT4YIELD, estimatedP4);
            contact.put(ContactObject.PLOT4SHADETREES, shadeTreesP4);
            contact.put(ContactObject.PLANTINGMATERIAL4, plantingP4);
            contact.put(ContactObject.FARMCONDITION4, farmConditionP4);
            contact.put(ContactObject.TREEDENSITY4, treeDensityP4);
            contact.put(ContactObject.TREEAGE4, treeAgeP4);
            contact.put(ContactObject.TREEHEALTH4, treeHealthP4);
            contact.put(ContactObject.DEBILITATINGDISEASE4, debilitationP4);
            contact.put(ContactObject.PRUNING4, pruningP4);
            contact.put(ContactObject.PESTDISEASESANITATION4, pestDiseaseP4);
            contact.put(ContactObject.WEEDING4, weedingP4);
            contact.put(ContactObject.HARVESTING4, harvestingP4);
            contact.put(ContactObject.SHADEMANAGEMENT4, shadeManagementP4);
            contact.put(ContactObject.SOILCONDITION4, soilConditionP4);
            contact.put(ContactObject.ORGANICMATTER4, organicMatterP4);
            contact.put(ContactObject.FERTILIZERFORMULATION4, fertFormP4);
            contact.put(ContactObject.FERTILIZERAPPLICATION4, fertApplicationP4);
            contact.put(ContactObject.LIMENEED4, limeP4);
            contact.put(ContactObject.DRAINAGENEED4, drainageP4);
            contact.put(ContactObject.FILLINGOPTION4, fillingP4);
            contact.put(ContactObject.HIRELABOR4, hireP4);
            contact.put(ContactObject.PLOT5GPS, gpsp5);
            contact.put(ContactObject.PLOT5AGE, plotAgep5);
            contact.put(ContactObject.PLOT5AREA, plotArea5);
            contact.put(ContactObject.PLOT5COCOATREES, cocoaTreesP5);
            contact.put(ContactObject.PLOT5YIELD, estimatedP5);
            contact.put(ContactObject.PLOT5SHADETREES, shadeTreesP5);
            contact.put(ContactObject.PLANTINGMATERIAL5, plantingP5);
            contact.put(ContactObject.FARMCONDITION5, farmConditionP5);
            contact.put(ContactObject.TREEDENSITY5, treeDensityP5);
            contact.put(ContactObject.TREEAGE5, treeAgeP5);
            contact.put(ContactObject.TREEHEALTH5, treeHealthP5);
            contact.put(ContactObject.DEBILITATINGDISEASE5, debilitationP5);
            contact.put(ContactObject.PRUNING5, pruningP5);
            contact.put(ContactObject.PESTDISEASESANITATION5, pestDiseaseP5);
            contact.put(ContactObject.WEEDING5, weedingP5);
            contact.put(ContactObject.HARVESTING5, harvestingP5);
            contact.put(ContactObject.SHADEMANAGEMENT5, shadeManagementP5);
            contact.put(ContactObject.SOILCONDITION5, soilConditionP5);
            contact.put(ContactObject.ORGANICMATTER5, organicMatterP5);
            contact.put(ContactObject.FERTILIZERFORMULATION5, fertFormP5);
            contact.put(ContactObject.FERTILIZERAPPLICATION5, fertApplicationP5);
            contact.put(ContactObject.LIMENEED5, limeP5);
            contact.put(ContactObject.DRAINAGENEED5, drainageP5);
            contact.put(ContactObject.FILLINGOPTION5, fillingP5);
            contact.put(ContactObject.HIRELABOR5, hireP5);
            contact.put(SyncManager.LOCAL, true);
            contact.put(SyncManager.LOCALLY_UPDATED, !isCreate);
            contact.put(SyncManager.LOCALLY_CREATED, isCreate);
            contact.put(SyncManager.LOCALLY_DELETED, false);
            if (isCreate) {
                smartStore.create(ContactListLoader.CONTACT_SOUP, contact);
            } else {
                smartStore.upsert(ContactListLoader.CONTACT_SOUP, contact);
            }
            Toast.makeText(this, "Save successful!", Toast.LENGTH_LONG).show();
            finish();
        } catch (JSONException e) {
            Log.e(TAG, "JSONException occurred while parsing", e);
        }
    }
}
