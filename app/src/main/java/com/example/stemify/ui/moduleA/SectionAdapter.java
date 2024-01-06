package com.example.stemify.ui.moduleA;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stemify.R;

import java.util.ArrayList;
import java.util.List;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.SectionViewHolder> {
    Context context;
    List<Section> listOfSection;

    public SectionAdapter(Context context, List<Section> listOfSection) {
        this.context = context;
        this.listOfSection = listOfSection;
    }

    @NonNull
    @Override
    public SectionAdapter.SectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SectionViewHolder(LayoutInflater.from(context).inflate(R.layout.item_section, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SectionAdapter.SectionViewHolder holder, int position) {
        Section section = listOfSection.get(position);

        // Bind View objects
        holder.title.setText(section.getTitle());
        holder.masteryPoints.setText(section.getMasteryPoints());

        List<Material> listOfMaterial = section.getListOfMaterial();
        MaterialAdapter materialAdapter = new MaterialAdapter(context, listOfMaterial);
        holder.materialRV.setLayoutManager(new LinearLayoutManager(context));
        holder.materialRV.setAdapter(materialAdapter);
        materialAdapter.notifyDataSetChanged();

        // Setting navigation to specific material page and transferring proper data to next
        materialAdapter.setOnItemClickListener(new MaterialAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String materialType = listOfMaterial.get(position).getType();
                Intent intent = new Intent();
                if("VideoLesson".equalsIgnoreCase(materialType)){
                    intent = new Intent(context, VideoLessonPage.class);
                    intent.putExtra("VideoLesson", listOfMaterial.get(position));
                }
                else if("Practice".equalsIgnoreCase(materialType)){
                    intent = new Intent(context, PracticePage.class);
                }
                else if("Quiz".equalsIgnoreCase(materialType)){
                    intent = new Intent(context, QuizPage.class);
                }
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfSection.size();
    }

    public class SectionViewHolder extends RecyclerView.ViewHolder{
        TextView title, masteryPoints;
        RecyclerView materialRV;

        public SectionViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.TVSectionTitle);
            this.masteryPoints = itemView.findViewById(R.id.TVSectionMasteryPoints);
            this.materialRV = itemView.findViewById(R.id.RVMaterialList);
        }
    }
}
