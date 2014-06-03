package com.ebiz.bp_mysql.web.util;

import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ebiz.bp_mysql.domain.NewsInfo;

public class ScriptUtils {

	private static final Logger logger = LoggerFactory.getLogger(ScriptUtils.class);

	/**
	 * CascadeSelect's nodes is contains with javascript arrays with strutcture like this: [[parent, text,
	 * value],[],...[]]
	 * 
	 * @param c Collection
	 * @param parentProperty
	 * @param textProperty
	 * @param valueProperty
	 * @return String
	 */
	public static String getCascadeSelectString(List<NewsInfo> newsInfoList, String parentProperty,
			String textProperty, String valueProperty) {
		StringBuffer buffer = new StringBuffer();
		for (NewsInfo o : newsInfoList) {
			String parent = "";
			String text = "";
			String value = "";
			try {
				parent = BeanUtils.getProperty(o, parentProperty);
				text = BeanUtils.getProperty(o, textProperty);
				value = BeanUtils.getProperty(o, valueProperty);
			} catch (Exception ex) {
				logger.error(ex.getMessage());
			}
			buffer.append("['").append(parent).append("','").append(StringUtils.replace(text, "\'", "\\\'")).append(
					"','").append(value).append("'],");
		}
		buffer.append("{}");
		return StringEscapeUtils.escapeJavaScript((new StringBuffer("[").append(buffer).append("]")).toString());
	}

	/**
	 * @param c
	 * @param imgProperty
	 * @param txtProperty
	 * @param lnkProperty
	 * @return
	 * @see #getPptJsonString(Collection, String, String, String,String, String)
	 */
	public static String getPptJsonString(List<NewsInfo> newsInfoList, String imgProperty, String txtProperty,
			String lnkProperty) {
		return ScriptUtils.getPptJsonString(newsInfoList, imgProperty, txtProperty, lnkProperty, "news/view.tdb", null);
	}

	/**
	 * @param c
	 * @param imgProperty
	 * @param txtProperty
	 * @param lnkProperty
	 * @param linkURI
	 * @return
	 * @see #getPptJsonString(Collection, String, String, String,String, String)
	 */
	public static String getPptJsonString(List<NewsInfo> newsInfoList, String imgProperty, String txtProperty,
			String lnkProperty, String linkURI) {
		return ScriptUtils.getPptJsonString(newsInfoList, imgProperty, txtProperty, lnkProperty, linkURI, null);
	}

	/**
	 * @param c Collection
	 * @param imgProperty
	 * @param txtProperty
	 * @param lnkProperty
	 * @param linkURI default is "news/view.tdb"
	 * @param siteURI default is "" link to other or absoult uri e.g. http://photo.163.com/
	 * @return String
	 */
	public static String getPptJsonString(List<NewsInfo> newsInfoList, String imgProperty, String txtProperty,
			String lnkProperty, String linkURI, String siteURI) {

		linkURI = StringUtils.isNotBlank(linkURI) ? linkURI : "news/view.tdb";
		siteURI = StringUtils.isNotBlank(siteURI) ? siteURI : "";

		linkURI = linkURI.indexOf("?") == -1 ? linkURI + "?id=" : linkURI + "&id=";

		StringBuffer buffer = new StringBuffer();
		for (NewsInfo o : newsInfoList) {
			String img = "";
			String txt = "";
			String lnk = "";
			try {
				img = BeanUtils.getProperty(o, imgProperty);
				txt = BeanUtils.getProperty(o, txtProperty);
				lnk = BeanUtils.getProperty(o, lnkProperty);
			} catch (Exception ex) {
				logger.error(ex.getMessage());
			}
			buffer.append("{");
			buffer.append("img:'").append(siteURI).append(img).append("',");
			try {
				buffer.append("txt:'").append(URLEncoder.encode(StringUtils.replace(txt, "\'", "\\\'"), "UTF-8"))
						.append("',");
			} catch (Exception e) {
				e.printStackTrace();
			}
			buffer.append("lnk:escape('").append(linkURI).append(lnk).append("')},");
		}
		buffer.append("{}");
		return buffer.toString();
	}

	public static String getPptJsonStringWithUrlRewrite(List<NewsInfo> newsInfoList, String imgProperty,
			String txtProperty, String lnkProperty, String linkURI, String siteURI) {

		linkURI = StringUtils.isNotBlank(linkURI) ? linkURI : "news/view.tdb";
		siteURI = StringUtils.isNotBlank(siteURI) ? siteURI : "";

		// linkURI = linkURI.indexOf("?") == -1 ? linkURI + "?id=" : linkURI +
		// "&id=";

		StringBuffer buffer = new StringBuffer();
		for (Object o : newsInfoList) {
			String img = "";
			String txt = "";
			String lnk = "";
			try {
				img = BeanUtils.getProperty(o, imgProperty);
				txt = BeanUtils.getProperty(o, txtProperty);
				lnk = BeanUtils.getProperty(o, lnkProperty);
			} catch (Exception ex) {
				logger.error(ex.getMessage());
			}
			buffer.append("{");
			buffer.append("img:'").append(siteURI).append(img).append("',");
			try {
				buffer.append("txt:'").append(URLEncoder.encode(StringUtils.replace(txt, "\'", "\\\'"), "UTF-8"))
						.append("',");
			} catch (Exception e) {
				e.printStackTrace();
			}
			buffer.append("lnk:escape('").append(linkURI).append(lnk).append(".xhtml')},");
		}
		buffer.append("{}");
		return buffer.toString();
	}
}
