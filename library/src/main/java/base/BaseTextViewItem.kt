/*
 * Copyright 2015-2019 Julien Guerinet
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

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.guerinet.morf.Morf
import com.guerinet.morf.util.Layout
import com.guerinet.morf.util.Position

/**
 * Builder for a [TextView] form item (buttons, texts, switches, inputs)
 * @author Julien Guerinet
 * @since 2.0.0
 *
 * @param morf [Morf] instance
 * @param view Form item [View]
 * @param isDefaultBackground True if we should use the default background, false otherwise
 */
open class BaseTextViewItem<T : BaseTextViewItem<T, V>, out V : TextView>(
    morf: Morf,
    view: V,
    isDefaultBackground: Boolean = true,
    lineView: View? = View(morf.context)
) : BaseLineItem<T, V>(
    morf, view, lineView
) {

    /**
     * List of empty [Icon]s to keep track of the compound drawables to set
     *  Order: start, top, end, bottom
     */
    private val icons: Array<Icon> = arrayOf(Icon(), Icon(), Icon(), Icon())

    init {
        // Layout
        layout(Layout.MATCH_PARENT, Layout.WRAP_CONTENT, Gravity.CENTER_VERTICAL)

        // Background
        val backgroundId = morf.shape.backgroundId
        if (isDefaultBackground && backgroundId != null) {
            @Suppress("LeakingThis")
            backgroundId(backgroundId)
        }

        // Text Color
        textColor(morf.shape.textColor)

        // Text Size
        textSizeId(morf.shape.textSizeId)

        // Padding
        val paddingId = morf.shape.paddingId
        val dpPadding = morf.shape.dpPadding
        val pixelPadding = morf.shape.pixelPadding
        when {
            paddingId != null -> paddingId(paddingId)
            dpPadding != null -> dpPadding(dpPadding)
            pixelPadding != null -> pixelPadding(pixelPadding)
        }

        // Typeface
        @Suppress("LeakingThis")
        typeface(morf.shape.textTypeface)
    }

    var text: String?
        get() = error("Setter only")
        set(value) {
            view.text = value
        }

    /**
     * Returns this [BaseTextViewItem] with the [text] set
     */
    fun text(text: String?): T = setAndReturn { this.text = text }

    var textId: Int
        get() = error("Setter only")
        set(value) = view.setText(value)

    /**
     * Returns this [BaseTextViewItem] with the text with [stringId] set
     */
    fun text(@StringRes stringId: Int): T = setAndReturn { this.textId = stringId }

    open var hint: String?
        get() = error("Setter only")
        set(value) {
            view.hint = value
        }

    /**
     * Returns this [BaseTextViewItem] with the [hint] set
     */
    open fun hint(hint: String?): T = setAndReturn { this.hint = hint }

    open var hintId: Int
        get() = error("Setter only")
        set(value) = view.setHint(value)

    /**
     * Returns this [BaseTextViewItem] with the hint with [stringId] set
     */
    open fun hint(@StringRes stringId: Int): T = setAndReturn { this.hintId = stringId }

    var isFocusable: Boolean
        get() = error("Setter only")
        set(value) {
            view.isFocusable = value
        }

    /**
     * Sets whether the returned item [isFocusable] or not
     */
    fun isFocusable(isFocusable: Boolean): T = setAndReturn { this.isFocusable = isFocusable }

    var isEnabled: Boolean
        get() = error("Setter only")
        set(value) {
            view.isEnabled = value
        }

    /**
     * Sets whether the returned item [isEnabled] or not
     */
    fun isEnabled(isEnabled: Boolean): T = setAndReturn { this.isEnabled = isEnabled }

    var textColor: Int
        get() = error("Setter only")
        set(value) = view.setTextColor(value)

    /**
     * Returns this [BaseTextViewItem] with the text set to the given [color]
     */
    fun textColor(@ColorInt color: Int): T = setAndReturn { this.textColor = color }

    var textSizeId: Int?
        get() = error("Setter only")
        set(value) {
            // If it's null, don't do anything
            if (value != null) {
                view.setTextSize(TypedValue.COMPLEX_UNIT_PX, view.resources.getDimension(value))
            }
        }

    /**
     * Returns this [BaseTextViewItem] with the text size set to the dimension with the [sizeId]
     */
    fun textSizeId(@DimenRes sizeId: Int?): T = setAndReturn { this.textSizeId = sizeId }

    /**
     * Sets the [start], [top], [end], and [bottom] paddings (in pixels) on the returned item.
     *  If one of these is null, the padding remains what it is currently for that side
     */
    fun pixelPadding(
        start: Int? = null,
        top: Int? = null,
        end: Int? = null,
        bottom: Int? = null
    ): T = setAndReturn {
        // Use the current paddings if one of them is null
        view.setPaddingRelative(start ?: view.paddingStart, top ?: view.paddingTop,
                end ?: view.paddingEnd, bottom ?: view.paddingBottom)
    }

    /**
     * Sets the paddings on the returned item using the [startDp], [topDp], [endDp], and [bottomDp].
     *  If one of these is null, the padding remains what it is currently for that side
     */
    fun dpPadding(
        startDp: Float? = null,
        topDp: Float? = null,
        endDp: Float? = null,
        bottomDp: Float? = null
    ): T = pixelPadding(startDp?.run { dpToPixels(this) }, topDp?.run { dpToPixels(this) },
            endDp?.run { dpToPixels(this) }, bottomDp?.run { dpToPixels(this) })

    /**
     * Sets the paddings on the returned item using the [startId], [topId], [endId], and [bottomId]
     *  dimension resource Ids. If one of these is null, the padding remains what it is currently
     *  for that side
     */
    fun paddingId(
        @DimenRes startId: Int? = null,
        @DimenRes topId: Int? = null,
        @DimenRes endId: Int? = null,
        @DimenRes bottomId: Int? = null
    ): T = pixelPadding(startId?.run { dimenToPixels(startId) },
            topId?.run { dimenToPixels(topId) }, endId?.run { dimenToPixels(endId) },
            bottomId?.run { dimenToPixels(bottomId) })

    var pixelPadding: Int
        get() = error("Setter only")
        set(value) {
            pixelPadding(value, value, value, value)
        }

    /**
     * Returns the [BaseTextViewItem] with the given [padding] (in pixels) on all 4 sides
     */
    fun pixelPadding(padding: Int): T = setAndReturn { this.pixelPadding = padding }

    var dpPadding: Float
        get() = error("Setter only")
        set(value) {
            dpPadding(value, value, value)
        }

    /**
     * Returns the [BaseTextViewItem] with padding, in [dps], on all 4 sides
     */
    fun dpPadding(dps: Float): T = setAndReturn { this.dpPadding = dps }

    var paddingId: Int
        get() = error("Setter only")
        set(value) {
            paddingId(value, value, value, value)
        }

    /**
     * Returns the [BaseTextViewItem] with padding from the given [dimenId] on all 4 sides
     */
    fun paddingId(dimenId: Int): T = setAndReturn { this.paddingId = dimenId }

    open var typeface: Typeface?
        get() = error("Setter only")
        set(value) {
            view.typeface = value
        }

    /**
     * Returns the [BaseTextViewItem] with the text in the given [typeface]
     */
    open fun typeface(typeface: Typeface?): T = setAndReturn { this.typeface = typeface }

    /**
     * @return Item with the applied text [style] and [typeface]
     *  (which defaults to the default one if none specified)
     */
    @JvmOverloads
    fun style(style: Int, typeface: Typeface? = morf.shape.textTypeface): T =
            setAndReturn { view.setTypeface(typeface, style) }

    /**
     * Sets up an icon at the given [position] with the given [drawableId],
     *  [color] (defaults to the default icon color), and whether it [isVisible] (defaults to true)
     */
    @JvmOverloads
    fun icon(
        @Position.Section position: Long,
        @DrawableRes drawableId: Int?,
        isVisible: Boolean = true,
        @ColorInt color: Int? = morf.shape.iconColor
    ): T =
            setAndReturn {
                icons[position.toInt()] = Icon(drawableId, color = color, isVisible = isVisible)
            }

    /**
     * Sets up an icon at the given [position] with the given [drawable],
     *  [color] (defaults to the default icon color), and whether it [isVisible] (defaults to true)
     */
    @JvmOverloads
    fun icon(
        @Position.Section position: Long,
        drawable: Drawable?,
        isVisible: Boolean = true,
        @ColorInt color: Int? = morf.shape.iconColor
    ): T = setAndReturn {
        icons[position.toInt()] = Icon(drawable = drawable, color = color, isVisible = isVisible)
    }

    /**
     * Returns the [BaseTextViewItem] with the given function set for click events
     */
    @Suppress("UNCHECKED_CAST")
    open fun onClick(onClick: ((T) -> Unit)?): T = setAndReturn {
        if (onClick == null) {
            view.setOnClickListener(null)
        } else {
            view.setOnClickListener { _ -> onClick(this as T) }
        }
    }

    var gravity: Int
        get() = error("Setter only")
        set(value) {
            view.gravity = value
        }

    /**
     * Returns the [BaseTextViewItem] with the given [gravity] set
     */
    fun gravity(gravity: Int): T = setAndReturn { this.gravity = gravity }

    /**
     * Returns the [BaseTextViewItem] with the single line option removed
     */
    fun removeSingleLine(): T = setAndReturn { view.setSingleLine(false) }

    var ellipsize: TextUtils.TruncateAt
        get() = error("Setter only")
        set(value) {
            view.ellipsize = value
        }

    /**
     * Returns the [BaseTextViewItem] with the given ellipsize [type] set
     */
    fun ellipsize(type: TextUtils.TruncateAt): T = setAndReturn { this.ellipsize = type }

    var visibility: Int
        get() = error("Setter only")
        set(value) {
            view.visibility = value
            // Set the same visibility on the line if there is one
            line?.visibility = value
        }

    /**
     * Returns the [BaseTextViewItem] with the given [visibility] set
     */
    fun visibility(visibility: Int): T = setAndReturn { this.visibility = visibility }

    /**
     * Updates the shown icons on the returned item, without re-adding the view to the container
     */
    fun updateIcons(): T = setAndReturn {
        // Get all of the drawables
        val drawables = arrayOf(getDrawable(icons[0]), getDrawable(icons[1]), getDrawable(icons[2]),
                getDrawable(icons[3]))

        // Set the compound drawable padding
        val drawablePixelPadding = morf.shape.drawablePixelPadding
        val drawableDpPadding = morf.shape.drawableDpPadding
        val drawablePaddingSizeId = morf.shape.drawablePaddingId
        when {
            drawablePixelPadding != null ->
                view.compoundDrawablePadding = drawablePixelPadding
            drawableDpPadding != null ->
                view.compoundDrawablePadding = dpToPixels(drawableDpPadding)
            drawablePaddingSizeId != null ->
                view.compoundDrawablePadding = dimenToPixels(drawablePaddingSizeId)
        }

        // Set the correct tinting and alpha for each drawable
        for (i in drawables.indices) {
            val icon = icons[i]
            var drawable = drawables[i]
            if (drawable != null) {
                // Mutate the drawable first
                drawable = drawable.mutate()
                if (!icon.isVisible) {
                    // Make it invisible if necessary
                    drawable.alpha = 0
                } else if (icon.color != null) {
                    // Wrap it in the design support library and set the tint if we have a color
                    drawable = DrawableCompat.wrap(drawable)
                    DrawableCompat.setTint(drawable, icon.color)
                }
            }
        }

        // Set the drawables on the view
        view.setCompoundDrawablesRelativeWithIntrinsicBounds(drawables[0], drawables[1],
                drawables[2], drawables[3])
    }

    override fun build(): T {
        updateIcons()
        return super.build()
    }

    /**
     * @return [Drawable] to use for the given [icon], null if none
     */
    private fun getDrawable(icon: Icon): Drawable? {
        return if (icon.drawableId != null) {
            ContextCompat.getDrawable(view.context, icon.drawableId)
        } else {
            icon.drawable
        }
    }

    /**
     * Keeps track of the icons to add
     *
     * @param drawableId Id of the resource to load, null if none (defaults to null)
     * @param drawable Drawable to use, null if none (defaults to null)
     * @param color Icon color, null if none (defaults to null)
     * @param isVisible True if the icon should be visible, false otherwise (defaults to false)
     */
    private class Icon(
        @DrawableRes val drawableId: Int? = null,
        val drawable: Drawable? = null,
        @ColorInt val color: Int? = null,
        val isVisible: Boolean = false
    )
}
