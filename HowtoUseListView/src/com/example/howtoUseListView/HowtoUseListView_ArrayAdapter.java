package com.example.howtoUseListView;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class HowtoUseListView_ArrayAdapter extends ArrayAdapter<MySimpleElement> {
	
	private HashMap<MySimpleElement, View> viewOfObject = new HashMap<MySimpleElement, View>();

	public HowtoUseListView_ArrayAdapter(Context context, ArrayList<MySimpleElement> mySimpleElements) {
		super(context, R.layout.howtouselistview_row, mySimpleElements);
	}

	@Override
	public View getView(int position, View convertView /*It contains the row that was before in that position*/, ViewGroup parent) {
		Log.d("Adapter", "Pos gen: "+position);
		
		MySimpleElement mySimpleElement = this.getItem(position);
		
		View row = viewOfObject.get(mySimpleElement);
		if(row == null) {
			row = ViewGroup.inflate(parent.getContext(), R.layout.howtouselistview_row, null);
			
			TextView title = (TextView) row.findViewById(R.id.myTitle);
			Button button = (Button) row.findViewById(R.id.myButton);
			
			title.setText(mySimpleElement.myTitle);
			button.setText(mySimpleElement.myTextButton);
			
			viewOfObject.put(mySimpleElement, row);
		} else {
			//Update row with newer values IF NEEDED.
		}
		
		return row;
	}
}
