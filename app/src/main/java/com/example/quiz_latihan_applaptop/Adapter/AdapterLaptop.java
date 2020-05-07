package com.example.quiz_latihan_applaptop.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.quiz_latihan_applaptop.Model.ModelLaptop;
import com.example.quiz_latihan_applaptop.R;

import java.util.ArrayList;

public class AdapterLaptop extends RecyclerView.Adapter<AdapterLaptop.MyHolder> {


    private ArrayList<ModelLaptop> list;
    private OnItemClickCallback onItemClickCallback;
    public interface OnItemClickCallback {
        void onItemClicked(ModelLaptop data);
    }
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public AdapterLaptop(ArrayList<ModelLaptop> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public AdapterLaptop.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_laptop, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterLaptop.MyHolder holder, int position) {


        holder.tvnamalaptop.setText(list.get(position).getNamaLaptop());
        //jika error menampilkan gambar tersebut
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.mipmap.ic_launcher);
        requestOptions.error(R.mipmap.ic_launcher);
        requestOptions.override(350,550);
        //menampilkan gambar dengan glide
        Glide.with(holder.itemView.getContext())
                //gambr error
                .setDefaultRequestOptions(requestOptions)
                //ge
                .load(list.get(position).getGambarLaptop())
                //.apply(new RequestOptions().override(350, 550))
                .into(holder.gambarlaptop);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fungsi ketika item di klik
                onItemClickCallback.onItemClicked(list.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        //variabel
        TextView tvnamalaptop;
        ImageView gambarlaptop;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            //inisialisasi
            tvnamalaptop = itemView.findViewById(R.id.tv_nama_laptop);
            gambarlaptop = itemView.findViewById(R.id.gambar_laptop);

        }
    }
}
