/*
 * Copyright 2015 Julien Guerinet
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
import android.graphics.Typeface;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Creates various form items and adds them to a given container
 * @author Julien Guerinet
 * @version 2.0.1
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
	private LayoutInflater mInflater;
	/**
	 * The {@link LinearLayout} used as the form container
	 */
	LinearLayout mContainer;
    /**
     * The {@link Builder} instance to use to construct this FormGenerator
     */
    protected Builder mBuilder;

	/**
	 * Binds the default {@link FormGenerator} to the given layout and returns it.
     *  This will use either the default generator set by the user,
     *  or a generator with the default values
	 *
	 * @param inflater  The {@link LayoutInflater}
	 * @param container The container that the items should be in
	 * @return The default {@link FormGenerator}
	 */
	public static FormGenerator bind(LayoutInflater inflater, LinearLayout container){
		//No singleton set, bind from the default settings
		if(singleton == null){
			singleton = new Builder();
		}

        return new FormGenerator(singleton, inflater, container);
	}

	/**
	 * Binds the default {@link FormGenerator} to the given layout and returns it.
     *  This will use either the default generator set by the user,
     *  or a generator with the default values
	 *
	 * @param context   The {@link LayoutInflater}
	 * @param container The container that the items should be in
	 * @return The default {@link FormGenerator}
	 */
	public static FormGenerator bind(Context context, LinearLayout container){
		return bind(LayoutInflater.from(context), container);
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
	 *  {@link #get()}, {@link #bind(Context, LinearLayout)} or
     *  {@link #bind(LayoutInflater, LinearLayout)} is called
	 *
	 * @param builder The {@link Builder} instance
	 */
	public static void set(Builder builder){
		singleton = builder;
	}

	/**
	 * Default Constructor
	 *
	 * @param builder   The {@link Builder} instance to construct the {@link FormGenerator} from
	 * @param inflater  The {@link LayoutInflater} instance
	 * @param container The container to add the form items to
	 */
	private FormGenerator(Builder builder, LayoutInflater inflater, LinearLayout container){
		mInflater = inflater;
		mContainer = container;
        mBuilder = builder;
	}

	/**
	 * Adds a space
	 */
	public SpaceItem space(){
		return new SpaceItem(this, mInflater.inflate(R.layout.fg_space, mContainer, false));
	}

	/**
	 * Adds a line
	 *
	 * @return The {@link LineItem}
	 */
	public LineItem line(){
		return new LineItem(this, mInflater.inflate(R.layout.fg_line, mContainer, false));
	}

	/**
	 * Adds an input item
	 *
	 * @param text The text
	 * @return The {@link EditTextFormItem}
	 */
	public EditTextFormItem input(String text){
		return new EditTextFormItem(this, mInflater.inflate(R.layout.fg_input, mContainer, false),
				text);
	}

	/**
	 * Adds a text item
	 *
	 * @param text The text
	 * @return The {@link TextViewFormItem}
	 */
	public TextViewFormItem text(String text){
		View view = mInflater.inflate(R.layout.fg_text, mContainer, false);
		return new TextViewFormItem(this, view, (TextView)view.findViewById(R.id.fg_text), text);
	}

	/**
	 * Adds a standard button
	 *
	 * @param text     The text
	 * @param listener The {@link View.OnClickListener}
	 * @return The {@link TextViewFormItem}
	 */
	public ButtonFormItem button(String text, View.OnClickListener listener){
		return new ButtonFormItem(this, mInflater.inflate(R.layout.fg_button, mContainer, false),
				text, listener);
	}

	/**
	 * Adds a switch item
	 *
	 * @param text The text
	 * @return The {@link SwitchFormItem}
	 */
	public SwitchFormItem aSwitch(String text){
		return new SwitchFormItem(this, mInflater.inflate(R.layout.fg_switch, mContainer, false),
				text);
	}

	/**
	 * The Form Generator builder
	 */
	public static class Builder {
        /**
         * The default icon color Id, 0 if none
         */
        @ColorRes
        int mDefaultIconColorId = 0;
        /**
         * The default background Id, null if none
         */
        @ColorRes @DrawableRes
        Integer mDefaultBackgroundId = null;
        /**
         * The default background Id for the input item, null if none
         */
        @ColorRes @DrawableRes
        Integer mDefaultInputBackgroundId = null;
        /**
         * The default color for the space, transparent if none
         */
        @ColorRes @DrawableRes
        int mDefaultSpaceColorId = android.R.color.transparent;
        /**
         * The default space size Id, 10dp if none
         */
        @DimenRes
        int mDefaultSpaceSizeId = R.dimen.space;
        /**
         * The default text size, 14dp if none
         */
        @DimenRes
        int mDefaultTextSizeId = R.dimen.text;
        /**
         * The default text color Id, black if none
         */
        @ColorRes
        int mDefaultTextColorId = android.R.color.black;
        /**
         * The default text color state list, 0 if none
         */
        @ColorRes
        int mDefaultTextColorStateListId = 0;
        /**
         * The default typeface to use, null if none
         */
        Typeface mDefaultTextTypeface = null;
        /**
         * The default padding size for the non-space/line items, 8dp if none
         */
        @DimenRes
        int mDefaultPaddingSizeId = R.dimen.padding;
        /**
         * The default line size, 0.5 dp if none
         */
        @DimenRes
        int mDefaultLineSizeId = R.dimen.line;
        /**
         * The default line color Id, #EEEEEE if none
         */
        @ColorRes @DrawableRes
        int mDefaultLineColorId = R.color.line;
        /**
         * True if we should show a line after a form item, false otherwise (defaults to true)
         */
        boolean mShowLine = true;

		/**
		 * Default Constructor
		 */
		public Builder(){}

        /**
         * @return A new {@link Builder} instance, generated from the given one
         */
        public Builder newInstance() {
            Builder builder = new Builder();

            //Set the values from the given instance
            builder.mDefaultIconColorId = mDefaultIconColorId;
            builder.mDefaultBackgroundId = mDefaultBackgroundId;
            builder.mDefaultInputBackgroundId = mDefaultInputBackgroundId;
            builder.mDefaultSpaceColorId = mDefaultSpaceColorId;
            builder.mDefaultSpaceSizeId = mDefaultSpaceSizeId;
            builder.mDefaultTextSizeId = mDefaultTextSizeId;
            builder.mDefaultTextColorId = mDefaultTextColorId;
            builder.mDefaultTextColorStateListId = mDefaultTextColorStateListId;
            builder.mDefaultTextTypeface = mDefaultTextTypeface;
            builder.mDefaultPaddingSizeId = mDefaultPaddingSizeId;
            builder.mDefaultLineSizeId = mDefaultLineSizeId;
            builder.mDefaultLineColorId = mDefaultLineColorId;
            builder.mShowLine = mShowLine;
            return builder;
        }

		/**
		 * Binds a {@link Builder} to a given view
		 *
		 * @param inflater  The {@link LayoutInflater} instance
		 * @param container The container for the views
		 * @return The created {@link FormGenerator} instance
		 */
		public FormGenerator bind(LayoutInflater inflater, LinearLayout container){
			return new FormGenerator(this, inflater, container);
		}

		/**
		 * Builds a {@link FormGenerator} based off of this {@link Builder}
		 *
		 * @param context   The app {@link Context}
		 * @param container The container for the views
		 * @return The created {@link FormGenerator} instance
		 */
		public FormGenerator bind(Context context, LinearLayout container){
			return bind(LayoutInflater.from(context), container);
		}

		/**
		 * Sets the default icon color
		 *
		 * @param colorId The color resource Id
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultIconColorId(@ColorRes int colorId){
			mDefaultIconColorId = colorId;
			return this;
		}

		/**
		 * Sets the default background
		 *
		 * @param backgroundId The background resource Id (can be a color or a drawable)
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultBackground(@ColorRes @DrawableRes int backgroundId){
			mDefaultBackgroundId = backgroundId;
			return this;
		}

		/**
		 * Sets the default background for the input fields
		 *
		 * @param backgroundId The background resource Id (can be a color or drawable)
		 * @return The {@link Builder} instance
		 */
		public Builder setInputDefaultBackground(@ColorRes @DrawableRes int backgroundId){
			mDefaultInputBackgroundId = backgroundId;
			return this;
		}

		/**
		 * Sets the default space color
		 *
		 * @param colorId The space color Id
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultSpaceColorId(@ColorRes int colorId){
			mDefaultSpaceColorId = colorId;
			return this;
		}

		/**
		 * Sets the default space size
		 *
		 * @param dimenId The dimension Id (in dp)
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultSpaceSize(@DimenRes int dimenId){
			mDefaultSpaceSizeId = dimenId;
			return this;
		}

		/**
		 * Sets the default text size
		 *
		 * @param dimenId The dimension Id (in dp)
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultTextSize(@DimenRes int dimenId){
			mDefaultTextSizeId = dimenId;
			return this;
		}

		/**
		 * Sets the default text color
		 *
		 * @param colorId   The color Id
		 * @param stateList True if this is a state list, false if it's a solid color
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultTextColorId(@ColorRes int colorId, boolean stateList){
			if(stateList){
				mDefaultTextColorStateListId = colorId;
			}
			else{
				mDefaultTextColorId = colorId;
			}
			return this;
		}

		/**
		 * Sets the default typeface for the text items
		 *
		 * @param typeface The {@link Typeface} to use
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultTypeface(Typeface typeface){
			mDefaultTextTypeface = typeface;
			return this;
		}

		/**
		 * Sets the default padding size
		 *
		 * @param dimenId The dimension Id (in dp)
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultPaddingSize(@DimenRes int dimenId){
			mDefaultPaddingSizeId = dimenId;
			return this;
		}

		/**
		 * Sets the default line size
		 *
		 * @param dimenId The dimension Id (in dp)
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultLineSize(@DimenRes int dimenId){
			mDefaultLineSizeId = dimenId;
			return this;
		}

		/**
		 * Sets the default line color Id
		 *
		 * @param colorId The color resource Id
		 * @return The {@link Builder} instance
		 */
		public Builder setDefaultLineColorId(@ColorRes @DrawableRes int colorId){
			mDefaultLineColorId = colorId;
			return this;
		}

		/**
		 * Sets if the line should be shown after a form item by default or not
		 *
		 * @param showLine True if a line should be shown after a form item, false otherwise
		 * @return The {@link Builder} instance
		 */
		public Builder setShowLine(boolean showLine){
			mShowLine = showLine;
			return this;
		}
	}
}
