package com.example.mani.mek3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryAdapterViewHolder>{

    Context mCtx;
    List<BookingDetail> mHistoryList;

    public HistoryAdapter(Context mCtx, List<BookingDetail> mHistoryList) {
        this.mCtx = mCtx;
        this.mHistoryList = mHistoryList;
    }

    @Override
    public HistoryAdapter.HistoryAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recycler_view_history_single_layout,parent,false);
        return new HistoryAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.HistoryAdapterViewHolder holder, int position) {

        final BookingDetail booking = mHistoryList.get(position);

        int company_id =  booking.getCompany_id();

        switch (company_id){
            case 0 : holder.iv_model_logo.setImageResource(R.drawable.ic_suzuki); break;
            case 1 : holder.iv_model_logo.setImageResource(R.drawable.ic_suzuki); break;
            case 2 : holder.iv_model_logo.setImageResource(R.drawable.ic_bmw); break;
            case 3 : holder.iv_model_logo.setImageResource(R.drawable.ic_volkswagen); break;
        }



        holder.tv_model_name.setText(booking.getModel_name());
        holder.tv_booking_id.setText("#"+String.valueOf(booking.getBooking_id()));
        holder.tv_licence.setText(booking.getLicence_plate_no());

        holder.tv_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "7907977801";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                mCtx.startActivity(intent);
            }
        });

        if(booking.isPayment_confirmation()) {
            holder.tv_pay_con.setTextColor(ContextCompat.getColor(mCtx, R.color.payment_confirmed));
            holder.iv_pay_con.setImageResource(R.drawable.ic_tick_green);
        }

        holder.iv_history_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mCtx,ShowHistoryDetails.class);
                i.putExtra("booking_detail", (Serializable) booking);
                mCtx.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mHistoryList.size();
    }

    public class HistoryAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView tv_booking_id,tv_model_name,tv_licence,tv_pay_con,tv_call;
        ImageView iv_history_detail,iv_model_logo,iv_pay_con;

        public HistoryAdapterViewHolder(View itemView) {
            super(itemView);

            tv_booking_id = itemView.findViewById(R.id.booking_id);
            tv_model_name = itemView.findViewById(R.id.model_name);
            tv_licence    = itemView.findViewById(R.id.licence_plate_number);
            tv_pay_con    = itemView.findViewById(R.id.payment_confirm);
            tv_call       = itemView.findViewById(R.id.call);

            iv_history_detail = itemView.findViewById(R.id.upcoming_detail);
            iv_model_logo      = itemView.findViewById(R.id.model_logo);
            iv_pay_con         = itemView.findViewById(R.id.payment_confirm_tick);

        }
    }
}
