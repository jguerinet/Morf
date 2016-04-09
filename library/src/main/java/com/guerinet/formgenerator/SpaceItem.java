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
 * Builder for a space.
 * @author Julien Guerinet
 * @since 2.0.0
 */
public class SpaceItem extends Item {
	/**
	 * The space {@link View}
	 */
	private final View space;

	/***
	 * Default Constructor
	 *
	 * @param fg    The {@link FormGenerator} instance
	 * @param space The space {@link View}
	 */
	public SpaceItem(FormGenerator fg, View space) {
		super(fg);
		this.space = space;

		this.fg.container.addView(this.space);

        if (this.fg.builder.defaultSpaceSize != -1) {
            size(this.fg.builder.defaultSpaceSize);
        }
        background(this.fg.builder.defaultSpaceColorId);
	}

	/**
	 * Sets the space size
	 *
	 * @param pixels The space size in <strong>pixels</strong>
	 * @return The {@link SpaceItem} instance
	 */
	public SpaceItem size(int pixels) {
		space.getLayoutParams().height = pixels;
		return this;
	}

	/**
	 * Sets the space color
	 *
	 * @param colorId The color Id
	 * @return The {@link SpaceItem} instance
	 */
	public SpaceItem background(@ColorRes @DrawableRes int colorId) {
		space.setBackgroundResource(colorId);
		return this;
	}

    /**
     * @return The space view
     */
    @Override
    public View view() {
        return space;
    }
}
