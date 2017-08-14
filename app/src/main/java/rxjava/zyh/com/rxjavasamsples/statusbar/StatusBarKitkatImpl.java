package rxjava.zyh.com.rxjavasamsples.statusbar;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * @author 占迎辉 (zhanyinghui@parkingwang.com)
 * @version 2017/8/4
 */

public class StatusBarKitkatImpl implements IStatusBar {
    private static final String STATUS_BAR_VIEW_TAG = "ghStatusBarView";
    @Override
    public void setStatusBar(Window window, int color, boolean isLightBar) {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ViewGroup decorViewGroup = (ViewGroup) window.getDecorView();
        View statusBarView = decorViewGroup.findViewWithTag(STATUS_BAR_VIEW_TAG);
        if (statusBarView == null) {
            statusBarView = new View(window.getContext());
            statusBarView.setTag(STATUS_BAR_VIEW_TAG);
            int statusBarHeight = getStatusBarHeight(window.getContext());
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, statusBarHeight);
            params.gravity = Gravity.TOP;
            statusBarView.setLayoutParams(params);
            decorViewGroup.addView(statusBarView);
        }
        statusBarView.setBackgroundColor(color);
        StatusBarCompat.setFitsSystemWindows(window, true);
        StatusBarCompatRom.setLightStatusBar(window, isLightBar);
    }

    private static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = res.getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }
}
