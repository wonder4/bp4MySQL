/**
 * 分页带ajax动态加载页面 需要引入jquery.js
 * 
 * @author ethanwoobolg@gmail.com
 * @version 1.0
 * @bulidDate 2012-02-13
 * @howUse 
 *  $.fn.pagination.addHiddenInputs("method", "list");
    $.fn.pagination.addHiddenInputs("mod_id", "${af.map.mod_id}");
	$("#Pagination").pagination({
		//isAllowAjax : true,
		//callback : genTable,
		pageForm : document.bottomPageForm,
		recordCount : parseFloat("${af.map.pager.recordCount}"),
		pageSize : parseFloat("${af.map.pager.pageSize}"),
		currentPage : parseFloat("${af.map.pager.currentPage - 1}")
	});
	function genTable (page_index, opts) {
		alert("page_index:" + page_index + " opts:" + $(opts.pageForm).serialize());
	}
 */

jQuery.fn.pagination = function(opts) {
	opts = jQuery.extend($.fn.pagination.defaults , opts || {});

	return this.each(function() {
		
		
		/**
		 * 计算最大分页显示数目
		 */
		function numPages() {
			return Math.ceil(opts.recordCount / opts.pageSize);
		}
		/**
		 * 极端分页的起始和结束点，这取决于currentPage 和 displayCount.
		 * 
		 * @返回 {数组(Array)}
		 */
		function getInterval() {
			var ne_half = Math.ceil(opts.displayCount / 2);
			var np = numPages();
			var upper_limit = np - opts.displayCount;
			var start = currentPage > ne_half ? Math.max(Math.min(currentPage
					- ne_half, upper_limit), 0) : 0;
			var end = currentPage > ne_half ? Math.min(currentPage + ne_half,
					np) : Math.min(opts.displayCount, np);
			return [ start, end ];
		}

		/**
		 * 分页链接事件处理函数
		 * 
		 * @参数 {int} page_id 为新页码
		 */
		function pageSelected(page_id, evt) {
			currentPage = page_id;
			drawLinks();
			var continuePropagation = opts.callback(page_id, panel);
			if (!continuePropagation) {
				if (evt.stopPropagation) {
					evt.stopPropagation();
				} else {
					evt.cancelBubble = true;
				}
			}
			return continuePropagation;
		}
		
		function pageSelectedAndSubmitForm(page_id, pageForm) {
			currentPage = page_id;
			drawLinks();
			pageForm.requestPage.value = page_id + 1;
			pageForm.submit();
			return ;
		}

		/**
		 * 此函数将分页链接插入到容器元素中
		 */
		function drawLinks() {
			panel.empty();
			var interval = getInterval();
			var np = numPages();
			// 这个辅助函数返回一个处理函数调用有着正确page_id的pageSelected。
			var getClickHandler = function(page_id) {
				if (opts.isAllowAjax) {
					return function(evt) {
						return pageSelected(page_id, evt);
					};
				} else {
					return function(evt) {
						return pageSelectedAndSubmitForm(page_id, opts.pageForm);
					};
				}
			};
			// 辅助函数用来产生一个单链接(如果不是当前页则产生span标签)
			var appendItem = function(page_id, appendopts) {
				page_id = page_id < 0 ? 0 : (page_id < np ? page_id : np - 1); // 规范page_id值
				appendopts = jQuery.extend( {
					text : page_id + 1,
					classes : ""
				}, appendopts || {});
				if (page_id == currentPage) {
					var lnk = jQuery("<span class='current'>"
							+ (appendopts.text) + "</span>");
				} else {
					var lnk = jQuery("<a>" + (appendopts.text) + "</a>").bind(
							"click", getClickHandler(page_id)).attr('href',
							opts.link_to.replace(/__id__/, page_id));
				}
				if (appendopts.classes) {
					lnk.addClass(appendopts.classes);
				}
				panel.append(lnk);
			};
			// 产生"Previous"-链接
			if (opts.prev_text && (currentPage > 0 || opts.prev_show_always)) {
				appendItem(currentPage - 1, {
					text : opts.prev_text,
					classes : "prev"
				});
			}
			// 产生起始点
			if (interval[0] > 0 && opts.num_edge_entries > 0) {
				var end = Math.min(opts.num_edge_entries, interval[0]);
				for ( var i = 0; i < end; i++) {
					appendItem(i);
				}
				if (opts.num_edge_entries < interval[0] && opts.ellipse_text) {
					jQuery("<span>" + opts.ellipse_text + "</span>").appendTo(
							panel);
				}
			}
			// 产生内部的些链接
			for ( var i = interval[0]; i < interval[1]; i++) {
				appendItem(i);
			}
			// 产生结束点
			if (interval[1] < np && opts.num_edge_entries > 0) {
				if (np - opts.num_edge_entries > interval[1]
						&& opts.ellipse_text) {
					jQuery("<span>" + opts.ellipse_text + "</span>").appendTo(
							panel);
				}
				var begin = Math.max(np - opts.num_edge_entries, interval[1]);
				for ( var i = begin; i < np; i++) {
					appendItem(i);
				}

			}
			// 产生 "Next"-链接
			if (opts.next_text
					&& (currentPage < np - 1 || opts.next_show_always)) {
				appendItem(currentPage + 1, {
					text : opts.next_text,
					classes : "next"
				});
			}
		}

		// 从选项中提取current_page
		var currentPage = opts.currentPage;
		// 创建一个显示条数和每页显示条数值
		opts.recordCount = (!opts.recordCount || opts.recordCount < 0) ? 1 : opts.recordCount;
		opts.pageSize = (!opts.pageSize || opts.pageSize < 0) ? 1
				: opts.pageSize;
		// 存储DOM元素，以方便从所有的内部结构中获取
		var panel = jQuery(this);
		// 获得附加功能的元素
		this.selectPage = function(page_id) {
			pageSelected(page_id);
		};
		this.prevPage = function() {
			if (currentPage > 0) {
				pageSelected(currentPage - 1);
				return true;
			} else {
				return false;
			}
		};
		this.nextPage = function() {
			if (currentPage < numPages() - 1) {
				pageSelected(currentPage + 1);
				return true;
			} else {
				return false;
			}
		};
		//加载CSS
		var stylepath = _getBasePath() + 'themes/' + opts.themeType + '/' + opts.themeType + '.css';
		_loadStyle(stylepath);
		
		// 所有初始化完成，绘制链接
		drawLinks();
		
		//加载隐藏参数
		var _hiddenInputStrings = [];
		for (var i = 0; i < opts._hiddenInputNameAndValues.length; i++){
			_hiddenInputStrings[_hiddenInputStrings.length] = '<input name="' + opts._hiddenInputNameAndValues[i][0] + '" type="hidden" id="' + opts._hiddenInputNameAndValues[i][0] + '" value="' + opts._hiddenInputNameAndValues[i][1] + '" />';
		}
		var hiddenElements = _hiddenInputStrings.join("").toString();
		panel.after("<span id='spanHiddenElements'>" + hiddenElements + "</span>");
		
		// 回调函数
		opts.callback(currentPage, opts);
		
		function _getBasePath() {
			var els = document.getElementsByTagName('script'), src;
			for (var i = 0, len = els.length; i < len; i++) {
				src = els[i].src || '';
				if (/pagination[\w\-\.]*\.js/.test(src)) {
					return src.substring(0, src.lastIndexOf('/') + 1);
				}
			}
			return '';
		}

		function _loadStyle(url) {
			var head = document.getElementsByTagName('head')[0] || (_QUIRKS ? document.body : document.documentElement),
				link = document.createElement('link');
			head.appendChild(link);
			link.href = url;
			link.rel = 'stylesheet';
		}
	});
};

