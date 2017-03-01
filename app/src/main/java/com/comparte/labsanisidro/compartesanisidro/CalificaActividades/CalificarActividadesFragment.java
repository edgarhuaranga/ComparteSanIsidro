package com.comparte.labsanisidro.compartesanisidro.CalificaActividades;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.comparte.labsanisidro.compartesanisidro.Model.Actividades;
import com.comparte.labsanisidro.compartesanisidro.R;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.util.ArrayList;
import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalificarActividadesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalificarActividadesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    GoogleSignInAccount account;

    public CalificarActividadesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalificarActividadesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalificarActividadesFragment newInstance(String param1, GoogleSignInAccount param2) {
        CalificarActividadesFragment fragment = new CalificarActividadesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putParcelable(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            account = getArguments().getParcelable(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calificar_actividades, container, false);
        RecyclerView recyclerViewCalificaActividades = (RecyclerView) view.findViewById(R.id.recycler_view_calificar);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerViewCalificaActividades.setLayoutManager(llm);

        ArrayList<Actividades> actividades = new ArrayList<>();
        actividades.add(new Actividades("e2", "cultura","Bicicleteada por ahi", 4, "27/12/92", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-0/s480x480/16996400_10154508248853160_633101615063230310_n.jpg?oh=cb4a95e900c40003480f16f06e25c605&oe=59337CE3"));
        actividades.add(new Actividades("e1", "cultura","Yoga en El Olivar", 4, "27/12/92", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/16832138_1253591128028481_8335769873075673821_n.png?oh=6987651decaca8042ea316a05bd33e63&oe=5939F219"));
        actividades.add(new Actividades("e3", "cultura","Partido Peru Colombia", 4, "27/12/92", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-0/s480x480/16996400_10154508248853160_633101615063230310_n.jpg?oh=cb4a95e900c40003480f16f06e25c605&oe=59337CE3"));
        actividades.add(new Actividades("e3", "cultura","Partido Peru Colombia", 4, "27/12/92", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-0/s480x480/16996400_10154508248853160_633101615063230310_n.jpg?oh=cb4a95e900c40003480f16f06e25c605&oe=59337CE3"));

        RecyclerCalificaActividadesAdapter adapter = new RecyclerCalificaActividadesAdapter(actividades, account);
        //recyclerViewCalificaActividades.addView(View.inflate(getContext(), R.layout.cardview_evento, (ViewGroup) view.getRootView()));
        recyclerViewCalificaActividades.setAdapter(adapter);

        return  view;

    }

}
