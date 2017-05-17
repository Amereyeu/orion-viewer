/*
 * Orion Viewer - pdf, djvu, xps and cbz file viewer for android devices
 *
 * Copyright (C) 2011-2013  Michael Bogdanov & Co
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package universe.constellation.orion.viewer;

import android.graphics.Point;
import universe.constellation.orion.viewer.prefs.GlobalOptions;

/**
 * User: mike
 * Date: 15.10.11
 * Time: 9:53
 */
public interface LayoutStrategy {

    void nextPage(LayoutPosition pos);

    void prevPage(LayoutPosition pos);

    void reset(LayoutPosition pos, int pageNumber);

    void reset(LayoutPosition pos, int pageNumber, boolean forward);

    boolean changeRotation(int rotation);

    boolean changeOverlapping(int horizontal, int vertical);

    int getRotation();

    void reset(LayoutPosition info, boolean forward, PageInfo pageInfo, int cropMode, int zoom, boolean doCentering);

    boolean changeZoom(int zoom);

    int getZoom();

    boolean changeCropMargins(CropMargins cropMargins);

    CropMargins getMargins();

    void init(LastPageInfo info, GlobalOptions options);

    void serialize(LastPageInfo info);

    Point convertToPoint(LayoutPosition pos);

    int getLayout();

    String getWalkOrder();

    boolean changeNavigation(String walkOrder);

    boolean changePageLayout(int navigation);

    void setDimension(int width, int height);

    PageWalker getWalker();
}
