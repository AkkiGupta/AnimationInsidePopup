package com.animation.inside.popup;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class SamplePopup extends Activity 
{

	View layoutPopUP;
	Button btnPopUp;
	Point p;
	AnimatingRelativeLayout llPopUp;
	Button btn1;
	Button btn2;
	Button btn3;
	AnimatingRelativeLayout llCustomViewPopUp;
	AnimatingRelativeLayout llListPopUp;
	AnimatingRelativeLayout rltvHeader;
	AnimatingRelativeLayout rltvBack;
	TextView lbl_Header;
	Button btnBackPopUp;
	Button btnCustomViewPopUp;
//	boolean subCustomViewVisible = false;
//	boolean subListVisible = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.samplepopup);
		btnPopUp = (Button)findViewById(R.id.btnShowPopUp);
		btnPopUp.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v) 
			{
				showPopup(SamplePopup.this, p);
			}
		});
	}
	
	/*public void onPopupButtonClick(View button) 
	{
        PopupMenu popup = new PopupMenu(this, button);
        popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(SamplePopup.this, "Clicked popup menu item " + item.getTitle(),
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        popup.show();
    }*/
	
	public void performAnimation(View targt,View targt2, int position, final int type)
	{
        final View target = targt;//findViewById(R.id.target);
        final View targetParent = (View) target.getParent();

        Animation a = new TranslateAnimation(0.0f,
                - target.getWidth(), 0.0f, 0.0f);
        a.setDuration(1000);
        Animation a2 = new TranslateAnimation(targt2.getWidth(),
                0.0f, 0.0f, 0.0f);
        a2.setDuration(2000);
//        a.setStartOffset(300);
        a.setAnimationListener(new AnimationListener() 
        {
			public void onAnimationStart(Animation animation) 
			{
				
			}
			
			public void onAnimationRepeat(Animation animation) 
			{
				
			}
			
			public void onAnimationEnd(Animation animation) 
			{
				if(type == 0)
				{
					llPopUp.setVisibility(View.GONE);
					llCustomViewPopUp.setVisibility(View.VISIBLE);
				}
				
			}
		});
        a.setRepeatMode(0);
        a.setRepeatCount(0);
        
        a2.setRepeatMode(0);
        a2.setRepeatCount(0);

//        switch (position) 
//        {
//        case 0:
//        	a.setInterpolator(AnimationUtils.loadInterpolator(this,
//                    android.R.anim.accelerate_interpolator));
//            break;
//        case 1:
//            a.setInterpolator(AnimationUtils.loadInterpolator(this,
//                    android.R.anim.decelerate_interpolator));
//            break;
//        case 2:
//            a.setInterpolator(AnimationUtils.loadInterpolator(this,
//                    android.R.anim.accelerate_decelerate_interpolator));
//            break;
//        case 3:
//            a.setInterpolator(AnimationUtils.loadInterpolator(this,
//                    android.R.anim.anticipate_interpolator));
//            break;
//        case 4:
//            a.setInterpolator(AnimationUtils.loadInterpolator(this,
//                    android.R.anim.overshoot_interpolator));
//            break;
//        case 5:
//            a.setInterpolator(AnimationUtils.loadInterpolator(this,
//                    android.R.anim.anticipate_overshoot_interpolator));
//            break;
//        case 6:
//            a.setInterpolator(AnimationUtils.loadInterpolator(this,
//                    android.R.anim.bounce_interpolator));
//            break;
//        }

        target.startAnimation(a);
        targt2.startAnimation(a2);
	}

