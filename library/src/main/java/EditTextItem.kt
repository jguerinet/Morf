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

import android.view.View
import android.widget.EditText
import com.guerinet.morf.base.BaseEditTextItem

/**
 * Form item that represents an [EditText]
 * @author Julien Guerinet
 * @since 4.0.0
 *
 * @param morf                    [Morf] instance
 * @param editText                  Item [View]
 * @param isDefaultBackground   True if we should use the default background, false otherwise
 */
class EditTextItem(morf: Morf) :
        BaseEditTextItem<EditTextItem, EditText>(morf, EditText(morf.context))