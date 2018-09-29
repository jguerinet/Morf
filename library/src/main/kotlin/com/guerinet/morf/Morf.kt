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

package com.guerinet.morf

import android.graphics.Color
import android.graphics.Typeface
import android.widget.Button
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes

/**
 * Creates the various form items and adds them to a given container
 * @author Julien Guerinet
 * @since 1.0.0
 */
class Morf private constructor(internal val shape: Shape,
                               internal val container: LinearLayout) {

    internal val context = container.context

    /**
     * @return [SpaceItem] added to the form
     */
    fun space(): SpaceItem = SpaceItem(this)

    /**
     * @return [LineItem] added to the form
     */
    fun line(): LineItem = LineItem(this)

    /**
     * @return [TextViewItem] added to the form
     */
    fun text(): TextViewItem = TextViewItem(this)

    /**
     * Creates a [TextViewItem], applies the block, and returns it
     */
    inline fun text(block: TextViewItem.() -> Unit): TextViewItem = text().apply(block).build()

    /**
     * @return [ButtonItem] added to the form
     */
    fun button(): ButtonItem = ButtonItem(this, Button(context))

    /**
     * Creates a [ButtonItem], applies the block, and returns it
     */
    inline fun button(block: ButtonItem.() -> Unit): ButtonItem = button().apply(block).build()

    /**
     * @return Borderless [ButtonItem] added to the form
     */
    fun borderlessButton(): ButtonItem = ButtonItem(this, Button(context, null,
            R.attr.borderlessButtonStyle))

    /**
     * Creates a borderless [ButtonItem], applies the block, and returns it
     */
    inline fun borderlessButton(block: ButtonItem.() -> Unit): ButtonItem =
            borderlessButton().apply(block).build()

    /**
     * @return [EditTextItem] added to the form
     */
    fun input(): EditTextItem = EditTextItem(this)

    /**
     * Creates an [EditTextItem], applies the block, and returns it
     */
    inline fun input(block: EditTextItem.() -> Unit): EditTextItem = input().apply(block).build()

    /**
     * @return [TextInputItem] added to the form
     */
    fun textInput(): TextInputItem = TextInputItem(this)

    /**
     * Creates a [TextInputItem], applies the block, and returns it
     */
    inline fun textInput(block: TextInputItem.() -> Unit): TextInputItem =
            textInput().apply(block).build()

    /**
     * @return [AutoCompleteTextInputItem] added to the form
     */
    fun autoCompleteTextInput(): AutoCompleteTextInputItem = AutoCompleteTextInputItem(this)

    /**
     * Creates a [AutoCompleteTextInputItem], applies the block, and returns it
     */
    inline fun autoCompleteTextInput(block: AutoCompleteTextInputItem.() -> Unit):
            AutoCompleteTextInputItem = autoCompleteTextInput().apply(block).build()

    /**
     * @return [SwitchItem] added to the form
     */
    fun aSwitch(): SwitchItem = SwitchItem(this)

    /**
     * Creates a [SwitchItem], applies the block, and returns it
     */
    inline fun aSwitch(block: SwitchItem.() -> Unit): SwitchItem = aSwitch().apply(block).build()

    companion object {

        /**
         * Default shape to use everywhere, null if none set
         */
        private var innerShape: Shape? = null
        var shape: Shape
            get() = innerShape ?: Shape()
            set(value) {
                innerShape = value
            }

        /**
         * Binds the default [Shape] to the given layout and returns the corresponding [Morf].
         *  This will use either the [Shape] set by the user, or a [Shape] with default values.
         */
        fun bind(container: LinearLayout): Morf = Morf(shape, container)

        inline fun createAndSetShape(block: Shape.() -> Unit) {
            shape = createShape(block)
        }

        inline fun createShape(block: Shape.() -> Unit): Shape =
                Shape().apply(block)
    }

    /**
     * Contains all of the customizable settings for a [Morf] instance
     */
    class Shape {

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
         * Resolved color for a line, defaults to #EEEEEE
         */
        @ColorInt
        var lineColor: Int = Color.parseColor("#EEEEEE")

        /**
         * Id of the background resource for a line, defaults to null
         *  Note: this takes precedence over lineColor if set
         */
        @ColorRes
        @DrawableRes
        var lineBackgroundId: Int? = null

        /**
         * True if we should show a line after a form item, false otherwise (defaults to true)
         */
        var isLineShown: Boolean = true

        /* Text */

        /**
         * Id of the size of the text, defaults to null (which is the app's default)
         */
        @DimenRes
        var textSizeId: Int? = null

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
         * Padding size in pixels for non-space/line items,
         *  defaults to null (which is the app's default)
         */
        var pixelPadding: Int? = null

        /**
         * Padding size in DP for non-space/line items, defaults to null.
         *  Note: This takes precedence over pixelPadding
         */
        var dpPadding: Float? = null

        /**
         * Dimension Id for a padding size for non-space/line items, defaults to null
         *  Note: This takes precedence over pixelPadding and dpPadding
         */
        var paddingId: Int? = null

        /**
         * Padding size in pixels between a view and its compound drawable, defaults to null
         *  (which is the app's default)
         */
        var drawablePixelPadding: Int? = null

        /**
         * Padding size in DP between a view and its compound drawable, defaults to null.
         *  Note: This takes precedence over drawablePixelPadding
         */
        var drawableDpPadding: Float? = null

        /**
         * Dimension Id for a padding size between a view and its compound drawable, defaults to
         *  null
         *  Note: This takes precedence over drawablePaddingId
         */
        var drawablePaddingId: Int? = null

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
         * @return New [Shape] instance, generated from the current one
         */
        fun newShape(): Shape {
            val settings = Shape()
            settings.spaceBackgroundId = spaceBackgroundId
            settings.spaceColor = spaceColor
            settings.spaceDpHeight = spaceDpHeight
            settings.spacePixelHeight = spacePixelHeight
            settings.spaceHeightId = spaceHeightId
            settings.lineDpHeight = lineDpHeight
            settings.linePixelHeight = linePixelHeight
            settings.lineHeightId = lineHeightId
            settings.lineColor = lineColor
            settings.lineBackgroundId = lineBackgroundId
            settings.isLineShown = isLineShown
            settings.textSizeId = textSizeId
            settings.textColor = textColor
            settings.textTypeface = textTypeface
            settings.pixelPadding = pixelPadding
            settings.dpPadding = dpPadding
            settings.paddingId = paddingId
            settings.drawablePixelPadding = drawablePixelPadding
            settings.drawableDpPadding = drawableDpPadding
            settings.drawablePaddingId = drawablePaddingId
            settings.iconColor = iconColor
            settings.backgroundId = backgroundId
            settings.inputBackgroundId = inputBackgroundId
            return settings
        }

        /**
         * @return New [Shape] instance, generated from the current one and the block
         */
        inline fun newShape(block: Shape.() -> Unit): Shape = newShape().apply(block)

        /**
         * @return [Morf] created from binding this [Shape] to the given [container]
         */
        fun bind(container: LinearLayout): Morf = Morf(this, container)
    }
}

