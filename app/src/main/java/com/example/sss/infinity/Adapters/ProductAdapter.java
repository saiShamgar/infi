package com.example.sss.infinity.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sss.infinity.R;
import com.example.sss.infinity.models.SubCategory;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final SubCategory mDataSet;
    private Context context;

    public ProductAdapter(SubCategory mDataSet, Context context) {
        this.mDataSet = mDataSet;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
//        checkConnection = new CheckConnection(context);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.description.setText(mDataSet.getSubCategoryObjects().get(position).getProductName());
        holder.priceOriginal.setText("Rs."+mDataSet.getSubCategoryObjects().get(position).getProductPrice().toString());
        if(mDataSet.getSubCategoryObjects().get(position).getProductDiscountPrice() > 0){
            holder.discountPrice.setText("Rs."+mDataSet.getSubCategoryObjects().get(position).getProductDiscountPrice().toString());
        }else
            holder.discountPrice.setVisibility(View.INVISIBLE);
        holder.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("increment", "checked");
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataSet.getSubCategoryObjects().size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        private TextView description,priceOriginal,discountPrice,offerPercentage,quantity;
        private ImageView imageView;
        Button increment, decrement;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.product_name);
            priceOriginal = itemView.findViewById(R.id.price_original);
            discountPrice = itemView.findViewById(R.id.price_discount);
            offerPercentage = itemView.findViewById(R.id.price_discount_percentage);
            quantity = itemView.findViewById(R.id.quantity);

            imageView = itemView.findViewById(R.id.imageView);

            increment = itemView.findViewById(R.id.increment);
            decrement = itemView.findViewById(R.id.decrement);
        }
    }
}
