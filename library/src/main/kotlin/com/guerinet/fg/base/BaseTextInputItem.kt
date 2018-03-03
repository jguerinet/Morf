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

package com.guerinet.fg.base

import android.support.design.widget.TextInputLayout
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import com.guerinet.fg.FormGenerator
import com.guerinet.fg.util.Layout

/**
 * Based form item for a [TextInputLayout]
 * @author Julien Guerinet
 * @since 3.0.0
 *
 * @param fg    [FormGenerator] instance
 * @param view  Item [View]
 */
@Suppress("UNCHECKED_CAST")
open class BaseTextInputItem<T : BaseTextInputItem<T, V>, V : EditText>(fg: FormGenerator, view: V)
    : BaseEditTextItem<T, V>(fg, view, false) {

    private val inputLayout = TextInputLayout(fg.container.context)

    init {
        inputLayout.layoutParams = LinearLayout.LayoutParams(Layout.MATCH_PARENT,
                Layout.WRAP_CONTENT)

        // Add the view to the input layout
        inputLayout.addView(view)
    }

    /**
     * @return Item with the password visibility toggle shown or not depending on [isEnabled]
     */
    fun showPasswordVisibilityToggle(isEnabled: Boolean): T {
        inputLayout.isPasswordVisibilityToggleEnabled = isEnabled
        return this as T
    }

    override fun hint(hint: String?): T {
        inputLayout.hint = hint
        return this as T
    }

    override fun hint(stringId: Int): T {
        return hint(fg.container.resources.getString(stringId))
    }

    override fun backgroundId(backgroundId: Int): T {
        inputLayout.setBackgroundResource(backgroundId)
        return this as T
    }
}