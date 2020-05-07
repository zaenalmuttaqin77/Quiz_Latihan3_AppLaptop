package com.example.quiz_latihan_applaptop.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz_latihan_applaptop.Model.DataLaptop;
import com.example.quiz_latihan_applaptop.Model.ModelLaptop;
import com.example.quiz_latihan_applaptop.R;

import com.example.quiz_latihan_applaptop.Adapter.AdapterLaptop;
import com.example.quiz_latihan_applaptop.R;

import com.example.quiz_latihan_applaptop.ui.Detail.DetailActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView rvlaptop;
    private ArrayList<ModelLaptop> list = new ArrayList<>();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        rvlaptop = root.findViewById(R.id.rv_latop);

        rvlaptop.setLayoutManager(new GridLayoutManager(getActivity(),2));
        list.addAll(DataLaptop.getlistResep());

        AdapterLaptop adapterLaptop = new AdapterLaptop(list);
        //set adapter pada variabel recyclerview

        rvlaptop.setAdapter(adapterLaptop);
        adapterLaptop.notifyDataSetChanged();


        adapterLaptop.setOnItemClickCallback(new AdapterLaptop.OnItemClickCallback() {
            @Override
            public void onItemClicked(ModelLaptop data) {

                // LOgic UNtuk Berpindah dan mengirim data ke detail activity

                Intent kirimData = new Intent(getActivity(), DetailActivity.class);

                kirimData.putExtra("NAMA",data.getNamaLaptop());
                kirimData.putExtra("GAMBAR", data.getGambarLaptop());
                kirimData.putExtra("DETAIL", data.getDetaiLaptop());

                startActivity(kirimData);

            }
        });

        return root;
    }
}
