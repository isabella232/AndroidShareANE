package com.jam3media.share.functions;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class ShareMedia extends Activity implements FREFunction {

	public FREObject call(FREContext context, FREObject[] passedArgs) {

		
		//our function parameters are passed via an array of FREObjects - you need to know the order to be able to parse them properly 
		
		//this gets our title string from the AIR app
		FREObject fro = passedArgs[0];
		String title = null;
		
		try {
			title = fro.getAsString();
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FRETypeMismatchException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FREInvalidObjectException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FREWrongThreadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		//retrieving our filePath
		FREObject fro1 = passedArgs[1];
		String filePath = null;
		
		try {
			filePath = fro1.getAsString();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//lastly we need to get the mime type
		FREObject fro2 = passedArgs[2];
		String mimeType = null;
		
		try {
			mimeType = fro2.getAsString();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FRETypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREInvalidObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FREWrongThreadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//share the file
		share(title,context, filePath, mimeType);
		
		return null;
	}
  private void share(String title,FREContext context, String filePath, String mimeType ){
	  
	  //create our intent
	  Intent sharingIntent = new Intent(Intent.ACTION_SEND);
	  
	  //get a usuable URI from the filePath
	  Uri uri  =Uri.parse("file://"+filePath); //		 Uri.fromFile(new File(Environment.getExternalStorageDirectory(), title)); 
	  System.out.println("ShareMedia.share() :: "+ uri.getPath());
	  
	  //set the mime Type
	  sharingIntent.setType(mimeType);		
	  
	  //attach our file to our sharingIntent
	  
	  
	  
	  sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);	
	  
	 //attach our title text to our sharingIntent
	  sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, title);	 
	  
	  //pop up the sharing activity
	  context.getActivity().startActivity(Intent.createChooser(sharingIntent,"Share using"));	  
    }
	

}
