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
import com.guerinet.formgenerator.FormGenerator

/**
 * Space in the form
 * @author Julien Guerinet
 * @since 2.0.0
 *
 * @param fg    [FormGenerator] instance
 * @param space Space [View]
 */
class SpaceItem(fg: FormGenerator, private val space: View) : Item(fg) {

    init {
        fg.container.addView(space)

        if (fg.builder.defaultSpaceSize != -1) {
            // If there is a custom default space height, set it
            height(fg.builder.defaultSpaceSize)
        }
        background(fg.builder.defaultSpaceColorId)
    }

    /**
     * @return [SpaceItem] instance with the new [height] set, in pixels
     */
    fun height(height: Int): SpaceItem {
        space.layoutParams.height = height
        return this
    }

    /**
     * @return [SpaceItem] instance with the background with the given [resId] set
     */
    fun background(@ColorRes @DrawableRes resId: Int): SpaceItem {
        space.setBackgroundResource(resId)
        return this
    }

    /**
     * @return [SpaceItem] instance with the background of the given [color]
     */
    fun backgroundColor(@ColorInt color: Int): SpaceItem {
        space.setBackgroundColor(color)
        return this
    }

    override fun view(): View = space
}