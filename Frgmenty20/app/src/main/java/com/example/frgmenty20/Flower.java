package com.example.frgmenty20;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Flower#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Flower extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Flower() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Flower.
     */
    // TODO: Rename and change types and number of parameters
    public static Flower newInstance(String param1, String param2) {
        Flower fragment = new Flower();
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
        View view = inflater.inflate(R.layout.fragment_flower, container, false);
        ImageView flowerImageView = view.findViewById(R.id.flowerImageView);

        DataViewModel dataVM = new ViewModelProvider(requireActivity()).get(DataViewModel.class) ;
        dataVM.getSharedData()
                .observe(getViewLifecycleOwner(), s -> {
                    String assetPath = s;
                    try {
                        flowerImageView.setImageBitmap(BitmapFactory.decodeStream(getContext().getAssets().open(assetPath)));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        return view;
    }
}