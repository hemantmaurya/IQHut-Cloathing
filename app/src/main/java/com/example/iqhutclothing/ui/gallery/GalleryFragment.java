package com.example.iqhutclothing.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.iqhutclothing.APIs_Online;
import com.example.iqhutclothing.AdapterPaymentOrderList;
import com.example.iqhutclothing.ModelSalesPaymentOrderList;
import com.example.iqhutclothing.ModelSalesPaymentOrderListBack;
import com.example.iqhutclothing.PaymentList;
import com.example.iqhutclothing.R;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;



    RecyclerView recyclerView;
    LinearLayoutManager manager;
    AdapterPaymentOrderList adapter;

    List<ModelSalesPaymentOrderListBack> itemList = new ArrayList<>(  );
    Boolean isScrolling = false;
    int currentItmes, totalItems, scrollOutItems;
    ArrayList list;
    ProgressBar progressBar;
    int nextPage = 1;

    int done = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of( this ).get( GalleryViewModel.class );
        View root = inflater.inflate( R.layout.fragment_gallery, container, false );

        recyclerView = (RecyclerView) root.findViewById( R.id.recyclerView );
        manager = new LinearLayoutManager( getContext() );
        adapter = new AdapterPaymentOrderList( getContext(), itemList );
        recyclerView.setLayoutManager( manager );
        recyclerView.setAdapter( adapter );

        recyclerView.addOnScrollListener( new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged( recyclerView, newState );
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled( recyclerView, dx, dy );
                currentItmes = manager.getChildCount();
                totalItems = manager.getItemCount();
                scrollOutItems = manager.findFirstVisibleItemPosition();

                if(isScrolling && (currentItmes + scrollOutItems == totalItems))
                {
                    isScrolling = false;
                    if(done == 0)
                    {
                        getData();
                    }else{
                        Toast.makeText( getContext(), "Data Completed", Toast.LENGTH_SHORT ).show();
                    }

                }
            }
        } );

        if(done == 0)
        {
            getData();
        }else{
            Toast.makeText( getContext(), "Data Completed", Toast.LENGTH_SHORT ).show();
        }


        return root;
    }

    private void getData()
    {
        Call<List<ModelSalesPaymentOrderList>> complaintListCall = APIs_Online.getPaymentOrderList().paymentList(  nextPage );
        complaintListCall.enqueue( new Callback<List<ModelSalesPaymentOrderList>>() {
            @Override
            public void onResponse(Call<List<ModelSalesPaymentOrderList>> call, Response<List<ModelSalesPaymentOrderList>> response) {
                Toast.makeText( getContext(), "Success", Toast.LENGTH_SHORT ).show();
//                Log.w("2.0 getFeed Hemant >> ",new GsonBuilder().setPrettyPrinting().create().toJson(response));
                List<ModelSalesPaymentOrderListBack> list =  response.body().get(0).getPaymentList().getData();
                String nextPageUrl = response.body().get(0).getPaymentList().getNextPageUrl();
                Log.i(nextPageUrl.toString(), response.body().toString());
                Log.i(nextPageUrl.toString(), response.body().toString());
                if(nextPageUrl==null || nextPageUrl.isEmpty()){
                    done = 1;
                }else{
                    String[] splitNextPageUrl = nextPageUrl.split( "=" );
                    String nextPageX = splitNextPageUrl[1].toString();
                    nextPage = Integer.parseInt(nextPageX);
                }

                itemList.addAll( list );
                adapter.notifyDataSetChanged();
//                Toast.makeText( getContext(), nextPage, Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onFailure(Call<List<ModelSalesPaymentOrderList>> call, Throwable t) {
                Toast.makeText( getContext(), "Error", Toast.LENGTH_SHORT ).show();
            }
        } );
    }
}