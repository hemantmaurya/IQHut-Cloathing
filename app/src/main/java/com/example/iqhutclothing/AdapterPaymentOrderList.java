package com.example.iqhutclothing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterPaymentOrderList extends RecyclerView.Adapter<AdapterPaymentOrderList.Vholder> {

    private Context context;
    private List<ModelSalesPaymentOrderListBack> items;

    public AdapterPaymentOrderList(Context context, List<ModelSalesPaymentOrderListBack> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public Vholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( context );
        View view = inflater.inflate( R.layout.itempaymentorderlist, parent, false );
        return new Vholder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull Vholder holder, int position) {
        ModelSalesPaymentOrderListBack item = items.get(position);
        holder.total.setText( " ₹ "+String.valueOf( item.getAmount() ) );
        holder.date.setText( String.valueOf( item.getPaymentDate() ) );
        holder.name.setText( String.valueOf( item.getName() ) );
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Vholder extends RecyclerView.ViewHolder {
        TextView total, date, name;
        public Vholder(@NonNull View itemView) {
            super( itemView );
                name = (TextView) itemView.findViewById( R.id.name );
                date = (TextView) itemView.findViewById( R.id.date );
                total = (TextView) itemView.findViewById( R.id.total );
//            txtItem = (TextView) itemView.findViewById( R.id.text_gallery );
        }
    }
}
