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
public class FormGenerator {;
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
	 * The default space size, 0 if none (defaults to 10dp)
	 */
	private int mDefaultSpaceSize;
	/**
	 * The default text color Id, 0 if none (defaults to black)
	 */
	private int mDefaultTextColorId;
	/**
	 * The default text color state list, 0 if none
	 */
	private int mDefaultTextColorStateList;
	/**
	 * The default padding size for the non-space/line items, 0 if none (defaults to 8dp)
	 */
	private int mDefaultPaddingSize;
	/**
	 * The default line size, 0 if none (defaults to 0.5 dp)
	 */
	private int mDefaultLineSize;
	/**
	 * The default line color Id, 0 if none (defaults to #EEEEEE)
	 */
	private int mDefaultLineColorId;

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
		mDefaultTextColorId = builder.mDefaultTextColorId;
		mDefaultTextColorStateList = builder.mDefaultTextColorStateList;
		mDefaultPaddingSize = builder.mDefaultPaddingSize;
		mDefaultLineSize = builder.mDefaultLineSize;
		mDefaultLineColorId = builder.mDefaultLineColorId;
	}

	/**
	 * Adds a space
	 */
	public void space(){
		View view = mInflater.inflate(R.layout.space, mContainer);
		//Set the height if there's a custom one
		if(mDefaultSpaceSize != 0){
			view.getLayoutParams().height = mDefaultSpaceSize;
		}
	}

	/* HELPERS */

	/**
	 * Colors the {@link TextView} icon at the given position with the default icon color if there
	 *  is one
	 * @param textView The {@link TextView}
	 * @param position The position of the compound drawable to color
	 */
	private void icon(TextView textView, int position){
		if(mDefaultIconColorId != 0){
			//Get the color
			int color = textView.getResources().getColor(mDefaultIconColorId);

			//Apply it to the compound drawable at the given position
			textView.getCompoundDrawables()[position].mutate().setColorFilter(
					new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
		}
	}

	/**
	 * Colors the {@link TextView} text with the default color or color state list if there is one
	 *
	 * @param textView The {@link TextView}
	 */
	private void textColor(TextView textView){
		if(mDefaultTextColorId != 0){
			textView.setTextColor(textView.getResources().getColor(mDefaultTextColorId));
		}
		else if(mDefaultTextColorStateList != 0){
			textView.setTextColor(textView.getResources()
					.getColorStateList(mDefaultTextColorStateList));
		}
	}

	/**
	 * Sets the {@link View} padding with the default padding if there is one
	 *
	 * @param view The {@link View}
	 */
	private void padding (View view){
		if(mDefaultPaddingSize != 0){
			view.setPadding(mDefaultPaddingSize, mDefaultPaddingSize, mDefaultPaddingSize,
					mDefaultPaddingSize);
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
	 * @param view The {@link View} containing the line
	 */
	private void line(View view){
		//If there is no default size nor color, no need to continue
		if(mDefaultLineSize == 0 && mDefaultLineColorId == 0){
			return;
		}

		//Find the line
		View line = view.findViewById(R.id.line);
		if(line != null){
			//Set the size if there is one
			if(mDefaultLineSize != 0){
				line.getLayoutParams().height = mDefaultLineSize;
			}
			//Set the color if there is one
			if(mDefaultLineColorId != 0){
				line.setBackgroundResource(mDefaultLineColorId);
			}
		}
	}

	/**
	 * The Form Generator builder
	 */
	public static class Builder {
		private LayoutInflater mInflater;
		private LinearLayout mContainer;
		private int mDefaultIconColorId = 0;
		private int mDefaultBackgroundId = 0;
		private int mDefaultSpaceSize = 0;
		private int mDefaultTextColorId = 0;
		private int mDefaultTextColorStateList = 0;
		private int mDefaultPaddingSize = 0;
		private int mDefaultLineSize = 0;
		private int mDefaultLineColorId = 0;

		/**
		 * Default Constructor
		 *
		 * @param inflater  The {@link LayoutInflater}
		 * @param container The container to put all of the generated form items in
		 */
		public Builder(LayoutInflater inflater, LinearLayout container){
			mInflater = inflater;
			mContainer = container;
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
		 * Sets the default icon color
		 *
		 * @param colorId The color resource Id
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultIconColor(int colorId){
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
		 * Sets the default text color
		 *
		 * @param colorId   The color Id
		 * @param stateList True if this is a state list, false if it's a solid color
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultTextColor(int colorId, boolean stateList){
			if(stateList){
				mDefaultTextColorStateList = colorId;
			}
			else{
				mDefaultTextColorId = colorId;
			}
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
	}
}
