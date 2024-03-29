package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "bisaixinxi_info")
public class BisaixinxiInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cansaibianhao")
	private String cansaibianhao;
	@Column(name = "baomingbianhao")
	private String baomingbianhao;
	@Column(name = "saishimingcheng")
	private String saishimingcheng;
	@Column(name = "saishididian")
	private String saishididian;
	@Column(name = "yonghuming")
	private String yonghuming;
	@Column(name = "xingming")
	private String xingming;
	@Column(name = "xingbie")
	private String xingbie;
	@Column(name = "shenfenzheng")
	private String shenfenzheng;
	@Column(name = "shoujihao")
	private String shoujihao;
	@Column(name = "shifouhuomingci")
	private String shifouhuomingci;
	@Column(name = "bisaichengji")
	private String bisaichengji;
	@Column(name = "tianjiaren")
	private String tianjiaren;
	@Column(name = "beizhu")
	private String beizhu;
	
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

	
	public String getCansaibianhao() {
        return cansaibianhao;
    }
    public void setCansaibianhao(String cansaibianhao) {
		this.cansaibianhao = cansaibianhao;
    }
	public String getBaomingbianhao() {
        return baomingbianhao;
    }
    public void setBaomingbianhao(String baomingbianhao) {
		this.baomingbianhao = baomingbianhao;
    }
	public String getSaishimingcheng() {
        return saishimingcheng;
    }
    public void setSaishimingcheng(String saishimingcheng) {
		this.saishimingcheng = saishimingcheng;
    }
	public String getSaishididian() {
        return saishididian;
    }
    public void setSaishididian(String saishididian) {
		this.saishididian = saishididian;
    }
	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
    }
	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
    }
	public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
    }
	public String getShenfenzheng() {
        return shenfenzheng;
    }
    public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
    }
	public String getShoujihao() {
        return shoujihao;
    }
    public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
    }
	public String getShifouhuomingci() {
        return shifouhuomingci;
    }
    public void setShifouhuomingci(String shifouhuomingci) {
		this.shifouhuomingci = shifouhuomingci;
    }
	public String getBisaichengji() {
        return bisaichengji;
    }
    public void setBisaichengji(String bisaichengji) {
		this.bisaichengji = bisaichengji;
    }
	public String getTianjiaren() {
        return tianjiaren;
    }
    public void setTianjiaren(String tianjiaren) {
		this.tianjiaren = tianjiaren;
    }
	public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
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