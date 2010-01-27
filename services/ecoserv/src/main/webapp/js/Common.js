
//Check Google Chrome Framework
function checkBrower() {
	CFInstall
			.check( {
				preventPrompt : true,
				onmissing : function() {
					Ext.Msg
							.show( {
								title : 'Warning',
								msg : '  You are currently using Internet Explorer (IE), which may cause very low performance of the map.<br/>   We recommend you to open the site using other browers (Firefox, Google Chrome).   You may also use IE with Google Chrome Frame installed.<br/>   Would you like to install Google Chrome Frame for your IE browser?',
								buttons : Ext.Msg.OKCANCEL,
								icon : Ext.MessageBox.QUESTION,
								fn : function(b, t, e) {
									if (b.toUpperCase() == 'OK') {
										document.location = 'http://www.google.com/chromeframe';
									}
								}
							});
				}
			});
}
