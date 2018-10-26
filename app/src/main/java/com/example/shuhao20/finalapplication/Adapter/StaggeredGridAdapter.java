package com.example.shuhao20.finalapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shuhao20.finalapplication.R;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {
    private Context mContext;
    private OnItemClickListener mListener;
    //for different activities using this adapter
    private int mDivider;

    //Constructor
    public StaggeredGridAdapter(Context context, OnItemClickListener listener, int divider) {
        this.mContext = context;
        this.mListener = listener;
        this.mDivider = divider;
    }

    @NonNull
    @Override
    //Set Layout File
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_grid_recyclerview_item, viewGroup, false));
    }

    @Override
    //Set Views and Listener
    public void onBindViewHolder(StaggeredGridAdapter.LinearViewHolder holder, final int position) {
        //for MainActivity
        if (mDivider == 1) {
            if (position == 0) {
                holder.imageView.setImageResource(R.mipmap.aa);
                holder.mTv_Chapter.setText("Chapter 1");
                holder.mTv_Chapter_Name.setText("Java Overview");
            } else if (position == 1) {
                holder.imageView.setImageResource(R.mipmap.configuration_3);
                holder.mTv_Chapter.setText("Chapter 2");
                holder.mTv_Chapter_Name.setText("Setting Java Environment");
            } else if (position == 2) {
                holder.imageView.setImageResource(R.mipmap.gg);
                holder.mTv_Chapter.setText("Chapter 3");
                holder.mTv_Chapter_Name.setText("Basic Java Syntax");
            } else if (position == 3) {
                holder.imageView.setImageResource(R.mipmap.dd);
                holder.mTv_Chapter.setText("Chapter 4");
                holder.mTv_Chapter_Name.setText("Variable & Data Type");
            } else if (position == 4) {
                holder.imageView.setImageResource(R.mipmap.ee);
                holder.mTv_Chapter.setText("Chapter 5");
                holder.mTv_Chapter_Name.setText("Arrays");
            } else if (position == 5) {
                holder.imageView.setImageResource(R.mipmap.ff);
                holder.mTv_Chapter.setText("Chapter 6");
                holder.mTv_Chapter_Name.setText("Control Statements");
            } else if (position == 6) {
                holder.imageView.setImageResource(R.mipmap.method);
                holder.mTv_Chapter.setText("Chapter 7");
                holder.mTv_Chapter_Name.setText("Methods");
            } else if (position == 7) {
                holder.imageView.setImageResource(R.mipmap.string);
                holder.mTv_Chapter.setText("Chapter 8");
                holder.mTv_Chapter_Name.setText("Strings");
            } else if (position == 8) {
                holder.imageView.setImageResource(R.mipmap.javaoop);
                holder.mTv_Chapter.setText("Chapter 9");
                holder.mTv_Chapter_Name.setText("Java OOP");
            } else if (position == 9) {
                holder.imageView.setImageResource(R.mipmap.cc);
                holder.mTv_Chapter.setText("Chapter 10");
                holder.mTv_Chapter_Name.setText("Constructors");
            } else if (position == 10) {
                holder.imageView.setImageResource(R.mipmap.ii);
                holder.mTv_Chapter.setText("Chapter 11");
                holder.mTv_Chapter_Name.setText("4 pillars");
            } else if (position == 11) {
                holder.imageView.setImageResource(R.mipmap.bb);
                holder.mTv_Chapter.setText("Chapter 12");
                holder.mTv_Chapter_Name.setText("Abstraction");
            } else if (position == 12) {
                holder.imageView.setImageResource(R.mipmap.jj);
                holder.mTv_Chapter.setText("Chapter 13");
                holder.mTv_Chapter_Name.setText("Encapsulation");
            } else if (position == 13) {
                holder.imageView.setImageResource(R.mipmap.kk);
                holder.mTv_Chapter.setText("Chapter 14");
                holder.mTv_Chapter_Name.setText("Inheritance");
            } else if (position == 14) {
                holder.imageView.setImageResource(R.mipmap.ll);
                holder.mTv_Chapter.setText("Chapter 15");
                holder.mTv_Chapter_Name.setText("Polymorphism");
            } else if (position == 15) {
                holder.imageView.setImageResource(R.mipmap.mm);
                holder.mTv_Chapter.setText("Chapter 16");
                holder.mTv_Chapter_Name.setText("Java Exception Handling");
            }
        } else if (mDivider == 0) {
            //for FirstActivity
            if (position == 0) {
                holder.imageView.setImageResource(R.mipmap.book_image);
                holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                holder.mTv_Menu.setText("Chapter Learning");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 1) {
                holder.imageView.setImageResource(R.mipmap.vt_image);
                holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                holder.mTv_Menu.setText("Video Tutorial");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 2) {
                holder.imageView.setImageResource(R.mipmap.quiz_image);
                holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                holder.mTv_Menu.setText("Quiz");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 3) {
                holder.imageView.setImageResource(R.mipmap.me_image);
                holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                holder.mTv_Menu.setText("My Profile");
                holder.mTv_Chapter_Name.setTextSize(0);
            }
        } else if (mDivider == 2) {
            //for SelectActivity
            if (position == 0) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.aa);
                holder.mTv_Chapter.setText("Chapter 1");
                holder.mTv_Chapter_Name.setText("Java Overview");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 1) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.secondimage);
                holder.mTv_Chapter.setText("Chapter 2");
                holder.mTv_Chapter_Name.setText("Setting Java Environment");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 2) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.third);
                holder.mTv_Chapter.setText("Chapter 3");
                holder.mTv_Chapter_Name.setText("Basic Java Syntax");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 3) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.dd);
                holder.mTv_Chapter.setText("Chapter 4");
                holder.mTv_Chapter_Name.setText("Variable & Data Type");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 4) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.ee);
                holder.mTv_Chapter.setText("Chapter 5");
                holder.mTv_Chapter_Name.setText("Arrays");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 5) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.ff);
                holder.mTv_Chapter.setText("Chapter 6");
                holder.mTv_Chapter_Name.setText("Control Statements");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 6) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.seventh);
                holder.mTv_Chapter.setText("Chapter 7");
                holder.mTv_Chapter_Name.setText("Methods");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 7) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.eighth);
                holder.mTv_Chapter.setText("Chapter 8");
                holder.mTv_Chapter_Name.setText("Strings");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 8) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.javaoop);
                holder.mTv_Chapter.setText("Chapter 9");
                holder.mTv_Chapter_Name.setText("Java OOP");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 9) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.cc);
                holder.mTv_Chapter.setText("Chapter 10");
                holder.mTv_Chapter_Name.setText("Constructors");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 10) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.eleventh);
                holder.mTv_Chapter.setText("Chapter 11");
                holder.mTv_Chapter_Name.setText("4 pillars");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 11) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.twelveth);
                holder.mTv_Chapter.setText("Chapter 12");
                holder.mTv_Chapter_Name.setText("Abstraction");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 12) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.jj);
                holder.mTv_Chapter.setText("Chapter 13");
                holder.mTv_Chapter_Name.setText("Encapsulation");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 13) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.fourteenth);
                holder.mTv_Chapter.setText("Chapter 14");
                holder.mTv_Chapter_Name.setText("Inheritance");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 14) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.ll);
                holder.mTv_Chapter.setText("Chapter 15");
                holder.mTv_Chapter_Name.setText("Polymorphism");
                holder.mTv_Chapter_Name.setTextSize(0);
            } else if (position == 15) {
                //holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.imageView.setImageResource(R.mipmap.mm);
                holder.mTv_Chapter.setText("Chapter 16");
                holder.mTv_Chapter_Name.setText("Java Exception Handling");
                holder.mTv_Chapter_Name.setTextSize(0);
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mDivider == 1) {
            return 16;
        } else if (mDivider == 0){
            return 4;
        } else {
            return 16;
        }
    }


    class LinearViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView mTv_Chapter, mTv_Chapter_Name, mTv_Menu;

        public LinearViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
            mTv_Chapter = itemView.findViewById(R.id.tv_chapter);
            mTv_Chapter_Name = itemView.findViewById(R.id.tv_chapter_name);
            mTv_Menu = itemView.findViewById(R.id.tv_menu);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}
