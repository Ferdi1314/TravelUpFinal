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
import android.widget.TextView;

import com.example.ferdinand.travelup.adapter.TopHotelAdapter;
import com.example.ferdinand.travelup.adapter.TopRestoAdapter;
import com.example.ferdinand.travelup.adapter.TopShopAdapter;
import com.example.ferdinand.travelup.model.HotelModel;
import com.example.ferdinand.travelup.model.RestoModel;
import com.example.ferdinand.travelup.model.ShopModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<HotelModel> lstHotel;
    private ArrayList<RestoModel> lstResto;
    private ArrayList<ShopModel> lstShop;
    private RecyclerView hotelRecyclerView, restoRecyclerView, shopRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private TopHotelAdapter hotelAdapter;
    private TopRestoAdapter restoAdapter;
    private TopShopAdapter shopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView hotelView = findViewById(R.id.view_hotel);
        TextView restaurantView = findViewById(R.id.view_restaurant);
        TextView shopView = findViewById(R.id.view_shop);
        ImageView hotelIcon = findViewById(R.id.imgHotels);
        ImageView restaurantIcon = findViewById(R.id.imgResto);
        ImageView shopIcon = findViewById(R.id.imgShops);
        hotelView.setOnClickListener(this);
        restaurantView.setOnClickListener(this);
        shopView.setOnClickListener(this);
        hotelIcon.setOnClickListener(this);
        restaurantIcon.setOnClickListener(this);
        shopIcon.setOnClickListener(this);

        createHotelList();
        buildHotelRecyclerView();
        filterRatedHotel();

        createRestoList();
        buildRestoRecyclerView();
        filterRatedResto();

        createShopList();
        buildShopRecyclerView();
        filterRatedShop();
    }

    // filterRatedHotel function is used to filter some items (hotels) from the list to get top rated hotels.
    // To filter, we used iteration and added it to a new list.
    private void filterRatedHotel(){
        ArrayList<HotelModel> filteredList = new ArrayList<>();

        for (HotelModel item : lstHotel){
            if (Double.parseDouble(item.getHotelReviews()) >= 4.5){
                filteredList.add(item);
            }
        }

        hotelAdapter.filterList(filteredList);
    }

    // filterRatedResto function is used to filter some items (restaurants) from the list to get top rated restaurants.
    // To filter, we used iteration and added it to a new list.
    private void filterRatedResto(){
        ArrayList<RestoModel> filteredList = new ArrayList<>();

        for (RestoModel item : lstResto){
            if (Double.parseDouble(item.getRestoReviews()) >= 4.5){
                filteredList.add(item);
            }
        }

        restoAdapter.filterList(filteredList);
    }

    // filterRatedShop function is used to filter some items (shops) from the list to get top rated shops.
    // To filter, we used iteration and added it to a new list.
    private void filterRatedShop(){
        ArrayList<ShopModel> filteredList = new ArrayList<>();

        for (ShopModel item : lstShop){
            if (Double.parseDouble(item.getShopReviews()) >= 4.5){
                filteredList.add(item);
            }
        }

        shopAdapter.filterList(filteredList);
    }

    // onClick method is an implementation of the OnClickListener interface, and therefore it applies
    // the polymorphism concept.
    public void onClick(View v) {
        if (v.getId() == R.id.view_hotel || v.getId() == R.id.imgHotels) {
            Intent i = new Intent(this, HotelActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.view_restaurant || v.getId() == R.id.imgResto) {
            Intent i = new Intent(this, RestaurantActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.view_shop || v.getId() == R.id.imgShops) {
            Intent i = new Intent(this, ShopActivity.class);
            startActivity(i);
        }
    }

    // createRestoList function is used to create an ArrayList containing data with six parameters on
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

    // createShopList function is used to create an ArrayList containing data with six parameters on
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

    // createHotelList function is used to create an ArrayList containing data with six parameters on
    // every item
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

    // buildHotelRecyclerView method is used to display scrolling hotel list of elements. The list itself
    // is the list that has been created using the filterRatedHotel method. This method applies the
    // encapsulation concept.
    private void buildHotelRecyclerView() {
        hotelRecyclerView = findViewById(R.id.recyclerviewTopHotel);
        hotelRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        hotelAdapter = new TopHotelAdapter(this, lstHotel);

        hotelRecyclerView.setLayoutManager(layoutManager);
        hotelRecyclerView.setAdapter(hotelAdapter);
    }

    // buildRestoRecyclerView method is used to display scrolling restaurants list of elements.
    // The list itself is the list that has been created using the filterRatedResto method. This method
    // applies the encapsulation concept.
    private void buildRestoRecyclerView() {
        restoRecyclerView = findViewById(R.id.recyclerviewTopResto);
        restoRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        restoAdapter = new TopRestoAdapter(this, lstResto);

        restoRecyclerView.setLayoutManager(layoutManager);
        restoRecyclerView.setAdapter(restoAdapter);
    }

    // buildShopRecyclerView method is used to display scrolling shop list of elements. The list itself
    // is the list that has been created using the filterRatedShop method. This method applies the
    // encapsulation concept.
    private void buildShopRecyclerView() {
        shopRecyclerView = findViewById(R.id.recyclerviewTopShop);
        shopRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        shopAdapter = new TopShopAdapter(this, lstShop);

        shopRecyclerView.setLayoutManager(layoutManager);
        shopRecyclerView.setAdapter(shopAdapter);
    }
}
