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

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;

/**
 * Builder for a {@link SwitchCompat} form item
 * @author Julien Guerinet
 * @version 2.0.0
 * @since 2.0.0
 */
public class SwitchFormItem extends TextViewFormItem {
	/**
	 * The {@link SwitchCompat}
	 */
	private SwitchCompat mSwitch;

	/**
	 * Default Constructor
	 *
	 * @param fg   The {@link FormGenerator} instance
	 * @param view The {@link View}
	 * @param text The text
	 */
	public SwitchFormItem(FormGenerator fg, View view, String text){
		super(fg, view, text);
		mSwitch = (SwitchCompat)view.findViewById(R.id.fg_switch);
	}

	/**
	 * Sets the {@link SwitchCompat}'s checked state
	 *
	 * @param checked True if the {@link SwitchCompat} should be checked, false otherwise
	 * @return The {@link SwitchFormItem} instance
	 */
	public SwitchFormItem checked(boolean checked){
		mSwitch.setChecked(checked);
		return this;
	}

	/**
	 * Sets the {@link CompoundButton.OnCheckedChangeListener} on the {@link SwitchCompat}
	 *
	 * @param listener The {@link CompoundButton.OnCheckedChangeListener}
	 * @return The {@link SwitchFormItem} instance
	 */
	public SwitchFormItem onCheckChanged(CompoundButton.OnCheckedChangeListener listener){
		mSwitch.setOnCheckedChangeListener(listener);
		return this;
	}

	/**
	 * Builds the switch form item
	 *
	 * @return The {@link SwitchCompat}
	 */
	@Override
	public SwitchCompat build(){
		return mSwitch;
	}
}
