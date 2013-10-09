/*******************************************************************************
 * Copyright (c) 2013 Benjamin Pabst and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Benjamin Pabst - initial API and implementation
 *    Tobias Placht  - additional funcionality
 ******************************************************************************/

package com.xeviox.commons.ui.eclipse.jface.tableviewer;

import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import static com.xeviox.commons.conditions.Clauses.when;
import static com.xeviox.commons.conditions.Clauses.nullChecked;

public class ColumnComparator<T> extends ViewerComparator {
    private final List<ColumnDescription<T>> descriptions;
    private int currentColIndex = -1;
    private Direction direction;
    private int sortColumn;

    public ColumnComparator(final List<ColumnDescription<T>> descriptions, int sortColumn,
            Direction direction) {
        super();

        nullChecked(descriptions, "You have to specify the list of column descriptions.");
        when(descriptions.size() < 0).throwIllegalState(
                "You have to specify a non empty list of column descriptions.");
        this.descriptions = descriptions;
        this.sortColumn = sortColumn;
        this.direction = direction;
    }

    @Override
    public int compare(Viewer viewer, Object e1, Object e2) {
        Comparator<T> comparator = null;
        if (currentColIndex < 0) {
            // We use the column speciefied in the constructor if none is selected
            comparator = descriptions.get(sortColumn).getComparator();
        }
        else {
            comparator = descriptions.get(currentColIndex).getComparator();
        }

        // TODO check instance!
        @SuppressWarnings("unchecked")
        T o1 = (T) e1;
        @SuppressWarnings("unchecked")
        T o2 = (T) e2;

        int result = comparator.compare(o1, o2);

        if (direction == Direction.DESCENDING) {
            result = -result;
        }

        return result;
    }

    public void setCurrentColumnIndex(final int index) {
        this.currentColIndex = index;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }
}
