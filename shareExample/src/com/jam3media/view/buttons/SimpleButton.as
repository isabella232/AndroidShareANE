package com.jam3media.view.buttons
{
	import com.greensock.TweenLite;
	
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.text.Font;
	import flash.text.TextField;
	import flash.text.TextFieldAutoSize;
	import flash.text.TextFormat;

	public class SimpleButton extends Sprite
	{
		
		private var tf:TextField
		
		public function SimpleButton(str:String)
		{
			
			var arr:Array = Font.enumerateFonts(true);
			
			
			var format:TextFormat = new TextFormat();
			format.font = "_sans";
			format.size = 36;
			
			
			tf = new TextField();
			tf.setTextFormat(format);
			tf.defaultTextFormat = format;
			tf.autoSize = TextFieldAutoSize.LEFT
			tf.text = str;
			tf.wordWrap = false;
			tf.multiline = false;
		
			addChild(tf);
			
			
			
		}
		
	}
}