package com.bryansills.jalousie;

import com.bryansills.jalousie.render.JalousieRenderer;

import net.rbgrn.android.glwallpaperservice.GLWallpaperService;

/**
 * Created by bsills on 9/19/14.
 */
public class JalousieWallpaperService extends GLWallpaperService {
    public JalousieWallpaperService() {
        super();
    }

    public Engine onCreateEngine() {
        JalousieEngine engine = new JalousieEngine();
        return engine;
    }

    class JalousieEngine extends GLEngine {
        JalousieRenderer renderer;
        public JalousieEngine() {
            super();
            // handle prefs, other initialization
            renderer = new JalousieRenderer();
            setRenderer(renderer);
            setRenderMode(RENDERMODE_CONTINUOUSLY);
        }

        public void onDestroy() {
            super.onDestroy();
            if (renderer != null) {
                renderer.release();
            }
            renderer = null;
        }
    }
}
