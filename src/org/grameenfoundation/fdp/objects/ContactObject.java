package org.grameenfoundation.fdp.objects;


import org.json.JSONObject;

import android.text.TextUtils;

import com.salesforce.androidsdk.smartsync.manager.SyncManager;
import com.salesforce.androidsdk.smartsync.model.SalesforceObject;
import com.salesforce.androidsdk.smartsync.util.Constants;

/**
 * A simple representation of a FDPSubmission object.
 *
 * @author bhariharan
 */
public class ContactObject extends SalesforceObject {

    public static final String FIRST_NAME = "fullName__c";
    public static final String LAST_NAME = "nationalID__c";
    public static final String TITLE = "farmerCode__c";
    public static final String BIRTHDAY = "birthday__c";
    public static final String GENDER = "gender__c";
    public static final String EDUCATIONALLEVEL = "educationalLevel__c";
    public static final String PHONE = "householdAddress__c";
    public static final String EMAIL = "village__c";
    public static final String DEPARTMENT = "gps__c";
    public static final String YEARSRELATIONSHIPWITHMARS = "yearsRelationshipWithMars__c";
    public static final String HOME_PHONE = "spouseName__c";
    public static final String SPOUSEBIRTHDAY = "spouseBirthday__c";
    public static final String SPOUSEEDUCATIONALLEVEL = "spouseEducationalLevel__c";
    public static final String UNDER17INSCHOOL = "under17InSchool__c";
    public static final String UNDER17 = "under17__c";
    public static final String FAMILYMEMBERS = "familyMembers__c";
    public static final String DEPENDECONOMICALLY = "dependEconomically__c";
    public static final String RECEIVESPAYMENTFARMLABOR = "receivesPaymentFarmLabor__c";
    public static final String SPOUSEHAVEPAIDWORK = "spouseHavePaidWork__c";
    public static final String FAMILYMEMBERSPAIDWORK = "familyMembersPaidWork__c";
    public static final String HAVEADITIONALCROPS = "haveAditionalCrops__c";
    public static final String HAVECREDIT = "haveCredit__c";
    public static final String GIVENSOMEONEALOAN = "givenSomeoneALoan__c";
    public static final String PRODUCTIONCOCOALY = "productionCocoaLY__c";
    public static final String AVERAGECOCOAPRICE = "averageCocoaPrice__c";
    public static final String EXPENSESCOCOALY = "expensesCocoaLY__c";
    public static final String INCOMEOTHERCROPS = "incomeOtherCrops__c";
    public static final String INCOMEFARMLABOR = "incomeFarmLabor__c";
    public static final String SPOUSEINCOME = "spouseIncome__c";
    public static final String FAMILYMEMBERSINCOME = "familyMembersIncome__c";
    public static final String AMOUNTOFLOAN = "amountOfLoan__c";
    public static final String LOANMONEYGETBACK = "loanMoneyGetBack__c";
    public static final String HOUSEHOLDSAVINGS = "householdSavings__c";
    public static final String ANNUALLIVINGEXPENSES = "annualLivingExpenses__c";
    public static final String ANNUALCOSTOFHOUSING = "annualCostOfHousing__c";
    public static final String ANNUALOTHEREXPENSES = "annualOtherExpenses__c";
    public static final String PLANNEDINVESTMENTS = "plannedInvestments__c";
    public static final String EXPECTEDEDUCATIONEXPENSES = "expectedEducationExpenses__c";
    public static final String HOWMUCHPAYFORCREDIT = "howMuchPayForCredit__c";
    public static final String ADITIONALCROPS = "aditionalCrops__c";
    public static final String AGREERECOMENDATIONS = "agreedRecommendations__c";
    public static final String DEBILITATINGDISEASE1 = "debilitatingDisease1__c";
    public static final String DEBILITATINGDISEASE10 = "debilitatingDisease10__c";
    public static final String DEBILITATINGDISEASE2 = "debilitatingDisease2__c";
    public static final String DEBILITATINGDISEASE3 = "debilitatingDisease3__c";
    public static final String DEBILITATINGDISEASE4 = "debilitatingDisease4__c";
    public static final String DEBILITATINGDISEASE5 = "debilitatingDisease5__c";
    public static final String DEBILITATINGDISEASE6 = "debilitatingDisease6__c";
    public static final String DEBILITATINGDISEASE7 = "debilitatingDisease7__c";
    public static final String DEBILITATINGDISEASE8 = "debilitatingDisease8__c";
    public static final String DEBILITATINGDISEASE9 = "debilitatingDisease9__c";
    public static final String DRAINAGENEED1 = "drainnageNeed1__c";
    public static final String DRAINAGENEED10 = "drainnageNeed10__c";
    public static final String DRAINAGENEED2 = "drainnageNeed2__c";
    public static final String DRAINAGENEED3 = "drainnageNeed3__c";
    public static final String DRAINAGENEED4 = "drainnageNeed4__c";
    public static final String DRAINAGENEED5 = "drainnageNeed5__c";
    public static final String DRAINAGENEED6 = "drainnageNeed6__c";
    public static final String DRAINAGENEED7 = "drainnageNeed7__c";
    public static final String DRAINAGENEED8 = "drainnageNeed8__c";
    public static final String DRAINAGENEED9 = "drainnageNeed9__c";
    public static final String FAMILYMEMBERSWORKONFARM = "familyMembersWorkOnFarm__c";
    public static final String FARMAGE = "farmAge__c";
    public static final String FARMCERTIFICATIONS = "farmCertifications__c";
    public static final String FARMCONDITION1 = "farmCondition1__c";
    public static final String FARMCONDITION10 = "farmCondition10__c";
    public static final String FARMCONDITION2 = "farmCondition2__c";
    public static final String FARMCONDITION3 = "farmCondition3__c";
    public static final String FARMCONDITION4 = "farmCondition4__c";
    public static final String FARMCONDITION5 = "farmCondition5__c";
    public static final String FARMCONDITION6 = "farmCondition6__c";
    public static final String FARMCONDITION7 = "farmCondition7__c";
    public static final String FARMCONDITION8 = "farmCondition8__c";
    public static final String FARMCONDITION9 = "farmCondition9__c";
    public static final String FARMERCOMMENTS = "farmerComments__c";
    public static final String FARMGPS = "farmGPS__c";
    public static final String FARMNAME = "farmName__c";
    public static final String FARMVILLAGE = "farmVillage__c";
    public static final String FERTILIZERAPPLICATION1 = "fertilizerApplication1__c";
    public static final String FERTILIZERAPPLICATION10 = "fertilizerApplication10__c";
    public static final String FERTILIZERAPPLICATION2 = "fertilizerApplication2__c";
    public static final String FERTILIZERAPPLICATION3 = "fertilizerApplication3__c";
    public static final String FERTILIZERAPPLICATION4 = "fertilizerApplication4__c";
    public static final String FERTILIZERAPPLICATION5 = "fertilizerApplication5__c";
    public static final String FERTILIZERAPPLICATION6 = "fertilizerApplication6__c";
    public static final String FERTILIZERAPPLICATION7 = "fertilizerApplication7__c";
    public static final String FERTILIZERAPPLICATION8 = "fertilizerApplication8__c";
    public static final String FERTILIZERAPPLICATION9 = "fertilizerApplication9__c";
    public static final String FERTILIZERFORMULATION1 = "fertilizerFormulation1__c";
    public static final String FERTILIZERFORMULATION10 = "fertilizerFormulation10__c";
    public static final String FERTILIZERFORMULATION2 = "fertilizerFormulation2__c";
    public static final String FERTILIZERFORMULATION3 = "fertilizerFormulation3__c";
    public static final String FERTILIZERFORMULATION4 = "fertilizerFormulation4__c";
    public static final String FERTILIZERFORMULATION5 = "fertilizerFormulation5__c";
    public static final String FERTILIZERFORMULATION6 = "fertilizerFormulation6__c";
    public static final String FERTILIZERFORMULATION7 = "fertilizerFormulation7__c";
    public static final String FERTILIZERFORMULATION8 = "fertilizerFormulation8__c";
    public static final String FERTILIZERFORMULATION9 = "fertilizerFormulation9__c";
    public static final String FILLINGOPTION1 = "fillingOption1__c";
    public static final String FILLINGOPTION10 = "fillingOption10__c";
    public static final String FILLINGOPTION2 = "fillingOption2__c";
    public static final String FILLINGOPTION3 = "fillingOption3__c";
    public static final String FILLINGOPTION4 = "fillingOption4__c";
    public static final String FILLINGOPTION5 = "fillingOption5__c";
    public static final String FILLINGOPTION6 = "fillingOption6__c";
    public static final String FILLINGOPTION7 = "fillingOption7__c";
    public static final String FILLINGOPTION8 = "fillingOption8__c";
    public static final String FILLINGOPTION9 = "fillingOption9__c";
    public static final String HARVESTING1 = "harvesting1__c";
    public static final String HARVESTING10 = "harvesting10__c";
    public static final String HARVESTING2 = "harvesting2__c";
    public static final String HARVESTING3 = "harvesting3__c";
    public static final String HARVESTING4 = "harvesting4__c";
    public static final String HARVESTING5 = "harvesting5__c";
    public static final String HARVESTING6 = "harvesting6__c";
    public static final String HARVESTING7 = "harvesting7__c";
    public static final String HARVESTING8 = "harvesting8__c";
    public static final String HARVESTING9 = "harvesting9__c";
    public static final String HIRELABOR = "hireLabor__c";
    public static final String HIRELABOR1 = "hireLabor1__c";
    public static final String HIRELABOR10 = "hireLabor10__c";
    public static final String HIRELABOR2 = "hireLabor2__c";
    public static final String HIRELABOR3 = "hireLabor3__c";
    public static final String HIRELABOR4 = "hireLabor4__c";
    public static final String HIRELABOR5 = "hireLabor5__c";
    public static final String HIRELABOR6 = "hireLabor6__c";
    public static final String HIRELABOR7 = "hireLabor7__c";
    public static final String HIRELABOR8 = "hireLabor8__c";
    public static final String HIRELABOR9 = "hireLabor9__c";
    public static final String HOWMANYLABORDAYSHIRE = "howManyLaborDaysHire__c";
    public static final String IMPLEMENTDRAINNAGE1 = "implementDrainnage1__c";
    public static final String IMPLEMENTDRAINNAGE10 = "implementDrainnage10__c";
    public static final String IMPLEMENTDRAINNAGE2 = "implementDrainnage2__c";
    public static final String IMPLEMENTDRAINNAGE3 = "implementDrainnage3__c";
    public static final String IMPLEMENTDRAINNAGE4 = "implementDrainnage4__c";
    public static final String IMPLEMENTDRAINNAGE5 = "implementDrainnage5__c";
    public static final String IMPLEMENTDRAINNAGE6 = "implementDrainnage6__c";
    public static final String IMPLEMENTDRAINNAGE7 = "implementDrainnage7__c";
    public static final String IMPLEMENTDRAINNAGE8 = "implementDrainnage8__c";
    public static final String IMPLEMENTDRAINNAGE9 = "implementDrainnage9__c";
    public static final String IMPLEMENTFILLING1 = "implementFilling1__c";
    public static final String IMPLEMENTFILLING10 = "implementFilling10__c";
    public static final String IMPLEMENTFILLING2 = "implementFilling2__c";
    public static final String IMPLEMENTFILLING3 = "implementFilling3__c";
    public static final String IMPLEMENTFILLING4 = "implementFilling4__c";
    public static final String IMPLEMENTFILLING5 = "implementFilling5__c";
    public static final String IMPLEMENTFILLING6 = "implementFilling6__c";
    public static final String IMPLEMENTFILLING7 = "implementFilling7__c";
    public static final String IMPLEMENTFILLING8 = "implementFilling8__c";
    public static final String IMPLEMENTFILLING9 = "implementFilling9__c";
    public static final String IMPLEMENTLIME1 = "implementLime1__c";
    public static final String IMPLEMENTLIME10 = "implementLime10__c";
    public static final String IMPLEMENTLIME2 = "implementLime2__c";
    public static final String IMPLEMENTLIME3 = "implementLime3__c";
    public static final String IMPLEMENTLIME4 = "implementLime4__c";
    public static final String IMPLEMENTLIME5 = "implementLime5__c";
    public static final String IMPLEMENTLIME6 = "implementLime6__c";
    public static final String IMPLEMENTLIME7 = "implementLime7__c";
    public static final String IMPLEMENTLIME8 = "implementLime8__c";
    public static final String IMPLEMENTLIME9 = "implementLime9__c";
    public static final String LIMENEED1 = "limeNeed1__c";
    public static final String LIMENEED10 = "limeNeed10__c";
    public static final String LIMENEED2 = "limeNeed2__c";
    public static final String LIMENEED3 = "limeNeed3__c";
    public static final String LIMENEED4 = "limeNeed4__c";
    public static final String LIMENEED5 = "limeNeed5__c";
    public static final String LIMENEED6 = "limeNeed6__c";
    public static final String LIMENEED7 = "limeNeed7__c";
    public static final String LIMENEED8 = "limeNeed8__c";
    public static final String LIMENEED9 = "limeNeed9__c";
    public static final String NUMBEROFPLOTS = "numberOfPlots__c";
    public static final String ORGANICMATTER1 = "organicMatter1__c";
    public static final String ORGANICMATTER10 = "organicMatter10__c";
    public static final String ORGANICMATTER2 = "organicMatter2__c";
    public static final String ORGANICMATTER3 = "organicMatter3__c";
    public static final String ORGANICMATTER4 = "organicMatter4__c";
    public static final String ORGANICMATTER5 = "organicMatter5__c";
    public static final String ORGANICMATTER6 = "organicMatter6__c";
    public static final String ORGANICMATTER7 = "organicMatter7__c";
    public static final String ORGANICMATTER8 = "organicMatter8__c";
    public static final String ORGANICMATTER9 = "organicMatter9__c";
    public static final String PESTDISEASESANITATION1 = "pestDiseaseSanitation1__c";
    public static final String PESTDISEASESANITATION10 = "pestDiseaseSanitation10__c";
    public static final String PESTDISEASESANITATION2 = "pestDiseaseSanitation2__c";
    public static final String PESTDISEASESANITATION3 = "pestDiseaseSanitation3__c";
    public static final String PESTDISEASESANITATION4 = "pestDiseaseSanitation4__c";
    public static final String PESTDISEASESANITATION5 = "pestDiseaseSanitation5__c";
    public static final String PESTDISEASESANITATION6 = "pestDiseaseSanitation6__c";
    public static final String PESTDISEASESANITATION7 = "pestDiseaseSanitation7__c";
    public static final String PESTDISEASESANITATION8 = "pestDiseaseSanitation8__c";
    public static final String PESTDISEASESANITATION9 = "pestDiseaseSanitation9__c";
    public static final String PLANTINGMATERIAL1 = "plantingMaterial1__c";
    public static final String PLANTINGMATERIAL10 = "plantingMaterial10__c";
    public static final String PLANTINGMATERIAL2 = "plantingMaterial2__c";
    public static final String PLANTINGMATERIAL3 = "plantingMaterial3__c";
    public static final String PLANTINGMATERIAL4 = "plantingMaterial4__c";
    public static final String PLANTINGMATERIAL5 = "plantingMaterial5__c";
    public static final String PLANTINGMATERIAL6 = "plantingMaterial6__c";
    public static final String PLANTINGMATERIAL7 = "plantingMaterial7__c";
    public static final String PLANTINGMATERIAL8 = "plantingMaterial8__c";
    public static final String PLANTINGMATERIAL9 = "plantingMaterial9__c";
    public static final String PLOT10AGE = "plot10Age__c";
    public static final String PLOT10AREA = "plot10Area__c";
    public static final String PLOT10COCOATREES = "plot10CocoaTrees__c";
    public static final String PLOT10GPS = "plot10GPS__c";
    public static final String PLOT10SHADETREES = "plot10ShadeTrees__c";
    public static final String PLOT10YIELD = "plot10Yield__c";
    public static final String PLOT1AGE = "plot1Age__c";
    public static final String PLOT1AREA = "plot1Area__c";
    public static final String PLOT1COCOATREES = "plot1CocoaTrees__c";
    public static final String PLOT1GPS = "plot1GPS__c";
    public static final String PLOT1SHADETREES = "plot1ShadeTrees__c";
    public static final String PLOT1YIELD = "plot1Yield__c";
    public static final String PLOT2AGE = "plot2Age__c";
    public static final String PLOT2AREA = "plot2Area__c";
    public static final String PLOT2COCOATREES = "plot2CocoaTrees__c";
    public static final String PLOT2GPS = "plot2GPS__c";
    public static final String PLOT2SHADETREES = "plot2ShadeTrees__c";
    public static final String PLOT2YIELD = "plot2Yield__c";
    public static final String PLOT3AGE = "plot3Age__c";
    public static final String PLOT3AREA = "plot3Area__c";
    public static final String PLOT3COCOATREES= "plot3_CocoaTrees__c";
    public static final String PLOT3GPS = "plot3GPS__c";
    public static final String PLOT3SHADETREES = "plot3ShadeTrees__c";
    public static final String PLOT3YIELD = "plot3Yield__c";
    public static final String PLOT4AGE = "plot4Age__c";
    public static final String PLOT4AREA = "plot4Area__c";
    public static final String PLOT4COCOATREES = "plot4CocoaTrees__c";
    public static final String PLOT4GPS = "plot4GPS__c";
    public static final String PLOT4SHADETREES = "plot4ShadeTrees__c";
    public static final String PLOT4YIELD = "plot4Yield__c";
    public static final String PLOT5AGE = "plot5Age__c";
    public static final String PLOT5AREA = "plot5Area__c";
    public static final String PLOT5COCOATREES = "plot5CocoaTrees__c";
    public static final String PLOT5GPS = "plot5GPS__c";
    public static final String PLOT5SHADETREES = "plot5ShadeTrees__c";
    public static final String PLOT5YIELD = "plot5Yield__c";
    public static final String PLOT6AGE = "plot6Age__c";
    public static final String PLOT6AREA = "plot6Area__c";
    public static final String PLOT6COCOATREES = "plot6CocoaTrees__c";
    public static final String PLOT6GPS = "plot6GPS__c";
    public static final String PLOT6SHADETREES = "plot6ShadeTrees__c";
    public static final String PLOT6YIELD = "plot6Yield__c";
    public static final String PLOT7AGE = "plot7Age__c";
    public static final String PLOT7AREA = "plot7Area__c";
    public static final String PLOT7COCOATREES = "plot7CocoaTrees__c";
    public static final String PLOT7GPS = "plot7GPS__c";
    public static final String PLOT7SHADETREES = "plot7ShadeTrees__c";
    public static final String PLOT7YIELD = "plot7Yield__c";
    public static final String PLOT8AGE = "plot8Age__c";
    public static final String PLOT8AREA = "plot8Area__c";
    public static final String PLOT8COCOATREES = "plot8CocoaTrees__c";
    public static final String PLOT8GPS = "plot8GPS__c";
    public static final String PLOT8SHADETREES = "plot8ShadeTrees__c";
    public static final String PLOT8YIELD = "plot8Yield__c";
    public static final String PLOT9AGE = "plot9Age__c";
    public static final String PLOT9AREA = "plot9Area__c";
    public static final String PLOT9COCOATREES = "plot9CocoaTrees__c";
    public static final String PLOT9GPS = "plot9GPS__c";
    public static final String PLOT9SHADETREES = "plot9ShadeTrees__c";
    public static final String PLOT9YIELD = "plot9Yield__c";
    public static final String PRUNING1 = "pruning1__c";
    public static final String PRUNING10 = "pruning10__c";
    public static final String PRUNING2 = "pruning2__c";
    public static final String PRUNING3 = "pruning3__c";
    public static final String PRUNING4 = "pruning4__c";
    public static final String PRUNING5 = "pruning5__c";
    public static final String PRUNING6 = "pruning6__c";
    public static final String PRUNING7 = "pruning7__c";
    public static final String PRUNING8 = "pruning8__c";
    public static final String PRUNING9 = "pruning9__c";
    public static final String REASONSNOTAGREED = "reasonsNotAgreed__c";
    public static final String SHADEMANAGEMENT1 = "shadeManagement1__c";
    public static final String SHADEMANAGEMENT10 = "shadeManagement10__c";
    public static final String SHADEMANAGEMENT2 = "shadeManagement2__c";
    public static final String SHADEMANAGEMENT3 = "shadeManagement3__c";
    public static final String SHADEMANAGEMENT4 = "shadeManagement4__c";
    public static final String SHADEMANAGEMENT5 = "shadeManagement5__c";
    public static final String SHADEMANAGEMENT6 = "shadeManagement6__c";
    public static final String SHADEMANAGEMENT7 = "shadeManagement7__c";
    public static final String SHADEMANAGEMENT8 = "shadeManagement8__c";
    public static final String SHADEMANAGEMENT9 = "shadeManagement9__c";
    public static final String SOILCONDITION1 = "soilCondition1__c";
    public static final String SOILCONDITION10 = "soilCondition10__c";
    public static final String SOILCONDITION2 = "soilCondition2__c";
    public static final String SOILCONDITION3 = "soilCondition3__c";
    public static final String SOILCONDITION4 = "soilCondition4__c";
    public static final String SOILCONDITION5 = "soilCondition5__c";
    public static final String SOILCONDITION6 = "soilCondition6__c";
    public static final String SOILCONDITION7 = "soilCondition7__c";
    public static final String SOILCONDITION8 = "soilCondition8__c";
    public static final String SOILCONDITION9 = "soilCondition9__c";
    public static final String STARTYEARP1 = "startYearP1__c";
    public static final String STARTYEARP10 = "startYearP10__c";
    public static final String STARTYEARP2 = "startYearP2__c";
    public static final String STARTYEARP3 = "startYearP3__c";
    public static final String STARTYEARP4 = "startYearP4__c";
    public static final String STARTYEARP5 = "startYearP5__c";
    public static final String STARTYEARP6 = "startYearP6__c";
    public static final String STARTYEARP7 = "startYearP7__c";
    public static final String STARTYEARP8 = "startYearP8__c";
    public static final String STARTYEARP9 = "startYearP9__c";
    public static final String TOTALAREAOTHERCROPS = "totalAreaOtherCrops__c";
    public static final String TOTALCOCOAAREA = "totalCocoaArea__c";
    public static final String TOTALFARMAREA = "totalFarmArea__c";
    public static final String TOTALRENOVATIONAREA = "totalRenovationArea__c";
    public static final String TREEAGE1 = "treeAge1__c";
    public static final String TREEAGE10 = "treeAge10__c";
    public static final String TREEAGE2 = "treeAge2__c";
    public static final String TREEAGE3 = "treeAge3__c";
    public static final String TREEAGE4 = "treeAge4__c";
    public static final String TREEAGE5 = "treeAge5__c";
    public static final String TREEAGE6 = "treeAge6__c";
    public static final String TREEAGE7 = "treeAge7__c";
    public static final String TREEAGE8 = "treeAge8__c";
    public static final String TREEAGE9 = "treeAge9__c";
    public static final String TREEDENSITY1 = "treeDensity1__c";
    public static final String TREEDENSITY10 = "treeDensity10__c";
    public static final String TREEDENSITY2 = "treeDensity2__c";
    public static final String TREEDENSITY3 = "treeDensity3__c";
    public static final String TREEDENSITY4 = "treeDensity4__c";
    public static final String TREEDENSITY5 = "treeDensity5__c";
    public static final String TREEDENSITY6 = "treeDensity6__c";
    public static final String TREEDENSITY7 = "treeDensity7__c";
    public static final String TREEDENSITY8 = "treeDensity8__c";
    public static final String TREEDENSITY9 = "treeDensity9__c";
    public static final String TREEHEALTH1 = "treeHealth1__c";
    public static final String TREEHEALTH10 = "treeHealth10__c";
    public static final String TREEHEALTH2 = "treeHealth2__c";
    public static final String TREEHEALTH3 = "treeHealth3__c";
    public static final String TREEHEALTH4 = "treeHealth4__c";
    public static final String TREEHEALTH5 = "treeHealth5__c";
    public static final String TREEHEALTH6 = "treeHealth6__c";
    public static final String TREEHEALTH7 = "treeHealth7__c";
    public static final String TREEHEALTH8 = "treeHealth8__c";
    public static final String TREEHEALTH9 = "treeHealth9__c";
    public static final String WEEDING1 = "weeding1__c";
    public static final String WEEDING10 = "weeding10__c";
    public static final String WEEDING2 = "weeding2__c";
    public static final String WEEDING3 = "weeding3__c";
    public static final String WEEDING4 = "weeding4__c";
    public static final String WEEDING5 = "weeding5__c";
    public static final String WEEDING6 = "weeding6__c";
    public static final String WEEDING7 = "weeding7__c";
    public static final String WEEDING8 = "weeding8__c";
    public static final String WEEDING9 = "weeding9__c";
    public static final String GA15 = "ga15__c";
    public static final String GB48 = "gb48__c";
    public static final String GB49 = "gb49__c";
    public static final String GB51 = "gb51__c";
    public static final String GB52 = "gb52__c";
    public static final String GB54 = "gb54__c";
    public static final String GB55 = "gb55__c";
    public static final String GB56 = "gb56__c";
    public static final String GB58 = "gb58__c";
    public static final String GB59 = "gb59__c";
    public static final String GB60 = "gb60__c";
    public static final String GB61 = "gb61__c";
    public static final String GB64 = "gb64__c";
    public static final String GB65 = "gb65__c";
    public static final String GB66 = "gb66__c";
    public static final String GB68 = "gb68__c";
    public static final String GB72 = "gb72__c";
    public static final String GC95 = "gc95__c";
    public static final String COB3 = "cob3__c";
    public static final String COB4 = "cob4__c";
    public static final String COB5 = "cob5__c";
    public static final String RA1 = "ra1__c";
    public static final String RA2 = "ra2__c";
    public static final String RA3 = "ra3__c";
    public static final String RA4 = "ra4__c";
    public static final String RA5 = "ra5__c";
    public static final String RA6 = "ra6__c";
    public static final String RA7 = "ra7__c";
    public static final String RA8 = "ra8__c";
    public static final String RA9 = "ra9__c";
    public static final String RA10 = "ra10__c";
    public static final String RA11 = "ra11__c";
    public static final String RA12 = "ra12__c";
    public static final String[] CONTACT_FIELDS_SYNC_DOWN = {
            FIRST_NAME,
            LAST_NAME,
            TITLE,
            BIRTHDAY,
            GENDER,
            EDUCATIONALLEVEL,
            PHONE,
            EMAIL,
            DEPARTMENT,
            YEARSRELATIONSHIPWITHMARS,
            HOME_PHONE,
            SPOUSEBIRTHDAY,
            SPOUSEEDUCATIONALLEVEL,
            UNDER17INSCHOOL,
            UNDER17,
            FAMILYMEMBERS,
            DEPENDECONOMICALLY,
            RECEIVESPAYMENTFARMLABOR,
            SPOUSEHAVEPAIDWORK,
            FAMILYMEMBERSPAIDWORK,
            HAVEADITIONALCROPS,
            HAVECREDIT,
            GIVENSOMEONEALOAN,
            PRODUCTIONCOCOALY,
            AVERAGECOCOAPRICE,
            EXPENSESCOCOALY,
            INCOMEOTHERCROPS,
            INCOMEFARMLABOR,
            SPOUSEINCOME,
            FAMILYMEMBERSINCOME,
            AMOUNTOFLOAN,
            LOANMONEYGETBACK,
            HOUSEHOLDSAVINGS,
            ANNUALLIVINGEXPENSES,
            ANNUALCOSTOFHOUSING,
            ANNUALOTHEREXPENSES,
            PLANNEDINVESTMENTS,
            EXPECTEDEDUCATIONEXPENSES,
            HOWMUCHPAYFORCREDIT,
            ADITIONALCROPS,
            AGREERECOMENDATIONS,
            DEBILITATINGDISEASE1,
            DEBILITATINGDISEASE10,
            DEBILITATINGDISEASE2,
            DEBILITATINGDISEASE3,
            DEBILITATINGDISEASE4,
            DEBILITATINGDISEASE5,
            DEBILITATINGDISEASE6,
            DEBILITATINGDISEASE7,
            DEBILITATINGDISEASE8,
            DEBILITATINGDISEASE9,
            DRAINAGENEED1,
            DRAINAGENEED10,
            DRAINAGENEED2,
            DRAINAGENEED3,
            DRAINAGENEED4,
            DRAINAGENEED5,
            DRAINAGENEED6,
            DRAINAGENEED7,
            DRAINAGENEED8,
            DRAINAGENEED9,
            FAMILYMEMBERSWORKONFARM,
            FARMAGE,
            FARMCERTIFICATIONS,
            FARMCONDITION1,
            FARMCONDITION10,
            FARMCONDITION2,
            FARMCONDITION3,
            FARMCONDITION4,
            FARMCONDITION5,
            FARMCONDITION6,
            FARMCONDITION7,
            FARMCONDITION8,
            FARMCONDITION9,
            FARMERCOMMENTS,
            FARMGPS,
            FARMNAME,
            FARMVILLAGE,
            FERTILIZERAPPLICATION1,
            FERTILIZERAPPLICATION10,
            FERTILIZERAPPLICATION2,
            FERTILIZERAPPLICATION3,
            FERTILIZERAPPLICATION4,
            FERTILIZERAPPLICATION5,
            FERTILIZERAPPLICATION6,
            FERTILIZERAPPLICATION7,
            FERTILIZERAPPLICATION8,
            FERTILIZERAPPLICATION9,
            FERTILIZERFORMULATION1,
            FERTILIZERFORMULATION10,
            FERTILIZERFORMULATION2,
            FERTILIZERFORMULATION3,
            FERTILIZERFORMULATION4,
            FERTILIZERFORMULATION5,
            FERTILIZERFORMULATION6,
            FERTILIZERFORMULATION7,
            FERTILIZERFORMULATION8,
            FERTILIZERFORMULATION9,
            FILLINGOPTION1,
            FILLINGOPTION10,
            FILLINGOPTION2,
            FILLINGOPTION3,
            FILLINGOPTION4,
            FILLINGOPTION5,
            FILLINGOPTION6,
            FILLINGOPTION7,
            FILLINGOPTION8,
            FILLINGOPTION9,
            HARVESTING1,
            HARVESTING10,
            HARVESTING2,
            HARVESTING3,
            HARVESTING4,
            HARVESTING5,
            HARVESTING6,
            HARVESTING7,
            HARVESTING8,
            HARVESTING9,
            HIRELABOR,
            HIRELABOR1,
            HIRELABOR10,
            HIRELABOR2,
            HIRELABOR3,
            HIRELABOR4,
            HIRELABOR5,
            HIRELABOR6,
            HIRELABOR7,
            HIRELABOR8,
            HIRELABOR9,
            HOWMANYLABORDAYSHIRE,
            IMPLEMENTDRAINNAGE1,
            IMPLEMENTDRAINNAGE10,
            IMPLEMENTDRAINNAGE2,
            IMPLEMENTDRAINNAGE3,
            IMPLEMENTDRAINNAGE4,
            IMPLEMENTDRAINNAGE5,
            IMPLEMENTDRAINNAGE6,
            IMPLEMENTDRAINNAGE7,
            IMPLEMENTDRAINNAGE8,
            IMPLEMENTDRAINNAGE9,
            IMPLEMENTFILLING1,
            IMPLEMENTFILLING10,
            IMPLEMENTFILLING2,
            IMPLEMENTFILLING3,
            IMPLEMENTFILLING4,
            IMPLEMENTFILLING5,
            IMPLEMENTFILLING6,
            IMPLEMENTFILLING7,
            IMPLEMENTFILLING8,
            IMPLEMENTFILLING9,
            IMPLEMENTLIME1,
            IMPLEMENTLIME10,
            IMPLEMENTLIME2,
            IMPLEMENTLIME3,
            IMPLEMENTLIME4,
            IMPLEMENTLIME5,
            IMPLEMENTLIME6,
            IMPLEMENTLIME7,
            IMPLEMENTLIME8,
            IMPLEMENTLIME9,
            LIMENEED1,
            LIMENEED10,
            LIMENEED2,
            LIMENEED3,
            LIMENEED4,
            LIMENEED5,
            LIMENEED6,
            LIMENEED7,
            LIMENEED8,
            LIMENEED9,
            NUMBEROFPLOTS,
            ORGANICMATTER1,
            ORGANICMATTER10,
            ORGANICMATTER2,
            ORGANICMATTER3,
            ORGANICMATTER4,
            ORGANICMATTER5,
            ORGANICMATTER6,
            ORGANICMATTER7,
            ORGANICMATTER8,
            ORGANICMATTER9,
            PESTDISEASESANITATION1,
            PESTDISEASESANITATION10,
            PESTDISEASESANITATION2,
            PESTDISEASESANITATION3,
            PESTDISEASESANITATION4,
            PESTDISEASESANITATION5,
            PESTDISEASESANITATION6,
            PESTDISEASESANITATION7,
            PESTDISEASESANITATION8,
            PESTDISEASESANITATION9,
            PLANTINGMATERIAL1,
            PLANTINGMATERIAL10,
            PLANTINGMATERIAL2,
            PLANTINGMATERIAL3,
            PLANTINGMATERIAL4,
            PLANTINGMATERIAL5,
            PLANTINGMATERIAL6,
            PLANTINGMATERIAL7,
            PLANTINGMATERIAL8,
            PLANTINGMATERIAL9,
            PLOT10AGE,
            PLOT10AREA,
            PLOT10COCOATREES,
            PLOT10GPS,
            PLOT10SHADETREES,
            PLOT10YIELD,
            PLOT1AGE,
            PLOT1AREA,
            PLOT1COCOATREES,
            PLOT1GPS,
            PLOT1SHADETREES,
            PLOT1YIELD,
            PLOT2AGE,
            PLOT2AREA,
            PLOT2COCOATREES,
            PLOT2GPS,
            PLOT2SHADETREES,
            PLOT2YIELD,
            PLOT3AGE,
            PLOT3AREA,
            PLOT3COCOATREES,
            PLOT3GPS,
            PLOT3SHADETREES,
            PLOT3YIELD,
            PLOT4AGE,
            PLOT4AREA,
            PLOT4COCOATREES,
            PLOT4GPS,
            PLOT4SHADETREES,
            PLOT4YIELD,
            PLOT5AGE,
            PLOT5AREA,
            PLOT5COCOATREES,
            PLOT5GPS,
            PLOT5SHADETREES,
            PLOT5YIELD,
            PLOT6AGE,
            PLOT6AREA,
            PLOT6COCOATREES,
            PLOT6GPS,
            PLOT6SHADETREES,
            PLOT6YIELD,
            PLOT7AGE,
            PLOT7AREA,
            PLOT7COCOATREES,
            PLOT7GPS,
            PLOT7SHADETREES,
            PLOT7YIELD,
            PLOT8AGE,
            PLOT8AREA,
            PLOT8COCOATREES,
            PLOT8GPS,
            PLOT8SHADETREES,
            PLOT8YIELD,
            PLOT9AGE,
            PLOT9AREA,
            PLOT9COCOATREES,
            PLOT9GPS,
            PLOT9SHADETREES,
            PLOT9YIELD,
            PRUNING1,
            PRUNING10,
            PRUNING2,
            PRUNING3,
            PRUNING4,
            PRUNING5,
            PRUNING6,
            PRUNING7,
            PRUNING8,
            PRUNING9,
            REASONSNOTAGREED,
            SHADEMANAGEMENT1,
            SHADEMANAGEMENT10,
            SHADEMANAGEMENT2,
            SHADEMANAGEMENT3,
            SHADEMANAGEMENT4,
            SHADEMANAGEMENT5,
            SHADEMANAGEMENT6,
            SHADEMANAGEMENT7,
            SHADEMANAGEMENT8,
            SHADEMANAGEMENT9,
            SOILCONDITION1,
            SOILCONDITION10,
            SOILCONDITION2,
            SOILCONDITION3,
            SOILCONDITION4,
            SOILCONDITION5,
            SOILCONDITION6,
            SOILCONDITION7,
            SOILCONDITION8,
            SOILCONDITION9,
            STARTYEARP1,
            STARTYEARP10,
            STARTYEARP2,
            STARTYEARP3,
            STARTYEARP4,
            STARTYEARP5,
            STARTYEARP6,
            STARTYEARP7,
            STARTYEARP8,
            STARTYEARP9,
            TOTALAREAOTHERCROPS,
            TOTALCOCOAAREA,
            TOTALFARMAREA,
            TOTALRENOVATIONAREA,
            TREEAGE1,
            TREEAGE10,
            TREEAGE2,
            TREEAGE3,
            TREEAGE4,
            TREEAGE5,
            TREEAGE6,
            TREEAGE7,
            TREEAGE8,
            TREEAGE9,
            TREEDENSITY1,
            TREEDENSITY10,
            TREEDENSITY2,
            TREEDENSITY3,
            TREEDENSITY4,
            TREEDENSITY5,
            TREEDENSITY6,
            TREEDENSITY7,
            TREEDENSITY8,
            TREEDENSITY9,
            TREEHEALTH1,
            TREEHEALTH10,
            TREEHEALTH2,
            TREEHEALTH3,
            TREEHEALTH4,
            TREEHEALTH5,
            TREEHEALTH6,
            TREEHEALTH7,
            TREEHEALTH8,
            TREEHEALTH9,
            WEEDING1,
            WEEDING10,
            WEEDING2,
            WEEDING3,
            WEEDING4,
            WEEDING5,
            WEEDING6,
            WEEDING7,
            WEEDING8,
            WEEDING9,
            GA15,
            GB48,
            GB49,
            GB51,
            GB52,
            GB54,
            GB55,
            GB56,
            GB58,
            GB59,
            GB60,
            GB61,
            GB64,
            GB65,
            GB66,
            GB68,
            GB72,
            GC95,
            COB3,
            COB4,
            COB5,
            RA1,
            RA2,
            RA3,
            RA4,
            RA5,
            RA6,
            RA7,
            RA8,
            RA9,
            RA10,
            RA11,
            RA12
    };
    public static final String[] CONTACT_FIELDS_SYNC_UP = {
            Constants.ID,
            FIRST_NAME,
            LAST_NAME,
            TITLE,
            BIRTHDAY,
            GENDER,
            EDUCATIONALLEVEL,
            PHONE,
            EMAIL,
            DEPARTMENT,
            YEARSRELATIONSHIPWITHMARS,
            HOME_PHONE,
            SPOUSEBIRTHDAY,
            SPOUSEEDUCATIONALLEVEL,
            UNDER17INSCHOOL,
            UNDER17,
            FAMILYMEMBERS,
            DEPENDECONOMICALLY,
            RECEIVESPAYMENTFARMLABOR,
            SPOUSEHAVEPAIDWORK,
            FAMILYMEMBERSPAIDWORK,
            HAVEADITIONALCROPS,
            HAVECREDIT,
            GIVENSOMEONEALOAN,
            PRODUCTIONCOCOALY,
            AVERAGECOCOAPRICE,
            EXPENSESCOCOALY,
            INCOMEOTHERCROPS,
            INCOMEFARMLABOR,
            SPOUSEINCOME,
            FAMILYMEMBERSINCOME,
            AMOUNTOFLOAN,
            LOANMONEYGETBACK,
            HOUSEHOLDSAVINGS,
            ANNUALLIVINGEXPENSES,
            ANNUALCOSTOFHOUSING,
            ANNUALOTHEREXPENSES,
            PLANNEDINVESTMENTS,
            EXPECTEDEDUCATIONEXPENSES,
            HOWMUCHPAYFORCREDIT,
            ADITIONALCROPS,
            AGREERECOMENDATIONS,
            DEBILITATINGDISEASE1,
            DEBILITATINGDISEASE10,
            DEBILITATINGDISEASE2,
            DEBILITATINGDISEASE3,
            DEBILITATINGDISEASE4,
            DEBILITATINGDISEASE5,
            DEBILITATINGDISEASE6,
            DEBILITATINGDISEASE7,
            DEBILITATINGDISEASE8,
            DEBILITATINGDISEASE9,
            DRAINAGENEED1,
            DRAINAGENEED10,
            DRAINAGENEED2,
            DRAINAGENEED3,
            DRAINAGENEED4,
            DRAINAGENEED5,
            DRAINAGENEED6,
            DRAINAGENEED7,
            DRAINAGENEED8,
            DRAINAGENEED9,
            FAMILYMEMBERSWORKONFARM,
            FARMAGE,
            FARMCERTIFICATIONS,
            FARMCONDITION1,
            FARMCONDITION10,
            FARMCONDITION2,
            FARMCONDITION3,
            FARMCONDITION4,
            FARMCONDITION5,
            FARMCONDITION6,
            FARMCONDITION7,
            FARMCONDITION8,
            FARMCONDITION9,
            FARMERCOMMENTS,
            FARMGPS,
            FARMNAME,
            FARMVILLAGE,
            FERTILIZERAPPLICATION1,
            FERTILIZERAPPLICATION10,
            FERTILIZERAPPLICATION2,
            FERTILIZERAPPLICATION3,
            FERTILIZERAPPLICATION4,
            FERTILIZERAPPLICATION5,
            FERTILIZERAPPLICATION6,
            FERTILIZERAPPLICATION7,
            FERTILIZERAPPLICATION8,
            FERTILIZERAPPLICATION9,
            FERTILIZERFORMULATION1,
            FERTILIZERFORMULATION10,
            FERTILIZERFORMULATION2,
            FERTILIZERFORMULATION3,
            FERTILIZERFORMULATION4,
            FERTILIZERFORMULATION5,
            FERTILIZERFORMULATION6,
            FERTILIZERFORMULATION7,
            FERTILIZERFORMULATION8,
            FERTILIZERFORMULATION9,
            FILLINGOPTION1,
            FILLINGOPTION10,
            FILLINGOPTION2,
            FILLINGOPTION3,
            FILLINGOPTION4,
            FILLINGOPTION5,
            FILLINGOPTION6,
            FILLINGOPTION7,
            FILLINGOPTION8,
            FILLINGOPTION9,
            HARVESTING1,
            HARVESTING10,
            HARVESTING2,
            HARVESTING3,
            HARVESTING4,
            HARVESTING5,
            HARVESTING6,
            HARVESTING7,
            HARVESTING8,
            HARVESTING9,
            HIRELABOR,
            HIRELABOR1,
            HIRELABOR10,
            HIRELABOR2,
            HIRELABOR3,
            HIRELABOR4,
            HIRELABOR5,
            HIRELABOR6,
            HIRELABOR7,
            HIRELABOR8,
            HIRELABOR9,
            HOWMANYLABORDAYSHIRE,
            IMPLEMENTDRAINNAGE1,
            IMPLEMENTDRAINNAGE10,
            IMPLEMENTDRAINNAGE2,
            IMPLEMENTDRAINNAGE3,
            IMPLEMENTDRAINNAGE4,
            IMPLEMENTDRAINNAGE5,
            IMPLEMENTDRAINNAGE6,
            IMPLEMENTDRAINNAGE7,
            IMPLEMENTDRAINNAGE8,
            IMPLEMENTDRAINNAGE9,
            IMPLEMENTFILLING1,
            IMPLEMENTFILLING10,
            IMPLEMENTFILLING2,
            IMPLEMENTFILLING3,
            IMPLEMENTFILLING4,
            IMPLEMENTFILLING5,
            IMPLEMENTFILLING6,
            IMPLEMENTFILLING7,
            IMPLEMENTFILLING8,
            IMPLEMENTFILLING9,
            IMPLEMENTLIME1,
            IMPLEMENTLIME10,
            IMPLEMENTLIME2,
            IMPLEMENTLIME3,
            IMPLEMENTLIME4,
            IMPLEMENTLIME5,
            IMPLEMENTLIME6,
            IMPLEMENTLIME7,
            IMPLEMENTLIME8,
            IMPLEMENTLIME9,
            LIMENEED1,
            LIMENEED10,
            LIMENEED2,
            LIMENEED3,
            LIMENEED4,
            LIMENEED5,
            LIMENEED6,
            LIMENEED7,
            LIMENEED8,
            LIMENEED9,
            NUMBEROFPLOTS,
            ORGANICMATTER1,
            ORGANICMATTER10,
            ORGANICMATTER2,
            ORGANICMATTER3,
            ORGANICMATTER4,
            ORGANICMATTER5,
            ORGANICMATTER6,
            ORGANICMATTER7,
            ORGANICMATTER8,
            ORGANICMATTER9,
            PESTDISEASESANITATION1,
            PESTDISEASESANITATION10,
            PESTDISEASESANITATION2,
            PESTDISEASESANITATION3,
            PESTDISEASESANITATION4,
            PESTDISEASESANITATION5,
            PESTDISEASESANITATION6,
            PESTDISEASESANITATION7,
            PESTDISEASESANITATION8,
            PESTDISEASESANITATION9,
            PLANTINGMATERIAL1,
            PLANTINGMATERIAL10,
            PLANTINGMATERIAL2,
            PLANTINGMATERIAL3,
            PLANTINGMATERIAL4,
            PLANTINGMATERIAL5,
            PLANTINGMATERIAL6,
            PLANTINGMATERIAL7,
            PLANTINGMATERIAL8,
            PLANTINGMATERIAL9,
            PLOT10AGE,
            PLOT10AREA,
            PLOT10COCOATREES,
            PLOT10GPS,
            PLOT10SHADETREES,
            PLOT10YIELD,
            PLOT1AGE,
            PLOT1AREA,
            PLOT1COCOATREES,
            PLOT1GPS,
            PLOT1SHADETREES,
            PLOT1YIELD,
            PLOT2AGE,
            PLOT2AREA,
            PLOT2COCOATREES,
            PLOT2GPS,
            PLOT2SHADETREES,
            PLOT2YIELD,
            PLOT3AGE,
            PLOT3AREA,
            PLOT3COCOATREES,
            PLOT3GPS,
            PLOT3SHADETREES,
            PLOT3YIELD,
            PLOT4AGE,
            PLOT4AREA,
            PLOT4COCOATREES,
            PLOT4GPS,
            PLOT4SHADETREES,
            PLOT4YIELD,
            PLOT5AGE,
            PLOT5AREA,
            PLOT5COCOATREES,
            PLOT5GPS,
            PLOT5SHADETREES,
            PLOT5YIELD,
            PLOT6AGE,
            PLOT6AREA,
            PLOT6COCOATREES,
            PLOT6GPS,
            PLOT6SHADETREES,
            PLOT6YIELD,
            PLOT7AGE,
            PLOT7AREA,
            PLOT7COCOATREES,
            PLOT7GPS,
            PLOT7SHADETREES,
            PLOT7YIELD,
            PLOT8AGE,
            PLOT8AREA,
            PLOT8COCOATREES,
            PLOT8GPS,
            PLOT8SHADETREES,
            PLOT8YIELD,
            PLOT9AGE,
            PLOT9AREA,
            PLOT9COCOATREES,
            PLOT9GPS,
            PLOT9SHADETREES,
            PLOT9YIELD,
            PRUNING1,
            PRUNING10,
            PRUNING2,
            PRUNING3,
            PRUNING4,
            PRUNING5,
            PRUNING6,
            PRUNING7,
            PRUNING8,
            PRUNING9,
            REASONSNOTAGREED,
            SHADEMANAGEMENT1,
            SHADEMANAGEMENT10,
            SHADEMANAGEMENT2,
            SHADEMANAGEMENT3,
            SHADEMANAGEMENT4,
            SHADEMANAGEMENT5,
            SHADEMANAGEMENT6,
            SHADEMANAGEMENT7,
            SHADEMANAGEMENT8,
            SHADEMANAGEMENT9,
            SOILCONDITION1,
            SOILCONDITION10,
            SOILCONDITION2,
            SOILCONDITION3,
            SOILCONDITION4,
            SOILCONDITION5,
            SOILCONDITION6,
            SOILCONDITION7,
            SOILCONDITION8,
            SOILCONDITION9,
            STARTYEARP1,
            STARTYEARP10,
            STARTYEARP2,
            STARTYEARP3,
            STARTYEARP4,
            STARTYEARP5,
            STARTYEARP6,
            STARTYEARP7,
            STARTYEARP8,
            STARTYEARP9,
            TOTALAREAOTHERCROPS,
            TOTALCOCOAAREA,
            TOTALFARMAREA,
            TOTALRENOVATIONAREA,
            TREEAGE1,
            TREEAGE10,
            TREEAGE2,
            TREEAGE3,
            TREEAGE4,
            TREEAGE5,
            TREEAGE6,
            TREEAGE7,
            TREEAGE8,
            TREEAGE9,
            TREEDENSITY1,
            TREEDENSITY10,
            TREEDENSITY2,
            TREEDENSITY3,
            TREEDENSITY4,
            TREEDENSITY5,
            TREEDENSITY6,
            TREEDENSITY7,
            TREEDENSITY8,
            TREEDENSITY9,
            TREEHEALTH1,
            TREEHEALTH10,
            TREEHEALTH2,
            TREEHEALTH3,
            TREEHEALTH4,
            TREEHEALTH5,
            TREEHEALTH6,
            TREEHEALTH7,
            TREEHEALTH8,
            TREEHEALTH9,
            WEEDING1,
            WEEDING10,
            WEEDING2,
            WEEDING3,
            WEEDING4,
            WEEDING5,
            WEEDING6,
            WEEDING7,
            WEEDING8,
            WEEDING9,
            GA15,
            GB48,
            GB49,
            GB51,
            GB52,
            GB54,
            GB55,
            GB56,
            GB58,
            GB59,
            GB60,
            GB61,
            GB64,
            GB65,
            GB66,
            GB68,
            GB72,
            GC95,
            COB3,
            COB4,
            COB5,
            RA1,
            RA2,
            RA3,
            RA4,
            RA5,
            RA6,
            RA7,
            RA8,
            RA9,
            RA10,
            RA11,
            RA12
    };

