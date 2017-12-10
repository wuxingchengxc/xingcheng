package com.atguigu0210.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class OBJECT_MY_T_MALL_SKU {

	private int id;
	private int shp_id;
	private int kc;
	private BigDecimal jg;
	private Date chjshj;
	private String sku_mch;
	private String kcdz;
	//封装的属性关联
	private List<OBJECT_T_MALL_ATTR_VALUE> list_attr_vlue_name ;
	
	private List<T_MALL_PRODUCT_IMAGE> list_imge;
	
	private T_MALL_PRODUCT spu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShp_id() {
		return shp_id;
	}

	public void setShp_id(int shp_id) {
		this.shp_id = shp_id;
	}

	public int getKc() {
		return kc;
	}

	public void setKc(int kc) {
		this.kc = kc;
	}

	public BigDecimal getJg() {
		return jg;
	}

	public void setJg(BigDecimal jg) {
		this.jg = jg;
	}

	public Date getChjshj() {
		return chjshj;
	}

	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}

	public String getSku_mch() {
		return sku_mch;
	}

	public void setSku_mch(String sku_mch) {
		this.sku_mch = sku_mch;
	}

	public String getKcdz() {
		return kcdz;
	}

	public void setKcdz(String kcdz) {
		this.kcdz = kcdz;
	}

	public List<OBJECT_T_MALL_ATTR_VALUE> getList_attr_vlue_name() {
		return list_attr_vlue_name;
	}

	public void setList_attr_vlue_name(List<OBJECT_T_MALL_ATTR_VALUE> list_attr_vlue_name) {
		this.list_attr_vlue_name = list_attr_vlue_name;
	}

	public List<T_MALL_PRODUCT_IMAGE> getList_imge() {
		return list_imge;
	}

	public void setList_imge(List<T_MALL_PRODUCT_IMAGE> list_imge) {
		this.list_imge = list_imge;
	}

	public T_MALL_PRODUCT getSpu() {
		return spu;
	}

	public void setSpu(T_MALL_PRODUCT spu) {
		this.spu = spu;
	}
	
}
