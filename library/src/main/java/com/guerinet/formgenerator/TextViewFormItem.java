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
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

/**
 * Builder for a {@link TextView} form item (buttons, texts, and inputs)
 * @author Julien Guerinet
 * @since 2.0.0
 */
public class TextViewFormItem extends FormItem {
	/**
	 * The {@link TextView}
	 */
	protected TextView mTextView;
	/**
	 * The list of {@link Icon}s to add
	 */
	private Icon[] mIcons;
	/**
	 * The {@link Context}
	 */
	protected Context mContext;

	/**
	 * Private Constructor that sets up all of the properties of the form item
	 *
	 * @param fg         The {@link FormGenerator} instance
	 * @param view       The {@link View}
     * @param textView   The {@link TextView}
     * @param background True if the default background should be applied, false otherwise
	 */
	private TextViewFormItem(FormGenerator fg, View view, TextView textView, boolean background){
		super(fg, view, background);
		mTextView = textView;
		mView.setClickable(false);
		mContext = mView.getContext();

		//Icons - set them all to nothing
		mIcons = new Icon[4];
		mIcons[0] = new Icon(0, 0, false);
		mIcons[1] = new Icon(0, 0, false);
		mIcons[2] = new Icon(0, 0, false);
		mIcons[3] = new Icon(0, 0, false);

		//Text Color
		if(mFG.mBuilder.mDefaultTextColorStateListId != 0){
			textColor(mFG.mBuilder.mDefaultTextColorStateListId, true);
		}
		else{
			textColor(mFG.mBuilder.mDefaultTextColorId, false);
		}

		//Text Size
		textSize(mFG.mBuilder.mDefaultTextSizeId);

		//Padding
		padding(mFG.mBuilder.mDefaultPaddingSizeId);

		//Typeface
		typeface(mFG.mBuilder.mDefaultTextTypeface);
	}

    /**
     * Default Constructor
     *
     * @param fg         The {@link FormGenerator} instance
     * @param view       The {@link View}
     * @param textView   The {@link TextView}
     * @param text       The text to use on the TextView
     * @param background True if the default background should be applied, false otherwise
     */
    public TextViewFormItem(FormGenerator fg, View view, TextView textView, String text,
            boolean background) {
        this(fg, view, textView, background);
        mTextView.setText(text);
    }

    /**
     * Constructor which takes a String resource Id for the text
     *
     * @param fg         The {@link FormGenerator} instance
     * @param view       The {@link View}
     * @param textView   The {@link TextView}
     * @param text       The text Id to use in the TextView
     * @param background True if the default background should be applied, false otherwise
     */
    public TextViewFormItem(FormGenerator fg, View view, TextView textView, @StringRes int text,
            boolean background) {
        this(fg, view, textView, background);
        mTextView.setText(text);
    }