    private boolean isLocallyModified;

    /**
     * Parameterized constructor.
     *
     * @param data Raw data.
     */
    public ContactObject(JSONObject data) {
        super(data);
        objectType = Constants.SUBMISSION;
        objectId = data.optString(Constants.ID);
        name = data.optString(FIRST_NAME) + " " + data.optString(LAST_NAME);
        isLocallyModified = data.optBoolean(SyncManager.LOCALLY_UPDATED) ||
                data.optBoolean(SyncManager.LOCALLY_CREATED) ||
                data.optBoolean(SyncManager.LOCALLY_DELETED);
    }

    /**
     * Returns first name of the contact.
     *
     * @return First name of the contact.
     */
    public String getFirstName() {
        return sanitizeText(rawData.optString(FIRST_NAME));
    }

    /**
     * Returns last name of the contact.
     *
     * @return Last name of the contact.
     */
    public String getLastName() {
        return sanitizeText(rawData.optString(LAST_NAME));
    }

    /**
     * Returns title of the contact.
     *
     * @return Title of the contact.
     */
    public String getTitle() {
        return sanitizeText(rawData.optString(TITLE));
    }

    /**
     * Returns birthday of the contact.
     *
     * @return birthday of the contact.
     */
    public String getBirthday() {
        return sanitizeText(rawData.optString(BIRTHDAY));
    }

