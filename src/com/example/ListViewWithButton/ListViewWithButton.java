package com.example.ListViewWithButton;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class ListViewWithButton extends ListActivity implements OnItemSelectedListener {
	
	ListView lv;
	
	Context context;
	
	@Override
    public void onCreate(Bundle onSavedInstanceState) {
	    	
		super.onCreate(onSavedInstanceState);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    
    	setContentView(R.layout.list_view_with_button);
    	
    	context = this;

    	ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = null;
    	
		for(int i=0; i<10; i++){
			map = new HashMap<String, String>();
			
			map.put("firstTextView", "first text view" + i);
			map.put("secondTextView", "STV" + i);
			map.put("thirdTextView", "TTV" + i);
			
			mylist.add(map);
		}
		
	    lv = this.getListView();
	    
	    lv.setOnItemSelectedListener(this);
	    
	    ArrayList<HashMap<String, String>> dataArrayList = new ArrayList<HashMap<String, String>>();
	  
	    for(int i=0; i< 20; i++) {
	    	HashMap<String, String> hashMap = new HashMap<String, String>();
	    	hashMap.put("firstTextView", "FirstTextView " + i);
	    	hashMap.put("secondTextView", "STV " + i);
	    	hashMap.put("thirdTextView", "TTV " + i);
    	
	    	dataArrayList.add(hashMap);
	    }
	    
	    
	    
	    MyAdapter myAdapter = new MyAdapter(this, dataArrayList, 
	    				R.layout.list_view_with_button_one_item_view, 
    					new String[]{"firstTextView", "secondTextView", "thirdTextView"}, 
    					new int[]{R.id.list_view_with_button_one_item_view_first_text_view, 
    							  R.id.list_view_with_button_one_item_view_second_text_view, 
    							  R.id.list_view_with_button_one_item_view_third_text_view});
	    
	    lv.setAdapter(myAdapter);
	    
	    LinearLayout buttonLinearLayout = (LinearLayout)findViewById(R.id.linear_layout_button);
	    
	    ArrayList<Button> buttonArray = new ArrayList<Button>();
	    
	    for(int i=0; i < 20; i++){
	    	Button button = new Button(this);
	    	LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT, 45);
	    	button.setLayoutParams(lp);
	    	button.setText("Delete");
	    	button.setTag(i);
	    	
	    	button.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View clickedButton) {
					Toast.makeText(context, "Delete button is Clicked " + clickedButton.getTag(), Toast.LENGTH_LONG).show();
				}
	    	});
	    	
	    	buttonArray.add(button);
	    	buttonLinearLayout.addView(button);
	    }
	    
	    
		
	}//end method onCreate
    
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		Toast.makeText(this, "List Item Selected is " + position, Toast.LENGTH_SHORT).show(); 
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		
	}

}//end class MessageListing