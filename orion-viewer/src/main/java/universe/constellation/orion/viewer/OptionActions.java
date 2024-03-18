package universe.constellation.orion.viewer;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.core.internal.view.SupportMenuItem;


public enum OptionActions {

    NONE("NONE"),

    SHOW_ACTION_BAR("SHOW_ACTION_BAR") {
        public void doAction(OrionViewerActivity activity, boolean oldValue, boolean newValue) {
            Toolbar toolbar = activity.getToolbar();
            ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
            if (newValue) {
                layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            } else {
                layoutParams.height = 0;
            }
            toolbar.setLayoutParams(layoutParams);
            Menu menu = toolbar.getMenu();
            menu.clear();
            activity.onCreateOptionsMenu(menu);
            if (!newValue) {
                for (int i = 0; i < menu.size(); i++) {
                    MenuItem item = menu.getItem(i);
                    item.setShowAsAction(SupportMenuItem.SHOW_AS_ACTION_NEVER);
                }
            }
        }
    },

    SHOW_STATUS_BAR("SHOW_ACTION_BAR") {
        public void doAction(OrionViewerActivity activity, boolean oldValue, boolean newValue) {
            activity.getStatusBarHelper().setShowStatusBar(newValue);
        }
    },

    SHOW_OFFSET_ON_STATUS_BAR("SHOW_OFFSET_ON_STATUS_BAR") {
        public void doAction(OrionViewerActivity activity, boolean oldValue, boolean newValue) {
            activity.getStatusBarHelper().setShowOffset(newValue);
        }
    },

    SCREEN_OVERLAPPING_HORIZONTAL("SCREEN_OVERLAPPING_HORIZONTAL") {
        public void doAction(OrionViewerActivity activity, int hor, int ver) {
            activity.getController().changeOverlap(hor, ver);
        }
    },

    SCREEN_OVERLAPPING_VERTICAL("SCREEN_OVERLAPPING_VERTICAL") {
        public void doAction(OrionViewerActivity activity, int hor, int ver) {
            activity.getController().changeOverlap(hor, ver);
        }
    },

    SET_CONTRAST("contrast") {
        public void doAction(OrionViewerActivity activity, int oldValue, int newValue) {
            Controller controller = activity.getController();
            if (controller != null) {
                controller.changeContrast(newValue);
            }
        }
    },

    SET_THRESHOLD("threshold") {
        public void doAction(OrionViewerActivity activity, int oldValue, int newValue) {
            Controller controller = activity.getController();
            if (controller != null) {
                controller.changeThreshhold(newValue);
            }
        }
    },

    DEBUG("DEBUG") {
        public void doAction(OrionViewerActivity activity, boolean oldValue, boolean newValue) {
            if (newValue) {
                AndroidLogger.startLogger(activity.getOrionContext().getCurrentBookParameters().openingFileName + ".trace");
            } else {
                AndroidLogger.stopLogger();
            }
        }
    };


    private final String key;

    OptionActions(String key) {
        this.key = key;
    }

    public void doAction(OrionViewerActivity activity, int oldValue, int newValue) {

    }

    public void doAction(OrionViewerActivity activity, boolean oldValue, boolean newValue) {

    }

    public String getKey() {
        return key;
    }
}
