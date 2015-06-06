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
import android.graphics.Typeface;
import android.support.annotation.ColorRes;
import android.view.LayoutInflater;
import android.view.View;
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
	LinearLayout mContainer;
	/**
	 * The default icon color Id, 0 if none
	 */
	int mDefaultIconColorId;
	/**
	 * The default background Id, null if none
	 */
	Integer mDefaultBackgroundId;
	/**
	 * The default background Id for the input item, null if none
	 */
	Integer mDefaultInputBackgroundId;
	/**
	 * The default space size, 10dp if none
	 */
	private int mDefaultSpaceSize;
	/**
	 * The default text size, 14dp if none
	 */
	int mDefaultTextSize;
	/**
	 * The default text color Id, black if none
	 */
	int mDefaultTextColorId;
	/**
	 * The default typeface to use, null if none
	 */
	Typeface mDefaultTextTypeface;
	/**
	 * The default text color state list, 0 if none
	 */
	int mDefaultTextColorStateListId;
	/**
	 * The default padding size for the non-space/line items, 8dp if none
	 */
	int mDefaultPaddingSize;
	/**
	 * The default line size, 0.5 dp if none
	 */
	int mDefaultLineSize;
	/**
	 * The default line color Id, #EEEEEE if none
	 */
	int mDefaultLineColorId;
	/**
	 * True if we should show a line after a form item, false otherwise (defaults to true)
	 */
	boolean mShowLine;

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
	 * Sets the default instance of the {@link FormGenerator} to use when
	 *  {@link #get(Context, LinearLayout)} or {@link #get(LayoutInflater, LinearLayout)} is called
	 *
	 * @param fg The default {@link FormGenerator instance to use}
	 */
	public static void setInstance(FormGenerator fg){
		singleton = fg;
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
		mDefaultInputBackgroundId = builder.mDefaultInputBackgroundId;
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
	 *
	 * @return The {@link LineItem}
	 */
	public LineItem line(){
		return new LineItem(this, mInflater.inflate(R.layout.fg_line, mContainer, false));
	}

	/**
	 * Adds an input item
	 *
	 * @param text The text
	 * @return The {@link EditTextFormItem}
	 */
	public EditTextFormItem input(String text){
		return new EditTextFormItem(this, mInflater.inflate(R.layout.fg_input, mContainer, false),
				text);
	}

	/**
	 * Adds a text item
	 *
	 * @param text The text
	 * @return The {@link TextViewFormItem}
	 */
	public TextViewFormItem text(String text){
		View view = mInflater.inflate(R.layout.fg_text, mContainer, false);
		return new TextViewFormItem(this, view, (TextView)view.findViewById(R.id.fg_text), text);
	}

	/**
	 * Adds a standard button
	 *
	 * @param text     The text
	 * @param listener The {@link View.OnClickListener}
	 * @return The {@link TextViewFormItem}
	 */
	public ButtonFormItem button(String text, View.OnClickListener listener){
		return new ButtonFormItem(this, mInflater.inflate(R.layout.fg_button, mContainer, false),
				text, listener);
	}

	/**
	 * Adds a switch item
	 *
	 * @param text The text
	 * @return The {@link SwitchFormItem}
	 */
	public SwitchFormItem aSwitch(String text){
		return new SwitchFormItem(this, mInflater.inflate(R.layout.fg_switch, mContainer, false),
				text);
	}

	/**
	 * The Form Generator builder
	 */
	public static class Builder {
		private LayoutInflater mInflater;
		private LinearLayout mContainer;
		private int mDefaultIconColorId = 0;
		private Integer mDefaultBackgroundId = null;
		private Integer mDefaultInputBackgroundId = null;
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
		 * Sets the default background for the input fields
		 *
		 * @param backgroundId The background resource Id (can be a color or drawable)
		 * @return The {@link Builder} instance
		 */
		public Builder setInputDefaultBackground(int backgroundId){
			mDefaultInputBackgroundId = backgroundId;
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
