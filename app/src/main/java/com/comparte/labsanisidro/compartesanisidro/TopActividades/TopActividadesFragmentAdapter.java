package com.comparte.labsanisidro.compartesanisidro.TopActividades;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by root on 09/02/17.
 */

public class TopActividadesFragmentAdapter extends FragmentPagerAdapter {
    final int NUMERO_PAGINAS=3;
    public String titulosTabs[] = new String[]{"Cultura","Talleres", "Otros"};

    public TopActividadesFragmentAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        ArrayList<Fragment> paginas = new ArrayList<>();
        paginas.add(ActividadesFragment.newInstance("a"));
        paginas.add(ActividadesFragment.newInstance("a"));
        paginas.add(ActividadesFragment.newInstance("a"));
        return paginas.get(position);


    }

    @Override
    public int getCount() {
        return NUMERO_PAGINAS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulosTabs[position];
    }
}
