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

package com.guerinet.fg

import android.graphics.Color
import android.graphics.Typeface
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.view.LayoutInflater
import android.widget.LinearLayout

/**
 * Creates the various form items and adds them to a given container
 * @author Julien Guerinet
 * @since 1.0.0
 */
class FormGenerator private constructor(internal val defaults: Defaults,
                                        internal val container: LinearLayout) {

    private val inflater: LayoutInflater = LayoutInflater.from(container.context)

    /**
     * @return [SpaceItem] added to the form
     */
    fun space(): SpaceItem = SpaceItem(this, inflater.inflate(R.layout.fg_space, container, false))

    /**
     * @return [LineItem] added to the form
     */
    fun line(): LineItem = LineItem(this, inflater.inflate(R.layout.fg_line, container, false))

    /**
     * @return [TextViewItem] added to the form
     */
    fun text(): TextViewItem {
        val view = inflater.inflate(R.layout.fg_text, container, false)
        return TextViewItem(this, view, view.findViewById(R.id.fg_text), true)
    }

    /**
     * @return [ButtonItem] added to the form
     */
    fun button(): ButtonItem =
            ButtonItem(this, inflater.inflate(R.layout.fg_button, container, false))

    /**
     * @return Borderless [ButtonItem] added to the form
     */
    fun borderlessButton(): ButtonItem =
            ButtonItem(this, inflater.inflate(R.layout.fg_button_borderless, container, false))

    /**
     * @return [EditTextItem] added to the form
     */
    fun input(): EditTextItem =
            EditTextItem(this, inflater.inflate(R.layout.fg_input, container, false), true)

    /**
     * @return [TextInputItem] added to the form
     */
    fun textInput(): TextInputItem =
            TextInputItem(this, inflater.inflate(R.layout.fg_text_input, container, false))

    /**
     * @return [AutoCompleteTextInputItem] added to the form
     */
    fun autoCompleteTextInput(): AutoCompleteTextInputItem =
            AutoCompleteTextInputItem(this, inflater.inflate(R.layout.fg_text_input_ac, container,
                    false))

    /**
     * @return [SwitchItem] added to the form
     */
    fun aSwitch(): SwitchItem =
            SwitchItem(this, inflater.inflate(R.layout.fg_switch, container, false))

    companion object {

        /**
         * User defaults to use everywhere, null if none set
         */
        private var _defaults: Defaults? = null
        var defaults: Defaults
            get() = _defaults ?: Defaults()
            set(value) {
                _defaults = value
            }

        /**
         * Binds the [Defaults] singleton to the given layout and returns the corresponding
         *  [FormGenerator]. This will use either the [Defaults] set by the user, or the [Defaults]
         *  with default values
         */
        fun bind(container: LinearLayout): FormGenerator = FormGenerator(defaults, container)

        inline fun createAndSetDefaults(block: Defaults.() -> Unit) {
            defaults = createDefaults(block)
        }

        inline fun createDefaults(block: Defaults.() -> Unit): Defaults =
                Defaults().apply(block)
    }

    /**
     * Contains all of the customizable defaults for a [FormGenerator]
     */
    class Defaults {

        /* Space */

        /**
         * Background resource for a space, defaults to transparent
         */
        @ColorRes
        @DrawableRes
        var spaceBackgroundId: Int = android.R.color.transparent

        /**
         * Resolved color for a space, defaults to null (in order to use spaceBackgroundId)
         *  Note: this takes precedence over spaceBackgroundId if set
         */
        @ColorInt
        var spaceColor: Int? = null

        /**
         * Height (in dp) of a space, defaults to 8
         */
        var spaceDpHeight: Float = 8f

        /**
         * Height (in pixels) of a space, defaults to null
         *  Note: this takes precedence over spaceDpHeight if set
         */
        var spacePixelHeight: Int? = null

        /**
         * Height from a dimension Id of a space, defaults to null
         *  Note: this takes precedence over spaceDpHeight and spacePixelHeight if set
         */
        @DimenRes
        var spaceHeightId: Int? = null

        /* Line */

        /**
         * Height (in dp) of a line, defaults to 0.5
         */
        var lineDpHeight: Float = 0.5f

        /**
         * Height (in pixels) of a line, defaults to null
         *  Note: this takes precedence over lineDpHeight if set
         */
        var linePixelHeight: Int? = null

        /**
         * Height from a dimension Id of a line, defaults to null
         *  Note: this takes precedence over lineDpHeight and linePixelHeight if set
         */
        @DimenRes
        var lineHeightId: Int? = null

        /**
         * Id of the background resource for a line, defaults to #EEEEEE
         */
        @ColorRes
        @DrawableRes
        var lineBackgroundId: Int = R.color.line

        /**
         * Resolved color for a line, defaults to null (in order to use lineBackgroundId)
         *  Note: this takes precedence over lineBackgroundId if set
         */
        @ColorInt
        var lineColor: Int? = null

        /**
         * True if we should show a line after a form item, false otherwise (defaults to true)
         */
        var isLineShown: Boolean = true

        /* Text */

        /**
         * Id of the size of the text, defaults to null (which is the app's default)
         */
        @DimenRes
        var textSize: Int? = null

        /**
         * Color of the text, defaults to black
         */
        @ColorInt
        var textColor: Int = Color.BLACK

        /**
         * Typeface to use for the text, null if none (defaults to null)
         */
        var textTypeface: Typeface? = null

        /* Padding */

        /**
         * Padding size for non-space/line items, defaults to null (which is the app's default)
         */
        var paddingSize: Int? = null

        /**
         * Padding size between a view and its compound drawable, defaults to null
         *  (which is the app's default)
         */
        var drawablePaddingSize: Int? = null

        /* Resources */

        /**
         * Color to tint the icons, null if none (defaults to null)
         */
        @ColorInt
        var iconColor: Int? = null

        /**
         * Id of the background to use, null if none (defaults to null)
         */
        @ColorRes
        @DrawableRes
        var backgroundId: Int? = null

        /**
         * Id of the background to use for input items, null if none (defaults to null)
         */
        @ColorRes
        @DrawableRes
        var inputBackgroundId: Int? = null

        /**
         * @return New [Defaults] instance, generated from the current one
         */
        fun newInstance(): Defaults {
            val defaults = Defaults()
            defaults.spaceBackgroundId = spaceBackgroundId
            defaults.spacePixelHeight = spacePixelHeight
            defaults.linePixelHeight = linePixelHeight
            defaults.lineBackgroundId = lineBackgroundId
            defaults.isLineShown = isLineShown
            defaults.textSize = textSize
            defaults.textColor = textColor
            defaults.textTypeface = textTypeface
            defaults.paddingSize = paddingSize
            defaults.drawablePaddingSize = drawablePaddingSize
            defaults.iconColor = iconColor
            defaults.backgroundId = backgroundId
            defaults.inputBackgroundId = inputBackgroundId
            return defaults
        }

        /**
         * @return [FormGenerator] created from this [Defaults] and the given [container]
         */
        fun bind(container: LinearLayout): FormGenerator = FormGenerator(this, container)
    }
}