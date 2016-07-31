package com.mobilions.fxonline;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {

	TableRow clickedrow;
	boolean clicked=false;
	TabRow[] tabArr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initTabArr();
		
		TableLayout t=(TableLayout) findViewById(R.id.table);
		for(int i=0;i<tabArr.length;i++){
			final TabRow tr=tabArr[i];
			final TableRow tabr=new TableRow(getBaseContext());
			tabr.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					if(clickedrow != null){
						clickedrow.setBackgroundResource(R.drawable.textview_grey);;
					}
					clickedrow=tabr;
					clicked=true;
					tabr.setBackgroundResource(R.drawable.textview_yellow);//setBackgroundResource(R.drawable.black);
				}
			});

			LayoutParams lp = new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
			tabr.setLayoutParams(lp);
			tabr.setBackgroundResource(R.drawable.textview_grey);
			tabr.setWeightSum(7);

			TextView tv1=Createview(1, tr.cur,"cur");
			tabr.addView(tv1, 0);

			//LinearLayout.LayoutParams llp2=new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.FILL_PARENT, 10);
			TextView tv2=Createview(1, tr.pos1,"pos1");
			tabr.addView(tv2,1);

			//LinearLayout.LayoutParams llp3=new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.FILL_PARENT, 10);
			TextView tv3=Createview(1, tr.pos2,"pos2");
			tabr.addView(tv3,2);

			//LinearLayout.LayoutParams llp4=new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.FILL_PARENT, 5);
			TextView tv4=Createview(1, tr.age,"age");
			tabr.addView(tv4,3);

			//LinearLayout.LayoutParams llp5=new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.FILL_PARENT, 5);
			TextView tv5=Createview(1, tr.pnl,"pnl");
			tabr.addView(tv5,4);

			//LinearLayout.LayoutParams llp6=new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.FILL_PARENT, 10);
			TextView tv6=Createview(1, tr.book,"book");
			tabr.addView(tv6,5);

			//LinearLayout.LayoutParams llp7=new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.FILL_PARENT, 10);
			TextView tv7=Createview(1, tr.mkt,"mrk");
			tabr.addView(tv7,6);
			
			tabr.setClickable(true);
			tabr.setFocusable(true);
			tabr.setFocusableInTouchMode(true);

			t.addView(tabr);	
		}

		ImageButton pie=(ImageButton) findViewById(R.id.pie);	
		OnClickListener l=new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity.this, SecondActivity.class);

				if(clicked){
					i.putExtra("clicked", clicked);

					clicked=false;
					startActivity(i);
				}
				else
					i.putExtra("clicked", false);	
//				startActivity(i);
			}
		};
		pie.setOnClickListener(l);	
	}

	TextView Createview(int weight,Object txtvalue,String field){

		TextView tv1=new TextView(this);
		LayoutParams llp1 = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT,weight);
		tv1.setText(txtvalue+"");
		tv1.setLayoutParams(llp1);
//		tv1.setBackgroundResource(R.drawable.lightgrey);
		tv1.setGravity(Gravity.CENTER);
		if(field.equals("pos1")&& (Double)txtvalue<0  ){
			tv1.setTextColor(Color.RED);
		}else if(field.equals("pos2")&& (Double)txtvalue<0  ){
			tv1.setTextColor(Color.RED);
		}else if(field.equals("pnl")){
			if( (Double)txtvalue<=0  )
				tv1.setTextColor(Color.RED);
			else
				tv1.setTextColor(Color.GREEN);
		}
		//tv1.setLayoutParams(llp1);
		return tv1;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void initTabArr(){
		TabRow t1= new TabRow("USD", 0.154, -0.123, 1, 0.2, 1.554, 1.564);
		TabRow t2=new TabRow("USD", -0.154, 0.123, 1, 0.2, 1.554, 1.564);
		TabRow t3=new TabRow("USD", 0.154, -0.123, 1, 0.0, 1.554, 1.564);
		TabRow t4=new TabRow("USD", 0.154, -0.123, 1, 0.2, 1.554, 1.564);
		TabRow t5=new TabRow("USD", -0.154, 0.123, 1, 0.2, 1.554, 1.564);
		TabRow t6=new TabRow("USD", 0.154, -0.123, 1, 0.0, 1.554, 1.564);
		TabRow t7=new TabRow("USD", 0.154, -0.123, 1, 0.2, 1.554, 1.564);
		TabRow t8=new TabRow("USD", -0.154, 0.123, 1, 0.2, 1.554, 1.564);
		TabRow t9=new TabRow("USD", 0.154, -0.123, 1, 0.0, 1.554, 1.564);
		TabRow t10=new TabRow("USD", 0.154, -0.123, 1, 0.2, 1.554, 1.564);
		TabRow t11=new TabRow("USD", -0.154, 0.123, 1, 0.2, 1.554, 1.564);
		TabRow t12=new TabRow("USD", 0.154, -0.123, 1, 0.0, 1.554, 1.564);
		TabRow t13=new TabRow("USD", 0.154, -0.123, 1, 0.2, 1.554, 1.564);
		TabRow t14=new TabRow("USD", -0.154, 0.123, 1, 0.2, 1.554, 1.564);
		TabRow t15=new TabRow("USD", 0.154, -0.123, 1, 0.0, 1.554, 1.564);
		TabRow t16=new TabRow("USD", 0.154, -0.123, 1, 0.2, 1.554, 1.564);
		TabRow t17=new TabRow("USD", -0.154, 0.123, 1, 0.2, 1.554, 1.564);
		TabRow t18=new TabRow("USD", 0.154, -0.123, 1, 0.0, 1.554, 1.564);
		TabRow t19=new TabRow("USD", -0.154, 0.123, 1, 0.2, 1.554, 1.564);
		TabRow t20=new TabRow("USD", 0.154, -0.123, 1, 0.0, 1.554, 1.564);
		TabRow t21=new TabRow("USD", 0.154, -0.123, 1, 0.0, 1.554, 1.564);
		TabRow t22=new TabRow("USD", 0.154, -0.123, 1, 0.0, 1.554, 1.564);
		TabRow t23=new TabRow("USD", 0.154, -0.123, 1, 0.0, 1.554, 1.564);
		TabRow t24=new TabRow("USD", 0.154, -0.123, 1, 0.0, 1.554, 1.564);
		TabRow t25=new TabRow("USD", 0.154, -0.123, 1, 0.0, 1.554, 1.564);
		TabRow t26=new TabRow("USD", 0.154, -0.123, 1, 0.0, 1.554, 1.564);
		TabRow t27=new TabRow("USD", 0.154, -0.123, 1, 0.0, 1.554, 1.564);
		
		tabArr = new TabRow[]{t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27};
	}
}
