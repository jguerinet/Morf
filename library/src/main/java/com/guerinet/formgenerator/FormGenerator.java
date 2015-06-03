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
import android.view.LayoutInflater;
import android.widget.LinearLayout;

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
	 * The default icon color Id, 0 if none (icon default color is white)
	 */
	private int mDefaultIconColorId;
	/**
	 * The default background Id, 0 if none
	 */
	private int mDefaultBackgroundId;

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
	}

	/**
	 * The Form Generator builder
	 */
	public static class Builder {
		private LayoutInflater mInflater;
		private LinearLayout mContainer;
		private int mDefaultIconColorId = 0;
		private int mDefaultBackgroundId = 0;

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
	}
}
