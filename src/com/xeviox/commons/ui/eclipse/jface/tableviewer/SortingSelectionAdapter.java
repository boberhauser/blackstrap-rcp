/*******************************************************************************
 * Copyright (c) 2013 Benjamin Pabst and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Benjamin Pabst - initial API and implementation
 *    Tobias Placht
 ******************************************************************************/

package com.xeviox.commons.ui.eclipse.jface.tableviewer;

import java.util.Arrays;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;

public class SortingSelectionAdapter<T> extends SelectionAdapter {
    private final TableViewer viewer;
    private final ColumnComparator<T> comparator;
    private TableColumn lastSelection;
    private Direction dir = Direction.ASCENDING;

    public SortingSelectionAdapter(final TableViewer viewer, final ColumnComparator<T> comparator) {
        super();

        this.viewer = viewer;
        this.comparator = comparator;
    }

    @Override
    public void widgetSelected(SelectionEvent e) {
        if (!(e.getSource() instanceof TableColumn)) {
            throw new IllegalArgumentException("Can only sort TableColumns.");
        }

        TableColumn currentCol = (TableColumn) e.getSource();

        if (lastSelection != null && lastSelection.equals(currentCol)) {
            if (dir == Direction.ASCENDING) {
                dir = Direction.DESCENDING;
            }
            else {
                dir = Direction.ASCENDING;
            }
        }

        lastSelection = currentCol;

        int columnIndex = Arrays.asList(viewer.getTable().getColumns()).indexOf(e.getSource());
        comparator.setCurrentColumnIndex(columnIndex);
        comparator.setDirection(dir);
        viewer.getTable().setSortDirection(dir.getValue());
        viewer.getTable().setSortColumn(currentCol);
        viewer.refresh();

    }
}
