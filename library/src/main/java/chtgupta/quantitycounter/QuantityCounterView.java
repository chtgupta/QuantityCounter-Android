package chtgupta.quantitycounter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class QuantityCounterView extends RelativeLayout {

    private int value;
    private Integer maxValue;
    private ValueListener valueListener;
    private String initialText;
    private int themeColor;
    private int backgroundColor;
    private Typeface typeface;

    private View root;
    private TextView add;
    private TextView valueView;
    private TextView minus;
    private TextView plus;

    public QuantityCounterView(Context context) {
        super(context);
        setDefaults(context);
        init(context);
    }

    public QuantityCounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDefaults(context);
        init(context, attrs);
    }

    private void setDefaults(Context context) {
        this.value = 0;
        this.maxValue = Integer.MAX_VALUE;
        this.valueListener = null;
        this.initialText = context.getString(R.string.initial_text_default);
        this.themeColor = context.getResources().getColor(R.color.theme_color_default);
        this.backgroundColor = Color.WHITE;
        this.typeface = Typeface.MONOSPACE;
    }

    private void init(Context context) {

        View view = inflate(context, R.layout.view, null);

        root = view.findViewById(R.id.root);
        add = view.findViewById(R.id.add);
        minus = view.findViewById(R.id.minus);
        valueView = view.findViewById(R.id.value);
        plus = view.findViewById(R.id.plus);

        add.setOnClickListener(v -> {

            if (value == 0) {
                value++;
                if (valueListener != null) valueListener.onValueChange(value);
                valueView.setText(String.valueOf(value));
                add.setVisibility(INVISIBLE);
            }

        });

        minus.setOnClickListener(v -> {
//            if (minValue != null && value != minValue) {
                value--;
                if (valueListener != null) valueListener.onValueChange(value);

                if (value == 0) {
                    add.setVisibility(VISIBLE);
                } else {
                    valueView.setText(String.valueOf(value));
                }
//            }

        });

        plus.setOnClickListener(v -> {

            if (maxValue == null) {
                value++;
                if (valueListener != null) valueListener.onValueChange(value);
                valueView.setText(String.valueOf(value));
            } else if (value != maxValue) {
                value++;
                if (valueListener != null) valueListener.onValueChange(value);
                valueView.setText(String.valueOf(value));
            }
        });

        addView(view);
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.QuantityCounterView);

        String initialText = typedArray.getString(R.styleable.QuantityCounterView_initialText);
        if (initialText != null) {
            this.initialText = initialText;
        }

        View view = inflate(context, R.layout.view, null);

        root = view.findViewById(R.id.root);
        add = view.findViewById(R.id.add);
        minus = view.findViewById(R.id.minus);
        valueView = view.findViewById(R.id.value);
        plus = view.findViewById(R.id.plus);

        add.setText(this.initialText);
        maxValue = typedArray.getInteger(R.styleable.QuantityCounterView_maxValue, Integer.MAX_VALUE);
        themeColor = typedArray.getColor(R.styleable.QuantityCounterView_themeColor, context.getResources().getColor(R.color.theme_color_default));
        backgroundColor = typedArray.getColor(R.styleable.QuantityCounterView_backgroundColor, Color.WHITE);

        setThemeColor(this.themeColor);
        setBackgroundColor(this.backgroundColor);
        setTypeface(this.typeface);

        add.setOnClickListener(v -> {

            if (value == 0) {
                value++;
                if (valueListener != null) valueListener.onValueChange(value);
                valueView.setText(String.valueOf(value));
                add.setVisibility(INVISIBLE);
            }

        });

        minus.setOnClickListener(v -> {
//            if (minValue != null && value != minValue) {
                value--;
                if (valueListener != null) valueListener.onValueChange(value);

                if (value == 0) {
                    add.setVisibility(VISIBLE);
                } else {
                    valueView.setText(String.valueOf(value));
                }
//            }

        });

        plus.setOnClickListener(v -> {

            if (maxValue == null) {
                value++;
                if (valueListener != null) valueListener.onValueChange(value);
                valueView.setText(String.valueOf(value));
            } else if (value != maxValue) {
                value++;
                if (valueListener != null) valueListener.onValueChange(value);
                valueView.setText(String.valueOf(value));
            }
        });

        addView(view);

        typedArray.recycle();

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;

        if (value == 0) {
            add.setVisibility(VISIBLE);
        } else {
            add.setVisibility(INVISIBLE);
            valueView.setText(String.valueOf(value));
        }

    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;

        add.setTypeface(this.typeface);
        plus.setTypeface(this.typeface);
        minus.setTypeface(this.typeface);
        valueView.setTypeface(this.typeface);
    }

    public void setThemeColor(int themeColor) {
        this.themeColor = themeColor;

        add.setTextColor(themeColor);
        plus.setTextColor(themeColor);
        minus.setTextColor(themeColor);
        valueView.setTextColor(themeColor);
        GradientDrawable rootBackground = (GradientDrawable) root.getBackground();
        GradientDrawable addBackground = (GradientDrawable) add.getBackground();
        rootBackground.setStroke(1, themeColor);
        addBackground.setStroke(1, themeColor);
    }

    @Override
    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;

        GradientDrawable rootBackground = (GradientDrawable) root.getBackground();
        GradientDrawable addBackground = (GradientDrawable) add.getBackground();
        rootBackground.setColor(this.backgroundColor);
        addBackground.setColor(this.backgroundColor);
    }

    public String getInitialText() {
        return initialText;
    }

    public void setInitialText(String initialText) {

        if (initialText != null) {
            this.initialText = initialText;
            add.setText(this.initialText);
        } else {
            throw new IllegalArgumentException("Parameter initialText cannot be null");
        }
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public interface ValueListener {
        void onValueChange(int value);
    }

    public void setValueListener(ValueListener valueListener) {
        this.valueListener = valueListener;
    }
}
