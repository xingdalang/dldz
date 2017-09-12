package com.dzm.dldz.qo;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class QueryObject {
	private Integer currentPage = 1;
	private Integer pageSize = 10;
	private Integer totalPage = 1;
}
