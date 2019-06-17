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

import com.example.ferdinand.travelup.adapter.ShopAdapter;
import com.example.ferdinand.travelup.model.ShopModel;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private ShopAdapter shopAdapter;
    private ArrayList<ShopModel> lstShop;
    private RecyclerView.LayoutManager layoutManager;

    // ShopActivity is an activity that allows the user to search for shops by typing the name of the
    // shop or by scrolling down the list.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ImageView backIcon = findViewById(R.id.backarrow);
        backIcon.setOnClickListener(this);

        createShopList();
        buildRecyclerView();

        EditText editText = findViewById(R.id.setSearch);
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

    // filter method is used to do a simple searching from the lstShop ArrayList
    private void filter(String text){
        ArrayList<ShopModel> filteredList = new ArrayList<>();

        for (ShopModel item : lstShop){
            if (item.getNameShop().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        shopAdapter.filterList(filteredList);
    }

    // createHotelList method is used to create an ArrayList containing data with six parameters on
    // every item
    private void createShopList(){
        lstShop = new ArrayList<>();
        lstShop.add(new ShopModel("Bakpiaku", "Jl. Raya Solo - Yogyakarta, Sleman, Yogyakarta",
                -7.7827781, 110.4307313, "4.3", R.drawable.bakpiaku));
        lstShop.add(new ShopModel("Bakpia Djava", "Jl. Laksda Adisucipto No.KM.8,3, Sleman, Yogyakarta",
                -7.783138, 110.4232598, "4.5", R.drawable.djava));
        lstShop.add(new ShopModel("Bakpia Pathuk 75", "Jl. Laksda Adisucipto No.KM 8 No.59, Sleman, Yogyakarta",
                -7.7830827, 110.4239958, "4.1", R.drawable.patuk75));
        lstShop.add(new ShopModel("Beringharjo Market", "Jl. Pabringan, Yogyakarta",
                -7.7991774, 110.3659436, "4.5", R.drawable.pasar_beringharjo));
        lstShop.add(new ShopModel("Bakpia Kukus Tugu", "Jl. Malioboro No.11, Yogyakarta",
                -7.7959742, 110.3630662, "4.5", R.drawable.kukustugu));
        lstShop.add(new ShopModel("Kenes Bakery & Resto", "Jl. Affandi No.15, Sleman, Yogyakarta",
                -7.7688288, 110.38862, "4.4", R.drawable.kenes));
        lstShop.add(new ShopModel("Amanda Brownies", "Jl. Laksda Adisucipto No.268, Sleman, Yogyakarta",
                -7.7829722, 110.3983137, "4.6", R.drawable.amanda));
        lstShop.add(new ShopModel("Bakpia Mutiara Jogja", "Jl. Dagen No.62, Yogyakarta",
                -7.7938051, 110.3608179, "4.4", R.drawable.mutiara));
        lstShop.add(new ShopModel("Bakpia Kurnia Sari", "Jl. Glagahsari No.91C, Yogyakarta",
                -7.80848, 110.385629, "4.3", R.drawable.kurnia));
        lstShop.add(new ShopModel("Bakpia Citra Premium", "Jl. Ngadisuryan No.4, Yogyakarta",
                -7.8114236, 110.3601152, "4.6", R.drawable.citra));
        lstShop.add(new ShopModel("Bakpia Pathok 25", "Jl. Bhayangkara Ng 1 No.1, Yogyakarta",
                -7.7968888, 110.3558348, "4.5", R.drawable.patok25));
        lstShop.add(new ShopModel("Monggo Chocolates", "Jl. Dalem KG III No.978, Yogyakarta",
                -7.8316897, 110.3972163, "4.5", R.drawable.monggo));
        lstShop.add(new ShopModel("Mirota Batik", "Jl. Jenderal Ahmad Yani No. 9, Yogyakarta",
                -7.7989203, 110.3622076, "4.5", R.drawable.mirota));
        lstShop.add(new ShopModel("Kerajinan Perak", "Jl. Kemasan Gang Sawo KG. II/801A, Yogyakarta",
                -7.8255811, 110.3976497, "4.3", R.drawable.perak));
        lstShop.add(new ShopModel("Jogja Scrummy", "Jl. Kaliurang KM. 5,5 No. 44, Sleman, Yogyakarta",
                -7.7583777, 110.3795913, "3.9", R.drawable.scrummy));
        lstShop.add(new ShopModel("Dagadu Jogja", "Jl. Alun-Alun Utara No.7, Yogyakarta",
                -7.8031354, 110.3634994, "4.4", R.drawable.dagadu));
    }

    // buildRecyclerView method is used prepare the RecyclerView, to display scrolling shop list
    // of elements
    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerviewMenuShop);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        shopAdapter = new ShopAdapter(this, lstShop);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(shopAdapter);
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
