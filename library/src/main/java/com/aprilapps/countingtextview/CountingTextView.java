package com.aprilapps.countingtextview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

/**
 * Created by Jacek Kwiecień on 08.06.15.
 */
public class CountingTextView extends TextView {

    private final String STATE = "state";
    private final String PREVIOUS_VALUE = "previous_value";
    private final String FORMATTER = "formatter";

    private float previousValue;
    private ValueFormatter formatter;
    private ObjectAnimator animator;
    private long animationDuration = 300;

    public CountingTextView(Context context) {
        super(context);
    }

    public CountingTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CountingTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private ObjectAnimator valueAnimator(float startValue, float endValue, String valueName) {
        ObjectAnimator animation = ObjectAnimator.ofFloat(this, valueName, startValue, endValue);
        animation.setDuration(animationDuration);
        animation.setInterpolator(new LinearInterpolator());
        return animation;
    }

    public void setValue(float value) {
        if (formatter == null) {
            formatter = new ValueFormatter() {
                @Override
                public String formatValue(float value) {
                    return String.format("%.1f", value);
                }
            };
        }

        if (animator != null) animator.cancel();

        animator = valueAnimator(previousValue, value, "valueAnimated");
        animator.start();
        previousValue = value;
    }

    private void setValueAnimated(float value) {
        setText(formatter.formatValue(value));
    }

    public static abstract class ValueFormatter implements Parcelable {
        public abstract String formatValue(float value);

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }
    }

    public void setFormatter(ValueFormatter formatter) {
        this.formatter = formatter;
    }

    public void setAnimationDuration(long animationDuration) {
        this.animationDuration = animationDuration;
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Bundle outState = new Bundle();
        outState.putFloat(PREVIOUS_VALUE, previousValue);
        outState.putParcelable(FORMATTER, formatter);
        outState.putParcelable(STATE, super.onSaveInstanceState());
        return outState;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        Bundle bundle = (Bundle) state;
        previousValue = ((Bundle) state).getFloat(PREVIOUS_VALUE);
        formatter = ((Bundle) state).getParcelable(FORMATTER);
        super.onRestoreInstanceState(bundle.getParcelable(STATE));

        if (previousValue != 0f) setValue(previousValue);
    }

}
