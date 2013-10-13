package com.xortech.cellinfo;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TowerInfo extends Fragment {
	
	public static final String ARG_SECTION_NUMBER = "section_number";
	
	// Network Type Constants
	public static final int NETWORK_TYPE_UNKNOWN = 0;
	public static final int NETWORK_TYPE_GPRS = 1;
	public static final int NETWORK_TYPE_EDGE = 2;
	public static final int NETWORK_TYPE_UMTS = 3;
	public static final int NETWORK_TYPE_CDMA = 4;
	public static final int NETWORK_TYPE_EVDO_0 = 5;
	public static final int NETWORK_TYPE_EVDO_A = 6;
	public static final int NETWORK_TYPE_1xRTT = 7;
	public static final int NETWORK_TYPE_HSDPA = 8;
	public static final int NETWORK_TYPE_HSUPA = 9;
	public static final int NETWORK_TYPE_HSPA = 10;
	
	private String deviceID;
	private CellLocation cellLocation;
	private String softwareVersion;
	private List<NeighboringCellInfo> neighborCellInfo;
	private int phoneType;
	private String operatorName;
	private String networkOperator;
	private String networkCountry;
	private int networkType;
	private String phoneNumber;
	private String subscriberId;
	
	Context context;
	TextView v1;
	TextView v2;
	TextView v3;
	TextView v4;
	TextView v5;
	TextView v6;
	TextView v7;
	TextView v8;
	TextView v9;
	TextView v10;
	
	public TowerInfo(Context ctx) {
		context = ctx;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.tower_info,container, false);
		
		TelephonyManager tManager = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
				
		deviceID = tManager.getDeviceId();
		cellLocation = tManager.getCellLocation();
		softwareVersion = tManager.getDeviceSoftwareVersion();
		phoneType = tManager.getPhoneType();
		operatorName = tManager.getNetworkOperatorName();
		networkOperator = tManager.getNetworkOperator();
		networkCountry = tManager.getNetworkCountryIso();
		networkType = tManager.getNetworkType();
		phoneNumber = tManager.getLine1Number();
		subscriberId = tManager.getSubscriberId();
		
		v1 = (TextView) rootView.findViewById(R.id.device_id);
		v2 = (TextView) rootView.findViewById(R.id.cell_location);
		v3 = (TextView) rootView.findViewById(R.id.software_version);
		v4 = (TextView) rootView.findViewById(R.id.phone_type);
		v5 = (TextView) rootView.findViewById(R.id.net_operator_name);
		v6 = (TextView) rootView.findViewById(R.id.network_operator);
		v7 = (TextView) rootView.findViewById(R.id.net_country);
		v8 = (TextView) rootView.findViewById(R.id.net_type);
		v9 = (TextView) rootView.findViewById(R.id.phone_number);
		v10 = (TextView) rootView.findViewById(R.id.subscriber_id);
		
		v1.setText("Device Id: " + deviceID);
		v2.setText("Cell Location: " + String.valueOf(cellLocation));
		v3.setText("Software Version: " + softwareVersion);
		// v4.setText(String.valueOf(neighborCellInfo.size()) + " towers");
		v4.setText("Phone Type: " + phoneType);
		v5.setText("Network Name: " + operatorName);
		v6.setText("Network Id: " + networkOperator);
		v7.setText("Network Country: " + networkCountry);
		v8.setText("Network Type: " + GetNetwork(networkType));
		v9.setText("Mobile Number: " + phoneNumber);
		v10.setText("Subscriber Id: " + subscriberId);
			
		return rootView;
	}
	
	public String GetNetwork(int network) {	
		switch (network) {
		case NETWORK_TYPE_GPRS:
			return "GPRS";
		case NETWORK_TYPE_EDGE:
			return "EDGE";
		case NETWORK_TYPE_UMTS:
			return "UMTS";
		case NETWORK_TYPE_HSDPA:
			return "HSDPA";
		case NETWORK_TYPE_HSUPA:
			return "HSUPA";
		case NETWORK_TYPE_HSPA:
			return "HSPA";
		case NETWORK_TYPE_CDMA:
			return "CDMA";
		case NETWORK_TYPE_EVDO_0:
			return "CDMA - EvDo rev. 0";
		case NETWORK_TYPE_EVDO_A:
			return "CDMA - EvDo rev. A";
		case NETWORK_TYPE_1xRTT:
			return "CDMA - 1xRTT";
		default:
			return "UNKNOWN";
		}
	}
}
