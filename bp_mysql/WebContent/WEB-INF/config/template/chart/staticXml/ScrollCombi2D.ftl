<?xml version="1.0" encoding="GBK"?>
<chart exportFileName="${((exportFileName)!" ")?html}" exportEnabled="1" exportAction="download" exportAtClient="0" exportHandler="${((ctx)!" ")?html}/FusionchartExporter.do" caption="Hits per hour" lineThickness="2" showValues="0"  areaOverColumns="0" formatNumberScale="0" useRoundEdges="1" palette="2" legendBorderAlpha="0">
	<categories >
		<category label="00:00" />
		<category label="01:00" />
		<category label="02:00" />
		<category label="03:00" />
		<category label="04:00" />
		<category label="05:00" />
		<category label="06:00" />
		<category label="07:00" />
		<category label="08:00" />
		<category label="09:00" />
		<category label="10:00" />
		<category label="11:00" />
		<category label="12:00" />
		<category label="13:00" />
		<category label="14:00" />
		<category label="15:00" />
		<category label="16:00" />
		<category label="17:00" />
		<category label="18:00" />
		<category label="19:00" />
		<category label="20:00" />
		<category label="21:00" />
		<category label="22:00" />
		<category label="23:00" />
	</categories>

	<dataset seriesName="Expected" renderAs="Area" alpha="60" showPlotBorder="1" plotBorderColor="0372ab">
		<set value="498" />
		<set value="512" />
		<set value="592" />
		<set value="619" />
		<set value="664" />
		<set value="782" />
		<set value="665" />
		<set value="833" />
		<set value="1259" />
		<set value="1623" />
		<set value="1867" />
		<set value="2198" />
		<set value="1112" />
		<set value="1192" />
		<set value="1219" />
		<set value="2264" />
		<set value="2282" />
		<set value="2365" />
		<set value="2433" />
		<set value="2559" />
		<set value="2823" />
		<set value="2867" />
		<set value="2867" />
		<set value="2867" />
	</dataset>


	<dataset seriesName="Actuals - Monday" >
		<set value="${((id)!' ')?html}" />
		<set value="371" />
		<set value="485" />
		<set value="592" />
		<set value="601" />
		<set value="716" />
		<set value="864" />
		<set value="880" />
		<set value="992" />
		<set value="1062" />
		<set value="1119" />
		<set value="1089" />
		<set value="1212" />
		<set value="904" />
		<set value="1215" />
		<set value="1358" />
		<set value="1482" />
		<set value="1666" />
		<set value="1811" />
		<set value="2051" />
		<set value="2138" />
		<set value="2209" />
		<set value="2247" />
		<set value="2301" />
	</dataset>

	<dataset seriesName="Actuals - Tuesday">
		<set value="854" />
		<set value="965" />
		<set value="1175" />
		<set value="1190" />
		<set value="1212" />
		<set value="1241" />
		<set value="1308" />
		<set value="1401" />
		<set value="1481" />
		<set value="1851" />
		<set value="1250" />
		<set value="2415" />
		<set value="2886" />
		<set value="3252" />
		<set value="3673" />
		<set value="4026" />
		<set value="4470" />
		<set value="4813" />
		<set value="4961" />
		<set value="5086" />
		<set value="5284" />
		<set value="5391" />
		<set value="5657" />
		<set value="5847" />
	</dataset>
	
	<dataset seriesName="Average" renderAs="Line" color="0372AB" lineThickness="2">
		<set value="511" />
		<set value="520" />
		<set value="628" />
		<set value="640" />
		<set value="746" />
		<set value="757" />
		<set value="890" />
		<set value="1050" />
		<set value="1099" />
		<set value="1191" />
		<set value="1252" />
		<set value="1448" />
		<set value="1771" />
		<set value="2316" />
		<set value="2763" />
		<set value="3149" />
		<set value="3637" />
		<set value="4015" />
		<set value="4262" />
		<set value="4541" />
		<set value="4837" />
		<set value="5016" />
		<set value="5133" />
		<set value="5278" />
	</dataset>
	<trendLines>
		<line startValue="4500" color="359A35" displayvalue="Good" valueOnRight="1"/> 
	</trendLines>

</chart>