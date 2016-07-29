package org.grameenfoundation.fdp.ui;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.math.DoubleMath;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.smartstore.store.SmartStore;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.util.Constants;
import com.salesforce.androidsdk.ui.SalesforceActivity;

import org.grameenfoundation.fdp.MainActivity;
import org.grameenfoundation.fdp.R;
import org.grameenfoundation.fdp.loaders.ContactDetailLoader;
import org.grameenfoundation.fdp.loaders.ContactListLoader;
import org.grameenfoundation.fdp.objects.ContactObject;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * Created by julian_Gf on 7/4/2016.
 */
public class fdpActivity  extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {
    private static final int CONTACT_DETAIL_LOADER_ID = 2;
    private static final String TAG = "SmartSyncExplorer: fdpActivity";
    private UserAccount curAccount;
    private String objectId;
    private String objectTitle;
    private String objNameKey;
    private ContactObject sObject;
    public static final String OBJECT_ID_KEY = "object_id";
    public static final String OBJECT_TITLE_KEY = "object_title";
    public static final String OBJECT_NAME_KEY = "object_name";
    public static final String YEAR_LAUNCH = "year_launch";
    private Spinner st1,st2,st3,st4,st5;
    private TextView gaplp1,grflp1,replp1,exslp1,limlp1,dralp1,fillp1,lablp1,gaplp2,grflp2,replp2,exslp2,limlp2,dralp2,fillp2,lablp2,gaplp3,grflp3,replp3,exslp3,limlp3,dralp3,fillp3,lablp3,gaplp4,grflp4,replp4,exslp4,limlp4,dralp4,fillp4,lablp4,gaplp5,grflp5,replp5,exslp5,limlp5,dralp5,fillp5,lablp5;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fdp);
        final Intent launchIntent = getIntent();
        if (launchIntent != null) {
            objectId = launchIntent.getStringExtra(plotActivity.OBJECT_ID_KEY);
            objectTitle = launchIntent.getStringExtra(plotActivity.OBJECT_TITLE_KEY);
            objNameKey = launchIntent.getStringExtra(plotActivity.OBJECT_NAME_KEY);
        }
        st1 = (Spinner)findViewById(R.id.startP1_field);
        st2 = (Spinner)findViewById(R.id.startP2_field);
        st3 = (Spinner)findViewById(R.id.startP3_field);
        st4 = (Spinner)findViewById(R.id.startP4_field);
        st5 = (Spinner)findViewById(R.id.startP5_field);
        gaplp1 = (TextView)findViewById(R.id.gapLabelP1_field);
        grflp1 = (TextView)findViewById(R.id.graftLabelP1_field);
        replp1 = (TextView)findViewById(R.id.replantLabelP1_field);
        exslp1 = (TextView)findViewById(R.id.extraSoilLabelP1_field);
        limlp1 = (TextView)findViewById(R.id.limeLabelP1_field);
        dralp1 = (TextView)findViewById(R.id.drainageLabelP1_field);
        fillp1 = (TextView)findViewById(R.id.fillingLabelP1_field);
        lablp1 = (TextView)findViewById(R.id.laborLabelP1_field);
        gaplp2 = (TextView)findViewById(R.id.gapLabelP2_field);
        grflp2 = (TextView)findViewById(R.id.graftLabelP2_field);
        replp2 = (TextView)findViewById(R.id.replantLabelP2_field);
        exslp2 = (TextView)findViewById(R.id.extraSoilLabelP2_field);
        limlp2 = (TextView)findViewById(R.id.limeLabelP2_field);
        dralp2 = (TextView)findViewById(R.id.drainageLabelP2_field);
        fillp2 = (TextView)findViewById(R.id.fillingLabelP2_field);
        lablp2 = (TextView)findViewById(R.id.laborLabelP2_field);
        gaplp3 = (TextView)findViewById(R.id.gapLabelP3_field);
        grflp3 = (TextView)findViewById(R.id.graftLabelP3_field);
        replp3 = (TextView)findViewById(R.id.replantLabelP3_field);
        exslp3 = (TextView)findViewById(R.id.extraSoilLabelP3_field);
        limlp3 = (TextView)findViewById(R.id.limeLabelP3_field);
        dralp3 = (TextView)findViewById(R.id.drainageLabelP3_field);
        fillp3 = (TextView)findViewById(R.id.fillingLabelP3_field);
        lablp3 = (TextView)findViewById(R.id.laborLabelP3_field);
        gaplp4 = (TextView)findViewById(R.id.gapLabelP4_field);
        grflp4 = (TextView)findViewById(R.id.graftLabelP4_field);
        replp4 = (TextView)findViewById(R.id.replantLabelP4_field);
        exslp4 = (TextView)findViewById(R.id.extraSoilLabelP4_field);
        limlp4 = (TextView)findViewById(R.id.limeLabelP4_field);
        dralp4 = (TextView)findViewById(R.id.drainageLabelP4_field);
        fillp4 = (TextView)findViewById(R.id.fillingLabelP4_field);
        lablp4 = (TextView)findViewById(R.id.laborLabelP4_field);
        gaplp5 = (TextView)findViewById(R.id.gapLabelP5_field);
        grflp5 = (TextView)findViewById(R.id.graftLabelP5_field);
        replp5 = (TextView)findViewById(R.id.replantLabelP5_field);
        exslp5 = (TextView)findViewById(R.id.extraSoilLabelP5_field);
        limlp5 = (TextView)findViewById(R.id.limeLabelP5_field);
        dralp5 = (TextView)findViewById(R.id.drainageLabelP5_field);
        fillp5 = (TextView)findViewById(R.id.fillingLabelP5_field);
        lablp5 = (TextView)findViewById(R.id.laborLabelP5_field);
    }

    @Override
    public void onResume(RestClient client) {
        curAccount = SmartSyncSDKManager.getInstance().getUserAccountManager().getCurrentUser();
        getLoaderManager().initLoader(CONTACT_DETAIL_LOADER_ID, null, this).forceLoad();
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

    public void launchYear1(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "1");
        startActivity(yearIntent);
    }
    public void launchYear2(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "2");
        startActivity(yearIntent);
    }
    public void launchYear3(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "3");
        startActivity(yearIntent);
    }
    public void launchYear4(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "4");
        startActivity(yearIntent);
    }
    public void launchYear5(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "5");
        startActivity(yearIntent);
    }
    public void launchYear6(View view) {
        save();
        final Intent yearIntent = new Intent(this, YearDetailActivity.class);
        yearIntent.addCategory(Intent.CATEGORY_DEFAULT);
        yearIntent.putExtra(OBJECT_ID_KEY, sObject.getObjectId());
        yearIntent.putExtra(OBJECT_TITLE_KEY, sObject.getName());
        yearIntent.putExtra(OBJECT_NAME_KEY, sObject.getEmail());
        yearIntent.putExtra(YEAR_LAUNCH, "6");
        startActivity(yearIntent);
    }

    public void onFinishClicked(View view) {
        save();
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
    }

    private void refreshScreen() {
        if (sObject != null) {
            int est11 = 0;
            int est12 = 0;
            int est13 = 0;
            int est14 = 0;
            int est15 = 0;
            int est16 = 0;
            int est17 = 0;
            int est21 = 0;
            int est22 = 0;
            int est23 = 0;
            int est24 = 0;
            int est25 = 0;
            int est26 = 0;
            int est27 = 0;
            int est31 = 0;
            int est32 = 0;
            int est33 = 0;
            int est34 = 0;
            int est35 = 0;
            int est36 = 0;
            int est37 = 0;
            int est41 = 0;
            int est42 = 0;
            int est43 = 0;
            int est44 = 0;
            int est45 = 0;
            int est46 = 0;
            int est47 = 0;
            int est51 = 0;
            int est52 = 0;
            int est53 = 0;
            int est54 = 0;
            int est55 = 0;
            int est56 = 0;
            int est57 = 0;
            int replantingY1 = 450;
            int replantingY2 = 0;
            int replantingY3 = 250;
            int replantingY4 = 1000;
            int replantingY5 = 1500;
            int replantingY6 = 2000;
            int replantingY7 = 2000;
            int graftingY1 = 450;
            int graftingY2 = 500;
            int graftingY3 = 1500;
            int graftingY4 = 2000;
            int graftingY5 = 2000;
            int graftingY6 = 2000;
            int graftingY7 = 2000;
            int extraSoilY1 = 1000;
            int extraSoilY2 = 1500;
            int extraSoilY3 = 2000;
            int extraSoilY4 = 2000;
            int extraSoilY5 = 2000;
            int extraSoilY6 = 2000;
            int extraSoilY7 = 2000;
            int gapsY1 = 2000;
            int gapsY2 = 2000;
            int gapsY3 = 2000;
            int gapsY4 = 2000;
            int gapsY5 = 2000;
            int gapsY6 = 2000;
            int gapsY7 = 2000;

            double plot1Area = Double.valueOf(sObject.getPlot1Area().toString());
            double plot2Area = Double.valueOf(sObject.getPlot2Area().toString());
            double plot3Area = Double.valueOf(sObject.getPlot3Area().toString());
            double plot4Area = Double.valueOf(sObject.getPlot4Area().toString());
            double plot5Area = Double.valueOf(sObject.getPlot5Area().toString());
            if (sObject.getFarmCondition1().equals("N/A") || sObject.getTreeDensity1().equals("N/A") || sObject.getDebilitatingDisease1().equals("N/A")|| sObject.getPlantingMaterial1().equals("N/A")){
                replp1.setVisibility(View.GONE);
                gaplp1.setVisibility(View.GONE);
                dralp1.setVisibility(View.GONE);
                grflp1.setVisibility(View.GONE);
                lablp1.setVisibility(View.GONE);
                limlp1.setVisibility(View.GONE);
                fillp1.setVisibility(View.GONE);
                exslp1.setVisibility(View.GONE);
            }else if (sObject.getFarmCondition1().equals("B") || sObject.getTreeDensity1().equals("B") || sObject.getDebilitatingDisease1().equals("B")) {
                //Replanting
                replp1.setVisibility(View.VISIBLE);
                int rep1P1 = (int) (plot1Area * 21372000);
                int rep2P1 = (int) (plot1Area * 19753000);
                int rep3P1 = (int) (plot1Area * 20640500);
                int rep4P1 = (int) (plot1Area * 23622000);
                est11 = (int)(plot1Area*replantingY1);
                est12 = (int)(plot1Area*replantingY2);
                est13 = (int)(plot1Area*replantingY3);
                est14 = (int)(plot1Area*replantingY4);
                est15 = (int)(plot1Area*replantingY5);
                est16 = (int)(plot1Area*replantingY6);
                est17 = (int)(plot1Area*replantingY7);

                setText2((TextView) findViewById(R.id.gapP1Y1_field), String.valueOf(rep1P1));
                setText2((TextView) findViewById(R.id.gapP1Y2_field), String.valueOf(rep2P1));
                setText2((TextView) findViewById(R.id.gapP1Y3_field), String.valueOf(rep3P1));
                setText2((TextView) findViewById(R.id.gapP1Y4_field), String.valueOf(rep4P1));
                setText2((TextView) findViewById(R.id.gapP1Y5_field), String.valueOf(rep4P1));
                setText2((TextView) findViewById(R.id.gapP1Y6_field), String.valueOf(rep4P1));
                setText2((TextView) findViewById(R.id.gapP1Y7_field), String.valueOf(rep4P1));
                if (sObject.getHireLabor1().equals("Yes")) {
                    lablp1.setVisibility(View.VISIBLE);
                    int labRep1P1 = (int) (plot1Area * 12150000);
                    int labRep2P1 = (int) (plot1Area * 6375000);
                    int labRep3P1 = (int) (plot1Area * 6975000);
                    int labRep4P1 = (int) (plot1Area * 11250000);
                    int labRep5P1 = (int) (plot1Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP1Y1_field), String.valueOf(labRep1P1));
                    setText2((TextView) findViewById(R.id.laborP1Y2_field), String.valueOf(labRep2P1));
                    setText2((TextView) findViewById(R.id.laborP1Y3_field), String.valueOf(labRep3P1));
                    setText2((TextView) findViewById(R.id.laborP1Y4_field), String.valueOf(labRep4P1));
                    setText2((TextView) findViewById(R.id.laborP1Y5_field), String.valueOf(labRep5P1));
                    setText2((TextView) findViewById(R.id.laborP1Y6_field), String.valueOf(labRep5P1));
                    setText2((TextView) findViewById(R.id.laborP1Y7_field), String.valueOf(labRep5P1));
                }
                if (sObject.getLimeNeed1().equals("Yes")||sObject.getDrainageNeed1().equals("Yes")) {
                    limlp1.setVisibility(View.VISIBLE);
                    int drafRep1P1 = (int) (plot1Area * 2250000);
                    int limRep1P1 = (int) (plot1Area* 925000);
                    int otherinter = drafRep1P1+limRep1P1;
                    setText2((TextView) findViewById(R.id.limeP1Y1_field), String.valueOf(otherinter));
                    setText2((TextView) findViewById(R.id.limeP1Y2_field), "0");
                    setText2((TextView) findViewById(R.id.limeP1Y3_field), "0");
                    setText2((TextView) findViewById(R.id.limeP1Y4_field), "0");
                    setText2((TextView) findViewById(R.id.limeP1Y5_field), "0");
                    setText2((TextView) findViewById(R.id.limeP1Y6_field), "0");
                    setText2((TextView) findViewById(R.id.limeP1Y7_field), "0");
                }
                if (sObject.getFillingOption1().equals("Yes")) {
                    fillp1.setVisibility(View.VISIBLE);
                }
                if (sObject.getDrainageNeed1().equals("Yes")) {
                    dralp1.setVisibility(View.VISIBLE);
                }
                exslp1.setVisibility(View.GONE);
                gaplp1.setVisibility(View.GONE);
                grflp1.setVisibility(View.GONE);
            } else if (sObject.getTreeHealth1().equals("G")&&(sObject.getPlantingMaterial1().equals("M")||sObject.getPlantingMaterial1().equals("B"))&&(sObject.getTreeAge1().equals("G")||sObject.getTreeAge1().equals("B"))) {
                //Grafting
                grflp1.setVisibility(View.VISIBLE);
                int graf1P1 = (int) (plot1Area * 23467500);
                int graf2P1 = (int) (plot1Area * 22358500);
                int graf3P1 = (int) (plot1Area * 23722000);
                int graf4P1 = (int) (plot1Area * 23622000);
                est11 = (int)(plot1Area*graftingY1);
                est12 = (int)(plot1Area*graftingY2);
                est13 = (int)(plot1Area*graftingY3);
                est14 = (int)(plot1Area*graftingY4);
                est15 = (int)(plot1Area*graftingY5);
                est16 = (int)(plot1Area*graftingY6);
                est17 = (int)(plot1Area*graftingY7);
                setText2((TextView) findViewById(R.id.gapP1Y1_field), String.valueOf(graf1P1));
                setText2((TextView) findViewById(R.id.gapP1Y2_field), String.valueOf(graf2P1));
                setText2((TextView) findViewById(R.id.gapP1Y3_field), String.valueOf(graf3P1));
                setText2((TextView) findViewById(R.id.gapP1Y4_field), String.valueOf(graf4P1));
                setText2((TextView) findViewById(R.id.gapP1Y5_field), String.valueOf(graf4P1));
                setText2((TextView) findViewById(R.id.gapP1Y6_field), String.valueOf(graf4P1));
                setText2((TextView) findViewById(R.id.gapP1Y7_field), String.valueOf(graf4P1));
                if (sObject.getHireLabor1().equals("Yes")) {
                    lablp1.setVisibility(View.VISIBLE);
                    int laborGraf1P1 = (int) (plot1Area * 12000000);
                    int laborGraf2P1 = (int) (plot1Area * 7200000);
                    int laborGraf3P1 = (int) (plot1Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP1Y1_field), String.valueOf(laborGraf1P1));
                    setText2((TextView) findViewById(R.id.laborP1Y2_field), String.valueOf(laborGraf2P1));
                    setText2((TextView) findViewById(R.id.laborP1Y3_field), String.valueOf(laborGraf3P1));
                    setText2((TextView) findViewById(R.id.laborP1Y4_field), String.valueOf(laborGraf3P1));
                    setText2((TextView) findViewById(R.id.laborP1Y5_field), String.valueOf(laborGraf3P1));
                    setText2((TextView) findViewById(R.id.laborP1Y6_field), String.valueOf(laborGraf3P1));
                    setText2((TextView) findViewById(R.id.laborP1Y7_field), String.valueOf(laborGraf3P1));
                }
                if (sObject.getFillingOption1().equals("Yes")) {
                    fillp1.setVisibility(View.VISIBLE);
                }
                exslp1.setVisibility(View.GONE);
                replp1.setVisibility(View.GONE);
                gaplp1.setVisibility(View.GONE);
                limlp1.setVisibility(View.GONE);
                dralp1.setVisibility(View.GONE);
            } else if ((sObject.getPlantingMaterial1().equals("G") || sObject.getPlantingMaterial1().equals("M")) && sObject.getFarmCondition1().equals("G") && sObject.getTreeDensity1().equals("G") && sObject.getTreeAge1().equals("G") && sObject.getTreeHealth1().equals("G") && sObject.getDebilitatingDisease1().equals("G") && (sObject.getPruning1().equals("G") || sObject.getPruning1().equals("M")) && (sObject.getPestDiseaseSanitation1().equals("G") || sObject.getPestDiseaseSanitation1().equals("M")) && sObject.getWeeding1().equals("G") && sObject.getHarvesting1().equals("G") && sObject.getShadeManagement1().equals("G") && sObject.getSoilCondition1().equals("B") || sObject.getOrganicMatter1().equals("B") || sObject.getFertilizerFormulation1().equals("B") || sObject.getFertilizerApplication1().equals("B")) {
                 //Extra Soil Management
                 exslp1.setVisibility(View.VISIBLE);
                 int eSoil1P1 = (int) (plot1Area * 24622000);
                est11 = (int)(plot1Area*extraSoilY1);
                est12 = (int)(plot1Area*extraSoilY2);
                est13 = (int)(plot1Area*extraSoilY3);
                est14 = (int)(plot1Area*extraSoilY4);
                est15 = (int)(plot1Area*extraSoilY5);
                est16 = (int)(plot1Area*extraSoilY6);
                est17 = (int)(plot1Area*extraSoilY7);
                 setText2((TextView) findViewById(R.id.gapP1Y1_field), String.valueOf(eSoil1P1));
                 setText2((TextView) findViewById(R.id.gapP1Y2_field), String.valueOf(eSoil1P1));
                 setText2((TextView) findViewById(R.id.gapP1Y3_field), String.valueOf(eSoil1P1));
                 setText2((TextView) findViewById(R.id.gapP1Y4_field), String.valueOf(eSoil1P1));
                 setText2((TextView) findViewById(R.id.gapP1Y5_field), String.valueOf(eSoil1P1));
                 setText2((TextView) findViewById(R.id.gapP1Y6_field), String.valueOf(eSoil1P1));
                 setText2((TextView) findViewById(R.id.gapP1Y7_field), String.valueOf(eSoil1P1));
                 if (sObject.getHireLabor1().equals("Yes")) {
                     lablp1.setVisibility(View.VISIBLE);
                     int laborS1P1 = (int) (plot1Area * 12825000);
                     int laborS2P1 = (int) (plot1Area * 13425000);
                     int laborS3P1 = (int) (plot1Area * 12075000);
                     setText2((TextView) findViewById(R.id.laborP1Y1_field), String.valueOf(laborS1P1));
                     setText2((TextView) findViewById(R.id.laborP1Y2_field), String.valueOf(laborS1P1));
                     setText2((TextView) findViewById(R.id.laborP1Y3_field), String.valueOf(laborS2P1));
                     setText2((TextView) findViewById(R.id.laborP1Y4_field), String.valueOf(laborS3P1));
                     setText2((TextView) findViewById(R.id.laborP1Y5_field), String.valueOf(laborS3P1));
                     setText2((TextView) findViewById(R.id.laborP1Y6_field), String.valueOf(laborS3P1));
                     setText2((TextView) findViewById(R.id.laborP1Y7_field), String.valueOf(laborS3P1));
                 }
                 if (sObject.getLimeNeed1().equals("Yes")) {
                     limlp1.setVisibility(View.VISIBLE);
                     int lime1P1 = (int) (plot1Area * 1850000);
                     setText2((TextView) findViewById(R.id.limeP1Y1_field), String.valueOf(lime1P1));
                     setText2((TextView) findViewById(R.id.limeP1Y2_field), String.valueOf(lime1P1));
                     setText2((TextView) findViewById(R.id.limeP1Y3_field), "0");
                     setText2((TextView) findViewById(R.id.limeP1Y4_field), "0");
                     setText2((TextView) findViewById(R.id.limeP1Y5_field), "0");
                     setText2((TextView) findViewById(R.id.limeP1Y6_field), "0");
                     setText2((TextView) findViewById(R.id.limeP1Y7_field), "0");
                 }
                 if (sObject.getFillingOption1().equals("Yes")) {
                     fillp1.setVisibility(View.VISIBLE);
                 }
                 replp1.setVisibility(View.GONE);
                 gaplp1.setVisibility(View.GONE);
                 dralp1.setVisibility(View.GONE);
                 grflp1.setVisibility(View.GONE);
             } else {
                //GAPS
                gaplp1.setVisibility(View.VISIBLE);
                int gapresultP1 = (int) (plot1Area * 23622000);
                est11 = (int)(plot1Area*gapsY1);
                est12 = (int)(plot1Area*gapsY2);
                est13 = (int)(plot1Area*gapsY3);
                est14 = (int)(plot1Area*gapsY4);
                est15 = (int)(plot1Area*gapsY5);
                est16 = (int)(plot1Area*gapsY6);
                est17 = (int)(plot1Area*gapsY7);
                setText2((TextView) findViewById(R.id.gapP1Y1_field), String.valueOf(gapresultP1));
                setText2((TextView) findViewById(R.id.gapP1Y2_field), String.valueOf(gapresultP1));
                setText2((TextView) findViewById(R.id.gapP1Y3_field), String.valueOf(gapresultP1));
                setText2((TextView) findViewById(R.id.gapP1Y4_field), String.valueOf(gapresultP1));
                setText2((TextView) findViewById(R.id.gapP1Y5_field), String.valueOf(gapresultP1));
                setText2((TextView) findViewById(R.id.gapP1Y6_field), String.valueOf(gapresultP1));
                setText2((TextView) findViewById(R.id.gapP1Y7_field), String.valueOf(gapresultP1));
                if (sObject.getHireLabor1().equals("Yes")) {
                    lablp1.setVisibility(View.VISIBLE);
                    int labor1P1 = (int) (plot1Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP1Y1_field), String.valueOf(labor1P1));
                    setText2((TextView) findViewById(R.id.laborP1Y2_field), String.valueOf(labor1P1));
                    setText2((TextView) findViewById(R.id.laborP1Y3_field), String.valueOf(labor1P1));
                    setText2((TextView) findViewById(R.id.laborP1Y4_field), String.valueOf(labor1P1));
                    setText2((TextView) findViewById(R.id.laborP1Y5_field), String.valueOf(labor1P1));
                    setText2((TextView) findViewById(R.id.laborP1Y6_field), String.valueOf(labor1P1));
                    setText2((TextView) findViewById(R.id.laborP1Y7_field), String.valueOf(labor1P1));
                }
                if (sObject.getFillingOption1().equals("Yes")) {
                    fillp1.setVisibility(View.VISIBLE);
                }
                replp1.setVisibility(View.GONE);
                exslp1.setVisibility(View.GONE);
                limlp1.setVisibility(View.GONE);
                dralp1.setVisibility(View.GONE);
                grflp1.setVisibility(View.GONE);
            }
            //end plot
            if (sObject.getFarmCondition2().equals("N/A") || sObject.getTreeDensity2().equals("N/A") || sObject.getDebilitatingDisease2().equals("N/A")|| sObject.getPlantingMaterial2().equals("N/A")){
                replp2.setVisibility(View.GONE);
                gaplp2.setVisibility(View.GONE);
                dralp2.setVisibility(View.GONE);
                grflp2.setVisibility(View.GONE);
                lablp2.setVisibility(View.GONE);
                limlp2.setVisibility(View.GONE);
                fillp2.setVisibility(View.GONE);
                exslp2.setVisibility(View.GONE);
            }else if (sObject.getFarmCondition2().equals("B") || sObject.getTreeDensity2().equals("B") || sObject.getDebilitatingDisease2().equals("B")) {
                //Replanting
                replp2.setVisibility(View.VISIBLE);
                int rep1P2 = (int) (plot2Area * 21372000);
                int rep2P2 = (int) (plot2Area * 19753000);
                int rep3P2 = (int) (plot2Area * 20640500);
                int rep4P2 = (int) (plot2Area * 23622000);
                est21 = (int)(plot2Area*replantingY1);
                est22 = (int)(plot2Area*replantingY2);
                est23 = (int)(plot2Area*replantingY3);
                est24 = (int)(plot2Area*replantingY4);
                est25 = (int)(plot2Area*replantingY5);
                est26 = (int)(plot2Area*replantingY6);
                est27 = (int)(plot2Area*replantingY7);
                setText2((TextView) findViewById(R.id.gapP2Y1_field), String.valueOf(rep1P2));
                setText2((TextView) findViewById(R.id.gapP2Y2_field), String.valueOf(rep2P2));
                setText2((TextView) findViewById(R.id.gapP2Y3_field), String.valueOf(rep3P2));
                setText2((TextView) findViewById(R.id.gapP2Y4_field), String.valueOf(rep4P2));
                setText2((TextView) findViewById(R.id.gapP2Y5_field), String.valueOf(rep4P2));
                setText2((TextView) findViewById(R.id.gapP2Y6_field), String.valueOf(rep4P2));
                setText2((TextView) findViewById(R.id.gapP2Y7_field), String.valueOf(rep4P2));
                if (sObject.getHireLabor2().equals("Yes")) {
                    lablp2.setVisibility(View.VISIBLE);
                    int labRep1P2 = (int) (plot2Area * 12150000);
                    int labRep2P2 = (int) (plot2Area* 6375000);
                    int labRep3P2 = (int) (plot2Area * 6975000);
                    int labRep4P2 = (int) (plot2Area * 11250000);
                    int labRep5P2 = (int) (plot2Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP2Y1_field), String.valueOf(labRep1P2));
                    setText2((TextView) findViewById(R.id.laborP2Y2_field), String.valueOf(labRep2P2));
                    setText2((TextView) findViewById(R.id.laborP2Y3_field), String.valueOf(labRep3P2));
                    setText2((TextView) findViewById(R.id.laborP2Y4_field), String.valueOf(labRep4P2));
                    setText2((TextView) findViewById(R.id.laborP2Y5_field), String.valueOf(labRep5P2));
                    setText2((TextView) findViewById(R.id.laborP2Y6_field), String.valueOf(labRep5P2));
                    setText2((TextView) findViewById(R.id.laborP2Y7_field), String.valueOf(labRep5P2));
                }
                if (sObject.getLimeNeed2().equals("Yes")||sObject.getDrainageNeed2().equals("Yes")) {
                    limlp2.setVisibility(View.VISIBLE);
                    int limRep1P2 = (int) (plot2Area * 925000);
                    int drafRep1P2 = (int) (plot2Area * 2250000);
                    int totalOtherp2 = limRep1P2+drafRep1P2;
                    setText2((TextView) findViewById(R.id.limeP2Y1_field), String.valueOf(totalOtherp2));
                    setText2((TextView) findViewById(R.id.limeP2Y2_field), "0");
                    setText2((TextView) findViewById(R.id.limeP2Y3_field), "0");
                    setText2((TextView) findViewById(R.id.limeP2Y4_field), "0");
                    setText2((TextView) findViewById(R.id.limeP2Y5_field), "0");
                    setText2((TextView) findViewById(R.id.limeP2Y6_field), "0");
                    setText2((TextView) findViewById(R.id.limeP2Y7_field), "0");
                }
                if (sObject.getFillingOption2().equals("Yes")) {
                    fillp2.setVisibility(View.VISIBLE);
                }

                if (sObject.getDrainageNeed2().equals("Yes")) {
                    dralp2.setVisibility(View.VISIBLE);
                }
                exslp2.setVisibility(View.GONE);
                gaplp2.setVisibility(View.GONE);
                grflp2.setVisibility(View.GONE);
            } else if (sObject.getTreeHealth2().equals("G")&&(sObject.getPlantingMaterial2().equals("M")||sObject.getPlantingMaterial2().equals("B"))&&(sObject.getTreeAge2().equals("G")||sObject.getTreeAge2().equals("B"))) {
                //Grafting
                grflp2.setVisibility(View.VISIBLE);
                int graf1P2 = (int) (plot2Area * 23467500);
                int graf2P2 = (int) (plot2Area * 22358500);
                int graf3P2 = (int) (plot2Area * 23722000);
                int graf4P2 = (int) (plot2Area * 23622000);
                est21 = (int)(plot2Area*graftingY1);
                est22 = (int)(plot2Area*graftingY2);
                est23 = (int)(plot2Area*graftingY3);
                est24 = (int)(plot2Area*graftingY4);
                est25 = (int)(plot2Area*graftingY5);
                est26 = (int)(plot2Area*graftingY6);
                est27 = (int)(plot2Area*graftingY7);
                setText2((TextView) findViewById(R.id.gapP2Y1_field), String.valueOf(graf1P2));
                setText2((TextView) findViewById(R.id.gapP2Y2_field), String.valueOf(graf2P2));
                setText2((TextView) findViewById(R.id.gapP2Y3_field), String.valueOf(graf3P2));
                setText2((TextView) findViewById(R.id.gapP2Y4_field), String.valueOf(graf4P2));
                setText2((TextView) findViewById(R.id.gapP2Y5_field), String.valueOf(graf4P2));
                setText2((TextView) findViewById(R.id.gapP2Y6_field), String.valueOf(graf4P2));
                setText2((TextView) findViewById(R.id.gapP2Y7_field), String.valueOf(graf4P2));
                if (sObject.getHireLabor2().equals("Yes")) {
                    lablp2.setVisibility(View.VISIBLE);
                    int laborGraf1P2 = (int) (plot2Area * 12000000);
                    int laborGraf2P2 = (int) (plot2Area * 7200000);
                    int laborGraf3P2 = (int) (plot2Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP2Y1_field), String.valueOf(laborGraf1P2));
                    setText2((TextView) findViewById(R.id.laborP2Y2_field), String.valueOf(laborGraf2P2));
                    setText2((TextView) findViewById(R.id.laborP2Y3_field), String.valueOf(laborGraf3P2));
                    setText2((TextView) findViewById(R.id.laborP2Y4_field), String.valueOf(laborGraf3P2));
                    setText2((TextView) findViewById(R.id.laborP2Y5_field), String.valueOf(laborGraf3P2));
                    setText2((TextView) findViewById(R.id.laborP2Y6_field), String.valueOf(laborGraf3P2));
                    setText2((TextView) findViewById(R.id.laborP2Y7_field), String.valueOf(laborGraf3P2));
                }
                if (sObject.getFillingOption2().equals("Yes")) {
                    fillp2.setVisibility(View.VISIBLE);
                }
                exslp2.setVisibility(View.GONE);
                replp2.setVisibility(View.GONE);
                gaplp2.setVisibility(View.GONE);
                limlp2.setVisibility(View.GONE);
                dralp2.setVisibility(View.GONE);
            } else if ((sObject.getPlantingMaterial2().equals("G") || sObject.getPlantingMaterial2().equals("M")) && sObject.getFarmCondition2().equals("G") && sObject.getTreeDensity2().equals("G") && sObject.getTreeAge2().equals("G") && sObject.getTreeHealth2().equals("G") && sObject.getDebilitatingDisease2().equals("G") && (sObject.getPruning2().equals("G") || sObject.getPruning2().equals("M")) && (sObject.getPestDiseaseSanitation2().equals("G") || sObject.getPestDiseaseSanitation2().equals("M")) && sObject.getWeeding2().equals("G") && sObject.getHarvesting2().equals("G") && sObject.getShadeManagement2().equals("G") && sObject.getSoilCondition2().equals("B") || sObject.getOrganicMatter2().equals("B") || sObject.getFertilizerFormulation2().equals("B") || sObject.getFartilizerApplication2().equals("B")) {
                 //Extra Soil Management
                 exslp2.setVisibility(View.VISIBLE);
                 int eSoil1P2 = (int) (plot2Area * 24622000);
                est21 = (int)(plot2Area*extraSoilY1);
                est22 = (int)(plot2Area*extraSoilY2);
                est23 = (int)(plot2Area*extraSoilY3);
                est24 = (int)(plot2Area*extraSoilY4);
                est25 = (int)(plot2Area*extraSoilY5);
                est26 = (int)(plot2Area*extraSoilY6);
                est27 = (int)(plot2Area*extraSoilY7);

                 setText2((TextView) findViewById(R.id.gapP2Y1_field), String.valueOf(eSoil1P2));
                 setText2((TextView) findViewById(R.id.gapP2Y2_field), String.valueOf(eSoil1P2));
                 setText2((TextView) findViewById(R.id.gapP2Y3_field), String.valueOf(eSoil1P2));
                 setText2((TextView) findViewById(R.id.gapP2Y4_field), String.valueOf(eSoil1P2));
                 setText2((TextView) findViewById(R.id.gapP2Y5_field), String.valueOf(eSoil1P2));
                 setText2((TextView) findViewById(R.id.gapP2Y6_field), String.valueOf(eSoil1P2));
                 setText2((TextView) findViewById(R.id.gapP2Y7_field), String.valueOf(eSoil1P2));
                 if (sObject.getHireLabor2().equals("Yes")) {
                     lablp2.setVisibility(View.VISIBLE);
                     int laborS1P2 = (int) (plot2Area* 12825000);
                     int laborS2P2 = (int) (plot2Area * 13425000);
                     int laborS3P2 = (int) (plot2Area * 12075000);
                     setText2((TextView) findViewById(R.id.laborP2Y1_field), String.valueOf(laborS1P2));
                     setText2((TextView) findViewById(R.id.laborP2Y2_field), String.valueOf(laborS1P2));
                     setText2((TextView) findViewById(R.id.laborP2Y3_field), String.valueOf(laborS2P2));
                     setText2((TextView) findViewById(R.id.laborP2Y4_field), String.valueOf(laborS3P2));
                     setText2((TextView) findViewById(R.id.laborP2Y5_field), String.valueOf(laborS3P2));
                     setText2((TextView) findViewById(R.id.laborP2Y6_field), String.valueOf(laborS3P2));
                     setText2((TextView) findViewById(R.id.laborP2Y7_field), String.valueOf(laborS3P2));
                 }
                 if (sObject.getLimeNeed2().equals("Yes")) {
                     limlp2.setVisibility(View.VISIBLE);
                     int lime1P2 = (int) (plot2Area * 1850000);
                     setText2((TextView) findViewById(R.id.limeP2Y1_field), String.valueOf(lime1P2));
                     setText2((TextView) findViewById(R.id.limeP2Y2_field), String.valueOf(lime1P2));
                     setText2((TextView) findViewById(R.id.limeP2Y3_field), "0");
                     setText2((TextView) findViewById(R.id.limeP2Y4_field), "0");
                     setText2((TextView) findViewById(R.id.limeP2Y5_field), "0");
                     setText2((TextView) findViewById(R.id.limeP2Y6_field), "0");
                     setText2((TextView) findViewById(R.id.limeP2Y7_field), "0");
                 }
                 if (sObject.getFillingOption2().equals("Yes")) {
                     fillp2.setVisibility(View.VISIBLE);
                 }
                 replp2.setVisibility(View.GONE);
                 gaplp2.setVisibility(View.GONE);
                 dralp2.setVisibility(View.GONE);
                 grflp2.setVisibility(View.GONE);
             } else {
                //GAPS
                gaplp2.setVisibility(View.VISIBLE);
                int gapresultP2 = (int) (plot2Area * 23622000);
                est21 = (int)(plot2Area*gapsY1);
                est22 = (int)(plot2Area*gapsY2);
                est23 = (int)(plot2Area*gapsY3);
                est24 = (int)(plot2Area*gapsY4);
                est25 = (int)(plot2Area*gapsY5);
                est26 = (int)(plot2Area*gapsY6);
                est27 = (int)(plot2Area*gapsY7);
                setText2((TextView) findViewById(R.id.gapP2Y1_field), String.valueOf(gapresultP2));
                setText2((TextView) findViewById(R.id.gapP2Y2_field), String.valueOf(gapresultP2));
                setText2((TextView) findViewById(R.id.gapP2Y3_field), String.valueOf(gapresultP2));
                setText2((TextView) findViewById(R.id.gapP2Y4_field), String.valueOf(gapresultP2));
                setText2((TextView) findViewById(R.id.gapP2Y5_field), String.valueOf(gapresultP2));
                setText2((TextView) findViewById(R.id.gapP2Y6_field), String.valueOf(gapresultP2));
                setText2((TextView) findViewById(R.id.gapP2Y7_field), String.valueOf(gapresultP2));
                if (sObject.getHireLabor2().equals("Yes")) {
                    lablp2.setVisibility(View.VISIBLE);
                    int labor1P2 = (int) (plot2Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP2Y1_field), String.valueOf(labor1P2));
                    setText2((TextView) findViewById(R.id.laborP2Y2_field), String.valueOf(labor1P2));
                    setText2((TextView) findViewById(R.id.laborP2Y3_field), String.valueOf(labor1P2));
                    setText2((TextView) findViewById(R.id.laborP2Y4_field), String.valueOf(labor1P2));
                    setText2((TextView) findViewById(R.id.laborP2Y5_field), String.valueOf(labor1P2));
                    setText2((TextView) findViewById(R.id.laborP2Y6_field), String.valueOf(labor1P2));
                    setText2((TextView) findViewById(R.id.laborP2Y7_field), String.valueOf(labor1P2));
                }
                if (sObject.getFillingOption2().equals("Yes")) {
                    fillp2.setVisibility(View.VISIBLE);
                }
                replp2.setVisibility(View.GONE);
                exslp2.setVisibility(View.GONE);
                limlp2.setVisibility(View.GONE);
                dralp2.setVisibility(View.GONE);
                grflp2.setVisibility(View.GONE);
            }
            //end plot
            if (sObject.getFarmCondition3().equals("N/A") || sObject.getTreeDensity3().equals("N/A") || sObject.getDebilitatingDisease3().equals("N/A")|| sObject.getPlantingMaterial3().equals("N/A")){
                replp3.setVisibility(View.GONE);
                gaplp3.setVisibility(View.GONE);
                dralp3.setVisibility(View.GONE);
                grflp3.setVisibility(View.GONE);
                lablp3.setVisibility(View.GONE);
                limlp3.setVisibility(View.GONE);
                fillp3.setVisibility(View.GONE);
                exslp3.setVisibility(View.GONE);
            }else if (sObject.getFarmCondition3().equals("B") || sObject.getTreeDensity3().equals("B") || sObject.getDebilitatingDisease3().equals("B")) {
                //Replanting
                replp3.setVisibility(View.VISIBLE);
                int rep1P3 = (int) (plot3Area * 21372000);
                int rep2P3 = (int) (plot3Area * 19753000);
                int rep3P3 = (int) (plot3Area * 20640500);
                int rep4P3 = (int) (plot3Area * 23622000);
                est31 = (int)(plot3Area*replantingY1);
                est32 = (int)(plot3Area*replantingY2);
                est33 = (int)(plot3Area*replantingY3);
                est34 = (int)(plot3Area*replantingY4);
                est35 = (int)(plot3Area*replantingY5);
                est36 = (int)(plot3Area*replantingY6);
                est37 = (int)(plot3Area*replantingY7);
                setText2((TextView) findViewById(R.id.gapP3Y1_field), String.valueOf(rep1P3));
                setText2((TextView) findViewById(R.id.gapP3Y2_field), String.valueOf(rep2P3));
                setText2((TextView) findViewById(R.id.gapP3Y3_field), String.valueOf(rep3P3));
                setText2((TextView) findViewById(R.id.gapP3Y4_field), String.valueOf(rep4P3));
                setText2((TextView) findViewById(R.id.gapP3Y5_field), String.valueOf(rep4P3));
                setText2((TextView) findViewById(R.id.gapP3Y6_field), String.valueOf(rep4P3));
                setText2((TextView) findViewById(R.id.gapP3Y7_field), String.valueOf(rep4P3));
                if (sObject.getHireLabor3().equals("Yes")) {
                    lablp3.setVisibility(View.VISIBLE);
                    int labRep1P3 = (int) (plot3Area * 12150000);
                    int labRep2P3 = (int) (plot3Area * 6375000);
                    int labRep3P3 = (int) (plot3Area * 6975000);
                    int labRep4P3 = (int) (plot3Area * 11250000);
                    int labRep5P3 = (int) (plot3Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP3Y1_field), String.valueOf(labRep1P3));
                    setText2((TextView) findViewById(R.id.laborP3Y2_field), String.valueOf(labRep2P3));
                    setText2((TextView) findViewById(R.id.laborP3Y3_field), String.valueOf(labRep3P3));
                    setText2((TextView) findViewById(R.id.laborP3Y4_field), String.valueOf(labRep4P3));
                    setText2((TextView) findViewById(R.id.laborP3Y5_field), String.valueOf(labRep5P3));
                    setText2((TextView) findViewById(R.id.laborP3Y6_field), String.valueOf(labRep5P3));
                    setText2((TextView) findViewById(R.id.laborP3Y7_field), String.valueOf(labRep5P3));
                }
                if (sObject.getDrainageNeed3().equals("Yes")) {
                    dralp3.setVisibility(View.VISIBLE);
                }
                if (sObject.getLimeNeed3().equals("Yes")||sObject.getDrainageNeed3().equals("Yes")) {
                    limlp3.setVisibility(View.VISIBLE);
                    int drafRep1P3 = (int) (plot3Area * 2250000);
                    int limRep1P3 = (int) (plot3Area * 925000);
                    int totalOtherP3 = drafRep1P3+limRep1P3;
                    setText2((TextView) findViewById(R.id.limeP3Y1_field), String.valueOf(totalOtherP3));
                    setText2((TextView) findViewById(R.id.limeP3Y2_field), "0");
                    setText2((TextView) findViewById(R.id.limeP3Y3_field), "0");
                    setText2((TextView) findViewById(R.id.limeP3Y4_field), "0");
                    setText2((TextView) findViewById(R.id.limeP3Y5_field), "0");
                    setText2((TextView) findViewById(R.id.limeP3Y6_field), "0");
                    setText2((TextView) findViewById(R.id.limeP3Y7_field), "0");
                }
                if (sObject.getFillingOption3().equals("Yes")) {
                    fillp3.setVisibility(View.VISIBLE);
                }
                exslp3.setVisibility(View.GONE);
                gaplp3.setVisibility(View.GONE);
                grflp3.setVisibility(View.GONE);
            } else if (sObject.getTreeHealth3().equals("G")&&(sObject.getPlantingMaterial3().equals("M")||sObject.getPlantingMaterial3().equals("B"))&&(sObject.getTreeAge3().equals("G")||sObject.getTreeAge3().equals("B"))) {
                //Grafting
                grflp3.setVisibility(View.VISIBLE);
                int graf1P3 = (int) (plot3Area* 23467500);
                int graf2P3 = (int) (plot3Area * 22358500);
                int graf3P3 = (int) (plot3Area * 23722000);
                int graf4P3 = (int) (plot3Area * 23622000);
                est31 = (int)(plot3Area*graftingY1);
                est32 = (int)(plot3Area*graftingY2);
                est33 = (int)(plot3Area*graftingY3);
                est34 = (int)(plot3Area*graftingY4);
                est35 = (int)(plot3Area*graftingY5);
                est36 = (int)(plot3Area*graftingY6);
                est37 = (int)(plot3Area*graftingY7);
                setText2((TextView) findViewById(R.id.gapP3Y1_field), String.valueOf(graf1P3));
                setText2((TextView) findViewById(R.id.gapP3Y2_field), String.valueOf(graf2P3));
                setText2((TextView) findViewById(R.id.gapP3Y3_field), String.valueOf(graf3P3));
                setText2((TextView) findViewById(R.id.gapP3Y4_field), String.valueOf(graf4P3));
                setText2((TextView) findViewById(R.id.gapP3Y5_field), String.valueOf(graf4P3));
                setText2((TextView) findViewById(R.id.gapP3Y6_field), String.valueOf(graf4P3));
                setText2((TextView) findViewById(R.id.gapP3Y7_field), String.valueOf(graf4P3));
                if (sObject.getHireLabor3().equals("Yes")) {
                    lablp3.setVisibility(View.VISIBLE);
                    int laborGraf1P3 = (int) (plot3Area * 12000000);
                    int laborGraf2P3 = (int) (plot3Area * 7200000);
                    int laborGraf3P3 = (int) (plot3Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP3Y1_field), String.valueOf(laborGraf1P3));
                    setText2((TextView) findViewById(R.id.laborP3Y2_field), String.valueOf(laborGraf2P3));
                    setText2((TextView) findViewById(R.id.laborP3Y3_field), String.valueOf(laborGraf3P3));
                    setText2((TextView) findViewById(R.id.laborP3Y4_field), String.valueOf(laborGraf3P3));
                    setText2((TextView) findViewById(R.id.laborP3Y5_field), String.valueOf(laborGraf3P3));
                    setText2((TextView) findViewById(R.id.laborP3Y6_field), String.valueOf(laborGraf3P3));
                    setText2((TextView) findViewById(R.id.laborP3Y7_field), String.valueOf(laborGraf3P3));
                }
                if (sObject.getFillingOption3().equals("Yes")) {
                    fillp3.setVisibility(View.VISIBLE);
                }
                exslp3.setVisibility(View.GONE);
                replp3.setVisibility(View.GONE);
                gaplp3.setVisibility(View.GONE);
                limlp3.setVisibility(View.GONE);
                dralp3.setVisibility(View.GONE);
            } else if ((sObject.getPlantingMaterial3().equals("G") || sObject.getPlantingMaterial3().equals("M")) && sObject.getFarmCondition3().equals("G") && sObject.getTreeDensity3().equals("G") && sObject.getTreeAge3().equals("G") && sObject.getTreeHealth3().equals("G") && sObject.getDebilitatingDisease3().equals("G") && (sObject.getPruning3().equals("G") || sObject.getPruning3().equals("M")) && (sObject.getPestDiseaseSanitation3().equals("G") || sObject.getPestDiseaseSanitation3().equals("M")) && sObject.getWeeding3().equals("G") && sObject.getHarvesting3().equals("G") && sObject.getShadeManagement3().equals("G") && sObject.getSoilCondition3().equals("B") || sObject.getOrganicMatter3().equals("B") || sObject.getFertilizerFormulation3().equals("B") || sObject.getFertilizerApplication3().equals("B")) {
                //Extra Soil Management
                exslp3.setVisibility(View.VISIBLE);
                int eSoil1P3 = (int) (plot3Area * 24622000);
                est31 = (int)(plot3Area*extraSoilY1);
                est32 = (int)(plot3Area*extraSoilY2);
                est33 = (int)(plot3Area*extraSoilY3);
                est34 = (int)(plot3Area*extraSoilY4);
                est35 = (int)(plot3Area*extraSoilY5);
                est36 = (int)(plot3Area*extraSoilY6);
                est37 = (int)(plot3Area*extraSoilY7);
                setText2((TextView) findViewById(R.id.gapP3Y1_field), String.valueOf(eSoil1P3));
                setText2((TextView) findViewById(R.id.gapP3Y2_field), String.valueOf(eSoil1P3));
                setText2((TextView) findViewById(R.id.gapP3Y3_field), String.valueOf(eSoil1P3));
                setText2((TextView) findViewById(R.id.gapP3Y4_field), String.valueOf(eSoil1P3));
                setText2((TextView) findViewById(R.id.gapP3Y5_field), String.valueOf(eSoil1P3));
                setText2((TextView) findViewById(R.id.gapP3Y6_field), String.valueOf(eSoil1P3));
                setText2((TextView) findViewById(R.id.gapP3Y7_field), String.valueOf(eSoil1P3));
                if (sObject.getHireLabor3().equals("Yes")) {
                    lablp3.setVisibility(View.VISIBLE);
                    int laborS1P3 = (int) (plot3Area * 12825000);
                    int laborS2P3 = (int) (plot3Area * 13425000);
                    int laborS3P3 = (int) (plot3Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP3Y1_field), String.valueOf(laborS1P3));
                    setText2((TextView) findViewById(R.id.laborP3Y2_field), String.valueOf(laborS1P3));
                    setText2((TextView) findViewById(R.id.laborP3Y3_field), String.valueOf(laborS2P3));
                    setText2((TextView) findViewById(R.id.laborP3Y4_field), String.valueOf(laborS3P3));
                    setText2((TextView) findViewById(R.id.laborP3Y5_field), String.valueOf(laborS3P3));
                    setText2((TextView) findViewById(R.id.laborP3Y6_field), String.valueOf(laborS3P3));
                    setText2((TextView) findViewById(R.id.laborP3Y7_field), String.valueOf(laborS3P3));
                }
                if (sObject.getLimeNeed3().equals("Yes")) {
                    limlp3.setVisibility(View.VISIBLE);
                    int lime1P3 = (int) (plot3Area * 1850000);
                    setText2((TextView) findViewById(R.id.limeP3Y1_field), String.valueOf(lime1P3));
                    setText2((TextView) findViewById(R.id.limeP3Y2_field), String.valueOf(lime1P3));
                    setText2((TextView) findViewById(R.id.limeP3Y3_field), "0");
                    setText2((TextView) findViewById(R.id.limeP3Y4_field), "0");
                    setText2((TextView) findViewById(R.id.limeP3Y5_field), "0");
                    setText2((TextView) findViewById(R.id.limeP3Y6_field), "0");
                    setText2((TextView) findViewById(R.id.limeP3Y7_field), "0");
                }
                if (sObject.getFillingOption3().equals("Yes")) {
                    fillp3.setVisibility(View.VISIBLE);
                }
                replp3.setVisibility(View.GONE);
                gaplp3.setVisibility(View.GONE);
                dralp3.setVisibility(View.GONE);
                grflp3.setVisibility(View.GONE);
            } else  {
                //GAPS
                gaplp3.setVisibility(View.VISIBLE);
                int gapresultP3 = (int) (plot3Area * 23622000);
                est31 = (int)(plot3Area*gapsY1);
                est32 = (int)(plot3Area*gapsY2);
                est33 = (int)(plot3Area*gapsY3);
                est34 = (int)(plot3Area*gapsY4);
                est35 = (int)(plot3Area*gapsY5);
                est36 = (int)(plot3Area*gapsY6);
                est37 = (int)(plot3Area*gapsY7);
                setText2((TextView) findViewById(R.id.gapP3Y1_field), String.valueOf(gapresultP3));
                setText2((TextView) findViewById(R.id.gapP3Y2_field), String.valueOf(gapresultP3));
                setText2((TextView) findViewById(R.id.gapP3Y3_field), String.valueOf(gapresultP3));
                setText2((TextView) findViewById(R.id.gapP3Y4_field), String.valueOf(gapresultP3));
                setText2((TextView) findViewById(R.id.gapP3Y5_field), String.valueOf(gapresultP3));
                setText2((TextView) findViewById(R.id.gapP3Y6_field), String.valueOf(gapresultP3));
                setText2((TextView) findViewById(R.id.gapP3Y7_field), String.valueOf(gapresultP3));
                if (sObject.getHireLabor3().equals("Yes")) {
                    lablp3.setVisibility(View.VISIBLE);
                    int labor1P3 = (int) (plot3Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP3Y1_field), String.valueOf(labor1P3));
                    setText2((TextView) findViewById(R.id.laborP3Y2_field), String.valueOf(labor1P3));
                    setText2((TextView) findViewById(R.id.laborP3Y3_field), String.valueOf(labor1P3));
                    setText2((TextView) findViewById(R.id.laborP3Y4_field), String.valueOf(labor1P3));
                    setText2((TextView) findViewById(R.id.laborP3Y5_field), String.valueOf(labor1P3));
                    setText2((TextView) findViewById(R.id.laborP3Y6_field), String.valueOf(labor1P3));
                    setText2((TextView) findViewById(R.id.laborP3Y7_field), String.valueOf(labor1P3));
                }
                if (sObject.getFillingOption3().equals("Yes")) {
                    fillp3.setVisibility(View.VISIBLE);
                }
                replp3.setVisibility(View.GONE);
                exslp3.setVisibility(View.GONE);
                limlp3.setVisibility(View.GONE);
                dralp3.setVisibility(View.GONE);
                grflp3.setVisibility(View.GONE);
            }
            //end plot
            if (sObject.getFarmCondition4().equals("N/A") || sObject.getTreeDensity4().equals("N/A") || sObject.getDebilitatingDisease4().equals("N/A")|| sObject.getPlantingMaterial4().equals("N/A")){
                replp4.setVisibility(View.GONE);
                gaplp4.setVisibility(View.GONE);
                dralp4.setVisibility(View.GONE);
                grflp4.setVisibility(View.GONE);
                lablp4.setVisibility(View.GONE);
                limlp4.setVisibility(View.GONE);
                fillp4.setVisibility(View.GONE);
                exslp4.setVisibility(View.GONE);
            }else if (sObject.getFarmCondition4().equals("B") || sObject.getTreeDensity4().equals("B") || sObject.getDebilitatingDisease4().equals("B")) {
                //Replanting
                replp4.setVisibility(View.VISIBLE);
                int rep1P4 = (int) (plot4Area* 21372000);
                int rep2P4 = (int) (plot4Area* 19753000);
                int rep3P4 = (int) (plot4Area * 20640500);
                int rep4P4 = (int) (plot4Area * 23622000);
                est41 = (int)(plot4Area*replantingY1);
                est42 = (int)(plot4Area*replantingY2);
                est43 = (int)(plot4Area*replantingY3);
                est44 = (int)(plot4Area*replantingY4);
                est45 = (int)(plot4Area*replantingY5);
                est46 = (int)(plot4Area*replantingY6);
                est47 = (int)(plot4Area*replantingY7);
                setText2((TextView) findViewById(R.id.gapP4Y1_field), String.valueOf(rep1P4));
                setText2((TextView) findViewById(R.id.gapP4Y2_field), String.valueOf(rep2P4));
                setText2((TextView) findViewById(R.id.gapP4Y3_field), String.valueOf(rep3P4));
                setText2((TextView) findViewById(R.id.gapP4Y4_field), String.valueOf(rep4P4));
                setText2((TextView) findViewById(R.id.gapP4Y5_field), String.valueOf(rep4P4));
                setText2((TextView) findViewById(R.id.gapP4Y6_field), String.valueOf(rep4P4));
                setText2((TextView) findViewById(R.id.gapP4Y7_field), String.valueOf(rep4P4));
                if (sObject.getHireLabor4().equals("Yes")) {
                    lablp4.setVisibility(View.VISIBLE);
                    int labRep1P4 = (int) (plot4Area * 12150000);
                    int labRep2P4 = (int) (plot4Area * 6375000);
                    int labRep3P4 = (int) (plot4Area * 6975000);
                    int labRep4P4 = (int) (plot4Area* 11250000);
                    int labRep5P4 = (int) (plot4Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP4Y1_field), String.valueOf(labRep1P4));
                    setText2((TextView) findViewById(R.id.laborP4Y2_field), String.valueOf(labRep2P4));
                    setText2((TextView) findViewById(R.id.laborP4Y3_field), String.valueOf(labRep3P4));
                    setText2((TextView) findViewById(R.id.laborP4Y4_field), String.valueOf(labRep4P4));
                    setText2((TextView) findViewById(R.id.laborP4Y5_field), String.valueOf(labRep5P4));
                    setText2((TextView) findViewById(R.id.laborP4Y6_field), String.valueOf(labRep5P4));
                    setText2((TextView) findViewById(R.id.laborP4Y7_field), String.valueOf(labRep5P4));
                }
                if (sObject.getDrainageNeed4().equals("Yes")) {
                    dralp4.setVisibility(View.VISIBLE);
                }
                if (sObject.geLimeNeed4().equals("Yes")||sObject.getDrainageNeed4().equals("Yes")) {
                    limlp4.setVisibility(View.VISIBLE);
                    int drafRep1P4 = (int) (plot4Area * 2250000);
                    int limRep1P4 = (int) (plot4Area* 925000);
                    int totalOtherP4 = drafRep1P4+limRep1P4;
                    setText2((TextView) findViewById(R.id.limeP4Y1_field), String.valueOf(totalOtherP4));
                    setText2((TextView) findViewById(R.id.limeP4Y2_field), "0");
                    setText2((TextView) findViewById(R.id.limeP4Y3_field), "0");
                    setText2((TextView) findViewById(R.id.limeP4Y4_field), "0");
                    setText2((TextView) findViewById(R.id.limeP4Y5_field), "0");
                    setText2((TextView) findViewById(R.id.limeP4Y6_field), "0");
                    setText2((TextView) findViewById(R.id.limeP4Y7_field), "0");
                }
                if (sObject.getFillingOption4().equals("Yes")) {
                    fillp4.setVisibility(View.VISIBLE);
                }
                exslp4.setVisibility(View.GONE);
                gaplp4.setVisibility(View.GONE);
                grflp4.setVisibility(View.GONE);
            } else if (sObject.getTreeHealth4().equals("G")&&(sObject.getPlantingMaterial4().equals("M")||sObject.getPlantingMaterial4().equals("B"))&&(sObject.getTreeAge4().equals("G")||sObject.getTreeAge4().equals("B"))) {
                //Grafting
                grflp4.setVisibility(View.VISIBLE);
                int graf1P4 = (int) (plot4Area * 23467500);
                int graf2P4 = (int) (plot4Area * 22358500);
                int graf3P4 = (int) (plot4Area * 23722000);
                int graf4P4 = (int) (plot4Area * 23622000);
                est41 = (int)(plot4Area*graftingY1);
                est42 = (int)(plot4Area*graftingY2);
                est43 = (int)(plot4Area*graftingY3);
                est44 = (int)(plot4Area*graftingY4);
                est45 = (int)(plot4Area*graftingY5);
                est46 = (int)(plot4Area*graftingY6);
                est47 = (int)(plot4Area*graftingY7);
                setText2((TextView) findViewById(R.id.gapP4Y1_field), String.valueOf(graf1P4));
                setText2((TextView) findViewById(R.id.gapP4Y2_field), String.valueOf(graf2P4));
                setText2((TextView) findViewById(R.id.gapP4Y3_field), String.valueOf(graf3P4));
                setText2((TextView) findViewById(R.id.gapP4Y4_field), String.valueOf(graf4P4));
                setText2((TextView) findViewById(R.id.gapP4Y5_field), String.valueOf(graf4P4));
                setText2((TextView) findViewById(R.id.gapP4Y6_field), String.valueOf(graf4P4));
                setText2((TextView) findViewById(R.id.gapP4Y7_field), String.valueOf(graf4P4));
                if (sObject.getHireLabor4().equals("Yes")) {
                    lablp4.setVisibility(View.VISIBLE);
                    int laborGraf1P4 = (int) (plot4Area * 12000000);
                    int laborGraf2P4 = (int) (plot4Area * 7200000);
                    int laborGraf3P4 = (int) (plot4Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP4Y1_field), String.valueOf(laborGraf1P4));
                    setText2((TextView) findViewById(R.id.laborP4Y2_field), String.valueOf(laborGraf2P4));
                    setText2((TextView) findViewById(R.id.laborP4Y3_field), String.valueOf(laborGraf3P4));
                    setText2((TextView) findViewById(R.id.laborP4Y4_field), String.valueOf(laborGraf3P4));
                    setText2((TextView) findViewById(R.id.laborP4Y5_field), String.valueOf(laborGraf3P4));
                    setText2((TextView) findViewById(R.id.laborP4Y6_field), String.valueOf(laborGraf3P4));
                    setText2((TextView) findViewById(R.id.laborP4Y7_field), String.valueOf(laborGraf3P4));
                }
                if (sObject.getFillingOption4().equals("Yes")) {
                    fillp4.setVisibility(View.VISIBLE);
                }
                exslp4.setVisibility(View.GONE);
                replp4.setVisibility(View.GONE);
                gaplp4.setVisibility(View.GONE);
                limlp4.setVisibility(View.GONE);
                dralp4.setVisibility(View.GONE);
            } else if ((sObject.getPlantingMaterial4().equals("G") || sObject.getPlantingMaterial4().equals("M")) && sObject.getFarmCondition4().equals("G") && sObject.getTreeDensity4().equals("G") && sObject.getTreeAge4().equals("G") && sObject.getTreeHealth4().equals("G") && sObject.getDebilitatingDisease4().equals("G") && (sObject.getPruning4().equals("G") || sObject.getPruning4().equals("M")) && (sObject.getPestDiseaseSanitation4().equals("G") || sObject.getPestDiseaseSanitation4().equals("M")) && sObject.getWeeding4().equals("G") && sObject.getHarvesting4().equals("G") && sObject.getShadeManagement4().equals("G") && sObject.getSoilCondition4().equals("B") || sObject.getOrganicMatter4().equals("B") || sObject.getFertilizerFormulation4().equals("B") || sObject.getFertilizerApplication4().equals("B")) {
                //Extra Soil Management
                exslp4.setVisibility(View.VISIBLE);
                int eSoil1P4 = (int) (plot4Area * 24622000);
                est41 = (int)(plot4Area*extraSoilY1);
                est42 = (int)(plot4Area*extraSoilY2);
                est43 = (int)(plot4Area*extraSoilY3);
                est44 = (int)(plot4Area*extraSoilY4);
                est45 = (int)(plot4Area*extraSoilY5);
                est46 = (int)(plot4Area*extraSoilY6);
                est47 = (int)(plot4Area*extraSoilY7);
                setText2((TextView) findViewById(R.id.gapP4Y1_field), String.valueOf(eSoil1P4));
                setText2((TextView) findViewById(R.id.gapP4Y2_field), String.valueOf(eSoil1P4));
                setText2((TextView) findViewById(R.id.gapP4Y3_field), String.valueOf(eSoil1P4));
                setText2((TextView) findViewById(R.id.gapP4Y4_field), String.valueOf(eSoil1P4));
                setText2((TextView) findViewById(R.id.gapP4Y5_field), String.valueOf(eSoil1P4));
                setText2((TextView) findViewById(R.id.gapP4Y6_field), String.valueOf(eSoil1P4));
                setText2((TextView) findViewById(R.id.gapP4Y7_field), String.valueOf(eSoil1P4));
                if (sObject.getHireLabor4().equals("Yes")) {
                    lablp4.setVisibility(View.VISIBLE);
                    int laborS1P4 = (int) (plot4Area * 12825000);
                    int laborS2P4 = (int) (plot4Area * 13425000);
                    int laborS3P4 = (int) (plot4Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP4Y1_field), String.valueOf(laborS1P4));
                    setText2((TextView) findViewById(R.id.laborP4Y2_field), String.valueOf(laborS1P4));
                    setText2((TextView) findViewById(R.id.laborP4Y3_field), String.valueOf(laborS2P4));
                    setText2((TextView) findViewById(R.id.laborP4Y4_field), String.valueOf(laborS3P4));
                    setText2((TextView) findViewById(R.id.laborP4Y5_field), String.valueOf(laborS3P4));
                    setText2((TextView) findViewById(R.id.laborP4Y6_field), String.valueOf(laborS3P4));
                    setText2((TextView) findViewById(R.id.laborP4Y7_field), String.valueOf(laborS3P4));
                }
                if (sObject.geLimeNeed4().equals("Yes")) {
                    limlp4.setVisibility(View.VISIBLE);
                    int lime1P4 = (int) (plot4Area* 1850000);
                    setText2((TextView) findViewById(R.id.limeP4Y1_field), String.valueOf(lime1P4));
                    setText2((TextView) findViewById(R.id.limeP4Y2_field), String.valueOf(lime1P4));
                    setText2((TextView) findViewById(R.id.limeP4Y3_field), "0");
                    setText2((TextView) findViewById(R.id.limeP4Y4_field), "0");
                    setText2((TextView) findViewById(R.id.limeP4Y5_field), "0");
                    setText2((TextView) findViewById(R.id.limeP4Y6_field), "0");
                    setText2((TextView) findViewById(R.id.limeP4Y7_field), "0");
                }
                if (sObject.getFillingOption4().equals("Yes")) {
                    fillp4.setVisibility(View.VISIBLE);
                }
                replp4.setVisibility(View.GONE);
                gaplp4.setVisibility(View.GONE);
                dralp4.setVisibility(View.GONE);
                grflp4.setVisibility(View.GONE);
            } else {
                //GAPS
                gaplp4.setVisibility(View.VISIBLE);
                int gapresultP4 = (int) (plot4Area * 23622000);
                est41 = (int)(plot4Area*gapsY1);
                est42 = (int)(plot4Area*gapsY2);
                est43 = (int)(plot4Area*gapsY3);
                est44 = (int)(plot4Area*gapsY4);
                est45 = (int)(plot4Area*gapsY5);
                est46 = (int)(plot4Area*gapsY6);
                est47 = (int)(plot4Area*gapsY7);
                setText2((TextView) findViewById(R.id.gapP4Y1_field), String.valueOf(gapresultP4));
                setText2((TextView) findViewById(R.id.gapP4Y2_field), String.valueOf(gapresultP4));
                setText2((TextView) findViewById(R.id.gapP4Y3_field), String.valueOf(gapresultP4));
                setText2((TextView) findViewById(R.id.gapP4Y4_field), String.valueOf(gapresultP4));
                setText2((TextView) findViewById(R.id.gapP4Y5_field), String.valueOf(gapresultP4));
                setText2((TextView) findViewById(R.id.gapP4Y6_field), String.valueOf(gapresultP4));
                setText2((TextView) findViewById(R.id.gapP4Y7_field), String.valueOf(gapresultP4));
                if (sObject.getHireLabor4().equals("Yes")) {
                    lablp4.setVisibility(View.VISIBLE);
                    int labor1P4 = (int) (plot4Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP4Y1_field), String.valueOf(labor1P4));
                    setText2((TextView) findViewById(R.id.laborP4Y2_field), String.valueOf(labor1P4));
                    setText2((TextView) findViewById(R.id.laborP4Y3_field), String.valueOf(labor1P4));
                    setText2((TextView) findViewById(R.id.laborP4Y4_field), String.valueOf(labor1P4));
                    setText2((TextView) findViewById(R.id.laborP4Y5_field), String.valueOf(labor1P4));
                    setText2((TextView) findViewById(R.id.laborP4Y6_field), String.valueOf(labor1P4));
                    setText2((TextView) findViewById(R.id.laborP4Y7_field), String.valueOf(labor1P4));
                }
                if (sObject.getFillingOption4().equals("Yes")) {
                    fillp4.setVisibility(View.VISIBLE);
                }
                replp4.setVisibility(View.GONE);
                exslp4.setVisibility(View.GONE);
                limlp4.setVisibility(View.GONE);
                dralp4.setVisibility(View.GONE);
                grflp4.setVisibility(View.GONE);
            }
            //end of plot
            if (sObject.getFarmCondition5().equals("N/A") || sObject.getTreeDensity5().equals("N/A") || sObject.getDebilitatingDisease5().equals("N/A")|| sObject.getPlantingMaterial5().equals("N/A")){
                replp5.setVisibility(View.GONE);
                gaplp5.setVisibility(View.GONE);
                dralp5.setVisibility(View.GONE);
                grflp5.setVisibility(View.GONE);
                lablp5.setVisibility(View.GONE);
                limlp5.setVisibility(View.GONE);
                fillp5.setVisibility(View.GONE);
                exslp5.setVisibility(View.GONE);
            }else if (sObject.getFarmCondition5().equals("B") || sObject.getTreeDensity5().equals("B") || sObject.getDebilitatingDisease5().equals("B")) {
                //Replanting
                replp5.setVisibility(View.VISIBLE);
                int rep1P5 = (int) (plot5Area * 21372000);
                int rep2P5 = (int) (plot5Area * 19753000);
                int rep3P5 = (int) (plot5Area * 20640500);
                int rep4P5 = (int) (plot5Area * 23622000);
                est51 = (int)(plot5Area*replantingY1);
                est52 = (int)(plot5Area*replantingY2);
                est53 = (int)(plot5Area*replantingY3);
                est54 = (int)(plot5Area*replantingY4);
                est55 = (int)(plot5Area*replantingY5);
                est56 = (int)(plot5Area*replantingY6);
                est57 = (int)(plot5Area*replantingY7);
                setText2((TextView) findViewById(R.id.gapP5Y1_field), String.valueOf(rep1P5));
                setText2((TextView) findViewById(R.id.gapP5Y2_field), String.valueOf(rep2P5));
                setText2((TextView) findViewById(R.id.gapP5Y3_field), String.valueOf(rep3P5));
                setText2((TextView) findViewById(R.id.gapP5Y4_field), String.valueOf(rep4P5));
                setText2((TextView) findViewById(R.id.gapP5Y5_field), String.valueOf(rep4P5));
                setText2((TextView) findViewById(R.id.gapP5Y6_field), String.valueOf(rep4P5));
                setText2((TextView) findViewById(R.id.gapP5Y7_field), String.valueOf(rep4P5));
                if (sObject.getHireLabor5().equals("Yes")) {
                    lablp5.setVisibility(View.VISIBLE);
                    int labRep1P5 = (int) (plot5Area * 12150000);
                    int labRep2P5 = (int) (plot5Area * 6375000);
                    int labRep3P5 = (int) (plot5Area * 6975000);
                    int labRep4P5 = (int) (plot5Area * 11250000);
                    int labRep5P5 = (int) (plot5Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP5Y1_field), String.valueOf(labRep1P5));
                    setText2((TextView) findViewById(R.id.laborP5Y2_field), String.valueOf(labRep2P5));
                    setText2((TextView) findViewById(R.id.laborP5Y3_field), String.valueOf(labRep3P5));
                    setText2((TextView) findViewById(R.id.laborP5Y4_field), String.valueOf(labRep4P5));
                    setText2((TextView) findViewById(R.id.laborP5Y5_field), String.valueOf(labRep5P5));
                    setText2((TextView) findViewById(R.id.laborP5Y6_field), String.valueOf(labRep5P5));
                    setText2((TextView) findViewById(R.id.laborP5Y7_field), String.valueOf(labRep5P5));
                }
                if (sObject.getDrainageNeed5().equals("Yes")) {
                    dralp5.setVisibility(View.VISIBLE);
                }
                if (sObject.getLimeNeed5().equals("Yes")||sObject.getDrainageNeed5().equals("Yes")) {
                    limlp5.setVisibility(View.VISIBLE);
                    int limRep1P5 = (int) (plot5Area * 925000);
                    int drafRep1P5 = (int) (plot5Area * 2250000);
                    int totalOtherP5 =limRep1P5+drafRep1P5;
                    setText2((TextView) findViewById(R.id.limeP5Y1_field), String.valueOf(totalOtherP5));
                    setText2((TextView) findViewById(R.id.limeP5Y2_field), "0");
                    setText2((TextView) findViewById(R.id.limeP5Y3_field), "0");
                    setText2((TextView) findViewById(R.id.limeP5Y4_field), "0");
                    setText2((TextView) findViewById(R.id.limeP5Y5_field), "0");
                    setText2((TextView) findViewById(R.id.limeP5Y6_field), "0");
                    setText2((TextView) findViewById(R.id.limeP5Y7_field), "0");
                }
                if (sObject.getFillingOption5().equals("Yes")) {
                    fillp5.setVisibility(View.VISIBLE);
                }
                exslp5.setVisibility(View.GONE);
                gaplp5.setVisibility(View.GONE);
                grflp5.setVisibility(View.GONE);
            } else if (sObject.getTreeHealth5().equals("G")&&(sObject.getPlantingMaterial5().equals("M")||sObject.getPlantingMaterial5().equals("B"))&&(sObject.getTreeAge5().equals("G")||sObject.getTreeAge5().equals("B"))) {
                //Grafting
                grflp5.setVisibility(View.VISIBLE);
                int graf1P5 = (int) (plot5Area * 23467500);
                int graf2P5 = (int) (plot5Area * 22358500);
                int graf3P5 = (int) (plot5Area * 23722000);
                int graf4P5 = (int) (plot5Area * 23622000);
                est51 = (int)(plot5Area*graftingY1);
                est52 = (int)(plot5Area*graftingY2);
                est53 = (int)(plot5Area*graftingY3);
                est54 = (int)(plot5Area*graftingY4);
                est55 = (int)(plot5Area*graftingY5);
                est56 = (int)(plot5Area*graftingY6);
                est57 = (int)(plot5Area*graftingY7);
                setText2((TextView) findViewById(R.id.gapP5Y1_field), String.valueOf(graf1P5));
                setText2((TextView) findViewById(R.id.gapP5Y2_field), String.valueOf(graf2P5));
                setText2((TextView) findViewById(R.id.gapP5Y3_field), String.valueOf(graf3P5));
                setText2((TextView) findViewById(R.id.gapP5Y4_field), String.valueOf(graf4P5));
                setText2((TextView) findViewById(R.id.gapP5Y5_field), String.valueOf(graf4P5));
                setText2((TextView) findViewById(R.id.gapP5Y6_field), String.valueOf(graf4P5));
                setText2((TextView) findViewById(R.id.gapP5Y7_field), String.valueOf(graf4P5));
                if (sObject.getHireLabor5().equals("Yes")) {
                    lablp5.setVisibility(View.VISIBLE);
                    int laborGraf1P5 = (int) (plot5Area * 12000000);
                    int laborGraf2P5 = (int) (plot5Area * 7200000);
                    int laborGraf3P5 = (int) (plot5Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP5Y1_field), String.valueOf(laborGraf1P5));
                    setText2((TextView) findViewById(R.id.laborP5Y2_field), String.valueOf(laborGraf2P5));
                    setText2((TextView) findViewById(R.id.laborP5Y3_field), String.valueOf(laborGraf3P5));
                    setText2((TextView) findViewById(R.id.laborP5Y4_field), String.valueOf(laborGraf3P5));
                    setText2((TextView) findViewById(R.id.laborP5Y5_field), String.valueOf(laborGraf3P5));
                    setText2((TextView) findViewById(R.id.laborP5Y6_field), String.valueOf(laborGraf3P5));
                    setText2((TextView) findViewById(R.id.laborP5Y7_field), String.valueOf(laborGraf3P5));
                }
                if (sObject.getFillingOption5().equals("Yes")) {
                    fillp5.setVisibility(View.VISIBLE);
                }
                exslp5.setVisibility(View.GONE);
                replp5.setVisibility(View.GONE);
                gaplp5.setVisibility(View.GONE);
                limlp5.setVisibility(View.GONE);
                dralp5.setVisibility(View.GONE);
            } else if ((sObject.getPlantingMaterial5().equals("G") || sObject.getPlantingMaterial5().equals("M")) && sObject.getFarmCondition5().equals("G") && sObject.getTreeDensity5().equals("G") && sObject.getTreeAge5().equals("G") && sObject.getTreeHealth5().equals("G") && sObject.getDebilitatingDisease5().equals("G") && (sObject.getPruning5().equals("G") || sObject.getPruning5().equals("M")) && (sObject.getPestDiseaseSanitation5().equals("G") || sObject.getPestDiseaseSanitation5().equals("M")) && sObject.getWeeding5().equals("G") && sObject.getHarvesting5().equals("G") && sObject.getShadeManagement5().equals("G") && sObject.getSoilCondition5().equals("B") || sObject.getOrganicMatter5().equals("B") || sObject.getFertilizerFormulation5().equals("B") || sObject.getFertilizerApplication5().equals("B")) {
                //Extra Soil Management
                exslp5.setVisibility(View.VISIBLE);
                int eSoil1P5 = (int) (plot5Area * 24622000);
                est51 = (int)(plot5Area*extraSoilY1);
                est52 = (int)(plot5Area*extraSoilY2);
                est53 = (int)(plot5Area*extraSoilY3);
                est54 = (int)(plot5Area*extraSoilY4);
                est55 = (int)(plot5Area*extraSoilY5);
                est56 = (int)(plot5Area*extraSoilY6);
                est57 = (int)(plot5Area*extraSoilY7);
                setText2((TextView) findViewById(R.id.gapP5Y1_field), String.valueOf(eSoil1P5));
                setText2((TextView) findViewById(R.id.gapP5Y2_field), String.valueOf(eSoil1P5));
                setText2((TextView) findViewById(R.id.gapP5Y3_field), String.valueOf(eSoil1P5));
                setText2((TextView) findViewById(R.id.gapP5Y4_field), String.valueOf(eSoil1P5));
                setText2((TextView) findViewById(R.id.gapP5Y5_field), String.valueOf(eSoil1P5));
                setText2((TextView) findViewById(R.id.gapP5Y6_field), String.valueOf(eSoil1P5));
                setText2((TextView) findViewById(R.id.gapP5Y7_field), String.valueOf(eSoil1P5));
                if (sObject.getHireLabor5().equals("Yes")) {
                    lablp5.setVisibility(View.VISIBLE);
                    int laborS1P5 = (int) (plot5Area * 12825000);
                    int laborS2P5 = (int) (plot5Area * 13425000);
                    int laborS3P5 = (int) (plot5Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP5Y1_field), String.valueOf(laborS1P5));
                    setText2((TextView) findViewById(R.id.laborP5Y2_field), String.valueOf(laborS1P5));
                    setText2((TextView) findViewById(R.id.laborP5Y3_field), String.valueOf(laborS2P5));
                    setText2((TextView) findViewById(R.id.laborP5Y4_field), String.valueOf(laborS3P5));
                    setText2((TextView) findViewById(R.id.laborP5Y5_field), String.valueOf(laborS3P5));
                    setText2((TextView) findViewById(R.id.laborP5Y6_field), String.valueOf(laborS3P5));
                    setText2((TextView) findViewById(R.id.laborP5Y7_field), String.valueOf(laborS3P5));
                }
                if (sObject.getLimeNeed5().equals("Yes")) {
                    limlp5.setVisibility(View.VISIBLE);
                    int lime1P5 = (int) (plot5Area * 1850000);
                    setText2((TextView) findViewById(R.id.limeP5Y1_field), String.valueOf(lime1P5));
                    setText2((TextView) findViewById(R.id.limeP5Y2_field), String.valueOf(lime1P5));
                    setText2((TextView) findViewById(R.id.limeP5Y3_field), "0");
                    setText2((TextView) findViewById(R.id.limeP5Y4_field), "0");
                    setText2((TextView) findViewById(R.id.limeP5Y5_field), "0");
                    setText2((TextView) findViewById(R.id.limeP5Y6_field), "0");
                    setText2((TextView) findViewById(R.id.limeP5Y7_field), "0");
                }
                if (sObject.getFillingOption5().equals("Yes")) {
                    fillp5.setVisibility(View.VISIBLE);
                }
                replp5.setVisibility(View.GONE);
                gaplp5.setVisibility(View.GONE);
                dralp5.setVisibility(View.GONE);
                grflp5.setVisibility(View.GONE);
            } else {
                //GAPS
                gaplp5.setVisibility(View.VISIBLE);
                int gapresultP5 = (int) (plot5Area * 23622000);
                est51 = (int)(plot5Area*gapsY1);
                est52 = (int)(plot5Area*gapsY2);
                est53 = (int)(plot5Area*gapsY3);
                est54 = (int)(plot5Area*gapsY4);
                est55 = (int)(plot5Area*gapsY5);
                est56 = (int)(plot5Area*gapsY6);
                est57 = (int)(plot5Area*gapsY7);
                setText2((TextView) findViewById(R.id.gapP5Y1_field), String.valueOf(gapresultP5));
                setText2((TextView) findViewById(R.id.gapP5Y2_field), String.valueOf(gapresultP5));
                setText2((TextView) findViewById(R.id.gapP5Y3_field), String.valueOf(gapresultP5));
                setText2((TextView) findViewById(R.id.gapP5Y4_field), String.valueOf(gapresultP5));
                setText2((TextView) findViewById(R.id.gapP5Y5_field), String.valueOf(gapresultP5));
                setText2((TextView) findViewById(R.id.gapP5Y6_field), String.valueOf(gapresultP5));
                setText2((TextView) findViewById(R.id.gapP5Y7_field), String.valueOf(gapresultP5));
                if (sObject.getHireLabor5().equals("Yes")) {
                    lablp5.setVisibility(View.VISIBLE);
                    int labor1P5 = (int) (plot5Area * 12075000);
                    setText2((TextView) findViewById(R.id.laborP5Y1_field), String.valueOf(labor1P5));
                    setText2((TextView) findViewById(R.id.laborP5Y2_field), String.valueOf(labor1P5));
                    setText2((TextView) findViewById(R.id.laborP5Y3_field), String.valueOf(labor1P5));
                    setText2((TextView) findViewById(R.id.laborP5Y4_field), String.valueOf(labor1P5));
                    setText2((TextView) findViewById(R.id.laborP5Y5_field), String.valueOf(labor1P5));
                    setText2((TextView) findViewById(R.id.laborP5Y6_field), String.valueOf(labor1P5));
                    setText2((TextView) findViewById(R.id.laborP5Y7_field), String.valueOf(labor1P5));
                }
                if (sObject.getFillingOption5().equals("Yes")) {
                    fillp5.setVisibility(View.VISIBLE);
                }
                replp5.setVisibility(View.GONE);
                exslp5.setVisibility(View.GONE);
                limlp5.setVisibility(View.GONE);
                dralp5.setVisibility(View.GONE);
                grflp5.setVisibility(View.GONE);
            }

            //net income cocoa
            int avgCost = Integer.parseInt(sObject.getAveragecocoaprice().toString());
            int est1 = est11+est21+est31+est41+est51;
            int est2 = est12+est22+est32+est42+est52;
            int est3 = est13+est23+est33+est43+est53;
            int est4 = est14+est24+est34+est44+est54;
            int est5 = est15+est25+est35+est45+est55;
            int est6 = est16+est26+est36+est46+est56;
            int est7 = est17+est27+est37+est47+est57;
            int totalIncomeY1 = avgCost * est1;
            int totalIncomeY2 = avgCost * est2;
            int totalIncomeY3 = avgCost * est3;
            int totalIncomeY4 = avgCost * est4;
            int totalIncomeY5 = avgCost * est5;
            int totalIncomeY6 = avgCost * est6;
            int totalIncomeY7 = avgCost * est7;
            int totalIncome = totalIncomeY1+totalIncomeY2+totalIncomeY3+totalIncomeY4+totalIncomeY5+totalIncomeY6+totalIncomeY7;
            setText2((TextView) findViewById(R.id.netPlotIncomeY1_field), String.valueOf(totalIncomeY1));
            setText2((TextView) findViewById(R.id.netPlotIncomeY2_field), String.valueOf(totalIncomeY2));
            setText2((TextView) findViewById(R.id.netPlotIncomeY3_field), String.valueOf(totalIncomeY3));
            setText2((TextView) findViewById(R.id.netPlotIncomeY4_field), String.valueOf(totalIncomeY4));
            setText2((TextView) findViewById(R.id.netPlotIncomeY5_field), String.valueOf(totalIncomeY5));
            setText2((TextView) findViewById(R.id.netPlotIncomeY6_field), String.valueOf(totalIncomeY6));
            setText2((TextView) findViewById(R.id.netPlotIncomeY7_field), String.valueOf(totalIncomeY7));
            //net income farming
            String farmWork = sObject.getIncomefarmlabor().toString();
            setText2((TextView) findViewById(R.id.netFarmingY1_field), farmWork);
            setText2((TextView) findViewById(R.id.netFarmingY2_field), farmWork);
            setText2((TextView) findViewById(R.id.netFarmingY3_field), farmWork);
            setText2((TextView) findViewById(R.id.netFarmingY4_field), farmWork);
            setText2((TextView) findViewById(R.id.netFarmingY5_field), farmWork);
            setText2((TextView) findViewById(R.id.netFarmingY6_field), farmWork);
            setText2((TextView) findViewById(R.id.netFarmingY7_field), farmWork);

            // net family income
            int spouseWork = Integer.parseInt(sObject.getSpouseincome().toString());
            int familyWork = Integer.parseInt(sObject.getFamilymembersincome().toString());
            int totalFincome;
            totalFincome = spouseWork + familyWork;
            setText2((TextView) findViewById(R.id.netFamilyY1_field), String.valueOf(totalFincome));
            setText2((TextView) findViewById(R.id.netFamilyY2_field), String.valueOf(totalFincome));
            setText2((TextView) findViewById(R.id.netFamilyY3_field), String.valueOf(totalFincome));
            setText2((TextView) findViewById(R.id.netFamilyY4_field), String.valueOf(totalFincome));
            setText2((TextView) findViewById(R.id.netFamilyY5_field), String.valueOf(totalFincome));
            setText2((TextView) findViewById(R.id.netFamilyY6_field), String.valueOf(totalFincome));
            setText2((TextView) findViewById(R.id.netFamilyY7_field), String.valueOf(totalFincome));

            //net other income
            int otherCrops = Integer.parseInt(sObject.getIncomeothercrops().toString());
            int moneyBack = Integer.parseInt(sObject.getLoanmoneygetback().toString());
            int hhSavings = Integer.parseInt(sObject.getHouseholdsavings().toString());
            int totalOtherIncome = otherCrops + moneyBack + hhSavings;
            setText2((TextView) findViewById(R.id.netOtherY1_field), String.valueOf(totalOtherIncome));
            setText2((TextView) findViewById(R.id.netOtherY2_field), String.valueOf(totalOtherIncome));
            setText2((TextView) findViewById(R.id.netOtherY3_field), String.valueOf(totalOtherIncome));
            setText2((TextView) findViewById(R.id.netOtherY4_field), String.valueOf(totalOtherIncome));
            setText2((TextView) findViewById(R.id.netOtherY5_field), String.valueOf(totalOtherIncome));
            setText2((TextView) findViewById(R.id.netOtherY6_field), String.valueOf(totalOtherIncome));
            setText2((TextView) findViewById(R.id.netOtherY7_field), String.valueOf(totalOtherIncome));

            //total income

            int totalIncomeAllY1 = totalIncomeY1 + Integer.valueOf(farmWork) + totalFincome + totalOtherIncome;
            int totalIncomeAllY2 = totalIncomeY2 + Integer.valueOf(farmWork) + totalFincome + totalOtherIncome;
            int totalIncomeAllY3 = totalIncomeY3 + Integer.valueOf(farmWork) + totalFincome + totalOtherIncome;
            int totalIncomeAllY4 = totalIncomeY4 + Integer.valueOf(farmWork) + totalFincome + totalOtherIncome;
            int totalIncomeAllY5 = totalIncomeY5 + Integer.valueOf(farmWork) + totalFincome + totalOtherIncome;
            int totalIncomeAllY6 = totalIncomeY6 + Integer.valueOf(farmWork) + totalFincome + totalOtherIncome;
            int totalIncomeAllY7 = totalIncomeY7 + Integer.valueOf(farmWork) + totalFincome + totalOtherIncome;
            int totalIncomeAll = totalIncomeAllY1+totalIncomeAllY2+totalIncomeAllY3+totalIncomeAllY4+totalIncomeAllY5+totalIncomeAllY6+totalIncomeAllY7;
            setText2((TextView) findViewById(R.id.totalIncomeY1_field), String.valueOf(totalIncomeAllY1));
            setText2((TextView) findViewById(R.id.totalIncomeY2_field), String.valueOf(totalIncomeAllY2));
            setText2((TextView) findViewById(R.id.totalIncomeY3_field), String.valueOf(totalIncomeAllY3));
            setText2((TextView) findViewById(R.id.totalIncomeY4_field), String.valueOf(totalIncomeAllY4));
            setText2((TextView) findViewById(R.id.totalIncomeY5_field), String.valueOf(totalIncomeAllY5));
            setText2((TextView) findViewById(R.id.totalIncomeY6_field), String.valueOf(totalIncomeAllY6));
            setText2((TextView) findViewById(R.id.totalIncomeY7_field), String.valueOf(totalIncomeAllY7));

            //total famili costs
            int expLY = Integer.parseInt(sObject.getExpensescocoaly().toString());
            int anLivExpen = Integer.parseInt(sObject.getAnnuallivingexpenses().toString());
            int anCostHh = Integer.parseInt(sObject.getAnnualcostofhousing().toString());
            int anOtherExp = Integer.parseInt(sObject.getAnnualotherexpenses().toString());
            int expEducExp = Integer.parseInt(sObject.getExpectededucationexpenses().toString());
            int credPay = Integer.parseInt(sObject.getHowmuchpayforcredit().toString());
            int totalExpenses = expLY+anLivExpen+anCostHh+anOtherExp+expEducExp+credPay;
            setText2((TextView) findViewById(R.id.totalExpensesY1_field), String.valueOf(totalExpenses));
            setText2((TextView) findViewById(R.id.totalExpensesY2_field), String.valueOf(totalExpenses));
            setText2((TextView) findViewById(R.id.totalExpensesY3_field), String.valueOf(totalExpenses));
            setText2((TextView) findViewById(R.id.totalExpensesY4_field), String.valueOf(totalExpenses));
            setText2((TextView) findViewById(R.id.totalExpensesY5_field), String.valueOf(totalExpenses));
            setText2((TextView) findViewById(R.id.totalExpensesY6_field), String.valueOf(totalExpenses));
            setText2((TextView) findViewById(R.id.totalExpensesY7_field), String.valueOf(totalExpenses));
            //found available
            int availableY1 = totalIncomeAllY1-totalExpenses;
            int availableY2 = totalIncomeAllY2-totalExpenses;
            int availableY3 = totalIncomeAllY3-totalExpenses;
            int availableY4 = totalIncomeAllY4-totalExpenses;
            int availableY5 = totalIncomeAllY5-totalExpenses;
            int availableY6 = totalIncomeAllY6-totalExpenses;
            int availableY7 = totalIncomeAllY7-totalExpenses;
            setText2((TextView) findViewById(R.id.foundsAvailableY1_field), String.valueOf(availableY1));
            setText2((TextView) findViewById(R.id.foundsAvailableY2_field), String.valueOf(availableY2));
            setText2((TextView) findViewById(R.id.foundsAvailableY3_field), String.valueOf(availableY3));
            setText2((TextView) findViewById(R.id.foundsAvailableY4_field), String.valueOf(availableY4));
            setText2((TextView) findViewById(R.id.foundsAvailableY5_field), String.valueOf(availableY5));
            setText2((TextView) findViewById(R.id.foundsAvailableY6_field), String.valueOf(availableY6));
            setText2((TextView) findViewById(R.id.foundsAvailableY7_field), String.valueOf(availableY7));
            //found needed
            int gap11 = 0;
            int lab11 = 0;
            int lime11 =  0;
            int gap21 =  0;
            int lab21 =  0;
            int lime21 =  0;
            int gap31 =  0;
            int lab31 =  0;
            int lime31 =  0;
            int gap41 =  0;
            int lab41 =  0;
            int lime41 =  0;
            int gap51 =  0;
            int lab51 =  0;
            int lime51 =  0;

            if (((TextView)findViewById(R.id.gapP1Y1_field)).getText().toString().equals("")) {} else {
                gap11 = Integer.valueOf(((TextView) findViewById(R.id.gapP1Y1_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP2Y1_field)).getText().toString().equals("")){} else {
                gap21 = Integer.valueOf(((TextView) findViewById(R.id.gapP2Y1_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP3Y1_field)).getText().toString().equals("")){} else {
                gap31 = Integer.valueOf(((TextView) findViewById(R.id.gapP3Y1_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP4Y1_field)).getText().toString().equals("")){} else {
                gap41 = Integer.valueOf(((TextView) findViewById(R.id.gapP4Y1_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP5Y1_field)).getText().toString().equals("")){} else {
                gap51 = Integer.valueOf(((TextView) findViewById(R.id.gapP5Y1_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP1Y1_field)).getText().toString().equals("")){} else {
                lab11 = Integer.valueOf(((TextView) findViewById(R.id.laborP1Y1_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP2Y1_field)).getText().toString().equals("")){} else {
                lab21 = Integer.valueOf(((TextView) findViewById(R.id.laborP2Y1_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP3Y1_field)).getText().toString().equals("")){} else {
                lab31 = Integer.valueOf(((TextView) findViewById(R.id.laborP3Y1_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP4Y1_field)).getText().toString().equals("")){} else {
                lab41 = Integer.valueOf(((TextView) findViewById(R.id.laborP4Y1_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP5Y1_field)).getText().toString().equals("")){} else {
                lab51 = Integer.valueOf(((TextView) findViewById(R.id.laborP5Y1_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP1Y1_field)).getText().toString().equals("")){} else {
                lime11 = Integer.valueOf(((TextView) findViewById(R.id.limeP1Y1_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP2Y1_field)).getText().toString().equals("")){} else {
                lime21 = Integer.valueOf(((TextView) findViewById(R.id.limeP2Y1_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP3Y1_field)).getText().toString().equals("")){} else {
                lime31 = Integer.valueOf(((TextView) findViewById(R.id.limeP3Y1_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP4Y1_field)).getText().toString().equals("")){} else {
                lime41 = Integer.valueOf(((TextView) findViewById(R.id.limeP4Y1_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP5Y1_field)).getText().toString().equals("")){} else {
                lime51 = Integer.valueOf(((TextView) findViewById(R.id.limeP5Y1_field)).getText().toString());
            }

            int totalY1 = gap11+lab11+lime11+gap21+lab21+lime21+gap31+lab31+lime31+gap41+lab41+lime41+gap51+lab51+lime51;
            setText2((TextView) findViewById(R.id.foundsNeededY1_field), String.valueOf(totalY1));

            int gap12 = 0;
            int lab12 = 0;
            int lime12 =  0;
            int gap22 =  0;
            int lab22 =  0;
            int lime22 =  0;
            int gap32 =  0;
            int lab32 =  0;
            int lime32 =  0;
            int gap42 =  0;
            int lab42 =  0;
            int lime42 =  0;
            int gap52 =  0;
            int lab52 =  0;
            int lime52 =  0;
            if (((TextView)findViewById(R.id.gapP1Y2_field)).getText().toString().equals("")) {} else {
                gap12 = Integer.valueOf(((TextView) findViewById(R.id.gapP1Y2_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP2Y2_field)).getText().toString().equals("")){} else {
                gap22 = Integer.valueOf(((TextView) findViewById(R.id.gapP2Y2_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP3Y2_field)).getText().toString().equals("")){} else {
                gap32 = Integer.valueOf(((TextView) findViewById(R.id.gapP3Y2_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP4Y2_field)).getText().toString().equals("")) {} else {
                gap42 = Integer.valueOf(((TextView) findViewById(R.id.gapP4Y2_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP5Y2_field)).getText().toString().equals("")){} else {
                gap52= Integer.valueOf(((TextView) findViewById(R.id.gapP5Y2_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP1Y2_field)).getText().toString().equals("")){} else {
                lab12 = Integer.valueOf(((TextView) findViewById(R.id.laborP1Y2_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP2Y2_field)).getText().toString().equals("")){} else {
                lab22 = Integer.valueOf(((TextView) findViewById(R.id.laborP2Y2_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP3Y2_field)).getText().toString().equals("")){} else {
                lab32 = Integer.valueOf(((TextView) findViewById(R.id.laborP3Y2_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP4Y2_field)).getText().toString().equals("")){} else {
                lab42 = Integer.valueOf(((TextView) findViewById(R.id.laborP4Y2_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP5Y2_field)).getText().toString().equals("")){} else {
                lab52 = Integer.valueOf(((TextView) findViewById(R.id.laborP5Y2_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP1Y2_field)).getText().toString().equals("")){} else {
                lime12 = Integer.valueOf(((TextView) findViewById(R.id.limeP1Y2_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP2Y2_field)).getText().toString().equals("")){} else {
                lime22 = Integer.valueOf(((TextView) findViewById(R.id.limeP2Y2_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP3Y2_field)).getText().toString().equals("")){} else {
                lime32 = Integer.valueOf(((TextView) findViewById(R.id.limeP3Y2_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP4Y2_field)).getText().toString().equals("")){} else {
                lime42 = Integer.valueOf(((TextView) findViewById(R.id.limeP4Y2_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP5Y2_field)).getText().toString().equals("")){} else {
                lime52 = Integer.valueOf(((TextView) findViewById(R.id.limeP5Y2_field)).getText().toString());
            }

            int totalY2 = gap12+lab12+lime12+gap22+lab22+lime22+gap32+lab32+lime32+gap42+lab42+lime42+gap52+lab52+lime52;
            setText2((TextView) findViewById(R.id.foundsNeededY2_field), String.valueOf(totalY2));

            int gap13 = 0;
            int lab13 = 0;
            int lime13 =  0;
            int gap23 =  0;
            int lab23 =  0;
            int lime23 =  0;
            int gap33 =  0;
            int lab33 =  0;
            int lime33 =  0;
            int gap43 =  0;
            int lab43 =  0;
            int lime43 =  0;
            int gap53 =  0;
            int lab53 =  0;
            int lime53 =  0;

            if (((TextView)findViewById(R.id.gapP1Y3_field)).getText().toString().equals("")) {} else {
                gap13 = Integer.valueOf(((TextView) findViewById(R.id.gapP1Y3_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP2Y3_field)).getText().toString().equals("")){} else {
                gap23 = Integer.valueOf(((TextView) findViewById(R.id.gapP2Y3_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP3Y3_field)).getText().toString().equals("")){} else {
                gap33 = Integer.valueOf(((TextView) findViewById(R.id.gapP3Y3_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP4Y3_field)).getText().toString().equals("")) {} else {
                gap43 = Integer.valueOf(((TextView) findViewById(R.id.gapP4Y3_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP5Y3_field)).getText().toString().equals("")){} else {
                gap53= Integer.valueOf(((TextView) findViewById(R.id.gapP5Y3_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP1Y3_field)).getText().toString().equals("")){} else {
                lab13 = Integer.valueOf(((TextView) findViewById(R.id.laborP1Y3_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP2Y3_field)).getText().toString().equals("")){} else {
                lab23 = Integer.valueOf(((TextView) findViewById(R.id.laborP2Y3_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP3Y3_field)).getText().toString().equals("")){} else {
                lab33 = Integer.valueOf(((TextView) findViewById(R.id.laborP3Y3_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP4Y3_field)).getText().toString().equals("")){} else {
                lab43 = Integer.valueOf(((TextView) findViewById(R.id.laborP4Y3_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP5Y3_field)).getText().toString().equals("")){} else {
                lab53 = Integer.valueOf(((TextView) findViewById(R.id.laborP5Y3_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP1Y3_field)).getText().toString().equals("")){} else {
                lime13 = Integer.valueOf(((TextView) findViewById(R.id.limeP1Y3_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP2Y3_field)).getText().toString().equals("")){} else {
                lime23 = Integer.valueOf(((TextView) findViewById(R.id.limeP2Y3_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP3Y3_field)).getText().toString().equals("")){} else {
                lime33 = Integer.valueOf(((TextView) findViewById(R.id.limeP3Y3_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP4Y3_field)).getText().toString().equals("")){} else {
                lime43 = Integer.valueOf(((TextView) findViewById(R.id.limeP4Y3_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP5Y3_field)).getText().toString().equals("")){} else {
                lime53 = Integer.valueOf(((TextView) findViewById(R.id.limeP5Y3_field)).getText().toString());
            }

            int totalY3 = gap13+lab13+lime13+gap23+lab23+lime23+gap33+lab33+lime33+gap43+lab43+lime43+gap53+lab53+lime53;
            setText2((TextView) findViewById(R.id.foundsNeededY3_field), String.valueOf(totalY3));

            int gap14 = 0;
            int lab14 = 0;
            int lime14 =  0;
            int gap24 =  0;
            int lab24 =  0;
            int lime24 =  0;
            int gap34 =  0;
            int lab34 =  0;
            int lime34 =  0;
            int gap44 =  0;
            int lab44 =  0;
            int lime44 =  0;
            int gap54 =  0;
            int lab54 =  0;
            int lime54 =  0;

            if (((TextView)findViewById(R.id.gapP1Y4_field)).getText().toString().equals("")) {} else {
                gap14 = Integer.valueOf(((TextView) findViewById(R.id.gapP1Y4_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP2Y4_field)).getText().toString().equals("")){} else {
                gap24 = Integer.valueOf(((TextView) findViewById(R.id.gapP2Y4_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP3Y4_field)).getText().toString().equals("")){} else {
                gap34 = Integer.valueOf(((TextView) findViewById(R.id.gapP3Y4_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP4Y4_field)).getText().toString().equals("")) {} else {
                gap44 = Integer.valueOf(((TextView) findViewById(R.id.gapP4Y4_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP5Y4_field)).getText().toString().equals("")){} else {
                gap54= Integer.valueOf(((TextView) findViewById(R.id.gapP5Y4_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP1Y4_field)).getText().toString().equals("")){} else {
                lab14 = Integer.valueOf(((TextView) findViewById(R.id.laborP1Y4_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP2Y4_field)).getText().toString().equals("")){} else {
                lab24 = Integer.valueOf(((TextView) findViewById(R.id.laborP2Y4_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP3Y4_field)).getText().toString().equals("")){} else {
                lab34 = Integer.valueOf(((TextView) findViewById(R.id.laborP3Y4_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP4Y4_field)).getText().toString().equals("")){} else {
                lab44 = Integer.valueOf(((TextView) findViewById(R.id.laborP4Y4_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP5Y4_field)).getText().toString().equals("")){} else {
                lab54 = Integer.valueOf(((TextView) findViewById(R.id.laborP5Y4_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP1Y4_field)).getText().toString().equals("")){} else {
                lime14 = Integer.valueOf(((TextView) findViewById(R.id.limeP1Y4_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP2Y4_field)).getText().toString().equals("")){} else {
                lime24 = Integer.valueOf(((TextView) findViewById(R.id.limeP2Y4_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP3Y4_field)).getText().toString().equals("")){} else {
                lime34 = Integer.valueOf(((TextView) findViewById(R.id.limeP3Y4_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP4Y4_field)).getText().toString().equals("")){} else {
                lime44 = Integer.valueOf(((TextView) findViewById(R.id.limeP4Y4_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP5Y4_field)).getText().toString().equals("")){} else {
                lime54 = Integer.valueOf(((TextView) findViewById(R.id.limeP5Y4_field)).getText().toString());
            }

            int totalY4 = gap14+lab14+lime14+gap24+lab24+lime24+gap34+lab34+lime34+gap44+lab44+lime44+gap54+lab54+lime54;
            setText2((TextView) findViewById(R.id.foundsNeededY4_field), String.valueOf(totalY4));

            int gap15 = 0;
            int lab15 = 0;
            int lime15 =  0;
            int gap25 =  0;
            int lab25 =  0;
            int lime25 =  0;
            int gap35 =  0;
            int lab35 =  0;
            int lime35 =  0;
            int gap45 =  0;
            int lab45 =  0;
            int lime45 =  0;
            int gap55 =  0;
            int lab55 =  0;
            int lime55 =  0;

            if (((TextView)findViewById(R.id.gapP1Y5_field)).getText().toString().equals("")) {} else {
                gap15 = Integer.valueOf(((TextView) findViewById(R.id.gapP1Y5_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP2Y5_field)).getText().toString().equals("")){} else {
                gap25 = Integer.valueOf(((TextView) findViewById(R.id.gapP2Y5_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP3Y5_field)).getText().toString().equals("")){} else {
                gap35 = Integer.valueOf(((TextView) findViewById(R.id.gapP3Y5_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP4Y5_field)).getText().toString().equals("")) {} else {
                gap45 = Integer.valueOf(((TextView) findViewById(R.id.gapP4Y5_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP5Y5_field)).getText().toString().equals("")){} else {
                gap55= Integer.valueOf(((TextView) findViewById(R.id.gapP5Y5_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP1Y5_field)).getText().toString().equals("")){} else {
                lab15 = Integer.valueOf(((TextView) findViewById(R.id.laborP1Y5_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP2Y5_field)).getText().toString().equals("")){} else {
                lab25 = Integer.valueOf(((TextView) findViewById(R.id.laborP2Y5_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP3Y5_field)).getText().toString().equals("")){} else {
                lab35 = Integer.valueOf(((TextView) findViewById(R.id.laborP3Y5_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP4Y5_field)).getText().toString().equals("")){} else {
                lab45 = Integer.valueOf(((TextView) findViewById(R.id.laborP4Y5_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP5Y5_field)).getText().toString().equals("")){} else {
                lab55 = Integer.valueOf(((TextView) findViewById(R.id.laborP5Y5_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP1Y5_field)).getText().toString().equals("")){} else {
                lime15 = Integer.valueOf(((TextView) findViewById(R.id.limeP1Y5_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP2Y5_field)).getText().toString().equals("")){} else {
                lime25 = Integer.valueOf(((TextView) findViewById(R.id.limeP2Y5_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP3Y5_field)).getText().toString().equals("")){} else {
                lime35 = Integer.valueOf(((TextView) findViewById(R.id.limeP3Y5_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP4Y5_field)).getText().toString().equals("")){} else {
                lime45 = Integer.valueOf(((TextView) findViewById(R.id.limeP4Y5_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP5Y5_field)).getText().toString().equals("")){} else {
                lime55 = Integer.valueOf(((TextView) findViewById(R.id.limeP5Y5_field)).getText().toString());
            }
            int totalY5 = gap15+lab15+lime15+gap25+lab25+lime25+gap35+lab35+lime35+gap45+lab45+lime45+gap55+lab55+lime55;
            setText2((TextView) findViewById(R.id.foundsNeededY5_field), String.valueOf(totalY5));

            int gap16 = 0;
            int lab16 = 0;
            int lime16 =  0;
            int gap26 =  0;
            int lab26 =  0;
            int lime26 =  0;
            int gap36 =  0;
            int lab36 =  0;
            int lime36 =  0;
            int gap46 =  0;
            int lab46 =  0;
            int lime46 =  0;
            int gap56 =  0;
            int lab56 =  0;
            int lime56 =  0;

            if (((TextView)findViewById(R.id.gapP1Y6_field)).getText().toString().equals("")) {} else {
                gap16 = Integer.valueOf(((TextView) findViewById(R.id.gapP1Y6_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP2Y6_field)).getText().toString().equals("")){} else {
                gap26 = Integer.valueOf(((TextView) findViewById(R.id.gapP2Y6_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP3Y6_field)).getText().toString().equals("")){} else {
                gap36 = Integer.valueOf(((TextView) findViewById(R.id.gapP3Y6_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP4Y6_field)).getText().toString().equals("")) {} else {
                gap46 = Integer.valueOf(((TextView) findViewById(R.id.gapP4Y6_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP5Y6_field)).getText().toString().equals("")){} else {
                gap56= Integer.valueOf(((TextView) findViewById(R.id.gapP5Y6_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP1Y6_field)).getText().toString().equals("")){} else {
                lab16 = Integer.valueOf(((TextView) findViewById(R.id.laborP1Y6_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP2Y6_field)).getText().toString().equals("")){} else {
                lab26 = Integer.valueOf(((TextView) findViewById(R.id.laborP2Y6_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP3Y6_field)).getText().toString().equals("")){} else {
                lab36 = Integer.valueOf(((TextView) findViewById(R.id.laborP3Y6_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP4Y6_field)).getText().toString().equals("")){} else {
                lab46 = Integer.valueOf(((TextView) findViewById(R.id.laborP4Y6_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP5Y6_field)).getText().toString().equals("")){} else {
                lab56 = Integer.valueOf(((TextView) findViewById(R.id.laborP5Y6_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP1Y6_field)).getText().toString().equals("")){} else {
                lime16 = Integer.valueOf(((TextView) findViewById(R.id.limeP1Y6_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP2Y6_field)).getText().toString().equals("")){} else {
                lime26 = Integer.valueOf(((TextView) findViewById(R.id.limeP2Y6_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP3Y6_field)).getText().toString().equals("")){} else {
                lime36 = Integer.valueOf(((TextView) findViewById(R.id.limeP3Y6_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP4Y6_field)).getText().toString().equals("")){} else {
                lime46 = Integer.valueOf(((TextView) findViewById(R.id.limeP4Y6_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP5Y6_field)).getText().toString().equals("")){} else {
                lime56 = Integer.valueOf(((TextView) findViewById(R.id.limeP5Y6_field)).getText().toString());
            }

            int totalY6 = gap16+lab16+lime16+gap26+lab26+lime26+gap36+lab36+lime36+gap46+lab46+lime46+gap56+lab56+lime56;
            setText2((TextView) findViewById(R.id.foundsNeededY6_field), String.valueOf(totalY6));

            int gap17 = 0;
            int lab17 = 0;
            int lime17 =  0;
            int gap27 =  0;
            int lab27 =  0;
            int lime27 =  0;
            int gap37 =  0;
            int lab37 =  0;
            int lime37 =  0;
            int gap47 =  0;
            int lab47 =  0;
            int lime47 =  0;
            int gap57 =  0;
            int lab57 =  0;
            int lime57 =  0;

            if (((TextView)findViewById(R.id.gapP1Y7_field)).getText().toString().equals("")) {} else {
                gap17 = Integer.valueOf(((TextView) findViewById(R.id.gapP1Y7_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP2Y7_field)).getText().toString().equals("")){} else {
                gap27 = Integer.valueOf(((TextView) findViewById(R.id.gapP2Y7_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP3Y7_field)).getText().toString().equals("")){} else {
                gap37 = Integer.valueOf(((TextView) findViewById(R.id.gapP3Y7_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP4Y7_field)).getText().toString().equals("")) {} else {
                gap47 = Integer.valueOf(((TextView) findViewById(R.id.gapP4Y7_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.gapP5Y7_field)).getText().toString().equals("")){} else {
                gap57= Integer.valueOf(((TextView) findViewById(R.id.gapP5Y7_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP1Y7_field)).getText().toString().equals("")){} else {
                lab17 = Integer.valueOf(((TextView) findViewById(R.id.laborP1Y7_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP2Y7_field)).getText().toString().equals("")){} else {
                lab27 = Integer.valueOf(((TextView) findViewById(R.id.laborP2Y7_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP3Y7_field)).getText().toString().equals("")){} else {
                lab37 = Integer.valueOf(((TextView) findViewById(R.id.laborP3Y7_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP4Y7_field)).getText().toString().equals("")){} else {
                lab47 = Integer.valueOf(((TextView) findViewById(R.id.laborP4Y7_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.laborP5Y7_field)).getText().toString().equals("")){} else {
                lab57 = Integer.valueOf(((TextView) findViewById(R.id.laborP5Y7_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP1Y7_field)).getText().toString().equals("")){} else {
                lime17 = Integer.valueOf(((TextView) findViewById(R.id.limeP1Y7_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP2Y7_field)).getText().toString().equals("")){} else {
                lime27 = Integer.valueOf(((TextView) findViewById(R.id.limeP2Y7_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP3Y7_field)).getText().toString().equals("")){} else {
                lime37 = Integer.valueOf(((TextView) findViewById(R.id.limeP3Y7_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP4Y7_field)).getText().toString().equals("")){} else {
                lime47 = Integer.valueOf(((TextView) findViewById(R.id.limeP4Y7_field)).getText().toString());
            }
            if (((TextView)findViewById(R.id.limeP5Y7_field)).getText().toString().equals("")){} else {
                lime57 = Integer.valueOf(((TextView) findViewById(R.id.limeP5Y7_field)).getText().toString());
            }

            int totalY7 = gap17+lab17+lime17+gap27+lab27+lime27+gap37+lab37+lime37+gap47+lab47+lime47+gap57+lab57+lime57;
            setText2((TextView) findViewById(R.id.foundsNeededY7_field), String.valueOf(totalY7));
            //profit or lost
            int pl1 = availableY1-totalY1;
            int pl2 = availableY2-totalY2;
            int pl3 = availableY3-totalY3;
            int pl4 = availableY4-totalY4;
            int pl5 = availableY5-totalY5;
            int pl6 = availableY6-totalY6;
            int pl7 = availableY7-totalY7;
            setText2((TextView) findViewById(R.id.profitOrLostY1_field), String.valueOf(pl1));
            setText2((TextView) findViewById(R.id.profitOrLostY2_field), String.valueOf(pl2));
            setText2((TextView) findViewById(R.id.profitOrLostY3_field), String.valueOf(pl3));
            setText2((TextView) findViewById(R.id.profitOrLostY4_field), String.valueOf(pl4));
            setText2((TextView) findViewById(R.id.profitOrLostY5_field), String.valueOf(pl5));
            setText2((TextView) findViewById(R.id.profitOrLostY6_field), String.valueOf(pl6));
            setText2((TextView) findViewById(R.id.profitOrLostY7_field), String.valueOf(pl7));
        }
    }

    private void setText(EditText textField, String text) {   if (textField != null) {
            textField.setText(text);
        }
    }

    private void setText2(TextView textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }


    private void save() {
        final String start1 = ((Spinner) findViewById(R.id.startP1_field)).getSelectedItem().toString();
        final String start2 = ((Spinner) findViewById(R.id.startP2_field)).getSelectedItem().toString();
        final String start3 = ((Spinner) findViewById(R.id.startP3_field)).getSelectedItem().toString();
        final String start4 = ((Spinner) findViewById(R.id.startP4_field)).getSelectedItem().toString();
        final String start5 = ((Spinner) findViewById(R.id.startP5_field)).getSelectedItem().toString();
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
            contact.put(ContactObject.STARTYEARP1, start1);
            contact.put(ContactObject.STARTYEARP2, start2);
            contact.put(ContactObject.STARTYEARP3, start3);
            contact.put(ContactObject.STARTYEARP4, start4);
            contact.put(ContactObject.STARTYEARP5, start5);
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
