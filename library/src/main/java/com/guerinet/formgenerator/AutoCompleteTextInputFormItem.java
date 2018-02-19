/*
 * Copyright 2015-2018 Julien Guerinet
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
import android.widget.AutoCompleteTextView;
import android.widget.Filterable;
import android.widget.ListAdapter;

import com.guerinet.fg.TextInputItem;

/**
 * Builder for an text input form item that has an autcomplete option
 * @author Julien Guerinet
 * @since 3.0.0
 */
public class AutoCompleteTextInputFormItem extends TextInputItem {

    /**
     * The AutoCompleteTextView instance
     */
    private final AutoCompleteTextView acTextView;

	/**
	 * Default Constructor
	 *
	 * @param fg   The {@link FormGenerator} instance
	 * @param view The {@link View}
	 */
    AutoCompleteTextInputFormItem(FormGenerator fg, View view) {
		super(fg, view);
        acTextView = (AutoCompleteTextView) getChildView();
    }

    /**
     * @param adapter Adapter to set on the AutoCompleteTextView
     * @param <T> Adapter type (must extend ListAdapter and Filterable)
     * @return {@link AutoCompleteTextInputFormItem}
     */
    public <T extends ListAdapter & Filterable> AutoCompleteTextInputFormItem setAdapter(
            T adapter) {
        acTextView.setAdapter(adapter);
        return this;
    }

    /**
     * @param threshold Number of characters that need to be typed before the options are displayed
     * @return {@link AutoCompleteTextInputFormItem} instance
     */
    public AutoCompleteTextInputFormItem setThreshold(int threshold) {
        // If the threshold is 0, set an OnTouchListener to open the list when clicked
        if (threshold == 0) {
            acTextView.setThreshold(1);
            acTextView.setOnTouchListener((v, event) -> {
                acTextView.showDropDown();
                return false;
            });
        } else {
            acTextView.setThreshold(threshold);
        }
        return this;
    }
}
