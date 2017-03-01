package com.comparte.labsanisidro.compartesanisidro.TopActividades;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.comparte.labsanisidro.compartesanisidro.Model.Actividades;
import com.comparte.labsanisidro.compartesanisidro.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActividadesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActividadesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "topico";

    // TODO: Rename and change types of parameters
    private String topico;


    public ActividadesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment ActividadesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActividadesFragment newInstance(String param1) {
        ActividadesFragment fragment = new ActividadesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            topico = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_actividades, container, false);
        RecyclerView recyclerViewActividades = (RecyclerView) view.findViewById(R.id.recycler_view_actividades);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerViewActividades.setLayoutManager(llm);

        ArrayList<Actividades> actividades = new ArrayList<>();
        actividades.add(new Actividades("e2", "cultura","Bicicleteada por ahi", 4, "27/12/92", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-0/s480x480/16996400_10154508248853160_633101615063230310_n.jpg?oh=cb4a95e900c40003480f16f06e25c605&oe=59337CE3"));
        actividades.add(new Actividades("e1", "cultura","Yoga en El Olivar", 4, "27/12/92", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/16832138_1253591128028481_8335769873075673821_n.png?oh=6987651decaca8042ea316a05bd33e63&oe=5939F219"));
        actividades.add(new Actividades("e3", "cultura","Partido Peru Colombia", 4, "27/12/92", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-0/s480x480/16996400_10154508248853160_633101615063230310_n.jpg?oh=cb4a95e900c40003480f16f06e25c605&oe=59337CE3"));
        RecyclerActividadesAdapter recyclerActividadesAdapter = new RecyclerActividadesAdapter(actividades);

        recyclerViewActividades.setAdapter(recyclerActividadesAdapter);
        return view;
    }

}
