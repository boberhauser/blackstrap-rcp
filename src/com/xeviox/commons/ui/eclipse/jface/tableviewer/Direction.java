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

import org.eclipse.swt.SWT;

public enum Direction {
    ASCENDING(SWT.UP), DESCENDING(SWT.DOWN);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
