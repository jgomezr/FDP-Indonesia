package org.grameenfoundation.fdp.ui;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.smartsync.app.SmartSyncSDKManager;
import com.salesforce.androidsdk.ui.SalesforceActivity;
import org.grameenfoundation.fdp.R;
import org.grameenfoundation.fdp.loaders.ContactDetailLoader;
import org.grameenfoundation.fdp.objects.ContactObject;


/**
 * Created by julian_Gf on 7/8/2016.
 */
public class YearDetailActivity extends SalesforceActivity implements LoaderManager.LoaderCallbacks<ContactObject> {
    private static final int CONTACT_DETAIL_LOADER_ID = 2;
    private static final String TAG = "SmartSyncExplorer: YearDetailActivity";
    private UserAccount curAccount;
    private String objectId;
    private String objectTitle;
    private String objNameKey;
    private String yearLaunch;
    private ContactObject sObject;
    public static final String OBJECT_ID_KEY = "object_id";
    public static final String OBJECT_TITLE_KEY = "object_title";
    public static final String OBJECT_NAME_KEY = "object_name";
    private TextView p1,p2,p3,p4,p5;
    private LinearLayout p1jan,p1feb,p1mar,p1apr,p1may,p1jun,p1jul,p1aug,p1sep,p1oct,p1nov,p1dec,p2jan,p2feb,p2mar,p2apr,p2may,p2jun,p2jul,p2aug,p2sep,p2oct,p2nov,p2dec,p3jan,p3feb,p3mar,p3apr,p3may,p3jun,p3jul,p3aug,p3sep,p3oct,p3nov,p3dec,p4jan,p4feb,p4mar,p4apr,p4may,p4jun,p4jul,p4aug,p4sep,p4oct,p4nov,p4dec,p5jan,p5feb,p5mar,p5apr,p5may,p5jun,p5jul,p5aug,p5sep,p5oct,p5nov,p5dec;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yeardetail);
        final Intent launchIntent = getIntent();
        if (launchIntent != null) {
            objectId = launchIntent.getStringExtra(fdpActivity.OBJECT_ID_KEY);
            objectTitle = launchIntent.getStringExtra(fdpActivity.OBJECT_TITLE_KEY);
            objNameKey = launchIntent.getStringExtra(fdpActivity.OBJECT_NAME_KEY);
            yearLaunch = launchIntent.getStringExtra(fdpActivity.YEAR_LAUNCH);
        }
        p1 = (TextView)findViewById(R.id.pt1);
        p2 = (TextView)findViewById(R.id.pt2);
        p3 = (TextView)findViewById(R.id.pt3);
        p4 = (TextView)findViewById(R.id.pt4);
        p5 = (TextView)findViewById(R.id.pt5);
        p1jan = (LinearLayout) findViewById(R.id.p1j);
        p1feb = (LinearLayout) findViewById(R.id.p1f);
        p1mar = (LinearLayout) findViewById(R.id.p1mr);
        p1apr = (LinearLayout) findViewById(R.id.p1a);
        p1may = (LinearLayout) findViewById(R.id.p1my);
        p1jun = (LinearLayout) findViewById(R.id.p1jn);
        p1jul = (LinearLayout) findViewById(R.id.p1jl);
        p1aug = (LinearLayout) findViewById(R.id.p1ag);
        p1sep = (LinearLayout) findViewById(R.id.p1sp);
        p1oct = (LinearLayout) findViewById(R.id.p1oc);
        p1nov = (LinearLayout) findViewById(R.id.p1nv);
        p1dec = (LinearLayout) findViewById(R.id.p1dc);
        p2jan = (LinearLayout) findViewById(R.id.p2j);
        p2feb = (LinearLayout) findViewById(R.id.p2f);
        p2mar = (LinearLayout) findViewById(R.id.p2mr);
        p2apr = (LinearLayout) findViewById(R.id.p2a);
        p2may = (LinearLayout) findViewById(R.id.p2my);
        p2jun = (LinearLayout) findViewById(R.id.p2jn);
        p2jul = (LinearLayout) findViewById(R.id.p2jl);
        p2aug = (LinearLayout) findViewById(R.id.p2ag);
        p2sep = (LinearLayout) findViewById(R.id.p2sp);
        p2oct = (LinearLayout) findViewById(R.id.p2oc);
        p2nov = (LinearLayout) findViewById(R.id.p2nv);
        p2dec = (LinearLayout) findViewById(R.id.p2dc);
        p3jan = (LinearLayout) findViewById(R.id.p3j);
        p3feb = (LinearLayout) findViewById(R.id.p3f);
        p3mar = (LinearLayout) findViewById(R.id.p3mr);
        p3apr = (LinearLayout) findViewById(R.id.p3a);
        p3may = (LinearLayout) findViewById(R.id.p3my);
        p3jun = (LinearLayout) findViewById(R.id.p3jn);
        p3jul = (LinearLayout) findViewById(R.id.p3jl);
        p3aug = (LinearLayout) findViewById(R.id.p3ag);
        p3sep = (LinearLayout) findViewById(R.id.p3sp);
        p3oct = (LinearLayout) findViewById(R.id.p3oc);
        p3nov = (LinearLayout) findViewById(R.id.p3nv);
        p3dec = (LinearLayout) findViewById(R.id.p3dc);
        p4jan = (LinearLayout) findViewById(R.id.p4j);
        p4feb = (LinearLayout) findViewById(R.id.p4f);
        p4mar = (LinearLayout) findViewById(R.id.p4mr);
        p4apr = (LinearLayout) findViewById(R.id.p4a);
        p4may = (LinearLayout) findViewById(R.id.p4my);
        p4jun = (LinearLayout) findViewById(R.id.p4jn);
        p4jul = (LinearLayout) findViewById(R.id.p4jl);
        p4aug = (LinearLayout) findViewById(R.id.p4ag);
        p4sep = (LinearLayout) findViewById(R.id.p4sp);
        p4oct = (LinearLayout) findViewById(R.id.p4oc);
        p4nov = (LinearLayout) findViewById(R.id.p4nv);
        p4dec = (LinearLayout) findViewById(R.id.p4dc);
        p5jan = (LinearLayout) findViewById(R.id.p5j);
        p5feb = (LinearLayout) findViewById(R.id.p5f);
        p5mar = (LinearLayout) findViewById(R.id.p5mr);
        p5apr = (LinearLayout) findViewById(R.id.p5a);
        p5may = (LinearLayout) findViewById(R.id.p5my);
        p5jun = (LinearLayout) findViewById(R.id.p5jn);
        p5jul = (LinearLayout) findViewById(R.id.p5jl);
        p5aug = (LinearLayout) findViewById(R.id.p5ag);
        p5sep = (LinearLayout) findViewById(R.id.p5sp);
        p5oct = (LinearLayout) findViewById(R.id.p5oc);
        p5nov = (LinearLayout) findViewById(R.id.p5nv);
        p5dec = (LinearLayout) findViewById(R.id.p5dc);
    }

    @Override
    public void onResume(RestClient client) {
        curAccount = SmartSyncSDKManager.getInstance().getUserAccountManager().getCurrentUser();
        getLoaderManager().initLoader(CONTACT_DETAIL_LOADER_ID, null, this).forceLoad();
    }

    public void onBackClicked(View view) {
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

    private void refreshScreen() {
        if (sObject != null) {
            //visibility of plots
            if (sObject.getNumberOfPlots().equals("1")){
                p1.setVisibility(View.VISIBLE);
                p1jan.setVisibility(View.VISIBLE);
                p1feb.setVisibility(View.VISIBLE);
                p1mar.setVisibility(View.VISIBLE);
                p1apr.setVisibility(View.VISIBLE);
                p1may.setVisibility(View.VISIBLE);
                p1jun.setVisibility(View.VISIBLE);
                p1jul.setVisibility(View.VISIBLE);
                p1aug.setVisibility(View.VISIBLE);
                p1sep.setVisibility(View.VISIBLE);
                p1oct.setVisibility(View.VISIBLE);
                p1nov.setVisibility(View.VISIBLE);
                p1dec.setVisibility(View.VISIBLE);

            }else if (sObject.getNumberOfPlots().equals("2")){
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.VISIBLE);
                p1jan.setVisibility(View.VISIBLE);
                p1feb.setVisibility(View.VISIBLE);
                p1mar.setVisibility(View.VISIBLE);
                p1apr.setVisibility(View.VISIBLE);
                p1may.setVisibility(View.VISIBLE);
                p1jun.setVisibility(View.VISIBLE);
                p1jul.setVisibility(View.VISIBLE);
                p1aug.setVisibility(View.VISIBLE);
                p1sep.setVisibility(View.VISIBLE);
                p1oct.setVisibility(View.VISIBLE);
                p1nov.setVisibility(View.VISIBLE);
                p1dec.setVisibility(View.VISIBLE);
                p2jan.setVisibility(View.VISIBLE);
                p2feb.setVisibility(View.VISIBLE);
                p2mar.setVisibility(View.VISIBLE);
                p2apr.setVisibility(View.VISIBLE);
                p2may.setVisibility(View.VISIBLE);
                p2jun.setVisibility(View.VISIBLE);
                p2jul.setVisibility(View.VISIBLE);
                p2aug.setVisibility(View.VISIBLE);
                p2sep.setVisibility(View.VISIBLE);
                p2oct.setVisibility(View.VISIBLE);
                p2nov.setVisibility(View.VISIBLE);
                p2dec.setVisibility(View.VISIBLE);

            }else if (sObject.getNumberOfPlots().equals("3")){
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.VISIBLE);
                p3.setVisibility(View.VISIBLE);
                p1jan.setVisibility(View.VISIBLE);
                p1feb.setVisibility(View.VISIBLE);
                p1mar.setVisibility(View.VISIBLE);
                p1apr.setVisibility(View.VISIBLE);
                p1may.setVisibility(View.VISIBLE);
                p1jun.setVisibility(View.VISIBLE);
                p1jul.setVisibility(View.VISIBLE);
                p1aug.setVisibility(View.VISIBLE);
                p1sep.setVisibility(View.VISIBLE);
                p1oct.setVisibility(View.VISIBLE);
                p1nov.setVisibility(View.VISIBLE);
                p1dec.setVisibility(View.VISIBLE);
                p2jan.setVisibility(View.VISIBLE);
                p2feb.setVisibility(View.VISIBLE);
                p2mar.setVisibility(View.VISIBLE);
                p2apr.setVisibility(View.VISIBLE);
                p2may.setVisibility(View.VISIBLE);
                p2jun.setVisibility(View.VISIBLE);
                p2jul.setVisibility(View.VISIBLE);
                p2aug.setVisibility(View.VISIBLE);
                p2sep.setVisibility(View.VISIBLE);
                p2oct.setVisibility(View.VISIBLE);
                p2nov.setVisibility(View.VISIBLE);
                p2dec.setVisibility(View.VISIBLE);
                p3jan.setVisibility(View.VISIBLE);
                p3feb.setVisibility(View.VISIBLE);
                p3mar.setVisibility(View.VISIBLE);
                p3apr.setVisibility(View.VISIBLE);
                p3may.setVisibility(View.VISIBLE);
                p3jun.setVisibility(View.VISIBLE);
                p3jul.setVisibility(View.VISIBLE);
                p3aug.setVisibility(View.VISIBLE);
                p3sep.setVisibility(View.VISIBLE);
                p3oct.setVisibility(View.VISIBLE);
                p3nov.setVisibility(View.VISIBLE);
                p3dec.setVisibility(View.VISIBLE);

            }else if (sObject.getNumberOfPlots().equals("4")){
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.VISIBLE);
                p3.setVisibility(View.VISIBLE);
                p4.setVisibility(View.VISIBLE);
                p1jan.setVisibility(View.VISIBLE);
                p1feb.setVisibility(View.VISIBLE);
                p1mar.setVisibility(View.VISIBLE);
                p1apr.setVisibility(View.VISIBLE);
                p1may.setVisibility(View.VISIBLE);
                p1jun.setVisibility(View.VISIBLE);
                p1jul.setVisibility(View.VISIBLE);
                p1aug.setVisibility(View.VISIBLE);
                p1sep.setVisibility(View.VISIBLE);
                p1oct.setVisibility(View.VISIBLE);
                p1nov.setVisibility(View.VISIBLE);
                p1dec.setVisibility(View.VISIBLE);
                p2jan.setVisibility(View.VISIBLE);
                p2feb.setVisibility(View.VISIBLE);
                p2mar.setVisibility(View.VISIBLE);
                p2apr.setVisibility(View.VISIBLE);
                p2may.setVisibility(View.VISIBLE);
                p2jun.setVisibility(View.VISIBLE);
                p2jul.setVisibility(View.VISIBLE);
                p2aug.setVisibility(View.VISIBLE);
                p2sep.setVisibility(View.VISIBLE);
                p2oct.setVisibility(View.VISIBLE);
                p2nov.setVisibility(View.VISIBLE);
                p2dec.setVisibility(View.VISIBLE);
                p3jan.setVisibility(View.VISIBLE);
                p3feb.setVisibility(View.VISIBLE);
                p3mar.setVisibility(View.VISIBLE);
                p3apr.setVisibility(View.VISIBLE);
                p3may.setVisibility(View.VISIBLE);
                p3jun.setVisibility(View.VISIBLE);
                p3jul.setVisibility(View.VISIBLE);
                p3aug.setVisibility(View.VISIBLE);
                p3sep.setVisibility(View.VISIBLE);
                p3oct.setVisibility(View.VISIBLE);
                p3nov.setVisibility(View.VISIBLE);
                p3dec.setVisibility(View.VISIBLE);
                p4jan.setVisibility(View.VISIBLE);
                p4feb.setVisibility(View.VISIBLE);
                p4mar.setVisibility(View.VISIBLE);
                p4apr.setVisibility(View.VISIBLE);
                p4may.setVisibility(View.VISIBLE);
                p4jun.setVisibility(View.VISIBLE);
                p4jul.setVisibility(View.VISIBLE);
                p4aug.setVisibility(View.VISIBLE);
                p4sep.setVisibility(View.VISIBLE);
                p4oct.setVisibility(View.VISIBLE);
                p4nov.setVisibility(View.VISIBLE);
                p4dec.setVisibility(View.VISIBLE);

            }else{
                p1.setVisibility(View.VISIBLE);
                p2.setVisibility(View.VISIBLE);
                p3.setVisibility(View.VISIBLE);
                p4.setVisibility(View.VISIBLE);
                p5.setVisibility(View.VISIBLE);
                p1jan.setVisibility(View.VISIBLE);
                p1feb.setVisibility(View.VISIBLE);
                p1mar.setVisibility(View.VISIBLE);
                p1apr.setVisibility(View.VISIBLE);
                p1may.setVisibility(View.VISIBLE);
                p1jun.setVisibility(View.VISIBLE);
                p1jul.setVisibility(View.VISIBLE);
                p1aug.setVisibility(View.VISIBLE);
                p1sep.setVisibility(View.VISIBLE);
                p1oct.setVisibility(View.VISIBLE);
                p1nov.setVisibility(View.VISIBLE);
                p1dec.setVisibility(View.VISIBLE);
                p2jan.setVisibility(View.VISIBLE);
                p2feb.setVisibility(View.VISIBLE);
                p2mar.setVisibility(View.VISIBLE);
                p2apr.setVisibility(View.VISIBLE);
                p2may.setVisibility(View.VISIBLE);
                p2jun.setVisibility(View.VISIBLE);
                p2jul.setVisibility(View.VISIBLE);
                p2aug.setVisibility(View.VISIBLE);
                p2sep.setVisibility(View.VISIBLE);
                p2oct.setVisibility(View.VISIBLE);
                p2nov.setVisibility(View.VISIBLE);
                p2dec.setVisibility(View.VISIBLE);
                p3jan.setVisibility(View.VISIBLE);
                p3feb.setVisibility(View.VISIBLE);
                p3mar.setVisibility(View.VISIBLE);
                p3apr.setVisibility(View.VISIBLE);
                p3may.setVisibility(View.VISIBLE);
                p3jun.setVisibility(View.VISIBLE);
                p3jul.setVisibility(View.VISIBLE);
                p3aug.setVisibility(View.VISIBLE);
                p3sep.setVisibility(View.VISIBLE);
                p3oct.setVisibility(View.VISIBLE);
                p3nov.setVisibility(View.VISIBLE);
                p3dec.setVisibility(View.VISIBLE);
                p4jan.setVisibility(View.VISIBLE);
                p4feb.setVisibility(View.VISIBLE);
                p4mar.setVisibility(View.VISIBLE);
                p4apr.setVisibility(View.VISIBLE);
                p4may.setVisibility(View.VISIBLE);
                p4jun.setVisibility(View.VISIBLE);
                p4jul.setVisibility(View.VISIBLE);
                p4aug.setVisibility(View.VISIBLE);
                p4sep.setVisibility(View.VISIBLE);
                p4oct.setVisibility(View.VISIBLE);
                p4nov.setVisibility(View.VISIBLE);
                p4dec.setVisibility(View.VISIBLE);
                p5jan.setVisibility(View.VISIBLE);
                p5feb.setVisibility(View.VISIBLE);
                p5mar.setVisibility(View.VISIBLE);
                p5apr.setVisibility(View.VISIBLE);
                p5may.setVisibility(View.VISIBLE);
                p5jun.setVisibility(View.VISIBLE);
                p5jul.setVisibility(View.VISIBLE);
                p5aug.setVisibility(View.VISIBLE);
                p5sep.setVisibility(View.VISIBLE);
                p5oct.setVisibility(View.VISIBLE);
                p5nov.setVisibility(View.VISIBLE);
                p5dec.setVisibility(View.VISIBLE);

            }

            //conditions to show info per plot
            if (yearLaunch.equals("1")){
                setText((TextView) findViewById(R.id.yearDetail),"YEAR 1");
                //plot 1
                if (sObject.getFarmCondition1().equals("B") || sObject.getTreeDensity1().equals("B") || sObject.getDebilitatingDisease1().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth1().equals("G")&&(sObject.getPlantingMaterial1().equals("M")||sObject.getPlantingMaterial1().equals("B"))&&(sObject.getTreeAge1().equals("G")||sObject.getTreeAge1().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial1().equals("G") || sObject.getPlantingMaterial1().equals("M")) && sObject.getFarmCondition1().equals("G") && sObject.getTreeDensity1().equals("G") && sObject.getTreeAge1().equals("G") && sObject.getTreeHealth1().equals("G") && sObject.getDebilitatingDisease1().equals("G") && (sObject.getPruning1().equals("G") || sObject.getPruning1().equals("M")) && (sObject.getPestDiseaseSanitation1().equals("G") || sObject.getPestDiseaseSanitation1().equals("M")) && sObject.getWeeding1().equals("G") && sObject.getHarvesting1().equals("G") && sObject.getShadeManagement1().equals("G") && sObject.getSoilCondition1().equals("B") || sObject.getOrganicMatter1().equals("B") || sObject.getFertilizerFormulation1().equals("B") || sObject.getFertilizerApplication1().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 2
                if (sObject.getFarmCondition2().equals("B") || sObject.getTreeDensity2().equals("B") || sObject.getDebilitatingDisease2().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth2().equals("G")&&(sObject.getPlantingMaterial2().equals("M")||sObject.getPlantingMaterial2().equals("B"))&&(sObject.getTreeAge2().equals("G")||sObject.getTreeAge2().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial2().equals("G") || sObject.getPlantingMaterial2().equals("M")) && sObject.getFarmCondition2().equals("G") && sObject.getTreeDensity2().equals("G") && sObject.getTreeAge2().equals("G") && sObject.getTreeHealth2().equals("G") && sObject.getDebilitatingDisease2().equals("G") && (sObject.getPruning2().equals("G") || sObject.getPruning2().equals("M")) && (sObject.getPestDiseaseSanitation2().equals("G") || sObject.getPestDiseaseSanitation2().equals("M")) && sObject.getWeeding2().equals("G") && sObject.getHarvesting2().equals("G") && sObject.getShadeManagement2().equals("G") && sObject.getSoilCondition2().equals("B") || sObject.getOrganicMatter2().equals("B") || sObject.getFertilizerFormulation2().equals("B") || sObject.getFartilizerApplication2().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 3
                if (sObject.getFarmCondition3().equals("B") || sObject.getTreeDensity3().equals("B") || sObject.getDebilitatingDisease3().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth3().equals("G")&&(sObject.getPlantingMaterial3().equals("M")||sObject.getPlantingMaterial3().equals("B"))&&(sObject.getTreeAge3().equals("G")||sObject.getTreeAge3().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial3().equals("G") || sObject.getPlantingMaterial3().equals("M")) && sObject.getFarmCondition3().equals("G") && sObject.getTreeDensity3().equals("G") && sObject.getTreeAge3().equals("G") && sObject.getTreeHealth3().equals("G") && sObject.getDebilitatingDisease3().equals("G") && (sObject.getPruning3().equals("G") || sObject.getPruning3().equals("M")) && (sObject.getPestDiseaseSanitation3().equals("G") || sObject.getPestDiseaseSanitation3().equals("M")) && sObject.getWeeding3().equals("G") && sObject.getHarvesting3().equals("G") && sObject.getShadeManagement3().equals("G") && sObject.getSoilCondition3().equals("B") || sObject.getOrganicMatter3().equals("B") || sObject.getFertilizerFormulation3().equals("B") || sObject.getFertilizerApplication3().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 4
                if (sObject.getFarmCondition4().equals("B") || sObject.getTreeDensity4().equals("B") || sObject.getDebilitatingDisease4().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth4().equals("G")&&(sObject.getPlantingMaterial4().equals("M")||sObject.getPlantingMaterial4().equals("B"))&&(sObject.getTreeAge4().equals("G")||sObject.getTreeAge4().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial4().equals("G") || sObject.getPlantingMaterial4().equals("M")) && sObject.getFarmCondition4().equals("G") && sObject.getTreeDensity4().equals("G") && sObject.getTreeAge4().equals("G") && sObject.getTreeHealth4().equals("G") && sObject.getDebilitatingDisease4().equals("G") && (sObject.getPruning4().equals("G") || sObject.getPruning4().equals("M")) && (sObject.getPestDiseaseSanitation4().equals("G") || sObject.getPestDiseaseSanitation4().equals("M")) && sObject.getWeeding4().equals("G") && sObject.getHarvesting4().equals("G") && sObject.getShadeManagement4().equals("G") && sObject.getSoilCondition4().equals("B") || sObject.getOrganicMatter4().equals("B") || sObject.getFertilizerFormulation4().equals("B") || sObject.getFertilizerApplication4().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 5
                if (sObject.getFarmCondition5().equals("B") || sObject.getTreeDensity5().equals("B") || sObject.getDebilitatingDisease5().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth5().equals("G")&&(sObject.getPlantingMaterial5().equals("M")||sObject.getPlantingMaterial5().equals("B"))&&(sObject.getTreeAge5().equals("G")||sObject.getTreeAge5().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial5().equals("G") || sObject.getPlantingMaterial5().equals("M")) && sObject.getFarmCondition5().equals("G") && sObject.getTreeDensity5().equals("G") && sObject.getTreeAge5().equals("G") && sObject.getTreeHealth5().equals("G") && sObject.getDebilitatingDisease5().equals("G") && (sObject.getPruning5().equals("G") || sObject.getPruning5().equals("M")) && (sObject.getPestDiseaseSanitation5().equals("G") || sObject.getPestDiseaseSanitation5().equals("M")) && sObject.getWeeding5().equals("G") && sObject.getHarvesting5().equals("G") && sObject.getShadeManagement5().equals("G") && sObject.getSoilCondition5().equals("B") || sObject.getOrganicMatter5().equals("B") || sObject.getFertilizerFormulation5().equals("B") || sObject.getFertilizerApplication5().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }
            }
            if (yearLaunch.equals("2")){
                setText((TextView) findViewById(R.id.yearDetail),"YEAR 2");
                //plot 1
                if (sObject.getFarmCondition1().equals("B") || sObject.getTreeDensity1().equals("B") || sObject.getDebilitatingDisease1().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth1().equals("G")&&(sObject.getPlantingMaterial1().equals("M")||sObject.getPlantingMaterial1().equals("B"))&&(sObject.getTreeAge1().equals("G")||sObject.getTreeAge1().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial1().equals("G") || sObject.getPlantingMaterial1().equals("M")) && sObject.getFarmCondition1().equals("G") && sObject.getTreeDensity1().equals("G") && sObject.getTreeAge1().equals("G") && sObject.getTreeHealth1().equals("G") && sObject.getDebilitatingDisease1().equals("G") && (sObject.getPruning1().equals("G") || sObject.getPruning1().equals("M")) && (sObject.getPestDiseaseSanitation1().equals("G") || sObject.getPestDiseaseSanitation1().equals("M")) && sObject.getWeeding1().equals("G") && sObject.getHarvesting1().equals("G") && sObject.getShadeManagement1().equals("G") && sObject.getSoilCondition1().equals("B") || sObject.getOrganicMatter1().equals("B") || sObject.getFertilizerFormulation1().equals("B") || sObject.getFertilizerApplication1().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 2
                if (sObject.getFarmCondition2().equals("B") || sObject.getTreeDensity2().equals("B") || sObject.getDebilitatingDisease2().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth2().equals("G")&&(sObject.getPlantingMaterial2().equals("M")||sObject.getPlantingMaterial2().equals("B"))&&(sObject.getTreeAge2().equals("G")||sObject.getTreeAge2().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial2().equals("G") || sObject.getPlantingMaterial2().equals("M")) && sObject.getFarmCondition2().equals("G") && sObject.getTreeDensity2().equals("G") && sObject.getTreeAge2().equals("G") && sObject.getTreeHealth2().equals("G") && sObject.getDebilitatingDisease2().equals("G") && (sObject.getPruning2().equals("G") || sObject.getPruning2().equals("M")) && (sObject.getPestDiseaseSanitation2().equals("G") || sObject.getPestDiseaseSanitation2().equals("M")) && sObject.getWeeding2().equals("G") && sObject.getHarvesting2().equals("G") && sObject.getShadeManagement2().equals("G") && sObject.getSoilCondition2().equals("B") || sObject.getOrganicMatter2().equals("B") || sObject.getFertilizerFormulation2().equals("B") || sObject.getFartilizerApplication2().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 3
                if (sObject.getFarmCondition3().equals("B") || sObject.getTreeDensity3().equals("B") || sObject.getDebilitatingDisease3().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth3().equals("G")&&(sObject.getPlantingMaterial3().equals("M")||sObject.getPlantingMaterial3().equals("B"))&&(sObject.getTreeAge3().equals("G")||sObject.getTreeAge3().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial3().equals("G") || sObject.getPlantingMaterial3().equals("M")) && sObject.getFarmCondition3().equals("G") && sObject.getTreeDensity3().equals("G") && sObject.getTreeAge3().equals("G") && sObject.getTreeHealth3().equals("G") && sObject.getDebilitatingDisease3().equals("G") && (sObject.getPruning3().equals("G") || sObject.getPruning3().equals("M")) && (sObject.getPestDiseaseSanitation3().equals("G") || sObject.getPestDiseaseSanitation3().equals("M")) && sObject.getWeeding3().equals("G") && sObject.getHarvesting3().equals("G") && sObject.getShadeManagement3().equals("G") && sObject.getSoilCondition3().equals("B") || sObject.getOrganicMatter3().equals("B") || sObject.getFertilizerFormulation3().equals("B") || sObject.getFertilizerApplication3().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 4
                if (sObject.getFarmCondition4().equals("B") || sObject.getTreeDensity4().equals("B") || sObject.getDebilitatingDisease4().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth4().equals("G")&&(sObject.getPlantingMaterial4().equals("M")||sObject.getPlantingMaterial4().equals("B"))&&(sObject.getTreeAge4().equals("G")||sObject.getTreeAge4().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial4().equals("G") || sObject.getPlantingMaterial4().equals("M")) && sObject.getFarmCondition4().equals("G") && sObject.getTreeDensity4().equals("G") && sObject.getTreeAge4().equals("G") && sObject.getTreeHealth4().equals("G") && sObject.getDebilitatingDisease4().equals("G") && (sObject.getPruning4().equals("G") || sObject.getPruning4().equals("M")) && (sObject.getPestDiseaseSanitation4().equals("G") || sObject.getPestDiseaseSanitation4().equals("M")) && sObject.getWeeding4().equals("G") && sObject.getHarvesting4().equals("G") && sObject.getShadeManagement4().equals("G") && sObject.getSoilCondition4().equals("B") || sObject.getOrganicMatter4().equals("B") || sObject.getFertilizerFormulation4().equals("B") || sObject.getFertilizerApplication4().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 5
                if (sObject.getFarmCondition5().equals("B") || sObject.getTreeDensity5().equals("B") || sObject.getDebilitatingDisease5().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth5().equals("G")&&(sObject.getPlantingMaterial5().equals("M")||sObject.getPlantingMaterial5().equals("B"))&&(sObject.getTreeAge5().equals("G")||sObject.getTreeAge5().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial5().equals("G") || sObject.getPlantingMaterial5().equals("M")) && sObject.getFarmCondition5().equals("G") && sObject.getTreeDensity5().equals("G") && sObject.getTreeAge5().equals("G") && sObject.getTreeHealth5().equals("G") && sObject.getDebilitatingDisease5().equals("G") && (sObject.getPruning5().equals("G") || sObject.getPruning5().equals("M")) && (sObject.getPestDiseaseSanitation5().equals("G") || sObject.getPestDiseaseSanitation5().equals("M")) && sObject.getWeeding5().equals("G") && sObject.getHarvesting5().equals("G") && sObject.getShadeManagement5().equals("G") && sObject.getSoilCondition5().equals("B") || sObject.getOrganicMatter5().equals("B") || sObject.getFertilizerFormulation5().equals("B") || sObject.getFertilizerApplication5().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }
            }
            if (yearLaunch.equals("3")){
                setText((TextView) findViewById(R.id.yearDetail),"YEAR 3");
                //plot 1
                if (sObject.getFarmCondition1().equals("B") || sObject.getTreeDensity1().equals("B") || sObject.getDebilitatingDisease1().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth1().equals("G")&&(sObject.getPlantingMaterial1().equals("M")||sObject.getPlantingMaterial1().equals("B"))&&(sObject.getTreeAge1().equals("G")||sObject.getTreeAge1().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial1().equals("G") || sObject.getPlantingMaterial1().equals("M")) && sObject.getFarmCondition1().equals("G") && sObject.getTreeDensity1().equals("G") && sObject.getTreeAge1().equals("G") && sObject.getTreeHealth1().equals("G") && sObject.getDebilitatingDisease1().equals("G") && (sObject.getPruning1().equals("G") || sObject.getPruning1().equals("M")) && (sObject.getPestDiseaseSanitation1().equals("G") || sObject.getPestDiseaseSanitation1().equals("M")) && sObject.getWeeding1().equals("G") && sObject.getHarvesting1().equals("G") && sObject.getShadeManagement1().equals("G") && sObject.getSoilCondition1().equals("B") || sObject.getOrganicMatter1().equals("B") || sObject.getFertilizerFormulation1().equals("B") || sObject.getFertilizerApplication1().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 2
                if (sObject.getFarmCondition2().equals("B") || sObject.getTreeDensity2().equals("B") || sObject.getDebilitatingDisease2().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth2().equals("G")&&(sObject.getPlantingMaterial2().equals("M")||sObject.getPlantingMaterial2().equals("B"))&&(sObject.getTreeAge2().equals("G")||sObject.getTreeAge2().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial2().equals("G") || sObject.getPlantingMaterial2().equals("M")) && sObject.getFarmCondition2().equals("G") && sObject.getTreeDensity2().equals("G") && sObject.getTreeAge2().equals("G") && sObject.getTreeHealth2().equals("G") && sObject.getDebilitatingDisease2().equals("G") && (sObject.getPruning2().equals("G") || sObject.getPruning2().equals("M")) && (sObject.getPestDiseaseSanitation2().equals("G") || sObject.getPestDiseaseSanitation2().equals("M")) && sObject.getWeeding2().equals("G") && sObject.getHarvesting2().equals("G") && sObject.getShadeManagement2().equals("G") && sObject.getSoilCondition2().equals("B") || sObject.getOrganicMatter2().equals("B") || sObject.getFertilizerFormulation2().equals("B") || sObject.getFartilizerApplication2().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 3
                if (sObject.getFarmCondition3().equals("B") || sObject.getTreeDensity3().equals("B") || sObject.getDebilitatingDisease3().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth3().equals("G")&&(sObject.getPlantingMaterial3().equals("M")||sObject.getPlantingMaterial3().equals("B"))&&(sObject.getTreeAge3().equals("G")||sObject.getTreeAge3().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial3().equals("G") || sObject.getPlantingMaterial3().equals("M")) && sObject.getFarmCondition3().equals("G") && sObject.getTreeDensity3().equals("G") && sObject.getTreeAge3().equals("G") && sObject.getTreeHealth3().equals("G") && sObject.getDebilitatingDisease3().equals("G") && (sObject.getPruning3().equals("G") || sObject.getPruning3().equals("M")) && (sObject.getPestDiseaseSanitation3().equals("G") || sObject.getPestDiseaseSanitation3().equals("M")) && sObject.getWeeding3().equals("G") && sObject.getHarvesting3().equals("G") && sObject.getShadeManagement3().equals("G") && sObject.getSoilCondition3().equals("B") || sObject.getOrganicMatter3().equals("B") || sObject.getFertilizerFormulation3().equals("B") || sObject.getFertilizerApplication3().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 4
                if (sObject.getFarmCondition4().equals("B") || sObject.getTreeDensity4().equals("B") || sObject.getDebilitatingDisease4().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth4().equals("G")&&(sObject.getPlantingMaterial4().equals("M")||sObject.getPlantingMaterial4().equals("B"))&&(sObject.getTreeAge4().equals("G")||sObject.getTreeAge4().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial4().equals("G") || sObject.getPlantingMaterial4().equals("M")) && sObject.getFarmCondition4().equals("G") && sObject.getTreeDensity4().equals("G") && sObject.getTreeAge4().equals("G") && sObject.getTreeHealth4().equals("G") && sObject.getDebilitatingDisease4().equals("G") && (sObject.getPruning4().equals("G") || sObject.getPruning4().equals("M")) && (sObject.getPestDiseaseSanitation4().equals("G") || sObject.getPestDiseaseSanitation4().equals("M")) && sObject.getWeeding4().equals("G") && sObject.getHarvesting4().equals("G") && sObject.getShadeManagement4().equals("G") && sObject.getSoilCondition4().equals("B") || sObject.getOrganicMatter4().equals("B") || sObject.getFertilizerFormulation4().equals("B") || sObject.getFertilizerApplication4().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 5
                if (sObject.getFarmCondition5().equals("B") || sObject.getTreeDensity5().equals("B") || sObject.getDebilitatingDisease5().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth5().equals("G")&&(sObject.getPlantingMaterial5().equals("M")||sObject.getPlantingMaterial5().equals("B"))&&(sObject.getTreeAge5().equals("G")||sObject.getTreeAge5().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial5().equals("G") || sObject.getPlantingMaterial5().equals("M")) && sObject.getFarmCondition5().equals("G") && sObject.getTreeDensity5().equals("G") && sObject.getTreeAge5().equals("G") && sObject.getTreeHealth5().equals("G") && sObject.getDebilitatingDisease5().equals("G") && (sObject.getPruning5().equals("G") || sObject.getPruning5().equals("M")) && (sObject.getPestDiseaseSanitation5().equals("G") || sObject.getPestDiseaseSanitation5().equals("M")) && sObject.getWeeding5().equals("G") && sObject.getHarvesting5().equals("G") && sObject.getShadeManagement5().equals("G") && sObject.getSoilCondition5().equals("B") || sObject.getOrganicMatter5().equals("B") || sObject.getFertilizerFormulation5().equals("B") || sObject.getFertilizerApplication5().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }
            }
            if (yearLaunch.equals("4")){
                setText((TextView) findViewById(R.id.yearDetail),"YEAR 4");
                //plot 1
                if (sObject.getFarmCondition1().equals("B") || sObject.getTreeDensity1().equals("B") || sObject.getDebilitatingDisease1().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth1().equals("G")&&(sObject.getPlantingMaterial1().equals("M")||sObject.getPlantingMaterial1().equals("B"))&&(sObject.getTreeAge1().equals("G")||sObject.getTreeAge1().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial1().equals("G") || sObject.getPlantingMaterial1().equals("M")) && sObject.getFarmCondition1().equals("G") && sObject.getTreeDensity1().equals("G") && sObject.getTreeAge1().equals("G") && sObject.getTreeHealth1().equals("G") && sObject.getDebilitatingDisease1().equals("G") && (sObject.getPruning1().equals("G") || sObject.getPruning1().equals("M")) && (sObject.getPestDiseaseSanitation1().equals("G") || sObject.getPestDiseaseSanitation1().equals("M")) && sObject.getWeeding1().equals("G") && sObject.getHarvesting1().equals("G") && sObject.getShadeManagement1().equals("G") && sObject.getSoilCondition1().equals("B") || sObject.getOrganicMatter1().equals("B") || sObject.getFertilizerFormulation1().equals("B") || sObject.getFertilizerApplication1().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 2
                if (sObject.getFarmCondition2().equals("B") || sObject.getTreeDensity2().equals("B") || sObject.getDebilitatingDisease2().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth2().equals("G")&&(sObject.getPlantingMaterial2().equals("M")||sObject.getPlantingMaterial2().equals("B"))&&(sObject.getTreeAge2().equals("G")||sObject.getTreeAge2().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial2().equals("G") || sObject.getPlantingMaterial2().equals("M")) && sObject.getFarmCondition2().equals("G") && sObject.getTreeDensity2().equals("G") && sObject.getTreeAge2().equals("G") && sObject.getTreeHealth2().equals("G") && sObject.getDebilitatingDisease2().equals("G") && (sObject.getPruning2().equals("G") || sObject.getPruning2().equals("M")) && (sObject.getPestDiseaseSanitation2().equals("G") || sObject.getPestDiseaseSanitation2().equals("M")) && sObject.getWeeding2().equals("G") && sObject.getHarvesting2().equals("G") && sObject.getShadeManagement2().equals("G") && sObject.getSoilCondition2().equals("B") || sObject.getOrganicMatter2().equals("B") || sObject.getFertilizerFormulation2().equals("B") || sObject.getFartilizerApplication2().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 3
                if (sObject.getFarmCondition3().equals("B") || sObject.getTreeDensity3().equals("B") || sObject.getDebilitatingDisease3().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth3().equals("G")&&(sObject.getPlantingMaterial3().equals("M")||sObject.getPlantingMaterial3().equals("B"))&&(sObject.getTreeAge3().equals("G")||sObject.getTreeAge3().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial3().equals("G") || sObject.getPlantingMaterial3().equals("M")) && sObject.getFarmCondition3().equals("G") && sObject.getTreeDensity3().equals("G") && sObject.getTreeAge3().equals("G") && sObject.getTreeHealth3().equals("G") && sObject.getDebilitatingDisease3().equals("G") && (sObject.getPruning3().equals("G") || sObject.getPruning3().equals("M")) && (sObject.getPestDiseaseSanitation3().equals("G") || sObject.getPestDiseaseSanitation3().equals("M")) && sObject.getWeeding3().equals("G") && sObject.getHarvesting3().equals("G") && sObject.getShadeManagement3().equals("G") && sObject.getSoilCondition3().equals("B") || sObject.getOrganicMatter3().equals("B") || sObject.getFertilizerFormulation3().equals("B") || sObject.getFertilizerApplication3().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 4
                if (sObject.getFarmCondition4().equals("B") || sObject.getTreeDensity4().equals("B") || sObject.getDebilitatingDisease4().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth4().equals("G")&&(sObject.getPlantingMaterial4().equals("M")||sObject.getPlantingMaterial4().equals("B"))&&(sObject.getTreeAge4().equals("G")||sObject.getTreeAge4().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial4().equals("G") || sObject.getPlantingMaterial4().equals("M")) && sObject.getFarmCondition4().equals("G") && sObject.getTreeDensity4().equals("G") && sObject.getTreeAge4().equals("G") && sObject.getTreeHealth4().equals("G") && sObject.getDebilitatingDisease4().equals("G") && (sObject.getPruning4().equals("G") || sObject.getPruning4().equals("M")) && (sObject.getPestDiseaseSanitation4().equals("G") || sObject.getPestDiseaseSanitation4().equals("M")) && sObject.getWeeding4().equals("G") && sObject.getHarvesting4().equals("G") && sObject.getShadeManagement4().equals("G") && sObject.getSoilCondition4().equals("B") || sObject.getOrganicMatter4().equals("B") || sObject.getFertilizerFormulation4().equals("B") || sObject.getFertilizerApplication4().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 5
                if (sObject.getFarmCondition5().equals("B") || sObject.getTreeDensity5().equals("B") || sObject.getDebilitatingDisease5().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth5().equals("G")&&(sObject.getPlantingMaterial5().equals("M")||sObject.getPlantingMaterial5().equals("B"))&&(sObject.getTreeAge5().equals("G")||sObject.getTreeAge5().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial5().equals("G") || sObject.getPlantingMaterial5().equals("M")) && sObject.getFarmCondition5().equals("G") && sObject.getTreeDensity5().equals("G") && sObject.getTreeAge5().equals("G") && sObject.getTreeHealth5().equals("G") && sObject.getDebilitatingDisease5().equals("G") && (sObject.getPruning5().equals("G") || sObject.getPruning5().equals("M")) && (sObject.getPestDiseaseSanitation5().equals("G") || sObject.getPestDiseaseSanitation5().equals("M")) && sObject.getWeeding5().equals("G") && sObject.getHarvesting5().equals("G") && sObject.getShadeManagement5().equals("G") && sObject.getSoilCondition5().equals("B") || sObject.getOrganicMatter5().equals("B") || sObject.getFertilizerFormulation5().equals("B") || sObject.getFertilizerApplication5().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }
            }
            if (yearLaunch.equals("5")){
                setText((TextView) findViewById(R.id.yearDetail),"YEAR 5");
                //plot 1
                if (sObject.getFarmCondition1().equals("B") || sObject.getTreeDensity1().equals("B") || sObject.getDebilitatingDisease1().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth1().equals("G")&&(sObject.getPlantingMaterial1().equals("M")||sObject.getPlantingMaterial1().equals("B"))&&(sObject.getTreeAge1().equals("G")||sObject.getTreeAge1().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial1().equals("G") || sObject.getPlantingMaterial1().equals("M")) && sObject.getFarmCondition1().equals("G") && sObject.getTreeDensity1().equals("G") && sObject.getTreeAge1().equals("G") && sObject.getTreeHealth1().equals("G") && sObject.getDebilitatingDisease1().equals("G") && (sObject.getPruning1().equals("G") || sObject.getPruning1().equals("M")) && (sObject.getPestDiseaseSanitation1().equals("G") || sObject.getPestDiseaseSanitation1().equals("M")) && sObject.getWeeding1().equals("G") && sObject.getHarvesting1().equals("G") && sObject.getShadeManagement1().equals("G") && sObject.getSoilCondition1().equals("B") || sObject.getOrganicMatter1().equals("B") || sObject.getFertilizerFormulation1().equals("B") || sObject.getFertilizerApplication1().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 2
                if (sObject.getFarmCondition2().equals("B") || sObject.getTreeDensity2().equals("B") || sObject.getDebilitatingDisease2().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth2().equals("G")&&(sObject.getPlantingMaterial2().equals("M")||sObject.getPlantingMaterial2().equals("B"))&&(sObject.getTreeAge2().equals("G")||sObject.getTreeAge2().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial2().equals("G") || sObject.getPlantingMaterial2().equals("M")) && sObject.getFarmCondition2().equals("G") && sObject.getTreeDensity2().equals("G") && sObject.getTreeAge2().equals("G") && sObject.getTreeHealth2().equals("G") && sObject.getDebilitatingDisease2().equals("G") && (sObject.getPruning2().equals("G") || sObject.getPruning2().equals("M")) && (sObject.getPestDiseaseSanitation2().equals("G") || sObject.getPestDiseaseSanitation2().equals("M")) && sObject.getWeeding2().equals("G") && sObject.getHarvesting2().equals("G") && sObject.getShadeManagement2().equals("G") && sObject.getSoilCondition2().equals("B") || sObject.getOrganicMatter2().equals("B") || sObject.getFertilizerFormulation2().equals("B") || sObject.getFartilizerApplication2().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 3
                if (sObject.getFarmCondition3().equals("B") || sObject.getTreeDensity3().equals("B") || sObject.getDebilitatingDisease3().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth3().equals("G")&&(sObject.getPlantingMaterial3().equals("M")||sObject.getPlantingMaterial3().equals("B"))&&(sObject.getTreeAge3().equals("G")||sObject.getTreeAge3().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial3().equals("G") || sObject.getPlantingMaterial3().equals("M")) && sObject.getFarmCondition3().equals("G") && sObject.getTreeDensity3().equals("G") && sObject.getTreeAge3().equals("G") && sObject.getTreeHealth3().equals("G") && sObject.getDebilitatingDisease3().equals("G") && (sObject.getPruning3().equals("G") || sObject.getPruning3().equals("M")) && (sObject.getPestDiseaseSanitation3().equals("G") || sObject.getPestDiseaseSanitation3().equals("M")) && sObject.getWeeding3().equals("G") && sObject.getHarvesting3().equals("G") && sObject.getShadeManagement3().equals("G") && sObject.getSoilCondition3().equals("B") || sObject.getOrganicMatter3().equals("B") || sObject.getFertilizerFormulation3().equals("B") || sObject.getFertilizerApplication3().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 4
                if (sObject.getFarmCondition4().equals("B") || sObject.getTreeDensity4().equals("B") || sObject.getDebilitatingDisease4().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth4().equals("G")&&(sObject.getPlantingMaterial4().equals("M")||sObject.getPlantingMaterial4().equals("B"))&&(sObject.getTreeAge4().equals("G")||sObject.getTreeAge4().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial4().equals("G") || sObject.getPlantingMaterial4().equals("M")) && sObject.getFarmCondition4().equals("G") && sObject.getTreeDensity4().equals("G") && sObject.getTreeAge4().equals("G") && sObject.getTreeHealth4().equals("G") && sObject.getDebilitatingDisease4().equals("G") && (sObject.getPruning4().equals("G") || sObject.getPruning4().equals("M")) && (sObject.getPestDiseaseSanitation4().equals("G") || sObject.getPestDiseaseSanitation4().equals("M")) && sObject.getWeeding4().equals("G") && sObject.getHarvesting4().equals("G") && sObject.getShadeManagement4().equals("G") && sObject.getSoilCondition4().equals("B") || sObject.getOrganicMatter4().equals("B") || sObject.getFertilizerFormulation4().equals("B") || sObject.getFertilizerApplication4().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 5
                if (sObject.getFarmCondition5().equals("B") || sObject.getTreeDensity5().equals("B") || sObject.getDebilitatingDisease5().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth5().equals("G")&&(sObject.getPlantingMaterial5().equals("M")||sObject.getPlantingMaterial5().equals("B"))&&(sObject.getTreeAge5().equals("G")||sObject.getTreeAge5().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial5().equals("G") || sObject.getPlantingMaterial5().equals("M")) && sObject.getFarmCondition5().equals("G") && sObject.getTreeDensity5().equals("G") && sObject.getTreeAge5().equals("G") && sObject.getTreeHealth5().equals("G") && sObject.getDebilitatingDisease5().equals("G") && (sObject.getPruning5().equals("G") || sObject.getPruning5().equals("M")) && (sObject.getPestDiseaseSanitation5().equals("G") || sObject.getPestDiseaseSanitation5().equals("M")) && sObject.getWeeding5().equals("G") && sObject.getHarvesting5().equals("G") && sObject.getShadeManagement5().equals("G") && sObject.getSoilCondition5().equals("B") || sObject.getOrganicMatter5().equals("B") || sObject.getFertilizerFormulation5().equals("B") || sObject.getFertilizerApplication5().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }
            }
            if (yearLaunch.equals("6")){
                setText((TextView) findViewById(R.id.yearDetail),"YEAR 6");
                //plot 1
                if (sObject.getFarmCondition1().equals("B") || sObject.getTreeDensity1().equals("B") || sObject.getDebilitatingDisease1().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth1().equals("G")&&(sObject.getPlantingMaterial1().equals("M")||sObject.getPlantingMaterial1().equals("B"))&&(sObject.getTreeAge1().equals("G")||sObject.getTreeAge1().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial1().equals("G") || sObject.getPlantingMaterial1().equals("M")) && sObject.getFarmCondition1().equals("G") && sObject.getTreeDensity1().equals("G") && sObject.getTreeAge1().equals("G") && sObject.getTreeHealth1().equals("G") && sObject.getDebilitatingDisease1().equals("G") && (sObject.getPruning1().equals("G") || sObject.getPruning1().equals("M")) && (sObject.getPestDiseaseSanitation1().equals("G") || sObject.getPestDiseaseSanitation1().equals("M")) && sObject.getWeeding1().equals("G") && sObject.getHarvesting1().equals("G") && sObject.getShadeManagement1().equals("G") && sObject.getSoilCondition1().equals("B") || sObject.getOrganicMatter1().equals("B") || sObject.getFertilizerFormulation1().equals("B") || sObject.getFertilizerApplication1().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 2
                if (sObject.getFarmCondition2().equals("B") || sObject.getTreeDensity2().equals("B") || sObject.getDebilitatingDisease2().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth2().equals("G")&&(sObject.getPlantingMaterial2().equals("M")||sObject.getPlantingMaterial2().equals("B"))&&(sObject.getTreeAge2().equals("G")||sObject.getTreeAge2().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial2().equals("G") || sObject.getPlantingMaterial2().equals("M")) && sObject.getFarmCondition2().equals("G") && sObject.getTreeDensity2().equals("G") && sObject.getTreeAge2().equals("G") && sObject.getTreeHealth2().equals("G") && sObject.getDebilitatingDisease2().equals("G") && (sObject.getPruning2().equals("G") || sObject.getPruning2().equals("M")) && (sObject.getPestDiseaseSanitation2().equals("G") || sObject.getPestDiseaseSanitation2().equals("M")) && sObject.getWeeding2().equals("G") && sObject.getHarvesting2().equals("G") && sObject.getShadeManagement2().equals("G") && sObject.getSoilCondition2().equals("B") || sObject.getOrganicMatter2().equals("B") || sObject.getFertilizerFormulation2().equals("B") || sObject.getFartilizerApplication2().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 3
                if (sObject.getFarmCondition3().equals("B") || sObject.getTreeDensity3().equals("B") || sObject.getDebilitatingDisease3().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth3().equals("G")&&(sObject.getPlantingMaterial3().equals("M")||sObject.getPlantingMaterial3().equals("B"))&&(sObject.getTreeAge3().equals("G")||sObject.getTreeAge3().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial3().equals("G") || sObject.getPlantingMaterial3().equals("M")) && sObject.getFarmCondition3().equals("G") && sObject.getTreeDensity3().equals("G") && sObject.getTreeAge3().equals("G") && sObject.getTreeHealth3().equals("G") && sObject.getDebilitatingDisease3().equals("G") && (sObject.getPruning3().equals("G") || sObject.getPruning3().equals("M")) && (sObject.getPestDiseaseSanitation3().equals("G") || sObject.getPestDiseaseSanitation3().equals("M")) && sObject.getWeeding3().equals("G") && sObject.getHarvesting3().equals("G") && sObject.getShadeManagement3().equals("G") && sObject.getSoilCondition3().equals("B") || sObject.getOrganicMatter3().equals("B") || sObject.getFertilizerFormulation3().equals("B") || sObject.getFertilizerApplication3().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 4
                if (sObject.getFarmCondition4().equals("B") || sObject.getTreeDensity4().equals("B") || sObject.getDebilitatingDisease4().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth4().equals("G")&&(sObject.getPlantingMaterial4().equals("M")||sObject.getPlantingMaterial4().equals("B"))&&(sObject.getTreeAge4().equals("G")||sObject.getTreeAge4().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial4().equals("G") || sObject.getPlantingMaterial4().equals("M")) && sObject.getFarmCondition4().equals("G") && sObject.getTreeDensity4().equals("G") && sObject.getTreeAge4().equals("G") && sObject.getTreeHealth4().equals("G") && sObject.getDebilitatingDisease4().equals("G") && (sObject.getPruning4().equals("G") || sObject.getPruning4().equals("M")) && (sObject.getPestDiseaseSanitation4().equals("G") || sObject.getPestDiseaseSanitation4().equals("M")) && sObject.getWeeding4().equals("G") && sObject.getHarvesting4().equals("G") && sObject.getShadeManagement4().equals("G") && sObject.getSoilCondition4().equals("B") || sObject.getOrganicMatter4().equals("B") || sObject.getFertilizerFormulation4().equals("B") || sObject.getFertilizerApplication4().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 5
                if (sObject.getFarmCondition5().equals("B") || sObject.getTreeDensity5().equals("B") || sObject.getDebilitatingDisease5().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth5().equals("G")&&(sObject.getPlantingMaterial5().equals("M")||sObject.getPlantingMaterial5().equals("B"))&&(sObject.getTreeAge5().equals("G")||sObject.getTreeAge5().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial5().equals("G") || sObject.getPlantingMaterial5().equals("M")) && sObject.getFarmCondition5().equals("G") && sObject.getTreeDensity5().equals("G") && sObject.getTreeAge5().equals("G") && sObject.getTreeHealth5().equals("G") && sObject.getDebilitatingDisease5().equals("G") && (sObject.getPruning5().equals("G") || sObject.getPruning5().equals("M")) && (sObject.getPestDiseaseSanitation5().equals("G") || sObject.getPestDiseaseSanitation5().equals("M")) && sObject.getWeeding5().equals("G") && sObject.getHarvesting5().equals("G") && sObject.getShadeManagement5().equals("G") && sObject.getSoilCondition5().equals("B") || sObject.getOrganicMatter5().equals("B") || sObject.getFertilizerFormulation5().equals("B") || sObject.getFertilizerApplication5().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }
            }
            if (yearLaunch.equals("7")){
                setText((TextView) findViewById(R.id.yearDetail),"YEAR 7");
                //plot 1
                if (sObject.getFarmCondition1().equals("B") || sObject.getTreeDensity1().equals("B") || sObject.getDebilitatingDisease1().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth1().equals("G")&&(sObject.getPlantingMaterial1().equals("M")||sObject.getPlantingMaterial1().equals("B"))&&(sObject.getTreeAge1().equals("G")||sObject.getTreeAge1().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial1().equals("G") || sObject.getPlantingMaterial1().equals("M")) && sObject.getFarmCondition1().equals("G") && sObject.getTreeDensity1().equals("G") && sObject.getTreeAge1().equals("G") && sObject.getTreeHealth1().equals("G") && sObject.getDebilitatingDisease1().equals("G") && (sObject.getPruning1().equals("G") || sObject.getPruning1().equals("M")) && (sObject.getPestDiseaseSanitation1().equals("G") || sObject.getPestDiseaseSanitation1().equals("M")) && sObject.getWeeding1().equals("G") && sObject.getHarvesting1().equals("G") && sObject.getShadeManagement1().equals("G") && sObject.getSoilCondition1().equals("B") || sObject.getOrganicMatter1().equals("B") || sObject.getFertilizerFormulation1().equals("B") || sObject.getFertilizerApplication1().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 2
                if (sObject.getFarmCondition2().equals("B") || sObject.getTreeDensity2().equals("B") || sObject.getDebilitatingDisease2().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth2().equals("G")&&(sObject.getPlantingMaterial2().equals("M")||sObject.getPlantingMaterial2().equals("B"))&&(sObject.getTreeAge2().equals("G")||sObject.getTreeAge2().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial2().equals("G") || sObject.getPlantingMaterial2().equals("M")) && sObject.getFarmCondition2().equals("G") && sObject.getTreeDensity2().equals("G") && sObject.getTreeAge2().equals("G") && sObject.getTreeHealth2().equals("G") && sObject.getDebilitatingDisease2().equals("G") && (sObject.getPruning2().equals("G") || sObject.getPruning2().equals("M")) && (sObject.getPestDiseaseSanitation2().equals("G") || sObject.getPestDiseaseSanitation2().equals("M")) && sObject.getWeeding2().equals("G") && sObject.getHarvesting2().equals("G") && sObject.getShadeManagement2().equals("G") && sObject.getSoilCondition2().equals("B") || sObject.getOrganicMatter2().equals("B") || sObject.getFertilizerFormulation2().equals("B") || sObject.getFartilizerApplication2().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 3
                if (sObject.getFarmCondition3().equals("B") || sObject.getTreeDensity3().equals("B") || sObject.getDebilitatingDisease3().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth3().equals("G")&&(sObject.getPlantingMaterial3().equals("M")||sObject.getPlantingMaterial3().equals("B"))&&(sObject.getTreeAge3().equals("G")||sObject.getTreeAge3().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial3().equals("G") || sObject.getPlantingMaterial3().equals("M")) && sObject.getFarmCondition3().equals("G") && sObject.getTreeDensity3().equals("G") && sObject.getTreeAge3().equals("G") && sObject.getTreeHealth3().equals("G") && sObject.getDebilitatingDisease3().equals("G") && (sObject.getPruning3().equals("G") || sObject.getPruning3().equals("M")) && (sObject.getPestDiseaseSanitation3().equals("G") || sObject.getPestDiseaseSanitation3().equals("M")) && sObject.getWeeding3().equals("G") && sObject.getHarvesting3().equals("G") && sObject.getShadeManagement3().equals("G") && sObject.getSoilCondition3().equals("B") || sObject.getOrganicMatter3().equals("B") || sObject.getFertilizerFormulation3().equals("B") || sObject.getFertilizerApplication3().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 4
                if (sObject.getFarmCondition4().equals("B") || sObject.getTreeDensity4().equals("B") || sObject.getDebilitatingDisease4().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth4().equals("G")&&(sObject.getPlantingMaterial4().equals("M")||sObject.getPlantingMaterial4().equals("B"))&&(sObject.getTreeAge4().equals("G")||sObject.getTreeAge4().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial4().equals("G") || sObject.getPlantingMaterial4().equals("M")) && sObject.getFarmCondition4().equals("G") && sObject.getTreeDensity4().equals("G") && sObject.getTreeAge4().equals("G") && sObject.getTreeHealth4().equals("G") && sObject.getDebilitatingDisease4().equals("G") && (sObject.getPruning4().equals("G") || sObject.getPruning4().equals("M")) && (sObject.getPestDiseaseSanitation4().equals("G") || sObject.getPestDiseaseSanitation4().equals("M")) && sObject.getWeeding4().equals("G") && sObject.getHarvesting4().equals("G") && sObject.getShadeManagement4().equals("G") && sObject.getSoilCondition4().equals("B") || sObject.getOrganicMatter4().equals("B") || sObject.getFertilizerFormulation4().equals("B") || sObject.getFertilizerApplication4().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }

                //plot 5
                if (sObject.getFarmCondition5().equals("B") || sObject.getTreeDensity5().equals("B") || sObject.getDebilitatingDisease5().equals("B")) {
                    //Replanting
                }else if (sObject.getTreeHealth5().equals("G")&&(sObject.getPlantingMaterial5().equals("M")||sObject.getPlantingMaterial5().equals("B"))&&(sObject.getTreeAge5().equals("G")||sObject.getTreeAge5().equals("B"))) {
                    //Grafting
                } else if ((sObject.getPlantingMaterial5().equals("G") || sObject.getPlantingMaterial5().equals("M")) && sObject.getFarmCondition5().equals("G") && sObject.getTreeDensity5().equals("G") && sObject.getTreeAge5().equals("G") && sObject.getTreeHealth5().equals("G") && sObject.getDebilitatingDisease5().equals("G") && (sObject.getPruning5().equals("G") || sObject.getPruning5().equals("M")) && (sObject.getPestDiseaseSanitation5().equals("G") || sObject.getPestDiseaseSanitation5().equals("M")) && sObject.getWeeding5().equals("G") && sObject.getHarvesting5().equals("G") && sObject.getShadeManagement5().equals("G") && sObject.getSoilCondition5().equals("B") || sObject.getOrganicMatter5().equals("B") || sObject.getFertilizerFormulation5().equals("B") || sObject.getFertilizerApplication5().equals("B")) {
                    //Extra Soil Management
                } else {
                    //GAPS
                }
            }
        }
    }

    private void setText(TextView textField, String text) {
        if (textField != null) {
            textField.setText(text);
        }
    }
}
