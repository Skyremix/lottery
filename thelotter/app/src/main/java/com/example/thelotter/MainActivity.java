package com.example.thelotter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;


public class MainActivity extends Activity {
		Button btnPlay,btnTicket;
		TextView textTime;
	    private ImageSwitcher imageSwitcher;
	    private int[] gallery = {R.drawable.a, R.drawable.b, R.drawable.s, R.drawable.p, R.drawable.k, R.drawable.m};
	    private int position = 0;
	    private Timer timer = null;
	class Layout{
		public Layout(){
		}	
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnTicket =(Button)findViewById(R.id.btnTicket);
        btnPlay = (Button)findViewById(R.id.btnPlay);
        
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        textTime = (TextView)findViewById(R.id.textTime);
        
        final CounterClass time = new CounterClass(720*60000,1000);
        textTime.setText("00:00:00");
       
        time.start();

        
        btnTicket.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentTicket =  new Intent(MainActivity.this,ActivityKeys.class);
					startActivity(intentTicket);
			}
		});
        
		btnPlay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentPlay  = new Intent(MainActivity.this,ActivityKeys.class);
					startActivity(intentPlay);
			}
		});
		
	
		
		
        imageSwitcher.setFactory(new ViewFactory() {
            public View makeView() 
            {
            	        timer = new Timer();
            	        timer.scheduleAtFixedRate(new TimerTask() {
            	        public void run() {
            	            // avoid exception: "Only the original thread that created a view hierarchy can touch its views"
            	            runOnUiThread(new Runnable() {
            	                 public void run() {
            	                     imageSwitcher.setImageResource(gallery[position]);
            	                     
            	                        position++;
            	                        if (position == 6)
            	                        {
            	                            position = 0;
            	                        }
            	                }
            	            });
            	        }
            	        }, 0, 2500);
                return new ImageView(MainActivity.this);
            } 
        });
		
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        imageSwitcher.setInAnimation(fadeIn);
        imageSwitcher.setOutAnimation(fadeOut); 
    }


    public class CounterClass extends CountDownTimer{
    	public CounterClass(long millisInFuture,long countDownInterval){
    		super(millisInFuture, countDownInterval);
    	}
    	
    	
    	public void onTick(long millisUtilFinished){
    		
    		  long millis = millisUtilFinished;
    		//data time 
//    		  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//    		  	String time = sdf.format(new Date(System.currentTimeMillis()));
    		//  settext(View Eliment)
    		/// time back  	
    		  String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
    				  TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
    				  TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
    		  System.out.println(hms);
    		  
    		  textTime.setText(hms);
    	}
    	
    	public void onFinish(){
    		textTime.setText("Complete");
    	} 
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
		case R.id.account:
			accountIrem();
			break;
		case R.id.rules:
			rulesItem();
			break;
		case R.id.about_as:
			aboutItem();
			break;
		case R.id.quit:
			finish();
			System.exit(0);
			break;

		}
        return true;
    }
    private void accountIrem(){
    	new AlertDialog.Builder(this)
    	.setTitle("Account")
    	//.setIcon(drawable.ic_dialog_info);
    	.setMessage("Good Luck")
    	.setNeutralButton("Close", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
			}
		}).show();
    }
    private void rulesItem(){
    	new AlertDialog.Builder(this)
    	.setTitle("Rules")
    	//.setIcon(drawable.ic_dialog_info);
    	.setMessage("The lyrics describe a metaphor for survival of the fittest in the animal kingdom, but applied to today's society. Raiden is portrayed as the weak prey (smaller physical size), and Metal Gear RAY as the strong predator or hunter (through sheer size, military equipment and power), showing that force alone does not guarantee victory and that victory can be won through ingenuity. The ")
    	.setNeutralButton("Close", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
			}
		}).show();
    }
    
    
    private void aboutItem(){
    	new AlertDialog.Builder(this)
    	.setTitle("About")
    	//.setIcon(drawable.ic_dialog_info);
    	.setMessage("This IS TEST Programming program From Andrey")
    	.setNeutralButton("Close", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
			}
		}).show();
    }

}
