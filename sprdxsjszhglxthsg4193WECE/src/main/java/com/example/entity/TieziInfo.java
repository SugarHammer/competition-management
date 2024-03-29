package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "tiezi_info")
public class TieziInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "suozaibankuai")
	private String suozaibankuai;
	@Column(name = "biaoti")
	private String biaoti;
	@Column(name = "neirong")
	private String neirong;
	@Column(name = "leixing")
	private String leixing;
	@Column(name = "faburen")
	private String faburen;
	@Column(name = "huitieshu")
	private String huitieshu;
	@Column(name = "dianzan_d")
	private String dianzan_d;
	@Column(name = "dianzan_c")
	private String dianzan_c;
	
	@Column(name = "addtime")
	private String addtime;
	@Column(name = "status")
	private String status;
	@Column(name = "fid")
	private Long fid;
//	@Column(name = "hts")
//	private Long hts;
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

	
	public String getSuozaibankuai() {
        return suozaibankuai;
    }
    public void setSuozaibankuai(String suozaibankuai) {
		this.suozaibankuai = suozaibankuai;
    }
	public String getBiaoti() {
        return biaoti;
    }
    public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
    }
	public String getNeirong() {
        return neirong;
    }
    public void setNeirong(String neirong) {
		this.neirong = neirong;
    }
	public String getLeixing() {
        return leixing;
    }
    public void setLeixing(String leixing) {
		this.leixing = leixing;
    }
	public String getFaburen() {
        return faburen;
    }
    public void setFaburen(String faburen) {
		this.faburen = faburen;
    }
	public String getHuitieshu() {
        return huitieshu;
    }
    public void setHuitieshu(String huitieshu) {
		this.huitieshu = huitieshu;
    }
	public String getDianzan_d() {
        return dianzan_d;
    }
    public void setDianzan_d(String dianzan_d) {
		this.dianzan_d = dianzan_d;
    }
	public String getDianzan_c() {
        return dianzan_c;
    }
    public void setDianzan_c(String dianzan_c) {
		this.dianzan_c = dianzan_c;
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

	public void setFid(Long fid) {
		this.fid = fid;
	}
	public Long getFid() {
		return this.fid;
	}

//	public void setHts(Long hts) {
//		this.hts = hts;
//	}
//	public Long getHts() {
//		return this.hts;
//	}

}