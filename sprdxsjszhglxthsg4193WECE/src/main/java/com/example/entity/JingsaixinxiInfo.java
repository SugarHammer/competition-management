package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "jingsaixinxi_info")
public class JingsaixinxiInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "saishimingcheng")	private String saishimingcheng;	@Column(name = "tupian")	private String tupian;	@Column(name = "saishididian")	private String saishididian;	@Column(name = "baomingfei")	private String baomingfei;	@Column(name = "saishishijian")	private String saishishijian;	@Column(name = "zhuangtai")	private String zhuangtai;	@Column(name = "cansaiyaoqiu")	private String cansaiyaoqiu;	@Column(name = "saishijianjie")	private String saishijianjie;	
	@Column(name = "addtime")
	private String addtime;
	@Column(name = "status")
	private String status;
	@Transient private List<Long> tupianflst;	//yoxuxtupTransiexnt
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public List<Long>  getTupianflst() {
        return tupianflst;
    }
    public void setTupianflst(List<Long> tupianflst) {
		this.tupianflst = tupianflst;
    }

	//public String getFileIds() {
//		return fileIds;
//	}
//
//	public void setFileIds(String fileIds) {
//		this.fileIds = fileIds;
//	}

	
	public String getSaishimingcheng() {
        return saishimingcheng;
    }
    public void setSaishimingcheng(String saishimingcheng) {
		this.saishimingcheng = saishimingcheng;
    }	public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
		this.tupian = tupian;
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
    }	public String getSaishishijian() {
        return saishishijian;
    }
    public void setSaishishijian(String saishishijian) {
		this.saishishijian = saishishijian;
    }	public String getZhuangtai() {
        return zhuangtai;
    }
    public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
    }	public String getCansaiyaoqiu() {
        return cansaiyaoqiu;
    }
    public void setCansaiyaoqiu(String cansaiyaoqiu) {
		this.cansaiyaoqiu = cansaiyaoqiu;
    }	public String getSaishijianjie() {
        return saishijianjie;
    }
    public void setSaishijianjie(String saishijianjie) {
		this.saishijianjie = saishijianjie;
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