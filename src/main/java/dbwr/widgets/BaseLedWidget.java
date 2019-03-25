/*******************************************************************************
 * Copyright (c) 2019 Oak Ridge National Laboratory.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the LICENSE
 * which accompanies this distribution
 ******************************************************************************/
package dbwr.widgets;

import java.io.PrintWriter;

import org.w3c.dom.Element;

import dbwr.parser.WidgetFactory;
import dbwr.parser.XMLUtil;

public class BaseLedWidget extends SvgPVWidget
{
    static
    {
        WidgetFactory.addCSS("led.css");
    }

    private final boolean square;

    protected BaseLedWidget(final ParentWidget parent, final Element xml, final String type) throws Exception
	{
		super(parent, xml, type, 20, 20);
		classes.add("Led");
		square = XMLUtil.getChildBoolean(xml, "square")
                        .orElse(XMLUtil.getChildBoolean(xml, "square_led").orElse(false));

	}

	@Override
	protected void fillHTML(final PrintWriter html, final int indent)
	{
	    if (square)
            html.append("<rect x=\"" + 0 + "\" y=\"" +  0 + "\" width=\"" + width + "\" height=\"" + height + "\" fill=\"grey\"></rect>");
	    else
	    {
    		final int rx = width/2, ry = height/2;
    		html.append("<ellipse cx=\"" + rx + "\" cy=\"" +  ry + "\" rx=\"" + rx + "\" ry=\"" + ry + "\" fill=\"grey\"></ellipse>");
	    }
	}
}
