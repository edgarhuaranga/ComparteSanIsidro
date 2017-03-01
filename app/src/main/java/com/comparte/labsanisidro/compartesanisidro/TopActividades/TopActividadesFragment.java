package com.comparte.labsanisidro.compartesanisidro.TopActividades;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.comparte.labsanisidro.compartesanisidro.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopActividadesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopActividadesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public TopActividadesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TopActividadesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TopActividadesFragment newInstance(String param1, String param2) {
        TopActividadesFragment fragment = new TopActividadesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_actividades, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager_top_actividades);
        viewPager.setAdapter(new TopActividadesFragmentAdapter(getChildFragmentManager()));
        
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.datos_tabs);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

}
