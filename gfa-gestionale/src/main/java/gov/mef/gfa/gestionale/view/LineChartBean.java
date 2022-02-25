package gov.mef.gfa.gestionale.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import gov.mef.gfa.common.bean.anagrafica.EntePO;
import gov.mef.gfa.gestionale.service.DataService;

@Component
@SessionScope
public class LineChartBean implements Serializable {

	private static final long serialVersionUID = 8501214126784647065L;
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

	public String getEnteById(Integer id) {
		EntePO enteRes = DataService.getInstance().getEnteById(id).getEnte();
		if (enteRes != null)
			return DataService.getInstance().getEnteById(id).getEnte().getId().toString();
		
		return "Nessun valore";
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}

}
