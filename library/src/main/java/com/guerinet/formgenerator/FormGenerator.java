/*
 * Copyright 2015 Julien Guerinet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.guerinet.formgenerator;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Creates various form items and adds them to a given container
 * @author Julien Guerinet
 * @version 1.0.0
 * @since 1.0.0
 */
public class FormGenerator {
	/**
	 * The singleton instance of the default {@link FormGenerator}
	 */
	private static FormGenerator singleton = null;
	/* SETTINGS */
	/**
	 * The {@link LayoutInflater}
	 */
	private LayoutInflater mInflater;
	/**
	 * The {@link LinearLayout} used as the form container
	 */
	private LinearLayout mContainer;
	/**
	 * The default icon color Id, 0 if none
	 */
	private int mDefaultIconColorId;
	/**
	 * The default background Id, 0 if none
	 */
	private int mDefaultBackgroundId;
	/**
	 * The default space size, 10dp if none
	 */
	private int mDefaultSpaceSize;
	/**
	 * The default text size, 14dp if none
	 */
	private int mDefaultTextSize;
	/**
	 * The default text color Id, black if none
	 */
	private int mDefaultTextColorId;
	/**
	 * The default typeface to use, null if none
	 */
	private Typeface mDefaultTextTypeface;
	/**
	 * The default text color state list, 0 if none
	 */
	private int mDefaultTextColorStateListId;
	/**
	 * The default padding size for the non-space/line items, 8dp if none
	 */
	private int mDefaultPaddingSize;
	/**
	 * The default line size, 0.5 dp if none
	 */
	private int mDefaultLineSize;
	/**
	 * The default line color Id, #EEEEEE if none
	 */
	private int mDefaultLineColorId;
	/**
	 * True if we should show a line after a form item, false otherwise (defaults to true)
	 */
	private boolean mShowLine;

	/**
	 * Returns the default {@link FormGenerator}. This will use either the default generator set
	 *  by the user, or a generator with the default values
	 *
	 * @param inflater  The {@link LayoutInflater}
	 * @param container The container that the items should be in
	 * @return The default {@link FormGenerator}
	 */
	public static FormGenerator get(LayoutInflater inflater, LinearLayout container){
		//No singleton set, build from the default settings
		if(singleton == null){
			singleton = new Builder(inflater, container).build();
		}
		//Singleton set: Update the inflater and the container
		else{
			singleton.mInflater = inflater;
			singleton.mContainer = container;
		}
		return singleton;
	}

	/**
	 * Returns the default {@link FormGenerator}. This will use either the default generator set
	 *  by the user, or a generator with the default values
	 *
	 * @param context   The {@link LayoutInflater}
	 * @param container The container that the items should be in
	 * @return The default {@link FormGenerator}
	 */
	public static FormGenerator get(Context context, LinearLayout container){
		return get(LayoutInflater.from(context), container);
	}

	/**
	 * Default Constructor
	 *
	 * @param builder The {@link Builder} instance to construct the {@link FormGenerator} from
	 */
	private FormGenerator(Builder builder){
		mInflater = builder.mInflater;
		mContainer = builder.mContainer;
		mDefaultIconColorId = builder.mDefaultIconColorId;
		mDefaultBackgroundId = builder.mDefaultBackgroundId;
		mDefaultSpaceSize = builder.mDefaultSpaceSize;
		mDefaultTextSize = builder.mDefaultTextSize;
		mDefaultTextColorId = builder.mDefaultTextColorId;
		mDefaultTextColorStateListId = builder.mDefaultTextColorStateListId;
		mDefaultTextTypeface = builder.mDefaultTextTypeface;
		mDefaultPaddingSize = builder.mDefaultPaddingSize;
		mDefaultLineSize = builder.mDefaultLineSize;
		mDefaultLineColorId = builder.mDefaultLineColorId;
		mShowLine = builder.mShowLine;
	}

	/**
	 * Adds a space
	 */
	public void space(){
		View space = mInflater.inflate(R.layout.fg_space, mContainer, false);
		space.getLayoutParams().height = mDefaultSpaceSize;

		mContainer.addView(space);
	}

