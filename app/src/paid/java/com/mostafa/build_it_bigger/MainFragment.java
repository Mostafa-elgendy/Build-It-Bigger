package com.mostafa.build_it_bigger;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mostafa.jokeviewer.JokeViewer;


public class MainFragment extends Fragment implements AsyncResponse{
String joke;
    private ProgressDialog dialog;
    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_main, container, false);
        Button display= (Button) view.findViewById(R.id.display);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchJoke();
            }
        });
        return  view;

    }


    private void fetchJoke() {
        dialog = new ProgressDialog(getContext());
        dialog.setMessage(getResources().getString(R.string.progress_text));
        dialog.show();
        EndpointsAsyncTask asyncTask=new EndpointsAsyncTask();
        asyncTask.delegate = this;
        asyncTask.execute();
    }

    @Override
    public void processFinish(String output) {
        joke=output;
        dialog.dismiss();
        Intent intent = JokeViewer.makeIntent(getActivity(), joke);
        startActivity(intent);

    }

}