$.fn.pagination.defaults = {
		pageForm : {},
		recordCount : 0, //总数
		pageSize : 10, //每页显示1项
		displayCount : 5,//主体显示页数
		currentPage : 0,
		num_edge_entries : 1, //边缘页数
		link_to : "#",
		prev_text : "上一页",
		next_text : "下一页",
		ellipse_text : "...",
		prev_show_always : true,
		next_show_always : true,
		isAllowAjax : false,
		_hiddenInputNameAndValues : [],
		themeType : 'default',
		basePath : [],
		callback : function() {
			return false;
		}
};
$.fn.pagination.addHiddenInputs = function (name, value) {
	$o = $.fn.pagination.defaults;  
	$o._hiddenInputNameAndValues[$o._hiddenInputNameAndValues.length] = new Array(name, value);
};



function confirmDeleteAll(form) {
	var checkedCount = 0;
	if (!form.pks) {
		return;
	}
	if(!form.pks.length) {
		if (form.pks.checked == true) {
			checkedCount = 1;
		}
	}
	for (var i = 0; i < form.pks.length; i++) {
		if (form.pks[i].checked == true) {
			checkedCount++;
		}
	}
	if (checkedCount == 0) {
		alert("\u8bf7\u81f3\u5c11\u9009\u62e9\u4e00\u4e2a\u5220\u9664\u9879\uff01");
	} else {
		if(confirm("\u786e\u5b9a\u8981\u5220\u9664\u6240\u6709\u9009\u4e2d\u7684\u9879\u5417\uff1f")) {
			form.method.value = "delete";
			form.submit();
		}
	}
}

function confirmDelete(msg, page, queryString) {
	msg  = msg  || "\u786e\u5b9a\u5220\u9664\u8fd9\u6761\u4fe1\u606f\u5417\uff1f";
	page = page || "?";
	page = page.indexOf("?") != -1 ? page : (page + "?");
	if(confirm(msg)){
		location.href = page + "method=delete&" + queryString;
	}
}

function confirmNeedMethod(msg, page, method, queryString) {
	msg  = msg  || "\u662f\u5426\u5173\u95ed\u6b64\u4efb\u52a1\u5355";
	page = page || "?";
	page = page.indexOf("?") != -1 ? page : (page + "?");
	if(confirm(msg)){
		location.href = page + "method=" + method + "&" + queryString;
	}
}

function confirmAudit(msg, page, method, queryString) {
	msg  = msg  || "\u786e\u5b9a\u5ba1\u6838\u901a\u8fc7\u5417?";
	page = page || "?";
	page = page.indexOf("?") != -1 ? page : (page + "?");
	if(confirm(msg)){
		location.href = page + "method=" + method + "&" + queryString;
	}
}

function confirmUpdate(msg, page, queryString) {
	//msg  = msg  || "\u786e\u5b9a\u4fee\u6539\u8fd9\u6761\u4fe1\u606f\u5417\uff1f";
	page = page || "?";
	page = page.indexOf("?") != -1 ? page : (page + "?");
	location.href = page  + "method=edit&" + queryString;
}

function doNeedMethod(msg, page, method, queryString) {
	//msg  = msg  || "\u786e\u5b9a\u4fee\u6539\u8fd9\u6761\u4fe1\u606f\u5417\uff1f";
	page = page || "?";
	page = page.indexOf("?") != -1 ? page : (page + "?");
	location.href = page  + "method=" + method + "&" + queryString;
}