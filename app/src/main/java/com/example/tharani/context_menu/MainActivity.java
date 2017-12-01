package com.example.tharani.context_menu;
/*import is libraries imported for writing the code
* AppCompatActivity is base class for activities
* Bundle handles the orientation of the activity
*/

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //declaring variables

    ListView listView;
    CustomAdapter listViewAdapter;
    int index=0;
    //here we taking to different String
    private final static String name[]={"Nida","Viveka","Raju","Anusha","Vinuntha","Sarayu","Ramya","Tharani"};
    private final static String number[]={"8791108392","9754367876","8798545642","7854378929","7154896547","9065378432","7809457254",
            "9097534246"};


    @Override
     /*onCreate is the first method in the life cycle of an activity
 savedInstance passes data to super class,data is pull to store state of application
 * setContentView is used to set layout for the activity
 *R is a resource and it is auto generate file
  * activity_main assign an integer value*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.list_View);
        listViewAdapter = new CustomAdapter(this,name,number);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
        registerForContextMenu(listView);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(this, "Long press to Call /SMS", Toast.LENGTH_LONG).show();
        // LENGTH_LONG is the duration for which a toast is displayed on screen and duration which is 3,5 seconds
        index=position;
    }

    @Override
    //here we are creating context Menu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //here we are adding header in the menu
        menu.setHeaderTitle("Select the Action");
        //here we are adding two different action in the menu
        menu.add(0, 1, 0, "Call");
        menu.add(0, 2, 1, "Send SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //here we are applying condition for two different action
        try {
            //here we are applying condition for call
            if(item.getItemId()==1 && item.getGroupId()==0){
                //here we are creating intent
                Intent i=new Intent();
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+number[index]));
                startActivity(i);
            }
            //here we are applying condition for sms
            else if(item.getItemId()==2 && item.getGroupId()==0){
                //here we are creating intent
                Intent i=new Intent();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+ number[index])));
                startActivity(i);
            }
            else{
                return false;
            }
            return true;
        } catch (Exception e) {//if false catches exception
            return true;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater() method will Inflate a menu hierarchy from the specified XML resource.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);//returns
    }
}