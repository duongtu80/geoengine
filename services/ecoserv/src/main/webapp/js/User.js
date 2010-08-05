main.loginEvent = function() {
	var _form = new Ext.FormPanel( {
		items : [ {
			fieldLabel : 'Username',
			name : 'username',
			xtype : 'textfield'
		}, {
			fieldLabel : 'Password',
			name : 'password',
			inputType : 'password',
			xtype : 'textfield'
		} ],
		bodyStyle : 'padding: 10px 15px 0',
		labelStyle : 'text-align: right;',
		labelAlign : 'right'
	});

	var win = new Ext.Window( {
		title : 'Login',
		layout : 'fit',
		width : 400,
		height : 200,
		closeAction : 'hide',
		plain : true,
		items : _form,
		buttons : [ {
			text : 'Login',
			scope: this,
			handler : function() {
				win.hide();

				var _username = _form.getForm().getValues()['username'];
				var _password = _form.getForm().getValues()['password'];

				var _data = {
					'username' : _username,
					'password' : _password
				};
				this.utils.wait('Login');
				Ext.Ajax.request( {
					url : '_login.do',
					params : {
						'input' : Ext.encode(_data)
					},
					scope : this,
					success : function(result, request) {
						if (this.utils.processException(result, true))
							return;

						var _resp = Ext.decode(result.responseText);
						this.login(_resp.user, _resp.real);
						this.utils.unwait();
					},
					failure : function(result, request) {
						Ext.Msg.alert('Error', result);
					}
				});
			}
		}, {
			text : 'Cancel',
			handler : function() {
				win.hide();
			}
		} ]
	});

	win.show();
	this.utils.wait('Login');
	Ext.Ajax.request( {
		url : '_logout.do',
		scope : this,
		success : function(result, request) {
			if (this.utils.processException(result, true))
				return;

			this.logout();
			this.utils.unwait();
		},
		failure : function(result, request) {
			Ext.Msg.alert('Error', result);
		}
	});
};

main.registerEvent = function() {
	var _form = new Ext.FormPanel( {
		items : [ {
			fieldLabel : 'Real Name',
			name : 'realname',
			xtype : 'textfield'
		}, {
			fieldLabel : 'User Name',
			name : 'username',
			xtype : 'textfield'
		}, {
			fieldLabel : 'Password',
			name : 'password',
			inputType : 'password',
			xtype : 'textfield'
		}, {
			fieldLabel : 'Password Repeat',
			name : 'password2',
			inputType : 'password',
			xtype : 'textfield'
		}, {
			fieldLabel : 'Email',
			name : 'email',
			xtype : 'textfield'
		} ],
		bodyStyle : 'padding: 10px 15px 0',
		labelStyle : 'text-align: right;',
		labelAlign : 'right'
	});

	var win = new Ext.Window( {
		title : 'Register',
		layout : 'fit',
		width : 400,
		height : 230,
		closeAction : 'hide',
		plain : true,
		items : _form,
		buttons : [ {
			text : 'Register',
			scope: this,
			handler : function() {
				var _realname = _form.getForm().getValues()['realname'];
				var _username = _form.getForm().getValues()['username'];
				var _password = _form.getForm().getValues()['password'];
				var _password2 = _form.getForm().getValues()['password2'];
				var _email = _form.getForm().getValues()['email'];

				if (_password != _password2) {
					Ext.Msg.alert('Warning', 'Passwords do not match');
					return;
				}

				var _data = {
					'realname' : _realname,
					'username' : _username,
					'password' : _password,
					'email' : _email
				};
				this.utils.wait('Login');
				Ext.Ajax.request( {
					url : '_register.do',
					params : {
						'input' : Ext.encode(_data)
					},
					scope : this,
					success : function(result, request) {
						if (this.utils.processException(result, true))
							return;

						var _resp = Ext.decode(result.responseText);
						this.login(_resp.user, _resp.real);
						this.utils.unwait();
					},
					failure : function(result, request) {
						Ext.Msg.alert('Error', result);
					}
				});
				win.hide();
			}
		}, {
			text : 'Cancel',
			handler : function() {
				win.hide();
			}
		} ]
	});

	win.show();
	this.utils.wait('Login');
	Ext.Ajax.request( {
		url : '_logout.do',
		scope : this,
		success : function(result, request) {
			if (this.utils.processException(result, true))
				return;

			this.logout();
			this.utils.unwait();
		},
		failure : function(result, request) {
			Ext.Msg.alert('Error', result);
		}
	});
};

main.logoutEvent = function() {
	this.utils.wait('Logout');
	Ext.Ajax.request( {
		url : '_logout.do',
		scope : this,
		success : function(result, request) {
			if (this.utils.processException(result, true))
				return;

			this.logout();
			this.utils.unwait();
		},
		failure : function(result, request) {
			Ext.Msg.alert('Error', result);
		}
	});
};

main.login = function(user, real) {
	if (user == null || user.length == 0)
		return this.logout();

	username = user;
	realname = real;

	Ext.getCmp('usernameText').setText(real + ' (' + user + ') ');
	Ext.getCmp('loginText').setVisible(false);
	Ext.getCmp('registerText').setVisible(false);
	Ext.getCmp('logoutText').setVisible(true);
};

main.logout = function() {
	username = null;

	Ext.getCmp('usernameText').setText('');
	Ext.getCmp('loginText').setVisible(true);
	Ext.getCmp('registerText').setVisible(true);
	Ext.getCmp('logoutText').setVisible(false);
};

main.isLogged = function() {
	return !(username == null || username.length == 0);
}

