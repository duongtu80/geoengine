<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.awt.*,org.jCharts.*,org.jCharts.chartData.*,org.jCharts.properties.*,org.jCharts.types.ChartType,org.jCharts.axisChart.*,org.jCharts.test.TestDataGenerator,org.jCharts.encoders.JPEGEncoder13"%>

<%
/**************************************************************************************
* Copyright 2002 (C) Nathaniel G. Auvil. All Rights Reserved.
*
* Redistribution and use of this software and associated documentation
* ("Software"), with or without modification, are permitted provided
* that the following conditions are met:
*
* 1. Redistributions of source code must retain copyright
*    statements and notices.  Redistributions must also contain a
*    copy of this document.
*
* 2. Redistributions in binary form must reproduce the
*    above copyright notice, this list of conditions and the
*    following disclaimer in the documentation and/or other
*    materials provided with the distribution.
*
* 3. The name "jCharts" or "Nathaniel G. Auvil" must not be used to
* 	  endorse or promote products derived from this Software without
* 	  prior written permission of Nathaniel G. Auvil.  For written
*    permission, please contact nathaniel_auvil@users.sourceforge.net
*
* 4. Products derived from this Software may not be called "jCharts"
*    nor may "jCharts" appear in their names without prior written
*    permission of Nathaniel G. Auvil. jCharts is a registered
*    trademark of Nathaniel G. Auvil.
*
* 5. Due credit should be given to the jCharts Project
*    (http://jcharts.sourceforge.net/).
*
* THIS SOFTWARE IS PROVIDED BY Nathaniel G. Auvil AND CONTRIBUTORS
* ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT
* NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL
* jCharts OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
* INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
* (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
* HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
* STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
* ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
* OF THE POSSIBILITY OF SUCH DAMAGE.
**********************************************************************************/

%>


<%
	try
	{
		//From AxisChartServlet.java:init()
		LegendProperties legendProperties = new LegendProperties();
		ChartProperties chartProperties = new ChartProperties();
		AxisProperties axisProperties = new AxisProperties();
		axisProperties.setScaleFont( new Font( "Georgia Negreta cursiva", Font.PLAIN,13 ) );
		axisProperties.setAxisTitleFont( new Font( "Arial Narrow", Font.PLAIN, 14) );
		
		//From LineChartServlet.java:init()
		Stroke[] strokes= { LineChartProperties.DEFAULT_LINE_STROKE, LineChartProperties.DEFAULT_LINE_STROKE, LineChartProperties.DEFAULT_LINE_STROKE };
		Shape[] shapes= { PointChartProperties.SHAPE_TRIANGLE,PointChartProperties.SHAPE_DIAMOND, PointChartProperties.SHAPE_CIRCLE };
		LineChartProperties lineChartProperties = new LineChartProperties(strokes,shapes);
		
		//From AxisChartServlet.java:createDataSeries()
		String[] xAxisLabels= { "1998", "1999", "2000", "2001", "2002", "2003", "2004"};
		String xAxisTitle= "Years";
		String yAxisTitle= "Problems";
		String title= "Micro$oft At Work";
		DataSeries dataSeries = new DataSeries( xAxisLabels, xAxisTitle, yAxisTitle,title );
		
				
		//From AxisChartServlet.java:createAxisChartDataSet
		double[][] data= TestDataGenerator.getRandomNumbers( 3, 7, 200, 500 );
		String[] legendLabels= { "Bugs", "Security Holes", "Backdoors" };
		Paint[] paints= TestDataGenerator.getRandomPaints( 3 );
		AxisChartDataSet acds = new AxisChartDataSet(data, legendLabels, paints,ChartType.LINE, lineChartProperties );
		dataSeries.addIAxisChartDataSet(acds);
		AxisChart axisChart = new AxisChart(dataSeries, chartProperties, axisProperties,legendProperties, 550, 360);
	
		JPEGEncoder13.encode(axisChart, 1.0f, response);
	
	}
	catch(Exception e)
	{
		out.println("<p>" + e);
		out.println("<p>" + e.getMessage());
	}
	
%>