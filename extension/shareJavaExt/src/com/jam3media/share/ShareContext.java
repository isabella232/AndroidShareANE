package com.jam3media.share;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.jam3media.share.functions.ShareMedia;
import com.jam3media.share.functions.ShareText;

public class ShareContext extends FREContext {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Map<String, FREFunction> getFunctions() {
		Map<String, FREFunction> functionMap = new HashMap<String, FREFunction>(); 
		
		//these are the functions that are publicly available - they match what we've added to shareExt.as
		
		//shareText is just for sharing text
		functionMap.put("shareText", new ShareText());
		
		//shareMedia can handle sharing media files
		functionMap.put("shareMedia", new ShareMedia());
		
		return functionMap;
	}

}
