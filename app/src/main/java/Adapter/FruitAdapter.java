package Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ts_yfzx_cqe.recyclerviewtest.R;

import java.util.ArrayList;
import java.util.List;

import bean.Fruit;

/**
 * Created by TS-YFZX-CQE on 2017/6/22.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{

    private List<Fruit> mList ;

    public FruitAdapter(List<Fruit> mList) {
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        //引入子item的布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        //实例化ViewHolder
        final ViewHolder viewHolder = new ViewHolder(view);
        //设置各项子view的具体点击事件
        viewHolder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mList.get(position);
                Toast.makeText(v.getContext(),"you clicked view " + fruit.getFruitName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mList.get(position);
                Toast.makeText(v.getContext(),"you clicked image " + fruit.getFruitName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //给子项的各个控件赋值
        Fruit fruit = mList.get(position);
        holder.fruitImage.setImageResource(fruit.getFruitImageId());
        holder.fruitName.setText(fruit.getFruitName());
    }

    @Override
    public int getItemCount() {
        return mList.size();//recyclerView的长度
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        public ViewHolder(View itemView) {//实例化子项的各个子控件
            super(itemView);
            fruitView = itemView;//子项的最外层布局
            fruitImage = (ImageView) itemView.findViewById(R.id.fruit_imageview);
            fruitName = (TextView) itemView.findViewById(R.id.fruit_tv);
        }
    }
}
