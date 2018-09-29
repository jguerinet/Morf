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
import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputLayout
import com.guerinet.morf.Morf
import com.guerinet.morf.util.Layout

/**
 * Based form item for a [TextInputLayout]
 * @author Julien Guerinet
 * @since 3.0.0
 *
 * @param morf  [Morf] instance
 * @param view  Item [View]
 */
open class BaseTextInputItem<T : BaseTextInputItem<T, V>, V : EditText>(morf: Morf, view: V)
    : BaseEditTextItem<T, V>(morf, view, false) {

    private val inputLayout = TextInputLayout(morf.context)

    init {
        inputLayout.layoutParams = LinearLayout.LayoutParams(Layout.MATCH_PARENT,
                Layout.WRAP_CONTENT)

        // Add the view to the input layout
        inputLayout.addView(view)
    }

    var isPasswordVisibilityToggleEnabled: Boolean
        get() = error("Setter only")
        set(value) {
            inputLayout.isPasswordVisibilityToggleEnabled = value
        }

    /**
     * @return Item with the password visibility toggle shown or not depending on [isEnabled]
     */
    fun showPasswordVisibilityToggle(isEnabled: Boolean): T = setAndReturn {
        this.isPasswordVisibilityToggleEnabled = isEnabled
    }

    override var hint: String?
        get() = super.hint
        set(value) {
            inputLayout.hint = value
        }

    override fun hint(hint: String?): T = setAndReturn { this.hint = hint }

    override var hintId: Int
        get() = super.hintId
        set(@StringRes value) {
            hint(view.resources.getString(value))
        }

    override fun hint(stringId: Int): T = setAndReturn { this.hintId = stringId }

    override var backgroundId: Int
        get() = super.backgroundId
        set(value) = inputLayout.setBackgroundResource(value)

    override fun backgroundId(backgroundId: Int): T =
            setAndReturn { this.backgroundId = backgroundId }

    override fun build(): T {
        // Add the input layout to the container, not the view
        if (inputLayout.parent == null) {
            morf.addView(inputLayout)
        }
        return super.build()
    }
}