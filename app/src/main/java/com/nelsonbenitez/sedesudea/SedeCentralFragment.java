package com.nelsonbenitez.sedesudea;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class SedeCentralFragment  extends DialogFragment{

    public static final String ARGUMENTO_TITLE="TITLE";
    public static final String ARGUMENTO_SNIPPET = "FULL SNIFFET";


    private String titulo, fullSnippet;

    public static SedeCentralFragment newInstance(String titulo, String fullSnippet) {
        SedeCentralFragment fragment = new SedeCentralFragment();
        Bundle b = new Bundle();
        b.putString(ARGUMENTO_TITLE,titulo);
        b.putString(ARGUMENTO_SNIPPET,fullSnippet);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();

        titulo= args.getString(ARGUMENTO_TITLE);
        fullSnippet = args.getString(ARGUMENTO_SNIPPET);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle(titulo)
                .setMessage(fullSnippet)
                .create();
        return dialog;
    }
}
