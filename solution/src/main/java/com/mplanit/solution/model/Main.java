package com.mplanit.solution.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Main {

	private int map_seq; // 맵순번
	private String product_seq; // 상품순번
	private String brand; // 브랜드
	private String product_name; // 상품명
	private String product_code; // 상품코드
	private int    quantity; // 수량
	private String purchasing_agent; // 구매대행(제품명)
	private String item; // 품목
	private String tax; // 신고가격
	private String supplier; // 거래처
	private String image_url; // 제품이미지주소
	private String image; // 제품이미지
	private String purchase_price_usd; // 구매단가(달러)
	private String purchase_price_krw; // 구매단가(한화)

}
