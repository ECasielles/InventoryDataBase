package com.example.usuario.inventorydatabase.ui.product;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.usuario.inventorydatabase.R;
import com.example.usuario.inventorydatabase.adapter.ProductAdapter;
import com.example.usuario.inventorydatabase.data.db.model.Product;
import com.example.usuario.inventorydatabase.data.db.repository.ProductRepository;

/**
 * Created by icenri on 2/1/18.
 */

public class ProductListFragment extends ListFragment {
    public static final String TAG = "ProductListFragment";
    private ProductAdapter adapter;
    private ProductListFragment.OnProductSelectedListener callback;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (OnProductSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity + " must implement OnProductSelectedListener interface");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new ProductAdapter(getActivity());
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_product, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setListAdapter(adapter);
        adapter.clear();
        adapter.addAll(ProductRepository.getInstance().getProducts());

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Parcelable parcel = (Parcelable) adapterView.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable(Product.TAG, parcel);
                callback.viewProduct(bundle);
            }
        });

    }

    public interface OnProductSelectedListener {
        void viewProduct(Bundle bundle);
    }

}
