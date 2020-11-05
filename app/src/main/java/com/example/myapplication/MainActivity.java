package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.IMyItemClickListener {
    //By default scroll functionality
    //It is more memory efficient while scrolling it bring data step vise rather load all data at a time


    MyRecyclerViewAdapter adapter;
    ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = new ArrayList<>();
        names.add("Item 1");
        names.add("Item 2");
        names.add("Item 3");
        names.add("Item 4");
        names.add("Item 5");
        names.add("Item 6");
        names.add("Item 7");
        names.add("Item 8");
        names.add("Item 9");
        names.add("Item 10");
        names.add("Item 11");
        names.add("Item 12");
        names.add("Item 13");
        names.add("Item 14");
        names.add("Item 15");
        names.add("Item 16");
        names.add("Item 17");
        names.add("Item 18");
        names.add("Item 19");
        names.add("Item 20");
        names.add("Item 21");


        RecyclerView recyclerView = findViewById(R.id.recyclerView1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Divider Code
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        adapter = new MyRecyclerViewAdapter(this, names);
        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onMyItemCick(View view, int position) {
        Toast.makeText(this, "You Clicked iTEM " + adapter.getItem(position) + "on Row" + position, Toast.LENGTH_LONG).show();
    }
}











// For Restoring DATA


/*
    public void OnclickRestoreInformation(View view) {
        // Insert single item
       /*
        String item = "BSE5C";
        int insertIndex = 2;
        names.add(insertIndex, item);
        adapter.notifyItemInserted(insertIndex);*/

        /*ArrayList<String> items = new ArrayList<>();
        items.add("Hen");
        items.add("Chicken");
        items.add("Dog");
        int insertIndex = 2;
        names.addAll(insertIndex, items);
        adapter.notifyItemRangeInserted(insertIndex, items.size());
        */
         /*
// Remove single item
int removeIndex = 2;
data.remove(removeIndex);
adapter.notifyItemRemoved(removeIndex);
*/


/*
// Remove multiple items

int startIndex = 2; // inclusive
int endIndex = 4;   // exclusive
int count = endIndex - startIndex; // 2 items will be removed
data.subList(startIndex, endIndex).clear();
adapter.notifyItemRangeRemoved(startIndex, count);
*/

/*
// Remove all items
data.clear();
adapter.notifyDataSetChanged();
*/
/*
// Replace old list with new list
// clear old list
data.clear();
*/

/*
// add new list
ArrayList<String> newList = new ArrayList<>();
newList.add("Lion");
newList.add("Wolf");
newList.add("Bear");
data.addAll(newList);

// notify adapter
adapter.notifyDataSetChanged();
*/

/*

// Update single item
String newValue = "I like sheep.";
int updateIndex = 3;
data.set(updateIndex, newValue);
adapter.notifyItemChanged(updateIndex);

// Move single item
int fromPosition = 3;
int toPosition = 1;

// update data array
String item = data.get(fromPosition);
data.remove(fromPosition);
data.add(toPosition, item);

// notify adapter
adapter.notifyItemMoved(fromPosition, toPosition);

    }*/
