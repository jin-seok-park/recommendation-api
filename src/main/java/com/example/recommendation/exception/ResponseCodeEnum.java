package com.example.recommendation.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseCodeEnum {

    NORMAL("0000", "정상"),
    NOT_FOUND_BRAND("ER0001", "브랜드 정보가 없습니다."),
    NOT_FOUND_PRODUCT("ER0002", "상품 정보가 없습니다."),
    NOT_FOUND_BRAND_PRODUCT("ER0003", "브랜드의 상품 정보가 없습니다."),
    NOT_FOUND_CATEGORY("ER0004", "카테고리 정보가 없습니다."),
    REQUEST_BRAND_CD_NULL("ER0005", "요청하신 정보중 브랜드 코드가 존재하지 않습니다."),
    REQUEST_BRAND_NAME_NULL("ER0006", "요청하신 정보중 브랜드 이름이 존재하지 않습니다."),
    DELETE_BRAND_FAIL("ER0007", "삭제할 브랜드 코드가 존재하지 않습니다."),
    REQUEST_PRODUCT_CATEGORY_CD_NULL("ER0008", "요청하신 정보 중 카테고리 코드가 존재하지 않습니다."),
    REQUEST_PRODUCT_NAME_NULL("ER0009", "요청하신 정보 중 상품 이름이 존재하지 않습니다."),
    REQUEST_PRODUCT_COUNT_NULL("ER0010", "요청하신 정보 중 상품 수량이 존재하지 않습니다."),
    REQUEST_PRODUCT_REQUESTER_NULL("ER0011", "요청하신 정보 중 사용자 정보가 존재하지 않습니다."),
    DELETE_PRODUCT_FAIL("ER0012", "삭제할 상품 번호가 존재하지 않습니다."),
    NOT_FOUND_SALE_STATUS("ER0013", "판매 상태를 찾을 수 없습니다."),
    DUPLICATION_FAIL("ER0014", "동일 브랜드/카테고리가 이미 존재합니다."),
    DUPLICATION_BRAND_FAIL("ER0015", "동일 브랜드가 이미 존재합니다."),
    REQUEST_PRODUCT_NO_NULL("ER0016", "요청하신 정보 중 상품번호가 존재하지 않습니다."),
    REQUEST_SALE_STATUS_NULL("ER0017", "요청하신 정보 중 상품 판매 상태가 존재하지 않습니다."),
    EXIST_BRAND_PRODUCT("ER0018", "삭제하려는 브랜드의 상품이 존재합니다. 상품부터 삭제되어야 합니다."),
    REQUEST_PRIORITY_NULL("ER0019", "요청하신 정보 중 노출 우선순위가 존재하지 않습니다.")
    ;

    private final String code;
    private final String message;


}
