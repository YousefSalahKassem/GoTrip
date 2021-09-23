package com.example.seniorstepsproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {

    ArrayList<insertmydata>list;

    Context context;


    public myadapter(ArrayList<insertmydata>l ,Context context){
this.list=l;

this.context=context;
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        return new myviewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, final int position) {
        holder.chooseclass.setText((list.get(position).getChooseclass())+" class");
holder.planename.setText(list.get(position).getPlanename());
holder.myprice.setText(list.get(position).getPrice()+"$");
holder.fromm.setText(list.get(position).getFrom());
holder.too.setText(list.get(position).getTo());
holder.mytime.setText(list.get(position).getTotaltime());
holder.timeto.setText((list.get(position).getTimere()));
holder.timeefrom.setText((list.get(position).getTimego()));
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(context,checkplane.class);
        intent.putExtra("from",list.get(position).getFrom());
        intent.putExtra("to",list.get(position).getTo());
        intent.putExtra("time",list.get(position).getTimego());
        intent.putExtra("date",list.get(position).getDate());
        intent.putExtra("price",list.get(position).getPrice());
        intent.putExtra("chooseclass",list.get(position).getChooseclass());
        intent.putExtra("planename",list.get(position).getPlanename());
        intent.putExtra("duration",list.get(position).getTotaltime());
        intent.putExtra("timefinish",list.get(position).getTimere());
        context.startActivity(intent);

    }
});
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class myviewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
TextView myprice,fromm,too,timeefrom,timeto,mytime,planename,chooseclass;

    public myviewholder(@NonNull View itemView) {
        super(itemView);
        planename=itemView.findViewById(R.id.nameplanee);
fromm=itemView.findViewById(R.id.placefrom);
too=itemView.findViewById(R.id.placeto);
timeto=itemView.findViewById(R.id.timere);
timeefrom=itemView.findViewById(R.id.timego);
mytime=itemView.findViewById(R.id.duration);
myprice=itemView.findViewById(R.id.pricee);
chooseclass=itemView.findViewById(R.id.chooseclass);
    }

        @Override
        public void onClick(View v) {
            Intent i=new Intent(context,checkplane.class);
            context.startActivity(i);

        }
    }

}
