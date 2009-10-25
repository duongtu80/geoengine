/*
 * 
 * Utility module for error checking and processing checking 
 * 
 * Min Feng 10/17/2009
 * 
*/
function Utils() {
	this.init = function(){
		this.waiting = null;
	};

	// Process exception from Ajax response
	this.processException = function(response, msgbox) {
		if (response.status == 207) {
			if (msgbox == true) {
				var _txt = response.getResponseHeader('error');
				if (_txt == null) {
					_txt = "No error message";
				}

				model.unwait();
				Ext.Msg.show( {
					title : 'Error',
					msg : _txt,
					buttons : Ext.Msg.OK,
					icon : Ext.MessageBox.ERROR
				});
			}
			return true;
		}

		return false;
	};

	this.wait = function(title) {
		this.waiting = Ext.Msg.wait(title + '...');
	};

	this.unwait = function(title) {
		if (this.waiting != null) {
			this.waiting.hide();
			this.waiting = null;
		}
	};
}
