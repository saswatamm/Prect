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
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class CustomAdapter extends FirebaseRecyclerAdapter<Model, CustomAdapter.myviewholder> {



    public CustomAdapter(@NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Model model) {
         String user = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
        int index = 0;
        for(int i=0;i<user.length();i++)
        {
            if(user.charAt(i)==' ')
            {
                index = i;
                break;
            }
        }
         String username = user.substring(1,index+1);
         String first = user.substring(0,1).toUpperCase();
         user = user.substring(0,index+1);
         username = first + username;


         holder.question.setText(model.getQuestion());
         holder.language.setText(model.getLanguage());

         holder.answers.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 AppCompatActivity activity = (AppCompatActivity) view.getContext();
                 Intent intent = new Intent(activity, AnswersGiven.class);
                 intent.putExtra("lang", model.getLanguage());
                 intent.putExtra("question",model.getQuestion());
                //intent.putExtra("uid",model.getUid());
                 activity.startActivity(intent);
                 activity.finish();
             }
         });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_row_item,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView  question, language;
        TextView answers;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            question = itemView.findViewById(R.id.question);
            language = itemView.findViewById(R.id.language);
            answers = itemView.findViewById(R.id.answers);



        }
    }
}
