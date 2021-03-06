<!-- 450 x 400 -->
<chart exportFileName="${((exportFileName)!" ")?html}" exportEnabled="1" exportAction="download" exportAtClient="0" exportHandler="${((ctx)!" ")?html}/FusionchartExporter.do" caption="Company Revenue" palette="1" showValues="0" yAxisValuesPadding="10" numberPrefix="$" chartOrder="line,area,column" startAngX="8" startAngY="-32" endAngX="8" endAngY="-32" zdepth="50" zgapPlot="10" showPlotBorder="0" dynamicShading="1"  showAlternateHGridColor="1">	
	<categories>
		<category label="Aug 05" />
		<category label="Sep 05" />
		<category label="Oct 05" />
		<category label="Nov 05" />
		<category label="Dec 05" />
        </categories>

	<dataset seriesName="Product A">

		<set value="${((id)!' ')?html}" />
		<set value="34300" />
		<set value="30000" />
		<set value="27800" />
		<set value="25000" />
	</dataset>

	<dataset seriesname="Product B">
		<set value="31000" />

		<set value="29300" />
		<set value="26000" />
		<set value="21000" />
		<set value="20500" />
	</dataset>
	
	<dataset seriesname="Predicted" renderAs="Line">
		<set value="25000" />
		<set value="21000" />
		<set value="20000" />

		<set value="22000" />
		<set value="14500" />
	</dataset>

	<dataset seriesname="2004 Avg." renderAs="Area" >
		<set value="17000" />
		<set value="15000" />
		<set value="16000" />
		<set value="11500" />

		<set value="10000" />
	</dataset>

</chart>
