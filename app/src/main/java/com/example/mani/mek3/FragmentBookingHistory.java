package com.example.mani.mek3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBookingHistory extends Fragment {


    public FragmentBookingHistory() {
        // Required empty public constructor
    }


    List<BookingDetail> mHistoryList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_booking_history, container, false);

        mHistoryList = new ArrayList<>();

        mHistoryList.add(new BookingDetail(123,1,"Suzuki","DL1PB3201",
                "Geeta Colony,New Delhi,India","2 p.m","3 Hrs",true,25));

        mHistoryList.add(new BookingDetail(456,2,"BMW","DL1PB7245",
                "Geeta Colony,New Delhi,India","1 p.m","2 Hrs",false,75));

        mHistoryList.add(new BookingDetail(789,3,"volkswagen","DL1PB7486",
                "Geeta Colony,New Delhi,India","11 a.m","3 Hrs",true,74));

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_history);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        HistoryAdapter adapter = new HistoryAdapter(getActivity(),mHistoryList);
        recyclerView.setAdapter(adapter);





        return  view;
    }

}
