package com.mplanit.solution.utils.pagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingVo {

	// 현재페이지, 시작페이지, 끝페이지, 게시글 총 갯수, 페이지당 글 갯수, 마지막페이지, SQL쿼리에 쓸 start, end
	private int nowPage, startPage, endPage, total, cntPerPage, lastPage, start, end;
	private int cntPage = 5;

	// Default constructor
	public PagingVo() {}

	// Constructor
	public PagingVo(int total, int nowPage, int cntPerPage) {
		
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
	}

	// Start, End Page
	public void calcStartEndPage(int nowPage, int cntPage) {
		
		setEndPage(((int) Math.ceil((double) nowPage / (double) cntPage)) * cntPage);
		if (getLastPage() < getEndPage()) setEndPage(getLastPage());
		setStartPage(getEndPage() - cntPage + 1);
		if (getStartPage() < 1) setStartPage(1);
	}

	// Last Page
	public void calcLastPage(int total, int cntPerPage) {
		
		setLastPage((int) Math.ceil((double) total / (double) cntPerPage));
	}

	// DB => Start, End값 계산
	public void calcStartEnd(int nowPage, int cntPerPage) {
		
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage + 1);
	}

	@Override
	public String toString() {
		
		return "{\"nowPage\": " + nowPage + ", \"startPage\": " + startPage + ", \"endPage\": " + endPage + ", \"total\": " + total + ", \"cntPerPage\": " + cntPerPage + ", \"lastPage\": " + lastPage + ", \"start\": " + start + ", \"end\": " + end + ", \"cntPage\": " + cntPage + "}";
	}
}