    /**
     * Returns Gender of the farmer.
     *
     * @return Gender of the farmer.
     */
    public String getGender() {
        return sanitizeText(rawData.optString(GENDER));
    }

    /**
     * Returns Educational Level of the farmer.
     *
     * @return Educational Level of the farmer.
     */
    public String getEducationallevel() {
        return sanitizeText(rawData.optString(EDUCATIONALLEVEL));
    }

    /**
     * Returns phone number of the contact.
     *
     * @return Phone number of the contact.
     */
    public String getPhone() {
        return sanitizeText(rawData.optString(PHONE));
    }

    /**
     * Returns e-mail address of the contact.
     *
     * @return E-mail address of the contact.
     */
    public String getEmail() {
        return sanitizeText(rawData.optString(EMAIL));
    }

    /**
     * Returns department of the contact.
     *
     * @return Department of the contact.
     */
    public String getDepartment() {
        return sanitizeText(rawData.optString(DEPARTMENT));
    }

    /**
     * Returns Years Relation with MARS of the farmer.
     *
     * @return Years Relation with MARS of the farmer.
     */
    public String getRelationWithMars() {
        return sanitizeText(rawData.optString(YEARSRELATIONSHIPWITHMARS));
    }

    /**
     * Returns home phone number of the contact.
     *
     * @return Home phone number of the contact.
     */
    public String getHomePhone() {
        return sanitizeText(rawData.optString(HOME_PHONE));
    }

