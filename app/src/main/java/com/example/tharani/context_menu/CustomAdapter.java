package com.example.tharani.context_menu;
/*import is libraries imported for writing the code
* AppCompatActivity is base class for activities
* Bundle handles the orientation of the activity
*/

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class CustomAdapter extends BaseAdapter {
    //declaration
    Activity context;
    String title[];
    String description[];
    //creating Constructor
    public CustomAdapter(Activity context, String title[], String description[]) {
        super();
        this.context = context;
        this.title = title;
        this.description = description;
    }

    @Override
   // getCount() returns the numbers of rows in the cursor
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int i) {
        //Get the data item associated with the specified position in the data set.
        return null;
    }

    @Override
    public long getItemId(int i) {
       // Get the item id associated with the specified position in the data set.
        return 0;
    }
    //here we are creating viewHolder CLASS
    private class ViewHolder {
        //Declaration of set of views
        TextView txtViewTitle;
        TextView txtViewDescription;
    }

    //Method getView()
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = context.getLayoutInflater();//retrieving layout of current context
        //Here we are applying condition
        if (view == null) {

            view = inflater.inflate(R.layout.row_custom,null);
            holder = new ViewHolder();
            holder.txtViewTitle =  view.findViewById(R.id.name);
            holder.txtViewDescription =  view.findViewById(R.id.number);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }
        holder.txtViewTitle.setText(title[position]);//setting title
        holder.txtViewDescription.setText(description[position]);//setting description

        return view;//return view

    }
}