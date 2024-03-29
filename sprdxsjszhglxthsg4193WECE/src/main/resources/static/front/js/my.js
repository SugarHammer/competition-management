function personalPage() {
    let user = JSON.parse(localStorage.getItem("user"));
    if (!user) {
        alert('请登录');
    }
	if (user && user.level && user.level === 1) {
		window.location = '/front/accountAdminInfo.html';
	}
	if (user && user.level && user.level === 2) {
		window.location = '/front/accountSellerInfo.html';
	}
	if (user && user.level && user.level === 3) {
		window.location = '/front/accountUserInfo.html';
	}

}

function uuid() {
	return 'xxxxxxxxxxx'.replace(/[xy]/g, function (c) {
		var r = Math.random() * 8 | 0,
			v = c == 'x' ? r : (r & 0x3 | 0x8);
		return v.toString(8);
	});
}
function msg(type, msg) {
	Vue.prototype.$message({
		type: type, // success（成功）、warning（警告）, error(错误)
		message: msg,
		duration: 2000,
		offset: 100,
		center: true
	})
}
function logout() {
    axios.get('/logout').then(res => {
        if (res.data.code === '0') {
            window.location = '/end/page/login.html';
        } else {
            alert(res.data.msg);
        }
    })
}
function logout2() {
    axios.get('/logout').then(res => {
        if (res.data.code === '0') {
            window.parent.location = '/end/page/login.html';
        } else {
            alert(res.data.msg);
        }
    })
}