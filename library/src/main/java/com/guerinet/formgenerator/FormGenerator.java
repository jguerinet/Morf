/*
 * Copyright 2015-2016 Julien Guerinet
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

package com.guerinet.formgenerator;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Creates various form items and adds them to a given container
 * @author Julien Guerinet
 * @since 1.0.0
 */
public class FormGenerator {
	/**
	 * The singleton instance of the default {@link Builder} to use
	 */
	private static Builder singleton = null;

	/* SETTINGS */
	/**
	 * The {@link LayoutInflater}
	 */
	private LayoutInflater inflater;
	/**
	 * The {@link LinearLayout} used as the form container
	 */
	LinearLayout container;
    /**
     * The {@link Builder} instance to use to construct this FormGenerator
     */
    Builder builder;

	/**
	 * Binds the default {@link FormGenerator} to the given layout and returns it.
     *  This will use either the default generator set by the user,
     *  or a generator with the default values
	 *
	 * @param container The container that the items should be in
	 * @return The default {@link FormGenerator}
	 */
	public static FormGenerator bind(LinearLayout container) {
        if (container == null) {
            throw new IllegalArgumentException("LinearLayout container cannot be null");
        }
		// No singleton set, bind from the default settings
		if (singleton == null) {
			singleton = new Builder();
		}

        return new FormGenerator(singleton, container);
	}

    /**
     * @return The default {@link Builder} instance
     */
    public static Builder get() {
        if (singleton == null) {
            singleton = new Builder();
        }
        return singleton;
    }

	/**
	 * Sets the default instance of the {@link FormGenerator} to use when
	 *  {@link #get()}, {@link #bind(LinearLayout)} or
	 *
	 * @param builder {@link Builder} instance
	 */
	public static void set(Builder builder) {
		singleton = builder;
	}

	/**
	 * Default Constructor
	 *
	 * @param builder   {@link Builder} instance to construct the {@link FormGenerator} from
	 * @param container Container to add the form items to
	 */
	private FormGenerator(Builder builder, LinearLayout container) {
		this.inflater = LayoutInflater.from(container.getContext());
		this.container = container;
        this.builder = builder;
	}

	/**
	 * Adds a space
	 */
	public SpaceItem space() {
		return new SpaceItem(this, inflater.inflate(R.layout.fg_space, container, false));
	}

	/**
	 * Adds a line
	 *
	 * @return The {@link LineItem}
	 */
	public LineItem line() {
		return new LineItem(this, inflater.inflate(R.layout.fg_line, container, false));
	}

	/**
	 * Adds an input item
	 *
	 * @return The {@link EditTextFormItem}
	 */
	public EditTextFormItem input() {
		return new EditTextFormItem(this, inflater.inflate(R.layout.fg_input, container, false));
	}

    /**
     * Adds a text input item
     *
     * @return Generated {@link TextInputFormItem}
     */
    public TextInputFormItem textInput() {
        return new TextInputFormItem(this, inflater.inflate(R.layout.fg_text_input, container,
                false));
    }

    /**
     * Adds an auto complete text input item
     *
     * @return Generated {@link AutoCompleteTextInputFormItem}
     */
    public AutoCompleteTextInputFormItem autoCompleteTextInput() {
        return new AutoCompleteTextInputFormItem(this, inflater.inflate(R.layout.fg_text_input_ac,
                container, false));
    }

	/**
	 * Adds a text item
	 *
	 * @return The {@link TextViewFormItem}
	 */
	public TextViewFormItem text() {
		View view = inflater.inflate(R.layout.fg_text, container, false);
		return new TextViewFormItem(this, view, (TextView)view.findViewById(R.id.fg_text), true);
	}

	/**
	 * Adds a standard button
	 *
	 * @return The {@link ButtonFormItem}
	 */
	public ButtonFormItem button() {
		return new ButtonFormItem(this, inflater.inflate(R.layout.fg_button, container, false));
	}

    /**
     * Adds a borderless button
     *
     * @return The {@link ButtonFormItem}
     */
    public ButtonFormItem borderlessButton() {
        return new ButtonFormItem(this, inflater.inflate(R.layout.fg_button_borderless, container,
                false));
    }

	/**
	 * Adds a switch item
	 *
	 * @return The {@link SwitchFormItem}
	 */
	public SwitchFormItem aSwitch() {
		return new SwitchFormItem(this, inflater.inflate(R.layout.fg_switch, container, false));
	}

