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

public class adapter5 extends RecyclerView.Adapter<adapter5.mvh> {
    ArrayList<inserttofirebase> list;
    Context context;
    public adapter5(ArrayList<inserttofirebase> l,Context c){
        this.list=l;
        this.context=c;
    }
    @NonNull
    @Override
    public mvh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row,parent,false);

        return new mvh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mvh holder, final int position) {
holder.passengername.setText(list.get(position).getName());
holder.phone.setText(list.get(position).getPhone());
holder.kid.setText(list.get(position).getKid());
holder.price.setText(list.get(position).getPrice()+"$");
holder.passpor.setText(list.get(position).getPassport());
holder.start.setText(list.get(position).getFrom());
holder.finish.setText(list.get(position).getTo());
holder.starttime.setText(list.get(position).getTimefrom());
holder.finishtime.setText(list.get(position).getTimeto());
holder.date.setText(list.get(position).getDate());
holder.planename.setText(list.get(position).getTypetravel());
holder.chooseclass.setText(list.get(position).getChooseclass());
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(context,itemtrips.class);
     intent.putExtra("name",list.get(position).getName());
        intent.putExtra("from",list.get(position).getFrom());
        intent.putExtra("to",list.get(position).getTo());
        intent.putExtra("starttime",list.get(position).getTimefrom());
        intent.putExtra("finishtime",list.get(position).getTimeto());
        intent.putExtra("date",list.get(position).getDate());
        intent.putExtra("planename",list.get(position).getTypetravel());
        intent.putExtra("address",list.get(position).getAddress());
        intent.putExtra("kid",list.get(position).getKid());
        intent.putExtra("class",list.get(position).getChooseclass());
        intent.putExtra("passport",list.get(position).getPassport());
        intent.putExtra("phone",list.get(position).getPhone());
        intent.putExtra("price",list.get(position).getPrice());
        context.startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class mvh extends RecyclerView.ViewHolder{
        TextView passengername,adult,kid,passpor,start,finish,starttime,date,price,chooseclass,planename,finishtime,totaltime,phone,types;
        public mvh(@NonNull View itemView) {
            super(itemView);
            passengername=itemView.findViewById(R.id.showname);
            kid=itemView.findViewById(R.id.showkids);
            passpor=itemView.findViewById(R.id.showpassport);
            start=itemView.findViewById(R.id.showfrom);
            finish=itemView.findViewById(R.id.showto);
            starttime=itemView.findViewById(R.id.showtimeto);
            finishtime=itemView.findViewById(R.id.showt);
            date=itemView.findViewById(R.id.showdate);
            price=itemView.findViewById(R.id.showprice);
            chooseclass=itemView.findViewById(R.id.showclass);
            planename=itemView.findViewById(R.id.showairname);
            phone=itemView.findViewById(R.id.showphone);
        }

    }

}
