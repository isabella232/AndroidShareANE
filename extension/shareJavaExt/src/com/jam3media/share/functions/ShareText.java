package com.jam3media.share.functions;

import android.app.Activity;
import android.content.Intent;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class ShareText extends Activity implements FREFunction {

	public FREObject call(FREContext context, FREObject[] passedArgs) {

		
		//our function parameters are passed via an array of FREObjects - you need to know the order to be able to parse them properly 
		FREObject fro = passedArgs[0];
		String str = null;
		
		try {
			str = fro.getAsString();
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
		
		//share our text
		share(str,context);
		
		return null;
	}
  private void share(String str,FREContext context){
	  
	  //create our intent to share
	  Intent sharingIntent = new Intent(Intent.ACTION_SEND);
	  
	  //set the type to just plain text
	  sharingIntent.setType("text/plain");
	  
	  //attach our text
	  sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, str);	 
	  
	//pop up the sharing activity
	  context.getActivity().startActivity(Intent.createChooser(sharingIntent,"Share using"));	  
    }
	

}
