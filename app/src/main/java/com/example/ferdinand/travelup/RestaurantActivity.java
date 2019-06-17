package com.example.ferdinand.travelup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.ferdinand.travelup.adapter.RestoAdapter;
import com.example.ferdinand.travelup.model.RestoModel;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private RestoAdapter restoAdapter;
    private ArrayList<RestoModel> lstResto;
    private RecyclerView.LayoutManager layoutManager;

    // RestaurantActivity is an activity that allows the user to search for restaurants by typing the
    // name of the restaurant or by scrolling down the list.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        ImageView backIcon = findViewById(R.id.backarrow);
        backIcon.setOnClickListener(this);

        createRestoList();
        buildRecyclerView();

        EditText editText = findViewById(R.id.retSearch);
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

    // filter method is used to do a simple searching from the lstResto ArrayList
    private void filter(String text){
        ArrayList<RestoModel> filteredList = new ArrayList<>();

        for (RestoModel item : lstResto){
            if (item.getNameResto().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        restoAdapter.filterList(filteredList);
    }

    // createRestoList method is used to create an ArrayList containing data with six parameters on
    // every item
    private void createRestoList(){
        lstResto = new ArrayList<>();
        lstResto.add(new RestoModel("McDonald's Kaliurang", "Jl. Kaliurang No.Km. 5.5, Sleman, Yogyakarta",
                -7.7625199, 110.3774708, "4.4", R.drawable.mcd));
        lstResto.add(new RestoModel("Yoshinoya Kaliurang", "Jl. Kaliurang No.Km 5, Sleman, Yogyakarta",
                -7.7615964, 110.3781879, "4.5", R.drawable.yoshinoya));
        lstResto.add(new RestoModel("Pizza Hut Kaliurang", "Jalan Kaliurang No.KM 5.6, Sleman, Yogyakarta",
                -7.7563335, 110.3800553, "4.5", R.drawable.ph));
        lstResto.add(new RestoModel("Yamie Panda Kridosono", "Jl. Krasak Timur No. 20, Yogyakarta",
                -7.7886154, 110.3726448, "4.5", R.drawable.yamie));
        lstResto.add(new RestoModel("Gudeg Yu Djum", "Jl. Agro No.5-15, Sleman, Yogyakarta",
                -7.7660603, 110.3791894, "4.3", R.drawable.gudeg));
        lstResto.add(new RestoModel("Hoka Hoka Bento Kaliurang", "Jl. Kaliurang Km 5.5, Sleman, Yogyakarta",
                -7.7578515, 110.3796108, "4.4", R.drawable.hokben));
        lstResto.add(new RestoModel("Nasi Uduk Palagan", "Jalan Palagan Tentara Pelajar, Sleman, Yogyakarta",
                -7.7470868, 110.3703317, "4.4", R.drawable.nasiuduk));
        lstResto.add(new RestoModel("Ayam Goreng Suharti", "Jl. Laksda Adisucipto No.208, Sleman, Yogyakarta",
                -7.783138, 110.4112649, "4.3", R.drawable.suharti));
        lstResto.add(new RestoModel("Kalimilk", "Jl. Kaliurang No.KM. 4.9, Sleman, Yogyakarta",
                -7.7629649, 110.3777577, "4.2", R.drawable.kalimilk));
        lstResto.add(new RestoModel("Mie Ayam Palembang Afui", "Jl. Kaliurang KM 4.5, Yogyakarta",
                -7.7634964, 110.3769852, "4.4", R.drawable.afui));
        lstResto.add(new RestoModel("Sushi Tei", "Jl. Affandi No.9, Sleman, Yogyakarta",
                -7.7789156, 110.3864213, "4.5", R.drawable.sushitei));
        lstResto.add(new RestoModel("Spesial Sambal", "Jalan Pandega Marta No.532 D, Sleman, Yogyakarta",
                -7.7559463, 110.3744107, "4.4", R.drawable.spesialsambal));
        lstResto.add(new RestoModel("Ayam Keprabon", "Jl. Prof. Herman Yohanes, Yogyakarta",
                -7.7791109, 110.3775837, "4.5", R.drawable.keprabon));
        lstResto.add(new RestoModel("Lotek & Gado Gado Bu Bagyo", "Jl. Prof. Herman Yohanes No.1, Yogyakarta",
                -7.7805644, 110.3770804, "4.4", R.drawable.lotek));
        lstResto.add(new RestoModel("Kentucky Fried Chicken", "Jl. C. Simanjuntak No.72A, Yogyakarta",
                -7.7759082, 110.3724175, "4.3", R.drawable.kfc));
    }

    // buildRecyclerView method is used prepare the RecyclerView, to display scrolling restaurant list
    // of elements
    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerviewMenuResto);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        restoAdapter = new RestoAdapter(this, lstResto);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(restoAdapter);
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
