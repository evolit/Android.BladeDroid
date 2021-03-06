package edu.uw.bladedroid.blade;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.view.KeyEvent;

public class SocialifyBlade extends AbstractBlade{	
	@Override
	public boolean onKeyLongPress(Activity activity, int keyCode, KeyEvent event)
	{
		if(keyCode == KeyEvent.KEYCODE_BACK)
		{
			postStuff(activity);
			return true;
		}
		return false;
	}
	
	public void postStuff(Activity activity)
	{
		Intent i = new Intent("android.intent.action.MAIN");
		i.setComponent(ComponentName.unflattenFromString("com.socialify/.PostActivity"));
		i.addCategory("android.intent.category.LAUNCHER");
		String packagename=activity.getApplicationContext().getPackageName();
		String activityname=activity.getClass().getSimpleName();
		i.putExtra("data", "I love "+ activityname+" of the wonderful app "+packagename);
		activity.startActivity(i);
	}
}