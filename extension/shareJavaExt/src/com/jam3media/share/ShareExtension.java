package com.jam3media.share;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class ShareExtension implements FREExtension {

	public FREContext createContext(String arg0) {
		return new ShareContext();
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void initialize() {
		// TODO Auto-generated method stub

	}

}
