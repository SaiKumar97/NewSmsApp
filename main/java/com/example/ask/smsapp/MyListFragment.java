package com.example.ask.smsapp;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by ask on 28/10/16.
 */

public class MyListFragment extends ListFragment implements AdapterView.OnItemClickListener{
    public final static String EXTRA_MESSAGE = "com.example.simpllistfragment.MESSAGE";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Fields, android.R.layout.simple_expandable_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if ( position == 0 ) {
            Intent intent = new Intent(this.getActivity(), CreateSmsActivity.class);
            startActivity(intent);
        } else if(position == 1) {
            Intent intent = new Intent(this.getActivity(), FragmentActivity.class);
            intent.putExtra( EXTRA_MESSAGE ,(String) getListAdapter().getItem(position));
            startActivity(intent);
        }
//        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }
}