    public String getSpousebirthday() {
        return sanitizeText(rawData.optString(SPOUSEBIRTHDAY));
    }

    public String getSpouseeducationallevel() {
        return sanitizeText(rawData.optString(SPOUSEEDUCATIONALLEVEL));
    }
    public String getUnder17inschool() {
        return sanitizeText(rawData.optString(UNDER17INSCHOOL));
    }
    public String getUnder17() {
        return sanitizeText(rawData.optString(UNDER17));
    }
    public String getFamilymembers() {
        return sanitizeText(rawData.optString(FAMILYMEMBERS));
    }
    public String getDependeconomically() {
        return sanitizeText(rawData.optString(DEPENDECONOMICALLY));
    }
    public String getReceivespaymentfarmlabor() {
        return sanitizeText(rawData.optString(RECEIVESPAYMENTFARMLABOR));
    }
    public String getSpousehavepaidwork() {
        return sanitizeText(rawData.optString(SPOUSEHAVEPAIDWORK));
    }
    public String getFamilymemberspaidwork() {
        return sanitizeText(rawData.optString(FAMILYMEMBERSPAIDWORK));
    }
    public String getHaveaditionalcrops() {
        return sanitizeText(rawData.optString(HAVEADITIONALCROPS));
    }
    public String getHavecredit() {
        return sanitizeText(rawData.optString(HAVECREDIT));
    }
    public String getGivensomeonealoan() {
        return sanitizeText(rawData.optString(GIVENSOMEONEALOAN));
    }
    public String getProductioncocoaly() {
        return sanitizeText(rawData.optString(PRODUCTIONCOCOALY));
    }
    public String getAveragecocoaprice() {
        return sanitizeText(rawData.optString(AVERAGECOCOAPRICE));
    }
    public String getExpensescocoaly() {
        return sanitizeText(rawData.optString(EXPENSESCOCOALY));
    }
    public String getIncomeothercrops() {
        return sanitizeText(rawData.optString(INCOMEOTHERCROPS));
    }
    public String getIncomefarmlabor() {
        return sanitizeText(rawData.optString(INCOMEFARMLABOR));
    }
    public String getSpouseincome() {
        return sanitizeText(rawData.optString(SPOUSEINCOME));
    }
    public String getFamilymembersincome() {
        return sanitizeText(rawData.optString(FAMILYMEMBERSINCOME));
    }
    public String getAmountofloan() {
        return sanitizeText(rawData.optString(AMOUNTOFLOAN));
    }
    public String getLoanmoneygetback() {
        return sanitizeText(rawData.optString(LOANMONEYGETBACK));
    }
    public String getHouseholdsavings() {
        return sanitizeText(rawData.optString(HOUSEHOLDSAVINGS));
    }
    public String getAnnuallivingexpenses() {
        return sanitizeText(rawData.optString(ANNUALLIVINGEXPENSES));
    }
    public String getAnnualcostofhousing() {
        return sanitizeText(rawData.optString(ANNUALCOSTOFHOUSING));
    }
    public String getAnnualotherexpenses() {
        return sanitizeText(rawData.optString(ANNUALOTHEREXPENSES));
    }
    public String getPlannedinvestments() {
        return sanitizeText(rawData.optString(PLANNEDINVESTMENTS));
    }
    public String getExpectededucationexpenses() {
        return sanitizeText(rawData.optString(EXPECTEDEDUCATIONEXPENSES));
    }
    public String getHowmuchpayforcredit() {
        return sanitizeText(rawData.optString(HOWMUCHPAYFORCREDIT));
    }
    public String getFarmName() {
        return sanitizeText(rawData.optString(FARMNAME));
    }
    public String getAditionalCrops() {
        return sanitizeText(rawData.optString(ADITIONALCROPS));
    }
    public String getAgreeRecomendations() {
        return sanitizeText(rawData.optString(AGREERECOMENDATIONS));
    }
    public String getDebilitatingDisease1() {
        return sanitizeText(rawData.optString(DEBILITATINGDISEASE1));
    }
    public String getDebilitatingDisease10() {
        return sanitizeText(rawData.optString(DEBILITATINGDISEASE10));
    }
    public String getDebilitatingDisease2() {
        return sanitizeText(rawData.optString(DEBILITATINGDISEASE2));
    }
    public String getDebilitatingDisease3() {
        return sanitizeText(rawData.optString(DEBILITATINGDISEASE3));
    }
    public String getDebilitatingDisease4() {
        return sanitizeText(rawData.optString(DEBILITATINGDISEASE4));
    }
    public String getDebilitatingDisease5() {
        return sanitizeText(rawData.optString(DEBILITATINGDISEASE5));
    }
    public String getDebilitatingDisease6() {
        return sanitizeText(rawData.optString(DEBILITATINGDISEASE6));
    }
    public String getDebilitatingDisease7() {
        return sanitizeText(rawData.optString(DEBILITATINGDISEASE7));
    }
    public String getDebilitatingDisease8() {
        return sanitizeText(rawData.optString(DEBILITATINGDISEASE8));
    }
    public String getDebilitatingDisease9() {
        return sanitizeText(rawData.optString(DEBILITATINGDISEASE9));
    }
    public String getDrainageNeed1() {
        return sanitizeText(rawData.optString(DRAINAGENEED1));
    }
    public String getDrainageNeed10() {
        return sanitizeText(rawData.optString(DRAINAGENEED10));
    }
    public String getDrainageNeed2() {
        return sanitizeText(rawData.optString(DRAINAGENEED2));
    }
    public String getDrainageNeed3() {
        return sanitizeText(rawData.optString(DRAINAGENEED3));
    }
    public String getDrainageNeed4() {
        return sanitizeText(rawData.optString(DRAINAGENEED4));
    }
    public String getDrainageNeed5() {
        return sanitizeText(rawData.optString(DRAINAGENEED5));
    }
    public String getDrainageNeed6() {
        return sanitizeText(rawData.optString(DRAINAGENEED6));
    }
    public String getDrainageNeed7() {
        return sanitizeText(rawData.optString(DRAINAGENEED7));
    }
    public String getDrainageNeed8() {
        return sanitizeText(rawData.optString(DRAINAGENEED8));
    }
    public String getDrainageNeed9() {
        return sanitizeText(rawData.optString(DRAINAGENEED9));
    }
    public String getFamilyMembersWorkFarm() {
        return sanitizeText(rawData.optString(FAMILYMEMBERSWORKONFARM));
    }
    public String getFarmAge() {
        return sanitizeText(rawData.optString(FARMAGE));
    }
    public String getFarmCertifications() {
        return sanitizeText(rawData.optString(FARMCERTIFICATIONS));
    }
    public String getFarmCondition1() {
        return sanitizeText(rawData.optString(FARMCONDITION1));
    }
    public String getFarmCondition10() {
        return sanitizeText(rawData.optString(FARMCONDITION10));
    }
    public String getFarmCondition2() {
        return sanitizeText(rawData.optString(FARMCONDITION2));
    }
    public String getFarmCondition3() {
        return sanitizeText(rawData.optString(FARMCONDITION3));
    }
    public String getFarmCondition4() {
        return sanitizeText(rawData.optString(FARMCONDITION4));
    }
    public String getFarmCondition5() {
        return sanitizeText(rawData.optString(FARMCONDITION5));
    }
    public String getFarmCondition6() {
        return sanitizeText(rawData.optString(FARMCONDITION6));
    }
    public String getFarmCondition7() {
        return sanitizeText(rawData.optString(FARMCONDITION7));
    }
    public String getFarmCondition8() {
        return sanitizeText(rawData.optString(FARMCONDITION8));
    }
    public String getFarmCondition9() {
        return sanitizeText(rawData.optString(FARMCONDITION9));
    }
    public String getFarmerComments() {
        return sanitizeText(rawData.optString(FARMERCOMMENTS));
    }
    public String getFarmGPS() {
        return sanitizeText(rawData.optString(FARMGPS));
    }
    public String getFarmVillage() {
        return sanitizeText(rawData.optString(FARMVILLAGE));
    }
    public String getFertilizerApplication1() {
        return sanitizeText(rawData.optString(FERTILIZERAPPLICATION1));
    }
    public String getFertilizerApplication10() {
        return sanitizeText(rawData.optString(FERTILIZERAPPLICATION10));
    }
    public String getFartilizerApplication2() {
        return sanitizeText(rawData.optString(FERTILIZERAPPLICATION2));
    }
    public String getFertilizerApplication3() {
        return sanitizeText(rawData.optString(FERTILIZERAPPLICATION3));
    }
    public String getFertilizerApplication4() {
        return sanitizeText(rawData.optString(FERTILIZERAPPLICATION4));
    }
    public String getFertilizerApplication5() {
        return sanitizeText(rawData.optString(FERTILIZERAPPLICATION5));
    }
    public String getFertilizerApplication6() {
        return sanitizeText(rawData.optString(FERTILIZERAPPLICATION6));
    }
    public String getFertilizerApplication7() {
        return sanitizeText(rawData.optString(FERTILIZERAPPLICATION7));
    }
    public String getFertilizerApplication8() {
        return sanitizeText(rawData.optString(FERTILIZERAPPLICATION8));
    }
    public String getFertilizerApplication9() {
        return sanitizeText(rawData.optString(FERTILIZERAPPLICATION9));
    }
    public String getFertilizerFormulation1() {
        return sanitizeText(rawData.optString(FERTILIZERFORMULATION1));
    }
    public String getFertilizerFormulation10() {
        return sanitizeText(rawData.optString(FERTILIZERFORMULATION10));
    }
    public String getFertilizerFormulation2() {
        return sanitizeText(rawData.optString(FERTILIZERFORMULATION2));
    }
    public String getFertilizerFormulation3() {
        return sanitizeText(rawData.optString(FERTILIZERFORMULATION3));
    }
    public String getFertilizerFormulation4() {
        return sanitizeText(rawData.optString(FERTILIZERFORMULATION4));
    }
    public String getFertilizerFormulation5() {
        return sanitizeText(rawData.optString(FERTILIZERFORMULATION5));
    }
    public String getFertilizerFormulation6() {
        return sanitizeText(rawData.optString(FERTILIZERFORMULATION6));
    }
    public String getFertilizerFormulation7() {
        return sanitizeText(rawData.optString(FERTILIZERFORMULATION7));
    }
    public String getFertilizerFormulation8() {
        return sanitizeText(rawData.optString(FERTILIZERFORMULATION8));
    }
    public String getFertilizerFormulation9() {
        return sanitizeText(rawData.optString(FERTILIZERFORMULATION9));
    }
    public String getFillingOption1() {
        return sanitizeText(rawData.optString(FILLINGOPTION1));
    }
    public String getFillingOption10() {
        return sanitizeText(rawData.optString(FILLINGOPTION10));
    }
    public String getFillingOption2() {
        return sanitizeText(rawData.optString(FILLINGOPTION2));
    }
    public String getFillingOption3() {
        return sanitizeText(rawData.optString(FILLINGOPTION3));
    }
    public String getFillingOption4() {
        return sanitizeText(rawData.optString(FILLINGOPTION4));
    }
    public String getFillingOption5() {
        return sanitizeText(rawData.optString(FILLINGOPTION5));
    }
    public String getFillingOption6() {
        return sanitizeText(rawData.optString(FILLINGOPTION6));
    }
    public String getFillingOption7() {
        return sanitizeText(rawData.optString(FILLINGOPTION7));
    }
    public String getFillingOption8() {
        return sanitizeText(rawData.optString(FILLINGOPTION8));
    }
    public String getFillingOption9() {
        return sanitizeText(rawData.optString(FILLINGOPTION9));
    }
    public String getHarvesting1() {
        return sanitizeText(rawData.optString(HARVESTING1));
    }
    public String getHarvesting10() {
        return sanitizeText(rawData.optString(HARVESTING10));
    }
    public String getHarvesting2() {
        return sanitizeText(rawData.optString(HARVESTING2));
    }
    public String getHarvesting3() {
        return sanitizeText(rawData.optString(HARVESTING3));
    }
    public String getHarvesting4() {
        return sanitizeText(rawData.optString(HARVESTING4));
    }
    public String getHarvesting5() {
        return sanitizeText(rawData.optString(HARVESTING5));
    }
    public String getHarvesting6() {
        return sanitizeText(rawData.optString(HARVESTING6));
    }
    public String getHarvesting7() {
        return sanitizeText(rawData.optString(HARVESTING7));
    }
    public String getHarvesting8() {
        return sanitizeText(rawData.optString(HARVESTING8));
    }
    public String getHarvesting9() {
        return sanitizeText(rawData.optString(HARVESTING9));
    }
    public String getHireLabor() {
        return sanitizeText(rawData.optString(HIRELABOR));
    }
    public String getHireLabor1() {
        return sanitizeText(rawData.optString(HIRELABOR1));
    }
    public String getHireLabor10() {
        return sanitizeText(rawData.optString(HIRELABOR10));
    }
    public String getHireLabor2() {
        return sanitizeText(rawData.optString(HIRELABOR2));
    }
    public String getHireLabor3() {
        return sanitizeText(rawData.optString(HIRELABOR3));
    }
    public String getHireLabor4() {
        return sanitizeText(rawData.optString(HIRELABOR4));
    }
    public String getHireLabor5() {
        return sanitizeText(rawData.optString(HIRELABOR5));
    }
    public String getHireLabor6() {
        return sanitizeText(rawData.optString(HIRELABOR6));
    }
    public String getHireLabor7() {
        return sanitizeText(rawData.optString(HIRELABOR7));
    }
    public String getHireLabor8() {
        return sanitizeText(rawData.optString(HIRELABOR8));
    }
    public String getHireLabor9() {
        return sanitizeText(rawData.optString(HIRELABOR9));
    }
    public String getHowManyLaborDaysHire() {
        return sanitizeText(rawData.optString(HOWMANYLABORDAYSHIRE));
    }
    public String getImplementDrainage1() {
        return sanitizeText(rawData.optString(IMPLEMENTDRAINNAGE1));
    }
    public String getImplementDrainage10() {
        return sanitizeText(rawData.optString(IMPLEMENTDRAINNAGE10));
    }
    public String getImplementDrainage2() {
        return sanitizeText(rawData.optString(IMPLEMENTDRAINNAGE2));
    }
    public String getImplementDrainage3() {
        return sanitizeText(rawData.optString(IMPLEMENTDRAINNAGE3));
    }
    public String getImplementDrainage4() {
        return sanitizeText(rawData.optString(IMPLEMENTDRAINNAGE4));
    }
    public String getImplementDrainage5() {
        return sanitizeText(rawData.optString(IMPLEMENTDRAINNAGE5));
    }
    public String getImplementDrainage6() {
        return sanitizeText(rawData.optString(IMPLEMENTDRAINNAGE6));
    }
    public String getImplementDrainage7() {
        return sanitizeText(rawData.optString(IMPLEMENTDRAINNAGE7));
    }
    public String getImplementDrainage8() {
        return sanitizeText(rawData.optString(IMPLEMENTDRAINNAGE8));
    }
    public String getImplementDranaige9() {
        return sanitizeText(rawData.optString(IMPLEMENTDRAINNAGE9));
    }
    public String getImplementFilling1() {
        return sanitizeText(rawData.optString(IMPLEMENTFILLING1));
    }
    public String getImplementFillin10() {
        return sanitizeText(rawData.optString(IMPLEMENTFILLING10));
    }
    public String getImplementFilling2() {
        return sanitizeText(rawData.optString(IMPLEMENTFILLING2));
    }
    public String getImplementFilling3() {
        return sanitizeText(rawData.optString(IMPLEMENTFILLING3));
    }
    public String getImplementFilling4() {
        return sanitizeText(rawData.optString(IMPLEMENTFILLING4));
    }
    public String getImplementFilling5() {
        return sanitizeText(rawData.optString(IMPLEMENTFILLING5));
    }
    public String getImplementFillin6() {
        return sanitizeText(rawData.optString(IMPLEMENTFILLING6));
    }
    public String getImplementFilling7() {
        return sanitizeText(rawData.optString(IMPLEMENTFILLING7));
    }
    public String getImplementFilling8() {
        return sanitizeText(rawData.optString(IMPLEMENTFILLING8));
    }
    public String getImplementFilling9() {
        return sanitizeText(rawData.optString(IMPLEMENTFILLING9));
    }
    public String getImplementLime1() {
        return sanitizeText(rawData.optString(IMPLEMENTLIME1));
    }
    public String getImplementLime10() {
        return sanitizeText(rawData.optString(IMPLEMENTLIME10));
    }
    public String getImplementLime2() {
        return sanitizeText(rawData.optString(IMPLEMENTLIME2));
    }
    public String getImplementLime3() {
        return sanitizeText(rawData.optString(IMPLEMENTLIME3));
    }
    public String getImplementLime4() {
        return sanitizeText(rawData.optString(IMPLEMENTLIME4));
    }
    public String getImplementLime5() {
        return sanitizeText(rawData.optString(IMPLEMENTLIME5));
    }
    public String getImplementLime6() {
        return sanitizeText(rawData.optString(IMPLEMENTLIME6));
    }
    public String getImplementLime7() {
        return sanitizeText(rawData.optString(IMPLEMENTLIME7));
    }
    public String getImplementLime8() {
        return sanitizeText(rawData.optString(IMPLEMENTLIME8));
    }
    public String getImplementLime9() {
        return sanitizeText(rawData.optString(IMPLEMENTLIME9));
    }
    public String getLimeNeed1() {
        return sanitizeText(rawData.optString(LIMENEED1));
    }
    public String getLimeNeed10() {
        return sanitizeText(rawData.optString(LIMENEED10));
    }
    public String getLimeNeed2() {
        return sanitizeText(rawData.optString(LIMENEED2));
    }
    public String getLimeNeed3() {
        return sanitizeText(rawData.optString(LIMENEED3));
    }
    public String geLimeNeed4() {
        return sanitizeText(rawData.optString(LIMENEED4));
    }
    public String getLimeNeed5() {
        return sanitizeText(rawData.optString(LIMENEED5));
    }
    public String getLimeNeed6() {
        return sanitizeText(rawData.optString(LIMENEED6));
    }
    public String getLimeNeed7() {
        return sanitizeText(rawData.optString(LIMENEED7));
    }
    public String getLimeNeed8() {
        return sanitizeText(rawData.optString(LIMENEED8));
    }
    public String getLimeNeed9() {
        return sanitizeText(rawData.optString(LIMENEED9));
    }
    public String getNumberOfPlots() {
        return sanitizeText(rawData.optString(NUMBEROFPLOTS));
    }
    public String getOrganicMatter1() {
        return sanitizeText(rawData.optString(ORGANICMATTER1));
    }
    public String getOrganicMatter10() {
        return sanitizeText(rawData.optString(ORGANICMATTER10));
    }
    public String getOrganicMatter2() {
        return sanitizeText(rawData.optString(ORGANICMATTER2));
    }
    public String getOrganicMatter3() {
        return sanitizeText(rawData.optString(ORGANICMATTER3));
    }
    public String getOrganicMatter4() {
        return sanitizeText(rawData.optString(ORGANICMATTER4));
    }
    public String getOrganicMatter5() {
        return sanitizeText(rawData.optString(ORGANICMATTER5));
    }
    public String getOrganicMatter6() {
        return sanitizeText(rawData.optString(ORGANICMATTER6));
    }
    public String getOrganicMatter7() {
        return sanitizeText(rawData.optString(ORGANICMATTER7));
    }
    public String getOrganicMatter8() {
        return sanitizeText(rawData.optString(ORGANICMATTER8));
    }
    public String getOrganicMatter9() {
        return sanitizeText(rawData.optString(ORGANICMATTER9));
    }
    public String getPestDiseaseSanitation1() {
        return sanitizeText(rawData.optString(PESTDISEASESANITATION1));
    }
    public String getPestDiseaseSanitation10() {
        return sanitizeText(rawData.optString(PESTDISEASESANITATION10));
    }
    public String getPestDiseaseSanitation2() {
        return sanitizeText(rawData.optString(PESTDISEASESANITATION2));
    }
    public String getPestDiseaseSanitation3() {
        return sanitizeText(rawData.optString(PESTDISEASESANITATION3));
    }
    public String getPestDiseaseSanitation4() {
        return sanitizeText(rawData.optString(PESTDISEASESANITATION4));
    }
    public String getPestDiseaseSanitation5() {
        return sanitizeText(rawData.optString(PESTDISEASESANITATION5));
    }
    public String getPestDiseaseSanitation6() {
        return sanitizeText(rawData.optString(PESTDISEASESANITATION6));
    }
    public String getPestDiseaseSanitation7() {
        return sanitizeText(rawData.optString(PESTDISEASESANITATION7));
    }
    public String getPestDiseaseSanitation8() {
        return sanitizeText(rawData.optString(PESTDISEASESANITATION8));
    }
    public String getPestDiseaseSanitation9() {
        return sanitizeText(rawData.optString(PESTDISEASESANITATION9));
    }
    public String getPlantingMaterial1() {
        return sanitizeText(rawData.optString(PLANTINGMATERIAL1));
    }
    public String getPlantingMaterial10() {
        return sanitizeText(rawData.optString(PLANTINGMATERIAL10));
    }
    public String getPlantingMaterial2() {
        return sanitizeText(rawData.optString(PLANTINGMATERIAL2));
    }
    public String getPlantingMaterial3() {
        return sanitizeText(rawData.optString(PLANTINGMATERIAL3));
    }
    public String getPlantingMaterial4() {
        return sanitizeText(rawData.optString(PLANTINGMATERIAL4));
    }
    public String getPlantingMaterial5() {
        return sanitizeText(rawData.optString(PLANTINGMATERIAL5));
    }
    public String getPlantingMaterial6() {
        return sanitizeText(rawData.optString(PLANTINGMATERIAL6));
    }
    public String getPlantingMaterial7() {
        return sanitizeText(rawData.optString(PLANTINGMATERIAL7));
    }
    public String getPlantingMaterial8() {
        return sanitizeText(rawData.optString(PLANTINGMATERIAL8));
    }
    public String getPlantingMaterial9() {
        return sanitizeText(rawData.optString(PLANTINGMATERIAL9));
    }
    public String getPlot10Age() {
        return sanitizeText(rawData.optString(PLOT10AGE));
    }
    public String getPlot10Area() {
        return sanitizeText(rawData.optString(PLOT10AREA));
    }
    public String getPlot10CocoaTrees() {
        return sanitizeText(rawData.optString(PLOT10COCOATREES));
    }
    public String getPlot10GPS() {
        return sanitizeText(rawData.optString(PLOT10GPS));
    }
    public String getPlot10ShadeTrees() {
        return sanitizeText(rawData.optString(PLOT10SHADETREES));
    }
    public String getPlot10Yield() {
        return sanitizeText(rawData.optString(PLOT10YIELD));
    }
    public String getPlot1Age() {
        return sanitizeText(rawData.optString(PLOT1AGE));
    }
    public String getPlot1Area() {
        return sanitizeText(rawData.optString(PLOT1AREA));
    }
    public String getPlot1CocoaTrees() {
        return sanitizeText(rawData.optString(PLOT1COCOATREES));
    }
    public String getPlot1GPS() {
        return sanitizeText(rawData.optString(PLOT1GPS));
    }
    public String getPlot1ShadeTrees() {
        return sanitizeText(rawData.optString(PLOT1SHADETREES));
    }
    public String getPlot1Yield() {
        return sanitizeText(rawData.optString(PLOT1YIELD));
    }
    public String getPlot2Age() {
        return sanitizeText(rawData.optString(PLOT2AGE));
    }
    public String getPlot2Area() {
        return sanitizeText(rawData.optString(PLOT2AREA));
    }
    public String getPlot2CocoaTrees() {
        return sanitizeText(rawData.optString(PLOT2COCOATREES));
    }
    public String getPlot2GPS() {
        return sanitizeText(rawData.optString(PLOT2GPS));
    }
    public String getPlot2ShadeTrees() {
        return sanitizeText(rawData.optString(PLOT2SHADETREES));
    }
    public String getPlot2Yield() {
        return sanitizeText(rawData.optString(PLOT2YIELD));
    }
    public String getPlot3Age() {
        return sanitizeText(rawData.optString(PLOT3AGE));
    }
    public String getPlot3Area() {
        return sanitizeText(rawData.optString(PLOT3AREA));
    }
    public String getPlot3CocoaTrees() {
        return sanitizeText(rawData.optString(PLOT3COCOATREES));
    }
    public String getPlot3GPS() {
        return sanitizeText(rawData.optString(PLOT3GPS));
    }
    public String getPlot3ShadeTrees() {
        return sanitizeText(rawData.optString(PLOT3SHADETREES));
    }
    public String getPlot3Yield() {
        return sanitizeText(rawData.optString(PLOT3YIELD));
    }
    public String getPlot4Age() {
        return sanitizeText(rawData.optString(PLOT4AGE));
    }
    public String getPlot4Area() {
        return sanitizeText(rawData.optString(PLOT4AREA));
    }
    public String getPlot4CocoaTrees() {
        return sanitizeText(rawData.optString(PLOT4COCOATREES));
    }
    public String getPlot4GPS() {
        return sanitizeText(rawData.optString(PLOT4GPS));
    }
    public String getPlot4ShadeTrees() {
        return sanitizeText(rawData.optString(PLOT4SHADETREES));
    }
    public String getPlot4Yield() {
        return sanitizeText(rawData.optString(PLOT4YIELD));
    }
    public String getPlot5Age() {
        return sanitizeText(rawData.optString(PLOT5AGE));
    }
    public String getPlot5Area() {
        return sanitizeText(rawData.optString(PLOT5AREA));
    }
    public String getPlot5CocoaTrees() {
        return sanitizeText(rawData.optString(PLOT5COCOATREES));
    }
    public String getPlot5GPS() {
        return sanitizeText(rawData.optString(PLOT5GPS));
    }
    public String getPlot5ShadeTrees() {
        return sanitizeText(rawData.optString(PLOT5SHADETREES));
    }
    public String getPlot5Yield() {
        return sanitizeText(rawData.optString(PLOT5YIELD));
    }
    public String getPlot6Age() {
        return sanitizeText(rawData.optString(PLOT6AGE));
    }
    public String getPlot6Area() {
        return sanitizeText(rawData.optString(PLOT6AREA));
    }
    public String getPlot6CocoaTrees() {
        return sanitizeText(rawData.optString(PLOT6COCOATREES));
    }
    public String getPlot6GPS() {
        return sanitizeText(rawData.optString(PLOT6GPS));
    }
    public String getPlot6ShadeTrees() {
        return sanitizeText(rawData.optString(PLOT6SHADETREES));
    }
    public String getPlot6Yield() {
        return sanitizeText(rawData.optString(PLOT6YIELD));
    }
    public String getPlot7Age() {
        return sanitizeText(rawData.optString(PLOT7AGE));
    }
    public String getPlot7Area() {
        return sanitizeText(rawData.optString(PLOT7AREA));
    }
    public String getPlot7CocoaTrees() {
        return sanitizeText(rawData.optString(PLOT7COCOATREES));
    }
    public String getPlot7GPS() {
        return sanitizeText(rawData.optString(PLOT7GPS));
    }
    public String getPlot7ShadeTrees() {
        return sanitizeText(rawData.optString(PLOT7SHADETREES));
    }
    public String getPlot7Yield() {
        return sanitizeText(rawData.optString(PLOT7YIELD));
    }
    public String getPlot8Age() {
        return sanitizeText(rawData.optString(PLOT8AGE));
    }
    public String getPlot8Area() {
        return sanitizeText(rawData.optString(PLOT8AREA));
    }
    public String getPlot8CocoaTrees() {
        return sanitizeText(rawData.optString(PLOT8COCOATREES));
    }
    public String getPlot8GPS() {
        return sanitizeText(rawData.optString(PLOT8GPS));
    }
    public String getPlot8ShadeTrees() {
        return sanitizeText(rawData.optString(PLOT8SHADETREES));
    }
    public String getPlot8Yield() {
        return sanitizeText(rawData.optString(PLOT8YIELD));
    }
    public String getPlot9Age() {
        return sanitizeText(rawData.optString(PLOT9AGE));
    }
    public String getPlot9Area() {
        return sanitizeText(rawData.optString(PLOT9AREA));
    }
    public String getPlot9CocoaTrees() {
        return sanitizeText(rawData.optString(PLOT9COCOATREES));
    }
    public String getPlot9GPS() {
        return sanitizeText(rawData.optString(PLOT9GPS));
    }
    public String getPlot9ShadeTrees() {
        return sanitizeText(rawData.optString(PLOT9SHADETREES));
    }
    public String getPlot9Yield() {
        return sanitizeText(rawData.optString(PLOT9YIELD));
    }
    public String getPruning1() {
        return sanitizeText(rawData.optString(PRUNING1));
    }
    public String getPruning10() {
        return sanitizeText(rawData.optString(PRUNING10));
    }
    public String getPruning2() {
        return sanitizeText(rawData.optString(PRUNING2));
    }
    public String getPruning3() {
        return sanitizeText(rawData.optString(PRUNING3));
    }
    public String getPruning4() {
        return sanitizeText(rawData.optString(PRUNING4));
    }
    public String getPruning5() {
        return sanitizeText(rawData.optString(PRUNING5));
    }
    public String getPruning6() {
        return sanitizeText(rawData.optString(PRUNING6));
    }
    public String getPruning7() {
        return sanitizeText(rawData.optString(PRUNING7));
    }
    public String getPruning8() {
        return sanitizeText(rawData.optString(PRUNING8));
    }
    public String getPruning9() {
        return sanitizeText(rawData.optString(PRUNING9));
    }
    public String getReasonNotAgreed() {
        return sanitizeText(rawData.optString(REASONSNOTAGREED));
    }
    public String getShadeManagement1() {
        return sanitizeText(rawData.optString(SHADEMANAGEMENT1));
    }
    public String getShadeManagement10() {
        return sanitizeText(rawData.optString(SHADEMANAGEMENT10));
    }
    public String getShadeManagement2() {
        return sanitizeText(rawData.optString(SHADEMANAGEMENT2));
    }
    public String getShadeManagement3() {
        return sanitizeText(rawData.optString(SHADEMANAGEMENT3));
    }
    public String getShadeManagement4() {
        return sanitizeText(rawData.optString(SHADEMANAGEMENT4));
    }
    public String getShadeManagement5() {
        return sanitizeText(rawData.optString(SHADEMANAGEMENT5));
    }
    public String getShadeManagement6() {
        return sanitizeText(rawData.optString(SHADEMANAGEMENT6));
    }
    public String getShadeManagement7() {
        return sanitizeText(rawData.optString(SHADEMANAGEMENT7));
    }
    public String getShadeManagement8() {
        return sanitizeText(rawData.optString(SHADEMANAGEMENT8));
    }
    public String getShadeManagement9() {
        return sanitizeText(rawData.optString(SHADEMANAGEMENT9));
    }
    public String getSoilCondition1() {
        return sanitizeText(rawData.optString(SOILCONDITION1));
    }
    public String getSoilCondition10() {
        return sanitizeText(rawData.optString(SOILCONDITION10));
    }
    public String getSoilCondition2() {
        return sanitizeText(rawData.optString(SOILCONDITION2));
    }
    public String getSoilCondition3() {
        return sanitizeText(rawData.optString(SOILCONDITION3));
    }
    public String getSoilCondition4() {
        return sanitizeText(rawData.optString(SOILCONDITION4));
    }
    public String getSoilCondition5() {
        return sanitizeText(rawData.optString(SOILCONDITION5));
    }
    public String getSoilCondition6() {
        return sanitizeText(rawData.optString(SOILCONDITION6));
    }
    public String getSoilCondition7() {
        return sanitizeText(rawData.optString(SOILCONDITION7));
    }
    public String getSoilCondition8() {
        return sanitizeText(rawData.optString(SOILCONDITION8));
    }
    public String getSoilCondition9() {
        return sanitizeText(rawData.optString(SOILCONDITION9));
    }
    public String getStartYearP1() {
        return sanitizeText(rawData.optString(STARTYEARP1));
    }
    public String getStartYearP10() {
        return sanitizeText(rawData.optString(STARTYEARP10));
    }
    public String getStartYearP2() {
        return sanitizeText(rawData.optString(STARTYEARP2));
    }
    public String getStartYearP3() {
        return sanitizeText(rawData.optString(STARTYEARP3));
    }
    public String getStartYearP4() {
        return sanitizeText(rawData.optString(STARTYEARP4));
    }
    public String getStartYearP5() {
        return sanitizeText(rawData.optString(STARTYEARP5));
    }
    public String getStartYearP6() {
        return sanitizeText(rawData.optString(STARTYEARP6));
    }
    public String getStartYearP7() {
        return sanitizeText(rawData.optString(STARTYEARP7));
    }
    public String getStartYearP8() {
        return sanitizeText(rawData.optString(STARTYEARP8));
    }
    public String getStartYearP9() {
        return sanitizeText(rawData.optString(STARTYEARP9));
    }
    public String getTotalAreaOtherCrops() {
        return sanitizeText(rawData.optString(TOTALAREAOTHERCROPS));
    }
    public String getTotalCocoaArea() {
        return sanitizeText(rawData.optString(TOTALCOCOAAREA));
    }
    public String getTotalFarmArea() {
        return sanitizeText(rawData.optString(TOTALFARMAREA));
    }
    public String getTotalRenovationArea() {return sanitizeText(rawData.optString(TOTALRENOVATIONAREA));}
    public String getTreeAge1() {
        return sanitizeText(rawData.optString(TREEAGE1));
    }
    public String getTreeAge10() {
        return sanitizeText(rawData.optString(TREEAGE10));
    }
    public String getTreeAge2() {
        return sanitizeText(rawData.optString(TREEAGE2));
    }
    public String getTreeAge3() {
        return sanitizeText(rawData.optString(TREEAGE3));
    }
    public String getTreeAge4() {
        return sanitizeText(rawData.optString(TREEAGE4));
    }
    public String getTreeAge5() {
        return sanitizeText(rawData.optString(TREEAGE5));
    }
    public String getTreeAge6() {
        return sanitizeText(rawData.optString(TREEAGE6));
    }
    public String getTreeAge7() {
        return sanitizeText(rawData.optString(TREEAGE7));
    }
    public String getTreeAge8() {
        return sanitizeText(rawData.optString(TREEAGE8));
    }
    public String getTreeAge9() {
        return sanitizeText(rawData.optString(TREEAGE9));
    }
    public String getTreeDensity1() {
        return sanitizeText(rawData.optString(TREEDENSITY1));
    }
    public String getTreeDensity10() {
        return sanitizeText(rawData.optString(TREEDENSITY10));
    }
    public String getTreeDensity2() {
        return sanitizeText(rawData.optString(TREEDENSITY2));
    }
    public String getTreeDensity3() {
        return sanitizeText(rawData.optString(TREEDENSITY3));
    }
    public String getTreeDensity4() {
        return sanitizeText(rawData.optString(TREEDENSITY4));
    }
    public String getTreeDensity5() {
        return sanitizeText(rawData.optString(TREEDENSITY5));
    }
    public String getTreeDensity6() {
        return sanitizeText(rawData.optString(TREEDENSITY6));
    }
    public String getTreeDensity7() {
        return sanitizeText(rawData.optString(TREEDENSITY7));
    }
    public String getTreeDensity8() {
        return sanitizeText(rawData.optString(TREEDENSITY8));
    }
    public String getTreeDensity9() {
        return sanitizeText(rawData.optString(TREEDENSITY9));
    }
    public String getTreeHealth1() {
        return sanitizeText(rawData.optString(TREEHEALTH1));
    }
    public String getTreeHealth10() {
        return sanitizeText(rawData.optString(TREEHEALTH10));
    }
    public String getTreeHealth2() {
        return sanitizeText(rawData.optString(TREEHEALTH2));
    }
    public String getTreeHealth3() {
        return sanitizeText(rawData.optString(TREEHEALTH3));
    }
    public String getTreeHealth4() {
        return sanitizeText(rawData.optString(TREEHEALTH4));
    }
    public String getTreeHealth5() {
        return sanitizeText(rawData.optString(TREEHEALTH5));
    }
    public String getTreeHealth6() {
        return sanitizeText(rawData.optString(TREEHEALTH6));
    }
    public String getTreeHealth7() {
        return sanitizeText(rawData.optString(TREEHEALTH7));
    }
    public String getTreeHealth8() {
        return sanitizeText(rawData.optString(TREEHEALTH8));
    }
    public String getTreeHealth9() {
        return sanitizeText(rawData.optString(TREEHEALTH9));
    }
    public String getWeeding1() {
        return sanitizeText(rawData.optString(WEEDING1));
    }
    public String getWeeding10() {
        return sanitizeText(rawData.optString(WEEDING10));
    }
    public String getWeeding2() {
        return sanitizeText(rawData.optString(WEEDING2));
    }
    public String getWeeding3() {
        return sanitizeText(rawData.optString(WEEDING3));
    }
    public String getWeeding4() {
        return sanitizeText(rawData.optString(WEEDING4));
    }
    public String getWeeding5() {
        return sanitizeText(rawData.optString(WEEDING5));
    }
    public String getWeeding6() {
        return sanitizeText(rawData.optString(WEEDING6));
    }
    public String getWeeding7() {
        return sanitizeText(rawData.optString(WEEDING7));
    }
    public String getWeeding8() {
        return sanitizeText(rawData.optString(WEEDING8));
    }
    public String getWeeding9() {
        return sanitizeText(rawData.optString(WEEDING9));
    }

