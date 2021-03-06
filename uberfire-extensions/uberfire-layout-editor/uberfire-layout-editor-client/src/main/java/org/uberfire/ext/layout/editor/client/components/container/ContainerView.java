/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.ext.layout.editor.client.components.container;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import org.jboss.errai.common.client.dom.Div;
import org.jboss.errai.common.client.dom.Span;
import org.jboss.errai.ui.client.local.api.IsElement;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.client.mvp.UberElement;
import org.uberfire.ext.layout.editor.client.components.rows.EmptyDropRow;
import org.uberfire.ext.layout.editor.client.components.rows.Row;
import org.uberfire.ext.layout.editor.client.infra.ContainerResizeEvent;

import static org.jboss.errai.common.client.dom.DOMUtil.addCSSClass;
import static org.jboss.errai.common.client.dom.DOMUtil.hasCSSClass;
import static org.jboss.errai.common.client.dom.DOMUtil.removeAllChildren;
import static org.jboss.errai.common.client.dom.DOMUtil.removeCSSClass;

@Dependent
@Templated
public class ContainerView
        implements UberElement<Container>,
                   Container.View,
                   IsElement {

    @Inject
    PlaceManager placeManager;
    @Inject
    @DataField
    Div layout;
    private Container presenter;
    @Inject
    @DataField
    private Span mobile;

    @Inject
    @DataField
    private Span tablet;

    @Inject
    @DataField
    private Span desktop;

    @Inject
    private Event<ContainerResizeEvent> resizeEvent;

    @Override
    public void init(Container presenter) {
        this.presenter = presenter;
    }

    @EventHandler("mobile")
    public void mobileSize(ClickEvent e) {
        removeCSSClass(layout,
                       "simulate-sm");
        addCSSClass(layout,
                    "simulate-xs");
        resizeEvent.fire(new ContainerResizeEvent());
    }

    @EventHandler("tablet")
    public void tabletSize(ClickEvent e) {
        addCSSClass(layout,
                    "simulate-sm");
        removeCSSClass(layout,
                       "simulate-xs");
        resizeEvent.fire(new ContainerResizeEvent());
    }

    @EventHandler("desktop")
    public void desktopSize(ClickEvent e) {
        removeCSSClass(layout,
                       "simulate-xs");
        removeCSSClass(layout,
                       "simulate-sm");
        resizeEvent.fire(new ContainerResizeEvent());
    }

    @Override
    public void addRow(UberElement<Row> view) {
        if (!hasCSSClass(layout,
                         "container-canvas")) {
            addCSSClass(layout,
                        "container-canvas");
        }
        removeCSSClass(layout,
                       "container-empty");
        layout.appendChild(view.getElement());
    }

    @Override
    public void clear() {
        removeAllChildren(layout);
    }

    @Override
    public void addEmptyRow(UberElement<EmptyDropRow> emptyDropRow) {
        removeCSSClass(layout,
                       "container-canvas");
        addCSSClass(layout,
                    "container-empty");
        layout.appendChild(emptyDropRow.getElement());
    }
}
