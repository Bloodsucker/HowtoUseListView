package com.example.howtoUseListView;

import java.util.ArrayList;
import java.util.HashMap;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class HowtoUseListView_baseAdapter extends BaseAdapter {
	
	private ArrayList<MySimpleElement> mySimpleElements;
	
//	private HashMap<Integer, MySimpleElement> viewAtPosition;

	public HowtoUseListView_baseAdapter(ArrayList<MySimpleElement> mySimpleElements){
		this.mySimpleElements = mySimpleElements;
		
		//notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		return mySimpleElements.size();
	}

	@Override
	public Object getItem(int position) {
		
		return mySimpleElements.get(position);
	}

	@Override
	public long getItemId(int position) {
		return -1;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.d("Adapter", ""+position);
		View row = ViewGroup.inflate(parent.getContext(), R.layout.howtouselistview_row, null);
		
		MySimpleElement mySimpleElement = mySimpleElements.get(position);
		
		TextView title = (TextView) row.findViewById(R.id.myTitle);
		Button button = (Button) row.findViewById(R.id.myButton);
		
		title.setText(mySimpleElement.myTitle);
		button.setText(mySimpleElement.myTextButton);
		
		return row;
	}

}
