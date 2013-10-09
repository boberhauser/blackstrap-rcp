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

import java.util.Comparator;

import org.eclipse.jface.viewers.BaseLabelProvider;

public class ColumnDescription<T> {
    private final String header;
    private final BaseLabelProvider labelProvider;
    private final Comparator<T> comparator;
    private final int width;

    public ColumnDescription(String header, BaseLabelProvider labelProvider,
            Comparator<T> comparator) {
        this(header, labelProvider, comparator, 200);
    }

    public ColumnDescription(String header, BaseLabelProvider labelProvider,
            Comparator<T> comparator, int width) {

        this.header = header;
        this.labelProvider = labelProvider;
        this.comparator = comparator;
        this.width = width;
    }

    public String getHeader() {
        return header;
    }

    public BaseLabelProvider getLabelProvider() {
        return labelProvider;
    }

    public Comparator<T> getComparator() {
        return comparator;
    }

    public int getWidth() {
        return width;
    }
}