	/**
	 * The Form Generator builder
	 */
	public static class Builder {
        /**
         * The default icon color Id, -1 if none
         */
        @ColorInt
        int defaultIconColor = -1;
        /**
         * The default background Id, null if none
         */
        @ColorRes
        @DrawableRes
        Integer defaultBackgroundId = null;
        /**
         * The default background Id for the input item, null if none
         */
        @ColorRes
        @DrawableRes
        Integer defaultInputBackgroundId = null;
        /**
         * The default color for the space, transparent if none
         */
        @ColorRes
        @DrawableRes
        int defaultSpaceColorId = android.R.color.transparent;
        /**
         * The default space size Id, -1 if none
         */
        int defaultSpaceSize = -1;
        /**
         * The default text size, app default if none
         */
        float defaultTextSize = -1;
        /**
         * The default text color Id, black if none
         */
        @ColorInt
        int defaultTextColor = Color.BLACK;
        /**
         * The default typeface to use, null if none
         */
        Typeface defaultTextTypeface = null;
        /**
         * The default padding size for the non-space/line items, app default if none
         */
        int defaultPaddingSize = -1;
        /**
         * Default padding size between a view and its compound drawable, app default if none
         */
        int defaultDrawablePaddingSize = -1;
        /**
         * The default line size, -1 if none
         */
        int defaultLineSize = -1;
        /**
         * The default line color Id, #EEEEEE if none
         */
        @ColorRes
        @DrawableRes
        int defaultLineColorId = R.color.line;
        /**
         * True if we should show a line after a form item, false otherwise (defaults to true)
         */
        boolean showLine = true;

		/**
		 * Default Constructor
		 */
		public Builder() {}

        /**
         * @return A new {@link Builder} instance, generated from the given one
         */
        public Builder newInstance() {
            Builder builder = new Builder();

            //Set the values from the given instance
            builder.defaultIconColor = defaultIconColor;
            builder.defaultBackgroundId = defaultBackgroundId;
            builder.defaultInputBackgroundId = defaultInputBackgroundId;
            builder.defaultSpaceColorId = defaultSpaceColorId;
            builder.defaultSpaceSize = defaultSpaceSize;
            builder.defaultTextSize = defaultTextSize;
            builder.defaultTextColor = defaultTextColor;
            builder.defaultTextTypeface = defaultTextTypeface;
            builder.defaultPaddingSize = defaultPaddingSize;
            builder.defaultDrawablePaddingSize = defaultDrawablePaddingSize;
            builder.defaultLineSize = defaultLineSize;
            builder.defaultLineColorId = defaultLineColorId;
            builder.showLine = showLine;
            return builder;
        }

		/**
		 * Binds a {@link Builder} to a given view
		 *
		 * @param container The container for the views
		 * @return The created {@link FormGenerator} instance
		 */
		public FormGenerator bind(LinearLayout container) {
			return new FormGenerator(this, container);
		}

		/**
		 * Sets the default icon color
		 *
		 * @param color The color
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultIconColor(@ColorInt int color) {
			defaultIconColor = color;
			return this;
		}

		/**
		 * Sets the default background
		 *
		 * @param backgroundId The background resource Id (can be a color or a drawable)
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultBackground(@ColorRes @DrawableRes int backgroundId) {
			defaultBackgroundId = backgroundId;
			return this;
		}

		/**
		 * Sets the default background for the input fields
		 *
		 * @param backgroundId The background resource Id (can be a color or drawable)
		 * @return The {@link Builder} instance
		 */
		public Builder setInputDefaultBackground(@ColorRes @DrawableRes int backgroundId) {
			defaultInputBackgroundId = backgroundId;
			return this;
		}

		/**
		 * Sets the default space color
		 *
		 * @param colorId The space color Id
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultSpaceColorId(@ColorRes int colorId) {
			defaultSpaceColorId = colorId;
			return this;
		}

		/**
		 * Sets the default space size
		 *
		 * @param pixels The size in <strong>pixels</strong>
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultSpaceSize(int pixels) {
			defaultSpaceSize = pixels;
			return this;
		}

		/**
		 * Sets the default text size
		 *
		 * @param size Default text size from the dimensions file
         *             (use getResources().getDimension())
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultTextSize(float size) {
			defaultTextSize = size;
			return this;
		}

		/**
		 * Sets the default text color
		 *
		 * @param color The color
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultTextColor(@ColorInt int color) {
            defaultTextColor = color;
			return this;
		}

		/**
		 * Sets the default typeface for the text items
		 *
		 * @param typeface The {@link Typeface} to use
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultTypeface(Typeface typeface) {
			defaultTextTypeface = typeface;
			return this;
		}

		/**
		 * Sets the default padding size
		 *
		 * @param pixels The padding size in <strong>pixels</strong>
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultPaddingSize(int pixels) {
			defaultPaddingSize = pixels;
			return this;
		}

        /**
         * Sets the default padding size between a view and its compound drawable
         *
         * @param pixels The padding size, in <strong>pixels</strong>
         * @return The {@link Builder} instance
         */
        public Builder setDefaultDrawablePaddingSize(int pixels) {
            defaultDrawablePaddingSize = pixels;
            return this;
        }

		/**
		 * Sets the default line size
		 *
		 * @param pixels The line size, in <strong>pixels</strong>
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultLineSize(int pixels) {
			defaultLineSize = pixels;
			return this;
		}

		/**
		 * Sets the default line color Id
		 *
		 * @param colorId The color resource Id
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultLineColorId(@ColorRes @DrawableRes int colorId) {
			defaultLineColorId = colorId;
			return this;
		}

		/**
		 * Sets if the line should be shown after a form item by default or not
		 *
		 * @param showLine True if a line should be shown after a form item, false otherwise
		 * @return The {@link Builder} instance
		 */
		public Builder setShowLine(boolean showLine) {
			this.showLine = showLine;
			return this;
		}
	}
}
