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
import android.view.View;

/**
 * Builder for a space.
 * @author Julien Guerinet
 * @version 2.0.0
 * @since 2.0.0
 */
public class SpaceItem extends Item {
	/**
	 * The space {@link View}
	 */
	private View mSpace;

	/***
	 * Default Constructor
	 *
	 * @param fg    The {@link FormGenerator} instance
	 * @param space The space {@link View}
	 */
	public SpaceItem(FormGenerator fg, View space){
		super(fg);
		mSpace = space;

		mFG.mContainer.addView(mSpace);

		size(mFG.mDefaultSpaceSize);
	}

	/**
	 * Sets the space size
	 *
	 * @param pixels The space size, in pixels
	 * @return The {@link SpaceItem} instance
	 */
	public SpaceItem size(int pixels){
		mSpace.getLayoutParams().height = pixels;
		return this;
	}

	/**
	 * Sets the space size
	 *
	 * @param sizeDimen The space size dimension Id
	 * @return The {@link SpaceItem} instance
	 */
	public SpaceItem sizeDimen(@DimenRes int sizeDimen){
		return size(mSpace.getResources().getDimensionPixelSize(sizeDimen));
	}

	@Override
	public View view(){
		return mSpace;
	}
}
