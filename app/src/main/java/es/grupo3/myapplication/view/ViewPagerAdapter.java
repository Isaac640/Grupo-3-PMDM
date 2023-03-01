package es.grupo3.myapplication.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import es.grupo3.myapplication.view.FragmentAceptadas;
import es.grupo3.myapplication.view.FragmentGuardias;
import es.grupo3.myapplication.view.FragmentHistorial;

public class ViewPagerAdapter
        extends FragmentPagerAdapter {

    public ViewPagerAdapter(
            @NonNull FragmentManager fm)
    {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = null;
        if (position == 0)
            fragment = new FragmentGuardias();
        else if (position == 1)
            fragment = new FragmentAceptadas();
        else if (position == 2)
            fragment = new FragmentHistorial();

        return fragment;
    }

    @Override
    public int getCount()
    {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = null;
        if (position == 0)
            title = "Guardias";
        else if (position == 1)
            title = "Aceptadas";
        else if (position == 2)
            title = "Historial";
        return title;
    }
}