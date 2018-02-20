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

import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.view.View
import com.guerinet.fg.base.Item

/**
 * Space in the form
 * @author Julien Guerinet
 * @since 2.0.0
 *
 * @param fg    [FormGenerator] instance
 * @param view  Space [View]
 */
class SpaceItem(fg: FormGenerator, view: View) : Item<SpaceItem>(fg, view) {

    init {
        // Size
        val spaceHeight = fg.defaults.spaceHeight
        if (spaceHeight != null) {
            height(spaceHeight)
        }

        // Background
        background(fg.defaults.spaceColorId)
    }

    /**
     * @return [SpaceItem] instance with the new [height] set, in pixels
     */
    fun height(height: Int): SpaceItem {
        view.layoutParams.height = height
        return this
    }

    /**
     * @return [SpaceItem] instance with the background with the given [resId] set
     */
    fun background(@ColorRes @DrawableRes resId: Int): SpaceItem {
        view.setBackgroundResource(resId)
        return this
    }

    /**
     * @return [SpaceItem] instance with the background of the given [color]
     */
    fun backgroundColor(@ColorInt color: Int): SpaceItem {
        view.setBackgroundColor(color)
        return this
    }
}