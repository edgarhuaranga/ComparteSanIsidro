package com.comparte.labsanisidro.compartesanisidro.Perfil;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.comparte.labsanisidro.compartesanisidro.Model.Actividades;
import com.comparte.labsanisidro.compartesanisidro.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by root on 28/02/17.
 */

public class RecyclerActividadesAsistidasAdapter extends RecyclerView.Adapter<RecyclerActividadesAsistidasAdapter.ActividadesAsistidasViewHolder> {
    ArrayList<Actividades> actividades;

    public RecyclerActividadesAsistidasAdapter(ArrayList<Actividades> actividades){
        this.actividades = actividades;
    }


    @Override
    public RecyclerActividadesAsistidasAdapter.ActividadesAsistidasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_actividades_asistidas, parent, false);
        ActividadesAsistidasViewHolder actividadesAsistidasViewHolder = new ActividadesAsistidasViewHolder(view);
        return  actividadesAsistidasViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerActividadesAsistidasAdapter.ActividadesAsistidasViewHolder holder, int position) {
        Glide.with(holder.imageViewActividad.getContext())
                .load(actividades.get(position).getImageUrl().toString())
                .fitCenter()
                .into(holder.imageViewActividad);
        holder.textViewNombreActividad.setText(actividades.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    public static class ActividadesAsistidasViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageViewActividad;
        TextView textViewNombreActividad;

        ActividadesAsistidasViewHolder (View itemView){
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view_asistida);
            imageViewActividad = (ImageView) itemView.findViewById(R.id.cardview_actividad_asistido_imagen);
            textViewNombreActividad = (TextView) itemView.findViewById(R.id.cardview_actividad_asistido_titulo);
        }
    }
}
