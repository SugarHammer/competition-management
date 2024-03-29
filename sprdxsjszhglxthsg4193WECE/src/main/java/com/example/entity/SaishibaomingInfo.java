package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "saishibaoming_info")
public class SaishibaomingInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "baomingbianhao")
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
    }
        return saishimingcheng;
    }
    public void setSaishimingcheng(String saishimingcheng) {
		this.saishimingcheng = saishimingcheng;
    }
        return saishididian;
    }
    public void setSaishididian(String saishididian) {
		this.saishididian = saishididian;
    }
        return baomingfei;
    }
    public void setBaomingfei(String baomingfei) {
		this.baomingfei = baomingfei;
    }
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
    }
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
    }
        return xingbie;
    }
    public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
    }
        return shenfenzheng;
    }
    public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
    }
        return shoujihao;
    }
    public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
    }
        return zhuangtai;
    }
    public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
    }
        return shenhehuifu;
    }
    public void setShenhehuifu(String shenhehuifu) {
		this.shenhehuifu = shenhehuifu;
    }
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