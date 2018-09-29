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

package com.guerinet.morf.base

import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import com.google.android.material.textfield.TextInputLayout
import com.guerinet.morf.Morf
import com.guerinet.morf.util.Layout

/**
 * Based form item for a [TextInputLayout]
 * @author Julien Guerinet
 * @since 3.0.0
 *
 * @param morf    [Morf] instance
 * @param view  Item [View]
 */
@Suppress("UNCHECKED_CAST")
open class BaseTextInputItem<T : BaseTextInputItem<T, V>, V : EditText>(morf: Morf, view: V)
    : BaseEditTextItem<T, V>(morf, view, false) {

    private val inputLayout = TextInputLayout(morf.context)

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
        return hint(morf.container.resources.getString(stringId))
    }

    override fun backgroundId(backgroundId: Int): T {
        inputLayout.setBackgroundResource(backgroundId)
        return this as T
    }

    override fun build(): T {
        // Add the input layout to the container, not the view
        if (inputLayout.parent == null) {
            morf.container.addView(inputLayout)
        }
        return super.build()
    }
}