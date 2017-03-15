package test.narendra.com.androidpracticaltest.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import test.narendra.com.androidpracticaltest.R;

/**
 * <h1>PinkDotView, a custom view which shows dots</h1>
 *
 * @author Narendra Singh
 * @version 1.0
 * @since 05-03-2017
 */


public class PinkDotView extends View {

    public static final int DEFAULT_DOT_COLOR = 0xff000000;
    public static final int DEFAULT_DOT_RADIUS_WITH_SPACE = 20;
    public static final int DEFAULT_DOT_SPACE = 5;
    public static final int DEFAULT_DOT_COUNT = 0;

    Rect viewRect;
    int dotColor = DEFAULT_DOT_COLOR;
    int dotRadius = DEFAULT_DOT_RADIUS_WITH_SPACE;
    int dotSpace = DEFAULT_DOT_SPACE;
    int dotCount = DEFAULT_DOT_COUNT;
    Paint mPaint;


    public PinkDotView(Context context) {
        super(context);
        init(context, null);
    }

    public PinkDotView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public PinkDotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PinkDotView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    public int getDotCount() {
        return dotCount;
    }

    public void setDotCount(int dotCount) {
        this.dotCount = dotCount;
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.pink_dot);
            final int N = a.getIndexCount();
            for (int i = 0; i < N; ++i) {
                int attr = a.getIndex(i);
                switch (attr) {
                    case R.styleable.pink_dot_dot_color:
                        dotColor = a.getColor(attr, DEFAULT_DOT_COLOR);
                        break;
                    case R.styleable.pink_dot_dot_count:
                        dotCount = a.getInt(attr, DEFAULT_DOT_COUNT);
                        break;
                    case R.styleable.pink_dot_dot_radius_with_space:
                        dotRadius = a.getDimensionPixelSize(attr, DEFAULT_DOT_RADIUS_WITH_SPACE);
                        break;
                    case R.styleable.pink_dot_dot_space:
                        dotSpace = a.getDimensionPixelSize(attr, DEFAULT_DOT_SPACE);
                        break;
                }
            }
            a.recycle();
        }

        viewRect = new Rect();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(dotColor);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (viewRect == null || viewRect.width() == 0) {
            return;
        }

        canvas.save();
        int dotCount = 1;
        final Rect viewrect = viewRect;
        int dotCenterX = viewrect.left + dotRadius;
        int dotCenterY = viewrect.top + dotRadius;
        while (dotCount <= this.dotCount) {
            canvas.drawCircle(dotCenterX, dotCenterY, dotRadius - dotSpace, mPaint);
            dotCenterX += (2 * dotRadius);
            if (dotCenterX > viewrect.right - dotRadius) {
                dotCenterX = viewrect.left + dotRadius;
                dotCenterY += (2 * dotRadius);
            }
            dotCount++;
        }

        canvas.restore();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int h = 0;
        if (dotCount > 0) {
            int w = MeasureSpec.getSize(widthMeasureSpec);
            int mainW = w;
            int rowDotCount = mainW / (2 * dotRadius);
            int heightDotCount = 1;
            int remainDot = dotCount - rowDotCount;
            while (remainDot > 0) {
                heightDotCount++;
                remainDot -= rowDotCount;
            }
            int mainH = (heightDotCount * (2 * dotRadius));
            h = mainH;
        }

        heightMeasureSpec = MeasureSpec.makeMeasureSpec(h, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        viewRect.right = w;
        viewRect.bottom = h;
    }
}
