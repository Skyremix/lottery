package com.example.thelotter;

import java.util.LinkedList;

import com.example.thelotter.R.drawable;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityKeys extends Activity {

	class Layout {
		public Layout() {
			key11 = find(R.id.key11);
			key21 = find(R.id.key21);
			key31 = find(R.id.key31);
			key41 = find(R.id.key41);

			key12 = find(R.id.key12);
			key22 = find(R.id.key22);
			key32 = find(R.id.key32);
			key42 = find(R.id.key42);

			key13 = find(R.id.key13);
			key23 = find(R.id.key23);
			key33 = find(R.id.key33);
			key43 = find(R.id.key43);

			key14 = find(R.id.key14);
			key24 = find(R.id.key24);
			key34 = find(R.id.key34);
			key44 = find(R.id.key44);

			key15 = find(R.id.key15);
			key25 = find(R.id.key25);
			key35 = find(R.id.key35);
			key45 = find(R.id.key45);

			key16 = find(R.id.key16);
			key26 = find(R.id.key26);
			key36 = find(R.id.key36);
			key46 = find(R.id.key46);

			key17 = find(R.id.key17);
			key27 = find(R.id.key27);
			key37 = find(R.id.key37);
			key47 = find(R.id.key47);

			key18 = find(R.id.key18);
			key28 = find(R.id.key28);
			key38 = find(R.id.key38);
			key48 = find(R.id.key48);

			key19 = find(R.id.key19);
			key29 = find(R.id.key29);
			key39 = find(R.id.key39);
			key49 = find(R.id.key49);

			key110 = find(R.id.key110);
			key210 = find(R.id.key210);
			key310 = find(R.id.key310);
			key410 = find(R.id.key410);

			key111 = find(R.id.key111);
			key211 = find(R.id.key211);
			key311 = find(R.id.key311);
			key411 = find(R.id.key411);

			key112 = find(R.id.key112);
			key212 = find(R.id.key212);
			key312 = find(R.id.key312);
			key412 = find(R.id.key412);
		}

		Button find(int id) {
			return (Button) findViewById(id);
		}

		Button key11, key21, key31, key41;
		Button key12, key22, key32, key42;
		Button key13, key23, key33, key43;
		Button key14, key24, key34, key44;

		Button key15, key25, key35, key45;
		Button key16, key26, key36, key46;
		Button key17, key27, key37, key47;
		Button key18, key28, key38, key48;

		Button key19, key29, key39, key49;
		Button key110, key210, key310, key410;
		Button key111, key211, key311, key411;
		Button key112, key212, key312, key412;

	}

	class Events {
		public Events() {
			click(l.key11);
			click(l.key21);
			click(l.key31);
			click(l.key41);
			click(l.key12);
			click(l.key22);
			click(l.key32);
			click(l.key42);
			click(l.key13);
			click(l.key23);
			click(l.key33);
			click(l.key44);
			click(l.key14);
			click(l.key24);
			click(l.key34);
			click(l.key44);

			click(l.key15);
			click(l.key25);
			click(l.key35);
			click(l.key45);
			click(l.key16);
			click(l.key26);
			click(l.key36);
			click(l.key46);
			click(l.key17);
			click(l.key27);
			click(l.key37);
			click(l.key47);
			click(l.key18);
			click(l.key28);
			click(l.key38);
			click(l.key48);

			click(l.key19);
			click(l.key29);
			click(l.key39);
			click(l.key49);
			click(l.key110);
			click(l.key210);
			click(l.key310);
			click(l.key410);
			click(l.key111);
			click(l.key211);
			click(l.key311);
			click(l.key411);
			click(l.key112);
			click(l.key212);
			click(l.key312);
			click(l.key412);

		}

		void click(Button card) {
			card.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View f) {
					// flipOn();

					addNumberToTextView((Button) f);
				}
			});
		}
	}

	Layout l;
	Events e;
	Button first;
	int count;

	LinkedList<TextView> arrayTextView;
	int postion = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_keys);

		arrayTextView = new LinkedList<TextView>();

		arrayTextView.add((TextView) findViewById(R.id.txtview1));
		arrayTextView.add((TextView) findViewById(R.id.txtview2));
		arrayTextView.add((TextView) findViewById(R.id.txtview3));
		arrayTextView.add((TextView) findViewById(R.id.txtview4));
		arrayTextView.add((TextView) findViewById(R.id.txtview5));
		arrayTextView.add((TextView) findViewById(R.id.txtview6));

		l = new Layout();
		e = new Events();

		flipAllCards(); // function call

		Button btnRefrseh = (Button) findViewById(R.id.btnRefresh);
		btnRefrseh.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ActivityKeys.this,
						ActivityKeys.class);
				startActivity(intent);
			}
		});

		Button btnBack = (Button) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ActivityKeys.this,
						MainActivity.class);
				startActivity(intent);
			}
		});
	}

	void addNumberToTextView(Button card) {

		if (postion < 6) {
			card.setBackgroundResource(drawable.selector_onkey);
			count++;
			card.setTextColor(Color.WHITE);
			card.setTextSize(16);
			card.setEnabled(false);

			int number = Integer.parseInt(card.getText().toString());
			TextView tv = arrayTextView.get(postion);
			tv.setText("" + number);
			postion++;
		} else {
			flipOn();
		}
	}

	void view() {

	}

	void flipAllCards() // function declaration
	{
		count = 0;

	}

	void flipOn() {

		new AlertDialog.Builder(this)
				.setTitle("Good luck dear customer")

				.setMessage(
						"This IS TEST Programming program From Andrey(Free using and no maney )")

				.setNegativeButton("Close",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						})

				.setNeutralButton("Sign in",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub

							}
						}).show();

	}

	// void cardHide(Button card)
	// {
	// card.setVisibility(View.INVISIBLE);
	// }
	//
}
