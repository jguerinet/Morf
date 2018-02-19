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

import android.support.annotation.StringRes;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.ListAdapter;

/**
 * Builder for an text input form item that has an autcomplete option
 * @author Julien Guerinet
 * @since 3.0.0
 */
public class AutoCompleteTextInputFormItem extends TextInputFormItem {
    /**
     * {@link TextInputLayout} instance
     */
    private final TextInputLayout inputLayout;
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
        inputLayout = view.findViewById(R.id.fg_input_layout);
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

    /**
     * @param show True if the password visibility toggle should be shown, false otherwise
     * @return {@link AutoCompleteTextInputFormItem} instance
     */
    @Override
    public AutoCompleteTextInputFormItem showTogglePasswordVisibility(boolean show) {
        return (AutoCompleteTextInputFormItem) super.showTogglePasswordVisibility(show);
    }

	/**
	 * Sets the input type for the {@link EditText}
	 *
	 * @param type The input type
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
    @Override
	public AutoCompleteTextInputFormItem inputType(int type) {
        return (AutoCompleteTextInputFormItem) super.inputType(type);
	}

	/**
	 * Sets the {@link EditText} background
	 *
	 * @param backgroundId The background Id
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
    @Override
	public AutoCompleteTextInputFormItem inputBackground(int backgroundId) {
        return (AutoCompleteTextInputFormItem) super.inputBackground(backgroundId);
	}

	/**
	 * Sets the {@link Button} hint
	 *
	 * @param hint The hint
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem hint(String hint) {
        inputLayout.setHint(hint);
        return this;
	}

	/**
	 * Sets the {@link Button} hint
	 *
	 * @param stringId The String Id
	 * @return The {@link AutoCompleteTextInputFormItem} instance
	 */
	@Override
	public AutoCompleteTextInputFormItem hint(@StringRes int stringId) {
        return hint(inputLayout.getContext().getString(stringId));
	}
}
