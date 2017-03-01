package com.comparte.labsanisidro.compartesanisidro.Perfil;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.comparte.labsanisidro.compartesanisidro.Model.Actividades;
import com.comparte.labsanisidro.compartesanisidro.R;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    GoogleSignInAccount account;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param account Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, GoogleSignInAccount account) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putParcelable(ARG_PARAM2, account);
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
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        TextView textViewNombre = (TextView) view.findViewById(R.id.textview_perfil_nombre);
        TextView textViewEmail = (TextView) view.findViewById(R.id.textview_perfil_correo);
        CircleImageView imageViewPerfil = (CircleImageView) view.findViewById(R.id.imageview_perfil);
        Glide.with(this)
                .load(account.getPhotoUrl().toString())
                .fitCenter()
                .centerCrop()
                .into(imageViewPerfil);
        textViewNombre.setText(account.getDisplayName());
        textViewEmail.setText(account.getEmail());

        RecyclerView recyclerViewActividadesAsistidas = (RecyclerView) view.findViewById(R.id.recycler_view_actividades_asistidas);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewActividadesAsistidas.setLayoutManager(mLayoutManager);

        ArrayList<Actividades> actividades = new ArrayList<>();
        actividades.add(new Actividades("e2", "cultura","Bicicleteada por ahi", 4, "27/12/92", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-0/s480x480/16996400_10154508248853160_633101615063230310_n.jpg?oh=cb4a95e900c40003480f16f06e25c605&oe=59337CE3"));
        actividades.add(new Actividades("e1", "cultura","Yoga en El Olivar", 4, "27/12/92", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-9/16832138_1253591128028481_8335769873075673821_n.png?oh=6987651decaca8042ea316a05bd33e63&oe=5939F219"));
        actividades.add(new Actividades("e3", "cultura","Partido Peru Colombia", 4, "27/12/92", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-0/s480x480/16996400_10154508248853160_633101615063230310_n.jpg?oh=cb4a95e900c40003480f16f06e25c605&oe=59337CE3"));
        actividades.add(new Actividades("e3", "cultura","Partido Peru Colombia", 4, "27/12/92", "https://scontent-mia1-1.xx.fbcdn.net/v/t1.0-0/s480x480/16996400_10154508248853160_633101615063230310_n.jpg?oh=cb4a95e900c40003480f16f06e25c605&oe=59337CE3"));

        RecyclerView.Adapter adapter = new RecyclerActividadesAsistidasAdapter(actividades);
        recyclerViewActividadesAsistidas.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerViewActividadesAsistidas.setItemAnimator(new DefaultItemAnimator());
        recyclerViewActividadesAsistidas.setAdapter(adapter);
        return view;
    }


    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
