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

import android.view.View;
import android.view.ViewGroup;

/**
 * Base Builder for all of the form items (except for line and space)
 * @author Julien Guerinet
 * @since 2.0.0
 */
abstract class FormItem extends LineItem {
	/**
	 * The form item {@link View}
	 */
	protected final View view;

	/**
	 * Default Constructor
	 *
	 * @param fg         The {@link FormGenerator} instance
	 * @param view       The {@link View}
     * @param background True if the default background should be applied, false otherwise
	 */
	public FormItem(FormGenerator fg, View view, boolean background) {
		super(view.findViewById(R.id.fg_line), fg);
		this.view = view;

		this.fg.container.addView(this.view);

		//Set the default background
        if (background && this.fg.builder.defaultBackgroundId != null) {
			background(this.fg.builder.defaultBackgroundId);
		}
	}

	/**
	 * Sets the background
	 *
	 * @param backgroundId The background Id
	 * @return The {@link FormItem} instance
	 */
	public FormItem background(int backgroundId) {
		view.setBackgroundResource(backgroundId);
		return this;
	}

    /**
     * Sets the {@link ViewGroup.LayoutParams} for this view
     *
     * @param params The {@link ViewGroup.LayoutParams} to set
     * @return The {@link FormItem} instance
     */
    public FormItem layoutParams(ViewGroup.LayoutParams params) {
        view.setLayoutParams(params);
        return this;
    }

	/**
	 * @return The {@link View}
	 */
    @Override
	public View view() {
		return view;
	}
}
