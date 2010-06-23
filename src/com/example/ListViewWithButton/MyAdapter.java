package com.example.ListViewWithButton; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


class MyAdapter extends SimpleAdapter implements OnClickListener {

	
		private LayoutInflater mInflater;
		Context ctx;
		
		ArrayList<HashMap<String, String>> listData;
		String[] fieldName;
		
	    public MyAdapter(Context context, List<HashMap<String, String>> data, int resource, String[] from, int[] to) {
	            super(context, data, resource, from, to);
	            ctx = context;
	            mInflater = LayoutInflater.from(context);
	            
	            listData = (ArrayList<HashMap<String, String>>) data;
	            fieldName = from;
	    }
	    
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	            
	            if (null == convertView) {
	            	convertView = mInflater.inflate(R.layout.list_view_with_button_one_item_view, null);
	            }
	            //take the Button and set listener. It will be invoked when you click the button.
	         //   Button btn = (Button) convertView.findViewById(R.id.list_view_with_button_one_item_view_first_button);
	         //   btn.setTag(position);
	         //   btn.setOnClickListener(this);
	            
	           // RelativeLayout rlText = (RelativeLayout)convertView.findViewById(R.id.list_view_with_button_one_item_view_text_relative_layout);
	           // rlText.setOnClickListener(this);
	            
	            HashMap<String, String> hm = (HashMap<String, String>) listData.get(position);
	            
	            String firstText = (String) hm.get(fieldName[0]);
	            String secondText = (String) hm.get(fieldName[1]);
	            String thirdText = (String) hm.get(fieldName[2]);
	            
	            TextView tv = (TextView) convertView.findViewById(R.id.list_view_with_button_one_item_view_first_text_view);
	            tv.setText(firstText);
	            
	            TextView tv1 = (TextView) convertView.findViewById(R.id.list_view_with_button_one_item_view_second_text_view);
	            tv1.setText(secondText);
	            
	            TextView tv2 = (TextView) convertView.findViewById(R.id.list_view_with_button_one_item_view_third_text_view);
	            tv2.setText(thirdText);
	            
	            return convertView;
	    }
	    
	    @Override
	    public void onClick(View v) {
	    	
	    	int clickedViewId = v.getId();
	    	switch(clickedViewId){
		    	//case R.id.list_view_with_button_one_item_view_first_button:{
		    	//	Integer position = (Integer)v.getTag();
		         //   Toast.makeText(ctx, "Row button clicked at position " + position, Toast.LENGTH_SHORT).show();
		    	//	break;
		    	//}
		    	case R.id.list_view_with_button_one_item_view_text_relative_layout:{
		    		Toast.makeText(ctx, "Relative Layout is clicked", Toast.LENGTH_SHORT).show();
		    		break;
		    	}	
	    	}          
	    }
	}