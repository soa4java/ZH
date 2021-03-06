package com.lakecloud.foundation.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.lakecloud.core.constant.Globals;
import com.lakecloud.core.domain.IdEntity;

/**
 * @info 商城活动商品类,参加活动的商品提交到该类中进行管理，审核后通过后的商品在活动页显示，同时活动过期后系统定时器自动将处理活动商品
 * @since V1.0
 * @author 江苏太湖云计算信息技术股份有限公司 www.chinacloud.net erikchang
 * 
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = Globals.DEFAULT_TABLE_SUFFIX + "activity_goods")
public class ActivityGoods extends IdEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private Goods ag_goods;// 活动商品
	private int ag_status;// 活动商品审核状态，0为待审核，1为审核通过，-1为审核拒绝,-2为已经到期关闭
	@ManyToOne(fetch = FetchType.LAZY)
	private User ag_admin;// 活动审核管理员
	@ManyToOne(fetch = FetchType.LAZY)
	private Activity act;// 对应的活动
	@Column(precision = 12, scale = 2)
	private BigDecimal ag_price;// 活动价格

	public Activity getAct() {
		return act;
	}

	public void setAct(Activity act) {
		this.act = act;
	}

	public Goods getAg_goods() {
		return ag_goods;
	}

	public void setAg_goods(Goods ag_goods) {
		this.ag_goods = ag_goods;
	}

	public int getAg_status() {
		return ag_status;
	}

	public void setAg_status(int ag_status) {
		this.ag_status = ag_status;
	}

	public User getAg_admin() {
		return ag_admin;
	}

	public void setAg_admin(User ag_admin) {
		this.ag_admin = ag_admin;
	}

	public BigDecimal getAg_price() {
		return ag_price;
	}

	public void setAg_price(BigDecimal ag_price) {
		this.ag_price = ag_price;
	}
}
