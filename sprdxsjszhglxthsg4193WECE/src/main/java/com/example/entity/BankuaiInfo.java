package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "bankuai_info")
public class BankuaiInfo extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "bankuaimingcheng")
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
    }
        return jianjie;
    }
    public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
    }
        return banzhu;
    }
    public void setBanzhu(String banzhu) {
		this.banzhu = banzhu;
    }
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