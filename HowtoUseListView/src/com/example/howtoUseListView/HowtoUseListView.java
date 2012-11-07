package com.example.howtoUseListView;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class HowtoUseListView extends Activity {

	private ListView myListView;
	
	private ArrayList<MySimpleElement> mySimpleElements = new ArrayList<MySimpleElement>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.howtouselistview);
		
		crearLista();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.howtouselistview, menu);
		return true;
	}
	
	private void generateRandomoData(int numeroElementos){
		for(int i=0; i<numeroElementos; i++){
			MySimpleElement mySimpleElement = new MySimpleElement();
			mySimpleElement.myTitle = "Elemento "+i;
			mySimpleElement.myTextButton = "Botoncito nº "+i;
			
			mySimpleElements.add(mySimpleElement);
		}
	}

	private void crearLista(){
		generateRandomoData(30);
		
		myListView = (ListView) findViewById(R.id.myListView);
//		myListView.setAdapter(new HowtoUseListView_baseAdapter(mySimpleElements));
		myListView.setAdapter(new HowtoUseListView_ArrayAdapter(this, mySimpleElements));
		
		/*HowtoUseListView_ArrayAdapter ad = (HowtoUseListView_ArrayAdapter) myListView.getAdapter();
		ad.remove(mySimpleElements.get(3));*/
	}
}
