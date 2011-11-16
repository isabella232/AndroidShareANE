package com.jam3media.shareExt
{
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.external.ExtensionContext;
	
	public class ShareExt extends EventDispatcher
	{
		
		private static var extContext:ExtensionContext = null;
		
		public function ShareExt(target:IEventDispatcher=null)
		{
			
			//create our extension context - the package needs to match the package in the java part.  For sharing, we don't need to specify a context. 
			if ( !extContext ) { 
				extContext = ExtensionContext.createExtensionContext("com.jam3media.shareExt",""); 
			}
		}
		
		// these are the functions that we can call on the native part of our extension
		
		//this will share only text
		public function shareText(str:String):void {			
			extContext.call("shareText",str); 
		}
		
		//use this function to share a file 
		public function shareMedia(title:String, filePath:String, mimeType:String):void { 
			extContext.call("shareMedia",title,filePath, mimeType); 
		}
	}
}