<?xml version="1.0" encoding="GBK"?>
<chart exportFileName="${((exportFileName)!" ")?html}" exportEnabled="1" exportAction="download" exportAtClient="0" exportHandler="${((ctx)!" ")?html}/FusionchartExporter.do" caption="Production Forecast" yAxisName="Units" bgColor="F7F7F7, E9E9E9" numVDivLines="10" divLineAlpha="30"  labelPadding ="10" yAxisValuesPadding ="10" showValues="1" rotateValues="1" valuePosition="auto">
	<categories>
		<category label="2006" /> 
		<category label="2007" /> 
		<category label="2008" /> 
		<category label="2009" /> 
		<category label="2010" /> 
		<category label="2011" /> 
	</categories>

	<dataset seriesName="Model A12" color="A66EDD" >
		<set value="${((id)!" ")?html}" /> 
		<set value="42" /> 
		<set value="31" /> 
		<set value="28" /> 
		<set value="34" /> 
		<set value="30" /> 
	</dataset>

	<dataset seriesName="Model A15" color="F6BD0F">
		<set value="22" /> 
		<set value="25" /> 
		<set value="18" /> 
		<set value="22" /> 
		<set value="17" /> 
		<set value="16" /> 
	</dataset>

</chart>