	/**
	 * Adds a line
	 */
	public void line(){
		View line = mInflater.inflate(R.layout.fg_line, mContainer, false);

		//Process it
		line(line, false);

		mContainer.addView(line);
	}

	/**
	 * Adds an input field with a left icon
	 *
	 * @param text        The input text
	 * @param hint        The input hint
	 * @param iconId      The Id of the icon to use
	 * @param iconVisible True if the icon should be visible, false otherwise
	 * @return The {@link EditText} where the user will be inputting
	 */
	public EditText input(String text, String hint, int iconId, boolean iconVisible){
		View inputField = mInflater.inflate(R.layout.fg_input, mContainer, false);
		line(inputField);
		background(inputField);

		EditText input = (EditText) inputField.findViewById(R.id.fg_input);
		textView(input, text, hint, iconId, 0, iconVisible);

		mContainer.addView(inputField);

		return input;
	}

	/**
	 * Adds a text box with left/right icons
	 *
	 * @param text        The text to show
	 * @param hint        The hint to show if there is no text
	 * @param leftIconId  The Id for the left icon, 0 if none
	 * @param rightIconId The Id for the right icon, 0 if none (used for chevrons)
	 * @param iconVisible True if the icon should be visible, false otherwise
	 * @return The {@link TextView}
	 */
	public TextView text(String text, String hint, int leftIconId, int rightIconId,
			boolean iconVisible){
		View textField = mInflater.inflate(R.layout.fg_text, mContainer, false);
		line(textField);
		background(textField);

		//Text
		TextView title = (TextView)textField.findViewById(R.id.fg_title);
		textView(title, text, hint, leftIconId, rightIconId, iconVisible);

		//Set the button to not clickable
		textField.setClickable(false);

		mContainer.addView(textField);

		return title;
	}

	/**
	 * Adds a button box with left/right icons
	 *
	 * @param text        The button text to show
	 * @param hint        The hint to show if there is no text
	 * @param leftIconId  The Id for the left icon, 0 if none
	 * @param rightIconId The Id for the right icon, 0 if none
	 * @param iconVisible True if the icon should be visible, false otherwise
	 * @param listener    The {@link OnClickListener} to call if the button is pressed
	 * @return The {@link TextView}
	 */
	public TextView button(String text, String hint, int leftIconId, int rightIconId,
			boolean iconVisible, OnClickListener listener){
		TextView title = text(text, hint, leftIconId, rightIconId, iconVisible);

		//Set the OnClickListener on the parent
		((View)title.getParent()).setOnClickListener(listener);

		return title;
	}

	/**
	 * Adds a standard {@link Button} (centered capitalized text)
	 *
	 * @param title    The button title
	 * @param listener The {@link OnClickListener} to call when the button is clicked
	 * @return The {@link Button}
	 */
	public Button button(String title, OnClickListener listener){
		Button button = (Button)mInflater.inflate(R.layout.fg_button, mContainer, false);
		background(button);

		textView(button, title, "", 0, 0, true);
		button.setOnClickListener(listener);

		mContainer.addView(button);

		return button;
	}

	/**
	 * Adds a {@link SwitchCompat} with the given title
	 *
	 * @param title       The title of the field
	 * @param leftIconId  The Id of the left icon, 0 if none
	 * @param iconVisible True if the left icon should be visible, false otherwise
	 * @return The {@link SwitchCompat}
	 */
	public SwitchCompat aSwitch(String title, int leftIconId, boolean iconVisible){
		View aSwitch = mInflater.inflate(R.layout.fg_switch, mContainer, false);
		background(aSwitch);
		line(aSwitch);

		SwitchCompat switchField = (SwitchCompat)aSwitch.findViewById(R.id.fg_switch);
		textView(switchField, title, "", leftIconId, 0, iconVisible);

		mContainer.addView(aSwitch);

		return switchField;
	}

	/* HELPERS */

