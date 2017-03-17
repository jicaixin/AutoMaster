package com.automaster.view.fragment;

import com.automaster.view.activity.CarFittingListActivity;
import com.juns.wechat.MainActivity;
import com.juns.wechat.R;
import com.juns.wechat.common.Utils;
import com.juns.wechat.zxing.CaptureActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class Fragment_main extends Fragment implements OnClickListener, OnItemSelectedListener{

	private Activity ctx;
	private View layout;
//	private layout_head;
	private MainActivity parentActivity;
	public RelativeLayout errorItem;
	public TextView errorText;
	private EditText carnumberText;
	private boolean isSpinnerFirst1 = true;
	private boolean isSpinnerFirst2 = true;
	private boolean isSpinnerFirst3 = true;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		if (layout == null) {
			ctx = this.getActivity();
			parentActivity = (MainActivity) getActivity();
			layout = ctx.getLayoutInflater().inflate(R.layout.fragment_main,
					null);
			errorItem = (RelativeLayout) layout
					.findViewById(R.id.rl_error_item);
			errorText = (TextView) errorItem
					.findViewById(R.id.tv_connect_errormsg);
			
			carnumberText = (EditText) layout.findViewById(R.id.chejiahao);
			
	
			
			
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
		layout.findViewById(R.id.btn_search).setOnClickListener(this);
		layout.findViewById(R.id.scan_car_number).setOnClickListener(this);
		layout.findViewById(R.id.take_car_photo).setOnClickListener(this);
		
		((Spinner) layout.findViewById(R.id.spinner1)).setOnItemSelectedListener(this);
		((Spinner) layout.findViewById(R.id.spinner2)).setOnItemSelectedListener(this);
		((Spinner) layout.findViewById(R.id.spinner3)).setOnItemSelectedListener(this);
	}
	
	public void refresh() {
	}

	/**
	 * 扫描到条形码或者二维码
	 * @param data
	 */
	public void onCaptureCarNumber(Intent data) {
		String number = data.getStringExtra("result");
		carnumberText.setText(number);
	}
	
	/**
	 * 扫描到行驶证
	 * @param data
	 */
	public void onCaptureCarCertificates(Intent data) {
		((Spinner) layout.findViewById(R.id.spinner1)).setSelection(1);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_search :

				Utils.start_Activity(getActivity(), CarFittingListActivity.class);
				break;
			case R.id.scan_car_number:
				Utils.start_ActivityForResult(getActivity(), CaptureActivity.class, MainActivity.REQUEST_CODE_CAPTURE);
				break;
			case R.id.take_car_photo:
				Utils.start_ActivityForResult(getActivity(), CaptureActivity.class, MainActivity.REQUEST_CODE_SCAN_CERTIFICATE);
				break;
			default: break;
		}
	}
	
	@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		
		switch (parent.getId()) {
			case R.id.spinner1:
				if (isSpinnerFirst1) {
		            view.setVisibility(View.INVISIBLE);
		        }
		        isSpinnerFirst1 = false;
				break;
			case R.id.spinner2:

				if (isSpinnerFirst2) {
		            view.setVisibility(View.INVISIBLE);
		        }
		        isSpinnerFirst2 = false;
				break;
			case R.id.spinner3:

				if (isSpinnerFirst3) {
		            view.setVisibility(View.INVISIBLE);
		        }
		        isSpinnerFirst3 = false;
				break;
		}
		
        
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
