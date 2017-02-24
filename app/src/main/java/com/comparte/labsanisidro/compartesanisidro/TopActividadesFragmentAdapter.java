package com.comparte.labsanisidro.compartesanisidro;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

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
        paginas.add(BlankFragment.newInstance("a","b"));
        paginas.add(BlankFragment.newInstance("a","b"));
        paginas.add(BlankFragment.newInstance("a","b"));
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
