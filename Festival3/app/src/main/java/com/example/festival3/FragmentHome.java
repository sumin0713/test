package com.example.festival3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentHome extends Fragment {
    ViewFlipper viewflipper;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, null);
        int images[] = {R.drawable.image1, R.drawable.image2};
        viewflipper = view.findViewById(R.id.flipper);

        for (int i = 0; i < images.length; i++){
            flipperImages(images[i]);
        }

        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    public void flipperImages(int image){
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);

        viewflipper.addView(imageView);
        viewflipper.setFlipInterval(4000);
        viewflipper.setAutoStart(true);

        viewflipper.setInAnimation(getActivity(), android.R.anim.slide_in_left);
        viewflipper.setOutAnimation(getActivity(), android.R.anim.slide_out_right);
    }
}