    public String getGA15() {
        return sanitizeText(rawData.optString(GA15));
    }
    public String getGB48() {
        return sanitizeText(rawData.optString(GB48));
    }
    public String getGB49() {
        return sanitizeText(rawData.optString(GB49));
    }
    public String getGB51() {
        return sanitizeText(rawData.optString(GB51));
    }
    public String getGB52() {
        return sanitizeText(rawData.optString(GB52));
    }
    public String getGB54() {
        return sanitizeText(rawData.optString(GB54));
    }
    public String getGB55() {
        return sanitizeText(rawData.optString(GB55));
    }
    public String getGB56() {
        return sanitizeText(rawData.optString(GB56));
    }
    public String getGB58() {
        return sanitizeText(rawData.optString(GB58));
    }
    public String getGB59() {
        return sanitizeText(rawData.optString(GB59));
    }
    public String getGB60() {
        return sanitizeText(rawData.optString(GB60));
    }
    public String getGB61() {
        return sanitizeText(rawData.optString(GB61));
    }
    public String getGB64() {
        return sanitizeText(rawData.optString(GB64));
    }
    public String getGB65() {
        return sanitizeText(rawData.optString(GB65));
    }
    public String getGB66() {
        return sanitizeText(rawData.optString(GB66));
    }
    public String getG68() {
        return sanitizeText(rawData.optString(GB68));
    }
    public String getGB72() {
        return sanitizeText(rawData.optString(GB72));
    }
    public String getGC95() {
        return sanitizeText(rawData.optString(GC95));
    }
    public String getCOB3() {
        return sanitizeText(rawData.optString(COB3));
    }
    public String getCOB4() {
        return sanitizeText(rawData.optString(COB4));
    }
    public String getCOB5() {
        return sanitizeText(rawData.optString(COB5));
    }
    public String getRA1() {
        return sanitizeText(rawData.optString(RA1));
    }
    public String getRA2() {
        return sanitizeText(rawData.optString(RA2));
    }
    public String getRA3() {
        return sanitizeText(rawData.optString(RA3));
    }
    public String getRA4() {
        return sanitizeText(rawData.optString(RA4));
    }
    public String getRA5() {
        return sanitizeText(rawData.optString(RA5));
    }
    public String getRA6() {
        return sanitizeText(rawData.optString(RA6));
    }
    public String getRA7() {
        return sanitizeText(rawData.optString(RA7));
    }
    public String getRA8() {
        return sanitizeText(rawData.optString(RA8));
    }
    public String getRA9() {
        return sanitizeText(rawData.optString(RA9));
    }
    public String getRA10() {
        return sanitizeText(rawData.optString(RA10));
    }
    public String getRA11() {
        return sanitizeText(rawData.optString(RA11));
    }
    public String getRA12() {
        return sanitizeText(rawData.optString(RA12));
    }


    /**
     * Returns whether the contact has been locally modified or not.
     *
     * @return True - if the contact has been locally modified, False - otherwise.
     */
    public boolean isLocallyModified() {
        return isLocallyModified;
    }

    private String sanitizeText(String text) {
        if (TextUtils.isEmpty(text) || text.equals(Constants.NULL_STRING)) {
            return Constants.EMPTY_STRING;
        }
        return text;
    }
}
