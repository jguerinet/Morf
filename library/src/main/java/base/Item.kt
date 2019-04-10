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

import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.CallSuper
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import com.guerinet.morf.Morf
import com.guerinet.morf.util.Layout

/**
 * Base class for all items that could be present on a form
 * @author Julien Guerinet
 * @since 2.0.0
 *
 * @param morf [Morf] that created this item
 */
open class Item<out T : Item<T, V>, out V : View>(protected val morf: Morf, val view: V) {

    var id: Int
        get() = error("Setter only")
        set(value) {
            view.id = value
        }

    /**
     * Returns the [Item] instance with the given [id] set
     */
    fun id(id: Int): T = setAndReturn { this.id = id }

    var pixelHeight: Int
        get() = error("Setter only")
        set(value) {
            pixelHeight(view, value)
        }

    /**
     * Returns the [Item] instance with its new height in [pixels] set
     */
    fun pixelHeight(pixels: Int): T = setAndReturn { this.pixelHeight = pixels }

    var dpHeight: Float
        get() = error("Setter only")
        set(value) {
            dpHeight(view, value)
        }

    /**
     * Returns the [Item] with its new height in [dps] set
     */
    fun dpHeight(dps: Float): T = setAndReturn { this.dpHeight = dps }

    var heightId: Int
        get() = error("Setter only")
        set(@DimenRes value) {
            heightId(view, value)
        }

    /**
     * @return Item with its new height from the [dimenId] set
     */
    fun heightId(@DimenRes dimenId: Int): T = setAndReturn { this.heightId = dimenId }

    /**
     * @return Item with the [view] height set to the given [pixels]
     */
    protected fun pixelHeight(view: View?, pixels: Int): T = setAndReturn {
        view?.layoutParams?.height = pixels
    }

    /**
     * @return Item with the [view] height set to the given [dps]
     */
    protected fun dpHeight(view: View?, dps: Float): T = pixelHeight(view, dpToPixels(dps))

    /**
     * @return Item with the [view] height set to the given [dimenId]
     */
    protected fun heightId(view: View?, @DimenRes dimenId: Int): T =
            pixelHeight(view, dimenToPixels(dimenId))

    protected fun dpToPixels(dps: Float): Int =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dps,
                    view.resources.displayMetrics).toInt()

    /**
     * @return Pixel equivalent of the dimen [dimenId]
     */
    protected fun dimenToPixels(@DimenRes dimenId: Int): Int =
            view.resources.getDimensionPixelOffset(dimenId)

    open var backgroundId: Int
        get() = error("Setter only")
        set(@ColorRes @DrawableRes value) = view.setBackgroundResource(value)

    /**
     * @return Item with the given background with [backgroundId] set
     */
    open fun backgroundId(@ColorRes @DrawableRes backgroundId: Int): T = setAndReturn {
        this.backgroundId = backgroundId
    }

    var backgroundColor: Int
        get() = error("Setter only")
        set(@ColorInt value) = view.setBackgroundColor(value)

    /**
     * @return Item with the background of the given [color]
     */
    fun backgroundColor(@ColorInt color: Int): T = setAndReturn { this.backgroundColor = color }

    /**
     * @return Item with the set [width] (defaults to MATCH_PARENT), [height]
     *  (defaults to WRAP_CONTENT), and [gravity] (null if none, defaults to null
     */
    @JvmOverloads
    fun layout(
        width: Int = Layout.MATCH_PARENT,
        height: Int = Layout.WRAP_CONTENT,
        gravity: Int? = null
    ): T = layoutParams(LinearLayout.LayoutParams(width, height), gravity)

    /**
     * @return Item with the given layout [params] and [gravity] (null if none, defaults to null)
     *  set
     */
    fun layoutParams(params: LinearLayout.LayoutParams, gravity: Int? = null): T = setAndReturn {
        if (gravity != null) {
            params.gravity = gravity
        }
        view.layoutParams = params
    }

    /**
     * Builds and returns the [Item] by adding it to the container. Subclasses may perform other
     *  operations
     */
    @CallSuper
    open fun build(): T = setAndReturn {
        if (view.parent == null) {
            morf.addView(view)
        }
    }

    /**
     * Builds and returns the item by applying the given block to it, and calling build().
     */
    @Suppress("UNCHECKED_CAST")
    inline fun build(block: T.() -> Unit): T = (this as T).apply(block).build()

    /**
     * Invokes the setter and returns this item, casted.
     */
    @Suppress("UNCHECKED_CAST")
    protected fun setAndReturn(setter: () -> Unit): T {
        setter()
        return this as T
    }
}
