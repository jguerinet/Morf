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

/**
 * The base class for all items that could be present on a form
 * @author Julien Guerinet
 * @since 2.0.0
 */
abstract class Item {
	/**
	 * The {@link FormGenerator} instance
	 */
	protected FormGenerator fg;

	/**
	 * Default Constructor
	 *
	 * @param fg The {@link FormGenerator} instance
	 */
	protected Item(FormGenerator fg) {
		this.fg = fg;
	}

	/**
	 * @return The {@link View}
	 */
	public abstract View view();
}
