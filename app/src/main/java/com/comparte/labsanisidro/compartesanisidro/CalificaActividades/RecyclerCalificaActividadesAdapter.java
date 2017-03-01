package com.comparte.labsanisidro.compartesanisidro.CalificaActividades;

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
import com.comparte.labsanisidro.compartesanisidro.TopActividades.RecyclerActividadesAdapter;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by root on 27/02/17.
 */

public class RecyclerCalificaActividadesAdapter extends RecyclerView.Adapter<RecyclerCalificaActividadesAdapter.CalificarViewHolder> {
    ArrayList<Actividades> actividades;
    GoogleSignInAccount account;

    public RecyclerCalificaActividadesAdapter(ArrayList<Actividades> actividades, GoogleSignInAccount account){
        this.actividades = actividades;
        this.account = account;
    }

    @Override
    public CalificarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_califica_actividad, parent, false);
        CalificarViewHolder actividadViewHolder = new CalificarViewHolder(v);
        return actividadViewHolder;
    }

    @Override
    public void onBindViewHolder(CalificarViewHolder holder, int position) {
        Glide.with(holder.imageViewActividad.getContext())
                .load(actividades.get(position).getImageUrl().toString())
                .fitCenter()
                .into(holder.imageViewActividad);
        holder.textViewNombreActividad.setText(actividades.get(position).getNombre());

        Glide.with(holder.fotoPerfil.getContext())
                .load(account.getPhotoUrl())
                .fitCenter()
                .into(holder.fotoPerfil);
    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }


    public static class CalificarViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageViewActividad;
        TextView textViewNombreActividad;
        CircleImageView fotoPerfil;

        CalificarViewHolder (View itemView){
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview_calificar);
            imageViewActividad = (ImageView) itemView.findViewById(R.id.cardview_foto_actividad);
            textViewNombreActividad = (TextView) itemView.findViewById(R.id.cardview_evento_textview_nombre_actividad);
            fotoPerfil = (CircleImageView) itemView.findViewById(R.id.cardview_foto_perfil);
        }
    }
}
