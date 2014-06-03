<?xml version="1.0" encoding="GBK"?>
  <chart exportFileName="${((exportFileName)!' ')?html}" exportEnabled="1" exportAction="download" exportAtClient="0" exportHandler="${((ctx)!' ')?html}/FusionchartExporter.do" caption="${((caption)!' ')?html}" subcaption="${((unit)!' ')?html}" shownames="1" showvalues="0" decimals="2" formatNumberScale='0' numberPrefix="${((moneyUnit)!' ')?html}" useRoundEdges="1" legendBorderAlpha="0" baseFontColor="666666" baseFont="${((baseFont)!' ')?html}" BaseFontSize ="12">
    <categories>
     <#list baseChartList as cur>
	    <category label="${((cur.category_label)!' ')?html}" />
     </#list>
    </categories>
    <#list stackedColumn2DChartList as cur>
        <dataset seriesName="${((cur.series_name)!' ')?html}" showValues="0">
          <#list cur.baseChartList as cur_base>
	    	<set value="${((cur_base.value)!' ')?html}" />
          </#list>
        </dataset>
     </#list>
  </chart>