//	public void getFlipper()
//	{
//		final ViewFlipper viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
//		Button nextButton = (Button) this.findViewById(R.id.nextButton);
//		nextButton.setOnClickListener(new OnClickListener()
//		{
//			@Override
//			public void onClick(View v) 
//			{
//				viewFlipper.setInAnimation(SamplePopup.this, R.anim.push_left_in);
//				viewFlipper.setOutAnimation(SamplePopup.this, R.anim.push_left_out); 
//				viewFlipper.showNext(); 
//			} 
//		});
//		Button previousButton = (Button) this.findViewById(R.id.previousButton); 
//		previousButton.setOnClickListener(new OnClickListener() 
//		{
//			@Override 
//			public void onClick(View v) 
//			{
//				viewFlipper.setInAnimation(SamplePopup.this, R.anim.view_transition_in_right);
//				viewFlipper.setOutAnimation(SamplePopup.this, R.anim.view_transition_out_right); 
//				viewFlipper.showPrevious();  
//			}});
//	}
	
	private void showPopup(final Activity context, Point p) 
	{
//		subCustomViewVisible = false;
//		subListVisible = false;
		int[] location = new int[2];
		// Get the x, y location and store it in the location[] array
		// location[0] = x, location[1] = y.
		btnPopUp.getLocationOnScreen(location);
		//Initialize the Point with x, and y positions
		p = new Point();
		p.x = location[0];
		p.y = location[1];
		// Inflate the popup_layout.xml
		LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popup);
		LayoutInflater layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		layoutPopUP = layoutInflater.inflate(R.layout.popuplayout, viewGroup);
		lbl_Header = (TextView)layoutPopUP.findViewById(R.id.lbl_Header);
		btnBackPopUp = (Button)layoutPopUP.findViewById(R.id.btnBackPopUp);
		rltvHeader = (AnimatingRelativeLayout)layoutPopUP.findViewById(R.id.rltvHeader);
		rltvBack = (AnimatingRelativeLayout)layoutPopUP.findViewById(R.id.rltvBack);
//		btnBackPopUp.setVisibility(View.GONE);
		llPopUp = (AnimatingRelativeLayout)layoutPopUP.findViewById(R.id.llPopUp);
		llCustomViewPopUp = (AnimatingRelativeLayout)layoutPopUP.findViewById(R.id.llCustomViewPopUp);
		btnCustomViewPopUp = (Button)layoutPopUP.findViewById(R.id.btnCustomViewPopUp);
		llListPopUp = (AnimatingRelativeLayout)layoutPopUP.findViewById(R.id.llListPopUp);
		
		btn1 = (Button)llPopUp.findViewById(R.id.btn1);
		btn2 = (Button)llPopUp.findViewById(R.id.btn2);
		btn3 = (Button)llPopUp.findViewById(R.id.btn3); 
		// Creating the PopupWindow
		final PopupWindow popup = new PopupWindow(context);
		popup.setContentView(layoutPopUP);
		popup.setWidth(LayoutParams.WRAP_CONTENT);
		popup.setHeight(LayoutParams.WRAP_CONTENT);
		popup.setFocusable(true);
		// Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
		int OFFSET_X = 0;
		int OFFSET_Y = 250;
		btn1.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v) 
			{
//				subCustomViewVisible = true;
				rltvBack.show(2);
				lbl_Header.setText("Custom View");
//				rltvHeader.show(2);
				llPopUp.hide(0);
				llCustomViewPopUp.show(0);
			}
		});
		btn2.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v) 
			{
//				subListVisible = true;
				lbl_Header.setText("List View");
				rltvBack.show(2);
				llPopUp.hide(0);
				llListPopUp.show(0);
			}
		});
		btnCustomViewPopUp.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v) 
			{
//				subCustomViewVisible = false;
//				subListVisible = false;
				lbl_Header.setText("PopUp");
				rltvBack.hide(3);
				llCustomViewPopUp.hide(1);
				llPopUp.show(1);
			}
		});
		btn3.setOnClickListener(new OnClickListener() 
		{
			public void onClick(View v) 
			{
				popup.dismiss();
			}
		});
		btnBackPopUp.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v) 
			{
//				subCustomViewVisible = false;
//				subListVisible = false;
				lbl_Header.setText("PopUp");
				rltvBack.hide(3);
				llCustomViewPopUp.hide(1);
				llListPopUp.hide(1);
				llPopUp.show(1);
//				btnBackPopUp.setVisibility(View.GONE);
			}
		});
		// Clear the default translucent background
		popup.setBackgroundDrawable(new BitmapDrawable());
		popup.showAtLocation(getWindow().getDecorView(), Gravity.TOP, p.x- OFFSET_X , p.y- OFFSET_Y);//+ OFFSET_X- OFFSET_Y
	}
}
