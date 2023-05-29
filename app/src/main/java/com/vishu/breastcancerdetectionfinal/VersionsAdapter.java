package com.vishu.breastcancerdetectionfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VersionsAdapter extends RecyclerView.Adapter<VersionsAdapter.VersionVH> {

    List<Versions> versionsList;

    public VersionsAdapter(List<Versions> versionsList) {
        this.versionsList = versionsList;
    }

    @NonNull
    @Override
    public VersionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent, false);
        return new VersionVH(view);
        //        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull VersionVH holder, int position) {

        Versions versions =versionsList.get(position);

        holder.codeNametxt.setText(versions.getCodeName());
        holder.versionTxt.setText(versions.getVersion());
        holder.apilevelText.setText(versions.getApiLevel());
        holder.descriptionTxt.setText(versions.getDescription());
//so now move in moe class

        boolean isExpendable = versionsList.get(position).isExpendable();
        holder.expendableLayout.setVisibility(isExpendable ? View.VISIBLE : View.GONE);


    }

    @Override
    public int getItemCount() {

        return versionsList.size();
//        return 0;
    }

    public class VersionVH extends RecyclerView.ViewHolder {


        TextView codeNametxt, versionTxt, apilevelText,descriptionTxt;
        LinearLayout linearLayout;
        RelativeLayout expendableLayout;


        public VersionVH(@NonNull View itemView) {
            super(itemView);

            codeNametxt=itemView.findViewById(R.id.code_name);
            versionTxt=itemView.findViewById(R.id.version);
            apilevelText=itemView.findViewById(R.id.api_level);
            descriptionTxt=itemView.findViewById(R.id.desciption);

            linearLayout=itemView.findViewById(R.id.linear_layout);
            expendableLayout=itemView.findViewById(R.id.expendable_layout);

            //here i am going to set click on listener on linear layout
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Versions versions=versionsList.get(getAdapterPosition());
                    versions.setExpendable(!versions.isExpendable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }

    //so here versionVH is ViewHolder class name

}


