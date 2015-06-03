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
	 * The default icon color, 0 if none
	 */
	private int mDefaultIconColor = 0;
	/**
	 * The default background drawable, 0 if none
	 */
	private int mBackgroundDrawable = 0;
}
