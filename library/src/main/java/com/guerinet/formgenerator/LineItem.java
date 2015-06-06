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

import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.view.View;

/**
 * Builder for a line. Base class for all classes
 * @author Julien Guerinet
 * @version 2.0.0
 * @since 2.0.0
 */
public class LineItem {
	/**
	 * The line {@link View}
	 */
	private View mLine;
	/**
	 * The {@link FormGenerator} instance
	 */
	protected FormGenerator mFG;

	/**
	 * Default Constructor
	 *
	 * @param fg       The {@link FormGenerator} instance
	 * @param line     The line {@link View}
	 * @param showLine True if the line should be shown, false otherwise
	 */
	public LineItem(FormGenerator fg, View line, boolean showLine){
		mLine = line;
		mFG = fg;

		if(mLine != null){
			visibility(showLine);
			lineSize(mFG.mDefaultLineSize);
			lineColor(mFG.mDefaultLineColorId);
		}
	}

	/**
	 * Sets the line size
	 *
	 * @param pixels The line size, in pixels
	 * @return The {@link LineItem} instance
	 */
	public LineItem lineSize(int pixels){
		mLine.getLayoutParams().height = pixels;
		return this;
	}

	/**
	 * Sets the line size
	 *
	 * @param sizeDimen The line size dimension Id
	 * @return The {@link LineItem} instance
	 */
	public LineItem lineSizeDimen(@DimenRes int sizeDimen){
		return lineSize(mLine.getResources().getDimensionPixelSize(sizeDimen));
	}

	/**
	 * Sets the line color
	 *
	 * @param colorId The color Id
	 * @return The {@link LineItem} instance
	 */
	public LineItem lineColor(@DrawableRes int colorId){
		mLine.setBackgroundResource(colorId);
		return this;
	}

	/**
	 * Builds the {@link View} and adds it to the container
	 *
	 * @return The {@link View}
	 */
	public View build(){
		mFG.mContainer.addView(mLine);
		return mLine;
	}

	/* HELPERS */

	/**
	 * Sets the line visibility
	 *
	 * @param show True if the line should be visible, false otherwise
	 */
	protected void visibility(boolean show){
		mLine.setVisibility(show ? View.VISIBLE : View.GONE);
	}
}