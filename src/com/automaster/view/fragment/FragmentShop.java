package com.automaster.view.fragment;

import com.juns.wechat.MainActivity;
import com.juns.wechat.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class FragmentShop extends Fragment implements OnClickListener{

	private Activity ctx;
	private View layout;
	private MainActivity parentActivity;
	public RelativeLayout errorItem;
	public TextView errorText;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		if (layout == null) {
			ctx = this.getActivity();
			parentActivity = (MainActivity) getActivity();
			layout = ctx.getLayoutInflater().inflate(R.layout.fragment_shop,
					null);
			errorItem = (RelativeLayout) layout
					.findViewById(R.id.rl_error_item);
			errorText = (TextView) errorItem
					.findViewById(R.id.tv_connect_errormsg);
			
	
			
			
			setOnListener();
		} else {
			ViewGroup parent = (ViewGroup) layout.getParent();
			if (parent != null) {
				parent.removeView(layout);
			}
		}
		return layout;
	}
	
	private void setOnListener() {
	}
	
	public void refresh() {
	}
	
	
	@Override
	public void onClick(View v) {
		
	}

}
