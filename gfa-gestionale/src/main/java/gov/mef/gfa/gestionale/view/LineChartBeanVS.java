package gov.mef.gfa.gestionale.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.stereotype.Component;

import gov.mef.gfa.gestionale.service.DataService;

@Component
@ViewScoped
public class LineChartBeanVS implements Serializable {

	private static final long serialVersionUID = 8428907124804587443L;
	private LineChartModel lineModel;
	
	@PostConstruct
	public void init() {
		lineModel = new LineChartModel();
		LineChartSeries s = new LineChartSeries();
		s.setLabel("Population");

		lineModel.addSeries(s);
		lineModel.setLegendPosition("e");
		Axis y = lineModel.getAxis(AxisType.Y);
		y.setMin(0.5);
		y.setMax(700);
		y.setLabel("Millions");

		Axis x = lineModel.getAxis(AxisType.X);
		x.setMin(0);
		x.setMax(7);
		x.setTickInterval("1");
		x.setLabel("Number of Years");

	}

	public void chartCall() {		
		lineModel = new LineChartModel();
		LineChartSeries s = new LineChartSeries();
		DataService.getInstance().getLineChartData().forEach(s::set);
		s.setLabel("Population");

		lineModel.addSeries(s);
		lineModel.setLegendPosition("e");
		Axis y = lineModel.getAxis(AxisType.Y);
		y.setMin(0.5);
		y.setMax(700);
		y.setLabel("Millions");

		Axis x = lineModel.getAxis(AxisType.X);
		x.setMin(0);
		x.setMax(7);
		x.setTickInterval("1");
		x.setLabel("Number of Years");
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}

}
