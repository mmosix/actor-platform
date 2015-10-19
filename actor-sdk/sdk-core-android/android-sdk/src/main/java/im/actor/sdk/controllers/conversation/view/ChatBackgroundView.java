package im.actor.sdk.controllers.conversation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import im.actor.messenger.R;

public class ChatBackgroundView extends View {

    private Drawable background;

    public ChatBackgroundView(Context context) {
        super(context);
        bind();
    }

    public ChatBackgroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bind();
    }

    public ChatBackgroundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bind();
    }

    public void release() {
        background = null;
    }

    public void bind() {
        if (background == null) {
            background = getResources().getDrawable(R.drawable.img_chat_background_default);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (background != null) {
            int w = background.getIntrinsicWidth();
            int h = background.getIntrinsicHeight();

            int screenW = getResources().getDisplayMetrics().widthPixels;
            int screenH = getResources().getDisplayMetrics().heightPixels;

            float scale = Math.min((float) w / (float) screenW, (float) h / (float) screenH);
            int realW = (int) (screenW * scale);
            int realH = (int) (screenH * scale);
            int paddingW = (w - realW) / 2;
            int paddingH = (h - realH) / 2;

            background.setBounds(
                    (int) (-paddingW / scale),
                    (int) (-paddingH / scale),
                    (int) (screenW + paddingW / scale),
                    (int) (screenH + paddingH / scale));
            background.draw(canvas);
        }
    }
}