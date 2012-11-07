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
	
	private HashMap<MySimpleElement, View> viewOfObject = new HashMap<MySimpleElement, View>();

	public HowtoUseListView_baseAdapter(ArrayList<MySimpleElement> mySimpleElements){
		this.mySimpleElements = mySimpleElements;
	}
	
	@Override
	public int getCount() {
		return mySimpleElements.size();
	}

	@Override
	public MySimpleElement getItem(int position) {
		
		return mySimpleElements.get(position);
	}

	/*WTF is this??*/
	@Override
	public long getItemId(int position) {
		return -1;
	}

	@Override
	public View getView(int position, View convertView /*It contains the row that was before in that position*/
			, ViewGroup parent) {
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
