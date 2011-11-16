package
{
	import com.jam3media.shareExt.ShareExt;
	import com.jam3media.view.buttons.SimpleButton;
	
	import flash.display.Bitmap;
	import flash.display.Sprite;
	import flash.display.StageAlign;
	import flash.display.StageScaleMode;
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.filesystem.File;
	import flash.text.TextField;
	import flash.utils.setTimeout;
	
	public class ShareApp extends Sprite
	{
		
		private var share:ShareExt
		
		private var file:File;
		
		private var button:SimpleButton
		
		[Embed(source="../_assets/ShareExentsionbackground.jpg")]
		private var BG:Class;
		
		private var background:Bitmap = new BG();
		
		public function ShareApp()
		{
			super();
			
			// support autoOrients
			stage.align = StageAlign.TOP_LEFT;
			stage.scaleMode = StageScaleMode.NO_SCALE;
			
			button = new SimpleButton("Click to find a file to share");
			button.x = stage.stageWidth/2 - button.width/2;
			button.y = stage.stageHeight/2 - button.height/2;
			
			
			button.addEventListener(MouseEvent.CLICK,getFile);
			
			
			addEventListener(Event.ADDED_TO_STAGE,onAdded);
			
			
			
			
			
			
		}
		private function onAdded(e:Event):void{
			background.x = stage.stageWidth/2 - background.width/2;
			addChild(background);
			
			button.y = stage.stageHeight-100;
			
			addChild(button);
		}
		private function getFile(e:Event):void{
			
			//find a file to share
			file = new File();
			file.addEventListener(Event.SELECT, onGotFile);
			file.browseForOpen("Please select a file...");
		}
		
		 
		private function onGotFile(e:Event):void{
			
			//list of all valid extensions - more can be added to support new types  - some of these might not even be supported by android 
			var imageExtensions:Array = ["jpg","jpeg","png","gif"];
			var audioExtensions:Array = ["wav","mp3","m4a"];
			var videoExtensions:Array = ["wmv","mp4","avi","flv","f4v"];
			
			
		
			//this next chunck of ugly code figures out what the mime type of the file is so that android launches the approprate share list.			
			var ext:String = file.extension;
			var str:String
			
			//if the extension doesn't match any from our arrays it will remain the defauld application/* and be shared as a file. 
			var mimeType:String = "application/*";
			
			for each (str in imageExtensions){
				if(ext==str){
					mimeType = "image/*";
					break;
				}
			}
			for each (str in videoExtensions){
				if(ext==str){
					mimeType = "video/*";
					break;
				}
			}
			for each (str in audioExtensions){
				if(ext==str){
					mimeType = "audio/*";
					break;
				}
			}
			
			/*
			
			here's the magic:			
			instantiate our Native Extension and share our file
			
			*/			
			share = new ShareExt();
			share.shareMedia(file.name,file.nativePath, mimeType);
			
		}
	}
}