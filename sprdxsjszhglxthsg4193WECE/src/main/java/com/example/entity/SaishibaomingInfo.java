package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "saishibaoming_info")
public class SaishibaomingInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "baomingbianhao")	private String baomingbianhao;	@Column(name = "saishimingcheng")	private String saishimingcheng;	@Column(name = "saishididian")	private String saishididian;	@Column(name = "baomingfei")	private String baomingfei;	@Column(name = "yonghuming")	private String yonghuming;	@Column(name = "xingming")	private String xingming;	@Column(name = "xingbie")	private String xingbie;	@Column(name = "shenfenzheng")	private String shenfenzheng;	@Column(name = "shoujihao")	private String shoujihao;	@Column(name = "zhuangtai")	private String zhuangtai;	@Column(name = "shenhehuifu")	private String shenhehuifu;	@Column(name = "iszf")	private String iszf;	
	@Column(name = "addtime")
	private String addtime;
	@Column(name = "status")
	private String status;
	//yoxuxtupTransiexnt
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	//gextsexttpzidxuan

	//public String getFileIds() {
//		return fileIds;
//	}
//
//	public void setFileIds(String fileIds) {
//		this.fileIds = fileIds;
//	}

	
	public String getBaomingbianhao() {
        return baomingbianhao;
    }
    public void setBaomingbianhao(String baomingbianhao) {
		this.baomingbianhao = baomingbianhao;
    }	public String getSaishimingcheng() {
        return saishimingcheng;
    }
    public void setSaishimingcheng(String saishimingcheng) {
		this.saishimingcheng = saishimingcheng;
    }	public String getSaishididian() {
        return saishididian;
    }
    public void setSaishididian(String saishididian) {
		this.saishididian = saishididian;
    }	public String getBaomingfei() {
        return baomingfei;
    }
    public void setBaomingfei(String baomingfei) {
		this.baomingfei = baomingfei;
    }	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
    }	public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
    }	public String getShenfenzheng() {
        return shenfenzheng;
    }
    public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
    }	public String getShoujihao() {
        return shoujihao;
    }
    public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
    }	public String getZhuangtai() {
        return zhuangtai;
    }
    public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
    }	public String getShenhehuifu() {
        return shenhehuifu;
    }
    public void setShenhehuifu(String shenhehuifu) {
		this.shenhehuifu = shenhehuifu;
    }	public String getIszf() {
        return iszf;
    }
    public void setIszf(String iszf) {
		this.iszf = iszf;
    }	

	public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return this.id;
	}

}