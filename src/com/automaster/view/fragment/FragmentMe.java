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
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FragmentMe extends Fragment implements OnClickListener{

	private Activity ctx;
	private View layout;
	private MainActivity parentActivity;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		if (layout == null) {
			ctx = this.getActivity();
			parentActivity = (MainActivity) getActivity();
			layout = ctx.getLayoutInflater().inflate(R.layout.fragment_me,
					null);
			
	
			
			
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
