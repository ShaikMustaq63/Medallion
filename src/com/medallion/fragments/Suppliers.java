package com.medallion.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.medallion.R;
import com.medallion.forms.AddSupplier;
import com.medallion.lists.NotificationsData;
import com.medallion.lists.SupplierData;

public class Suppliers extends SherlockFragment {

	Context context;
	View rootView;
	Intent i;
	ProgressDialog pd;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.suppliers, container, false);
		setHasOptionsMenu(true);
		return rootView;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.suppliers, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		context = getActivity();
		switch (item.getItemId()) {
		case R.id.m_view_suppliers:
			pd = ProgressDialog.show(context, "Please wait",
					"Retrieving data...", true);
			new Thread(new Runnable() {
				@Override
				public void run() {
					// do the thing that takes a long time
					try {
						Thread.sleep(4000);
						i = new Intent(context, SupplierData.class);
						startActivity(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pd.dismiss();
				}
			}).start();
			break;
		case R.id.m_add_suppliers:
			Toast.makeText(context, "Add Suppliers", Toast.LENGTH_LONG)
					.show();
			i = new Intent(context, AddSupplier.class);
			startActivity(i);
			break;
		case R.id.m_search:
			Toast.makeText(context, "Search", Toast.LENGTH_LONG).show();
			break;
		}
		return super.onOptionsItemSelected(item);

	}
}
