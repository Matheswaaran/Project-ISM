package com.sih2018.mat.schemefinder.Extras;

/**
 * Created by mat on 31/03/18.
 */

public abstract class DataAttributes {

    //preference attributes
    public static String PREFERENCE_STRING = "HRM_Contractor";
    public static String PREFERENCE_USER_OBJECT = "User";
    public static String PREFERENCE_UID = "uid";
    public static String PREFERENCE_UNAME = "uname";
    //preference attributes

    //splashscreen time
    public static int SPLASH_SCREEN_DISPLAY_TIME = 1000;


    //http request param
    public static String PARAM_USERNAME = "username";
    public static String PARAM_PASSWORD = "password";

    //request
    public static String REQUEST_OPTION = "option";

    //http response code
    public static String RESPONSE_STATUS = "status";
    public static String RESPONSE_MESSAGE = "message";
    public static String RESPONSE_CODE = "code";
    public static String RESPONSE_DATA = "data";
    public static String RESPONSE_UID = "code";
    public static int RESPONSE_SUCCESS = 200;
    public static int RESPONSE_ERROR = 300;
    public static int RESPONSE_VALIDATION_FAILED = 180;


    //Aadhar attributes
    public static String AADHAAR_DATA_TAG = "PrintLetterBarcodeData";
    public static String AADHAR_UID_ATTR = "uid";
    public static String AADHAR_NAME_ATTR = "name";
    public static String AADHAR_GENDER_ATTR = "gender";
    public static String AADHAR_YOB_ATTR = "yob";
    public static String AADHAR_GNAME_ATTR = "gname";
    public static String AADHAR_CO_ATTR = "co";

    public static String AADHAR_STREET_ATTR = "street";
    public static String AADHAR_HOUSE_ATTR = "house";
    public static String AADHAR_LM_ATTR = "lm";
    public static String AADHAR_VTC_ATTR = "vtc";
    public static String AADHAR_PO_ATTR = "po";
    public static String AADHAR_DIST_ATTR = "dist";
    public static String AADHAR_SUBDIST_ATTR = "subdist";
    public static String AADHAR_STATE_ATTR = "state";
    public static String AADHAR_PC_ATTR = "pc";

    public static String AADHAR_DOB_ATTR = "dob";
    //Aadhar attributes

    //worker attributes
    public static String WORKER_SKILL_1 = "skilled";
    public static String WORKER_SKILL_2 = "Semi-skilled";
    public static String WORKER_SKILL_3 = "Unskilled";
    public static String WORKER_SKILL_4 = "Helper";

    public static String WORKER_TYPE_1 = "Permanent";
    public static String WORKER_TYPE_2 = "Contractor";
    public static String WORKER_TYPE_3 = "Casual";

    public static String WORKER_AUTH = "Authenticated";
    public static String WORKER_NOT_AUTH = "Not Authenticated";


    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;

    public static final String SHARED_PREF = "ah_firebase";



    //intend extras
    public static final String INTENT_VIEW = "view";
    public static final String INTENT_EDIT = "edit";
    public static final String INTENT_WORKER = "worker";
    public static final String INTENT_REQUEST = "request";
    public static final String INTENT_FragmentId = "frag_id";
    public static final String INTENT_Su_req = "su_req";
    public static final String INTENT_name = "name";
    public static final String INTENT_aadhar_uid = "uid";


}

