package com.example.howtoUseListView;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class HowtoUseListView_ArrayAdapter extends ArrayAdapter<MySimpleElement> {

	public HowtoUseListView_ArrayAdapter(Context context, ArrayList<MySimpleElement> mySimpleElements) {
		super(context, R.layout.howtouselistview_row, mySimpleElements);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.d("Adapter", ""+position);
		View row = ViewGroup.inflate(parent.getContext(), R.layout.howtouselistview_row, null);
		
		MySimpleElement mySimpleElement = this.getItem(position);
		
		TextView title = (TextView) row.findViewById(R.id.myTitle);
		Button button = (Button) row.findViewById(R.id.myButton);
		
		title.setText(mySimpleElement.myTitle);
		button.setText(mySimpleElement.myTextButton);
		
		return row;
	}
	
	

}
