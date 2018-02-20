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
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.view.View
import com.guerinet.fg.R.color.line
import com.guerinet.fg.base.BaseLineItem
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
        // Height
        val spaceHeightId = fg.defaults.spaceHeightId
        if (spaceHeightId != null) {
            heightId(spaceHeightId)
        } else {
            val spacePixelHeight = fg.defaults.spacePixelHeight
            if (spacePixelHeight != null) {
                pixelHeight(spacePixelHeight)
            } else {
                dpHeight(fg.defaults.spaceDpHeight)
            }
        }

        // Background
        val spaceColor = fg.defaults.spaceColor
        if (spaceColor != null) {
            backgroundColor(spaceColor)
        } else {
            backgroundId(fg.defaults.spaceBackgroundId)
        }
    }
}