	/**
	 * Sets the {@link TextView} hint
	 *
	 * @param hint The hint
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem hint(String hint){
		mTextView.setHint(hint);
		return this;
	}

	/**
	 * Sets the {@link TextView} hint
	 *
	 * @param stringId The String Id
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem hint(@StringRes int stringId){
		mTextView.setHint(stringId);
		return this;
	}

	/**
	 * Sets the {@link TextView} text color
	 *
	 * @param colorId   The resource Id
	 * @param stateList True if the color is a state list, false if it's a solid color
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem textColor(int colorId, boolean stateList){
		if(stateList){
			mTextView.setTextColor(ContextCompat.getColorStateList(mContext, colorId));
		}
		else{
			mTextView.setTextColor(ContextCompat.getColor(mContext, colorId));
		}
		return this;
	}

	/**
	 * Sets the {@link TextView} text size
	 *
	 * @param dimenId The dimension Id
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem textSize(@DimenRes int dimenId){
        mTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                mContext.getResources().getDimensionPixelSize(dimenId));
        return this;
	}

	/**
	 * Sets the {@link TextView} padding
	 *
	 * @param leftId   The dimension Id for the left padding
	 * @param topId    The dimension Id for the top padding
	 * @param rightId  The dimension Id for the right padding
	 * @param bottomId The dimension Id for the bottom padding
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem padding(@DimenRes int leftId, @DimenRes int topId,
            @DimenRes int rightId, @DimenRes int bottomId){
        mTextView.setPadding(mContext.getResources().getDimensionPixelSize(leftId),
                mContext.getResources().getDimensionPixelSize(topId),
                mContext.getResources().getDimensionPixelSize(rightId),
                mContext.getResources().getDimensionPixelSize(bottomId));
        return this;
	}

	/**
	 * Sets the {@link TextView} padding
	 *
	 * @param dimenId The dimension Id to use for all sides
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem padding(@DimenRes int dimenId){
		return padding(dimenId, dimenId, dimenId, dimenId);
	}

	/**
	 * Sets the {@link TextView} {@link Typeface}
	 *
	 * @param typeface The {@link Typeface}
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem typeface(Typeface typeface){
		mTextView.setTypeface(typeface);
		return this;
	}

	/**
	 * Sets the {@link TextView} {@link Typeface} and style
	 *
	 * @param typeface The {@link Typeface}
	 * @param style    The style
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem style(Typeface typeface, int style){
		mTextView.setTypeface(typeface, style);
		return this;
	}

	/**
	 * Sets the {@link TextView} style. Note: if you are using a custom {@link Typeface},
	 *  use {@link #style(Typeface, int)}
	 *
	 * @param style The style
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem style(int style){
		mTextView.setTypeface(mFG.mBuilder.mDefaultTextTypeface, style);
		return this;
	}

	/**
	 * Sets up the icon
	 *
	 * @param position The icon position
	 * @param iconId   The icon Id
	 * @param colorId  The color Id
	 * @param visible  True if the icon should be visible, false otherwise
	 */
	private void icon(int position, @DrawableRes int iconId, @ColorRes int colorId,
			boolean visible){
		mIcons[position] = new Icon(iconId, colorId, visible);

		//Set all of the icons
		mTextView.setCompoundDrawablesWithIntrinsicBounds(mIcons[0].mDrawableId,
				mIcons[1].mDrawableId, mIcons[2].mDrawableId, mIcons[3].mDrawableId);

		//Apply the tinting and alpha
		for(int i = 0; i < 4; i++){
			Icon icon = mIcons[i];
			Drawable drawable = mTextView.getCompoundDrawables()[i];
			if(drawable != null){
                //Wrap it in the design support library
				drawable = DrawableCompat.wrap(drawable).mutate();
				if(!icon.mVisible){
					drawable.setAlpha(0);
				}
				else{
                    DrawableCompat.setTint(drawable,
                            ContextCompat.getColor(mContext, icon.mColorId));
				}
			}
		}
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem leftIcon(@DrawableRes int iconId, boolean visible){
		icon(0, iconId, mFG.mBuilder.mDefaultIconColorId, visible);
		return this;
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem topIcon(@DrawableRes int iconId, boolean visible){
		icon(1, iconId, mFG.mBuilder.mDefaultIconColorId, visible);
		return this;
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem rightIcon(@DrawableRes int iconId, boolean visible){
		icon(2, iconId, mFG.mBuilder.mDefaultIconColorId, visible);
		return this;
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @param visible True if the icon should be visible, false otherwise
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem bottomIcon(@DrawableRes int iconId, boolean visible){
		icon(3, iconId, mFG.mBuilder.mDefaultIconColorId, visible);
		return this;
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem leftIcon(@DrawableRes int iconId){
		icon(0, iconId, mFG.mBuilder.mDefaultIconColorId, true);
		return this;
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem topIcon(@DrawableRes int iconId){
		icon(1, iconId, mFG.mBuilder.mDefaultIconColorId, true);
		return this;
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem rightIcon(@DrawableRes int iconId){
		icon(2, iconId, mFG.mBuilder.mDefaultIconColorId, true);
		return this;
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem bottomIcon(@DrawableRes int iconId){
		icon(3, iconId, mFG.mBuilder.mDefaultIconColorId, true);
		return this;
	}

	/**
	 * Sets the left icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem leftIcon(@DrawableRes int iconId, @ColorRes int colorId){
		icon(0, iconId, colorId, true);
		return this;
	}

	/**
	 * Sets the top icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem topIcon(@DrawableRes int iconId, @ColorRes int colorId){
		icon(1, iconId, colorId, true);
		return this;
	}

	/**
	 * Sets the right icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem rightIcon(@DrawableRes int iconId, @ColorRes int colorId){
		icon(2, iconId, colorId, true);
		return this;
	}

	/**
	 * Sets the bottom icon
	 *
	 * @param iconId  The icon resource Id
	 * @param colorId The color Id
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem bottomIcon(@DrawableRes int iconId, @ColorRes int colorId){
		icon(3, iconId, colorId, true);
		return this;
	}

	/**
	 * Sets the {@link View.OnClickListener}
	 *
	 * @param listener The {@link View.OnClickListener}
	 * @return The {@link TextViewFormItem} instance
	 */
	public TextViewFormItem onClick(View.OnClickListener listener){
		mView.setOnClickListener(listener);
		return this;
	}

    /**
     * Sets the {@link TextView} gravity
     *
     * @param gravity The gravity
     * @return The {@link TextViewFormItem} instance
     */
    public TextViewFormItem gravity(int gravity) {
        mTextView.setGravity(gravity);
        return this;
    }

    /**
     * Sets the {@link TextView} to be single line
     *
     * @return The {@link TextViewFormItem} instance
     */
    public TextViewFormItem singleLine() {
        mTextView.setSingleLine();
        return this;
    }

    /**
     * Sets the {@link TextView} ellipsize option
     *
     * @param type The ellipsize type
     * @return The {@link TextViewFormItem} instance
     */
    public TextViewFormItem ellipsize(TextUtils.TruncateAt type) {
        mTextView.setEllipsize(type);
        return this;
    }

    /**
	 * Sets the line size
	 *
	 * @param sizeDimen The line size dimension Id
	 * @return The {@link TextViewFormItem} instance
	 */
	@Override
	public TextViewFormItem lineSize(@DimenRes int sizeDimen){
		return (TextViewFormItem) super.lineSize(sizeDimen);
	}

	/**
	 * Sets the line color
	 *
	 * @param colorId The color Id
	 * @return The {@link TextViewFormItem} instance
	 */
	@Override
	public TextViewFormItem lineColor(@ColorRes @DrawableRes int colorId){
		return (TextViewFormItem)super.lineColor(colorId);
	}

	/**
	 * Sets the line visibility
	 *
	 * @param show True if the line should be visible, false otherwise
	 * @return The {@link LineItem} instance
	 */
	@Override
	public TextViewFormItem showLine(boolean show){
		return (TextViewFormItem)super.showLine(show);
	}

	/**
	 * Sets the background
	 *
	 * @param backgroundId The background Id
	 * @return The {@link TextViewFormItem} instance
	 */
	@Override
	public TextViewFormItem background(@ColorRes @DrawableRes int backgroundId){
		return (TextViewFormItem)super.background(backgroundId);
	}

	/**
	 * @return The {@link TextView}
	 */
	@Override
	public TextView view(){
		return mTextView;
	}

	/**
	 * Keeps track of the icons to add
	 */
	class Icon {
		/**
		 * The drawable resource
		 */
		private int mDrawableId;
		/**
		 * The icon color
		 */
		private int mColorId;
		/**
		 * True if the icon should be visible, false otherwise
		 */
		private boolean mVisible;

		/**
		 * Default Constructor
		 *
		 * @param drawableId The drawable resource
		 * @param colorId    The color Id
		 * @param visibility True if the icon should be visible, false otherwise
		 */
		private Icon(@DrawableRes int drawableId, @ColorRes int colorId, boolean visibility){
			mDrawableId = drawableId;
			mColorId = colorId;
			mVisible = visibility;
		}
	}
}
