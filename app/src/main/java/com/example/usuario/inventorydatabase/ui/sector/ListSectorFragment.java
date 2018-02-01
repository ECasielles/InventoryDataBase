package com.example.usuario.inventorydatabase.ui.sector;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.usuario.inventorydatabase.R;
import com.example.usuario.inventorydatabase.adapter.SectorAdapter;
import com.example.usuario.inventorydatabase.data.db.model.Sector;


//TODO: Implementar MVP
public class ListSectorFragment extends Fragment {

    public static final String TAG = "ListSectorFragment";
    private RecyclerView recyclerSector;
    private SectorAdapter sectorAdapter;
    private SectorListener listener;
    //private SectorAdapter.OnItemClickListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listsector, container, false);
        recyclerSector = view.findViewById(android.R.id.list);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerSector.setHasFixedSize(true);
        recyclerSector.setLayoutManager(new LinearLayoutManager(getContext()));

        listener = new SectorListener();

        if (savedInstanceState != null)
            sectorAdapter = new SectorAdapter(listener, savedInstanceState.getParcelableArrayList("sector"));
        else
            sectorAdapter = new SectorAdapter(listener);
        recyclerSector.setAdapter(sectorAdapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("sector", sectorAdapter.getModifiedSectors());
    }

    class SectorListener implements SectorAdapter.OnItemClickListener {
        @Override
        public void onItemClick(Sector sector) {
            Toast.makeText(getActivity(), "SectorItemClick: " + sector.getName(), Toast.LENGTH_SHORT).show();
        }
    }

}