	/**
	 * Sets up the given {@link TextView}
	 *
	 * @param textView    The {@link TextView}
	 * @param text        The text
	 * @param hint        The hint
	 * @param leftIconId  The left icon Id
	 * @param rightIconId The right icon Id
	 * @param iconVisible True if the left icon should be visible, false otherwise
	 */
	private void textView(TextView textView, String text, String hint, int leftIconId,
			int rightIconId, boolean iconVisible){
		//Text
		textView.setHint(hint);
		textView.setText(text);

		//Text Color
		if(mDefaultTextColorStateListId != 0){
			textView.setTextColor(textView.getResources()
					.getColorStateList(mDefaultTextColorStateListId));
		}
		else{
			textView.setTextColor(textView.getResources().getColor(mDefaultTextColorId));
		}

		//Text Size
		textView.setTextSize(mDefaultTextSize);

		//Padding
		textView.setPadding(mDefaultPaddingSize, mDefaultPaddingSize, mDefaultPaddingSize,
				mDefaultPaddingSize);

		//Typeface
		if(mDefaultTextTypeface != null){
			textView.setTypeface(mDefaultTextTypeface);
		}

		//Icons
		textView.setCompoundDrawablesWithIntrinsicBounds(leftIconId, 0, rightIconId, 0);
		icon(textView);
		if(leftIconId != 0){
			textView.getCompoundDrawables()[0].setAlpha(iconVisible ? 255 : 0);
		}
	}

