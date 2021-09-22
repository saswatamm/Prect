package com.example.prect;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

public class CustomAdapter1 extends FirebaseRecyclerAdapter<Model1, CustomAdapter1.myviewholder> {


    public CustomAdapter1(@NonNull FirebaseRecyclerOptions<Model1> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CustomAdapter1.myviewholder holder, int position, @NonNull Model1 model) {
        holder.question.setText(model.getQuestion());
        holder.language.setText(model.getLanguage());
        holder.giveanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Intent intent = new Intent(activity, GiveAnswer.class);
                intent.putExtra("question",model.getQuestion());
                intent.putExtra("language",model.getLanguage());
                intent.putExtra("uid",model.getUid());
                activity.startActivity(intent);
            }
        });

    }

    @NonNull
    @Override
    public CustomAdapter1.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlequestion,parent,false);
        return new CustomAdapter1.myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView question, language;
        TextView giveanswer;


        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            question = itemView.findViewById(R.id.questions);
            language = itemView.findViewById(R.id.language);
            giveanswer = itemView.findViewById(R.id.giveanswer);




        }
    }
}
