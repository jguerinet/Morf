/*
 * Copyright 2015-2016 Julien Guerinet
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

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.view.View;

/**
 * Builder for a line. Base class for all classes
 * @author Julien Guerinet
 * @since 2.0.0
 */
public class LineItem extends Item {
	/**
	 * The line {@link View}
	 */
	private final View line;

	/**
	 * Default Constructor
	 *
	 * @param line     The line {@link View}
	 * @param fg       The {@link FormGenerator} instance
	 */
	protected LineItem(View line, FormGenerator fg) {
		super(fg);
		this.line = line;

        if (this.line != null) {
			showLine(this.fg.builder.showLine);
			lineSize(this.fg.builder.defaultLineSize);
			lineColor(this.fg.builder.defaultLineColorId);
		}
	}

	/**
	 * Constructor for the independent lines
	 *
	 * @param fg   The {@link FormGenerator}
	 * @param line The line {@link View}
	 */
	public LineItem(FormGenerator fg, View line) {
		super(fg);
		this.line = line;

		this.fg.container.addView(this.line);

		showLine(true);
		lineSize(this.fg.builder.defaultLineSize);
		lineColor(this.fg.builder.defaultLineColorId);
	}

	/**
	 * Sets the line size
	 *
	 * @param pixels The line size, in <strong>pixels</strong>
	 * @return The {@link LineItem} instance
	 */
	public LineItem lineSize(int pixels) {
        line.getLayoutParams().height = pixels;
        return this;
	}

	/**
	 * Sets the line color
	 *
	 * @param colorId The color Id
	 * @return The {@link LineItem} instance
	 */
	public LineItem lineColor(@DrawableRes @ColorRes int colorId) {
		line.setBackgroundResource(colorId);
		return this;
	}

	/**
	 * Sets the line visibility
	 *
	 * @param show True if the line should be visible, false otherwise
	 * @return The {@link LineItem} instance
	 */
	public LineItem showLine(boolean show) {
		line.setVisibility(show ? View.VISIBLE : View.GONE);
		return this;
	}

	@Override
	public View view() {
		return line;
	}
}
