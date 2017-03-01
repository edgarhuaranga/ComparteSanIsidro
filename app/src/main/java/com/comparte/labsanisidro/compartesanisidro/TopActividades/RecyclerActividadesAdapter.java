package com.comparte.labsanisidro.compartesanisidro.TopActividades;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.comparte.labsanisidro.compartesanisidro.Model.Actividades;
import com.comparte.labsanisidro.compartesanisidro.R;

import java.util.ArrayList;

/**
 * Created by root on 23/02/17.
 */

public class RecyclerActividadesAdapter extends RecyclerView.Adapter<RecyclerActividadesAdapter.ActividadViewHolder>{

    ArrayList<Actividades> actividades;

    public RecyclerActividadesAdapter(ArrayList<Actividades> actividades)  {
        this.actividades = actividades;
    }

    @Override
    public ActividadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_evento, parent, false);
        ActividadViewHolder actividadViewHolder = new ActividadViewHolder(v);
        return actividadViewHolder;
    }

    @Override
    public void onBindViewHolder(ActividadViewHolder holder, int position) {
        Glide.with(holder.imageViewActividad.getContext())
                .load(actividades.get(position).getImageUrl().toString())
                .fitCenter()
                .into(holder.imageViewActividad);
        holder.textViewNombreActividad.setText(actividades.get(position).getNombre());
        holder.ratingBarActividad.setRating(actividades.get(position).getPuntuacion());
        holder.textViewFechaActividad.setText(actividades.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    public static class ActividadViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageViewActividad;
        TextView textViewNombreActividad;
        RatingBar ratingBarActividad;
        TextView textViewFechaActividad;

        ActividadViewHolder (View itemView){
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview_evento);
            imageViewActividad = (ImageView) itemView.findViewById(R.id.cardview_imagen_evento);
            textViewNombreActividad = (TextView) itemView.findViewById(R.id.cardview_evento_textview_nombre_actividad);
            ratingBarActividad = (RatingBar) itemView.findViewById(R.id.cardview_evento_rating);
            textViewFechaActividad = (TextView) itemView.findViewById(R.id.cardview_evento_textview_fecha);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
