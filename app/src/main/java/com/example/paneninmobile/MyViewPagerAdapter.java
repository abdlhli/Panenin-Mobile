package com.example.paneninmobile;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.paneninmobile.fragments.BelumBayarFragment;
import com.example.paneninmobile.fragments.DiBatalkanFragment;
import com.example.paneninmobile.fragments.DiKemasFragment;
import com.example.paneninmobile.fragments.DiKirimFragment;
import com.example.paneninmobile.fragments.PengembalianFragment;
import com.example.paneninmobile.fragments.SelesaiFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new BelumBayarFragment();
            case 1:
                return new DiKemasFragment();
            case 2:
                return new DiKirimFragment();
            case 3:
                return new SelesaiFragment();
            case 4:
                return new DiBatalkanFragment();
            default:
                return new PengembalianFragment();
        }
    }

    @Override
    public int getItemCount() {

        return 6;
    }
}
