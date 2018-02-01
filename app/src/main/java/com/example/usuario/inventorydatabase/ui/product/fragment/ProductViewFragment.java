package com.example.usuario.inventorydatabase.ui.product.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.usuario.inventorydatabase.R;
import com.example.usuario.inventorydatabase.data.db.model.Category;
import com.example.usuario.inventorydatabase.data.db.model.Product;
import com.example.usuario.inventorydatabase.data.db.model.ProductClass;
import com.example.usuario.inventorydatabase.ui.product.contract.ProductViewContract;
import com.example.usuario.inventorydatabase.ui.product.presenter.ProductViewPresenter;

/**
 * Created by icenri on 1/31/18.
 */

public class ProductViewFragment extends Fragment implements ProductViewContract.View {
    public static final String TAG = "ProductViewFragment";

    EditText edtShortname, edtSerial, edtVendor, edtModelcode, edtDescription, edtPrice, edtDatePurchase, edtUrl, edtNotes;
    TextView txvCategory, spnSubcategory, txvProductClass;
    int dependencyId;
    int sectorID;
    int quantity;
    int bitmap;
    String imageName;
    private ProductViewContract.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setPresenter(new ProductViewPresenter(this));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_product, container, false);
        edtShortname = view.findViewById(R.id.edtProductName);
        edtSerial = view.findViewById(R.id.edtSerial);
        edtVendor = view.findViewById(R.id.edtVendor);
        edtModelcode = view.findViewById(R.id.edtModelCode);
        edtDescription = view.findViewById(R.id.edtDescription);
        edtPrice = view.findViewById(R.id.edtPrice);
        edtDatePurchase = view.findViewById(R.id.edtDatePurchase);
        edtUrl = view.findViewById(R.id.edtUrl);
        edtNotes = view.findViewById(R.id.edtNotes);
        txvCategory = view.findViewById(R.id.txvCategory);
        //spnSubcategory = view.findViewById(R.id.spnSubCategory);
        txvProductClass = view.findViewById(R.id.txvProductClass);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        if (getArguments() != null) {
            Product product = getArguments().getParcelable(Product.TAG);
            edtShortname.setText(product.getShortname());
            edtSerial.setText(product.getSerial());
            edtVendor.setText(product.getVendor());
            edtModelcode.setText(product.getModelCode());
            edtDescription.setText(product.getDescription());
            edtPrice.setText(String.valueOf(product.getValue()));
            edtDatePurchase.setText(product.getDatePurchase());
            edtUrl.setText(product.getUrl());
            edtNotes.setText(product.getNotes());

            //spnSubcategory.setSelection(product().getSubcategory());
            presenter.loadCategories(product.getCategory());
            presenter.loadProductClasses(product.getProductClass());
        }

    }

    @Override
    public void setPresenter(ProductViewContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void saveCategories(Category category) {
        txvCategory.setText(category.getShortname());
    }

    @Override
    public void saveProductClasses(ProductClass productClass) {
        txvProductClass.setText(productClass.getDescription());
    }


}