/*
 * Copyright 2015 JBoss, by Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.ext.layout.editor.api.editor;

import java.util.ArrayList;
import java.util.List;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class LayoutRow {

    private List<LayoutColumn> layoutColumns = new ArrayList<LayoutColumn>();

    public LayoutRow() {

    }

    public List<LayoutColumn> getLayoutColumns() {
        return layoutColumns;
    }

    public void add(List<LayoutColumn> layoutColumn) {
        layoutColumns.addAll(layoutColumn);
    }

    public void add(LayoutColumn layoutColumn) {
        layoutColumns.add(layoutColumn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LayoutRow)) {
            return false;
        }

        LayoutRow layoutRow = (LayoutRow) o;

        if (layoutColumns != null ? !layoutColumns.equals(layoutRow.layoutColumns) : layoutRow.layoutColumns != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return layoutColumns != null ? layoutColumns.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LayoutRow{" +
                "layoutColumns=" + layoutColumns +
                '}';
    }
}
