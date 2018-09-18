package com.sih2018.mat.schemefinder.SubActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScanner;
import com.edwardvanraak.materialbarcodescanner.MaterialBarcodeScannerBuilder;
import com.google.android.gms.vision.barcode.Barcode;
import com.sih2018.mat.schemefinder.Extras.Aadhar;
import com.sih2018.mat.schemefinder.Extras.DataAttributes;
import com.sih2018.mat.schemefinder.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

public class AadharActivity extends AppCompatActivity {
    private String TAG, Wor_aadhar_string;
    Spinner Spinner_Prof,Spinner_Income;
    Button BTN_Create,BTN_Aadhar_scan;
    EditText Edit_name,Edit_uid,Edit_gender,Edit_dob,Edit_co,Edit_add_dn,Edit_add_street,Edit_add_landmark,Edit_add_vill,Edit_add_post,Edit_add_dist,Edit_add_subdist,Edit_add_state,Edit_add_pincode;

    ArrayAdapter<CharSequence> Skills,EmpTypes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhar);

        BTN_Create = (Button)findViewById(R.id.btn_create);
        BTN_Aadhar_scan = (Button)findViewById(R.id.btn_worker_aadhar);
        Edit_name = (EditText)findViewById(R.id.edit_worker_name);
        Edit_uid = (EditText)findViewById(R.id.edit_aadhar_uid);
        Edit_gender = (EditText)findViewById(R.id.edit_aadhar_gender);
        Edit_dob = (EditText)findViewById(R.id.edit_aadhar_yob);
        Edit_co = (EditText)findViewById(R.id.edit_aadhar_co);
        Edit_add_dn = (EditText)findViewById(R.id.edit_aadhar_add_do);
        Edit_add_street = (EditText)findViewById(R.id.edit_aadhar_add_street);
        Edit_add_landmark = (EditText)findViewById(R.id.edit_aadhar_add_lm);
        Edit_add_post = (EditText)findViewById(R.id.edit_aadhar_add_post);
        Edit_add_vill = (EditText)findViewById(R.id.edit_aadhar_add_vill);
        Edit_add_dist = (EditText)findViewById(R.id.edit_aadhar_add_dist);
        Edit_add_subdist = (EditText)findViewById(R.id.edit_aadhar_add_subdis);
        Edit_add_state = (EditText)findViewById(R.id.edit_aadhar_add_state);
        Edit_add_pincode = (EditText)findViewById(R.id.edit_aadhar_add_pin);

        Spinner_Prof = (Spinner)findViewById(R.id.spinner_profession);
        Spinner_Income = (Spinner)findViewById(R.id.spinner_income);

        Skills = ArrayAdapter.createFromResource(this, R.array.income, android.R.layout.simple_spinner_item);
        Skills.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Income.setAdapter(Skills);

        EmpTypes = ArrayAdapter.createFromResource(this, R.array.Occupation, android.R.layout.simple_spinner_item);
        EmpTypes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_Prof.setAdapter(EmpTypes);

        BTN_Aadhar_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startScan();
            }
        });

        BTN_Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ViewSchemesActivity.class);
                i.putExtra("profession",Spinner_Prof.getSelectedItem().toString());
                i.putExtra("income",Spinner_Income.getSelectedItem().toString());
                i.putExtra("yob",Edit_dob.getText().toString());
                i.putExtra("gender",Edit_gender.getText().toString());
                startActivity(i);

            }
        });
    }

    private void startScan() {
        MaterialBarcodeScanner barcodeScanner = new MaterialBarcodeScannerBuilder(this)
                .withEnableAutoFocus(true)
                .withBackfacingCamera()
                .withBleepEnabled(true)
                .withText("Scan the QR Code")
                .withCenterTracker()
                .withResultListener(new MaterialBarcodeScanner.OnResultListener() {
                    @Override
                    public void onResult(Barcode barcode) {
                        Wor_aadhar_string = barcode.rawValue;
                        Aadhar aadhar = processScannedData(barcode.rawValue);
                        Toast.makeText(getApplicationContext(),Wor_aadhar_string,Toast.LENGTH_LONG).show();
                        setAadharAttributesFormember(aadhar);
                    }
                })
                .build();

        barcodeScanner.startScan();
    }

    public Aadhar processScannedData(String scanData){
        Log.d("Rajdeol",scanData);
        Aadhar aadhar = new Aadhar();
        XmlPullParserFactory pullParserFactory;
        try {
            // init the parserfactory
            pullParserFactory = XmlPullParserFactory.newInstance();
            // get the parser
            XmlPullParser parser = pullParserFactory.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(new StringReader(scanData));
            // parse the XML
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if(eventType == XmlPullParser.START_DOCUMENT) {
                    Log.d("Rajdeol","Start document");
                } else if(eventType == XmlPullParser.START_TAG && DataAttributes.AADHAAR_DATA_TAG.equals(parser.getName())) {
                    // extract data from tag
                    //uid
                    aadhar.uid = parser.getAttributeValue(null,DataAttributes.AADHAR_UID_ATTR);
                    //name
                    aadhar.name = parser.getAttributeValue(null,DataAttributes.AADHAR_NAME_ATTR);
                    //gender
                    aadhar.gender = parser.getAttributeValue(null,DataAttributes.AADHAR_GENDER_ATTR);
                    // year of birth
                    aadhar.yob = parser.getAttributeValue(null,DataAttributes.AADHAR_YOB_ATTR);
                    //gname
                    aadhar.gname = parser.getAttributeValue(null,DataAttributes.AADHAR_GNAME_ATTR);

                    // care of
                    aadhar.careof = parser.getAttributeValue(null,DataAttributes.AADHAR_CO_ATTR);

                    // street
                    aadhar.street = parser.getAttributeValue(null,DataAttributes.AADHAR_STREET_ATTR);

                    // house
                    aadhar.house = parser.getAttributeValue(null,DataAttributes.AADHAR_HOUSE_ATTR);

                    // landmark
                    aadhar.landmark = parser.getAttributeValue(null,DataAttributes.AADHAR_LM_ATTR);

                    // village
                    aadhar.vtc = parser.getAttributeValue(null,DataAttributes.AADHAR_VTC_ATTR);
                    // Post Office
                    aadhar.postoffice = parser.getAttributeValue(null,DataAttributes.AADHAR_PO_ATTR);
                    // district
                    aadhar.dist = parser.getAttributeValue(null,DataAttributes.AADHAR_DIST_ATTR);

                    // subdistrict
                    aadhar.subdist = parser.getAttributeValue(null,DataAttributes.AADHAR_SUBDIST_ATTR);

                    // state
                    aadhar.state = parser.getAttributeValue(null,DataAttributes.AADHAR_STATE_ATTR);
                    // Post Code
                    aadhar.pincode = parser.getAttributeValue(null,DataAttributes.AADHAR_PC_ATTR);


                } else if(eventType == XmlPullParser.END_TAG) {
                    Log.d(TAG,"End tag "+parser.getName());
                } else if(eventType == XmlPullParser.TEXT) {
                    Log.d(TAG,"Text "+parser.getText());
                }
                // update eventType
                eventType = parser.next();
            }
            // display the data on screen
        } catch (XmlPullParserException e) {

            aadhar = null;
            e.printStackTrace();
            Log.e(TAG,"error in parsing");
        } catch (IOException e) {
            aadhar = null;
            Log.e(TAG,"error in parsing 1");
            e.printStackTrace();
        }

        return aadhar;
    }

    void setAadharAttributesFormember(Aadhar aadhar){
        Edit_name.setText(aadhar.name);
        Edit_uid.setText(aadhar.uid);
        Edit_gender.setText(aadhar.gender);
        Edit_co.setText(aadhar.careof);
        Edit_dob.setText(aadhar.yob);
        Edit_add_dn.setText(aadhar.house);
        Edit_add_street.setText(aadhar.street);
        Edit_add_landmark.setText(aadhar.landmark);
        Edit_add_vill.setText(aadhar.vtc);
        Edit_add_post.setText(aadhar.postoffice);
        Edit_add_dist.setText(aadhar.dist);
        Edit_add_state.setText(aadhar.state);
        Edit_add_subdist.setText(aadhar.subdist);
        Edit_add_pincode.setText(aadhar.pincode);
        Log.e(TAG,"member details set");
    }
}
