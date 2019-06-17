package com.example.ferdinand.travelup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View;

import java.util.ArrayList;

import com.example.ferdinand.travelup.adapter.*;
import com.example.ferdinand.travelup.model.*;

public class HotelActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private ArrayList<HotelModel> lstHotel;
    private HotelAdapter hotelAdapter;
    private RecyclerView.LayoutManager layoutManager;

    // HotelActivity is an activity that allows the user to search for hotels by typing the name of the
    // hotel or by scrolling down the list.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        ImageView backIcon = findViewById(R.id.backarrow);
        backIcon.setOnClickListener(this);

        createHotelList();
        buildRecyclerView();

        EditText editText = findViewById(R.id.hetSearch);
        editText.addTextChangedListener(new TextWatcher() {
            // These methods are made to do a filter with 's' input on the EditText
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    // filter method is used to do a simple searching from the lstHotel ArrayList.
    private void filter(String text){
        ArrayList<HotelModel> filteredList = new ArrayList<>();

        for (HotelModel item : lstHotel){
            if (item.getNameHotel().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        hotelAdapter.filterList(filteredList);
    }

    // createHotelList method is used to create an ArrayList containing data with six parameters on
    // every item.
    private void createHotelList(){
        lstHotel = new ArrayList<>();
        lstHotel.add(new HotelModel("Favehotel", "Jl. I Dewa Nyoman Oka No.30, Yogyakarta",
                -7.7855261,110.3677555, "4.4", R.drawable.favehotel));
        lstHotel.add(new HotelModel("Marriott Hotel", "Jl. Ringroad Utara, Sleman, Yogyakarta",
                -7.761885, 110.3962313,"4.7", R.drawable.marriott));
        lstHotel.add(new HotelModel("Platinum Hotel", "Jl. Raya Solo - Yogyakarta No.28, Sleman, Yogyakarta",
                -7.7830952, 110.4350722, "4.5", R.drawable.platinum));
        lstHotel.add(new HotelModel("Royal Ambarrukmo Hotel", "Jl. Laksda Adisucipto No.81, Sleman, Yogyakarta",
                -7.7827773, 110.4006064, "4.7",R.drawable.ambarrukmo));
        lstHotel.add(new HotelModel("Grand Mercure Hotel", "Jl. Laksda Adisucipto No.80, Sleman, Yogyakarta",
                -7.7836748, 110.3901039, "4.5", R.drawable.mercure));
        lstHotel.add(new HotelModel("Sheraton Mustika Hotel", "Jl. Laksda Adisucipto No.Km 8.7, Sleman, Yogyakarta",
                -7.7817487, 110.4258963, "4.5", R.drawable.sheraton));
        lstHotel.add(new HotelModel("Tentrem Hotel", "Jl. P. Mangkubumi No.72A, Yogyakarta",
                -7.7735805, 110.3664571, "4.7", R.drawable.tentrem));
        lstHotel.add(new HotelModel("Grand Tjokro Hotel", "Jl. Affandi No.37, Sleman, Yogyakarta",
                -7.7669399, 110.3893918, "4.3", R.drawable.tjokro));
        lstHotel.add(new HotelModel("Prime Plaza Hotel", "Jl. Affandi, Sleman, Yogyakarta",
                -7.7769294, 110.3871801, "4.5", R.drawable.prime));
        lstHotel.add(new HotelModel("UC Universitas Gadjah Mada", "Jl. Pancasila Bulaksumur No.2, Sleman, Yogyakarta",
                -7.7731477, 110.3751633, "4.3", R.drawable.ucugm));
        lstHotel.add(new HotelModel("Artotel", "Jl. Kaliurang KM 5.6 no. 14, Sleman, Yogyakarta",
                -7.7566449, 110.380034, "4.5", R.drawable.artotel));
        lstHotel.add(new HotelModel("Indoluxe Hotel", "Jl. Palagan No.106, Sleman, Yogyakarta",
                -7.7504087, 110.3706192,"4.4", R.drawable.indoluxe));
        lstHotel.add(new HotelModel("Sahid Rich Hotel", "Jl. Magelang No.KM.6 No.18, Sleman, Yogyakarta",
                -7.7524426, 110.3590168, "4.5", R.drawable.sahid));
        lstHotel.add(new HotelModel("Jambuluwuk Malioboro Hotel", "Jl. Gajah Mada No.67, Yogyakarta",
                -7.7975533, 110.3700699, "4.3", R.drawable.jambuluwuk));
        lstHotel.add(new HotelModel("Lafayette Boutique Hotel", "Jl. Ring Road Utara No. 409, Sleman, Yogyakarta",
                -7.7592471, 110.3852267, "4.6", R.drawable.lafayette));
    }

    // buildRecyclerView method is used prepare the RecyclerView, to display scrolling hotel list
    // of elements
    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerviewMenuHotel);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        hotelAdapter = new HotelAdapter(this, lstHotel);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(hotelAdapter);
    }

    // onClick method is an implementation of the OnClickListener interface, and therefore it applies
    // the polymorphism concept.
    public void onClick(View v) {
        if (v.getId() == R.id.backarrow) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
