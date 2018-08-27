package com.example.mani.mek3;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowUpcomingDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_upcomig_details);

        BookingDetail detail = (BookingDetail) getIntent().getSerializableExtra("booking_detail");

        getSupportActionBar().setTitle("Order #"+detail.getBooking_id());

//        Log.e("id",""+detail.isPayment_confirmation());
//        Log.e("id",""+detail.getModel_name());
//        Log.e("id",""+detail.getBooking_id());
//        Log.e("id",""+detail.getAddress());

        ImageView modelLogo     = findViewById(R.id.model_logo);
        TextView modelName      = findViewById(R.id.model_name);

        TextView licence_plate_no = findViewById(R.id.licence_plate_number);
        TextView address        = findViewById(R.id.address);

        TextView pay_text       = findViewById(R.id.payment_confirm);
        ImageView pay_tick      = findViewById(R.id.payment_confirm_tick);
        TextView call           = findViewById(R.id.call);

        TextView booking_time   = findViewById(R.id.booking_time);
        TextView duration       = findViewById(R.id.duration);
        TextView fare           = findViewById(R.id.fare);

        TextView navigation     = findViewById(R.id.navigation);


        int company_id = detail.getCompany_id();

        switch (company_id){
            case 0 : modelLogo.setImageResource(R.drawable.ic_suzuki); break;
            case 1 : modelLogo.setImageResource(R.drawable.ic_suzuki); break;
            case 2 : modelLogo.setImageResource(R.drawable.ic_bmw); break;
            case 3 : modelLogo.setImageResource(R.drawable.ic_volkswagen); break;
        }

        modelName.setText(detail.getModel_name());
        licence_plate_no.setText(detail.getLicence_plate_no());
        address.setText(detail.getAddress());

        if(detail.isPayment_confirmation()){
            pay_text.setTextColor(ContextCompat.getColor(this, R.color.payment_confirmed));
            pay_tick.setImageResource(R.drawable.ic_tick_green);

        }

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShowUpcomingDetails.this,"Calling",Toast.LENGTH_SHORT).show();
            }
        });

        booking_time.setText(detail.getBoolking_time());
        duration.setText(detail.getDuraion());
        fare.setText("\u20B9 "+String.valueOf(detail.getFare()));


        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShowUpcomingDetails.this,"Navigating",Toast.LENGTH_SHORT).show();
            }
        });





    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