	/**
	 * Colors the {@link TextView} compound icons with the default icon color if there is one
	 * @param textView The {@link TextView}
	 */
	private void icon(TextView textView){
		if(mDefaultIconColorId != 0){
			//Get the color
			int color = textView.getResources().getColor(mDefaultIconColorId);

			for(int i = 0; i < 4; i ++){
				//Apply it to the compound drawable at the given position
				Drawable drawable = textView.getCompoundDrawables()[i];
				if(drawable != null){
					drawable.mutate().setColorFilter(
							new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
				}
			}
		}
	}

	/**
	 * Sets the background resource on the given view if there is one
	 *
	 * @param view The {@link View}
	 */
	private void background(View view){
		if(mDefaultBackgroundId != 0){
			view.setBackgroundResource(mDefaultBackgroundId);
		}
	}

	/**
	 * Sets the default line size and/or color on the given view
	 *
	 * @param view     The {@link View} containing the line
	 * @param hideLine True if we should hide the line if requested, false if shown regardless
	 */
	private void line(View view, boolean hideLine){
		//Find the line
		View line = view.findViewById(R.id.fg_line);
		if(line != null){
			//Hide the line if needed
			if(hideLine && !mShowLine){
				line.setVisibility(View.GONE);
				return;
			}
			line.getLayoutParams().height = mDefaultLineSize;
			line.setBackgroundResource(mDefaultLineColorId);
		}
	}

	/**
	 * Sets the line parameters for the given {@link View}
	 *
	 * @param view The {@link View}
	 */
	private void line(View view){
		line(view, mShowLine);
	}

	/**
	 * The Form Generator builder
	 */
	public static class Builder {
		private LayoutInflater mInflater;
		private LinearLayout mContainer;
		private int mDefaultIconColorId = 0;
		private int mDefaultBackgroundId = 0;
		private int mDefaultSpaceSize;
		private int mDefaultTextSize;
		private int mDefaultTextColorId = android.R.color.black;
		private int mDefaultTextColorStateListId = 0;
		private Typeface mDefaultTextTypeface = null;
		private int mDefaultPaddingSize;
		private int mDefaultLineSize;
		private int mDefaultLineColorId = R.color.line;
		private boolean mShowLine = true;

		/**
		 * Default Constructor
		 *
		 * @param inflater  The {@link LayoutInflater}
		 * @param container The container to put all of the generated form items in
		 */
		public Builder(LayoutInflater inflater, LinearLayout container){
			mInflater = inflater;
			mContainer = container;

			//Set the default sizes
			mDefaultSpaceSize = mInflater.getContext().getResources()
					.getDimensionPixelSize(R.dimen.space);
			mDefaultPaddingSize = mInflater.getContext().getResources()
					.getDimensionPixelSize(R.dimen.padding);
			mDefaultLineSize = mInflater.getContext().getResources()
					.getDimensionPixelSize(R.dimen.line);
			mDefaultTextSize = mInflater.getContext().getResources()
					.getDimensionPixelSize(R.dimen.text);
		}

		/**
		 * Constructor that uses a {@link Context} to get the {@link LayoutInflater}
		 *
		 * @param context   The app {@link Context}
		 * @param container The container to put all of the generated form items in
		 */
		public Builder(Context context, LinearLayout container){
			this(LayoutInflater.from(context), container);
		}

		/**
		 * Builds a {@link FormGenerator} based off of this {@link Builder}
		 *
		 * @return The created {@link FormGenerator} instance
		 */
		public FormGenerator build(){
			return new FormGenerator(this);
		}

		/**
		 * Sets the default icon color
		 *
		 * @param colorId The color resource Id
		 * @return The {@link Builder} instance
		 */
		@ColorRes
		public Builder setDefaultIconColorId(int colorId){
			mDefaultIconColorId = colorId;
			return this;
		}

		/**
		 * Sets the default background
		 *
		 * @param backgroundId The background resource Id (can be a color or a drawable)
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultBackground(int backgroundId){
			mDefaultBackgroundId = backgroundId;
			return this;
		}

		/**
		 * Sets the default space size
		 *
		 * @param dimenId The dimension Id (in dp)
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultSpaceDimen(int dimenId){
			mDefaultSpaceSize = mInflater.getContext().getResources()
					.getDimensionPixelSize(dimenId);
			return this;
		}

		/**
		 * Sets the default space size
		 *
		 * @param pixels The space size in pixels
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultSpaceSize(int pixels){
			mDefaultSpaceSize = pixels;
			return this;
		}

		/**
		 * Sets the default text size
		 *
		 * @param dimenId The dimension Id (in dp)
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultTextDimen(int dimenId){
			mDefaultTextSize = mInflater.getContext().getResources().getDimensionPixelSize(dimenId);
			return this;
		}

		/**
		 * Sets the default text size
		 *
		 * @param pixels The text size in pixels
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultTextSize(int pixels){
			mDefaultTextSize = pixels;
			return this;
		}

		/**
		 * Sets the default text color
		 *
		 * @param colorId   The color Id
		 * @param stateList True if this is a state list, false if it's a solid color
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultTextColorId(int colorId, boolean stateList){
			if(stateList){
				mDefaultTextColorStateListId = colorId;
			}
			else{
				mDefaultTextColorId = colorId;
			}
			return this;
		}

		/**
		 * Sets the default typeface for the text items
		 *
		 * @param typeface The {@link Typeface} to use
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultTypeface(Typeface typeface){
			mDefaultTextTypeface = typeface;
			return this;
		}

		/**
		 * Sets the default padding size
		 *
		 * @param dimenId The dimension Id (in dp)
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultPaddingDimen(int dimenId){
			mDefaultPaddingSize = mInflater.getContext().getResources()
					.getDimensionPixelSize(dimenId);
			return this;
		}

		/**
		 * Sets the default padding size
		 *
		 * @param pixels The padding size in pixels
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultPaddingSize(int pixels){
			mDefaultPaddingSize = pixels;
			return this;
		}

		/**
		 * Sets the default line size
		 *
		 * @param dimenId The dimension Id (in dp)
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultLineDimen(int dimenId){
			mDefaultLineSize = mInflater.getContext().getResources().getDimensionPixelSize(dimenId);
			return this;
		}

		/**
		 * Sets the default line size
		 *
		 * @param pixels The line size in pixels
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultLineSize(int pixels){
			mDefaultLineSize = pixels;
			return this;
		}

		/**
		 * Sets the default line color Id
		 *
		 * @param colorId The color resource Id
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultLineColorId(int colorId){
			mDefaultLineColorId = colorId;
			return this;
		}

		/**
		 * Sets if the line should be shown after a form item by default or not
		 *
		 * @param showLine True if a line should be shown after a form item, false otherwise
		 * @return The {@link Builder} instance
		 */
		public Builder setShowLine(boolean showLine){
			mShowLine = showLine;
			return this;
		}
	}
}
