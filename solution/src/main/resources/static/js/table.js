//==============================================================================================
function tableCreate(url, nowPage, cntPerPage) {
	// table option default
	let option = false;
	// default paging parameter value set
	if (nowPage === undefined) nowPage = '1';
	if (cntPerPage === undefined) cntPerPage = '10';
	// axios => async/await
	const promiseData = async () => {
		try {
			// get request => paging data
			const pagingData = await axios.get(`/${url}Paging?nowPage=${nowPage}&cntPerPage=${cntPerPage}`),
				// string type => object type(parse)
				result = await JSON.parse(pagingData.data.paging),
				// get request => table data
				tableData = await axios.get(`/${url}Select?start=${result.start}&end=${result.end}`),
				table = await tableData.data;
			// paging write html
			pagingHtml(url, result);
			// table write html
			tableHtml(url, table, result, option);
		} catch (err) {
			console.log(err);
		}
	}

	return promiseData();
}
//==============================================================================================
function pagingHtml(url, res) {
	let addHtml = '';

	addHtml += `<ul class="pagination">`;
	if (res.startPage != 1) {
		addHtml += `<li class="page-item previous"><a class="page-link" onclick="tableCreate('${url}', ${res.startPage - 1}, ${res.cntPerPage});">이전</a></li>`;
	}
	for (let start = res.startPage; start <= res.endPage; start++) {
		if (start == res.nowPage) {
			addHtml += `<li class="page-item"><b class="page-link">${start}</b></li>`;
		}
		if (start != res.nowPage) {
			addHtml += `<li class="page-item"><a class="page-link" onclick="tableCreate('${url}', ${start}, ${res.cntPerPage});">${start}</a></li>`;
		}
	}
	if (res.endPage != res.lastPage) {
		addHtml += `<li class="page-item next"><a class="page-link" onclick="tableCreate('${url}', ${res.endPage + 1}, ${res.cntPerPage});">다음</a></li>`;
	}
	addHtml += `</ul>`;

	return document.querySelector('#paging').innerHTML = addHtml;
}
//==============================================================================================