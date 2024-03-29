package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "bankuai_info")
public class BankuaiInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "bankuaimingcheng")	private String bankuaimingcheng;	@Column(name = "jianjie")	private String jianjie;	@Column(name = "banzhu")	private String banzhu;	@Column(name = "yiyoutieshu")	private String yiyoutieshu;	
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

	
	public String getBankuaimingcheng() {
        return bankuaimingcheng;
    }
    public void setBankuaimingcheng(String bankuaimingcheng) {
		this.bankuaimingcheng = bankuaimingcheng;
    }	public String getJianjie() {
        return jianjie;
    }
    public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
    }	public String getBanzhu() {
        return banzhu;
    }
    public void setBanzhu(String banzhu) {
		this.banzhu = banzhu;
    }	public String getYiyoutieshu() {
        return yiyoutieshu;
    }
    public void setYiyoutieshu(String yiyoutieshu) {
		this.yiyoutieshu = yiyoutieshu;
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